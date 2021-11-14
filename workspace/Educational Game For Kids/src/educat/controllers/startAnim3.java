package educat.controllers;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import educat.view.Tester;
import educat.view.startGame;

public class startAnim3 implements Runnable {
	//Sets background with three in the slide.
	@Override
	public void run() {
		JPanel p = Tester.getJPanel();
		JFrame frame = Tester.getJFrame();
		frame.remove(p);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		startGame.createBG();
		JLabel bg = startGame.getBG();
		startGame.setThree();
		JLabel two = startGame.getThree();
		startGame.createRoc();
		JLabel roc = startGame.getRock();
		bg.add(roc);
		bg.add(two);
		panel.add(bg);
		Tester.setJPanel(panel);
		frame.add(panel);
		frame.repaint();
		frame.revalidate();
		frame.setVisible(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startAnimGO c = new startAnimGO();
		Thread tm = new Thread(c);
		tm.start();
	}
}
