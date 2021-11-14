package automation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Word;

public class random_word {

	static JTextField text;
	public random_word(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		JLabel c = new JLabel("Random word genrator");
		c.setBounds(50,20,150,50);
		panel.add(c);
		JButton button = new JButton("Generate word");
		button.setBounds(200,20,100,50);
		fetch_events fetch = new fetch_events();
		button.addActionListener(fetch);
		panel.add(button);
		text = new JTextField("");
		text.setBounds(150,75,150,50);
		text.setText("Word appears here ");
		panel.add(text);
		frame.add(panel);
		frame.setSize(450,450);
		frame.setVisible(true);
	}
	public static class fetch_events implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			try {
				Word word = new Word();
				@SuppressWarnings("static-access")
				String re = word.chooseWord();
				text.setText(re);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		new random_word();
	}

}
