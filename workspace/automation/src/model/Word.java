package model;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import controller.readTextFile;
import controller.string_to_key_press;

public class Word {
	/**
	 * Hopefully will result in a program that will be able to pose questions. with the use of
	 * informatives and words from the dictionary as well as adverbs, nouns, adjectives required to 
	 * produce a feasible question. 
	 * 
	 */
	static char [] alphabet = {'a','b','c','d','e','f','g','h','i','j','k'
			,'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	String [] informatives ={"Who","What","Where","Why", "When"};
	static ArrayList<String> words ;
	String [] nouns = {}; // Refers to a thing
	String [] adjectives = {}; // An attribute of a noun
	String [] verbs = {}; //An action word
	String [] adverbs = {}; //Describes a verb.
	static String [] questions_list = {"What is the meaning of","How do i use the word ", "Where is the ",
		"Why should i use the word","What is a better word for", "What is a ",
		"How can i use","in a sentence",
		"When is the best time to use","in a conversation",
		"What does","mean"};
	//How can i use ... in a sentence
	//When is the best time to use ... in a conversation
	//What does ... mean 
	
	static ArrayList<String> question = new ArrayList<String>(Arrays.asList(questions_list));
	static StringBuffer word = new StringBuffer();
	static StringBuffer key_strokes = new StringBuffer();
	public static char getLetter(int c){
		return alphabet[c];
	}
	public void setLetter(){
		
	}
	//createWord from scratch
	public static StringBuffer createWord(int c){
		if (c != 0){
			try{
				char d = getLetter((int)Math.round(Math.random()*alphabet.length));
				key_strokes.append(Integer.toString( string_to_key_press.key_int(d) ));				
				word.append(d);
			}
			catch(ArrayIndexOutOfBoundsException e){
				word.append(getLetter((int)Math.round(Math.random()*alphabet.length)));		
			}
			c = c-1;
			createWord(c);
		}
		return word;
	}
		public static int generateRandomNumber(ArrayList<String> c){
			int size = c.size()-1;
			int rand = (int)Math.round(Math.random()*size);
			return rand;
		}
		public Word() throws FileNotFoundException{
			new readTextFile("information_proper.txt");
			words = readTextFile.getList();
		}
		//Choose a word from the word list.
		public static String chooseWord(){
			return words.get(generateRandomNumber(words));
		}
		//Randomly generate questions
		public static String stageQuestion(){
			try{
				String re = question.get(generateRandomNumber(question))+" "+chooseWord();
				if(generateRandomNumber(question) == 6){
					re = question.get(6)+" "+chooseWord()+ " " + question.get(7);
				}
				if(generateRandomNumber(question) == 7){
					re = question.get(generateRandomNumber(question))+chooseWord();
				}
				if(generateRandomNumber(question) == 8){
					re = question.get(8)+" "+chooseWord()+" " + question.get(9);
				}
				if(generateRandomNumber(question) == 9){
					re = question.get(generateRandomNumber(question))+chooseWord();
				}
				if(generateRandomNumber(question) == 10){
					re = question.get(10)+" "+chooseWord()+" " + question.get(11);
				}
				if(generateRandomNumber(question) == 11){
					re = question.get(generateRandomNumber(question))+chooseWord();
				}
				return re;
			}
			catch(IndexOutOfBoundsException e){
				String re = question.get(generateRandomNumber(question))+" "+ chooseWord();
				return re;
			}
		}
	public static void main(String[]args) throws AWTException,InterruptedException,IOException{
		new Word();
		//System.out.println(word.stageQuestion());
		//Ready to be tested on a text file!
		//string_to_key_press.string_to_key_press(word.stageQuestion());
		
		}
}
