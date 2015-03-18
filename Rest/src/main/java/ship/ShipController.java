package ship;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

@RestController
public class ShipController {

    //Request a ship with a certain name?
    @RequestMapping(value="/ship/{name}")
    public Ship getShip(@PathVariable String name) {

    	ShipList ships = new ShipList();

        //Static ships for now
    	ships.addShip(new Ship(1, "Jonken1"));
    	ships.addShip(new Ship(2, "Jonken2"));
    	ships.addShip(new Ship(3, "Henki"));
        ReadXMLFile();
        // Is the name in the list?
        return ships.findShip(name);
    }

    public void ReadXMLFile(){

        try {
     
          File fXmlFile = new File("F:/TNM094 - Kandidatprojekt/webapplikation/colu/Rest/src/main/java/ship/Voyage_and_shipdata/ship_101.xml");
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(fXmlFile);
         
          //optional, but recommended
          //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
          doc.getDocumentElement().normalize();
         
         // System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
         
          NodeList nList = doc.getElementsByTagName("ship");
         
          for (int temp = 0; temp < nList.getLength(); temp++) {
         
            Node nNode = nList.item(temp);
         
            // System.out.println("\nCurrent Element :" + nNode.getNodeName());
         
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
         
              Element eElement = (Element) nNode;
              
              // System.out.println("Staff id : " + eElement.getAttribute("comment"));

              System.out.println(eElement.getElementsByTagName("comment").item(0).getTextContent());
              System.out.println("ID PÅ SHIP " + eElement.getAttribute("id"));
              System.out.println(eElement.getElementsByTagName("description").item(0).getTextContent());
              System.out.println(eElement.getElementsByTagName("contact").item(0).getTextContent());
              System.out.println(eElement.getElementsByTagName("onboardsystem").item(0).getTextContent());

            }
          }
        } catch (Exception e) {
             e.printStackTrace();
        }
          
    }
}