package educat.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import educat.controllers.action_buttons;
import educat.model.tableData;

public class Leaderboard {
	//Holds the leaderboards which will hold and save player scores.
	// Maybe code options for settings and other things like blind and deaf settings!
	static JPanel pane;
	JScrollPane scroll_pane;
	JTable jt;
	static int width;
	int height;	
	static int rowCount;
	int columnCount;
	public JFrame getJFrame(){
		return MainMenu.jf;
	}
	public void setJFrame(JFrame jframe){
		MainMenu.jf = jframe;
	}
	public static JPanel getJPanel(){
		return pane;
	}
	public void setJPanel(JPanel pane){
		this.pane = pane;
	}
	public JScrollPane getScrollPane(){
		return scroll_pane;
	}
	public void setScrollPane(JScrollPane pane){
		this.scroll_pane = pane;
	}
	public JTable getTable(){
		return jt;
	}
	public void setTable(JTable jt){
		this.jt = jt;
	}
	public void setRowHeight(int i ){
		JTable table = getTable();
		table.setRowHeight(i);
	}
	public static int getRowCount(){
		return rowCount;
	}
	public void setRowCount(int c){
		rowCount = c;
	}
	public int getColumnCount(){
		return columnCount;
	}
	public void setColumnCount(int c){
		columnCount = c;
	}
	public void createTable(){
		JTable table = new JTable(tableData.data,tableData.column_names);
		this.setTable(table);
	}
	public void createPane(){
		JPanel pane = new JPanel();
		JButton back_button = new JButton("Back");
		action_buttons.action_back_to_menu_lb ab = new action_buttons.action_back_to_menu_lb();
		back_button.addActionListener(ab);
		pane.add(back_button);
		setJPanel(pane);	
		createTable();
		JTable table = getTable();
		setColumnCount(table.getColumnCount());
		System.out.println(getColumnCount());
		setRowCount(table.getRowCount());
		System.out.println(getRowCount());
		JScrollPane sp = new JScrollPane(table);
		setScrollPane(sp);
		pane.add(sp);
		table.setRowHeight(30);
		table.setBounds(30, 40, 100, 100);
	}
	public Leaderboard(){
		createPane();
	}
	public void setSizeOfWidth(int c){
		c = width;
	}
	public static int getSizeOfWidth(){
		return width;
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Leaderboard lb = new Leaderboard();
		JPanel pane = getJPanel();
		frame.setLayout(new FlowLayout());
		frame.add(pane);
        frame.setVisible(true);
        frame.setSize(300,300); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
	}
