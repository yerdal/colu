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



    private Ship getXMLShip(){

        try {
     
          File fXmlFile = new File("C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata/ship_1063.xml");
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(fXmlFile);
        
          //optional, but recommended
          //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
          doc.getDocumentElement().normalize();
         
         
          NodeList nList = doc.getElementsByTagName("ship");
            //System.out.println(nList.getLength() + "\n" + "\n"); 
            for (int temp = 1; temp < nList.getLength(); temp++) 
            {
                Node nNode = nList.item(temp); //get the second Ship node
  
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {
                    Element eElement = (Element) nNode;
                    int shipID = Integer.parseInt(eElement.getAttribute("id"));

                    String shipValues = eElement.getAttribute("values");
                    
                    String[] shipParts = shipValues.split(";", 34);
                    for (int i = 0; i < shipParts.length; i++)
                    {
                        //System.out.println(shipParts[i] + "\n");              
                    }
                    
                    String shipComment = eElement.getElementsByTagName("comment").item(0).getTextContent();
                    String shipDesc = eElement.getElementsByTagName("description").item(0).getTextContent();
          
        

                    Ship theShip = new Ship(shipID, parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8], parts[9], parts[10],
                        parts[11], parts[12], parts[13], parts[14], parts[15], parts[16], parts[17], parts[18], parts[19], parts[20], parts[21], parts[22], 
                        parts[23], parts[24], parts[25], parts[26], parts[27], parts[28], parts[29], parts[30], parts[31], parts[32], parts[33], shipComment, shipDesc);
                    return theShip;
                }
                NodeList contactList = doc.getElementsByTagName("contact");
                for (int k = 1; k < contactList.getLength(); k++)
                {
                    Node contactNode = contactList.item(k);

                    if (contactNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                      Element eElement = (Element) contactNode;
                      int contactID  = Integer.parseInt(eElement.getAttribute("id"));
                      String contactValues = eElement.getAttribute("values");
                      String[] contactParts = contactValues.split(";", 4);
                      for (int i = 0; i < contactParts.length; i++)
                      {
                        //System.out.println(contactParts[i] + " ");
                      }

                    }
                }
                NodeList operatorList = doc.getElementsByTagName("operator");
                for (int j = 1; j < operatorList.getLength(); j++)
                {
                    Node operatorNode = operatorList.item(j);
                    if (operatorNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                      Element eElement = (Element) operatorNode;
                      int operatorID = Integer.parseInt(eElement.getAttribute("id"));
                      String operatorValues = eElement.getAttribute("values");
                      String [] operatorParts = operatorValues.split(";", 5);
                      for (int n = 0; n < operatorParts.length; n++)
                      {
                        System.out.println(operatorParts[n] + " ");
                      }
                    }
                }



          }

        
        } catch (Exception e) {
             e.printStackTrace();
        }
         return null; 
    }



}