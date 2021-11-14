
package instagram;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
//import java.util.ArrayList;




import controller.events;
import controller.string_to_key_press;

public class hit_likigram_for_followers {
	/*Method exploits 50 free instagram followers from website likigram.com by automatically 
	filling in the form required to have the trial.
	*/
	//Slow down the loading so the program can load up programs and get things ready
	static String edge = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
	static Runtime run = Runtime.getRuntime();
	static String string = "boycalledwonder";
	static String[] emails = {"grimreaper-32@hotmail.co.uk","grimreaper32@hotmail.co.uk","kaide.josephwright@gmail.com"};
	//public static ArrayList website = new ArrayList(); 
	public static int current_keycode;
	public static void main(String[] args) throws AWTException,InterruptedException,IOException, URISyntaxException  {
		Robot rb = new Robot();
		//Fetch email and apply it to clipboard
		String myString = emails[0];
		StringSelection stringSelection = new StringSelection(myString);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		
		URI pic2txt = new URI("https://likigram.com/free-instagram-followers/");
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(pic2txt);
		Thread.sleep(10000);
		rb.mouseMove(427,455);
		events.click();
		//Enter username (boycalledwonder)!
		new string_to_key_press("boycalledwonder");	
		rb.mouseMove(890, 455); //Pass through to email address enter
		events.click();
		Thread.sleep(7500);
		
		
		rb.mouseMove(1356, 153);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseMove(1356, 200);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		
		Thread.sleep(5000);
		rb.mouseMove(450, 502); //Enter email address
		events.click();
		Thread.sleep(1000);
		//Paste email to enter email address part.
		events.paste();
		Thread.sleep(500);
		rb.mouseMove(469,558);
		events.click();
		Thread.sleep(2500);
		
		//Close browser!
		events.close_browser();
		
	}
}
