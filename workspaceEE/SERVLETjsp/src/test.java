import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws SQLException {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			  String host="mysql.mcscw3.le.ac.uk";
			  String database="kjw42";
			  String username="kjw42";
			  String password="AoL9Aeni";
			  String port ="3306";
			
			 String conn_string="jdbc:mysql://"+host+":"+port+"/"+database;
		      Connection connect = DriverManager.getConnection(conn_string,username,password);
		      
		      pstmt = connect.prepareStatement("SELECT * FROM Classes");
		      rs = pstmt.executeQuery();
		      System.out.println(rs);
	}
}
