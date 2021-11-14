package educat.model;
public class receiveLoginDetails extends userInfo {
		//receiveLoginDetails from log in Page and search Database for information.
	String username	= "";
	String password = "";
	public void receiveUserName(String s){
			username = s;
		}
	public void receivePasswordField(String s){
			password = s;	
		}
}
