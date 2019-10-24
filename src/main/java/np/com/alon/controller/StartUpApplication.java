package np.com.alon.controller;

import np.com.alon.DaoImpl.GradeDaoImpl;
import np.com.alon.DaoImpl.MessageSentStatusDaoImpl;
import np.com.alon.DaoImpl.MessageTemplateDaoImpl;
import np.com.alon.DaoImpl.StudentDaoImpl;
import np.com.alon.dao.GradeDao;
import np.com.alon.dao.MessageSentStatusDao;
import np.com.alon.dao.MessageTemplateDao;
import np.com.alon.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class StartUpApplication extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDao studentDao = new StudentDaoImpl();
        GradeDao gradeDao = new GradeDaoImpl();
        MessageTemplateDao messageTemplateDao = new MessageTemplateDaoImpl();
        MessageSentStatusDao messageSentStatusDao = new MessageSentStatusDaoImpl();
        req.setAttribute("studentCount", studentDao.count());

        HttpSession session = req.getSession(false);


        if (session != null) {
            String loggedInStatus = (String) session.getAttribute("loggedIn");

            if (loggedInStatus != null && loggedInStatus.equalsIgnoreCase("true")) {
                req.setAttribute("studentCount", studentDao.count());
                req.setAttribute("gradeCount", gradeDao.count());
                req.setAttribute("messageTemplateCount", messageTemplateDao.count());
                req.setAttribute("messageSentStatusCount", messageSentStatusDao.count());
                req.getRequestDispatcher("main.jsp").forward(req, resp);

            } else {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
