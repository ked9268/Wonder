package trading.currencies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import trading.executeTrades;
import controller.ActionListeners;
import controller.Check_time;
import controller.readTextFile;
import model.tableLogic;

public class usdjpy {
	//Have a check date for some of the methods.
	public static String pivot;
	public static String preDeterminedBias;
	public static String trendStrength;
	public static String bias;
	public static String stoploss;
	public static int take_profit;
	public static String firstTarget;
	public static String secondTarget;
	static String current_price;
	static String first_for_15;
	static String last_for_15;
	boolean use_forecast;
	static ArrayList<String> last15 = new ArrayList<String>();
	static ArrayList<String> last_hour = new ArrayList<String>();
	static int place;
	public usdjpy() throws IOException{
		//Sets predetermined bias and sets factors from the forecast!
		setPreDeterminedBias();
		printForecast();
		System.out.println("USD/JPY");
		readTextFile rt = new readTextFile("usdjpy-forecast.txt");
		String forecast = rt.getList().get(0);		
		String date_check = forecast.substring(forecast.indexOf("Date")+5,forecast.indexOf("Date")+9);

		setForecast();
		if(date_check.equals(Check_time.getDate()+Check_time.getMonth()) == true){
		
			use_forecast = true;
		}
		else{
			
			use_forecast = false;
		}
	}
	public void addToPrice(int place,String enter){
		int max_size = 14;
		int difference_for_15 = 0;
		last15.add(place,enter);
	}
	public static void printCurrentArray(){
		System.out.println(last15 +" ");
		System.out.println(last15.size() + "  Size");
	
	}
	public static void printForecast() throws IOException{
		readTextFile rt = new readTextFile();
		rt.readFile("usdjpy-forecast.txt");
	}
	public void setTrade() throws NumberFormatException, IOException{
		if(use_forecast == true){
			System.out.println("Set Trade");
			executeTrades.execute_trade(2,usdjpy.getBias());
		}
		else{
			//Get forecast are use a differnt method ie. Trend follwing or last time.
			System.out.println();
		}
	}
	public void setTradeByHowLong(int length){
		ActionListeners.count c = new ActionListeners.count();
		
		c.howlong = 60*length;
		//Place trade.
		//Can be based on pivot or on Manual trend following
		executeTrades.execute_trade(2,"sell");
		//Thread tm = new Thread(c);
		//tm.start();
	}
	/*
	 * 
	 * GET AND SET METHODS
	 * 
	 * */
	public static String getBias() throws NumberFormatException, IOException{
		//int result = tableLogic.convertStringtoInt(pivot)- tableLogic.convertStringtoInt(firstTarget);
		//int result = 4;
		if(pivot.length() != 0 && firstTarget.length() != 0){
			if(Integer.parseInt(pivot) < Integer.parseInt(firstTarget)){
				bias = "buy";
			}
			else {
				bias = "sell";
			}
			setStopLoss();
			setTakeProfit();
			return bias;
		}
		else{
			bias = "na";
			return bias;
		}
	}
	
