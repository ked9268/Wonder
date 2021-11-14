package controller;

import java.util.Date;

import view.notification;

/*
 * Get and set methods in relation to time
 * as well as starting methods at sections of time
 * 
 * 
 * */
public class Check_time {
	static int secs = 0;
	static int mins = 0;
	static int hours = 0;
	static Date date;
	public static Boolean check_second = true;
	static Boolean check_minute = true;
	static Boolean check_hour = true;
	private static void check_hour(int check){
		int chec = check;
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");;
		String hour = receive.substring(8,10);
		String minute = receive.substring(11,13);
		String second = receive.substring(14,16);
		int hou = Integer.valueOf(hour);
		setHour(hou);
		int min = Integer.valueOf(minute);
		setMinute(min);
		int sec = Integer.valueOf(second);
		setSecond(sec);
		if (hou == chec){
			check_hour = false;
			System.out.println("Complete!");
			printCurrentTime();
		}
	}
	public static void check_minute(int check){
		try{
			Thread.sleep(60000);
		}
		catch(InterruptedException e){
			
		}
		int chec = check;
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");;
		String hour = receive.substring(8,10);
		String minute = receive.substring(11,13);
		String second = receive.substring(14,16);
		int min = Integer.valueOf(minute);
		setMinute(min);
		int hou = Integer.valueOf(hour);
		setHour(hou);
		if(min != chec){
		print_minute();
		}
		if(min == chec){ //Catch the minute at the right time.
			check_minute = false;
			notification.notif_check = false;
			setMinute(min);
			setHour(hou);
			System.out.println("Current hour and minute: "+hour+" : "+minute + " : " +second);
		}
	}
	public static void check_second(){
		check_second = true;
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");;
		String hour = receive.substring(8,10);
		String minute = receive.substring(11,13);
		String second = receive.substring(14,16);
		int sec = Integer.valueOf(second);
		int min = Integer.valueOf(minute);
		int hou = Integer.valueOf(hour);
		setHour(hou);
		setMinute(min);
		setSecond(sec);
		if(sec == 59){
			setMinute(min+1);
			setHour(hou);
			//print_minute();
			check_second = false;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static String getDate(){
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");
		String date = receive.substring(6,8);
		return date;
	}
	public static String getDay(){
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");
		String day = receive.substring(0,3);
		switch(day){
		case "Mon":
			return "Monday";
		case "Tue":
			return "Tuesday";
		case "Wed":
			return "Wednesday";
		case "Thu":
			return "Thursday";
		case "Fri":
			return "Friday";
		case "Sat":
			return "Saturday";
		case "Sun":
			return "Sunday";		
		}
		return day;
	}
	public static int getHour(){
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");
		String hour = receive.substring(8,10);
		int hou = Integer.valueOf(hour);
		setHour(hou);
		return hours;
	}
	public static int getMinute(){
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");
		String min = receive.substring(11,13);
		int minute = Integer.valueOf(min);
		setMinute(minute);
		return mins;
	}
	public static String getMonth(){
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");
		String month = receive.substring(3,6);
		String mon = "";
		switch(month){
			case "Jan":
				mon = "1";
				return "0"+"1";
			case "Feb":
				mon = "2";
				return "0"+"2";
			case "Mar":
				mon = "3";
				return "0"+"3";
			case "Apr":
				mon = "4";
				return "0"+"4";
			case "May":
				mon = "5";
				return "0"+"5";
			case "Jun":
				mon = "6";
				return "0"+"6";
			case "Jul":
				mon = "7";
				return "0"+"7";
			case "Aug":
				mon = "8";
				return "0"+"8";
			case "Sep":
				mon = "9";
				return "0"+"9";
			case "Oct":
				mon = "10";
				return "10";
			case "Nov":
				mon = "11";
				return "11";
			case "Dec":
				mon = "12";
				return "12";
		}
		return mon;
	}
	public static int getSecond(){
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");
		String second = receive.substring(14,16);
		secs = Integer.valueOf(second);
		return secs;
	}
	public static String printCurrentDate(){
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");
		String year = receive.substring(19,23);
		System.out.println(year);
		System.out.println(getDate());
		System.out.println(getMonth());
		return getDate()+"/"+getMonth()+"/"+year;
	}
	public static String printCurrentTime(){
		date = new Date();
		String receive = date.toString().replaceAll("\\s+","");
		String hour = receive.substring(8,10);
		String minute = receive.substring(11,13);
		String second = receive.substring(14,16);
		int sec = Integer.valueOf(second);
		int min = Integer.valueOf(minute);
		int hou = Integer.valueOf(hour);
		setHour(hou);
		setMinute(min);
		setSecond(sec);
		String correct = getHour() + " : "+ getMinute() + " : " + getSecond();
		return correct;
	}
	private static void print_minute(){
		System.out.println("Current hour and minute: "+getHour()+" : "+getMinute());
	}
	public static void setHour(int hour){
		hours = hour;
	}
	public static void setMinute(int min){
		mins = min;
	}
	public static void setSecond(int sec){
		secs = sec;
	}
	public static boolean start(){
		//Starts on the next hour 
		int start_hour = startOnTheHour(getHour()+1);
		while(check_second == true){
			check_second();
		}
		while(check_minute == true){
			System.out.println(start_hour);
			check_minute(0);
		}
		while(check_hour == true){
			check_hour(start_hour);
		}
		return true;
	}
	public static int startOnTheHour(int c){
		//Start at the next hour. Irrespective of minutes or seconds.
		
		if(c == 24){
			c = 0;
		}
		return c;
	}
	public static void startOnTheInterval() throws InterruptedException{
		//Returns action at 0,15,30,45 minutes hands.
		int start_minute = getMinute();
		if(start_minute > 0 & start_minute < 15){
			System.out.println(start_minute);
			Thread.sleep(60000);
			startOnTheInterval();
		}
		if(start_minute > 15 & start_minute < 30){
			System.out.println(start_minute);
			Thread.sleep(60000);
			startOnTheInterval();
		}
		if(start_minute > 30 & start_minute < 45){
			System.out.println(start_minute);
			Thread.sleep(60000);
			startOnTheInterval();
		}
		if(start_minute > 45 & start_minute < 60){
			System.out.println(start_minute);
			Thread.sleep(60000);
			startOnTheInterval();
		}
		else{
			System.out.println("Time is at 0,15,30 or 45 minute interval");
		}
	}
	public static void main(String[] args) throws InterruptedException {
	
		}
	}
