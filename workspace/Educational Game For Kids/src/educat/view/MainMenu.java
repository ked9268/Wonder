package educat.view;

import java.awt.Color;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import educat.controllers.action_buttons;

public class MainMenu {
	// The user will be greeted to this page once the Desktop Application loads completely.
	// Will send variables that run generally through the game to the Tester class 
	// The Tester class is the main handling class and loads up the game for use.
	static JPanel jp;
	static JFrame jf;
	Color bg_color = Color.DARK_GRAY;
	JButton button;
	int int_width = 0;
	int int_height = 0;
	JButton menu,startgame,log_in,leaderboard;
	public void setPanel(JPanel jp){
		this.jp = jp;
	}
	public static JPanel getPanel(){
		return jp;
	}
	public static JFrame getJFrame(){
		return jf;
	}
	public void setJFrame(JFrame jf){
		this.jf = jf;
	}
	public void createPanel(){
		JPanel panel = new JPanel();
		panel.setBackground(bg_color);
		Tester.setJPanel(panel);
		this.setPanel(panel);
	}
	//Creates a random number. 
	public String randomVar(){
		Random random = new Random();
		String c = Integer.toString(random.nextInt(100));
		return c;
	}
	// Adds a Jbutton and an associated Action Event through addEvent method from action_buttons class.
	public JButton addJButton(String c){
		button = new JButton(c);
		button.setActionCommand(c);
		addEvent(button);
		return button;
	}
	//Adds event actions to a JButton.
	public static void addEvent(JButton b){
		if (b.getActionCommand() == "Start Game"){
			action_buttons.action_startgame_mm sg = new action_buttons.action_startgame_mm();
			b.addActionListener(sg);
		}
		else if (b.getActionCommand() == "Menu"){
			action_buttons.action_menu_mm menu = new action_buttons.action_menu_mm();
			b.addActionListener(menu);
		}
		else if (b.getActionCommand() == "Leaderboard") {
			action_buttons.action_leaderboard_mm lb = new action_buttons.action_leaderboard_mm();
			b.addActionListener(lb);
		}
		else if (b.getActionCommand() == "Log In") {
			action_buttons.action_log_in_mm lg = new action_buttons.action_log_in_mm();
			b.addActionListener(lg);
		}
		else if (b.getActionCommand() == "Back to Menu.") {
			action_buttons.action_back_to_menu_lg bm = new action_buttons.action_back_to_menu_lg();
			b.addActionListener(bm);
		}
	}
	// Main Menu constructor class generates the scene.
	public MainMenu(){
		createPanel();
		JFrame frame = Tester.getJFrame();
		int height = Tester.getJFrameHeight()/2;
		int width = Tester.getJFrameWidth()-200;
		setJFrame(frame);
		JPanel panel = getPanel();
		panel.setLayout(null);
		menu = addJButton("Menu");
		menu.setBounds(width-1100,height,150,50);
		startgame = addJButton("Start Game");
		startgame.setBounds(width-800,height,150,50);
		leaderboard = addJButton("Leaderboard");
		leaderboard.setBounds(width-500,height,150,50);
		log_in = addJButton("Log In");
		log_in.setBounds(width-200,height,150,50);
		JLabel title = new JLabel("Educational Game for Kids");
		title.setForeground(Color.WHITE);
		title.setBounds(width/20 ,height/4,800,500);
		title.setFont(title.getFont().deriveFont(40f));
		panel.add(title);
		panel.add(startgame);
		panel.add(menu);
		panel.add(leaderboard);
		panel.add(log_in);
		Tester.setJPanel(panel);
	}
	public static void main(String[] args){
		JFrame frame = new JFrame();
		MainMenu mm = new MainMenu();
		mm.setJFrame(frame);
		JPanel jp = mm.getPanel();
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.add(jp);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

