package automation;

import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class WakeMouse implements Runnable {
	private JFrame frame;
	boolean canBeWoke = false;
	static ArrayList<Integer> mouseCoordsX = new ArrayList<Integer>();
	static ArrayList<Integer> mouseCoordsY = new ArrayList<Integer>();
	static int followX = 0;
	static int followY = 0;
	public void run(){
		frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();
		frame.setUndecorated(true);
		frame.setSize(width,height-100);
		frame.setOpacity(0.55f);
		frame.setVisible(true);
	}
	public static int getX(){
		return MouseInfo.getPointerInfo().getLocation().x;
	}
	public static int getY(){
		return MouseInfo.getPointerInfo().getLocation().y;
		
	}
	public static void addToCoord(int x,int y){
		int placeX = mouseCoordsX.size();
		int placeY = mouseCoordsY.size();
		if(placeX <= 14 && placeY <= 14){
			mouseCoordsX.add(x);
			mouseCoordsY.add(y);
		}
		if(placeX > 14 && placeY > 14){	
				mouseCoordsX.remove(followX);
				mouseCoordsX.add(followX,x);
				followX++;
				if(followX > 14){
					followX = 0;
				}
				mouseCoordsY.remove(followY);
				mouseCoordsY.add(followY,y);
				followY++;
				if(followY > 14){
					followY = 0;
				}
		}
	}
	public static boolean killProgram (boolean real){
		//When it receives a wake check!
		ArrayList<Integer> traverse = mouseCoordsX;
		ArrayList<Integer> traverseY = mouseCoordsY;
		//most recent input
		int most_recent_Y = followY;
		int most_recent_X = followX;
		//if this 5 and last 5 is not the same to close program and had functionalities back to user! 
		//by throwing an exception!
		return true;
	}
	public static void main(String[] args) throws InterruptedException {
		//WakeMouse sc = new WakeMouse();
		//Thread run = new Thread(sc);
		//run.start();
		while(true){
			Thread.sleep(1000);
			addToCoord(getX(),getY());
			System.out.println(mouseCoordsX);
			System.out.println(mouseCoordsY);
		}
	}
}
