package automation;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//Loads a transparent JFRame to set coordinates of program 
//Also detects the coordinates of the button click when the program is running.
public class screenCoord implements Runnable,MouseListener,KeyListener {
	public static Robot rb;
	static int locationX = 0;
	static int locationY = 0;
	static JFrame frame;
	public void setLocationX(int c){
		locationX = c;
	}
	public void setLocationY(int c){
		locationY = c;
	}
	public static int getLocationX(){
		return locationX;
	}
	public static int getLocationY(){
		return locationY;
	}
	public void run() {
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		frame.addMouseListener(this);
		frame.addKeyListener(this);
		frame.setUndecorated(true);
		frame.setSize(width,height-100);
		frame.setOpacity(0.55f);
		frame.setVisible(true);
	}
	public void mouseClicked(MouseEvent e) {
		setLocationX(e.getX());
		System.out.println("X:"+getLocationX());
		setLocationY(e.getY());
		System.out.println("Y:"+getLocationY());
		JOptionPane.showMessageDialog(frame,"Screen coordinate for the point selected was: "+"X: "+screenCoord.getLocationX() +" Y: "+screenCoord.getLocationY() );
		
	}
	public static void main(String[] args) {
		screenCoord sc = new screenCoord();
		Thread run = new Thread(sc);
		run.start();
	}
	/*
	 * UNNEEDED METHODS.
	 * */
	public void mouseEntered(MouseEvent e) {	
	}
	public void mouseExited(MouseEvent e) {	
	}
	public void mousePressed(MouseEvent e) {	
	}
	public void mouseReleased(MouseEvent e) {	
	}
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());	
	}
	public void keyReleased(KeyEvent e) {	
	}
	public void keyTyped(KeyEvent e) {
	}
}
