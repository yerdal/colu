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
    private ArrayList getXMLShipVoyage(){
        ArrayList<Voyage> voyageArray = new ArrayList<Voyage>();

        try {
          // Mattias: /Users/mattiaspalmgren/Dropbox/MT/temp/Voyage_and_ship_data/polls.xml
          // OSKAR C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata
          File fXmlFile = new File("C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata/voyage_89710.xml");

          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(fXmlFile);
        
          //optional, but recommended
          //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
          doc.getDocumentElement().normalize();
          
         
          NodeList nList = doc.getElementsByTagName("voyage");
            //System.out.println(nList.getLength() + "\n" + "\n"); 
            for (int temp = 1; temp < nList.getLength(); temp++) 
            {
                Node nNode = nList.item(temp); //get the second voyage node the first node for description
    
                if (nNode.getNodeType() == Node.ELEMENT_NODE) 
                {

                  Element tempVoyageEl = (Element) nNode;
                  int voyageID = Integer.parseInt(tempVoyageEl.getAttribute("id"));
                  String voyageComment = tempVoyageEl.getElementsByTagName("comment").item(0).getTextContent();
                  int worklistid = tempVoyageEl.getElementsByTagName("worklistid");
                  String systemonboardstatus = tempVoyageEl.getElementsByTagName("systemonboardstatus"); 
                  String state = tempVoyageEl.getElementsByTagName("state");
                  String pvapdf = tempVoyageEl.getElementsByTagName("pvapdf");
                  String lastupdate =  tempVoyageEl.getElementsByTagName("lastupdate");



                  String voyValues = tempVoyageEl.getAttribute("values");

                  String[] voyageValues = voyValues.split(";", 34);
                  String voyageName = voyageValues[0];
                  String voyageVoyref = voyageValues[1];
                  String operatorName; = voyageValues[2];
                  String personName = voyageValues[3]; 
                  String shipEmployment = voyageValues[4];
                  String shipTypeName = voyageValues[5];
                  String shipVoyage = tempVoyageEl.getElementsByTagName("ship");
                  String shipId = Integer.parseInt(shipVoyage.getAttribute("id"));
                  
                  String ship = new Ship(shipId, theOperator, "defaultName");
                  String voyageDeparture = voyageValues[6];
                  String voyageDestination = voyageValues[7];
                  String voyageEtd = voyageValues[8];
                  String voyageEta = voyageValues[9];
                  String voyageRequired_eta = voyageValues[10];
                  String voyageLoading = voyageValues[11];
                  String voyageCargoweight = voyageValues[12];
                  String voyageCargosensitiv = voyageValues[13];
                  String voyageGmheight = voyageValues[14];
                  String voyageDisplacement_at_dep = voyageValues[15];
                  String voyageMaxspeed =  voyageValues[16];
                  String voyageDraft_aft = voyageValues[17];
                  String voyageDraft_fwd = voyageValues[18];
                  String voyageDraft_mean = voyageValues[19];
                  String voyageDraft_trim = voyageValues[20];
                  String tradelaneName = voyageValues[21];
                  String voyagePhase = voyageValues[22];
                  String voyageHasroute = voyageValues[23];
                  String voyageNextMessageDate = voyageValues[24];
                  String voyagePriority =  voyageValues[25];
                  String seaName = voyageValues[26];
                  String seaSortOrder = voyageValues[27];
                  String forecastModifieddate = voyageValues[28];
                  String forecastState =  voyageValues[29];
                  String voyageFo_brob_dep = voyageValues[30];
                  String voyageDo_brob_dep = voyageValues[31];
                  String voyageFo_brob_latest = voyageValues[32];
                  String voyageDo_brob_latest =  voyageValues[33];
                  String voyageHas_pva = voyageValues[34];
                  //get the operator ID  voyageValues[0]
                  //Alarms 
                  NodeList nList_alarms = tempShipElement.getElementsByTagName("alarms");
                  //System.out.println(nList.getLength() + "\n" + "\n"); 
                  for (int j = 0; j < nList_alarms.getLength(); j++) 
                  {
                    Node alarmNode = nList_alarms.item(j);

                    if (alarmNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                      Element alarmEl = (Element) alarmNode;
                      String warning  = alarmEl.getAttribute("warn"));
                      String alert = alarmEl.getAttribute("alert"));
                      String summary  = alarmEl.getAttribute("summary"));
                      String alarmVal = alarmEl.getAttribute("values");
                      String[] alarmValues = alarmVal.split(";", 2);
                      //TODO MAKE ALARM CLASS

                    }
                  }
                  //Weather Way points
                  ArrayList<WeatherWayPoint> weatherWayPointArray = new ArrayList<WeatherWayPoint>();
                  NodeList nList_weatherWayPoint = tempShipElement.getElementsByTagName("weatherwaypoint");
                  
                  for (int j = 0; j < nList_weatherWayPoint.getLength(); j++) 
                  {
                    Node weatherwayNode = nList_weatherWayPoint.item(j);

                    if (weatherwayNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                      Element weatherWayEl = (Element) weatherwayNode;
                      String weatherLon  = weatherWayEl.getAttribute("lon"));
                      String legType = weatherWayEl.getAttribute("legtype"));
                      String weatherLat  = weatherWayEl.getAttribute("lat"));
                      String date  = weatherWayEl.getAttribute("date"));
                      String weatherWayPVal = weatherWayEl.getAttribute("values");
                      String[] weatherWayPValues = weatherWayEl.split(";", 16);
                      
                      double weatherwaypointWindspeed = parseDoubleSafely(weatherWayPValues[0]);
                      double weatherwaypointWinddir = parseDoubleSafely(weatherWayPValues[1]);
                      double weatherwaypointSwellh = parseDoubleSafely(weatherWayPValues[2]);
                      double weatherwaypointSwelldir = parseDoubleSafely(weatherWayPValues[3]);
                      double weatherwaypointSwellperiod = parseDoubleSafely(weatherWayPValues[4)] 
                      double weatherwaypointCurrentspeed = parseDoubleSafely(weatherWayPValues[5]);
                      double weatherwaypointCurrentdir = parseDoubleSafely(weatherWayPValues[6]);
                      double weatherwaypointPressure = parseDoubleSafely(weatherWayPValues[7]);
                      double weatherwaypointSignwaveh = parseDoubleSafely(weatherWayPValues[8]);
                      double weatherwaypointWindwaveh = parseDoubleSafely(weatherWayPValues[9]);
                      double weatherwaypointWindwaveperiod = parseDoubleSafely(weatherWayPValues[10]);
                      double weatherwaypointCalcshipspeed = parseDoubleSafely(weatherWayPValues[11]);
                      double weatherwaypointWeatherfactor = parseDoubleSafely(weatherWayPValues[12]);
                      double weatherwaypointCurrentfactor = parseDoubleSafely(weatherWayPValues[13]);
                      double weatherwaypointCalcdistance = parseDoubleSafely(weatherWayPValues[14]);
                      double weatherwaypointGoodweather = parseDoubleSafely(weatherWayPValues[15]);

                      WeatherWayPoint tempPoint = new WeatherWayPoint(weatherwaypointWindspeed,
                                                                      weatherwaypointWinddir,
                                                                      weatherwaypointSwellh,
                                                                      weatherwaypointSwelldir,
                                                                      weatherwaypointSwellperiod,
                                                                      weatherwaypointCurrentspeed,
                                                                      weatherwaypointCurrentdir,
                                                                      weatherwaypointPressure,
                                                                      weatherwaypointSignwaveh,
                                                                      weatherwaypointWindwaveh,
                                                                      weatherwaypointWindwaveperiod,
                                                                      weatherwaypointCalcshipspeed,
                                                                      weatherwaypointWeatherfactor,
                                                                      weatherwaypointCurrentfactor,
                                                                      weatherwaypointCalcdistance,
                                                                      weatherwaypointGoodweather)
                      //Einar do magic!
                      weatherWayPointArray.add(tempPoint);

                    }
                  }
                  Voyage voyage = new Voyage(voyageID, voyageComment, worklistid,systemonboards,state,
                                              pvapdf, lastupdate,
                                              voyageName,
                                              voyageVoyref,
                                              operatorName,
                                              personName,
                                              ship,
                                              voyageDeparture,
                                              voyageDestination,
                                              voyageEtd,
                                              voyageEta,
                                              voyageRequired_eta,
                                              voyageLoading,
                                              voyageCargoweight,
                                              voyageCargosensitiv,
                                              voyageGmheight,
                                              voyageDisplacement_at_dep,
                                              voyageMaxspeed,
                                              voyageDraft_aft,
                                              voyageDraft_fwd,
                                              voyageDraft_mean,
                                              voyageDraft_trim,
                                              tradelaneName,
                                              voyagePhase,
                                              voyageHasroute,
                                              voyageNextMessageDate,
                                              voyagePriority,
                                              seaName,
                                              seaSortOrder,
                                              forecastModifieddate,
                                              forecastState,
                                              voyageFo_brob_dep,
                                              voyageDo_brob_dep,
                                              voyageFo_brob_latest,
                                              voyageDo_brob_latest,
                                              voyageHas_pva,
                                              weatherWayPointArray)
                 
                  voyageArray.add(voyage);

                }

                        

          }
          return voyageArray;

        
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