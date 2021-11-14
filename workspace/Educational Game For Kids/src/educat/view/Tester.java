package educat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import educat.model.loadingFacts;
import educat.view.MainG.HandlerClass;

public class Tester extends JFrame implements Runnable,KeyListener {
	int var = 0;
	static JFrame jf; // Main JFrame 
	static JPanel jp; // Main JPanel
	JTextField textfield;
	static JTextArea textarea;
	static int frame_height,frame_width;
	JProgressBar jbar;
	Boolean captions_finished = null;
	Boolean bar_finished = null;		
	public static JFrame getJFrame(){
		return jf;
	}
	public void setJFrame(JFrame jf){
		this.jf = jf;
	}
	public static void setJFrameHeight(int c){
		frame_height = c;
	}
	public static int getJFrameHeight(){
		return frame_height;
	}
	public static void setJFrameWidth(int c){
		frame_width = c;
	}
	public static int getJFrameWidth(){
		return frame_width;
	}
	public static  void setJPanel(JPanel panel){
		jp = panel;
	}	
	public static JPanel getJPanel(){
		return jp;
	}
	public void setJValue(int c){
		this.var = c;
	}
	public int getJValue(){
		return var;
	}
	public void setTextField(String jt){
		JTextField c = new JTextField(jt);
		textfield = c;
		}
	public String getTextField(int i){
		// Logic Handling.
		switch(i){
			case 0: 
				setTextField(" ");
				return textfield.getText();
			case 1: 
				setTextField(loadingFacts.fact1);
				return textfield.getText();
			case 2: 
				setTextField(loadingFacts.fact2);
				return textfield.getText();
			case 3: 
				setTextField(loadingFacts.fact3);
				return textfield.getText();
			case 4: 
				setTextField(loadingFacts.fact4);
				return textfield.getText();
			case 5: 
				setTextField(loadingFacts.fact5);
				return textfield.getText();
			case 6: 
				setTextField(loadingFacts.fact6);
				return textfield.getText();
			case 7: 
				setTextField(loadingFacts.fact7);
				return textfield.getText();
			case 8:
				setTextField(loadingFacts.fact8);
				return textfield.getText();
			case 9: 
				setTextField(loadingFacts.fact9);
				return textfield.getText();
			default: return " ";
		}
	}
	public void setTextArea(JTextArea jt){
		textarea = jt;
	}
	public JTextArea getTextArea(){
		return textarea;
	}
	public JProgressBar getJBar(){
		return jbar;
	}
	public void setJBar(JProgressBar jba){
		jbar = jba;
	}
	public void setCFinished(){
		captions_finished = true;
	}
	public Boolean getCFinished(){
		return captions_finished;
	}
	public void setBFinished(){
		bar_finished = true;
	}
	public Boolean getBFinished(){
		return bar_finished;
	} 
	Tester(){
		JFrame frame = getJFrame();
		setJFrame(frame);
		JPanel pane = new JPanel();
		pane.setLayout(null);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int width_of_tips = getJFrameWidth()-100;
		int height_of_tips = (getJFrameHeight()/100)+100;
		//Progress bar which shows complete loading.
		JProgressBar pb = new JProgressBar();
		setJBar(pb);
		pb.setValue(var);
		int x = 25;
		int y = (getJFrameHeight()/2);
		pb.setBounds(25,y,width_of_tips,height_of_tips); // Set location and adapt to the size of the browser.
		pane.add(pb);
		
		//Text area shows tips about programming.
		JTextArea ts = new JTextArea();
		ts.setBackground(Color.GREEN);
		ts.setBounds(x,y-height_of_tips,width_of_tips,height_of_tips); //Set location and adapt to the size of the Screen
		ts.setFont(ts.getFont().deriveFont(18f));
		ts.setEditable(false);
		setTextArea(ts);
		pane.add(ts);
		setJPanel(pane);
		Thread tm = new Thread(this);
		tm.start();
	}
	public void LoadMainMenu(){
		JFrame frame = getJFrame();
		JPanel pane = getJPanel();
		pane.setBackground(Color.DARK_GRAY);
		frame.remove(pane);
		setJPanel(null);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
		MainMenu m = new MainMenu();
		JPanel jp = m.getPanel();
		frame.add(jp);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		//Adds functionality of working keys to JFrame
		HandlerClass hc = new HandlerClass();
		frame.addKeyListener(hc);
		frame.setFocusable(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		SizeCheck c = new SizeCheck();
		c.start();
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tester t = new Tester();
		t.setJFrame(frame);
		JPanel jp = t.getJPanel();
		frame.add(jp);
		frame.setVisible(true);
	}
	@Override
	public void run() {
		Timer captions = new Timer();
		Timer jp_bar = new Timer();
		Timer size = new Timer();
		Boolean jp_bar_done = null;
		jp_bar.schedule(new TimerTask(){
			int j = 0;
			JProgressBar jb = getJBar();
			@Override
			public void run() {
				setJValue(j);
				jb.setValue(getJValue());
				j=j+10;
				if (j > 100){
					jp_bar.cancel();
					setBFinished();
				}
			}			
		},2500,1200);
		size.schedule(new TimerTask(){
			public void run(){
			
				setJFrameHeight(getJPanel().getHeight());
				setJFrameWidth(getJPanel().getWidth());
				getJPanel().repaint();
				getJPanel().revalidate();
			}
		},1000,1000);
		captions.schedule(new TimerTask (){
			JTextArea jt = getTextArea();
			int i = 0;
			public void run(){
				getTextField(i);
				jt.setText(textfield.getText());
				setTextArea(jt);
				i++;
				if (i > 10){
					captions.cancel();
					setCFinished();	
					try{
						if(getBFinished() == true && getCFinished() == true){
							LoadMainMenu();
						}
					}catch(NullPointerException e){
						LoadMainMenu();
					}
				}
			}
		},0,3000);
		jp_bar_done = true;		
	}
	public static class SizeCheck extends Thread{
		public void run() {
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int width = (int) screenSize.getWidth();
			int height = (int) screenSize.getHeight();
			setJFrameWidth(width);
			setJFrameHeight(height);
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
