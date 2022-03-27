package xml;

import java.io.File;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLFileUsingDOM {

	public static final String xmlFilePath = "C:\\Users\\ionut\\eclipse-workspace\\project\\taxpayers.xml";
    
private	ArrayList<String> names = new ArrayList<>();
private	ArrayList<String> firstnames = new ArrayList<>();
private	ArrayList<String> lastnames = new ArrayList<>();
private	ArrayList<String> lands = new ArrayList<>();
private	ArrayList<String> cars = new ArrayList<>();
	
	public void display() {
		try {
			File xmlDoc = new File("taxpayers.xml");
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			Document doc = dBuild.parse(xmlDoc);
			// read root element
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("person");
			

			System.out.println("Done creating XML File");
			
			firstnames.clear();
		    lastnames.clear();
		    lands.clear();
		    cars.clear();
		    names.clear();
			
			
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				System.out.println("Node name: " + nNode.getNodeName() + " " + (i + 1));
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
				//	System.out.println("Person ID: " + eElement.getAttribute("idno"));
				//	System.out.println("Person First Name: "
				//			+ eElement.getElementsByTagName("firstname").item(0).getTextContent());
				//	System.out.println("Person Last Name: "
				//			+ eElement.getElementsByTagName("lastname").item(0).getTextContent());
				//	System.out.println("Land size:"
				//			+ eElement.getElementsByTagName("land").item(0).getTextContent());
				//	System.out.println("------------------------------ ");
					
					
					String lastName = eElement.getElementsByTagName("lastname").item(0).getTextContent();
				    String firstName = eElement.getElementsByTagName("firstname").item(0).getTextContent();
				    String land = eElement.getElementsByTagName("land").item(0).getTextContent();
				    String car = eElement.getElementsByTagName("carCapacity").item(0).getTextContent();
				    firstnames.add(firstName);
				    lastnames.add(lastName);
				    lands.add(land);
				    cars.add(car);
				    names.add(lastName + " " + firstName);
				}
			}
			//sort by name
			//Collections.sort(names);
		   // System.out.println("Names:" +names);
		  //  System.out.println("FirstNames:" +firstnames);
		  //  System.out.println("LastNames:" +lastnames);
		  //  System.out.println("Lands:" +lands);
		  //  System.out.println("Cars:" +cars);
			
		  
			//number of elements
		//  System.out.println("Number of elements: "+nList.getLength());  (the number of elements in the list)
			
			  
		} catch (Exception e) {
		}
	}

	public ArrayList<String> getNames() {
		return names;
	}

	public ArrayList<String> getFirstnames() {
		return firstnames;
	}

	public ArrayList<String> getLastnames() {
		return lastnames;
	}

	public ArrayList<String> getLands() {
		return lands;
	}

	public ArrayList<String> getCars() {
		return cars;
	}
	
	

}
