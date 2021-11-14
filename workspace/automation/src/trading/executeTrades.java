package trading;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.glass.events.KeyEvent;

import controller.Check_time;
import controller.events;
import controller.string_to_key_press;
import model.Word;
/**
 * Holds methods used to execute trades on MetaTrader4.
 * method execute_trade(int down_amount,String bias) is the method to be called to place
 * a trade. ** must be called from the main menu in the Mainview class. **
 * */
/**
 * However calling new${currency}order(double quantity,double stop_loss,double take_profit,boolean bias); 
 * will execute the trade on the platform. This method finally ends with an open instance of openTrades which records the
 * trade information
 * 
 * The enter at the end of execute_trade calls this method.
 * */
public class executeTrades {
	//execute trades on their on thread.
	double pip_value;
	double quantity;
	public static String [] currency = {"GBP/USD","USD/JPY","EUR/GBP","EUR/USD"};
	static int placeholder;
	static String timestamp;
	static int one_min = 60000;
	static double trailingstop = 0.1;
	static openTrades [] running_trades;
	public static List<openTrades> running = new ArrayList<openTrades>();
	public static void buildProfile(){
		
	}
	public static void copyPrice() throws AWTException, InterruptedException{
		Robot rb = new Robot();
		rb.mouseMove(233, 310);
		events.sleep(200);
		events.mouseDrag(233, 310, 315, 315);
		events.sleep(200);
		events.copy();
	}
	public static void execute_trade(int down_amount, String bias){
		//1 is GBP/USD 2 is USD/JPY 3 is EUR/GBP 4 is EUR/USD
		try {
			//Select execute trade button
			Robot rb = new Robot();
			rb.mouseMove(650,250);
			events.sleep(1000);
			events.click();
			events.sleep(1000);
			//Set parameteres for trade!
			rb.mouseMove(350, 350);
			events.sleep(300);
			events.click();
			events.sleep(300);
			events.Down(down_amount);
			events.sleep(300);
			events.Tab(1);
			events.sleep(300);
			String quantity = "0.2";
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			StringSelection stringSelection = new StringSelection(quantity);
			clipboard.setContents(stringSelection, null);
			events.sleep(300);
			events.paste();
			events.sleep(300);
			events.Tab(1);
			events.sleep(300);
			String stoploss = "0.15";
			clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			stringSelection = new StringSelection(stoploss);
			clipboard.setContents(stringSelection, null);
			events.sleep(300);
			events.paste();
			events.sleep(300);
			events.Tab(1);
			events.sleep(300);
			String takeprofit = "0.15";
			clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			stringSelection = new StringSelection(takeprofit);
			clipboard.setContents(stringSelection, null);
			events.sleep(300);
			events.paste();
			events.sleep(300);
			events.Tab(1);
			events.sleep(300);
			new string_to_key_press(bias);
			events.sleep(200);
			events.enter(1);			
			
		} catch (AWTException | InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}
	}
	public static void open_newOrder() throws AWTException, InterruptedException{
		Robot rb = new Robot();
		events.click();
		events.sleep(500);
		rb.keyPress(KeyEvent.VK_F9);
		events.sleep(100);
		rb.keyRelease(KeyEvent.VK_F9);
	}
	public static void openmt4_platform() throws IOException{
		String link = "C:\\Program Files (x86)\\FxPro - MetaTrader 4\\terminal.exe";
		events.run.exec(link);
	}
	public static void openSites() throws URISyntaxException, IOException{
		//Back to Front.
		positions.opengbpusd();  
		positions.openusdjpy();  
		positions.openeurgbp();  
		positions.openeurusd();  
	}
	public static void opentrading212() throws IOException, InterruptedException, AWTException{
		Robot rb = new Robot();
		events.open_firefox();
		events.sleep(2000);
		events.fullScreen();
		events.sleep(1000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_B);
		events.sleep(1000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_SHIFT);
		rb.keyRelease(KeyEvent.VK_B);
		events.sleep(1000);
		events.enter(1);
		events.sleep(20000);
}
	public static void selectBuy() throws AWTException, InterruptedException{
		Robot rb = new Robot();
		rb.mouseMove(600,345);
		events.sleep(1000);
		events.click();
	}
	public static void selectSell() throws InterruptedException, AWTException{
		Robot rb = new Robot();
		events.sleep(1000);
		rb.mouseMove(500,345);
		events.sleep(1000);
		events.click();
	}
	public static void newUSDJPYorder(double quantity,double stop_loss,double take_profit,boolean bias) throws AWTException, InterruptedException, IOException{
		/**Provides method to execute trade on the platform whilst simultaenously saving an instance to the running program.
		with method openTrades it also sends an email to 'kaide.josephwright@icloud.com' with the trade details.
		**/
		
		stop_loss = 0.002;
		take_profit = 0.002;
		openmt4_platform();
		events.sleep(12000);
		Robot rb = new Robot();
		open_newOrder();
		events.sleep(2000);
		//Select currency!
		rb.keyPress(KeyEvent.VK_U);
		rb.keyRelease(KeyEvent.VK_U);
		//Select volume.
		events.Tab(1);
		events.sleep(600);
		String myString = Double.toString(quantity);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(stringSelection, null);
		events.paste();
		events.Tab(1);
		//Set stop loss
		events.sleep(600);
		myString = Double.toString(stop_loss);
		StringSelection stopLoss = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(stopLoss, null);
		events.paste();
		events.Tab(1);
		//Set take profit.
		events.sleep(200);
		myString = Double.toString(take_profit);
		StringSelection takeProfit = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(takeProfit, null);
		events.paste();
		if (bias == true){
			selectSell();
		}
		else{
			selectBuy();
		}
		addTrade(new openTrades("USD/JPY",quantity,stop_loss,take_profit,bias));
		//Put internally.
	}
	public static void newEURUSDorder(double quantity,double stop_loss,double take_profit,boolean bias) throws AWTException, InterruptedException, IOException{
		stop_loss = 0.002;
		take_profit = 0.002;
		openmt4_platform();
		events.sleep(12000);
		Robot rb = new Robot();
		open_newOrder();
		events.sleep(2000);
		//Select currency!
		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);
		//Select Volume
		events.Tab(1);
		events.sleep(600);
		String myString = Double.toString(quantity);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(stringSelection, null);
		events.paste();
		events.Tab(1);
		//Set stop loss
		events.sleep(600);
		myString = Double.toString(stop_loss);
		StringSelection stopLoss = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(stopLoss, null);
		events.paste();
		events.Tab(1);
		//Set take profit.
		events.sleep(600);
		myString = Double.toString(take_profit);
		StringSelection takeProfit = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(takeProfit, null);
		events.paste();
		if (bias == true){
			selectSell();
		}
		else{
			selectBuy();
		}
		addTrade(new openTrades("EUR/USD",quantity,stop_loss,take_profit,bias));
	}
	public static void newGBPUSDorder(double quantity,double stop_loss,double take_profit,boolean bias) throws AWTException, InterruptedException, IOException{
		stop_loss = 0.002;
		take_profit = 0.002; //Forced.
		openmt4_platform();
		events.sleep(12000);
		Robot rb = new Robot();
		open_newOrder();
		events.sleep(2000);
		//Select currency!
		rb.keyPress(KeyEvent.VK_G);
		rb.keyRelease(KeyEvent.VK_G);
		//Select Volume
		events.Tab(1);
		events.sleep(600);
		String myString = Double.toString(quantity);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(myString);
		events.sleep(200);
		clipboard.setContents(stringSelection, null);
		events.paste();
		events.Tab(1);
		//Set stop loss
		events.sleep(600);
		myString = Double.toString(stop_loss);
		StringSelection stopLoss = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(stopLoss, null);
		events.paste();
		events.Tab(1);
		//Set take profit.
		events.sleep(600);
		myString = Double.toString(take_profit);
		StringSelection takeProfit = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(takeProfit, null);
		events.paste();
		if (bias == false){
			selectSell();
		}
		else{
			selectBuy();
		}
		addTrade(new openTrades("GBP/USD",quantity,stop_loss,take_profit,bias));
	}
	public static void newEURGBPorder(double quantity,double stop_loss,double take_profit,boolean bias) throws AWTException, InterruptedException, IOException{
		stop_loss = 0.002;
		take_profit = 0.002; //Forced.
		openmt4_platform();
		events.sleep(12000);
		Robot rb = new Robot();
		open_newOrder();
		events.sleep(2000);
		//Select currency!
		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);
		events.sleep(200);
		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);
		events.sleep(200);
		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);
		//Select Volume 
		events.Tab(1);
		events.sleep(600);
		String myString = Double.toString(quantity);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(stringSelection, null);
		events.paste();
		events.Tab(1);
		//Set stop loss
		events.sleep(600);
		myString = Double.toString(stop_loss);
		StringSelection stopLoss = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(stopLoss, null);
		events.paste();
		events.Tab(1);
		//Set take profit.
		events.sleep(600);
		myString = Double.toString(take_profit);
		StringSelection takeProfit = new StringSelection(myString);
		events.sleep(600);
		clipboard.setContents(takeProfit, null);
		events.paste();
		if (bias == true){
			selectSell();
		}
		else{
			selectBuy();
		}
		addTrade(new openTrades("EUR/GBP",quantity,stop_loss,take_profit,bias));
	}
	/**
	*INTERNALS.
	*
	*
	*
	**/
	
	public static void addTrade(openTrades trade){
		running.add(trade);
		trade.setPosition(running.size());
	};
	public static void close_trade(openTrades trade){
		//trade.close_trade();
		running.remove(trade.getPosition());
	}
	public static void printAllTrades(){
		running.size();
		int counter = 0;
		while(counter < running.size()){
			System.out.println(running.get(counter).returnTradeDetails());
			counter++;
		}
	}
	public static void pause(int c) throws InterruptedException{
		Thread.sleep(c*one_min);
	}
	public static void traverse(int place, String [] list){
		placeholder = place;
		int length = list.length;
		System.out.println(list[placeholder]);
		placeholder +=1;
		if(placeholder > length - 1){
			placeholder = 0;
		}
	}
	public static void end(openTrades trade){
		//Provide instruction with The site to close the trade.
		//Run the end execution on FXPro with Robot class..Send the Email. Update the Spreadsheet. Reset the values
		remove(trade);
	}
	public static void manage(){
		//Provide instruction to manage the trade. Maybe as the program develops. Notably with trailing stops.
	}
	public static openTrades[] getOnTrades(){
		return running_trades;
	}
	public static void remove(openTrades trade){
		//trade.close_trade();
		running.remove(trade.getPosition());
		
	}
	public static void newTrade(String which,double quantity,double SL ,double TP,boolean sway){
		addTrade(new openTrades(which,quantity,SL,TP,sway));
	}
	public static void main(String[] args) throws InterruptedException, URISyntaxException, IOException, AWTException {
			//newGBPUSDorder(0.4,0.4,0.5,true);
		openTrades trade = new openTrades("USD/JPY",0.4,0.02,0.03,false);
		addTrade(trade);
		openTrades custom = new openTrades("GBP/USD",0.5,0.3,0.2,true);
		addTrade(custom);
		System.out.println("Custom index position :"+custom.getPosition());
		printAllTrades();
		openTrades one_more = new openTrades("EUR/GBP",0.5,0.3,0.2,true);
		addTrade(one_more);
		System.out.println("Size: "+running.size());
		//printAllTrades();
		//running.remove(trade);
		//System.out.println("Size: "+running.size());
		System.out.println("Custom index position: "+custom.getPosition());
		running.remove(trade);
		System.out.println("Remove");
		System.out.println("Size: "+running.size());
		System.out.println("Custom index position: "+custom.getPosition());
		running.remove(custom);
		printAllTrades();
		//printAllTrades();
		//System.out.println("Size: "+running.size());
		}

}
