package educat.controllers;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import educat.view.Tester;
import educat.view.startGame;

public class startAnim implements Runnable {

	//Sets background with one in the slide.
	@Override
	public void run() {
		JPanel p = Tester.getJPanel();
		JFrame frame = Tester.getJFrame();
		frame.remove(p);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		startGame.createBG();
		JLabel bg = startGame.getBG();
		startGame.setOne();
		JLabel one = startGame.getOne();
		startGame.createRoc();
		JLabel roc = startGame.getRock();
		bg.add(roc);
		bg.add(one);
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
		startAnim2 c = new startAnim2();
		Thread tm = new Thread(c);
		tm.start();
	}

}
