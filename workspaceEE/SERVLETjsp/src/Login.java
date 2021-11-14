import java.io.IOException;
import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {

	public void doGet(HttpServletRequest req, 
	        HttpServletResponse res) throws IOException  {
		
		String userEmail=req.getParameter("userEmail");
		String password=req.getParameter("password");
		Account account = new Account(userEmail,password);
		Cookie cookie = new Cookie(userEmail,"value");
		res.addCookie(cookie);
		Cookie[] current = req.getCookies();
		if(current[0] == cookie){
			//cookie confirmation.
			//redirect if cookie is correct.
			res.sendRedirect("/VotingPage.html");
		}
		else{
			//if cookie is wrong align new user with new login credentials.
		}
		
		
	}
}
