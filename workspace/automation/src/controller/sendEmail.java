package controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;

public class sendEmail {
	Date date;
	public void send() throws AWTException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_S);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_S);
	}
	public void newmsg() throws AWTException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_N);
	}
	public static void sendOnBrowser(String subject,String message) throws IOException, InterruptedException, AWTException{
		Robot rb = new Robot();
		String myString = "https://www.fxstreet.com/economic-calendar";
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection(message);
		events.open_chrome();
		events.sleep(2000);
		events.fullScreen();
		events.sleep(1000);
		events.bookMarks();
		events.sleep(1000);
		events.Tab(3);
		Thread.sleep(1000);
		events.Down(3);
		events.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);	
		events.sleep(10000);
		//events.move(500, 500);
		//Thread.sleep(1000);
		//events.click();
		new string_to_key_press("c");
		events.sleep(4000);
		//send to?
		new string_to_key_press("ka");
		events.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		events.sleep(1000);
		events.Tab(1);
		//subject
		new string_to_key_press(subject);
		//
		events.Tab(1);
		//message content
		events.sleep(500);
		clipboard.setContents(stringSelection, null);
		events.sleep(500);
		events.paste();	
		//
		events.Tab(1);
		events.sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		events.sleep(5000);
		events.close_browser();
		
	}
	
	public void send_email(String cc_email, String message) throws AWTException, InterruptedException{
		//String myString = "https://www.fxstreet.com/economic-calendar";
		//String send_email = "kaide.josephwright@gmail.com";
		StringSelection stringSelection = new StringSelection(message);
		StringSelection stringSelect = new StringSelection(cc_email);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		events.open_mail();
		Thread.sleep(5000);
		Robot rb = new Robot();
		newmsg();
		Thread.sleep(3000);
		clipboard.setContents(stringSelect, null);
		Thread.sleep(500);
		events.paste();	
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		new string_to_key_press("Hello World!");
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(500);
		clipboard.setContents(stringSelection, null);
		Thread.sleep(500);
		events.paste();	
		Thread.sleep(500);
		send();
		events.close_browser();
	}
	public static void readLatestEmail() throws InterruptedException, AWTException, IOException{
		Robot rb = new Robot();
		events.open_gmail_on_chrome();
		events.sleep(2000);
		events.enter(1);
		events.sleep(600);
		readSubjectLine();
		events.backToProgram();
		new string_to_key_press("i");
		events.enter(1);
		//rb.mouseMove(200,200);
	}
	public static void readSubjectLine() throws InterruptedException, AWTException{
		events.sleep(2000);
		events.move(280, 200);
		events.sleep(600);
		events.mouseDrag(280, 200, 475, 200);
		events.copy();
		events.sleep(600);
		events.move(250,250);
	}
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		sendEmail send = new sendEmail();
		//send.readLatestEmail();
		//send.sendOnBrowser("This is confirm ","https://www.fxstreet.com/economic-calendar");
		System.out.println(Check_time.getDate());
		
		
	}

}
