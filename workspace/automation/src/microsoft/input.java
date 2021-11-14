package microsoft;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import controller.events;
import controller.string_to_key_press;
import model.Word;
/**
 * 
 * Program is detailed to open Microsoft Bing in Firefox and complete entries 
 * for a certain amount of times to receive the microsoft reward
 *
 */
//Complete and ready for ship . Will have to change the counter in line with the rewards scheme 
public class input {
static Robot rb;
	static Word word;
	int counter = 0;
	public input() throws IOException, InterruptedException, AWTException{
		rb = new Robot();
		word = new Word();
		Thread.sleep(3000);
		//events.open_firefox();
		while(counter < 21){
			Thread.sleep(1000);
			events.moveToSearch();
			rb.keyPress(KeyEvent.VK_BACK_SPACE);
			rb.keyRelease(KeyEvent.VK_BACK_SPACE);
			rb.keyPress(KeyEvent.VK_BACK_SPACE);
			rb.keyRelease(KeyEvent.VK_BACK_SPACE);
			rb.keyPress(KeyEvent.VK_BACK_SPACE);
			rb.keyRelease(KeyEvent.VK_BACK_SPACE);
			search();
			counter = counter+1;
		}
		//events.extendScreen();
		//events.sleep(5000);
		
	}
	//Does the main body of work that allows the program to work.
	public static void search() throws IOException, InterruptedException, AWTException{
		//While true have it continually type and change questions for the engine.
		int c = (int) Math.round(100*Math.random());	
		if(c > 50){
			new string_to_key_press(Word.chooseWord());
			Thread.sleep(1000);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_SPACE);
			rb.keyRelease(KeyEvent.VK_SPACE);
			Thread.sleep(250);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
		}
		else{
		
			new string_to_key_press(Word.stageQuestion());
			Thread.sleep(1000);
			rb = new Robot();
			rb.keyPress(KeyEvent.VK_SPACE);
			rb.keyRelease(KeyEvent.VK_SPACE);
			Thread.sleep(250);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
		}
	}
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		//All the code needed to make this program work
		new input();
		
	}
	

}
