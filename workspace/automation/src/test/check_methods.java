package test;
import instagram.Instagram;

import java.awt.AWTException;
import java.awt.Color;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.events;
public class check_methods {
	public static Runtime run = Runtime.getRuntime();
	public static ArrayList<String> points = new ArrayList<String>();
	static String pivot;
	static boolean bias;
	
	public static void check_for_keyword(String d){
		if(d.contains("upside")){
			bias = true;
		}
		if(d.contains("downside")){
			bias = false;
		}
		System.out.println(bias);
	}
	public static String getBias(ArrayList<String> list,String c){
		//Only use when all has failed!
		int counter = 0;
		String pivot = "";
		if(c.equals("mostlikely")){
			while(counter < list.size()){
				String compare = list.get(counter);
				if(pivot.equals(compare)){
					continue;
				}
				if(Integer.parseInt(compare) > Integer.parseInt(pivot)){
					bias = false;
				}
				else{
					bias = true;
				}
			}
		}
		else{
			while(counter < list.size()){
				String compare = list.get(counter);
				if(pivot.equals(compare)){
					continue;
				}
				if(Integer.parseInt(compare) < Integer.parseInt(pivot)){
					bias = false;
				}
				else{
					bias = true;
				}
			}
		}
		if(bias == true){
			return "buy";
		}
		else{
			return "sell";
		}
	}
	public static void main(String[] args) throws InterruptedException, IOException, AWTException, URISyntaxException{			
	}
	
}
