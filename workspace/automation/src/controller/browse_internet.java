package controller;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class browse_internet {
	String [] websites  = {"facebook.com","reddit.com","youtube.com","Wikipedia.com",
			"twitter.com","instagram.com","google.com"};
	static Robot c;
	
	public browse_internet(){
		//Class constructor!
	}
	public static void openFacebook() throws URISyntaxException, IOException,InterruptedException{
		URI facebook = new URI("https://www.facebook.com/");
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(facebook);
		Thread.sleep(5000);
	}
	public static void scroll(int x,int y) throws AWTException,InterruptedException{
		c = new Robot();
		c.mouseMove(x,y);
		Thread.sleep(2000);
		c.mousePress(InputEvent.BUTTON2_MASK);
		Thread.sleep(2000);
		c.mouseMove(x,y+30);
		Thread.sleep(5000);
	}
	public static void selectContent(){
		//Select content to watch for a minute at a time.
		
	}
	public static void openTwitter(){
		
	}
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, AWTException {
		
		openFacebook();
		scroll(1100,500);
		/*
		 * Constantly loop between scroll and selectContent with a pause element
		 *  For a minute to hold this then escape character to back out of the content
		 * */
		//Run method constantly whilst watching videos and selecting tasks to interact with!
		
		
		events.close_browser();
	}

}
