package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class readCSVFile {
	//Loss/Gain,Date,Quantity,Result,Currency,Direction,AverageP,CloseP
	static String copy;
	public static void main(String[] args) throws IOException {
		// String form!
		File delete = new File("C:\\Users\\ked\\Downloads\\Google Downloads\\TradingView.xlsx - MainPage.csv");
		Scanner c = new Scanner(delete);
		while(c.hasNextLine()){
			System.out.println(c.nextLine());
		}
		c.close();
		FileWriter write = new FileWriter(delete,true);
		//read.close();
		write.write(",\n-1,29/12/2020,10000,£3.50,USD/JPY,Buy,,");
		write.close();
	}

}
