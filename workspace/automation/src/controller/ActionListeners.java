package controller;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import trading.executeTrades;
import trading.positions;
import view.Mainview;

public class ActionListeners {
	public static class backToHome implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Mainview.frame.remove(Mainview.current_panel);
			Mainview.frame.repaint();
			Mainview.frame.add(Mainview.panel);
			SwingUtilities.updateComponentTreeUI(Mainview.frame);
		}
	}
	public static class check_price implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
					try {
						events.sleep(2000);// Make dependent on entries
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				System.out.println(executeTrades.running);
				if(executeTrades.running.size() == 0){
					try {
						throw new InterruptedException();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i = 0;i < executeTrades.running.size();i++){
					executeTrades.running.get(i).check_price();
				}
			}
		}
		
	}
	public static class comboBox implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent arg0) {
			JComboBox mein = Mainview.menu;
			if(mein.getSelectedItem() == "GBP/USD"){
				//System.out.println("This will send to GBP/USD scene!");
				Mainview.menu.setSelectedIndex(-1);
				Mainview.frame.remove(Mainview.panel);
				Mainview.frame.repaint();
				Mainview.frame.revalidate();
				Mainview.frame.setVisible(true);
				Mainview.current_panel = Mainview.gbpusd_scene.panel;
				Mainview.frame.add(Mainview.gbpusd_scene.panel);
				Mainview.frame.repaint();
				Mainview.frame.revalidate();
				Mainview.frame.setVisible(true);
				//switch scenes with a full breakdown and jtextfield to continue getting prices
			}
			if(mein.getSelectedItem() == "USD/JPY"){
				//System.out.println("This will send to USD/JPY scene!");
				Mainview.menu.setSelectedIndex(-1);
				Mainview.frame.remove(Mainview.panel);
				Mainview.frame.repaint();
				Mainview.frame.revalidate();
				Mainview.frame.setVisible(true);
				Mainview.current_panel = Mainview.usdjpy_scene.panel;
				Mainview.frame.add(Mainview.usdjpy_scene.panel);
				Mainview.frame.repaint();
				Mainview.frame.revalidate();
				Mainview.frame.setVisible(true);
				//switch scenes with a full breakdown and jtextfield to continue getting prices
			}
			if(mein.getSelectedItem() == "EUR/USD"){
				//System.out.println("This will send to EUR/USD scene!");
				Mainview.menu.setSelectedIndex(-1);
				Mainview.frame.remove(Mainview.panel);
				Mainview.frame.repaint();
				Mainview.frame.revalidate();
				Mainview.frame.setVisible(true);
				Mainview.current_panel = Mainview.eurusd_scene.panel;
				Mainview.frame.add(Mainview.eurusd_scene.panel);
				Mainview.frame.repaint();
				Mainview.frame.revalidate();
				Mainview.frame.setVisible(true);
				//switch scenes with a full breakdown and jtextfield to continue getting prices
			}
			if(mein.getSelectedItem() == "EUR/GBP"){
				//System.out.println("This will send to EUR/GBP scene!");
				Mainview.menu.setSelectedIndex(-1);
				Mainview.frame.remove(Mainview.panel);
				Mainview.frame.repaint();
				Mainview.frame.revalidate();
				Mainview.frame.setVisible(true);
				Mainview.current_panel = Mainview.eurgbp_scene.panel;
				Mainview.frame.add(Mainview.eurgbp_scene.panel);
				Mainview.frame.repaint();
				Mainview.frame.revalidate();
				Mainview.frame.setVisible(true);
				//switch scenes with a full breakdown and jtextfield to continue getting prices
			}
			
		}
		
	}
	public static class count implements Runnable{
		int counter = 0;
		public int howlong = 0;
		@Override
		public void run() {
			System.out.println(howlong);
			while(true){
				try {
					events.sleep(900);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(counter);
				
				counter++;
				if(counter == howlong){
					break;
				}
			}
			System.out.println("Run method to close trade!");
		}	
	}
	public static class execute_trade implements ActionListener{

		static JTextField quantity,stop_loss,take_profit,direction;
		static JComboBox menu;
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new JFrame();
			frame.addKeyListener(new listenForEnter());
			frame.setFocusable(true);
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.GREEN);
			//Specific trade.
			menu = new JComboBox(executeTrades.currency);
			menu.setSelectedIndex(-1);
			ActionListeners.comboBox cb = new ActionListeners.comboBox();
			menu.addItemListener(cb);
			menu.setBounds(0,5,200,40);
			panel.add(menu);
			//Size of trade
			quantity = new JTextField();
			quantity.setBounds(10,50,50,40);
			panel.add(quantity);
			JLabel quantity_text = new JLabel("quantity");
			quantity_text.setBounds(65,50,75,40);
			panel.add(quantity_text);
			// Stop loss value
			stop_loss = new JTextField();
			stop_loss.setBounds(10,100,50,40);
			panel.add(stop_loss);
			JLabel stop_loss_text = new JLabel("stop loss");
			stop_loss_text.setBounds(65,100,75,40);
			panel.add(stop_loss_text);
			// Take profit value
			take_profit = new JTextField();
			take_profit.setBounds(10,150,50,40);
			panel.add(take_profit);
			JLabel take_profit_text = new JLabel("take profit");
			take_profit_text.setBounds(65,150,75,40);
			panel.add(take_profit_text);
			//Direction 
			direction = new JTextField();
			direction.setBounds(10,200,50,40);
			panel.add(direction);
			JLabel direction_text = new JLabel("direction");
			direction_text.setBounds(65,200,75,40);
			panel.add(direction_text);
			
			JButton button = new JButton();
			button.setBounds(250,250,30,30);
			button.addActionListener(new listenForEnter());
			panel.add(button);
			
			frame.add(panel);
			frame.setSize(300,300);
			frame.setLocation(300,300);
			frame.getRootPane().setDefaultButton(button);
			button.requestFocus();
			frame.setVisible(true);			
		}	
	}
	public static class get_prices implements ActionListener,Runnable{
		
		public static boolean stop = false;
		public void run() {
			Robot rb;
			try {
				rb = new Robot();
				executeTrades.openSites();
				Thread.sleep(15000);
				while(events.getTime){
					events.sleep(600);
					rb.mouseMove(213, 310);
					events.sleep(600);
					events.click();
					if(stop == true){
						events.close_browser();
						events.getTime = false;
						break;
					}
					Thread.sleep(5000);
					events.mouseDrag(213, 310, 310, 320);
					events.sleep(600);
					events.copy();
					events.sleep(600);
					events.nextApp();
					events.sleep(600);
					rb.mouseMove(250,250);
					events.sleep(300);
					events.click();
					events.sleep(200);
					events.paste();
					events.sleep(300);
					events.enter(1);
					events.sleep(600);
					events.nextApp();
					events.sleep(600);
					events.previousTab();
					
				}
			} catch (AWTException | InterruptedException | URISyntaxException | IOException e) {   }
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {			
				Thread am = new Thread(this);
				events.getTime = true;
				am.start();
				}
		}
	
	public static class get_7am implements ActionListener,Runnable{
		public void run() {
			try {
				events.gbpusdforecastC();
				Thread.sleep(10000);
				events.eurgbpforecastC();
				events.sleep(10000);
				events.eurusdforecastC();
			} catch (InterruptedException | IOException | AWTException e) {}
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Thread am = new Thread(this);
			am.start();
		}
	}
	public static class get_11AM implements ActionListener,Runnable{

		@Override
		public void run() {
			try {
				events.sleep(5000);
				events.usdjpyforecastC();
				events.sleep(10000);
				events.eurusdforecastC();
			} catch (InterruptedException | IOException | AWTException e) {}
			System.out.println("Get 11AM forecasts");
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Thread am = new Thread(this);
			am.start();		
		}
	}
	public static class listenForEnter implements KeyListener,ActionListener{
		
		public void keyPressed(KeyEvent arg0) {}
		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			if(arg0.getKeyCode() == KeyEvent.VK_SHIFT){
				System.out.println("shift has been pressed!");
			}
		}
		public void keyTyped(KeyEvent arg0) {   }

		@Override
		public void actionPerformed(ActionEvent e) {
			//default values for stop loss and take profit and quantity.
			boolean bias;
			String selectedIndex,direction;
			double quantity = Double.valueOf(execute_trade.quantity.getText());
			double stoploss = Double.valueOf(execute_trade.stop_loss.getText());
			double takeprofit = Double.valueOf(execute_trade.take_profit.getText());
			direction = (String) execute_trade.direction.getText();
			selectedIndex = (String) execute_trade.menu.getSelectedItem();
			System.out.println(selectedIndex);
			execute_trade.quantity.setText("");
			execute_trade.stop_loss.setText("");
			execute_trade.take_profit.setText("");
			execute_trade.direction.setText("");
			execute_trade.menu.setSelectedIndex(-1);		
			try {
				events.close_browser();
			} catch (InterruptedException | AWTException e2) {}
				
			
			if(selectedIndex == "GBP/USD"){
				if(direction == "buy"){
					bias = true;
				}
				else{
					bias = false;
				}
				try {
					executeTrades.newGBPUSDorder(quantity, stoploss, takeprofit, bias);
				} catch (AWTException | InterruptedException | IOException e1) {}
				
			}
			if(selectedIndex == "USD/JPY"){
				if(direction == "buy"){
					bias = true;
				}
				else{
					bias = false;
				}
				try {
					executeTrades.newUSDJPYorder(quantity, stoploss, takeprofit, bias);
				} catch (AWTException | InterruptedException | IOException e1) {   }
				
			}
			if(selectedIndex == "EUR/USD"){
				if(direction == "buy"){
					bias = true;
				}
				else{
					bias = false;
				}
				try {
					executeTrades.newEURUSDorder(quantity, stoploss, takeprofit, bias);
				} catch (AWTException | InterruptedException | IOException e1) {   }
				
			}
			if(selectedIndex == "EUR/GBP"){
				if(direction == "buy"){
					bias = true;
				}
				else{
					bias = false;
				}
				try {
					executeTrades.newEURGBPorder(quantity, stoploss, takeprofit, bias);
				} catch (AWTException | InterruptedException | IOException e1) {
				
				}
				
			}
			
		}		
	}
	public static class printTrades implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			executeTrades.printAllTrades();			
		}		
	}
	public static class stopPrintTimes implements ActionListener,Runnable{

		@Override
		public void run() {
			
					//events.getTime = false;
			get_prices.stop = true;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Thread the = new Thread(this);
			the.start();
		}
	}
	
}
