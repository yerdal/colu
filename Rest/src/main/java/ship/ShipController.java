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
    @RequestMapping(value="/ships/{name}")
    public ArrayList getShip(@PathVariable String name) {

   /*     ShipList ships = new ShipList();

        //Static ships for now

        ships.addShip(new Ship(1, "Jonken1"));
        ships.addShip(new Ship(2, "Jonken2"));
        ships.addShip(new Ship(3, "Henki"));*/
        // ArrayList<Ship> myShips = getXMLShip();
        ArrayList<Ship> myShips_pos = getXMLShipPolls();

        // Is the name in the list?
       // return ships.findShip(name);
        return myShips_pos;
    }



    private ArrayList getXMLShip(){
        ArrayList<Ship> shipsArray = new ArrayList<Ship>();
        try {
     
          // OSKAR C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata
          // Mattias /Users/mattiaspalmgren/Dropbox/MT/temp/Voyage_and_ship_data/ships.xml
          File fXmlFile = new File("/Users/mattiaspalmgren/Dropbox/MT/temp/Voyage_and_ship_data/ships.xml");

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

    private ArrayList getXMLShipPolls(){
        ArrayList<Ship> shipsArray = new ArrayList<Ship>();
        
        try {
          // Mattias: /Users/mattiaspalmgren/Dropbox/MT/temp/Voyage_and_ship_data/polls.xml
          // OSKAR C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata
          File fXmlFile = new File("C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata/polls.xml");

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
                  //New array with positions for every ship 
                  ArrayList<SatCPollPosition> satCPollArray = new ArrayList<SatCPollPosition>();

                  Element tempShipElement = (Element) nNode;
                  int shipID = Integer.parseInt(tempShipElement.getAttribute("id"));
                  String shipValues = tempShipElement.getAttribute("values");

                  String[] shipParts = shipValues.split(";", 34);
                  //get the operator ID  shipParts[0]
                  Operator tempOperator = new Operator(Integer.parseInt(shipParts[0])); 
                  Ship tempShip = new Ship(shipID, tempOperator, shipParts[4]);
                  
                  NodeList nList_pos = tempShipElement.getElementsByTagName("satcpollposition");

                  //System.out.println(nList.getLength() + "\n" + "\n"); 
                  for (int j = 0; j < nList_pos.getLength(); j++) 
                  {
                    Node positionNode = nList_pos.item(j);

                    if (positionNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                      Element eSatCPosElement = (Element) positionNode;
                      double lon  = Double.parseDouble(eSatCPosElement.getAttribute("lon"));
                      double lat  = Double.parseDouble(eSatCPosElement.getAttribute("lat"));
                      int id  = Integer.parseInt(eSatCPosElement.getAttribute("id"));
                      String date = eSatCPosElement.getAttribute("date");
                      String posValues = eSatCPosElement.getAttribute("values");
                      String[] posParts = posValues.split(";", 5);
                      //  System.out.println(" \n Posiiton VALUES  ");
                      // for (int i = 0; i < posParts.length; i++)
                      // {
                      //   System.out.println(posParts[i] + " ");
                      // }

                      SatCPollPosition position = new SatCPollPosition(id, lon, lat, date, 
                           parseDoubleSafely(posParts[0]), parseDoubleSafely(posParts[1]), posParts[2], parseDoubleSafely(posParts[3]));
                      
                      satCPollArray.add(position);
                    }


                  }
                   
                  tempShip.setPollPositions(satCPollArray); 
                  shipsArray.add(tempShip);
                    
                }

                              



          }
          return shipsArray;

        
        } catch (Exception e) {
             e.printStackTrace();
        }
         return null; 
    }

    //Method for returning 0 if string empty
  public static double parseDoubleSafely(String str) {
    double result = 0;
    try {
        result = Double.parseDouble(str);
    } catch (NullPointerException npe) {
    } catch (NumberFormatException nfe) {
    }
    return result;
}
}