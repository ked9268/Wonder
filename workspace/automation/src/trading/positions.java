package trading;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import test.check_methods;
import view.Mainview;
import controller.Check_time;
import controller.events;
import controller.readTextFile;
import controller.string_to_key_press;
import model.tableLogic;
/**		Holds classes commonly used to execute the fetching of the forecast information. 
		Aswell as methods about how to make sense of this information
 *
 * 		@author ked
 *
 */
public class positions {
	String scalp_text_usdjpy = "";
	public static HashMap<String,String> firstFridays = new HashMap<String,String>();
	public static ArrayList<String> workable = new ArrayList<String>(); //Ints with decimal points
	public static ArrayList<Integer> scalable = new ArrayList<Integer>(); //Ints without decimal points
	public static ArrayList<String> points = new ArrayList<String>();
	public static ArrayList<String> output = new ArrayList<String>();
	
	public static void add(double c) throws IOException{
		int b = tableLogic.convertStringtoInt(Double.toString(c));
		scalable.add(b);
		writeToFile();
	}
	public static void append(String c){
		points.add(c);
		System.out.println(points.toString());
	}
	public static void clearTextFile(String c) throws IOException{
		 FileWriter fileWriter = new FileWriter(".\\src\\model\\database\\"+c);
		 fileWriter.close();
	} 
	public static void delete(int c){
		scalable.remove(c);
	}
	public static void method() throws IOException{
		if(scalable.size() >= 10){
			//Remove value at 0 and replace with new value. 
			workable.set(1,"105.34");
			//New value to get an add to the task.
			System.out.println(workable);
			
		}
		else{
			add(105.66);	
		}
	}
	//Open the website with the current price information
	public static void openusdjpy() throws URISyntaxException,IOException{
		URI usdjpy = new URI("https://uk.investing.com/currencies/usd-jpy");
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(usdjpy);
	}
	
	public static void opengbpusd() throws URISyntaxException,IOException{
		URI usdjpy = new URI("https://uk.investing.com/currencies/gbp-usd");
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(usdjpy);
	}
	public static void openeurusd() throws URISyntaxException,IOException{
		URI usdjpy = new URI("https://uk.investing.com/currencies/eur-usd");
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(usdjpy);
	}
	public static void openeurgbp() throws URISyntaxException,IOException{
		URI usdjpy = new URI("https://uk.investing.com/currencies/eur-gbp");
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(usdjpy);
	}
	//Open the raw text file
	public static void openusdjpytxt() throws IOException{
		File file = new File(".\\src\\model\\database\\usdjpy_scalp.txt");
		Desktop desktop = Desktop.getDesktop();
		desktop.open(file);
	}
	public static void opengbpusdtxt() throws IOException{
		File file = new File(".\\src\\model\\database\\gbpusd_scalp.txt");
		Desktop desktop = Desktop.getDesktop();
		desktop.open(file);
	}
	public static void putIntoArray(ArrayList<Integer> c,int d){
		c.add(d);
	}
	public static void writeToFile() throws IOException{
		Integer[] b = scalable.toArray(new Integer[scalable.size()]);	
		System.out.println(Arrays.toString(b));
		FileWriter file = new FileWriter(".\\src\\model\\database\\usdjpy_scalp.txt");
		for(int i = 0;i < b.length ; i++){
			file.write(tableLogic.convertIntToString(b[i]));
			file.write("\n");
		}
		file.close();
	}

