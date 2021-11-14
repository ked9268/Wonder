package educat.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import educat.controllers.action_buttons;
import educat.view.gameMechanic;

public class finishScreen {
	// Finish screen when user finishes game and is displayed with options to play again?
	static JFrame jf;
	JPanel jp;
	public void setJFrame(JFrame jf){
		this.jf = jf;
	}
	public JFrame getJFrame(){
		return jf;
	}
	public void setJPanel (JPanel jp){
		this.jp = jp;
	}
	public JPanel getJPanel(){
		return jp;
	}
	finishScreen(){
		JFrame frame = getJFrame();
		JPanel pane = new JPanel();
		pane.setBackground(Color.DARK_GRAY);
		int width = Tester.getJFrameWidth()/2;
		pane.setLayout(null);
		//
		action_buttons.save_info save_action = new action_buttons.save_info();
		JButton save = new JButton("Save");
		save.addActionListener(save_action);
		save.setBounds(width,0,100,30);
		//
		JButton play_again = new JButton("Play Again");
		action_buttons.startgame_from_instruct start_again = new action_buttons.startgame_from_instruct(); 
		play_again.addActionListener(start_again);
		play_again.setBounds(width,200,100,30);
		//Change difficulty and play again!
		JButton play_again_change_settings = new JButton("Change Difficulty.");
		play_again_change_settings.setBounds(width,400,100,30);
		action_buttons.change_difficulty change = new action_buttons.change_difficulty();
		play_again_change_settings.addActionListener(change);
		//
		action_buttons.mainmenu_from_finishScreen back_to_mainmenu = new action_buttons.mainmenu_from_finishScreen();
		JButton return_home = new JButton("Main Menu");
		return_home.addActionListener(back_to_mainmenu);
		return_home.setBounds(width,600,100,30);
		JLabel c = new JLabel("FinalScore! " +(Double.toString(MainG.getFinalScore())));
		//gameMechanic.clickRocketToStart action = new gameMechanic.clickRocketToStart();
		//c.addMouseListener(action);
		c.setBounds(width+50,50,1000,30);
		c.setFont(new Font(c.getFont().getName(), c.getFont().getStyle(), 20));
		c.setForeground(Color.WHITE);
		pane.add(c);
		pane.add(return_home);
		pane.add(play_again_change_settings);
		pane.add(play_again);
		pane.add(save);
		Tester.setJPanel(pane);
		setJPanel(pane);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		finishScreen fs =  new finishScreen();
		JPanel pane = fs.getJPanel();
		frame.add(pane);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}
