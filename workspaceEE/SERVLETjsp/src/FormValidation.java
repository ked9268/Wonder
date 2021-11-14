import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class FormValidation extends HttpServlet {

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
					//ex.printStackTrace();
				}
			}else{
				return connect;
			}
		}
	public void doPost(HttpServletRequest req, 
	        HttpServletResponse res) {
		String sni_number = req.getParameter("sniNumber");
		String [] sninumber = {"B7F6EM2Y","OXFG75MZ","Q7OW5WWM","7XP02HJ3","FWM4HQEQ","R824O2NZ","JTP70XGU","P8AO57RS","S3ATWJUZ","4M6YFNAC","RR9E1MBQ","DABSP97S","XIO0FT40","Z4PHBVY9","G9H3FM8G","4817YN1C","70EV6SC4","AUTIHS8I","72GQU9ZK","P4YHAJUX"};
		Connection connect = getConnection();
		String userEmail=req.getParameter("userEmail");
		String sniNumber=req.getParameter("sniNumber");
		String sql="SELECT * from SNI WHERE Used='1'";
		String sq2 = "SELECT * from Voter";
		HttpSession current = req.getSession();
		
		//sniNumber exists.
		for(int i=0; i == sninumber.length;i++){
			//The SNI entered by the voter does not match the record in the database.
			if(sninumber[i] == sni_number){
				try {
					PreparedStatement pstmt = connect.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery();
					String compare = rs.getString(1);
					//Another voter already used the provided SNI.
					if(compare == sniNumber){
						try {
							//Email address is associated with another account
							PreparedStatement error_3 = connect.prepareStatement(sq2);
							ResultSet rs_3 = error_3.executeQuery();
							String compare_2 = rs_3.getString(0);
							while(rs_3.next() == true){
								if(userEmail == compare){
									//Account set.
									String password = req.getParameter("password");
									String constint = req.getParameter("constint");
									String fullname = req.getParameter("fullname");
								Account account = new Account(userEmail,password);
								account.setPassword(password);
								account.setConstint(constint);
								account.setFullName(fullname);
								current.setAttribute("User", account);
								
								}
								else{
									rs_3.next();
									compare = rs_3.getString(0);
								}
							}
							if(rs_3.next()== false){
								//Print error Page.
								res.sendRedirect("/error.html");
							}
						} catch (SQLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					else{
						//print error message.
						res.sendRedirect("/error.html");
					}
				
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else{
				if(i == sninumber.length){
					//Print error page. 
					try {
						res.sendRedirect("/error.html");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				i = i+1;
			}
		}
	}
}
