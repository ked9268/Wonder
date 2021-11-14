package controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
//import instagram.hit_likigram_for_followers;

public class string_to_key_press {
		/*
		 * CONVERTS A GIVEN STRING INTO A KEY PRESS BY THE Java.awt.Robot class.
		 * 
		 * 
		 * 
		 * */
	public static void search(String c){
		char compare = c.charAt(0);
		int last_index = c.length() - 1;
		System.out.println("Index number of last number: "+last_index);
		System.out.println("Length of whole string: "+c.length());
		for(int i=0; i <= last_index; i++){
			compare = c.charAt(i);
			key(compare);
		}
	}
	public string_to_key_press(String c) throws AWTException{
		for(int i =0; i < c.length(); i++){
			string_to_key(c.charAt(i));
		}
	}
	public static void string_to_key(char c) throws AWTException{
		Robot rb = new Robot();
		switch(c){
			case 'a':
				rb.keyPress(KeyEvent.VK_A);
				rb.keyRelease(KeyEvent.VK_A);	
				break;
			case 'b':
				rb.keyPress(KeyEvent.VK_B);
				rb.keyRelease(KeyEvent.VK_B);
				break;
			case 'c':
				rb.keyPress(KeyEvent.VK_C);
				rb.keyRelease(KeyEvent.VK_C);
				break;
			case 'd':
				rb.keyPress(KeyEvent.VK_D);
				rb.keyRelease(KeyEvent.VK_D);
				break;
			case 'e':
				rb.keyPress(KeyEvent.VK_E);
				rb.keyRelease(KeyEvent.VK_E);
				break;
			case 'f':
				rb.keyPress(KeyEvent.VK_F);
				rb.keyRelease(KeyEvent.VK_F);
				break;
			case 'g':
				rb.keyPress(KeyEvent.VK_G);
				rb.keyRelease(KeyEvent.VK_G);
				break;
			case 'h':
				rb.keyPress(KeyEvent.VK_H);
				rb.keyRelease(KeyEvent.VK_H);
				break;
			case 'i':
				rb.keyPress(KeyEvent.VK_I);
				rb.keyRelease(KeyEvent.VK_I);
				break;
			case 'j':
				rb.keyPress(KeyEvent.VK_J);
				rb.keyRelease(KeyEvent.VK_J);
				break;
			case 'k':
				rb.keyPress(KeyEvent.VK_K);
				rb.keyRelease(KeyEvent.VK_K);
				break;
			case 'l':
				rb.keyPress(KeyEvent.VK_L);
				rb.keyRelease(KeyEvent.VK_L);
				break;
			case 'm':
				rb.keyPress(KeyEvent.VK_M);
				rb.keyRelease(KeyEvent.VK_M);
				break;
			case 'n':
				rb.keyPress(KeyEvent.VK_N);
				rb.keyRelease(KeyEvent.VK_N);
				break;
			case 'o':
				rb.keyPress(KeyEvent.VK_O);
				rb.keyRelease(KeyEvent.VK_O);
				break;
			case 'p':
				rb.keyPress(KeyEvent.VK_P);
				rb.keyRelease(KeyEvent.VK_P);
				break;
			case 'q':
				rb.keyPress(KeyEvent.VK_Q);
				rb.keyRelease(KeyEvent.VK_Q);
				break;
			case 'r':
				rb.keyPress(KeyEvent.VK_R);
				rb.keyRelease(KeyEvent.VK_R);
				break;
			case 's':
				rb.keyPress(KeyEvent.VK_S);
				rb.keyRelease(KeyEvent.VK_S);
				break;
			case 't':
				rb.keyPress(KeyEvent.VK_T);
				rb.keyRelease(KeyEvent.VK_T);
				break;
			case 'u':
				rb.keyPress(KeyEvent.VK_U);
				rb.keyRelease(KeyEvent.VK_U);
				break;
			case 'v':
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_V);
				break;
			case 'w':
				rb.keyPress(KeyEvent.VK_W);
				rb.keyRelease(KeyEvent.VK_W);
				break;
			case 'x':
				rb.keyPress(KeyEvent.VK_X);
				rb.keyRelease(KeyEvent.VK_X);
				break;
			case 'y':
				rb.keyPress(KeyEvent.VK_Y);
				rb.keyRelease(KeyEvent.VK_Y);
				break;
			case 'z':
				rb.keyPress(KeyEvent.VK_Z);
				rb.keyRelease(KeyEvent.VK_Z);
				break;
		///////////////////////
			case 'A':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_A);
				rb.keyRelease(KeyEvent.VK_A);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);	
				break;
			case 'B':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_B);
				rb.keyRelease(KeyEvent.VK_B);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'C':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_C);
				rb.keyRelease(KeyEvent.VK_C);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'D':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_D);
				rb.keyRelease(KeyEvent.VK_D);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'E':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_E);
				rb.keyRelease(KeyEvent.VK_E);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'F':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_F);
				rb.keyRelease(KeyEvent.VK_F);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'G':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_G);
				rb.keyRelease(KeyEvent.VK_G);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'H':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_H);
				rb.keyRelease(KeyEvent.VK_H);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'I':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_I);
				rb.keyRelease(KeyEvent.VK_I);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'J':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_J);
				rb.keyRelease(KeyEvent.VK_J);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'K':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_K);
				rb.keyRelease(KeyEvent.VK_K);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'L':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_L);
				rb.keyRelease(KeyEvent.VK_L);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'M':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_M);
				rb.keyRelease(KeyEvent.VK_M);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'N':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_N);
				rb.keyRelease(KeyEvent.VK_N);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'O':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_O);
				rb.keyRelease(KeyEvent.VK_O);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'P':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_P);
				rb.keyRelease(KeyEvent.VK_P);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'Q':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_Q);
				rb.keyRelease(KeyEvent.VK_Q);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'R':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_R);
				rb.keyRelease(KeyEvent.VK_R);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'S':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_S);
				rb.keyRelease(KeyEvent.VK_S);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'T':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_T);
				rb.keyRelease(KeyEvent.VK_T);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'U':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_U);
				rb.keyRelease(KeyEvent.VK_U);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'V':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_V);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'W':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_W);
				rb.keyRelease(KeyEvent.VK_W);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'X':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_X);
				rb.keyRelease(KeyEvent.VK_X);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'Y':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_Y);
				rb.keyRelease(KeyEvent.VK_Y);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			case 'Z':
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				rb.keyPress(KeyEvent.VK_Z);
				rb.keyRelease(KeyEvent.VK_Z);
				rb.keyPress(KeyEvent.VK_CAPS_LOCK);
				rb.keyRelease(KeyEvent.VK_CAPS_LOCK);
				break;
			/////////////////////////////////
			case '0':
				rb.keyPress(KeyEvent.VK_0);
				rb.keyRelease(KeyEvent.VK_0);
			case '1':		
				rb.keyPress(KeyEvent.VK_1);
				rb.keyRelease(KeyEvent.VK_1);
			case '2':
				rb.keyPress(KeyEvent.VK_2);
				rb.keyRelease(KeyEvent.VK_2);	
			case '3':
				rb.keyPress(KeyEvent.VK_3);
				rb.keyRelease(KeyEvent.VK_3);
			case '4':
				rb.keyPress(KeyEvent.VK_4);
				rb.keyRelease(KeyEvent.VK_4);
			case '5':
				rb.keyPress(KeyEvent.VK_5);
				rb.keyRelease(KeyEvent.VK_5);
			case '6':
				rb.keyPress(KeyEvent.VK_6);
				rb.keyRelease(KeyEvent.VK_6);
			case '7':
				rb.keyPress(KeyEvent.VK_7);
				rb.keyRelease(KeyEvent.VK_7);
			case '8':
				rb.keyPress(KeyEvent.VK_8);
				rb.keyRelease(KeyEvent.VK_8);
			case '9':
				rb.keyPress(KeyEvent.VK_9);
				rb.keyRelease(KeyEvent.VK_9);
			/*
			 * SPECIAL CHARACTERS
			 * */
			case '.':
				rb.keyPress(KeyEvent.VK_PERIOD);
				rb.keyRelease(KeyEvent.VK_PERIOD);
			case '?':
				rb.keyPress(KeyEvent.VK_SHIFT);
				rb.keyPress(KeyEvent.VK_SLASH);
				rb.keyRelease(KeyEvent.VK_SHIFT);
				rb.keyRelease(KeyEvent.VK_SLASH);
			case ':':
				rb.keyPress(KeyEvent.VK_COLON);
				rb.keyRelease(KeyEvent.VK_COLON);
			case '/':
				rb.keyPress(KeyEvent.VK_SLASH);
				rb.keyRelease(KeyEvent.VK_SLASH);
			case '\\':
				rb.keyPress(KeyEvent.VK_BACK_SLASH);
				rb.keyRelease(KeyEvent.VK_BACK_SLASH);
			case ' ':
				rb.keyPress(KeyEvent.VK_SPACE);
				rb.keyRelease(KeyEvent.VK_SPACE);
			
		}
		
	}
	public static int key_int(char e){
		switch(e){
		case 'a':
			return 65;
		case 'b':
			return 66;
		case 'c':
			return 67;
		case 'd':
			return 68;
		case 'e':
			return 69;
		case 'f':
			return 70;
		case 'g':
			return 71;
		case 'h':
			return 72;
		case 'i':
			return 73;
		case 'j':
			return 74;
		case 'k':
			return 75;
		case 'l':
			return 76;
		case 'm':
			return 77;
		case 'n':
			return 78;
		case 'o':
			return 79;
		case 'p':
			return 80;
		case 'q':
			return 81;
		case 'r':
			return 82;
		case 's':
			return 83;
		case 't':
			return 84;
		case 'u':
			return 85;
		case 'v':
			return 86;
		case 'w':
			return 87;
		case 'x':
			return 88;
		case 'y':
			return 89;
		case 'z':
			return 90;
		/**
		 *UPPER CASE 
		 * 
		 */
		case 'A':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(65);
			return 16;
		case 'B':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(66);
			return 16;
		case 'C':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(67);
			return 16;
		case 'D':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(68);
			return 16;
		case 'E':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(69);
			return 16;
		case 'F':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(70);
			return 16;
		case 'G':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(71);
			return 16;
		case 'H':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(72);
			return 16;
		case 'I':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(73);
			return 16;
		case 'J':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(74);
			return 16;
		case 'K':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(75);
			return 16;
		case 'L':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(76);
			return 16;
		case 'M':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(77);
			return 16;
		case 'N':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(78);
			return 16;
		case 'O':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(79);
			return 16;
		case 'P':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(80);
			return 16;
		case 'Q':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(81);
			return 16;
		case 'R':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(82);
			return 16;
		case 'S':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(83);
			return 16;
		case 'T':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(84);
			return 16;
		case 'U':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(85);
			return 16;
		case 'V':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(86);
			return 16;
		case 'W':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(87);
			return 16;
		case 'X':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(88);
			return 16;
		case 'Y':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(89);
			return 16;
		case 'Z':
			//hit_likigram_for_followers.website.add(16);
			//hit_likigram_for_followers.website.add(90);
			return 16;
		/*
		 * NUMBERS
		 * */
		case '1':		
			return 49;
		case '2':
			return 50;	
		case '3':
			return 51;
		case '4':
			return 52;
		case '5':
			return 53;
		case '6':
			return 54;
		case '7':
			return 55;
		case '8':
			return 56;
		case '9':
			return 57;
		/*
		 * SPECIAL CHARACTERS
		 * */
		case '.':
			return 190;
		case '?':
			//hit_likigram_for_followers.website.add(16);
			return 191;
		case ':':
		//	hit_likigram_for_followers.website.add(16);
			return 186;
		case '/':
			return 191;
		case ' ':
			return 32;
		case '!':
			return 33;
		}
			return 0;
	}
	public static void key(char e){
			switch(e){
			/*-----------------------
			 * LOWER CASE*/
			case 'a':
				System.out.println('a' + " : 65");
				break;
			case 'b':
				System.out.println('b'+ " : 66");
				break;
			case 'c':
				System.out.println('c'+ " : 67");
				break;
			case 'd':
				System.out.println('d'+ " : 68");
				break;
			case 'e':
				System.out.println('e'+ " : 69");
				break;
			case 'f':
				System.out.println('f'+ " : 70");
				break;
			case 'g':
				System.out.println('g'+ " : 71");
				break;
			case 'h':
				System.out.println('h'+ " : 72");
				break;
			case 'i':
				System.out.println('i'+ " : 73");
				break;
			case 'j':
				System.out.println('j'+ " : 74");
				break;
			case 'k':
				System.out.println('k'+ " : 75");
				break;
			case 'l':
				System.out.println('l'+ " : 76");
				break;
			case 'm':
				System.out.println('m'+ " : 77");
				break;
			case 'n':
				System.out.println('n'+ " : 78");
				break;
			case 'o':
				System.out.println('o'+ " : 79");
				break;
			case 'p':
				System.out.println('p'+ " : 80");
				break;
			case 'q':
				System.out.println('q'+ " : 81");
				break;
			case 'r':
				System.out.println('r'+ " : 82");
				break;
			case 's':
				System.out.println('s'+ " : 83");
				break;
			case 't':
				System.out.println('t'+ " : 84");
				break;
			case 'u':
				System.out.println('u'+ " : 85");
				break;
			case 'v':
				System.out.println('v'+ " : 86");
				break;
			case 'w':
				System.out.println('w'+ " : 87");
				break;
			case 'x':
				System.out.println('x'+ " : 88");
				break;
			case 'y':
				System.out.println('y'+ " : 89");
				break;
			case 'z':
				System.out.println('z'+ " : 90");
				break;
			/*  ---------------
			 * UPPPER CASE
			 * ----------------------------------   */
			case 'A':
				System.out.println('A');
				break;
			case 'B':
				System.out.println('B');
				break;
			case 'C':
				System.out.println('C');
				break;
			case 'D':
				System.out.println('D');
				break;
			case 'E':
				System.out.println('E');
				break;
			case 'F':
				System.out.println('F');
				break;
			case 'G':
				System.out.println('G');
				break;
			case 'H':
				System.out.println('H');
				break;
			case 'I':
				System.out.println('I');
				break;
			case 'J':
				System.out.println('J');
				break;
			case 'K':
				System.out.println('K');
				break;
			case 'L':
				System.out.println('L');
				break;
			case 'M':
				System.out.println('M');
				break;
			case 'N':
				System.out.println('N');
				break;
			case 'O':
				System.out.println('O');
				break;
			case 'P':
				System.out.println('P');
				break;
			case 'Q':
				System.out.println('Q');
				break;
			case 'R':
				System.out.println('R');
				break;
			case 'S':
				System.out.println('S');
				break;
			case 'T':
				System.out.println('T');
				break;
			case 'U':
				System.out.println('U');
				break;
			case 'V':
				System.out.println('V');
				break;
			case 'W':
				System.out.println('W');
				break;
			case 'X':
				System.out.println('X');
				break;
			case 'Y':
				System.out.println('Y');
				break;
			case 'Z':
				System.out.println('Z');
				break;
			/*----
			 * NUMBERS
			 * --------------------------------------------- */
			case '1':
				System.out.println('1');
				break;
			case '2':
				System.out.println('2');
				break;
			case '3':
				System.out.println('3');
				break;
			case '4':
				System.out.println('4');
				break;
			case '5':
				System.out.println('5');
				break;
			case '6':
				System.out.println('6');
				break;
			case '7':
				System.out.println('7');
				break;
			case '8':
				System.out.println('8');
				break;
			case '9':
				System.out.println('9');
				break;
			/*----
			 * SPECIAL CHARACTERS
			 * --------------------------------- */
			case '.':
				System.out.println('.');
				break;
			case '?':
				System.out.println('?');
				break;
			case ':':
				System.out.println(':');
			case '/':
				System.out.println('/');				
			}
		}
	public static void int_to_key_stroke( String c) throws AWTException{
		int length_of_string = c.length();
		if(length_of_string == 0){
			System.out.println("Length = 0");
		}
		if(length_of_string == 2){
			System.out.println("Length = 2");
			int first = Integer.parseInt(c.substring(0,2));
			int_to_key(first);
			
		}
		if(length_of_string == 4){
			System.out.println("Length = 4");
			int first = Integer.parseInt(c.substring(0,2));
			int_to_key(first);
			int second = Integer.parseInt(c.substring(2,4));
			int_to_key(second);
		}
		if(length_of_string == 6){
			System.out.println("Length = 6");
			int first = Integer.parseInt(c.substring(0,2));
			int_to_key(first);
			int second = Integer.parseInt(c.substring(2,4));
			int_to_key(second);
			int third = Integer.parseInt(c.substring(4,6));
			int_to_key(third);
		}
		if(length_of_string == 8){
			System.out.println("Length = 8");
			int first = Integer.parseInt(c.substring(0,2));
			int_to_key(first);
			int second = Integer.parseInt(c.substring(2,4));
			int_to_key(second);
			int third = Integer.parseInt(c.substring(4,6));
			int_to_key(third);
			int fourth = Integer.parseInt(c.substring(6,8));
			int_to_key(fourth);
		}
		if(length_of_string == 10){
			System.out.println("Length = 10");
			int first = Integer.parseInt(c.substring(0,2));
			int_to_key(first);
			int second = Integer.parseInt(c.substring(2,4));
			int_to_key(second);
			int third = Integer.parseInt(c.substring(4,6));
			int_to_key(third);
			int fourth = Integer.parseInt(c.substring(6,8));
			int_to_key(fourth);
			int fifth = Integer.parseInt(c.substring(8,10));
			int_to_key(fifth);
		}
		if(length_of_string == 12){
			System.out.println("Length = 12");
			int first = Integer.parseInt(c.substring(0,2));
			int_to_key(first);
			int second = Integer.parseInt(c.substring(2,4));
			int_to_key(second);
			int third = Integer.parseInt(c.substring(4,6));
			int_to_key(third);
			int fourth = Integer.parseInt(c.substring(6,8));
			int_to_key(fourth);
			int fifth = Integer.parseInt(c.substring(8,10));
			int_to_key(fifth);
			int sixth = Integer.parseInt(c.substring(10,12));
			int_to_key(sixth);
		}
		if(length_of_string == 14){
			System.out.println("Length = 14");
			int first = Integer.parseInt(c.substring(0,2));
			int_to_key(first);
			int second = Integer.parseInt(c.substring(2,4));
			int_to_key(second);
			int third = Integer.parseInt(c.substring(4,6));
			int_to_key(third);
			int fourth = Integer.parseInt(c.substring(6,8));
			int_to_key(fourth);
			int fifth = Integer.parseInt(c.substring(8,10));
			int_to_key(fifth);
			int sixth = Integer.parseInt(c.substring(10,12));
			int_to_key(sixth);
			int seventh = Integer.parseInt(c.substring(12,14));
			int_to_key(seventh);
		}
		if(length_of_string == 16){
			System.out.println("Length = 16");
			int first = Integer.parseInt(c.substring(0,2));
			int_to_key(first);
			int second = Integer.parseInt(c.substring(2,4));
			int_to_key(second);
			int third = Integer.parseInt(c.substring(4,6));
			int_to_key(third);
			int fourth = Integer.parseInt(c.substring(6,8));
			int_to_key(fourth);
			int fifth = Integer.parseInt(c.substring(8,10));
			int_to_key(fifth);
			int sixth = Integer.parseInt(c.substring(10,12));
			int_to_key(sixth);
			int seventh = Integer.parseInt(c.substring(12,14));
			int_to_key(seventh);
			int eigth = Integer.parseInt(c.substring(14,16));
			int_to_key(eigth);
		}
	}
	public static void int_to_key(int c) throws AWTException{
		Robot rb = new Robot();
		switch(c){
			case 65:
				rb.keyPress(KeyEvent.VK_A);
				rb.keyRelease(KeyEvent.VK_A);	
				break;
			case 66:
				rb.keyPress(KeyEvent.VK_B);
				rb.keyRelease(KeyEvent.VK_B);
				break;
			case 67:
				rb.keyPress(KeyEvent.VK_C);
				rb.keyRelease(KeyEvent.VK_C);
				break;
			case 68:
				rb.keyPress(KeyEvent.VK_D);
				rb.keyRelease(KeyEvent.VK_D);
				break;
			case 69:
				rb.keyPress(KeyEvent.VK_E);
				rb.keyRelease(KeyEvent.VK_E);
				break;
			case 70:
				rb.keyPress(KeyEvent.VK_F);
				rb.keyRelease(KeyEvent.VK_F);
				break;
			case 71:
				rb.keyPress(KeyEvent.VK_G);
				rb.keyRelease(KeyEvent.VK_G);
				break;
			case 72:
				rb.keyPress(KeyEvent.VK_H);
				rb.keyRelease(KeyEvent.VK_H);
				break;
			case 73:
				rb.keyPress(KeyEvent.VK_I);
				rb.keyRelease(KeyEvent.VK_I);
				break;
			case 74:
				rb.keyPress(KeyEvent.VK_J);
				rb.keyRelease(KeyEvent.VK_J);
				break;
			case 75:
				rb.keyPress(KeyEvent.VK_K);
				rb.keyRelease(KeyEvent.VK_K);
				break;
			case 76:
				rb.keyPress(KeyEvent.VK_L);
				rb.keyRelease(KeyEvent.VK_L);
				break;
			case 77:
				rb.keyPress(KeyEvent.VK_M);
				rb.keyRelease(KeyEvent.VK_M);
				break;
			case 78:
				rb.keyPress(KeyEvent.VK_N);
				rb.keyRelease(KeyEvent.VK_N);
				break;
			case 79:
				rb.keyPress(KeyEvent.VK_O);
				rb.keyRelease(KeyEvent.VK_O);
				break;
			case 80:
				rb.keyPress(KeyEvent.VK_P);
				rb.keyRelease(KeyEvent.VK_P);
				break;
			case 81:
				rb.keyPress(KeyEvent.VK_Q);
				rb.keyRelease(KeyEvent.VK_Q);
				break;
			case 82:
				rb.keyPress(KeyEvent.VK_R);
				rb.keyRelease(KeyEvent.VK_R);
				break;
			case 83:
				rb.keyPress(KeyEvent.VK_S);
				rb.keyRelease(KeyEvent.VK_S);
				break;
			case 84:
				rb.keyPress(KeyEvent.VK_T);
				rb.keyRelease(KeyEvent.VK_T);
				break;
			case 85:
				rb.keyPress(KeyEvent.VK_U);
				rb.keyRelease(KeyEvent.VK_U);
				break;
			case 86:
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_V);
				break;
			case 87:
				rb.keyPress(KeyEvent.VK_W);
				rb.keyRelease(KeyEvent.VK_W);
				break;
			case 88:
				rb.keyPress(KeyEvent.VK_X);
				rb.keyRelease(KeyEvent.VK_X);
				break;
			case 89:
				rb.keyPress(KeyEvent.VK_Y);
				rb.keyRelease(KeyEvent.VK_Y);
				break;
			case 90:
				rb.keyPress(KeyEvent.VK_Z);
				rb.keyRelease(KeyEvent.VK_Z);
				break;
		}
	}
}
