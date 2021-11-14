import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class test {

	public static void main(String[] args) throws SQLException {
		
		File file = new File("..\\hierachy.xml");
			try   
				{  
				
				//an instance of factory that gives a document builder  
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
				//an instance of builder to parse the specified xml file  
				DocumentBuilder db = dbf.newDocumentBuilder();  
				Document doc = db.parse(file);  
				doc.getDocumentElement().normalize(); //Normalized strings to one line.
				Node rens = doc.getFirstChild(); //returns root element   
				NodeList nodeList = rens.getChildNodes();  //returns child elements of root 'classses' 
			  
				// For B
					for (int itr = 0; itr < nodeList.getLength(); itr++)   
						{  
							Node node = nodeList.item(itr);  
							String c = node.getTextContent();
						
							if(node.getNodeName()=="gondola"){
								System.out.println(c);
								System.out.println(c.length()); // correctly returns length
								System.out.println(c.indexOf('0')); // correctly returns index
								System.out.println(c.charAt(5)); //correctly returns character check charcaters 4 for cid 5 for pid and 6 for abstract.
								break;
							}
						}  
					Element start = doc.createElement("Bus");
					rens.appendChild(start);
				} 
			
			
					catch (Exception e)   
						{  
							e.printStackTrace();  
						}  
				}  
				
	}
