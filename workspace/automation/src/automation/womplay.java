package automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import controller.events;
import controller.string_to_key_press;

public class womplay {
	static Robot rb;
	public static void toSearch() throws AWTException, InterruptedException{
		rb = new Robot();
		events.sleep(2000);
		events.move(150, 250); //Get location main page search bar
		events.sleep(700);
		events.click();
		events.sleep(700);
		events.Tab(3);
	}
	public static void close() throws InterruptedException, AWTException{
		events.sleep(700);
		events.move(30,90);
		events.sleep(700);
		events.click();
	}
	public static void closeGamePopUp() throws AWTException, InterruptedException{
		events.sleep(700);
		events.move(975,160);
		events.sleep(700);
		events.click();
	}
	public static void startGame(int c) throws InterruptedException, AWTException{
		//All the way up to actual GamePlay.
		toSearch();
		events.sleep(700);
		if(c == 0){
			new string_to_key_press("tower rush");
		}
		else{
			new string_to_key_press("knife rain");
		}
		events.sleep(700);
		events.enter(1);
		events.move(250, 400); //Location of Game after Main page search
		events.sleep(700);
		events.click();
		events.sleep(4000);
		events.move(880, 620);
		events.sleep(700);
		events.click();
		events.sleep(3000);
		events.move(700,480);
		events.sleep(700);
		events.click();
	}
	public static class knife_rain{
		public knife_rain() throws AWTException, InterruptedException{
			startGame(1);
			events.sleep(30000);
			close();
			closeGamePopUp();
		}
		public static void play_game(){
			
		}
		public static void search() throws AWTException{
			new string_to_key_press("knife rain");
		}
		
	}
	public static class tower_rush{
		public tower_rush() throws AWTException, InterruptedException {
			startGame(0);
			events.sleep(30000);
			close();
			closeGamePopUp();
		}
	}
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		int counter = 0;
		boolean value = true;
		while(value){
			new tower_rush();
			new knife_rain();
				if(counter > 22){
					value = false;
					//events.shutdown();
				}
			counter = counter+1;
		}

	}

}
