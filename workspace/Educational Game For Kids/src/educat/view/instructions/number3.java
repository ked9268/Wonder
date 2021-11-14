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
import educat.controllers.action_buttons.instru_next_3;
import educat.view.Tester;

public class number3 {

	public number3(){
		JFrame frame = Tester.getJFrame();
		ImageIcon image_1 = new ImageIcon("src/educat/pictures/instructions/pentagon.jpg");
		JLabel image = new JLabel(image_1);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		image.setBounds(100,100,150,150);
		panel.add(image);
		ImageIcon image_2 = new ImageIcon("src/educat/pictures/instructions/triangle.jpg ");
		JLabel label_2 = new JLabel(image_2);
		label_2.setBounds(300,100,150,150);
		panel.add(label_2);
		ImageIcon image_3 = new ImageIcon("src/educat/pictures/instructions/square.jpg ");
		JLabel label_3 = new JLabel(image_3);
		label_3.setBounds(500,100,150,150);
		panel.add(label_3);
		ImageIcon image_4 = new ImageIcon("src/educat/pictures/instructions/hexagon.jpg ");
		JLabel label_4 = new JLabel(image_4);
		label_4.setBounds(700,100,150,150);
		panel.add(label_4);
		JTextArea explain = new JTextArea("If the user icon is going to hit\n then move with the mouse or the keyboard ");
		explain.setFont(new Font(explain.getFont().getName(), explain.getFont().getStyle(), 20));
		explain.setForeground(Color.WHITE);
		explain.setBackground(Color.DARK_GRAY);
		explain.setBounds(200,300,550,100);
		panel.add(explain);
		JButton next = new JButton("next");
		action_buttons.instru_next_3 n1 = new action_buttons.instru_next_3();
		next.addActionListener(n1);
		next.setBounds(Tester.getJFrameWidth()-200,400,150,50);
		JButton back = new JButton("back");
		back.setBounds(Tester.getJFrameWidth()-400,400,150,50);
		action_buttons.back_3_2 back_action =  new action_buttons.back_3_2();
		back.addActionListener(back_action);
		panel.add(back);
		panel.add(next);
		
		//JTextArea explain = new JTextArea("This is the User rocket you will use to play the game ");
		//explain.setFont(new Font(explain.getFont().getName(), explain.getFont().getStyle(), 20));
		//explain.setBounds(600,200,250,200);
		//panel.add(explain);
		panel.setLayout(null);
		frame.add(panel);
		Tester.setJPanel(panel);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
