import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Vote extends HttpServlet {

		private static Connection connect = null;
		private static String host="mysql.mcscw3.le.ac.uk";
		private static String database="kjw42";
		private static String username="kjw42";
		private static String password="password";
		public static Connection getConnection(){
				if(connect ==null){
					try{
						Class.forName("com.mysql.jdbc.Driver");
						String conn_string="jdbc:mysql://"+host+"/"+database;
						Connection connect = DriverManager.getConnection(conn_string,username,password);
						return connect;
					}catch(Exception ex){
						return null;
					
					}
				}else{
					return connect;
				}
			}
	  
		public void doGet(HttpServletRequest req, 
					HttpServletResponse res) throws IOException  {
			HttpSession current = req.getSession();
			Object c = current.getAttribute("Account");
			Cookie[] cookie = req.getCookies();
			Account account;
			String constituency=req.getParameter("constituency");
			if(constituency == "YellowParty"){
				account.setVote(constituency);
			}
			else if (constituency == "RedParty"){
				account.setVote(constituency);
			}
			else if (constituency == "BlueParty"){
				account.setVote(constituency);
			}
			else{
				account.setVote(constituency);
			}
		}
	}

