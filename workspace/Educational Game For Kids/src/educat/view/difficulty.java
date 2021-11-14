package educat.view;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import educat.controllers.action_buttons;

public class difficulty extends JPanel {
	
	JFrame frame;
	JPanel panel;
	public JFrame getFrame(){
		return frame;
	}
	public void setFrame(JFrame jf){
		frame = jf;
	}
	public void setPanel(JPanel jp){
		panel = jp;
	}
	public JPanel getPanel(){
		return panel;
	}
	public difficulty(){
		//JFrame fram = Tester.getJFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		int height = Tester.getJFrameHeight()/2;
		JButton hard = new JButton("Hard");
		action_buttons.hard_difficulty hard_action = new action_buttons.hard_difficulty();
		hard.setBounds(0,height,150,50);
		hard.addActionListener(hard_action);
		panel.add(hard);
		JButton medium = new JButton("Medium");
		medium.setBounds(160,height,150,50);
		action_buttons.medium_difficulty medium_action = new action_buttons.medium_difficulty();
		medium.addActionListener(medium_action);
		panel.add(medium);
		JButton easy = new JButton("Easy");
		easy.setBounds(350,height,150,50);
		action_buttons.easy_difficulty easy_action = new action_buttons.easy_difficulty();
		easy.addActionListener(easy_action);
		panel.add(easy);
		Tester.setJPanel(panel);
		setPanel(panel);
		//fram.add(panel);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		difficulty diff = new difficulty();
		frame.add(diff.getPanel());
		frame.setSize(300,300);
		frame.setVisible(true);

	}

}
