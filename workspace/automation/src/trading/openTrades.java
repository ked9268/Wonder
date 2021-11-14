package trading;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import model.tableLogic;
import trading.currencies.eurgbp;
import trading.currencies.eurusd;
import trading.currencies.gbpusd;
import trading.currencies.usdjpy;
import view.Mainview;
import controller.ActionListeners;
import controller.Check_time;
import controller.events;
import controller.sendEmail;

public class openTrades {
	/**Set Time and Date, Pip Value,Quanity Time. Entry location when start aswell as s
	top losses and take profit signs,bias! Also includes Spreadsheet updating, Notifications and email delivery.
	**/
	double take_profit;
	double stop_loss;
	double pip_value;
	boolean bias; //True is buy False is sell.
	String time;
	static double pivot;
	int quantity;
	int random_number;
	String currency;
	static int position;
	int result;
	
	public void close_trade(){
		
		//Close.
		/**
		 * Provide method to close on the platform!
		 */
		//Sends email with complete
		try {
			sendEmail.sendOnBrowser("Completed Trade",returnTradeDetails() );
		} catch (IOException | InterruptedException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static int getMin(ArrayList<String> c){
		ArrayList<Integer> boob = new ArrayList<Integer>();
		for(int i = 0;i <c.size();i++){
			boob.add(tableLogic.convertStringtoInt(c.get(i)));
		}
		return Collections.min(boob);
	}
	public static int getMax(ArrayList<String> c){
		ArrayList<Integer> boob = new ArrayList<Integer>();
		for(int i = 0;i <c.size();i++){
			boob.add(tableLogic.convertStringtoInt(c.get(i)));
		}
		return Collections.max(boob);
	}
	public static int getRange(int max,int min){
		return max-min;
	};
	public int RRcalculator(String target_level,String stop_loss,String pivot,String bias){
		return 0;
	}
	public int comparedToPivot(String c) throws IOException{
		tableLogic.convertStringtoInt(c);
		int return_value = 0;
		int current_price = 0;
		if(currency.equals("USD/JPY")){
			current_price = tableLogic.convertStringtoInt(c);
			return_value = current_price - Integer.valueOf(usdjpy.getpivot());
		}
		if(currency.equals("GBP/USD")){
			current_price = tableLogic.convertStringtoInt(c);
			return_value = current_price - Integer.valueOf(gbpusd.getpivot());
		}
		if(currency.equals("EUR/GBP")){
			current_price = tableLogic.convertStringtoInt(c);
			return_value = current_price - Integer.valueOf(eurgbp.getpivot());
		}
		if(currency.equals("EUR/USD")){
			current_price = tableLogic.convertStringtoInt(c);
			return_value = current_price - Integer.valueOf(eurusd.getpivot());
		}
		return return_value;
	}
	public void setTP(double tp){
		take_profit = tp;
	}
	public Double getTP(){
		return take_profit;
	}
	public void setSL(double sl){
		stop_loss = sl;
	}
	public Double getSL(){
		return stop_loss;
	}
	public void setBias(boolean bi){
		bias = bi;
	}
	public boolean getBias(){
		return bias;
	}
	public void setCurrency(String cur){
		currency = cur;
	}
	public String getCurrency(){
		return currency;
	}
	public static void setPosition(int c){
		position = c-1;
	}
	public static int getPosition(){
		return position;
	}
	public static double getResult(){
		return 0.0;
	}
	public static void setResult(double result){
		
	}
	public void check_price(){
		//This is your check!
		//Still have to get price!.
		//if(bias == true){
		double current_price = 0.0;
		if(getCurrency().equals("USD/JPY")){
			//current_price = Mainview.usdjpy.getCurrentPrice();
			
		}
		if(getCurrency().equals("EUR/USD")){
			//current_price = Mainview.eurusd.getCurrentPrice();
		}
		if(getCurrency().equals("GBP/USD")){
			//current_price = Mainview.gbpusd.getCurrentPrice();
		}
		if(getCurrency().equals("EUR/GBP")){
			//current_price = Mainview.eurgbp.getCurrentPrice();
		}
		if(getBias() == true){
			if(current_price > getTP()){
				
			}
			if(current_price < stop_loss){
				//Where you close in executeTrades class.
				
			}
		}
		else{
			 if(current_price < getTP()){
				 //Takes profit on a sell trade
			 }
			 if(current_price > getSL()){
				 //Cuts loss on a sell trade.
			 }
		}
	};
	public String returnTradeDetails(){	
		return "Currency: "+currency+" Quantity: " +pip_value+" Stop loss: "+getSL()+"Take Profit: "+getTP()+ " Bias: "+bias;
	}
	public void resetValues(){
		pip_value = 0;
		setSL(0);
		setTP(0);
	}
	public openTrades(String which,double quantity,double SL ,double TP,boolean sway){
		currency = which;
		pip_value = quantity;
		setSL(SL);
		setTP(TP);
		bias = sway;
		//String send_string = "Currency: "+which+"\nQuantity: "+pip_value+"\n Bias:"+sway;
		//try {
			//sendEmail.sendOnBrowser("New Trade Alert",send_string);
		//} catch (IOException | InterruptedException | AWTException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	}
	public static void trade(int how){
		
		//Run a new thread and when class is reached close the trade.
		ActionListeners.count c = new ActionListeners.count();
		c.howlong = 60*how;
		Thread correct = new Thread(c);
		correct.start();
	}
	public openTrades(){
		//Content of trade happens here in the constructor
		//pip_value = 0.89;
		//quantity = 7000;
		time = Check_time.printCurrentTime();	
		random_number = events.randomNumber(executeTrades.currency.length);
	}
	public static void main(String[] args) throws IOException {
	
	}

}