	public String getCurrentPrice(){
		return current_price;
	}
	public static String getTrend(){
		int compare = 0;
		if(last_hour.size() == 1){
			compare = Integer.valueOf(last_hour.get(0));
			if(compare < -5){
				trendStrength = "buy";
			}
			if(compare > 5){
				trendStrength = "sell";
			}
		}
		if (last_hour.size() > 1){
			for(int i = last_hour.size() - 1 ;i > -1; i--){
				compare = Integer.valueOf(last_hour.get(i));
			}	
		}
		return "";
	}
	public static void setCurrentPrice(String current){		
		int current_place = getPlace();
		int difference_for_15;
		if(last15.size() == 15){
			System.out.println(last15);
			if(current_place != 14){
				current_price = current;
				last15.set(current_place,current);
				setPlace(current_place+1);
			}
			if(current_place == 0){
				first_for_15 = current;
				current_price = current;
				System.out.println(first_for_15 + " first for 15");
				System.out.println(last_hour);
			}
			if(current_place == 14){
					
				last15.set(current_place,current);
				current_price = current;
				setPlace(0);
				
				//Update for hour
				last_for_15 = current;
				
				difference_for_15 = tableLogic.convertStringtoInt(last_for_15) - tableLogic.convertStringtoInt(first_for_15);
				int add = last_hour.size();
				last_hour.add(add,String.valueOf(difference_for_15));
				System.out.println(last_hour);
			}
			
		}
		if(last15.size() != 15){
			if(current_place == 0){
				first_for_15 = current;
				current_price = current;
			}
			if(current_place == 14){
				System.out.println("current place 14");
				last_for_15 = current;
				current_price = current;
				difference_for_15 = tableLogic.convertStringtoInt(last_for_15) - tableLogic.convertStringtoInt(first_for_15);
				last_hour.add(last_hour.size(),String.valueOf(difference_for_15));
				last15.add(current_place,current);
				setPlace(0);
				printCurrentArray();
			}
			else{	
					current_price = current;
					last15.add(current_place,current);
					setPlace(current_place+1);
			}
		}
	}
	public void getElement(int c){
		System.out.println(last15.get(c));
	}
	public static String getFirstTarget(){
		return firstTarget;
	}
	public void setForecast() throws IOException{
		getpivot();
		getTarget();
		getBias();
	}
	public static String getpivot() throws IOException{
		String forecast;
		File read_proper = new File(".\\src\\model\\database\\"+"usdjpy-forecast.txt");
		readTextFile rt = new readTextFile();
		BufferedReader br = new BufferedReader(new FileReader(read_proper));
		StringBuffer sb = new StringBuffer();
		sb.append(br.readLine());
		forecast = sb.toString();
		pivot = forecast.substring(forecast.indexOf("Pivot")+6,forecast.indexOf("Bias")).trim();
		return pivot;	
	}
	
	public static void setPlace(int c){
		place = c;
	}
	public static  int getPlace(){
		return place;
	}
	public static String getPreDeterminedValue(){
		return preDeterminedBias;
	}
	public static void setPreDeterminedBias(){
		String day = Check_time.getDay();
		int hour = Check_time.getHour();
		//System.out.println(hour);
		//Specific day!
		if(day.equals("Monday") == true || day.equals("Sunday") == true){
			preDeterminedBias = "buy";
		}
		if(day.equals("Friday") == true){
			preDeterminedBias = "sell";
		}
		//Hour in the day
		if(hour >= 5 && hour <= 11){
			preDeterminedBias = "buy";
		}
		if(hour <= 21 && hour >= 4){
			preDeterminedBias = "sell";
		}
	}
	public static String getStopLoss(){
		return stoploss;
	}
	public static void setStopLoss() throws NumberFormatException, IOException{
		int pivot = Integer.valueOf(getpivot());
		int stop_loss;
		//System.out.println(pivot);
		//Needs to be set in comparison to the bias.
		
		if(bias.equals("buy")){
			stop_loss = pivot -20;
			stoploss = String.valueOf(stop_loss);
		}
		else{
			stop_loss = pivot +20;
			stoploss = String.valueOf(stop_loss);
		}
	}
	public static String getSecondTarget(){
		return secondTarget;
	}
	public int getSize(){
		return last_hour.size();
	}
	public static void setTakeProfit(){
		//******************/
		
		take_profit = Integer.parseInt(firstTarget);
	}
	public static int getTakeProfit(){
		return take_profit;
	}
	public static String getTarget() throws IOException{
		String forecast;
		File read_proper = new File(".\\src\\model\\database\\"+"usdjpy-forecast.txt");
		readTextFile rt = new readTextFile();
		BufferedReader br = new BufferedReader(new FileReader(read_proper));
		StringBuffer sb = new StringBuffer();
		sb.append(br.readLine());
		forecast = sb.toString();
		if(forecast.length() == 4){
			firstTarget = "";
			secondTarget = "";
		}
		else{
			firstTarget = forecast.substring(forecast.indexOf("TargetOne")+11,forecast.indexOf("TargetTwo")).trim();
			secondTarget = forecast.substring(forecast.indexOf("TargetTwo")+11,forecast.indexOf("Date")).trim();
		}
		return "";
	}
	public static void main(String[] args) throws IOException {
		usdjpy usdjpy = new usdjpy();
		
	}

}
