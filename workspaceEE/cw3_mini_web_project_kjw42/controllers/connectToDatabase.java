import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectToDatabase {

     public Connection getConnection() throws SQLException {
      String host="mysql.mcscw3.le.ac.uk";
   	  String database="kjw42";
   	  String username="kjw42";
   	  String password="AoL9Aeni";
   	  String port ="3306";
   	
   	 String conn_string="jdbc:mysql://"+host+":"+port+"/"+database;
        Connection connect = DriverManager.getConnection(conn_string,username,password);
        return connect;
    	 
     }
     
}
