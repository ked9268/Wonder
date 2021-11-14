package view;

import java.awt.Color;






import java.awt.GridBagLayout;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.events;
//send notification
public class notification implements Runnable {
	public static Boolean notif_check = false;
	JLabel text;
	static String msg = "Sent";
	
	public static void main(String[] args) throws InterruptedException{	
		notification nt = new notification();
		//msg = "Email Sent";
		Thread main = new Thread(nt);
		main.start();
		//events.sleep(3000);
		//notification.notif_check = true;
		//events.sleep(3000);
		//notification.notif_check = false;
	}
	public Boolean getNotif(){
		return notif_check;
	}
	public static void setNotif(String notif){
		msg = notif;
	}
	@Override
	public void run() {
		try {		
				JFrame frame = new JFrame();
				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout());
				//panel.setLayout(null);
				panel.setBackground(Color.magenta);
				frame.add(panel);
				text = new JLabel(msg);
				text.setFont(text.getFont().deriveFont(16f));
				text.setHorizontalAlignment(text.LEFT);
				//text.setLocation(500,40);
				panel.add(text);
				//Required painting of Notification tab.
				frame.setUndecorated(true);
				frame.setLocation(500,50);
				frame.setShape(new RoundRectangle2D.Double(10,10,250,100,50,50));
				frame.setSize(300,150);
				frame.setFocusableWindowState(false);
				frame.setVisible(true);
				Thread.sleep(3000);
				frame.dispose();
			
		} catch (InterruptedException e) {
		}
	}
	

}
