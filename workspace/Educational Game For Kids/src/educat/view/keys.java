package educat.view;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

import educat.view.MainG.HandlerClass;

public class keys implements KeyListener {

	static Boolean left,right,up,down;
	JPanel pane;
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel pane = new JPanel();
		//pane.setName("Panel 1");
		//System.out.println(pane.getName());
		JButton button = new JButton("Hello World!");
		pane.add(button);
		pane.setFocusable(true);
		keys key = new keys();
		pane.setBackground(Color.RED);
		pane.addKeyListener(key);
		frame.add(pane);
		frame.setSize(300,300);
		//try {
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		//} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		frame.setVisible(true);
	}
	@Override
	public void keyPressed(KeyEvent ke) {
		HandlerClass hc = new HandlerClass();
		if(KeyEvent.getKeyText(ke.getKeyCode())=="Left"){
			left = true;
			right = false;
			up = false;
			down = false;
			hc.decreaseX();
			System.out.println(hc.getX());
		}
		if(KeyEvent.getKeyText(ke.getKeyCode())=="Right" ){
			left = false;
			right = true;
			up = false;
			down = false;
			hc.increaseX();
			System.out.println(hc.getX());
		}
		if(KeyEvent.getKeyText(ke.getKeyCode())=="Up"){
			left = false;
			right = false;
			up = true;
			down = false;
			hc.decreaseY();
			System.out.println(hc.getY());
		}
		if ( KeyEvent.getKeyText(ke.getKeyCode())=="Down"){
			left = false;
			right = false;
			up = false;
			down = false;
			hc.decreaseY();
			System.out.println(hc.getY());
			System.out.println("Left: "+left+"   Right:"+right+"  Up:"+up+"  Down:"+down);
		}
		if (KeyEvent.getKeyText(ke.getKeyCode()) == "Enter"){
			//Get location of where the user at 
			System.out.println(pane);
		} 
	}
	@Override
	public void keyReleased(KeyEvent ke) {		

	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub	
	}

}
