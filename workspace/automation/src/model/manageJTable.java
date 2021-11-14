package model;

import javax.swing.JTable;

import view.Mainview;

public class manageJTable {
	static int count = 13;
	public void clearTable(JTable c){
		System.out.println(c.getColumnCount());
		System.out.println(c.getRowCount());
			for(int g=0;g <=c.getRowCount();g++){
				c.setValueAt(" ",0,g);
				if(g <=c.getRowCount()){
					break;
			}
		}
		Mainview.frame.repaint();
	}
	public static void returnValues(JTable c){		
		for(int i = 0; i <= c.getRowCount() -1 ;i++){
			
			System.out.println(c.getValueAt(i,0) + "  Row count: "+ i);
		}
		
	}
	public static int returnEmpties(JTable c){
		int firstValue = 0;
		for(int i =0;i<=c.getRowCount() -1;i++){
			if(c.getValueAt(i,0) == null){
				firstValue = i;
				break;
			}
		}
		return firstValue;
	}
	
	public static void addToTable(JTable c,int r,String str,int g){
		c.setValueAt(str,r,g);
	}
	public static void comparePrice(JTable c,int r){
		//int b = Integer.parseInt(c.getModel().getValueAt(r,0).toString());
		//System.out.println(b);
	}
	public static void insert(JTable c,String str){
		if(count == c.getRowCount()-1){
			addToTable(c,count,str,0);
			count = 1;
		}
		else{
			addToTable(c,count,str,0);
			count = count+1;
		}
	}
	public static void main(String[] args) {
		
	}

}
