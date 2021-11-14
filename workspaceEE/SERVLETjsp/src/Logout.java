import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logout extends HttpServlet {
		public void doGet(HttpServletRequest req, 
				        HttpServletResponse res) {
			HttpSession current=req.getSession();
			current.removeAttribute("user");
			try {
				res.sendRedirect("/SignIn.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
