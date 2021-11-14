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

public class number4 {

	public number4(){
		JFrame frame = Tester.getJFrame();
		ImageIcon image_1 = new ImageIcon("src/educat/pictures/instructions/score.jpg");
		JLabel image = new JLabel(image_1);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		image.setBounds(100,100,350,350);
		panel.add(image);
		JTextArea explain = new JTextArea("While you play this game your score will \n increase");
		explain.setFont(new Font(explain.getFont().getName(), explain.getFont().getStyle(), 20));
		explain.setBounds(600,200,450,200);
		panel.add(explain);
		explain.setForeground(Color.WHITE);
		explain.setBackground(Color.DARK_GRAY);
		JButton sg = new JButton("start game");
		action_buttons.change_difficulty change = new action_buttons.change_difficulty();
		sg.addActionListener(change);
		sg.setBounds(600,400,150,50);
		
		JButton back = new JButton("back");
		back.setBounds(800,400,150,50);
		panel.add(back);panel.add(sg);
		action_buttons.back_4_3 back_action = new action_buttons.back_4_3();
		back.addActionListener(back_action);
		panel.setLayout(null);
		//frame.add(panel);
		Tester.setJPanel(panel);	
	}
}
