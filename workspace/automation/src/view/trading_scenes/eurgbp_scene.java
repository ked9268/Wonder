package view.trading_scenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.tableLogic;
import view.Mainview;
import controller.ActionListeners;
import controller.events;

public class eurgbp_scene implements KeyListener {

		public JPanel panel;
		private JTextField jt;
		public static JTable eurgbp_table;
		//JFrame frame = Mainview.frame;
	
		public eurgbp_scene(){
		JFrame frame = new JFrame();
		
		panel = new JPanel();
		panel.setBackground(Color.ORANGE);
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
		
		JLabel eurgbp_table_header = new JLabel("EUR/GBP Price");
		eurgbp_table_header.setBounds(550,100,150,275);
		panel.add(eurgbp_table_header);
		
		eurgbp_table = new JTable(16,3);
		eurgbp_table.setValueAt("Current price",0,0);
		eurgbp_table.setValueAt("difference with last price",0,1);
		eurgbp_table.setValueAt("Time GG stamp",0,2);
		eurgbp_table.setBounds(550,300,650,375);
		panel.add(eurgbp_table);
		
		frame.add(panel);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		//priceFetch();
		//frame.setVisible(true);
	}
	public static void main(String[] args) {
		eurgbp_scene eurgbp = new eurgbp_scene();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			//tableLogic.whichCurrency(jt.getText());
			//System.out.println(jt.getText());
			tableLogic.whichCurrency(events.trim(jt.getText()));
			jt.setText("");
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
