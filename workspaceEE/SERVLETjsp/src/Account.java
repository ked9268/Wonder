
public class Account {
	
	String userEmail;
	String password;
	String fullname;
	String constint;
	String sninumber;
	String vote;
	public String getEmail() {
		return userEmail;
	}
	public void setName(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName(){
		return fullname;
	}
	public void setFullName(String fullname){
		this.fullname = fullname;
	}
	public String getConstint(){
		return constint;
	}
	public void setConstint(String constint){
		this.constint = constint;
	}
	public String getSNI(){
		return sninumber;
	}
	public void setSNI(String sninumber){
		this.sninumber = sninumber;
	}
	public Account(String userEmail,String password) {
		this.userEmail = userEmail;
		this.password = password;
	}
	public String getVote(){
		return vote;
	}
	public void setVote(String Vote){
		this.vote = Vote;
	}
}
