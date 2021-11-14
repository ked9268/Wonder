package view.trading_scenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.tableLogic;
import controller.ActionListeners;
import controller.events;
import controller.ActionListeners.execute_trade;
import controller.ActionListeners.listenForEnter;
import trading.executeTrades;
import view.Mainview;

public class usdjpy_scene implements KeyListener {

	public JPanel panel;
	static JTextField quantity,stop_loss,take_profit,direction;
	static String quantity_string,stop_loss_string,take_profit_string,direction_string;
	JTextField jt;
	public static JTable usdjpy_table;
	boolean direct;

	
	public static void setLatestPrice(String c){
				
	}
	/**
	 * Logic!
	 * **/
	public usdjpy_scene(){
		//JFrame frame = Mainview.frame;
		//frame.remove(events_5.panel);		
		JFrame frame = new JFrame();
		
		panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setLayout(null);
		//panel = Mainview.current_panel;
		
		jt = new JTextField();
		jt.addKeyListener(this);
		jt.setBounds(0,0,300,300);
		panel.add(jt);
		
		JButton back = new JButton("Back");
		back.setBounds(1000,20,150,50);
		panel.add(back);
		ActionListeners.backToHome eventback = new ActionListeners.backToHome();
		back.addActionListener(eventback);
		
		JLabel usdjpy_table_header = new JLabel("USD/JPY Price");
		usdjpy_table_header.setBounds(550,100,150,275);
		panel.add(usdjpy_table_header);
		
		usdjpy_table = new JTable(16,3);
		usdjpy_table.setValueAt("Current price",0,0);
		usdjpy_table.setValueAt("difference with last price",0,1);
		usdjpy_table.setValueAt("Time GG stamp",0,2);
		usdjpy_table.setBounds(550,300,650,375);
		panel.add(usdjpy_table);
		
		quantity = new JTextField();
		quantity.setBounds(220,300,50,40);
		panel.add(quantity);
		JLabel quantity_text = new JLabel("quantity");
		quantity_text.setBounds(280,300,75,40);
		panel.add(quantity_text);
		// Stop loss value
		stop_loss = new JTextField();
		stop_loss.setBounds(220,350,70,40);
		panel.add(stop_loss);
		JLabel stop_loss_text = new JLabel("stop loss");
		stop_loss_text.setBounds(330,350,75,40);
		panel.add(stop_loss_text);
		// Take profit value
		take_profit = new JTextField();
		take_profit.setBounds(220,400,50,40);
		panel.add(take_profit);
		JLabel take_profit_text = new JLabel("take profit");
		take_profit_text.setBounds(280,400,75,40);
		panel.add(take_profit_text);
		//Direction 
		direction = new JTextField();
		direction.setBounds(220,450,50,40);
		panel.add(direction);
		JLabel direction_text = new JLabel("direction");
		direction_text.setBounds(280,450,75,40);
		panel.add(direction_text);
		
		JButton button = new JButton();
		button.setBounds(250,500,30,30);
		button.addActionListener(new enter());
		panel.add(button);
		frame.add(panel);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		//priceFetch();
		//frame.setVisible(true);
	}
	public class enter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			quantity_string = usdjpy_scene.quantity.getText();
			stop_loss_string = usdjpy_scene.stop_loss.getText();
			
			take_profit_string = usdjpy_scene.take_profit.getText();
			direction_string = usdjpy_scene.direction.getText();
			if(direction_string.equals("buy")){
				direct = true;
			}
			else{
				direct = false;
			}
			executeTrades.newTrade("USD/JPY", Double.valueOf(usdjpy_scene.quantity.getText()), Double.valueOf(usdjpy_scene.stop_loss.getText()), Double.valueOf(usdjpy_scene.take_profit.getText()), direct);
			usdjpy_scene.quantity.setText("");
			usdjpy_scene.stop_loss.setText("");
			usdjpy_scene.take_profit.setText("");
			usdjpy_scene.direction.setText("");
		}
		
	}
	public static void main(String[] args) {
		usdjpy_scene usdjpy = new usdjpy_scene();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			//tableLogic.whichCurrency(jt.getText());
			//System.out.println(jt.getText());
			tableLogic.whichCurrency(events.trim(jt.getText()));
			jt.setText("");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
