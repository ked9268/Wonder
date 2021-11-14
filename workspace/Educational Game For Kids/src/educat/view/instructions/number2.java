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

public class number2 {

	public number2(){
		JFrame frame = Tester.getJFrame();
		ImageIcon image_1 = new ImageIcon("src/educat/pictures/instructions/move.jpg");
		JLabel image = new JLabel(image_1);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		image.setBounds(100,100,350,350);
		panel.add(image);
		JTextArea explain = new JTextArea("To move the game ");
		explain.setFont(new Font(explain.getFont().getName(), explain.getFont().getStyle(), 20));
		explain.setForeground(Color.WHITE);
		explain.setBackground(Color.DARK_GRAY);
		explain.setBounds(600,200,550,200);
		panel.add(explain);
		JButton next = new JButton("next");
		action_buttons.instru_next_2 n1 = new action_buttons.instru_next_2();
		next.addActionListener(n1);
		next.setBounds(600,400,150,50);
		JButton back = new JButton("back");
		action_buttons.back_2_1 back_action =  new action_buttons.back_2_1();
		back.addActionListener(back_action);
		back.setBounds(800,400,150,50);
		
		panel.add(back);
		panel.add(next);
		panel.setLayout(null);
		frame.add(panel);
		Tester.setJPanel(panel);
	}
}
