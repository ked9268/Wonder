
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Controller
public class extractClassInfo {
	File file = new File("..//classes.xml");
	connectToDatabase hero = new connectToDatabase();
	// A
	@RequestMapping(value = "/cheditor/api/addclass", method = RequestMethod.GET)
	public String addclass(@RequestParam(value = "cid",required = true) int cid,
						@RequestParam(value = "name",required = true) String name,
						@RequestParam(value = "abstract",required = false) boolean class_is_abstract,
						@RequestParam(value = "pid",required = false) int pid){
		try {
		} catch (SQLException e) {
			
		}
				String variable=null;
				PreparedStatement pstmt;
				//response in json.
				if(){
					return "{"+"\""+"ret"+"\""+":"+"\"true\""+"}";
				}
				else{
					return "{"+"\n"+"\""+"ret"+"\""+":"+"\"false\""+","+"\n"
				+"\""+"message"+":"+"\""+variable+"\"";
				}
				//JSON request.
					return "{"+"\n"+"\""+"cid"+"\""+cid+"\""+","+"\n"
				+"\""+"name"+"\""+":"+name+","+"\n"
					+"\""+"abstract"+"\""+":"+"\""+class_is_abstract+"\n"+"}";
	}
	
	// B 
	@RequestMapping(value = "/cheditor/api/getclass/{cid}", method=RequestMethod.GET)
	public String getInfo(@PathVariable("cid") int cid){
		//Get information from table for class variables name and class is abstract.
		//Json string
		boolean tried=true;
		File file = new File("..\\hierachy.xml");
		String pid_info = "";
		boolean class_is_abstract = false;
		String cid_info ="";
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
							System.out.println(c.length()); // correctly returns length
							System.out.println(c.indexOf('0')); // correctly returns index
							System.out.println(c.charAt(5)); //correctly returns character check charcaters 4 for cid 5 for pid and 6 for abstract.
							cid = c.charAt(4);
							switch(c.charAt(5)){
							case '1':
								pid_info = "Vehicle";
							case '2':
								pid_info = "Car";
							case '3':
								pid_info = "Plane";
							case '4':
								pid_info = "Watercraft";
							case '5':
								pid_info = "Ship";
							case '6':
								pid_info = "Boat";
							case '7':
								pid_info = "Powerboat";
							case '8':
								pid_info = "Rowingboat";
							case '9':
								pid_info = "Gondola";
							}
							switch(c.charAt(4)){
							case '1':
								cid_info = "Vehicle";
							case '2':
								cid_info = "Car";
							case '3':
								cid_info = "Plane";
							case '4':
								cid_info = "Watercraft";
							case '5':
								cid_info = "Ship";
							case '6':
								cid_info = "Boat";
							case '7':
								cid_info = "Powerboat";
							case '8':
								cid_info = "Rowingboat";
							case '9':
								cid_info = "Gondola";
							}
							if (c.charAt(6) == 1){
								class_is_abstract = true;
							}
							else{
								class_is_abstract = false;
							}
							break;
						}
					}  
			} 
		
		
				catch (Exception e)   
					{  
						e.printStackTrace();  
					}  
			  
			
		if(tried = true){
			return "{"+"\n"+"\""+"cid"+"\""+cid_info+"\""+","+"\n"
					+"\""+"name"+"\""+":"+pid_info+","+"\n"
						+"\""+"abstract"+"\""+":"+"\""+class_is_abstract+"\n"+"}";
		}
		else{
			return "{"+"\n"+"\""+"ret"+"\""+":"+"\"false\""+","+"\n"
					+"\""+"message"+":"+"\""+"cid "+cid+"doesnt exist"+"\"";
		}
	}
	
	// C
	@RequestMapping(value = "/cheditor/api/getclass/{cid}", method = RequestMethod.GET)
	public String deleteClass(@PathVariable("cid")int cid){
		boolean tried= true;
		
		if(tried){
			return "{"+"\""+"ret"+"\""+":"+"\"true\""+"}";
		}
		else{
			return "{"+"\n"+"\""+"ret"+"\""+":"+"\"false\""+","+"\n"
					+"\""+"message"+":"+"\""+"cid "+cid+"doesnt exist"+"\"";
		}
	}
	// D
	@RequestMapping(value = "/cheditor/api/superclasses/{cid}",method = RequestMethod.GET)
	public String getSuperClasses(@PathVariable("cid") int cid){
		boolean tried = true;
		if(tried = true){
			
		}
		else{
			return "{"+"\n"+"\""+"result"+"\""+":"+"\"false\""+","+"\n"
					+"\""+"message"+":"+"\""+"cid "+cid+"doesnt exist"+"\"";
		}
	}
	// E
	@RequestMapping(value = "/cheditor/api/subclasses/{cid}",method = RequestMethod.GET)
	public String getSubClasses(@PathVariable("cid") int cid){
		return "";
	}
	
}