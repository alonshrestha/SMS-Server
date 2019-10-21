package np.com.alon.controller;

import np.com.alon.DaoImpl.GradeDaoImpl;
import np.com.alon.DaoImpl.MessageTemplateDaoImpl;
import np.com.alon.DaoImpl.StudentDaoImpl;
import np.com.alon.dao.GradeDao;
import np.com.alon.dao.MessageTemplateDao;
import np.com.alon.dao.StudentDao;
import np.com.alon.enumlist.HttpRequestList;
import np.com.alon.model.MessageTemplate;
import np.com.alon.model.Student;
import np.com.alon.smss.Sms1Sender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/mmm")
public class MessageSenderController extends HttpServlet {
GradeDao gradeDao = new GradeDaoImpl();
StudentDao studentDao=new StudentDaoImpl();
MessageTemplateDao messageTemplateDao =new MessageTemplateDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if(action.equalsIgnoreCase(HttpRequestList.DIRECT_MESSAGE.toString())){
            req.getRequestDispatcher("sendMessage/index.jsp").forward(req,resp);

        }else if(action.equalsIgnoreCase(HttpRequestList.MESSAGE_FROM_TEMPLATE.toString())){
            req.setAttribute("grade", gradeDao.findAll());
            req.setAttribute("messageTemplate", messageTemplateDao.findAll());
            req.getRequestDispatcher("sendMessage/messageFromTemplate.jsp")
                    .forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        Sms1Sender smsSender = new Sms1Sender();

        if(action.equalsIgnoreCase(HttpRequestList.DIRECT_MESSAGE.toString())){
            System.out.println("smsSender = " + smsSender);
            try {
                smsSender.doIt(
                        req.getParameter("phoneNumber"),
                        req.getParameter("messageBody")
                );
                req.getRequestDispatcher("sendMessage/index.jsp").forward(req,resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(action.equalsIgnoreCase(HttpRequestList.MESSAGE_FROM_TEMPLATE.toString())){

            String grade = req.getParameter("grade");
            String messageTemplateId = req.getParameter("messageTemplate");
            MessageTemplate messageTemplate = messageTemplateDao.findById(Integer.parseInt(messageTemplateId));
            System.out.println("grade = " + grade);
            List<Student> students = studentDao.findByGrade(Integer.parseInt(grade));
            List<String> phoneNumberList = new ArrayList<String>();
            for(Student student: students){
                phoneNumberList.add(student.getParentPhoneNumber());
            }

            try {
                smsSender.sendMultipleMessage(phoneNumberList,messageTemplate.getMessageBody());
            } catch (Exception e) {
                e.printStackTrace();
            }
            req.getRequestDispatcher("sendMessage/messageFromTemplate.jsp").forward(req,resp);
        }

    }
}
