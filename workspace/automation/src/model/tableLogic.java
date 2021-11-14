package model;

import controller.Check_time;
import trading.currencies.eurgbp;
import trading.currencies.gbpusd;
import view.Mainview;
import view.trading_scenes.eurgbp_scene;
import view.trading_scenes.eurusd_scene;
import view.trading_scenes.gbpusd_scene;
import view.trading_scenes.usdjpy_scene;

public class tableLogic {
	public static int insert_usdjpy = 1;
	public static int insert_gbpusd = 1;
	public static int insert_eurusd = 1;
	public static int insert_eurgbp = 1;
	static String compare_gbpusd = "1.3300";
	static String compare_usdjpy = "105.00";
	static String compare_eurgbp = "0.8999";
	static String compare_eurusd = "1.0054";
	//Maybe a new differential 

	public static String whichCurrency(String c){
		//One entry for all currencies.
		String ret = "";
		String time = ""+Check_time.getHour()+" : "+Check_time.getMinute()+"";
		if(c.charAt(3) == '.'){
			ret ="USD/JPY";
			// System.out.println(ret);-- check which is being inputted for the currency.
			int number = tableLogic.convertStringtoInt(compare_usdjpy);
			int difference = tableLogic.convertStringtoInt(c) - number;
			String result = Integer.toString(difference);
			System.out.println(usdjpy_scene.usdjpy_table.getRowCount());
			if(insert_usdjpy == usdjpy_scene.usdjpy_table.getRowCount()-1){
				Mainview.usdjpy.setCurrentPrice(c);
				manageJTable.addToTable(usdjpy_scene.usdjpy_table, insert_usdjpy, c,0);
				manageJTable.addToTable(usdjpy_scene.usdjpy_table,insert_usdjpy,result,1);
				manageJTable.addToTable(usdjpy_scene.usdjpy_table, insert_usdjpy, time, 2);
				Mainview.frame.repaint();
				
				insert_usdjpy = 1;
			}
			else{
				if(insert_usdjpy != 1){
					manageJTable.addToTable(usdjpy_scene.usdjpy_table, insert_usdjpy, c,0);
					Mainview.usdjpy.setCurrentPrice(c);
					difference = tableLogic.convertStringtoInt(c) - number;
					result = Integer.toString(difference);
					manageJTable.addToTable(usdjpy_scene.usdjpy_table,insert_usdjpy,result,1);
					manageJTable.addToTable(usdjpy_scene.usdjpy_table, insert_usdjpy, time, 2);
					
					Mainview.frame.repaint();
					
					insert_usdjpy = insert_usdjpy+1;
				}
				if(insert_usdjpy == 1){
					manageJTable.addToTable(usdjpy_scene.usdjpy_table, insert_usdjpy, c,0);
					Mainview.usdjpy.setCurrentPrice(c);
					compare_usdjpy = c;
					manageJTable.addToTable(usdjpy_scene.usdjpy_table,insert_usdjpy,compare_usdjpy,1);
					manageJTable.addToTable(usdjpy_scene.usdjpy_table, insert_usdjpy, time, 2);
					Mainview.frame.repaint();
					insert_usdjpy = insert_usdjpy+1;
				}
			}
		}
		if(c.charAt(0) == '0'){
			ret = "EUR/GBP";
			//System.out.println(ret); -- check which is being inputted for the currency.
			int number = tableLogic.convertStringtoInt(compare_eurgbp);
			int difference = tableLogic.convertStringtoInt(c) - number;
			String result = Integer.toString(difference);
			if(insert_eurgbp == eurgbp_scene.eurgbp_table.getRowCount()-1){
				Mainview.eurgbp.setCurrentPrice(c);
				manageJTable.addToTable(eurgbp_scene.eurgbp_table, insert_eurgbp, c,0);
				manageJTable.addToTable(eurgbp_scene.eurgbp_table,insert_eurgbp,result,1);
				manageJTable.addToTable(eurgbp_scene.eurgbp_table, insert_eurgbp, time, 2);
				Mainview.frame.repaint();
				insert_eurgbp = 1;			
			}
			else{
				if(insert_eurgbp != 1){
					manageJTable.addToTable(eurgbp_scene.eurgbp_table, insert_eurgbp, c,0);
					Mainview.eurgbp.setCurrentPrice(c);
					difference = tableLogic.convertStringtoInt(c) - number;
					result = Integer.toString(difference);
					manageJTable.addToTable(eurgbp_scene.eurgbp_table,insert_eurgbp,result,1);
					manageJTable.addToTable(eurgbp_scene.eurgbp_table, insert_eurgbp, time, 2);
					
					Mainview.frame.repaint();
					insert_eurgbp = insert_eurgbp+1;
				}
				if(insert_eurgbp == 1){
					manageJTable.addToTable(eurgbp_scene.eurgbp_table, insert_eurgbp, c,0);
					compare_eurgbp = c;
					Mainview.eurgbp.setCurrentPrice(c);
					manageJTable.addToTable(eurgbp_scene.eurgbp_table,insert_eurgbp,compare_eurgbp,1);
					manageJTable.addToTable(eurgbp_scene.eurgbp_table, insert_eurgbp, time, 2);
					
					Mainview.frame.repaint();
					insert_eurgbp = insert_eurgbp+1;
				}
			}
		}
		if(c.charAt(0) == '1'){
			if(c.charAt(2) == '1' || c.charAt(2) == '2'){
				ret = "EUR/USD";
				//System.out.println(ret); -- check which is being inputted for the currency.
				//EURUSD
				int number = tableLogic.convertStringtoInt(compare_eurusd);
				int difference = tableLogic.convertStringtoInt(c) - number;
				String result = Integer.toString(difference);
				if(insert_eurusd == eurusd_scene.eurusd_table.getRowCount()-1){
					Mainview.eurusd.setCurrentPrice(c);
					manageJTable.addToTable(eurusd_scene.eurusd_table, insert_eurusd, c,0);
					manageJTable.addToTable(eurusd_scene.eurusd_table,insert_eurusd,result,1);
					manageJTable.addToTable(eurusd_scene.eurusd_table, insert_eurusd, time, 2);
					Mainview.frame.repaint();
					insert_eurusd = 1;			
				}
				else{
					if(insert_eurusd != 1){
						manageJTable.addToTable(eurusd_scene.eurusd_table, insert_eurusd, c,0);
						Mainview.eurusd.setCurrentPrice(c);
						difference = tableLogic.convertStringtoInt(c) - number;
						result = Integer.toString(difference);
						manageJTable.addToTable(eurusd_scene.eurusd_table,insert_eurusd,result,1);
						manageJTable.addToTable(eurusd_scene.eurusd_table, insert_eurusd, time, 2);
						
						Mainview.frame.repaint();
						insert_eurusd = insert_eurusd+1;
					}
					if(insert_eurusd == 1){
						manageJTable.addToTable(eurusd_scene.eurusd_table, insert_eurusd, c,0);
						compare_eurusd = c;
						Mainview.eurusd.setCurrentPrice(c);
						manageJTable.addToTable(eurusd_scene.eurusd_table,insert_eurusd,compare_eurusd,1);
						manageJTable.addToTable(eurusd_scene.eurusd_table, insert_eurusd, time, 2);
						
						Mainview.frame.repaint();
						insert_eurusd = insert_eurusd+1;
					}
				}
			}
			else{
				if(c.charAt(3) != '.'){
					ret = "GBP/USD";
					//System.out.println(ret); -- check which is being inputted for the currency.
					int number = tableLogic.convertStringtoInt(compare_gbpusd);
					int difference = tableLogic.convertStringtoInt(c) - number;
					String result = Integer.toString(difference);
				
					if(insert_gbpusd == gbpusd_scene.gbpusd_table.getRowCount()-1){
						Mainview.gbpusd.setCurrentPrice(c);
						manageJTable.addToTable(gbpusd_scene.gbpusd_table, insert_gbpusd, c,0);
						manageJTable.addToTable(gbpusd_scene.gbpusd_table,insert_gbpusd,result,1);
						manageJTable.addToTable(gbpusd_scene.gbpusd_table, insert_gbpusd, time, 2);
						Mainview.frame.repaint();
						insert_gbpusd = 1;			
					}
					else{
						if(insert_gbpusd != 1){
							manageJTable.addToTable(gbpusd_scene.gbpusd_table, insert_gbpusd, c,0);
							Mainview.gbpusd.setCurrentPrice(c);
							difference = tableLogic.convertStringtoInt(c) - number;
							result = Integer.toString(difference);
							manageJTable.addToTable(gbpusd_scene.gbpusd_table,insert_gbpusd,result,1);
							manageJTable.addToTable(gbpusd_scene.gbpusd_table, insert_gbpusd, time, 2);
						
							Mainview.frame.repaint();
							insert_gbpusd = insert_gbpusd+1;
						}
						if(insert_gbpusd == 1){
							Mainview.gbpusd.setCurrentPrice(c);
							manageJTable.addToTable(gbpusd_scene.gbpusd_table, insert_gbpusd, c,0);
							compare_gbpusd = c;
							manageJTable.addToTable(gbpusd_scene.gbpusd_table,insert_gbpusd,compare_gbpusd,1);
							manageJTable.addToTable(gbpusd_scene.gbpusd_table, insert_gbpusd, time, 2);
						
							Mainview.frame.repaint();
							insert_gbpusd = insert_gbpusd+1;
						}
					}
				}
			}
		}
		return ret;
	}
	public static String convertIntToString(int c){
		String b =Integer.toString(c);
		String first = b.substring(0,3);
		String second = b.substring(3,5);
		return first + "." + second ;
	}
	public static int convertStringtoInt(String c){
		
			int length = c.length();
			int ret = 0;
			if(c.charAt(3) == '.'){
				String first = c.substring(0,3); //Before decimal point.
				String second = c.substring(4,6); //After decimal point.
				String re = first + second;
				ret =  Integer.valueOf(re);
			}
			else{
				String first = c.substring(0,1); //Before decimal point.
				String second = c.substring(2,6); //After decimal point.
				String re = first + second;
				ret =  Integer.valueOf(re);
			}
			return ret;
		};
		
		
}
