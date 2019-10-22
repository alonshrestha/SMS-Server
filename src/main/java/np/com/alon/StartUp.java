package np.com.alon;

import np.com.alon.smss.Sms1Sender;
import org.smslib.GatewayException;
import org.smslib.SMSLibException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class StartUp extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message","from Control");
        System.out.println("req = " + req);
        req.getRequestDispatcher("login.jsp").forward(req,resp);

    }
}
