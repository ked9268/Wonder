package educat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import educat.view.MainG.HandlerClass;
import educat.view.Tester.SizeCheck;
public class newGame extends JPanel implements Runnable,ActionListener {

	JFrame jf;
	static JPanel jp;
	Timer t = new Timer(500, this);
	int height = 85;
	double ratio_height = 0;
	int width = 110;
	double ratio_width = 0;
	public void setJFrame(JFrame jf){
		this.jf=jf;
	}
	public static JFrame getJFrame(){
		return MainMenu.jf;
	}
	public void setPanel(JPanel jp){
		this.jp = jp;
	}
	public static JPanel getPanel(){
		return jp;
	}
	public void paint(Graphics g){
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		newGame ng = new newGame();
		frame.add(ng);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	@Override
	public void run() {
		JPanel p = Tester.getJPanel();
		JFrame frame = Tester.getJFrame();
		frame.remove(p);
		System.out.println("Game ready!");
		HandlerClass hc = new HandlerClass();
		if(hc.getX() != 500){
			hc.setX(500);
		}
		if(hc.getY() != 500){
			hc.setY(500);
		}
		MainG mg = new MainG();
		mg.resetClassComponents();
		frame.add(mg);
		frame.repaint();
		frame.revalidate();
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}
