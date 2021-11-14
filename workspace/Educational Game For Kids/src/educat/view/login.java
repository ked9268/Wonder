package educat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import educat.controllers.action_buttons;
import educat.model.receiveLoginDetails;

public class login implements ActionListener {
	//Holds the login to the database so the user can access their personalized settings.
	static JPanel jp;
	JTextField us,ps;
	JButton jb,rb;
	public void setUserField(JTextField us){
		this.us = us;
	}
	public JTextField getUserField(){
		return us;
	}
	public void setPasswordField(JTextField ps){
		this.ps = ps;
	}
	public JTextField getPasswordField(){
		return ps; 
	}
	public void setLogInButton(JButton jb){
		this.jb = jb;
	}
	public JButton getLogInButton(){
		return jb;
	}
	public void setRegisterButton(JButton jb){
		this.jb = rb;
	}
	public JButton getRegisterButton(){
		return rb;
	}
	public void createPane(){
		JPanel pane = new JPanel();
		// Username JTextField holds the information the user has to input to log in to the server.
		JTextField username = new JTextField("Enter Name");
		username.setBounds(20,20,150,30);
		// Password JTextField holds the associated password to log into the server.
		JTextField password = new JTextField("Password");
		password.setBounds(175,20,150,30);
		// log in button sends information to controller classes for log in to the server
		JButton log_in_action = new JButton("Log In");
		log_in_action.setBounds(100,100,70,70);
		log_in_action.addActionListener(this);
		// Register form JButton loads up the register form for new users.
		JButton register_form = new JButton("Register");
		register_form.setBounds(150,150,100,70);
		action_buttons.go_to_register_form rf = new action_buttons.go_to_register_form();
		register_form.addActionListener(rf);
		// Back button returns the end user to the main menu.
		JButton back_button = new JButton("Back to Menu.");
		MainMenu.addEvent(back_button);
		back_button.setBounds(175,80,120,50);
		//JLabel to communicate results from the server
		//Set Objects as class variables
		setPasswordField(password);
		setUserField(username);
		setJPanel(pane);
		// Add objects to the class pane.
		pane.add(username);
		pane.add(password);
		pane.add(log_in_action);
		pane.add(register_form);
		pane.add(back_button);
		pane.setLayout(null);
	}
	public void setJPanel(JPanel jp){
		jp.setBackground(Color.BLUE);
		this.jp = jp;
	}
	public static JPanel getJPanel(){
		return jp;
	}
	public login(){
		createPane();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		login log_in = new login();
		JPanel Panel = log_in.getJPanel();
		frame.add(Panel);
		frame.setVisible(true);
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// Set up ready to be sent to the server.
		receiveLoginDetails c = new receiveLoginDetails();
		JTextField user = getUserField();
		c.receiveUserName(user.getText());
		JTextField pass = getPasswordField();
		c.receivePasswordField(pass.getText());	
	}

}
