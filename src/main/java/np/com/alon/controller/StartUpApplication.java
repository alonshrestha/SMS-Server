package np.com.alon.controller;

import np.com.alon.DaoImpl.StudentDaoImpl;
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
        System.out.println("Hello");
        StudentDao studentDao = new StudentDaoImpl();
        req.setAttribute("studentCount", studentDao.count());
        HttpSession session = req.getSession(false);
        System.out.println("session = " + session);

        if (session != null) {
            String loggedInStatus = (String) session.getAttribute("loggedIn");

            if (loggedInStatus != null && loggedInStatus.equalsIgnoreCase("true")) {
                System.out.println("Hello");
                req.setAttribute("studentCount", studentDao.count());
                req.getRequestDispatcher("main.jsp").forward(req, resp);
            } else {
                System.out.println("saD");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
