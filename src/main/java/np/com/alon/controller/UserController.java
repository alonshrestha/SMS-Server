package np.com.alon.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/loginCheck")
public class UserController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }else {
        req.setAttribute("errorMessage", true);
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }


    }
}
