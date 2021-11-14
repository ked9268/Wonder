package educat.controllers;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import educat.view.Tester;
import educat.view.newGame;
import educat.view.startGame;

public class startAnimGO implements Runnable {
	//Sets background with GO in the slide.
	@Override
	public void run() {
		
		JPanel p = Tester.getJPanel();
		JFrame frame = Tester.getJFrame();
		frame.remove(p);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		startGame.createBG();
		JLabel bg = startGame.getBG();
		startGame.setGO();
		JLabel go = startGame.getGO();
		startGame.createRoc();
		JLabel roc = startGame.getRock();
		bg.add(roc);
		bg.add(go);
		panel.add(bg);
		frame.add(panel);
		Tester.setJPanel(panel);
		frame.repaint();
		frame.revalidate();
		//frame.setVisible(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newGame ng = new newGame();
		Thread c = new Thread(ng);
		c.start();	
	}
}
