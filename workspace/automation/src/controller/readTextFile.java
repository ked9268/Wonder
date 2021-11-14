package controller;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import trading.positions;

public class readTextFile {
	public static ArrayList<String> c = new ArrayList<String>();
	public static long length = 0;
	public static String readTextFile(String d) throws FileNotFoundException{
		File read_proper = new File(".\\src\\model\\database\\"+d);
		length = read_proper.length();
		Scanner scanner = new Scanner(read_proper);
		int counter = 0;
		//Can put into an array with the counter and the information!
		while((scanner.hasNextLine() == true)){
			counter = counter+1;
			c.add(scanner.nextLine());
		}
		scanner.close();
		return "";
	}
	public readTextFile(String d) throws FileNotFoundException{
		File read_proper = new File(".\\src\\model\\database\\"+d);
		length = read_proper.length();
		Scanner scanner = new Scanner(read_proper);
		int counter = 0;
		//Can put into an array with the counter and the information!
		while((scanner.hasNextLine() == true)){
			counter = counter+1;
			c.add(scanner.nextLine());
		}
		scanner.close();
		
	}
	public readTextFile() {
		// TODO Auto-generated constructor stub
	}
	public static String readFile(String d) throws IOException{
		File read_proper = new File(".\\src\\model\\database\\"+d);
		BufferedReader br = new BufferedReader(new FileReader(read_proper));
		StringBuffer sb = new StringBuffer();
		sb.append(br.readLine());
		String st;
		st = sb.toString();
		System.out.println(st);
		return "";
	}
	public static ArrayList<String> getList(){
		return c;
	}
	public void clearTextFile(String c) throws IOException{
		 FileWriter fileWriter = new FileWriter(".\\src\\model\\database\\"+c);
		 fileWriter.close();
	} 
	public static void writeToFile(String link,String attach) throws IOException{
		FileWriter write = new FileWriter(".\\src\\model\\database\\"+link);
		write.write(attach);
		write.close();
	}
	public static void recordResult(int quantity,int result,int currency,int direction) throws IOException{
		File delete = new File("C:\\Users\\ked\\Downloads\\Google Downloads\\TradingView.xlsx - MainPage.csv");
		FileWriter write = new FileWriter(delete,true);
		write.write(",\n-1,"+Check_time.printCurrentDate()+",10000,£3.50,USD/JPY,Buy,,");
		write.close();
	}
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
			readTextFile rt = new readTextFile();
			rt.readFile("gbpusd-forecast.txt");
			rt.readFile("eurusd-forecast.txt");
			//System.out.println(rt.getList());
			//rt.clearTextFile("gbpusd-forecast.txt");
			//System.out.println(rt.getList());
			//rt.writeToFile("gbpusd-forecast.txt","This is a completed writetoFile method");
			
	}
}
