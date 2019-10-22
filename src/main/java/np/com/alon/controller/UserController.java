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

@WebServlet(urlPatterns = "/loginCheck")
public class UserController extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.equals("admin") && password.equals("admin")) {
            HttpSession session = req.getSession();
            session.setAttribute("loggedIn", "true");
            req.setAttribute("studentCount", studentDao.count());
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMessage", true);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }


    }
}
