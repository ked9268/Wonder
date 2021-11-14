package educat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class startGame {
	//Scene user is greeted with when they press start game but the game hasn't start yet.
	static JPanel panel;
	static JFrame frame;
	static JLabel one;
	static JLabel two;
	static JLabel three;
	static JLabel bg_i;
	static JLabel rocket;
	static JLabel go;
	static int height_roc;
	static int width_roc;
	static JLabel instro;
	
	static int height = Tester.getJFrameHeight()/3;
	static int width = Tester.getJFrameWidth()/2;
	public static void setPanel(JPanel jp){
		panel = jp;
	}
	public static JPanel getPanel(){
		return panel;
	}
	public static JFrame getFrame(){
		return frame;
	}
	public void setFrame(JFrame jf){
		frame = jf;
	}
	public void showOne(){
		one.setFont(new Font(one.getFont().getName(), one.getFont().getStyle(), 100));
	}
	public static void createBG(){
		ImageIcon bg_image = new ImageIcon("src/educat/pictures/NightSky.jpg");
		bg_i = new JLabel(bg_image);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		bg_i.setBounds(0,0,width,height);
	}
	public static JLabel getBG(){
		return bg_i;
	}
	public static void createRoc(){
		ImageIcon rocket_image = new ImageIcon("src/educat/pictures/rocket.jpg");
		Tester.SizeCheck d = new Tester.SizeCheck();
		d.start();
		rocket = new JLabel(rocket_image);
		gameMechanic.bb mouse = new gameMechanic.bb();
		rocket.addMouseListener(mouse);
		setRocHei(Tester.getJFrameHeight()/2);
		setRocWid(Tester.getJFrameWidth()/2);
		rocket.setBounds(getRocWid(),getRocHei(),92,226);
	}
	public static JLabel getRock(){
		return rocket;
	}
	public static int getRocHei(){
		return height_roc;
	}
	public static void setRocHei(int C){
		height_roc = C;
	}
	public static void setRocWid(int C){
		width_roc = C; 
	}
	public static int getRocWid(){
		return width_roc;
	}
	public static void setOne(){
		one = new JLabel("1");
		one.setForeground(Color.WHITE);
		one.setFont(new Font(one.getFont().getName(), one.getFont().getStyle(), 100));
		one.setBounds(width,height,200,200);
	}
	public static JLabel getOne(){
		return one;
	}
	public static void setTwo(){
		two = new JLabel("2");
		two.setForeground(Color.WHITE);
		two.setFont(new Font(one.getFont().getName(), one.getFont().getStyle(), 100));
		two.setBounds(width,height,200,200);
	}
	public static JLabel getTwo(){
		return two;
	}
	public static void setThree(){
		three = new JLabel("3");
		three.setForeground(Color.WHITE);
		three.setFont(new Font(one.getFont().getName(), one.getFont().getStyle(), 100));
		three.setBounds(width,height,200,200);
	}
	public static JLabel getThree(){
		return three;
	}
	public static JLabel getGO(){
		return go;
	}
	public static void setGO(){
		go = new JLabel("GO");
		go.setForeground(Color.WHITE);
		go.setFont(new Font(one.getFont().getName(), one.getFont().getStyle(), 100));
		go.setBounds(width,height,200,200);
	}
	public static void setInstro(){
		instro = new JLabel("Click the Rocket to Start!");
		instro.setForeground(Color.WHITE);
		instro.setFont(new Font(instro.getFont().getName(), instro.getFont().getStyle(), 20));
		instro.setBounds(width,height,250,100);
	}
	public static JLabel getInstro(){
		return instro;
	}
	public startGame(){
		JFrame frame = getFrame();
		setFrame(frame);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		createBG();
		JLabel c = getBG();
		createRoc();
		JLabel roc = getRock();
		gameMechanic.bb mouse = new gameMechanic.bb();
		setInstro();
		JLabel instro = getInstro();
		panel.addMouseListener(mouse);
		panel.add(instro);
		panel.add(roc);
		panel.add(c);
		Tester.setJPanel(panel);
		setPanel(panel);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		startGame sg = new startGame();
		sg.setFrame(frame);
		JPanel pane = startGame.getPanel();
		frame.add(pane);
		frame.setSize(300,300);
		frame.setVisible(true);

	}

}
