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
import java.util.ArrayList;

@RestController
public class ShipController {

    //Request a ship with a certain name?
    @RequestMapping(value="/ships")
    public ArrayList getShip(@PathVariable String name) {

   /*     ShipList ships = new ShipList();

        //Static ships for now

        ships.addShip(new Ship(1, "Jonken1"));
        ships.addShip(new Ship(2, "Jonken2"));
        ships.addShip(new Ship(3, "Henki"));*/
        ArrayList<Ship> myShips = getXMLShip();

        // Is the name in the list?
       // return ships.findShip(name);
        return myShips;
    }



    private ArrayList getXMLShip(){
        ArrayList<Ship> shipsArray = new ArrayList<Ship>();
        try {
     
          // OSKAR C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata
          File fXmlFile = new File("C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata/ships.xml");

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
          
                    Operator operator =  new Operator(Integer.parseInt(shipParts[0]));

                    Ship theShip = new Ship(shipID, operator, shipParts[1], shipParts[2], shipParts[3], shipParts[4], shipParts[5], shipParts[6], shipParts[7], shipParts[8], shipParts[9], shipParts[10],
                        shipParts[11], shipParts[12], shipParts[13], shipParts[14], shipParts[15], shipParts[16], shipParts[17], shipParts[18], shipParts[19], shipParts[20], shipParts[21], shipParts[22], 
                        shipParts[23], shipParts[24], shipParts[25], shipParts[26], shipParts[27], shipParts[28], shipParts[29], shipParts[30], shipParts[31], shipParts[32], shipParts[33], shipComment, shipDesc);
                    shipsArray.add(theShip);
                    
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
                      System.out.println(" \n Contact VALUES  ");
                      for (int i = 0; i < contactParts.length; i++)
                      {
                        System.out.println(contactParts[i] + " ");
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
                      System.out.println(" \n OPERATOR VALUE  ");
                      for (int n = 0; n < operatorParts.length; n++)
                      {
                        System.out.println(operatorParts[n] + " ");
                      }
                    }
                }

                



          }
          return shipsArray;

        
        } catch (Exception e) {
             e.printStackTrace();
        }
         return null; 
    }

    // private ArrayList getXMLShipPolls(){
    //     ArrayList<Ship> shipsArray = new ArrayList<Ship>();
    //     try {
     
    //       // OSKAR C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata
    //       File fXmlFile = new File("C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata/polls.xml");

    //       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    //       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    //       Document doc = dBuilder.parse(fXmlFile);
        
    //       //optional, but recommended
    //       //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    //       doc.getDocumentElement().normalize();
          
         
    //       NodeList nList = doc.getElementsByTagName("ship");
    //         //System.out.println(nList.getLength() + "\n" + "\n"); 
    //         for (int temp = 1; temp < nList.getLength(); temp++) 
    //         {
    //             Node nNode = nList.item(temp); //get the second Ship node
  
    //             if (nNode.getNodeType() == Node.ELEMENT_NODE) 
    //             {
    //               NodeList nList_pos = eElement.getElementsByTagName("satcpollposition");
    //               //System.out.println(nList.getLength() + "\n" + "\n"); 
    //               for (int temp = 1; temp < nList.getLength(); temp++) 
    //               {
                        
                    
                    
    //             }
    //             NodeList contactList = doc.getElementsByTagName("contact");
    //             for (int k = 1; k < contactList.getLength(); k++)
    //             {
    //                 Node contactNode = contactList.item(k);

    //                 if (contactNode.getNodeType() == Node.ELEMENT_NODE)
    //                 {
    //                   Element eElement = (Element) contactNode;
    //                   int contactID  = Integer.parseInt(eElement.getAttribute("id"));
    //                   String contactValues = eElement.getAttribute("values");
    //                   String[] contactParts = contactValues.split(";", 4);
    //                   System.out.println(" \n Contact VALUES  ");
    //                   for (int i = 0; i < contactParts.length; i++)
    //                   {
    //                     System.out.println(contactParts[i] + " ");
    //                   }

    //                 }
    //             }
    //             NodeList operatorList = doc.getElementsByTagName("operator");
    //             for (int j = 1; j < operatorList.getLength(); j++)
    //             {
    //                 Node operatorNode = operatorList.item(j);
    //                 if (operatorNode.getNodeType() == Node.ELEMENT_NODE)
    //                 {
    //                   Element eElement = (Element) operatorNode;
    //                   int operatorID = Integer.parseInt(eElement.getAttribute("id"));
    //                   String operatorValues = eElement.getAttribute("values");
    //                   String [] operatorParts = operatorValues.split(";", 5);
    //                   System.out.println(" \n OPERATOR VALUE  ");
    //                   for (int n = 0; n < operatorParts.length; n++)
    //                   {
    //                     System.out.println(operatorParts[n] + " ");
    //                   }
    //                 }
    //             }

                



    //       }
    //       return shipsArray;

        
    //     } catch (Exception e) {
    //          e.printStackTrace();
    //     }
    //      return null; 
    // }



}