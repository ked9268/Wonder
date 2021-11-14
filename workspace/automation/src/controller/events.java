package controller;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.ActionListeners.get_prices;
import automation.screenCoord;
import trading.positions;
import view.Mainview;
import microsoft.chrome_exploit;
import microsoft.input;
import model.tableLogic;

public class events {
	static String open_chrome = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
	static String open_firefox = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String open_edge = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe";
	static String open_paint = "C:\\WINDOWS\\system32\\mspaint.exe";
	static String open_notepad = "C:\\WINDOWS\\system32\\notepad.exe";
	static String open_capture2text = "C:\\Users\\ked\\Desktop\\automation\\Capture2Text\\Capture2Text.exe";
	public static Runtime run = Runtime.getRuntime();
	public static Boolean getTime = true;
		
	public static void backToProgram() throws AWTException, InterruptedException{
		//Back to program and copies input into the textField 
		events.sleep(1000);
		copy();
		Thread.sleep(4000);
		events.close_browser();
		Thread.sleep(1000);
		events.move(250,250);
		Thread.sleep(500);
		events.click();
		Thread.sleep(500);
		events.paste();
		Thread.sleep(500);
	}
	public static void bookMarks() throws InterruptedException, AWTException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyPress(KeyEvent.VK_O);
		Thread.sleep(500);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_SHIFT);
		rb.keyRelease(KeyEvent.VK_O);
	}
		//Load clicking feature of mouse to go forward
	public static void click() throws AWTException, InterruptedException{
			Thread.sleep(2000);
			Robot rb = new Robot();
			rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	public static void close_notepad() throws AWTException,InterruptedException{
		Robot rb = new Robot();
		rb.mouseMove(1235, 117);
		click();
		Thread.sleep(500);
		rb.mouseMove(715, 380);
		click();
	}
	public static void close_browser() throws InterruptedException,AWTException{
		Thread.sleep(5000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_F4);
		rb.keyRelease(KeyEvent.VK_ALT);
		rb.keyRelease(KeyEvent.VK_F4);;
	}	
	public static void closeTab() throws InterruptedException,AWTException{
		Thread.sleep(2000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_W);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_W);
		
	}
	public static void copy() throws AWTException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_C);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_C);
	}
	//Load desktop
	public static void desktop() throws AWTException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_D);
	}
	public static void Down(int c) throws AWTException, InterruptedException{
		Robot rb = new Robot();
		for(int i = 0;i < c; i++){
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
		}
	}
	public static void duplicateScreen() throws AWTException, InterruptedException{
		Robot rb = new Robot();
		events.desktop();
		sleep(1000);
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_I);
		sleep(500);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_I);
		sleep(500);
		fullScreen();
		sleep(3000);
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);
		sleep(1000);
		rb.keyPress(KeyEvent.VK_I);
		rb.keyRelease(KeyEvent.VK_I);
		sleep(1000);
		rb.keyPress(KeyEvent.VK_S);
		rb.keyRelease(KeyEvent.VK_S);
		sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		sleep(2000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		sleep(500);
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
		sleep(500);
		rb.mouseMove(523,596);
		sleep(500);
		click();
		sleep(500);
		rb.mouseMove(441, 554);
		sleep(500);
		click();
		sleep(500);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		sleep(500);
		click();
		close_browser();	
	}
	public static void enter(int c) throws AWTException, InterruptedException{
		Robot rb = new Robot();
		for(int i = 0;i < c; i++){
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
		}
	}
	public static void eurgbpforecastC() throws InterruptedException, IOException, AWTException{
		Robot rb = new Robot();
		Mainview.which = 3;
		events.openCapture2Text();
		events.open_chrome();
		Thread.sleep(2000);
		events.fullScreen();
		Thread.sleep(1000);
		events.bookMarks();
		Thread.sleep(1000);
		events.Tab(3);
		Thread.sleep(1000);
		events.Down(3);
		Thread.sleep(1000);
		enter(1);
		Thread.sleep(8000);
		rb.keyPress(KeyEvent.VK_SLASH);
		rb.keyRelease(KeyEvent.VK_SLASH);
		Thread.sleep(1000);
		new string_to_key_press("fxpro european ");
		Thread.sleep(2000);
		enter(1);
		Thread.sleep(2000);
		enter(1);
		Thread.sleep(2000);
		find();
		Thread.sleep(2000);
		new string_to_key_press("eur");
		Thread.sleep(1000);
		enter(8);
		Thread.sleep(1000);
		mouseDrag(480,493,800,612);
		backToProgram();
		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyRelease(KeyEvent.VK_SHIFT);
	}
	public static void eurusdforecastC() throws InterruptedException, IOException, AWTException{
		Robot rb = new Robot();
		Mainview.which = 4;
		events.openCapture2Text();
		events.open_chrome();
		Thread.sleep(2000);
		events.fullScreen();
		Thread.sleep(1000);
		events.bookMarks();
		Thread.sleep(1000);
		events.Tab(3);
		Thread.sleep(1000);
		events.Down(3);
		Thread.sleep(1000);
		enter(1);
		Thread.sleep(8000);
		rb.keyPress(KeyEvent.VK_SLASH);
		rb.keyRelease(KeyEvent.VK_SLASH);
		Thread.sleep(1000);
		new string_to_key_press("fxpro european");
		Thread.sleep(1500);
		enter(1);
		Thread.sleep(1000);
		enter(1);
		Thread.sleep(3000);
		find();
		Thread.sleep(1000);
		new string_to_key_press("most");
		Thread.sleep(1000);
		mouseDrag(480,493,800,612);
		backToProgram();
		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyRelease(KeyEvent.VK_SHIFT);
	}
	
	public static void extendScreen() throws AWTException, InterruptedException{
		Robot rb = new Robot();
		events.desktop();
		sleep(1000);
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_I);
		sleep(500);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_I);
		sleep(500);
		fullScreen();
		sleep(3000);
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);
		sleep(1000);
		rb.keyPress(KeyEvent.VK_I);
		rb.keyRelease(KeyEvent.VK_I);
		sleep(1000);
		rb.keyPress(KeyEvent.VK_S);
		rb.keyRelease(KeyEvent.VK_S);
		sleep(1000);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		sleep(2000);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		sleep(500);
		rb.keyPress(KeyEvent.VK_PAGE_DOWN);
		rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
		sleep(500);
		rb.mouseMove(523,596);
		sleep(500);
		click();
		sleep(500);
		rb.mouseMove(592,629);
		sleep(500);
		click();
		sleep(500);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		sleep(500);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		sleep(500);
		click();
		close_browser();
	}
	public static void find() throws AWTException, InterruptedException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_F);
		Thread.sleep(1000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_F);
	}
	public static void fullScreen() throws InterruptedException,AWTException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyPress(KeyEvent.VK_UP);
		Thread.sleep(200);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_UP);
	}

	public static void gbpusdforecastC() throws InterruptedException, IOException, AWTException{
		Robot rb = new Robot();
		Mainview.which = 1;
		events.openCapture2Text();
		events.open_chrome();
		Thread.sleep(2000);
		events.fullScreen();
		Thread.sleep(1000);
		events.bookMarks();
		Thread.sleep(1000);
		events.Tab(3);
		Thread.sleep(1000);
		events.Down(3);
		Thread.sleep(1000);
		enter(1);
		Thread.sleep(8000);
		rb.keyPress(KeyEvent.VK_SLASH);
		rb.keyRelease(KeyEvent.VK_SLASH);
		Thread.sleep(1000);
		new string_to_key_press("fxpro european ");
		Thread.sleep(1500);
		enter(1);
		Thread.sleep(1500);
		enter(1);
		Thread.sleep(3000);
		find();
		Thread.sleep(1500);
		new string_to_key_press("gbp");
		Thread.sleep(1000);
		enter(3);
		Thread.sleep(1000);
		mouseDrag(480,493,800,612);
		backToProgram();
		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyRelease(KeyEvent.VK_SHIFT);
	}
	public static void new_tab() throws AWTException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_T);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_T);
	}
	public static void nextApp() throws AWTException, InterruptedException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ALT);
		rb.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(600);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_ALT);
	} 
	public static void move(int x,int y) throws AWTException{
		Robot rb = new Robot();
		rb.mouseMove(x,y);
	}
	public static void mouseDrag(int a,int b,int c,int d) throws InterruptedException,AWTException{
		Thread.sleep(2000);
		Robot rb = new Robot();
		rb.mouseMove(a,b);
		rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		rb.mouseMove(c,d);
		rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	//Close browser 

	public static void moveToSearch() throws InterruptedException,AWTException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_E);
		Thread.sleep(200);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_E);
	}
	public static void openCapture2Text() throws IOException{
		run.exec(open_capture2text);
	}
	public static void open_chrome() throws IOException{	
		//OPen chrome
		run.exec(open_chrome);
	}
	//Open Microsoft edge
	public static void open_edge() throws IOException{
		run.exec(open_edge);
	}
	//Open FireFox
	public static void open_email_txt() throws IOException {
		File file = new File("C:\\Users\\ked\\Desktop\\email.txt");
		Desktop desktop = Desktop.getDesktop();
		desktop.open(file);
	}
	public static void open_firefox() throws IOException{
		run.exec(open_firefox);
	}
	public static void open_gmail_on_chrome() throws IOException, InterruptedException, AWTException{
		Robot rb = new Robot();
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
	}
	public static void open_notepad() throws IOException{
		run.exec(open_notepad);
	}
	//Open picture to text website.
	public static void open_picture_to_text() throws URISyntaxException, IOException{
		URI pic2txt = new URI("https://www.onlineocr.net/");
		Desktop desktop = Desktop.getDesktop();
		desktop.browse(pic2txt);
	}
	//Open Swagbucks website in firefox
	public static void open_swagbucks() throws InterruptedException,AWTException,IOException{
		Robot rb = new Robot();
		open_firefox();
		Thread.sleep(1000);
		new_tab();
		Thread.sleep(1000);
		rb.keyPress(KeyEvent.VK_S);
		rb.keyRelease(KeyEvent.VK_S);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	//Open Micosoft mail program!
	public static void open_mail() throws AWTException,InterruptedException{
		Robot rb = new Robot();
		desktop();
		rb.keyPress(KeyEvent.VK_WINDOWS);
		rb.keyRelease(KeyEvent.VK_WINDOWS);
		rb.mouseMove(235, 422);
		Thread.sleep(7500);
		click();
	}
	
	//Open Gmail on Google web browser 
	public static void open_mail_on_google() throws AWTException,InterruptedException,IOException{
		Robot rb = new Robot();
		open_chrome();
		rb.mouseMove(689, 513);
		Thread.sleep(500);
		click();
	}
	public static void open_paint() throws IOException{	
		run.exec(open_paint);
	}
	public static void paste() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
	}
	public static void previousTab() throws InterruptedException, AWTException{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_SHIFT);
		Thread.sleep(200);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_SHIFT);
	}
	public static void print_screen() throws InterruptedException, AWTException{
		Thread.sleep(5000);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_PRINTSCREEN);
		rb.keyRelease(KeyEvent.VK_PRINTSCREEN);
	}
	public static int randomNumber(int size){
		int rand = (int)Math.round(Math.random()*size);
		return rand;
	}
	public static void right_click() throws InterruptedException, AWTException{
		//Screenshot and put into paint file.
		Thread.sleep(2000);
		Robot rb = new Robot();
		rb.mouseMove(141, 287);
		rb.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		Thread.sleep(2000);
		rb.mouseMove(160, 360);
		events.click();
		mouseDrag(160,360,675,477);
		events.click();
		rb.mouseMove(538, 408);
		rb.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		rb.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		rb.mouseMove(624, 528);
		Thread.sleep(300);
		events.click();
		rb.keyPress(KeyEvent.VK_DELETE);
		rb.keyRelease(KeyEvent.VK_DELETE);
		Thread.sleep(300);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_S);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_S);
		Thread.sleep(300);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);		
	}
	public static void restart_get_prices(){
		get_prices.stop = false;
		events.getTime = true;
		get_prices gp = new get_prices();
		Thread tgp = new Thread(gp);
		tgp.start();
	}

	public static void shutdown() throws IOException, AWTException, InterruptedException{
		sleep(1500);
		run.exec("cmd.exe /c start");
		//events.open_notepad();
		Robot rb = new Robot();
		sleep(200);
		new string_to_key_press("shutdown ");
		sleep(200);
		rb.keyPress(KeyEvent.VK_SLASH);
		rb.keyRelease(KeyEvent.VK_SLASH);
		sleep(200);
		new string_to_key_press("s");
		enter(1);
	}
	public static void sleep(int c) throws InterruptedException{
		Thread.sleep(c);
	}
	public static void Tab(int c) throws AWTException, InterruptedException{
		Robot rb = new Robot();
		for(int i = 0;i < c; i++){
			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);
		}
	}
	public static String trim(String c){
		String check = c.replaceFirst("^\\s*", "");
		return check;
		
		/**
		 * Removes dots asweell
		 * String check = c.trim();
		check = check.replaceAll("\\W", "" );
		**/
	}
	public static void usdjpyforecastC() throws InterruptedException, IOException, AWTException{
		Robot rb = new Robot();
		Mainview.which = 2;
		events.openCapture2Text();
		events.open_chrome();
		Thread.sleep(2000);
		events.fullScreen();
		Thread.sleep(1000);
		events.bookMarks();
		Thread.sleep(1000);
		events.Tab(3);
		Thread.sleep(1000);
		events.Down(3);
		Thread.sleep(1000);
		enter(1);
		Thread.sleep(8000);
		rb.keyPress(KeyEvent.VK_SLASH);
		rb.keyRelease(KeyEvent.VK_SLASH);
		sleep(1000);
		new string_to_key_press("fxpro us");
		sleep(1500);
		enter(1);
		sleep(1500);
		enter(1);
		sleep(3000);
		find();
		Thread.sleep(1000);
		new string_to_key_press("jpy");
		Thread.sleep(1000);
		enter(1);
		Thread.sleep(1000);
		mouseDrag(480,493,800,612);
		backToProgram();
		rb.keyPress(KeyEvent.VK_SHIFT);
		rb.keyRelease(KeyEvent.VK_SHIFT);
		}
}