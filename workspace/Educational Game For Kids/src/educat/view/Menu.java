package educat.view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import educat.controllers.action_buttons;

public class Menu {
	/*Holds the menu options which will hold 
	 * auxillary features to help and customise the experience for the user.
	*/
	 static JPanel jp;

	public void setJPanel(JPanel jp){
		jp.setBackground(Color.BLUE);
		this.jp = jp;
	}
	public static JPanel getJPanel(){
		return jp;
	}
	public Menu (){
		JPanel pane = new JPanel();
		JButton back = new JButton("Back to Menus");
		action_buttons.action_back_to_menu_mm ab = new action_buttons.action_back_to_menu_mm();
		back.addActionListener(ab);
		pane.add(back);
		setJPanel(pane);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		Menu m = new Menu();
		frame.add(m.getJPanel());
		frame.setSize(300,300);
		frame.setVisible(true);
	}

}
