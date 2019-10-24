package np.com.alon.controller;

import np.com.alon.DaoImpl.ConnectionPortDaoImpl;
import np.com.alon.dao.ConnectionPortDao;
import np.com.alon.enumlist.HttpRequestList;
import np.com.alon.model.ConnectionPort;
import np.com.alon.smss.Sms1Sender;
import org.smslib.GatewayException;
import org.smslib.SMSLibException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/connectionPorts")
public class ConnectionPortController  extends HttpServlet {

    ConnectionPortDao connectionPortDao = new ConnectionPortDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


            String action = req.getParameter("action");
            if(action.equalsIgnoreCase(HttpRequestList.ALL.toString())){
                ConnectionPort connectionPort = connectionPortDao.findById(1);
                System.out.println("connectionPort = " + connectionPort);
                req.setAttribute("connectionPort",connectionPort);
                req.getRequestDispatcher("connectionPort/index.jsp")
                        .forward(req,resp);
            }else if(action.equalsIgnoreCase(HttpRequestList.UPDATE.toString())){
                req.setAttribute("connectionPort",connectionPortDao.findById(1));
                req.getRequestDispatcher("connectionPort/updatePort.jsp").forward(req,resp);
            }else if(action.equalsIgnoreCase(HttpRequestList.ADD.toString())){
                req.getRequestDispatcher("connectionPort/addPort.jsp").forward(req,resp);
            }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String action = req.getParameter("action");
        if(action.equalsIgnoreCase(HttpRequestList.ADD.toString())){
            ConnectionPort connectionPort = new ConnectionPort();
            connectionPort.setPortNumber(req.getParameter("portNumber"));
            connectionPort.setByteLimit(req.getParameter("portLimit"));
            connectionPortDao.add(connectionPort);
        }else if(action.equalsIgnoreCase(HttpRequestList.UPDATE.toString())){
            ConnectionPort connectionPort = new ConnectionPort();
            connectionPort.setPortNumber(req.getParameter("portNumber"));
            connectionPort.setByteLimit(req.getParameter("byteLimit"));
            connectionPort.setId(Integer.parseInt(req.getParameter("id")));
            connectionPortDao.update(connectionPort);
        }

        ConnectionPort connectionPort = connectionPortDao.findById(1);
        req.setAttribute("connectionPort", connectionPort);
        req.getRequestDispatcher("connectionPort/index.jsp").forward(req,resp);
    }
}
