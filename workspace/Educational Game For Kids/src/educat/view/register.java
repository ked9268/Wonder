package educat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import educat.model.createNewUser;

public class register implements ActionListener {
	// Event handling for class.
	static JPanel jp;
	static JTextField pass,user;
	public void setJPanel(JPanel jp){
		jp.setBackground(Color.BLUE);
		this.jp = jp;
	}
	public static JPanel getJPanel(){
		return jp;
	}
	public static void setFirstNameField(JTextField jt){
		pass = jt;
	}
	public static JTextField getFirstNameField(){
		return pass;
	}
	public static void setLastNameField(JTextField jf){
		user = jf;
	}
	public static JTextField getLastNameField(){
		return user;
	}
	public void createPane(){
		JPanel pane = new JPanel();
		//Create JTextField to take first name of user.
		JTextField first_name = new JTextField("First Name");
		first_name.setBounds(100,100,70,70);
		setFirstNameField(first_name);
		//Create JTextField to take last name of user.
		JTextField last_name = new JTextField("Last Name");
		last_name.setBounds(150,150,100,70);
		setLastNameField(last_name);
		//Create register button to input information to server for account creation.
		JButton register = new JButton("Register");
		register.setBounds(200,200,100,70); 
		register.addActionListener(this);
		//Back to Login feature.
		JButton back_to_login = new JButton("Back to Log In");
		back_to_login.setBounds(650,450,150,150);
		//Add action Listener to complete this button.
		//Back to Menu to cancel registration completely.
		JButton back_to_menu = new JButton("Back to Menu");
		//Add action Listener with Panels all set centrally to complete this  button.
		back_to_menu.setBounds(450,450,150,150);
		setJPanel(pane);
		pane.add(back_to_menu);
		pane.add(back_to_login);
		pane.add(register);
		pane.add(first_name);
		pane.add(last_name);
		pane.setLayout(null);
	}
	public register(){
		createPane();
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		register rg = new register();
		JPanel current = rg.getJPanel();
		frame.add(current);
		frame.setSize(300,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// Set up and ready to be sent to model classes.
		createNewUser c = new createNewUser();
		JTextField fn = getFirstNameField();
		c.receiveUserName(fn.getText());
		JTextField ln = getLastNameField();
		c.receivePassword(ln.getText());
	}

}