	public static void getLastFive() throws FileNotFoundException{
		getTextFileInfo("usdjpy_scalp.txt");
		if(readTextFile.length > 1){
		for(int i =0;i <workable.size();i++){
			tableLogic.convertStringtoInt(workable.get(i));
			putIntoArray(scalable,tableLogic.convertStringtoInt(workable.get(i)));
		}
		}
		else{
			workable.add(0,"103.66"); //Get method to get the first price of the session
			System.out.println(workable);
			tableLogic.convertStringtoInt(workable.get(0));
			putIntoArray(scalable,tableLogic.convertStringtoInt(workable.get(0)));
		}
	}
	public static void getEURUSDPrice() throws URISyntaxException, IOException, AWTException, InterruptedException{
		Robot rb = new Robot();
		openeurusd();
		Thread.sleep(15000);
		rb.mouseMove(233, 310);
		events.mouseDrag(233, 310, 310, 315);
		events.copy();
		Thread.sleep(4000);
		events.close_browser();
	}
	public static void getEURGBPPrice() throws URISyntaxException, IOException, AWTException, InterruptedException{
		Robot rb = new Robot();
		openeurgbp();
		Thread.sleep(15000);
		rb.mouseMove(233, 310);
		events.mouseDrag(233, 310, 310, 315);
		events.copy();
		Thread.sleep(4000);
		events.close_browser();
	}
	public static void getGBPUSDPrice() throws URISyntaxException, IOException, AWTException, InterruptedException{
		Robot rb = new Robot();
		opengbpusd();
		Thread.sleep(15000);
		rb.mouseMove(233, 310);
		events.mouseDrag(233, 310, 310, 315);
		events.copy();
		Thread.sleep(4000);
		events.close_browser();
		Thread.sleep(1000);
	}
	public static void getUSDJPYPrice() throws URISyntaxException, IOException, AWTException, InterruptedException{
		Robot rb = new Robot();
		openusdjpy();
		Thread.sleep(15000);
		rb.mouseMove(233, 310);
		events.mouseDrag(233, 310, 310, 315);
		events.copy();
		Thread.sleep(4000);
		events.close_browser();
		Thread.sleep(1000);
	}
	public static void getTextFileInfo(String c) throws FileNotFoundException{
		//readTextFile rt = new readTextFile(c);
		//workable = rt.getList();
	//	System.out.println(workable);
	}
	public static void usdjpyforecast() throws AWTException, InterruptedException, IOException{
		//String ready for processing!.
		Robot rb = new Robot();
		events.openCapture2Text();
		Thread.sleep(5000);
		events.open_mail();
		Thread.sleep(7500);
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_UP);
		Thread.sleep(300);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(2500);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_E);
		Thread.sleep(300);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_E);
		
		
		rb.keyPress(KeyEvent.VK_U);
		rb.keyRelease(KeyEvent.VK_U);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_S);
		rb.keyRelease(KeyEvent.VK_S);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(8000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(15000);
		rb.mouseMove(887,486);// selects which hot link to follow!
		//Maybe make a method that constantly clicks that whole area!
		events.click();
		Thread.sleep(3000);
		rb.mouseMove(1189, 402);//
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_Q);
		Thread.sleep(1500);
		rb.keyRelease(KeyEvent.VK_Q);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		Thread.sleep(2000);
		rb.mouseMove(536, 220);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.mouseMove(632,338);
		Thread.sleep(1000);
		events.click();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
		events.copy();
		events.close_browser();
		Thread.sleep(1000);
		events.click();
		events.close_browser();
		
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(500);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rb.mouseMove(250,250);
		events.click();
		events.paste();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void gbpusdforecast() throws AWTException, IOException, InterruptedException{
		Robot rb = new Robot();
		events.openCapture2Text();
		Thread.sleep(5000);
		events.open_mail();
		Thread.sleep(7500);
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_UP);
		Thread.sleep(300);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(2500);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_E);
		Thread.sleep(300);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_E);
		Thread.sleep(300);
		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_U);
		rb.keyRelease(KeyEvent.VK_U);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_R);
		rb.keyRelease(KeyEvent.VK_R);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_O);
		rb.keyRelease(KeyEvent.VK_O);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_P);
		rb.keyRelease(KeyEvent.VK_P);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_A);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_N);
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(8000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(15000);
		rb.mouseMove(820,486);
		events.click();
		Thread.sleep(3000);
		rb.mouseMove(1189, 402);
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_Q);
		Thread.sleep(1500);
		rb.keyRelease(KeyEvent.VK_Q);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		Thread.sleep(2000);
		rb.mouseMove(536, 220);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rb.mouseMove(632, 338);
		events.click();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		Thread.sleep(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_A);
		events.copy();
		events.close_browser();
		Thread.sleep(1000);
		events.click();
		events.close_browser();
		
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(500);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		rb.mouseMove(250,250);
		events.click();
		events.paste();
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public static void saveLink() throws AWTException, InterruptedException{
		Robot rb = new Robot();
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_BACK_SLASH);;
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		new string_to_key_press("Users");
		rb.keyPress(KeyEvent.VK_BACK_SLASH);;
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		new string_to_key_press("ked");
		rb.keyPress(KeyEvent.VK_BACK_SLASH);;
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		new string_to_key_press("workspace");
		rb.keyPress(KeyEvent.VK_BACK_SLASH);;
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		new string_to_key_press("automation");
		rb.keyPress(KeyEvent.VK_BACK_SLASH);;
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		new string_to_key_press("src");
		rb.keyPress(KeyEvent.VK_BACK_SLASH);;
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		new string_to_key_press("model");
		rb.keyPress(KeyEvent.VK_BACK_SLASH);;
		rb.keyRelease(KeyEvent.VK_BACK_SLASH);
		new string_to_key_press("database");
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		new string_to_key_press("usdjpyforecastprop");
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void setNFP(){
	firstFridays.put("01","01");
	firstFridays.put("02","05");
	firstFridays.put("03","05");
	firstFridays.put("04","02");
	firstFridays.put("05","07");
	firstFridays.put("06","04");
	firstFridays.put("07","02");
	firstFridays.put("08","06");
	firstFridays.put("09","03");
	firstFridays.put("10","01");
	firstFridays.put("11","05");
	firstFridays.put("12","03");
	}
	public positions() throws FileNotFoundException{
		//Gets text file and puts it into variable workable which includes the decimal point.
		//getLastFive();
		setNFP();
	}
	public static void receiveForeCast(int d,String c) throws IOException{
		c = c.trim();
		String pivot = c.substring(0,c.indexOf("Most Likely Scenario"));
		String most_likely_scenario = c.substring(c.indexOf("Most Likely Scenario"),c.indexOf("Alternative scenario"));
		String alternative_scenario = c.substring(c.indexOf("Alternative scenario"));
		if(Mainview.which == 1){
			return_all(pivot,".");
			Mainview.gbpusd.pivot = points.get(0);
			points.clear();
			return_all(most_likely_scenario,".");
			getValuableInfo(points,output,Mainview.gbpusd.pivot);
			System.out.println(output);
			Mainview.gbpusd.firstTarget = output.get(0);
			if(output.size() > 1){
			Mainview.gbpusd.secondTarget = output.get(1);
			}
			points.clear();
			
			return_all(alternative_scenario,".");
			if(alternative_scenario.contains("short")){
				Mainview.gbpusd.bias = "sell";
			}
			else{
				Mainview.gbpusd.bias = "buy";
			}
			//Mainview.gbpusd.bias = check_methods.getBias(points,"");
			//points.clear();
			readTextFile read = new readTextFile("gbpusd-forecast.txt");
			read.clearTextFile("gbpusd-forecast.txt");
			String toTxt = ("Pivot: " + Mainview.gbpusd.pivot + " Bias: " +Mainview.gbpusd.bias+ " TargetOne: " + Mainview.gbpusd.firstTarget+" TargetTwo: " +Mainview.gbpusd.secondTarget 
					+ "Date " +Check_time.getDate() + Check_time.getMonth());
			System.out.println(toTxt);
			read.writeToFile("gbpusd-forecast.txt", toTxt);
			Mainview.gbpusd.setForecast();
			
		}
		if(Mainview.which == 2){
			return_allJPY(pivot,".");
			Mainview.usdjpy.pivot = points.get(0);
			points.clear();
			return_allJPY(most_likely_scenario,".");	
			getValuableInfo(points,output,Mainview.usdjpy.pivot);	
			System.out.println(output);
			Mainview.usdjpy.firstTarget = output.get(0);
			if(output.size() > 1){
			Mainview.usdjpy.secondTarget = output.get(1);
			}
			points.clear();
			//System.out.println(Mainview.gbpusd.firstTarget);
			
			return_all(alternative_scenario,".");
			if(alternative_scenario.contains("short")){
				Mainview.usdjpy.bias = "sell";
			}
			else{
				Mainview.usdjpy.bias = "buy";
			}
			//Mainview.gbpusd.bias = check_methods.getBias(points,"");
			//points.clear();
			readTextFile read = new readTextFile("usdjpy-forecast.txt");
			read.clearTextFile("usdjpy-forecast.txt");
			String toTxt = ("Pivot: " + Mainview.usdjpy.pivot + " Bias: " +Mainview.usdjpy.bias+ " TargetOne: " + Mainview.usdjpy.firstTarget+" TargetTwo: " +Mainview.usdjpy.secondTarget 
					+ " Date " +Check_time.getDate() + Check_time.getMonth());
			System.out.println(toTxt);
			read.writeToFile("usdjpy-forecast.txt", toTxt);
			Mainview.usdjpy.setForecast();
		}
		if(Mainview.which == 3){
			return_all(pivot,".");
			Mainview.eurgbp.pivot = points.get(0);
			points.clear();
			return_all(most_likely_scenario,".");
			getValuableInfo(points,output,Mainview.eurgbp.pivot);
			if(points.size() == 1 &&points.get(0).equals(Mainview.eurgbp.pivot)){
				//Get from alternative
				points.clear();
				//System.out.println(Mainview.gbpusd.firstTarget);
				return_all(alternative_scenario,".");
				getValuableInfo(points,output,Mainview.eurgbp.pivot);
				int compare = Integer.valueOf(points.get(0));
				Mainview.eurgbp.firstTarget = "";
				Mainview.eurgbp.secondTarget = "";
				if(alternative_scenario.contains("short")){
					Mainview.eurgbp.bias = "sell";
				}
				else{
					Mainview.eurgbp.bias = "buy";
				}
				if(compare > Integer.valueOf(Mainview.eurgbp.pivot)){
					Mainview.eurgbp.bias = "sell";
				}
				else{
					Mainview.eurgbp.bias = "buy";
				}
			}
			else{
				Mainview.eurgbp.firstTarget = output.get(0);
				if(Integer.valueOf(Mainview.eurgbp.firstTarget) > Integer.valueOf(Mainview.eurgbp.pivot)){
					Mainview.eurgbp.bias = "buy";
				}
				else{
					Mainview.eurgbp.bias = "sell";
				}
				if(output.size() > 1){
					Mainview.eurgbp.secondTarget = output.get(1);
				}
			}
			points.clear();
			//System.out.println(Mainview.gbpusd.firstTarget);
			
			
			//Mainview.gbpusd.bias = check_methods.getBias(points,"");
			//points.clear();
			readTextFile read = new readTextFile("eurgbp-forecast.txt");
			read.clearTextFile("eurgbp-forecast.txt");
			String toTxt = ("Pivot: " + Mainview.eurgbp.pivot + " Bias: " +Mainview.eurgbp.bias+ " TargetOne: " + Mainview.eurgbp.firstTarget+" TargetTwo: " +Mainview.eurgbp.secondTarget 
					+ "Date " +Check_time.getDate() + Check_time.getMonth());
			System.out.println(toTxt);
			read.writeToFile("eurgbp-forecast.txt", toTxt);
			Mainview.eurgbp.setForecast();
		}
		if(Mainview.which == 4){
			return_all(pivot,".");
			Mainview.eurusd.pivot = points.get(0);
			points.clear();
			return_all(most_likely_scenario,".");
			getValuableInfo(points,output,Mainview.eurusd.pivot);	
			Mainview.eurusd.firstTarget = output.get(0);
			if(output.size() > 1){
			Mainview.eurusd.secondTarget = output.get(1);
			}
			points.clear();
			//System.out.println(Mainview.gbpusd.firstTarget);
			
			return_all(alternative_scenario,".");
			if(alternative_scenario.contains("short")){
				Mainview.eurusd.bias = "sell";
			}
			else{
				Mainview.eurusd.bias = "buy";
			}
			//Mainview.gbpusd.bias = check_methods.getBias(points,"");
			//points.clear();
			readTextFile read = new readTextFile("eurusd-forecast.txt");
			read.clearTextFile("eurusd-forecast.txt");
			String toTxt = ("Pivot: " + Mainview.eurusd.pivot + " Bias: " +Mainview.eurusd.bias+ " TargetOne: " + Mainview.eurusd.firstTarget+" TargetTwo: " +Mainview.eurusd.secondTarget 
					+ "Date " +Check_time.getDate() + Check_time.getMonth());
			System.out.println(toTxt);
			read.writeToFile("eurusd-forecast.txt", toTxt);
			Mainview.eurusd.setForecast();
		}
	}
	public static void getValuableInfo(ArrayList<String> list,ArrayList<String> output,String pivot){
		int counter = 0;
		while(counter < list.size()){
			if(pivot.equals(list.get(counter))){
				counter++;
				//Set bias from alternative!
				continue;			
			}
			else{
				output.add(list.get(counter));
				counter++;
			}
		}
	}
	public static void return_allJPY(String d, String look ){
	String c = "";	
	String work = "";
	int dot;
		try{
			if(d.contains("Alternative scenario")){
				work = d.substring(d.indexOf("Alternative scenario"),d.indexOf("Comment"));
				//System.out.println(work);
				dot = work.indexOf(look);
				if(work.contains(look) == true){
					
					//System.out.println(work.substring(work.indexOf(look)));
					
					points.add(work.substring((dot-4),dot)+work.substring((dot+1),(dot+3)));
					c = work.substring((dot+3));
				}
				c = work.substring((dot+3));
				return_allJPY(c,".");
			}
			else{
				if(d.length() < 4){
					
				}
				if(d.contains(".") == true){
					dot = d.indexOf(".");
					//System.out.println(dot);
					//System.out.println(work.substring(work.indexOf(look)));
					//System.out.println(d.substring((dot-1),dot)+d.substring((dot+1),(dot+5)));
					points.add(d.substring((dot-4),dot)+d.substring((dot+1),(dot+3)));
					c = d.substring((dot+3));
					return_allJPY(c,".");
				}							
			} 
			}catch(StringIndexOutOfBoundsException e){    }			
	}
	public static void return_all(String d, String look ){
		//	   	Our pivot point is at 0.8931.  Most Likely Scenario: the downside prevails as long as 0.8931 is resistance.  Alternative scenario: above 0.8931, look for 0.8963 and 0.8982.  Comment
	String c = "";
	
	String work = "";
	int dot;
		try{
			if(d.contains("Alternative scenario")){
				work = d.substring(d.indexOf("Alternative scenario"),d.indexOf("Comment"));
				//System.out.println(work);
				dot = work.indexOf(look);
				if(work.contains(look) == true){
					
					//System.out.println(work.substring(work.indexOf(look)));
					
					points.add(work.substring((dot-1),dot)+work.substring((dot+1),(dot+5)));
					c = work.substring((dot+5));
				}
				c = work.substring((dot+5));
				return_all(c,".");
			}
			else{
				if(d.length() < 4){
					
				}
				if(d.contains(".") == true){
					dot = d.indexOf(".");
					
					//System.out.println(work.substring(work.indexOf(look)));
					
					points.add(d.substring((dot-1),dot)+d.substring((dot+1),(dot+5)));
					c = d.substring((dot+5));
					return_all(c,".");
				}							
			} 
			}catch(StringIndexOutOfBoundsException e){    }			
	}
	
	public static void receiveForcast(int d,String c) throws IOException{
		//How does the program make use of this information? 
		System.out.println(c);
		
		String check = c.trim();
		check = check.replaceAll("\\W", "" );
		int start = check.indexOf("Pivot") + 5;
		int end = start + 5;
		String pivot = check.substring(check.indexOf("Pivot"),check.indexOf("MostLikelyScenario"));
		int bias_start = check.indexOf("MostLikelyScenario")+ 18;
		int bias_end = bias_start + 5;
		String bias_check = check.substring(bias_start,bias_end);
		String bias;
		if(bias_check.charAt(4) == 't'){
			bias = "Short";
		}
		else{
			bias = "Long";
		}		
		int most_likely_target_start_one = check.indexOf("targets") + 9;
		int most_likely_target_end_one = most_likely_target_start_one + 5;
		String target_one = check.substring(most_likely_target_start_one,most_likely_target_end_one);
		int most_likely_target_start_two = most_likely_target_end_one;
		int most_likely_target_end_two = most_likely_target_start_two + 5;
		String target_two = check.substring(most_likely_target_start_two,most_likely_target_end_two);
		if(Mainview.which == 1){
			Mainview.gbpusd.pivot = pivot;
			Mainview.gbpusd.bias = bias;
			Mainview.gbpusd.firstTarget = target_one;
			Mainview.gbpusd.secondTarget = target_two;
			readTextFile read = new readTextFile("gbpusd-forecast.txt");
			read.clearTextFile("gbpusd-forecast.txt");
			String toTxt = ("Pivot: " + pivot + " Bias: " + " TargetOne: " + target_one+" TargetTwo: " +target_two 
					+ "Date " +Check_time.getDate() + Check_time.getMonth());
			System.out.println(toTxt);
			read.writeToFile("gbpusd-forecast.txt", toTxt);
			Mainview.gbpusd.setForecast();
		}
		if(Mainview.which == 2){
			Mainview.usdjpy.pivot = pivot;
			Mainview.usdjpy.bias = bias;
			Mainview.usdjpy.firstTarget = target_one;
			Mainview.usdjpy.secondTarget = target_two;
			
			//Adds new data to text files.
			readTextFile read = new readTextFile("usdjpy-forecast.txt");
			read.clearTextFile("usdjpy-forecast.txt");
			String toTxt = ("Pivot: " + pivot + " Bias: " + " TargetOne: " + target_one+" TargetTwo: " +target_two 
					+ "Date " +Check_time.getDate() + Check_time.getMonth());
			System.out.println(toTxt);
			read.writeToFile("usdjpy-forecast.txt", toTxt);
			Mainview.usdjpy.setForecast();
		}
		if(Mainview.which == 3){	
			//	   	Our pivot point is at 0.8931.  Most Likely Scenario: the downside prevails as long as 0.8931 is resistance.  Alternative scenario: above 0.8931, look for 0.8963 and 0.8982.  Comment
			pivot = c.substring(0,c.indexOf("Most Likely Scenario"));
			int dot = pivot.indexOf(".");
			
			Mainview.eurgbp.pivot = pivot.substring((dot-1),dot)+pivot.substring((dot+1),(dot+5)); //pivot
			//String pivot_return = pivot.substring(pivot.indexOf(".")-1) + pivot.indexOf(pivot.indexOf("."),pivot.indexOf(".")+5);
			//System.out.println(pivot_return);
			//Mainview.eurgbp.pivot = pivot_return;
			System.out.println(Mainview.eurgbp.pivot);
			pivot = c.substring(c.indexOf("Most Likely Scenario"),c.indexOf("Alternative scenario"));
			dot = pivot.indexOf(".");
			Mainview.eurgbp.firstTarget = pivot.substring((dot-1),dot)+pivot.substring((dot+1),(dot+5));
			System.out.println(Mainview.eurgbp.firstTarget);
			if(Mainview.eurgbp.pivot.equals(Mainview.eurgbp.firstTarget)){
				pivot = c.substring(c.indexOf("Alternative scenario"));
				System.out.println(pivot);
			}
			//Mainview.eurgbp.secondTarget = target_two;
			//bias = Mainview.eurgbp.getBias();
			//readTextFile read = new readTextFile("eurgbp-forecast.txt");
			//read.clearTextFile("eurgbp-forecast.txt");
			//bias = Mainview.eurgbp.getBias();
			//String toTxt = ("Pivot: " + Mainview.eurgbp.pivot + " Bias: " +bias +" TargetOne: " + Mainview.eurgbp.firstTarget+" TargetTwo: " +Mainview.eurgbp.secondTarget 
					//+ "Date " +Check_time.getDate() + Check_time.getMonth());
			////System.out.println(toTxt);
			//read.writeToFile("eurgbp-forecast.txt", toTxt);
			//Mainview.eurgbp.setForecast();
			
		}
		if(Mainview.which == 4){
			Mainview.eurusd.pivot = pivot;
			Mainview.eurusd.bias = bias;
			Mainview.eurusd.firstTarget = target_one;
			Mainview.eurusd.secondTarget = target_two;
			readTextFile read = new readTextFile("eurusd-forecast.txt");
			read.clearTextFile("eurusd-forecast.txt");
			String toTxt = ("Pivot: " + pivot + " Bias: " + " TargetOne: " + target_one+" TargetTwo: " +target_two 
					+ "Date " +Check_time.getDate() + Check_time.getMonth());
			System.out.println(toTxt);
			read.writeToFile("eurusd-forecast.txt", toTxt);
			Mainview.eurusd.setForecast();
		}
	}
	public static void main(String[] args) throws URISyntaxException, IOException,AWTException, InterruptedException {
		
	}

}
