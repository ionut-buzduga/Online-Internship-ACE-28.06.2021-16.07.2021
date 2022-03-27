package xml;


import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class RemXMLFileUsingDOM {
	public static final String xmlFilePath = "C:\\Users\\ionut\\eclipse-workspace\\project\\taxpayers.xml";
    private int id;
    public RemXMLFileUsingDOM(int id) {
		this.id=id;
	}
	public void remove() {
		try {
			  File xmlDoc = new File("taxpayers.xml");
			    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			    DocumentBuilder db = dbf.newDocumentBuilder();
			    
			    Document doc = db.parse(xmlDoc);
			    NodeList nList = doc.getElementsByTagName("person");
			    
			    
			    Element element = (Element) doc.getElementsByTagName("person").item(id-1);
                   
			    Node parent = element.getParentNode();
			    parent.removeChild(element);
			    parent.normalize();
			    
			    
			  
			    TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				
				DOMSource domSource = new DOMSource(doc);
				StreamResult streamResult = new StreamResult(new File(xmlFilePath));
				transformer.transform(domSource, streamResult);
				System.out.println("removed");

		
		} catch (Exception e) {
		}
	}
	
	public void changeID() {
		try {
			  File xmlDoc = new File("taxpayers.xml");
			    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			    DocumentBuilder db = dbf.newDocumentBuilder();
			    
			    Document doc = db.parse(xmlDoc);
			    NodeList nList = doc.getElementsByTagName("person");
			    
			    
			    
                 
			    for (int i = id-1; i < nList.getLength(); i++) {
					Node nNode = nList.item(i);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						String idno=String.valueOf(id);
						eElement.setAttribute("idno",idno );
						id=id+1;
					}
				}
			    
			    
			  
			    TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				
				DOMSource domSource = new DOMSource(doc);
				StreamResult streamResult = new StreamResult(new File(xmlFilePath));
				transformer.transform(domSource, streamResult);
				System.out.println("changed id");

		
		} catch (Exception e) {
		}
	}
}