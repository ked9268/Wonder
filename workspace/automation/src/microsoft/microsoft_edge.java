package microsoft;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.IOException;

import controller.events;
import model.Word;

public class microsoft_edge {
	Word word;
	static Robot rb;
	static int counter = 0;
	public microsoft_edge() throws FileNotFoundException{
		word = new Word();
	}
	public static void selectUA() throws AWTException, InterruptedException{
		events.new_tab();
		events.sleep(500);
		events.Tab(2);
		events.sleep(500);
		events.enter(1);
		events.sleep(500);
		rb.mouseMove(520, 310);
		events.sleep(200);
		events.click();
	}
	public static void search() throws InterruptedException, AWTException, IOException{
		events.sleep(500);
		events.moveToSearch();
		events.sleep(500);
		input.search();
	}
	public static void new_account() throws AWTException, InterruptedException{
		events.new_tab();
		events.sleep(500);
		events.Tab(5);
		events.sleep(500);
	}
	public static void run_input(int number_of_accounts,boolean if_multiple_choice ) throws IOException, InterruptedException, AWTException{
		rb = new Robot();
		events.open_edge();
		events.sleep(3000);
		events.click();
		events.sleep(800);
		events.fullScreen();
		events.sleep(500);
		counter = 0;
		while(counter < 34){
			search();
			counter = counter+1;
		}
		if (if_multiple_choice == false){
			
		}
		selectUA();
		counter = 0;
		while(counter < 21){
		search();
		counter = counter+1;
		
	}
		
	}
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		microsoft_edge me = new microsoft_edge();
		me.run_input(0,true);
		
	}

}
