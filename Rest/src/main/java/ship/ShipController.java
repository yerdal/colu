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

   /*     ShipList ships = new ShipList();

        //Static ships for now

        ships.addShip(new Ship(1, "Jonken1"));
        ships.addShip(new Ship(2, "Jonken2"));
        ships.addShip(new Ship(3, "Henki"));*/
        Ship myShip = getXMLShip();

        // Is the name in the list?
       // return ships.findShip(name);
        return myShip;
    }



    public Ship getXMLShip(){

        try {
     
          File fXmlFile = new File("/Users/einarsandberg/Documents/Voyage_ship_data/ship_1063.xml");
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(fXmlFile);
        
          //optional, but recommended
          //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
          doc.getDocumentElement().normalize();
         
         
          NodeList nList = doc.getElementsByTagName("ship");
        
            for (int temp = 1; temp < nList.getLength(); temp++) 
            {
         
                Node nNode = nList.item(temp);
         
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());
         
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
         
                    Element eElement = (Element) nNode;
                    int shipID = Integer.parseInt(eElement.getAttribute("id"));
                    String values = eElement.getAttribute("values");
                    
                    String[] parts = values.split(";",34);
                    for (int i = 0; i < parts.length; i++)
                    {
                        System.out.println(parts[i] + "\n");              
                    }

                    Ship theShip = new Ship(shipID, parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9], parts[10],
                        parts[11], parts[12], parts[13], parts[14], parts[15], parts[16], parts[17], parts[18], parts[19], parts[20], parts[21], parts[22], 
                        parts[23], parts[24], parts[25], parts[26], parts[27], parts[28], parts[29], parts[30], parts[31], parts[32], parts[33]);
                    return theShip;
                }
          }
        } catch (Exception e) {
             e.printStackTrace();
        }
         return null; 
    }

}