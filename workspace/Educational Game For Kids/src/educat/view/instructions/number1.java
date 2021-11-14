package educat.view.instructions;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import educat.controllers.action_buttons;
import educat.view.Tester;

public class number1 {
		// If Else 
		// While loop 
		// Math plus minus with the space debris
		// IF you stay in the game the game will CONTINUE but IF you lose the game will BREAK!
		// Call variable in game a boolean and cause this clause to trigger it^^^
		// True means you stay in the game and false means you break;
		/* When you finish your final score will be saved to an Object! A Java object is an ordinary object 
		 * which will hold your score!
		 */
		// If you spot any keywords within the game that are Java keywords, move into them! You'll get extra points.
		// Although moving into them will cause you to lose some points!
	public number1(){
		JFrame frame = Tester.getJFrame();
		ImageIcon image_1 = new ImageIcon("src/educat/pictures/rocket.jpg");
		JLabel image = new JLabel(image_1);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		image.setBounds(100,100,350,250);
		panel.add(image);
		JTextArea explain = new JTextArea("This is the User rocket you will use to play the game ");
		explain.setFont(new Font(explain.getFont().getName(), explain.getFont().getStyle(), 20));
		explain.setForeground(Color.WHITE);
		explain.setBackground(Color.DARK_GRAY);
		explain.setBounds(600,200,550,200);
		panel.add(explain);
		JButton next = new JButton("next");
		action_buttons.instru_next_1 n1 = new action_buttons.instru_next_1();
		next.addActionListener(n1);
		next.setBounds(600,400,150,50);
		
		JButton start = new JButton("Start menu");
		action_buttons.mainmenu_from_finishScreen back_to_mainmenu = new action_buttons.mainmenu_from_finishScreen();
		start.addActionListener(back_to_mainmenu);
		start.setBounds(800,400,150,50);
		panel.add(start);
		panel.add(next);
		panel.setLayout(null);
		//frame.add(panel);
		Tester.setJPanel(panel);	
	}
}
