package educat.model;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

public class userInfo {
	public int passrow; 
	public static String [] column_names = {" First Name", "Last Name", "Age","UserName"
		,"Password"};
	public static String [][] data ={
		{"Example First Name ","Example Last name ","Example Age  ","kaidewright","feather12"},
		{"Example First Name ","Example Last name ","Example Age  ","kaideleft","feather12"},
	};
	public void setPassRow(int c){
		passrow = c;
	}
	public int getPassRow(){
		return passrow;
	}
	public boolean searchForUserName(String c){
		Boolean result = null;
		int row = 0;
		ArrayList array = new ArrayList(); 
		for(int i = 0;i < data.length;i++){
			if(c.equals(data[i][3]) == true){
				result = true;
				row = i;
				break;
			}
			else{
				result = false;
			}
		}
		setPassRow(row);
		return result;
	}
	
	public boolean searchForPassword(String c){
		//System.out.println(data.length);
		int crow = getPassRow();
		Boolean result = null;
		ArrayList array = new ArrayList(); 
			if(c.equals(data[crow][4]) == true){
				result = true;
			}
			else{
				result = false;
			}
		return result;
	}
	public String returnInfo(String user,String pass){
		Boolean us = searchForUserName(user);
		Boolean ps = searchForPassword(pass);
		if(us == true && ps == true){
				System.out.println("correct");
		}
		else {
			//Return password combination is wrong.
			System.out.println("Incorrect combination!");
		}
		return "";
	}
	public static void main(String[] args) {
		try {
			Robot rb = new Robot();
			rb.mouseMove(300,300);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
