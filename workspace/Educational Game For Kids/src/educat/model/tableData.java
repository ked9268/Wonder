package educat.model;

import java.util.ArrayList;
import java.util.Arrays;

import educat.view.Leaderboard;

public class tableData {
	// Get information from a text File. using File classes
	public static String [] column_names = {"Name", "Score","Date taken"};
	public static String [][] data ={
			{"Test data ","End of Row",null},
			{"Second Row","End of Row",null},
			{"Third Row "," End of Row",null},
			{"Fourth Row","End of Row",null},
			{"Fifth data "," End of Row",null},
			{"Sixth Row","End of Row",null},
			{"Seventh data "," End of Row",null},
			{"8th Row","End of Row","10th Row"},
			{"Test data "," End of Row",null},
			{"Second Row","End of Row",null},
			{"Test data "," End of Row",null},
			{"Second Row","End of Row",null},
	};
	public static void main(String[] args) {
		System.out.println(data.length);
		Leaderboard lb = new Leaderboard();
		ArrayList c = new ArrayList(); 
		//ArrayLists because removing and adding is easier.
		for(int i = 0;i < data.length;i++){
			//System.out.println(data[i][0]);
			System.out.println(data[i][1]);
			c.add(data[i][0]);
		}
		System.out.println(Leaderboard.getRowCount());
		System.out.println(c);
		//c.remove(11);// Remove all instances when it gets deleted or add all instances.
		
		//System.out.println(c);
	}
}
