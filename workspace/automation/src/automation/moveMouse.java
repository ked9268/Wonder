package automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;

import controller.events;

public class moveMouse {

	public moveMouse() throws AWTException, InterruptedException{
		int x = 500;
		int y = 500;
		Robot rb = new Robot();
		rb.mouseMove(x,y);
		while(true){
			x=x+5;
			Thread.sleep(1500);
			rb.mouseMove(x,y);
			x=x-5;
			Thread.sleep(1500);
			rb.mouseMove(x,y);
		}
	}
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		Thread.sleep(1500);
		//new moveMouse();
		events.shutdown();

	}

}
