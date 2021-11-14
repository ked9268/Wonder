package instagram;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
//import java.util.ArrayList;

//import automation.string_to_key_press;

public class hit_stormlikes_for_likes {
	//Method is not working
	//method is supposed to exploit stormlikes.com website.
	//Says we already used the free trial!
	static String string = "boycalledwonder";
	//static ArrayList website = new ArrayList();
	static String edge = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
	static Runtime run = Runtime.getRuntime();
	public static void main(String[] args) {
		try{
			//Coordinates to copy email from txt file may need to be recalibrated from time to time 
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_D);
		Thread.sleep(100);
		rb.mouseMove(983, 352);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(100);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseMove(589,203);	
		Thread.sleep(300);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseMove(1024,193);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(300);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_C);
		Thread.sleep(300);
		
		//Open browser
		run.exec(edge);
		Thread.sleep(5000);
		rb.keyPress(KeyEvent.VK_S);
		rb.keyRelease(KeyEvent.VK_S);
		Thread.sleep(1500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		//Navigate website
		Thread.sleep(12000);
		rb.mouseMove(516,583);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		//Enter name!
		/**
		for(int i =0; i < string.length(); i++){
			website.add(string_to_key_press.key_int(string.charAt(i)));
		}
		for(int i = 0; i < website.size();i++){
			rb.keyPress((int) website.get(i));
			rb.keyRelease((int) website.get(i));
		}
		**/
		Thread.sleep(2500);
		
		Thread.sleep(4000);
		rb.mouseMove(1354,216);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseMove(1354, 266);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseMove(671,624);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1500);
		rb.mouseMove(476, 594);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1500);
		rb.mouseMove(1358, 283);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1500);
		rb.mouseMove(1358, 550);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1500);
		rb.mouseMove(483, 397);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1500);
		rb.mouseMove(448, 556);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(1500);
		rb.mouseMove(672, 590);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(3000);
		rb.mouseMove(1335, 17);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
		catch(InterruptedException | AWTException | IOException e){
			}
		//}
	}	
}
