package view.trading_scenes;

import java.awt.Color;
import java.awt.Dimension;
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
import view.Mainview;

public class gbpusd_scene implements KeyListener {
	public JPanel panel;
	JTextField jt;
	public static JTable gbpusd_table;

	public gbpusd_scene(){
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
		
		JLabel gbpusd_table_header = new JLabel("GBP/USD Price");
		gbpusd_table_header.setBounds(550,100,150,275);
		panel.add(gbpusd_table_header);
		
		gbpusd_table = new JTable(16,3);
		gbpusd_table.setValueAt("Current price",0,0);
		gbpusd_table.setValueAt("difference with last price",0,1);
		gbpusd_table.setValueAt("Time GG stamp",0,2);
		gbpusd_table.setBounds(550,300,650,375);
		panel.add(gbpusd_table);
		
		frame.add(panel);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		//priceFetch();
		//frame.setVisible(true);
	}
	public static void main(String[] args) {
		gbpusd_scene gbpusd = new gbpusd_scene();
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
