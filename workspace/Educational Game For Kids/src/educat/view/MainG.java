package educat.view;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.Timer;

import educat.controllers.action_buttons;
import educat.controllers.action_buttons.extras_mm.right_answer;
import educat.controllers.action_buttons.extras_mm.wrong_answer;

public class MainG extends JPanel implements ActionListener  {

	Timer t = new Timer(25, this); // Speed of Game refresh!
	Robot rb;
	//Size of JFrame.
	Boolean alreadyAdded = false;
	private static int height = Tester.getJFrameHeight();;
	private static int width = Tester.getJFrameWidth();;
	JFrame frame;
	private static JPanel panel;
	private static double final_score;
	//Difficulty
	private static int difficulty;
	// Size of Image
	BufferedImage img = null;
	private int width_image = 0;
	private int height_image = 0;
	//
	int current_width = getWidth();
	int current_height = getHeight();;
	//Grey Square
	private int first_y = -200;
	private int g_square_x = 200; //Choose a random variable 
	//Red Rotate Square
	private int degree = 0;
	private int size_of_rotate_x = 150;
	private int size_of_rotate_y = 150;
	private int y_value = -350;
	private int x_value = 400; //Choose a random variable
	//Triangle
	//Length of triangle is 60
	private static int point_AX = 500; //Choose a random variable
	private static int point_BX = point_AX-100; 
	private static int point_CX = point_AX+100;
	static int point_AY = -250;
	static int point_BY = point_AY+120;
	static int point_CY = point_BY;
	//Display Final Score
	double score = 0;
	//Pentagon
	//Vertical length of pentagon is  60
	static int point_AX_pen = 50; //Choose a random variable within the bounds of the program!
	static int point_BX_pen = point_AX_pen-80; //variations will change in accordance to size of screen.
	static int point_CX_pen = point_AX_pen-50;
	static int point_DX_pen = point_AX_pen+50;
	static int point_EX_pen = point_AX_pen+80;
	static int point_AY_pen = -350;
	static int point_BY_pen = point_AY_pen+60;
	static int point_CY_pen = point_AY_pen+130;
	static int point_DY_pen = point_CY_pen;
	static int point_EY_pen = point_BY_pen;
	//Concerned with where Y is placed!
	//Vertical length of hexagon is 90
	static int point_AX_hex = 150; //Choose a random X variable
	static int point_BX_hex = point_AX_hex-100; //These can be made with relations!
	static int point_CX_hex = point_BX_hex;
	static int point_DX_hex = point_AX_hex;
	static int point_EX_hex = point_AX_hex+100;
	static int point_FX_hex = point_EX_hex;
	static int point_AY_hex = -300; //Start outside the map everytime
	static int point_BY_hex = point_AY_hex+60;
	static int point_CY_hex = point_AY_hex+140;
	static int point_DY_hex = point_AY_hex+180; //Must be larger than Y coordinates of point_CY_hex;
	static int point_EY_hex = point_CY_hex;
	static int point_FY_hex = point_BY_hex;
	
	//Points on the user rocket!
	int point_one_x = HandlerClass.x-difficulty ;
	int point_one_y = HandlerClass.y;
	int point_two_x = HandlerClass.x+width_image+difficulty;
	int point_two_y = HandlerClass.y;
	int point_three_x = HandlerClass.x-difficulty;
	int point_three_y = HandlerClass.y+height_image+difficulty;
	int point_four_x = HandlerClass.x+width_image+difficulty;
	int point_four_y = HandlerClass.y+height_image+difficulty;
	//Points on red square!
	int sq_one_x = x_value; 
	int sq_one_y = y_value; 
	int sq_two_x = x_value+size_of_rotate_x; 
	int sq_two_y = y_value; 
	int sq_three_x = x_value; 
	int sq_three_y = y_value+size_of_rotate_y;
	int sq_four_x = x_value+size_of_rotate_x; 
	int sq_four_y = y_value+size_of_rotate_y;
	
