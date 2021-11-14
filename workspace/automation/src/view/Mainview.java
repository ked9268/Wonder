package view;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.tableLogic;
import trading.executeTrades;
import trading.positions;
import trading.currencies.eurgbp;
import trading.currencies.eurusd;
import trading.currencies.gbpusd;
import trading.currencies.usdjpy;
import controller.ActionListeners;
import controller.ActionListeners.get_prices;
import controller.Check_time;
import controller.events;
import controller.readTextFile;
import controller.sendEmail;
/*
 * Currently we have the capacity to execute trades as soon as the forecast comes out. We don't have the ability to
 * manage the trades manually. Or close the trades manually. We can open the trade with an initial stop loss and and an initial 
 * take profit. Which will close the trade when the price goes out of favour. However we can not apply a trailing stop price or monitor
 * the location of the price internally as to manage the trade independently.
 * 
 * */
//main app
public class Mainview implements Runnable,KeyListener {
	public static JFrame frame;
	public static JPanel panel;
	public static JPanel current_panel;
	static int rightSide;
	static int bottomSide;
	JLabel label;
	JButton button,button_2,button_3,button_4,button_5;
	JTable tabel;
	public static boolean NFP_day = false;
	public static eurgbp eurgbp;
	public static view.trading_scenes.eurgbp_scene eurgbp_scene;
	public static eurusd eurusd;
	public static view.trading_scenes.eurusd_scene eurusd_scene;
	public static usdjpy usdjpy;
	public static view.trading_scenes.usdjpy_scene usdjpy_scene;
	public static gbpusd gbpusd;
	public static view.trading_scenes.gbpusd_scene gbpusd_scene;
	public static JTextField jt;
	public static JComboBox menu;
	public static int which = 0;
	public static String current_date; 
	private static void setTime(){
		Date date = new Date();
		String receive = date.toString().replaceAll("\\s+","");;
		String hour = receive.substring(8,10);
		String minute = receive.substring(11,13);
		String second = receive.substring(14,16);
		int secs = Integer.valueOf(second);
		int min = Integer.valueOf(minute);
		int hou = Integer.valueOf(hour);
		Check_time.setSecond(secs);
		Check_time.setMinute(min);
		Check_time.setHour(hou);
	}
	public static void setRightSide(int c){
			rightSide = c;
	}
	public static int getRightSide(){
		return rightSide;
	}
	public static void setBottomSide(int c){
		bottomSide = c;
	}
	public static int getBottomSide(){
		return bottomSide;
	}
	public void priceFetch() throws IOException{
		eurgbp = new eurgbp();
		eurgbp_scene = new view.trading_scenes.eurgbp_scene();
		eurusd = new eurusd();
		eurusd_scene = new view.trading_scenes.eurusd_scene();
		usdjpy = new usdjpy();		
		usdjpy_scene = new view.trading_scenes.usdjpy_scene();
		gbpusd = new gbpusd();
		gbpusd_scene = new view.trading_scenes.gbpusd_scene();
	}
	public Mainview() throws IOException{
		current_date = Check_time.getDate() + Check_time.getMonth();
		System.out.println(current_date);
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(null);
		//panel = current_panel;
		
		jt = new JTextField();
		jt.addKeyListener(this);
		jt.setBounds(0,0,300,300);
		panel.add(jt);
		
		label = new JLabel(Check_time.printCurrentTime());
		label.setForeground(Color.WHITE);
		label.setBounds(500,500,300,100);
		panel.add(label);
		
		JButton get_7am = new JButton("Get 7AM Forecasts");
		get_7am.setBounds(600,300,150,50);
		ActionListeners.get_7am get_7AM = new ActionListeners.get_7am();
		get_7am.addActionListener(get_7AM);
		panel.add(get_7am);
		
		JButton get_11am = new JButton("Get 11AM forecasts");
		get_11am.setBounds(800,300,150,50);
		ActionListeners.get_11AM get_11AM = new ActionListeners.get_11AM();
		get_11am.addActionListener(get_11AM);
		panel.add(get_11am);
		
		JButton get_prices = new JButton("Get prices");
		get_prices.setBounds(600,600,150,50);
		ActionListeners.get_prices get_PRICES = new ActionListeners.get_prices();
		get_prices.addActionListener(get_PRICES);
		panel.add(get_prices);
		
		JButton stop_get = new JButton("Stop Get prices");
		stop_get.setBounds(400,600,150,50);
		ActionListeners.stopPrintTimes stop_PRICES = new ActionListeners.stopPrintTimes();
		stop_get.addActionListener(stop_PRICES);
		panel.add(stop_get);
		
		JButton execute_trade = new JButton("Execute Trade");
		execute_trade.setBounds(600,200,150,50);
		ActionListeners.execute_trade execute_TRADE = new ActionListeners.execute_trade();
		execute_trade.addActionListener(execute_TRADE);
		panel.add(execute_trade);
		
		JButton printTrades = new JButton("Print trades");
		printTrades.setBounds(600,475,150,50);
		ActionListeners.printTrades pt = new ActionListeners.printTrades();
		printTrades.addActionListener(pt);
		panel.add(printTrades);
		
		tabel = new JTable(9,1);
		//tabel.setValueAt("Should automate trades in 1 hour slots ",0,0);
		//tabel.setValueAt("",1,0);
		tabel.setValueAt("USD forecasts at 11Am",2,0);
		tabel.setValueAt("European forecasts at 7AM",3,0);
		tabel.setValueAt("Markets open at 9:59PM GMT Sunday", 4, 0);
		tabel.setValueAt("Save and upload prices to a text file",5,0);
		tabel.setValueAt("Check prices inbetween eachother to get gradient",6,0);
		tabel.setValueAt("Markets close at 9:59PM GMT Friday",1,0);
		tabel.setValueAt("First friday of the month is NFP",0,0);
		tabel.setValueAt("Check date of forecast before attempting to get a new forecast",7,0);
		tabel.setValueAt("All forecasts except USD/JPY can be collected twice at 7 and 11",8,0);
		tabel.setBounds(900,500,300,200);
		panel.add(tabel);

		menu = new JComboBox(executeTrades.currency);
		menu.setSelectedIndex(-1);
		ActionListeners.comboBox cb = new ActionListeners.comboBox();
		menu.addItemListener(cb);
		menu.setBounds(800,200,150,50);
		panel.add(menu);
		
		
		panel.setBackground(Color.BLUE);
		frame.add(panel);
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable(true);
		priceFetch();
		frame.setVisible(true);
		
		//Just change this to accomodate for amount.
		//executeTrades.execute_trade(1,"sell"); //Sets call to run the trade
	}
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		Mainview main = new Mainview();
		Thread tmain = new Thread(main);
		tmain.start();
		/**events.open_chrome();
		events.sleep(10000);
		events.click();
		events.sleep(1000);
		events.close_browser();
		*/
		events.sleep(5000);		
		events.eurgbpforecastC();
	}
	@Override
	public void run() {	
		if(Check_time.getDate().equals("01")){
			try {
				sendEmail.sendOnBrowser("Economic Calendar","https://www.fxstreet.com/economic-calendar");
				notification nt = new notification();
				nt.setNotif("Email Sent");
				Thread tm = new Thread(nt);
				tm.start();		
			} catch (IOException | InterruptedException | AWTException e) {     }
		}
		if(Check_time.getDay() == "Friday"){			
			try {
				positions pos = new positions();
				String month = Check_time.getMonth();
				
				String friday = pos.firstFridays.get(month);
				if(Check_time.getDate().equals(friday) == true){
					NFP_day = true;
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Get prices.
		//get_prices gp = new get_prices();
		//Thread tgp = new Thread(gp);
		//tgp.start();
		int counter = 0;
		if(NFP_day == true){
			//What to do when the NFP day is Friday!
		}
		while(true){
			//counter ++;
			//System.out.println(counter);
			if(counter == 35){
				//get_prices.stop = true; //Stop collection of prices! 
				try {
					sendEmail.readLatestEmail();
				} catch (InterruptedException | AWTException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/**
			 * Allows for the completion of methods such as trade management 
			 * and forecast coolection. 
			 */
			if(counter == 75){
				//events.restart_get_prices(); //Restart collection of prices!
			}
			try{		
				Thread.sleep(1000);
				setTime();
			
				setRightSide(frame.getWidth());
				setBottomSide(frame.getHeight());
				if(getBottomSide() == 300 && getRightSide() == 300){
					panel.setBackground(Color.BLACK);
					label.setBounds(100,100,200,100);
					button_4.setBounds(5,5,125,75);
					}
				else{
					panel.setBackground(Color.BLUE);
					label.setBounds(500,500,300,100);
				}
			}
			catch(InterruptedException e){	}
			label.setText(Check_time.printCurrentTime());
			if (Check_time.getSecond() == 0 && Check_time.getMinute() == 10 && Check_time.getHour() == 7){
				get_prices.stop = true;
				try {
					events.gbpusdforecastC();
					events.sleep(30000);
					events.eurgbpforecastC();
				} catch (InterruptedException | IOException | AWTException e) {    }
				events.restart_get_prices();
			}
			if (Check_time.getHour() >= 7 && Check_time.getMinute() >= 10 && Check_time.getHour() < 8){
				//System.out.println("Time is greater than 7:10 AM and less than 8:00 AM");
			}
			if (Check_time.getSecond() == 0 ){
				System.out.println("Second is 0");
			}
			if(Check_time.getSecond() == 0 && Check_time.getMinute() == 10 && Check_time.getHour() == 11){
				get_prices.stop = true;
				try {
					events.usdjpyforecastC();
				} catch (InterruptedException | IOException | AWTException e) {   }
				events.restart_get_prices();
			}
			if(executeTrades.running.size() >= 1){
				//Start of manual trade management.
				ActionListeners.check_price cb = new ActionListeners.check_price();
				Thread thread = new Thread(cb);
				thread.start();
			}
			panel.repaint();
		}		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
			tableLogic.whichCurrency(events.trim(jt.getText()));
			jt.setText("");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_SHIFT){
			try {
				positions.receiveForeCast(which,jt.getText());
			} catch (IOException e) { }			
			jt.setText("");
		}
		if(arg0.getKeyCode() == KeyEvent.VK_I){
			System.out.println(events.trim(jt.getText()));
			System.out.println(events.trim(jt.getText()).contains("New instagram alert"));
			if(events.trim(jt.getText()).contains("New instagram alert") == true){
				
			}
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {  }
	@Override
	public void keyTyped(KeyEvent arg0) {	}
}