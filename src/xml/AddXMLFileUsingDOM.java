package xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AddXMLFileUsingDOM {

	public static final String xmlFilePath = "C:\\Users\\ionut\\eclipse-workspace\\project\\taxpayers.xml";
	
	private String fname;
	private String lname;
	private String l;
	private String capacity;
	public AddXMLFileUsingDOM(String fname,String lname,String l,String capacity ) {
		
		this.fname=fname;
		this.lname=lname;
		this.l=l;
		this.capacity=capacity;
	}
    
	public void add() {
		try {
			File xmlDoc = new File("taxpayers.xml");
			DocumentBuilderFactory dbFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dbFact.newDocumentBuilder();
			Document doc = dBuild.parse(xmlDoc);
			NodeList nList = doc.getElementsByTagName("person");
			// read root element
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
			doc.getElementsByTagName("person");
			Element root = doc.getDocumentElement();
			Element person = doc.createElement("person");

			root.appendChild(person);
			String idno=String.valueOf(nList.getLength());
			String landvalue=String.valueOf(l);
			String carCapacity=String.valueOf(capacity);
			// set an attribute to staff element
			Attr attr = doc.createAttribute("idno");
			attr.setValue(idno);
			person.setAttributeNode(attr);

			// you can also use staff.setAttribute("id", "1") for this

			// firstname element
			Element firstName = doc.createElement("firstname");
			firstName.appendChild(doc.createTextNode(fname));
			person.appendChild(firstName);

			// lastname element
			Element lastname = doc.createElement("lastname");
			lastname.appendChild(doc.createTextNode(lname));
			person.appendChild(lastname);

			// email element
			
			Element land = doc.createElement("land");
			land.appendChild(doc.createTextNode(l));
			person.appendChild(land);
			
			Element car= doc.createElement("carCapacity");
			car.appendChild(doc.createTextNode(capacity));
			person.appendChild(car);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

			// If you use
			// StreamResult result = new StreamResult(System.out);
			// the output will be pushed to the standard output ...
			// You can use that for debugging

			transformer.transform(domSource, streamResult);

			System.out.println("Done creating XML File");

		
            
		} catch (Exception e) {
		}
	}


}