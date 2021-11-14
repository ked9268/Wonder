package educat.view.instructions;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import educat.controllers.action_buttons;
import educat.view.Tester;

public class skip {

	static JFrame frame;
	static JPanel panel;
	//Skip the instructions and go straight to the game.
	//Two buttons
	//One to the game
	//And one to run through the full instructions.
	public static void setFrame(JFrame fram){
		frame = fram;
	}
	public JFrame getFrame(){
		return frame;
	}
	public static JPanel getPanel(){
		return panel;
	}
	public void setPanel(JPanel pane){
		panel = pane;
	}
	public skip(){
		JFrame frame = Tester.getJFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		int height = Tester.getJFrameHeight()/2;
		JButton to_instructions = new JButton("Instructions");
		to_instructions.setBounds(0,height,150,50);
		//Add action listeners.
		action_buttons.instruct_from_startmenu instruct_button = new action_buttons.instruct_from_startmenu();
		to_instructions.addActionListener(instruct_button);
		JButton to_full_game = new JButton("Start Game");
		to_full_game.setBounds(160,height,150,50);
		//Add action listeners.
		action_buttons.change_difficulty change = new action_buttons.change_difficulty();
		to_full_game.addActionListener(change);
		//One set panelmethod for the whole program?
		JButton back_button = new JButton("Back to Main Menu");
		action_buttons.mainmenu_from_finishScreen back_to_mainmenu = new action_buttons.mainmenu_from_finishScreen();
		back_button.addActionListener(back_to_mainmenu);
		back_button.setBounds(350,height,150,50);
		panel.add(back_button);
		panel.add(to_instructions);
		panel.add(to_full_game);
		//frame.add(panel);
		Tester.setJPanel(panel);
		setPanel(panel);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		setFrame(frame);
		String var = "Hello World!";
		skip fr = new skip();
		JPanel panel = fr.getPanel();
		frame.add(panel);
		frame.setSize(300,300);
		Scanner scanner = new Scanner(System.in);
		String c = scanner.nextLine();
		System.out.println(c);
		frame.setVisible(true);
	}

}
