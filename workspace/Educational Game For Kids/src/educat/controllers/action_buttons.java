package educat.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import educat.view.*;
import educat.view.instructions.*;
import educat.view.instructions.skip;

public class action_buttons implements ActionListener {
	//Class which holds all the actions events from the Buttons within the program. Should probably be locked away from normal user.
	@Override
	//Send all the set frames and set Panels to the JPanel and JFrame instaces within Tester class.
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
	//Forward Buttons.
	public static class action_startgame_mm implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = MainMenu.getPanel();
			frame.remove(pane);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
			skip mg = new skip();
			frame.add(skip.getPanel());
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
		}	
	}
	public static class action_menu_mm implements ActionListener {		
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = MainMenu.getPanel();
			frame.remove(pane);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
			Menu m = new Menu();
			JPanel p = m.getJPanel();
			frame.add(p);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
		}
	}
	public static class action_leaderboard_mm implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = MainMenu.getPanel();
			frame.remove(pane);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
			Leaderboard lb = new Leaderboard();
			JPanel panel = lb.getJPanel();
			//frame.setLayout(new FlowLayout());
			frame.add(panel);
			frame.repaint();
			frame.revalidate();
		}
	}
	public static class action_log_in_mm implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = MainMenu.getPanel();
			frame.remove(pane);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
			login lg = new login();
			JPanel Panel = lg.getJPanel();
			frame.add(Panel);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();	
		}
	}
	public static class icon_pivot implements MouseMotionListener {
		public static int x,y;
		public void mouseDragged(MouseEvent e) {	
			x = e.getX();
			y = e.getY();
		}
		@Override
		public void mouseMoved(MouseEvent arg0) {
					
		}
	}
	//Back buttons.
	public static class action_back_to_menu_lg implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = login.getJPanel();
			frame.remove(pane);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
			MainMenu m = new MainMenu();
			JPanel jp = m.getPanel();
			frame.add(jp);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();	
		}
	}
	public static class action_back_to_menu_mm implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Menu.getJPanel();
			frame.remove(pane);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
			MainMenu m = new MainMenu();
			JPanel jp = m.getPanel();
			frame.add(jp);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();		
		}
	}
	public static class action_back_to_menu_lb implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Leaderboard.getJPanel();
			frame.remove(pane);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
			MainMenu m = new MainMenu();
			JPanel jp = m.getPanel();
			frame.add(jp);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();	
		}
	}
	public static class go_to_register_form implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
			register r = new register();
			JPanel jp = r.getJPanel();
			frame.add(jp);
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();		
		}
	}
	public static class save_info implements ActionListener,Serializable{
		private StringBuffer child_path;

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = new JFrame();
			String var = "Hello World!";
			frame.setSize(300,300);	
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showSaveDialog(frame);
			//File myObj = new File(fileChooser.getSelectedFile(), null);
			String save = fileChooser.getSelectedFile().toString();
			int position = 0;
			StringBuilder child_path = new StringBuilder();
			StringBuilder parent_path = new StringBuilder();
			for(int i = save.length()-1;i > 0;i--){
				if(save.charAt(i) == '\\'){
					position = i+1;
					System.out.println(position);
					break;
				}
			}
			//PathName
			for(int i = save.length()-1; i >= position ;i--){
				//int current_length = child_path.length();
				child_path.insert(0,save.charAt(i));
			}
			for(int i = 0;i < position;i++){
				parent_path.append(save.charAt(i));
			}
			File file = new File(parent_path.toString(),child_path.toString());
			System.out.println(fileChooser.getSelectedFile());
			//Get string to be put namely details and score!
			try {
				FileOutputStream fileOut = new FileOutputStream(fileChooser.getSelectedFile());
	            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
	            objectOut.writeUTF(" ");
	            objectOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	public static class play_again implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Play again Initiated!");
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
		}
	}
	public static class mainmenu_from_finishScreen implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			MainMenu mg = new MainMenu();
			frame.add(Tester.getJPanel());
			frame.setVisible(true);
			frame.repaint();
			frame.revalidate();
		}
	}
	public static class instruct_from_startmenu implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = Tester.getJFrame();
			JPanel panel = Tester.getJPanel();
			frame.remove(panel);
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
			number1 n1 = new number1();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
		}	
	}
	public static class startgame_from_instruct implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Start Game from instructions page");
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
			startGame mg = new startGame();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
		}
	}
	public static class change_difficulty implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			MainG.setFinalScore(0);		
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
			difficulty diff = new difficulty();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
			
		}
		
	}
	public static class easy_difficulty implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			MainG.setGameDiff(1);
			//Pass game on 
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
			startGame mg = new startGame();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
		}	
	}
	public static class medium_difficulty implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			MainG.setGameDiff(2);
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
			startGame mg = new startGame();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
			//Probably have a reprompt 
		}
	}
	public static class hard_difficulty implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			MainG.setGameDiff(3);
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
			startGame mg = new startGame();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
		}
	} 
	public static class instru_next_1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			//frame.setVisible(true);
			number2 n1 = new number2();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);	
		}
	}
	public static class instru_next_2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			//frame.setVisible(true);
			number3 n1 = new number3();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);		
		}
	}
	public static class instru_next_3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			//frame.setVisible(true);
			number4 n1 = new number4();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);	
		}
		
	}
	public static class extras_mm implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			System.out.println("extras clicked");
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			JTextPane extra_info = new JTextPane();
			ImageIcon cross = new ImageIcon("src/educat/pictures/CROSS.jpg");
			ImageIcon tick = new ImageIcon("src/educat/pictures/TICK.jpg");
			JLabel cross_label = new JLabel(cross);
			JLabel tick_label = new JLabel(tick);
			//Select text and display text
			cross_label.setBounds(200,50,175,175);
			tick_label.setBounds(400,50,175,150);
			extra_info.setBounds(200,200,300,300);
			extra_info.setText("Hello World!");
			right_answer right = new right_answer();
			tick_label.addMouseListener(right);
			wrong_answer wrong = new wrong_answer();
			cross_label.addMouseListener(wrong);
			pane.add(extra_info);
			pane.add(tick_label);
			pane.add(cross_label);
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public static class wrong_answer implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Wrong answer!");
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		public static class right_answer implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("Right answer clicked!");		
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}	
		}
	}
	public static class back_2_1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			//frame.setVisible(true);
			number1 n1 = new number1();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);	
		}
	}
	public static class back_3_2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			//frame.setVisible(true);
			number2 n1 = new number2();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);	
		}
	}
	public static class back_4_3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = Tester.getJFrame();
			JPanel pane = Tester.getJPanel();
			frame.remove(pane);
			frame.repaint();
			frame.revalidate();
			//frame.setVisible(true);
			number3 n1 = new number3();
			frame.add(Tester.getJPanel());
			frame.repaint();
			frame.revalidate();
			frame.setVisible(true);	
			
		}
		
	}
}