	//Bubble show!
	static int eli_var = 0;
	static String [] names = {"Java","Variable","Class","Computer"};
	static Boolean [] right_or_wrong = {false,true,true,false};
	static String [] display_text = {"Wrong!","Correct!","Correct!","Wrong!"};
	//Bubble coord
	static int eli_x = 200;
	static int eli_y = -800 ;
	int word_x = 220;
	int word_y = -150 ;
	
	
	public JPanel getJPanel(){
		return panel;
	}
	public void setJPanel(JPanel jp){
		panel = jp;
	}
	public Boolean getAnswer(int c){
		if(c == 1){
			System.out.println("true");
			return true;
		}
		else if(c == 2){
			System.out.println("true");
			return true;
		}
		else{
			System.out.println("false");
			return false;
		}
	}
	public void setJFrame(JFrame jf){
		frame = jf;
	}
	public JFrame getJFrame(){
		return frame;
	}
	public static void setFinalScore(double score){
		 final_score = score;
	}
	public void resetClassComponents(){
		eli_y = -800;
		word_y = -750;
		//Triangle reset values
		point_AX = 500; //Choose a random variable
		point_BX = point_AX-100; 
		point_CX = point_AX+100;
		point_AY = -250;
		point_BY = point_AY+120;
		point_CY = point_BY;		
		//Pentagon reset values
		point_AX_pen = 50; //Choose a random variable within the bounds of the program!
		point_BX_pen = point_AX_pen-80; //variations will change in accordance to size of screen.
		point_CX_pen = point_AX_pen-50;
		point_DX_pen = point_AX_pen+50;
		point_EX_pen = point_AX_pen+80;
		point_AY_pen = -350;
		point_BY_pen = point_AY_pen+60;
		point_CY_pen = point_AY_pen+130;
		point_DY_pen = point_CY_pen;
		point_EY_pen = point_BY_pen;
		//Hexagon Reset values
		point_AY_hex = -300;
		point_AX_hex = 150; //Choose a random X variable
		point_BX_hex = point_AX_hex-100; //These can be made with relations!
		point_CX_hex = point_BX_hex;
		point_DX_hex = point_AX_hex;
		point_EX_hex = point_AX_hex+100;
		point_FX_hex = point_EX_hex;
		point_AY_hex = -300; //Start outside the map everytime
		point_BY_hex = point_AY_hex+60;
		point_CY_hex = point_AY_hex+140;
		point_DY_hex = point_AY_hex+180; //Must be larger than Y coordinates of point_CY_hex;
		point_EY_hex = point_CY_hex;
		point_FY_hex = point_BY_hex;
		point_AY = -250;
		y_value = -350;
		first_y = -200;
	}
	public static double getFinalScore(){
		return final_score;
	}
	public static void setGameDiff(int C){
		if (C==1){
			difficulty = 60;
			System.out.println(difficulty);
		}
		else if(C == 2){
			difficulty = 100;
			System.out.println(difficulty);
		}
		else {
			difficulty = 150;
			System.out.println(difficulty);
		}
	}
	public static int randomNumber(int random){
		Random rand = new Random(); 
		int c = rand.nextInt(random);
		return c;
	}
	public static void endGame(){
		JFrame frame = Tester.getJFrame();
		JPanel pane = Tester.getJPanel();
		frame.remove(pane);
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
		finishScreen fs =  new finishScreen();
		JPanel panel = Tester.getJPanel();
		frame.add(panel);
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
		throw new RuntimeException("End Game!");
	}
	public void paint(Graphics g){
		//Sets background for the main game.
		super.paint(g);
		Tester.SizeCheck d = new Tester.SizeCheck();
		d.start();
		HandlerClass hc = new HandlerClass();
		this.addMouseMotionListener(hc);
		ImageIcon bg_image = new ImageIcon("src/educat/pictures/NightSky.jpg");
		JLabel c = new JLabel(bg_image);
		this.setLayout(null);
		c.setBounds(-25,-25,Tester.getJFrameWidth()+50,Tester.getJFrameHeight());
		this.add(c);
		//Loads the rocket or the main user icon.
		
		try
			{img = ImageIO.read(new File("src/educat/pictures/rocket.jpg" ));}
		catch ( IOException e ){e.printStackTrace();}
		height_image = img.getHeight();
		width_image = img.getWidth();
		Graphics roc = (Graphics) g;
		roc.drawImage( img, HandlerClass.x,HandlerClass.y, this );
		/*
		 * Obstacles
		 */
		//Gray square move.
		Graphics2D g2d =  (Graphics2D) g.create();
		g2d.setPaint(new Color(150, 150, 150));
		t.start();
		g2d.fillRect(g_square_x,first_y, 110, 85);
	    //Rotate Square.
		Graphics2D g5d = (Graphics2D) g;
		Rectangle2D rect = new Rectangle2D.Double( x_value, y_value, size_of_rotate_x,size_of_rotate_y  );
		AffineTransform transform = new AffineTransform();
		//transform.rotate(Math.toRadians(degree), x_value, y_value );
		Shape s = transform.createTransformedShape( rect );
		g5d.setColor(Color.RED);
		g5d.fill(s);
	    //Triangle. 
	    Graphics2D g6d = (Graphics2D) g;
	    g6d.setColor(Color.BLUE);
	    int [] x = new int[]{ point_AX , point_BX , point_CX };
	    int [] y = new int[]{ point_AY , point_BY , point_CY };
	    g6d.fillPolygon(x,y,3);
	    //Display score.
	    Graphics2D g4d = (Graphics2D) g;
	    g4d.setColor(Color.WHITE);
	    g4d.drawString("Current Score: " + score , Tester.getJFrameWidth()-200, Tester.getJFrameHeight()-200);
	    //Pentagon
	    int [] xp = new int [] {point_AX_pen ,point_BX_pen,point_CX_pen,point_DX_pen,point_EX_pen};
	    int [] yp = new int [] {point_AY_pen,point_BY_pen,point_CY_pen,point_DY_pen,point_EY_pen};
	    Graphics2D g7d = (Graphics2D) g;
	    g7d.setColor(Color.GREEN);
	    g7d.fillPolygon(xp,yp,5);
	    
	    //Hexagon 
	    int [] xh = new int []{point_AX_hex,point_BX_hex,point_CX_hex,point_DX_hex,point_EX_hex,point_FX_hex};
	    int [] yh = new int []{point_AY_hex,point_BY_hex,point_CY_hex,point_DY_hex,point_EY_hex,point_FY_hex};
	    Graphics2D g8d = (Graphics2D) g;
	    g8d.setColor(Color.MAGENTA);
	    g8d.fillPolygon(xh,yh,6);
	    
	    boost(g);
	    //Set JPanel
	    revalidate();
	}
	public void boost(Graphics g){
		//names of keywords.
		//Array of possible names to fill 
		Graphics2D gd =  (Graphics2D) g.create();
		gd.setPaint(new Color(200,200,200,200));
		gd.fill(new Ellipse2D.Double(eli_x,eli_y,120,80));
		gd.setPaint(new Color(0,0,0,255));
		gd.drawString(names[eli_var], word_x,word_y );
	}
	public int reAllocation(int x){
		//Get X values of all coordinates and sizes!.
		
		int left_side_tri = point_BX;
		int right_side_tri = point_CX;
		int size_of_component_tri = right_side_tri - left_side_tri;
		int left_side_hex = point_BX_hex;
		int right_side_hex = point_EX_hex;
		int size_of_component_hex = right_side_hex - left_side_hex;
		int left_side_pen = point_BX_pen;
		int right_side_pen = point_EX_pen;
		int size_of_component_pen = right_side_pen - left_side_pen;
		int left_side_sq = sq_one_x;
		int right_side_sq = sq_two_x;
		int size_of_component_sq = right_side_sq - left_side_sq;
		int size_of_frame = Tester.getJFrameHeight();
		int left=0,right=0;
		int [] pc = {left_side_tri,right_side_tri,left_side_hex,right_side_hex,left_side_pen,right_side_pen,left_side_sq,right_side_sq};
		for(int i = 0;i < pc.length ; i++){
			if(pc[i] < size_of_frame/2){
				left = left+1;
			}
			else{
				right = right+1;
			}
		}
		if(left> right){
			return size_of_frame/2 - 100;
		}
		else{
			return size_of_frame/2 + 100;
		}
	}
	public int reAllocationY(int c){
		int top_of_tri = point_AY;
		int bottom_of_tri = point_CY;
		int size_of_component_tri = top_of_tri - bottom_of_tri;
		int top_of_hex = point_AY_hex;
		int bottom_of_hex = point_DY_hex;
		int size_of_component_hex = top_of_hex - bottom_of_hex;
		int top_of_pen = point_AY_pen;
		int bottom_of_pen = point_CY_pen;
		int size_of_component_pen = top_of_pen - bottom_of_pen;
		int top_of_sq = sq_one_y;
		int bottom_of_sq = sq_two_y;
		int size_of_component_sq = top_of_sq - bottom_of_sq;
		int size_of_frame = Tester.getJFrameWidth();
		int left=0,right=0;
		int [] pc = {top_of_tri,bottom_of_tri,top_of_hex,bottom_of_hex,top_of_pen,bottom_of_pen,top_of_sq,bottom_of_sq};
		
		int up=0,down=0;
		for(int i = 0;i < pc.length ; i++){
			if(pc[i] < size_of_frame/2){
				up = up+1;
			}
			else{
				down = down+1;
			}
		}
		if(up> down){
			return size_of_frame/2 - 100;
		}
		else{
			return size_of_frame/2 + 100;
		}
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		MainG mg = new MainG();
		jf.add(mg);
		jf.setSize(300,300);
		jf.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		current_width = getWidth();
		int ratio_width = width/current_width;
		current_height = getHeight();
		int ratio_height = height/current_height;
		
		//Grey Square
		first_y += 15;   //Y coordinate of the Grey Square
		//Red Rotate Square 
		degree += 6; 	// Degree of rotation of Red sqaure.
		y_value += 15; // Y value of the red square.
		//Triangle push down.
		point_AY += 10;
		point_BY += 10;
		point_CY += 10;
		
		//Display Score!
		score = score+10; // Score for the user.
		//Pentagon push down.
		point_AY_pen += 10;
		point_BY_pen += 10;
		point_CY_pen += 10;
		point_DY_pen += 10;
		point_EY_pen += 10;
		//Hexagon push down;
		point_AY_hex += 10;
		point_BY_hex += 10;
		point_CY_hex += 10;
		point_DY_hex += 10;
		point_EY_hex += 10;
		point_FY_hex += 10;
		//Will make sure to implement scores for difficulties.
		height = Tester.getJFrameHeight();
		width = Tester.getJFrameWidth();
		
		//Boost score coord
		eli_y +=10;
		word_y +=10;
		repaint();
		revalidate();
		if(eli_y >=height || word_y >= height){
			eli_y = -100;
			word_y = -80;
			int random_x = randomNumber(width-50);
			word_x = random_x;
			eli_x = random_x - 20;
			eli_var = randomNumber(names.length);
		}
		if(y_value >= height){
			y_value = -150;
			x_value = randomNumber((width-50));
			//Random generator for X value
		}
		//Margin of difficulty.
		//Rocket points of contact.
		point_one_x = HandlerClass.x-difficulty ;
		point_one_y = HandlerClass.y;
		point_two_x = HandlerClass.x+width_image+difficulty;
		point_two_y = HandlerClass.y;
		
		//End clause for Red rotate square
		sq_one_x = x_value; 
		sq_one_y = y_value; 
		sq_two_x = x_value+size_of_rotate_x; 
		sq_two_y = y_value; 
		sq_three_x = x_value; 
		sq_three_y = y_value+size_of_rotate_y;
		sq_four_x = x_value+size_of_rotate_x; 
		sq_four_y = y_value+size_of_rotate_y;
		
		//Collision detection for all components.
		if (point_one_y > sq_one_y && point_one_y > sq_two_y){
			if(point_one_x > sq_one_x && point_one_x > sq_three_x){
				if(point_one_y < sq_three_y && point_one_y < sq_four_y){
					if(point_one_x < sq_two_x && point_one_x < sq_four_x){		
							setFinalScore(score);
							endGame();
						}
					}
				}
			}
		//Triangle collision detection
		if(point_one_x < point_CX && point_one_x > point_BX && point_one_y > point_AY && point_one_y < point_BY  ){
			setFinalScore(score);
			endGame();
		}
		//Pentagon Collision detection 
		if(point_one_x > point_BX_pen && point_one_x < point_EX_pen && point_one_y < point_CY_pen && point_one_y > point_AY_pen){
				setFinalScore(score);
				endGame();
			}
		//Hexagon collision detection
		if(point_one_x > point_BX_hex && point_one_x < point_EX_hex && point_one_y > point_AY_hex &&point_one_y < point_DY_hex){
			//System.out.println("true");
			setFinalScore(score);
			endGame();
		}
		if(eli_x >= point_one_x && eli_x <= point_two_x && point_one_y > eli_y && point_one_y < eli_y+200  ){
			if(difficulty == 60){
				score = score+25;
			}
			else if (difficulty == 100){
				score = score+50;
			}
			else{
				score = score+75;
			}
		}
		//When shapes reach the bottom of the screen!
		if(first_y >= height ){
			first_y = -200;
			g_square_x = randomNumber((width-50));		
		}
		if(point_AY >= height){
			point_AY = -300;
			point_BY = point_AY+120;
			point_CY = point_BY;
			point_AX = randomNumber((width-50)); 
			point_BX = point_AX-100;
			point_CX = point_AX+100;
		}
		if(point_AY_pen >=height){
			point_AX_pen = randomNumber((width-50));
			point_BX_pen = point_AX_pen-80; //variations will change in accordance to size of screen.
			point_CX_pen = point_AX_pen-50;
			point_DX_pen = point_AX_pen+50;
			point_EX_pen = point_AX_pen+80;
			point_AY_pen = 0;
			point_BY_pen = 60;
			point_CY_pen = 135;
			point_DY_pen = point_CY_pen;
			point_EY_pen = point_BY_pen;
		}
		if(point_AY_hex >= height){
			point_AX_hex = randomNumber((width-50)); 
			point_BX_hex = point_AX_hex-100;
			point_CX_hex = point_BX_hex;
			point_DX_hex = point_AX_hex;
			point_EX_hex = point_AX_hex+100;
			point_FX_hex = point_EX_hex;
			point_AY_hex = -100;
			point_BY_hex = point_AY_hex+60;
			point_CY_hex = point_AY_hex+140;
			point_DY_hex = point_AY_hex+180; 
			point_EY_hex = point_CY_hex;
			point_FY_hex = point_BY_hex;
		}			
	}
	//Handles movements of The main user icon.
	public static class HandlerClass implements MouseMotionListener,KeyListener {
		public static int x = 500,y = 500;
			static Boolean left,right,up,down;
			public static int getX(){
				return x;
			}
			public static int getY(){
				return y;	
			}
			public static void setX(int X){
				x = X;
			}
			public static void setY(int Y){
				y = Y;
			}
			public void decreaseY(){
				y -= 10;
				setY(y);
			}
			public void decreaseX(){
				x -= 10;
				setX(x);
			}
			public void increaseX(){
				x += 10;
				setX(x);
			}
			public void increaseY(){
				y += 10;
				setY(y);
			}
			public void mouseDragged(MouseEvent e) {	
				x = e.getX();
				y = e.getY();
			}
			@Override
			public void mouseMoved(MouseEvent arg0) {
			}
				@Override
			public void keyPressed(KeyEvent e) {
				if(KeyEvent.getKeyText(e.getKeyCode())=="Left"){
					left = true;
					right = false;
					up = false;
					down = false;
					decreaseX();
				}
				if(KeyEvent.getKeyText(e.getKeyCode())=="Right" ){
					left = false;
					right = true;
					up = false;
					down = false;
					increaseX();
				}
				if(KeyEvent.getKeyText(e.getKeyCode())=="Up"){
					left = false;
					right = false;
					up = true;
					down = false;
					decreaseY();
				}
				if ( KeyEvent.getKeyText(e.getKeyCode())=="Down"){
					left = false;
					right = false;
					up = false;
					down = true;
					increaseY();
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub	
			}
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
	}
}
