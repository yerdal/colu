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

/**
 * Handling the rest API and parsing XML files
 */
@RestController
public class ShipController {
     /**
   * @param  id the id of the ship
   * @return      a Ship with given ID
   * @see         None
   */ 
    //Request a ship with a certain name?
    @RequestMapping(value="/ships/{id}")
    public ArrayList getShip(@PathVariable String id) {

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
    @RequestMapping(value="/ongoingVoyages/{name}")
        public ArrayList getOngoingVoyages(@PathVariable String name){
          ArrayList<OnVoyages> voyages = getOngoingVoyages();
          return voyages;
        }

    private ArrayList getOngoingVoyages(){
        ArrayList<OnVoyages> voyageArray = new ArrayList<OnVoyages>();

        try{
          //OSKAR C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata/
          // Einar /Users/einarsandberg/Documents/Voyage_ship_data/ongoingVoyages.xml
          File fXmlFile = new File("/Users/einarsandberg/Documents/Voyage_ship_data/ongoingVoyages.xml");

          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(fXmlFile);

          doc.getDocumentElement().normalize();

          NodeList nList = doc.getElementsByTagName("voyage");



            for(int temp = 1; temp < nList.getLength(); temp++)
            {
                Node nNode = nList.item(temp);

                if(nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                  Element eElement = (Element) nNode;
                  int voyageID = Integer.parseInt(eElement.getAttribute("id"));
                  String voyageValue = eElement.getAttribute("values");

                  //String[] voyageNames = voyageValue.split(";", 34);
                  

                  Node shipNode = eElement.getElementsByTagName("ship").item(0);

                 
                    //Node shipNode = shipList.item(temp1);
                  Element cElement = (Element) shipNode;
                  String shipValues = cElement.getAttribute("values");
                  String[] shipValuesArray = shipValues.split(";", 34);

                  OnVoyages theVoyage = new OnVoyages(voyageID, shipValuesArray[5]); 
                    voyageArray.add(theVoyage);

                }
                  
            }

            return voyageArray;
        }catch(Exception e){
            e.printStackTrace();
          }
          return null;

    }

    @RequestMapping(value="/voyages/{name}")
    public ArrayList getVoyage(@PathVariable String name) {
        ArrayList<Voyage> myVoyage_pos = getXMLShipVoyage();
        return myVoyage_pos;
    }

    private ArrayList getXMLShip(){
        ArrayList<Ship> shipsArray = new ArrayList<Ship>();
        try {
     
          // OSKAR C:/Users/Oskar Ankarberg/Desktop/Voyage_and_shipdata
          // Mattias /Users/mattiaspalmgren/Dropbox/MT/temp/Voyage_and_ship_data/ships.xml
          // Yusuf /Users/Yusuf/Documents/LIU/TNM094-KEX/Voyage_and_ship_data
          // EINAR /Users/einarsandberg/Documents/Voyage_ship_data/ship_101.xml
          File fXmlFile = new File("/Users/einarsandberg/Documents/Voyage_ship_data/ship_101.xml");

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
          // Yusuf /Users/Yusuf/Documents/LIU/TNM094-KEX/Voyage_and_ship_data
          // Einar /Users/einarsandberg/Documents/Voyage_ship_data/polls.xml
          File fXmlFile = new File("/Users/einarsandberg/Documents/Voyage_ship_data/polls.xml");

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
          // EINAR /Users/einarsandberg/Documents/Voyage_ship_data/voyage_89710.xml
          File fXmlFile = new File("/Users/einarsandberg/Documents/Voyage_ship_data/voyage_89710.xml");

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
                  int worklistid = parseIntSafely(tempVoyageEl.getAttribute("worklistid"));
                  String systemonboardstatus = tempVoyageEl.getAttribute("systemonboardstatus"); 
                  String state = tempVoyageEl.getAttribute("state");
                  String pvapdf = tempVoyageEl.getAttribute("pvapdf");
                  String lastupdate =  tempVoyageEl.getAttribute("lastupdate");



                  String voyValues = tempVoyageEl.getAttribute("values");

                  String[] voyageValues = voyValues.split(";", 35);
                  String voyageName = voyageValues[0];
                  String voyageVoyref = voyageValues[1];
                  String operatorName = voyageValues[2];
                  Operator ope = new Operator(2);
                  String personName = voyageValues[3]; 
                  String shipEmployment = voyageValues[4];
                  String shipTypeName = voyageValues[5];
                  Node shipVoyage = tempVoyageEl.getElementsByTagName("ship").item(0);
                  Element shipVoyageEl = (Element) shipVoyage;
                  int shipId = Integer.parseInt(shipVoyageEl.getAttribute("id"));
                  
                  Ship ship = new Ship(shipId, ope, "defaultName");
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
                  NodeList nList_alarms = tempVoyageEl.getElementsByTagName("alarms");
                  //System.out.println(nList.getLength() + "\n" + "\n"); 
                  for (int j = 0; j < nList_alarms.getLength(); j++) 
                  {
                    Node alarmNode = nList_alarms.item(j);

                    if (alarmNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                      Element alarmEl = (Element) alarmNode;
                      String warning  = alarmEl.getAttribute("warn");
                      String alert = alarmEl.getAttribute("alert");
                      String summary  = alarmEl.getAttribute("summary");
                      String alarmVal = alarmEl.getAttribute("values");
                      String[] alarmValues = alarmVal.split(";", 2);
                      //TODO MAKE ALARM CLASS

                    }
                  }
                  //SHIP REPORTS
                  ArrayList<ShipReport> shipReportsArray = new ArrayList<ShipReport>();
                  NodeList nList_shipReport = tempVoyageEl.getElementsByTagName("shipreport");
                  
                  for (int j = 0; j < nList_shipReport.getLength(); j++) 
                  {
                    Node shipReportNode = nList_shipReport.item(j);

                    if (shipReportNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                      Element shipReportEl = (Element) shipReportNode;
                      Node fuelOilNode = shipReportEl.getElementsByTagName("fuel-oil-performance").item(0);
                      Element fuilOilPerEl = (Element) fuelOilNode;

                      int baselineID = parseIntSafely(fuilOilPerEl.getAttribute("id")); 
                      String baselineVals = fuilOilPerEl.getAttribute("values");
                      String[] baselineValues = baselineVals.split(";", 7);
                      String baselineSelected = baselineValues[0];
                      String baselineOva_cons_performance = baselineValues[1];
                      String baselineOva_cons_performance_rep_diff = baselineValues[2];
                      String baselineOva_cons_performance_rep_diff_prcnt = baselineValues[3];
                      String baselinePva_cons_performance = baselineValues[4];
                      String baselinePva_cons_performance_rep_diff = baselineValues[5];
                      String baselinePva_cons_performance_rep_diff_prcnt = baselineValues[6];
                      FuelOilPerformance fuilOilPerf = new FuelOilPerformance(baselineID,
                                                                              baselineSelected,
                                                                              baselineOva_cons_performance,
                                                                              baselineOva_cons_performance_rep_diff,
                                                                              baselineOva_cons_performance_rep_diff_prcnt,
                                                                              baselinePva_cons_performance,
                                                                              baselinePva_cons_performance_rep_diff,
                                                                              baselinePva_cons_performance_rep_diff_prcnt);

                      int shipReportID  = parseIntSafely(shipReportEl.getAttribute("id"));
                      double shipLon  = parseDoubleSafely(shipReportEl.getAttribute("lon"));
                      String legType = shipReportEl.getAttribute("legtype");
                      double shipLat  = parseDoubleSafely(shipReportEl.getAttribute("lat"));
                      String date  = shipReportEl.getAttribute("date");
                      String shipReportVal = shipReportEl.getAttribute("values");
                      String[] shipReportValues = shipReportVal.split(";", 55);
                      
                      String repshipCosp_eosp = (shipReportValues[0]);
                      String repshipEta_earliest = (shipReportValues[1]);
                      double observationWindspeed = parseDoubleSafely(shipReportValues[2]);
                      double observationWindspeedbf = parseDoubleSafely(shipReportValues[3]);
                      double observationWinddir = parseDoubleSafely(shipReportValues[4]);
                      double observationWaveh = parseDoubleSafely(shipReportValues[5]);
                      double observationSwellh = parseDoubleSafely(shipReportValues[6]);
                      double observationSwelldir = parseDoubleSafely(shipReportValues[7]);
                      String repshipCourse = (shipReportValues[8]);
                      double repshipSpeed_avg = parseDoubleSafely(shipReportValues[9]);
                      double repshipRpm_avg = parseDoubleSafely(shipReportValues[10]);
                      double repshipLoad_Avg = parseDoubleSafely(shipReportValues[11]);
                      double repshipDist_since_latest_rep = parseDoubleSafely(shipReportValues[12]);
                      double repshipDist_rem_to_go = parseDoubleSafely(shipReportValues[13]);
                      String repshipHfo_brob = (shipReportValues[14]);
                      String repshipLsfo_brob = (shipReportValues[15]);
                      String repshipMgo_brob = (shipReportValues[16]);
                      String repshipMdo_brob = (shipReportValues[17]);
                      String repshipMeHfoSLR = (shipReportValues[18]);
                      String repshipMeLsfoSLR = (shipReportValues[19]);
                      String repshipMeMdoSLR = (shipReportValues[20]);
                      String repshipMeMgoSLR = (shipReportValues[21]);
                      String repshipAuxHfoSLR = (shipReportValues[22]);
                      String repshipAuxLsfoSLR = (shipReportValues[23]);
                      String repshipAuxMdoSLR = (shipReportValues[24]);
                      String repshipAuxMgoSLR = (shipReportValues[25]);
                      String repshipBoilerHfoSLR = (shipReportValues[26]);
                      String repshipBoilerLsfoSLR = (shipReportValues[27]);
                      String repshipBoilerMdoSLR = (shipReportValues[28]);
                      String repshipBoilerMgoSLR = (shipReportValues[29]);
                      String repshipCleanHfoSLR = (shipReportValues[30]);
                      String repshipCleanLsfoSLR = (shipReportValues[31]);
                      String repshipCleanMdoSLR = (shipReportValues[32]);
                      String repshipCleanMgoSLR = (shipReportValues[33]);
                      String repshipHeatHfoSLR = (shipReportValues[34]);
                      String repshipHeatLsfoSLR = (shipReportValues[35]);
                      String repshipHeatMdoSLR = (shipReportValues[36]);
                      String repshipHeatMgoSLR = (shipReportValues[37]);
                      String repshipGenAtSeaHfoSLR = (shipReportValues[38]);
                      String repshipGenAtSeaLsfoSLR = (shipReportValues[39]);
                      String repshipGenAtSeaMdoSLR = (shipReportValues[40]);
                      String repshipGenAtSeaMgoSLR = (shipReportValues[41]);
                      String repshipOthersAtSeaHfoSLR = (shipReportValues[42]);
                      String repshipOthersAtSeaLsfoSLR = (shipReportValues[43]);
                      String repshipOthersAtSeaMdoSLR = (shipReportValues[44]);
                      String repshipOthersAtSeaMgoSLR = (shipReportValues[45]);
                      String repshipInstructedlegcode = (shipReportValues[46]);
                      double repshipInstructedspeed = parseDoubleSafely(shipReportValues[47]);
                      String repshipPropulsionengines = (shipReportValues[48]);
                      String repshipShaftgenerators = (shipReportValues[49]);
                      String repshipFinstabilizers = (shipReportValues[50]);
                      String repshipSteamTimeSLR = (shipReportValues[51]);
                      String baseline_instructionBaseline_instruction_id = (shipReportValues[52]);
                      double repshipProforma_speed = parseDoubleSafely(shipReportValues[53]);
                      double repshipIntended_speed = parseDoubleSafely(shipReportValues[54]);


            
                      ShipReport tempShipReport = new ShipReport(shipReportID,
                                                                  repshipCosp_eosp,
                                                                  repshipEta_earliest,
                                                                  observationWindspeed,
                                                                  observationWindspeedbf,
                                                                  observationWinddir,
                                                                  observationWaveh,
                                                                  observationSwellh,
                                                                  observationSwelldir,
                                                                  repshipCourse,
                                                                  repshipSpeed_avg,
                                                                  repshipRpm_avg,
                                                                  repshipLoad_Avg,
                                                                  repshipDist_since_latest_rep,
                                                                  repshipDist_rem_to_go,
                                                                  repshipHfo_brob,
                                                                  repshipLsfo_brob,
                                                                  repshipMgo_brob,
                                                                  repshipMdo_brob,
                                                                  repshipMeHfoSLR,
                                                                  repshipMeLsfoSLR,
                                                                  repshipMeMdoSLR,
                                                                  repshipMeMgoSLR,
                                                                  repshipAuxHfoSLR,
                                                                  repshipAuxLsfoSLR,
                                                                  repshipAuxMdoSLR,
                                                                  repshipAuxMgoSLR,
                                                                  repshipBoilerHfoSLR,
                                                                  repshipBoilerLsfoSLR,
                                                                  repshipBoilerMdoSLR,
                                                                  repshipBoilerMgoSLR,
                                                                  repshipCleanHfoSLR,
                                                                  repshipCleanLsfoSLR,
                                                                  repshipCleanMdoSLR,
                                                                  repshipCleanMgoSLR,
                                                                  repshipHeatHfoSLR,
                                                                  repshipHeatLsfoSLR,
                                                                  repshipHeatMdoSLR,
                                                                  repshipHeatMgoSLR,
                                                                  repshipGenAtSeaHfoSLR,
                                                                  repshipGenAtSeaLsfoSLR,
                                                                  repshipGenAtSeaMdoSLR,
                                                                  repshipGenAtSeaMgoSLR,
                                                                  repshipOthersAtSeaHfoSLR,
                                                                  repshipOthersAtSeaLsfoSLR,
                                                                  repshipOthersAtSeaMdoSLR,
                                                                  repshipOthersAtSeaMgoSLR,
                                                                  repshipInstructedlegcode,
                                                                  repshipInstructedspeed,
                                                                  repshipPropulsionengines,
                                                                  repshipShaftgenerators,
                                                                  repshipFinstabilizers,
                                                                  repshipSteamTimeSLR,
                                                                  baseline_instructionBaseline_instruction_id,
                                                                  repshipProforma_speed,
                                                                  repshipIntended_speed,
                                                                  shipLon, 
                                                                  legType, 
                                                                  shipLat,
                                                                  date);
                      shipReportsArray.add(tempShipReport);

                    }
                  }


                  //Weather Way points
                  ArrayList<WeatherWaypoint> weatherWayPointArray = new ArrayList<WeatherWaypoint>();
                  NodeList nList_weatherWayPoint = tempVoyageEl.getElementsByTagName("weatherwaypoint");
                  
                  for (int j = 0; j < nList_weatherWayPoint.getLength(); j++) 
                  {
                    Node weatherwayNode = nList_weatherWayPoint.item(j);

                    if (weatherwayNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                      Element weatherWayEl = (Element) weatherwayNode;
                      double weatherLon  = parseDoubleSafely(weatherWayEl.getAttribute("lon"));
                      String legType = weatherWayEl.getAttribute("legtype");
                      double weatherLat  = parseDoubleSafely(weatherWayEl.getAttribute("lat"));
                      String date  = weatherWayEl.getAttribute("date");
                      String weatherWayPVal = weatherWayEl.getAttribute("values");
                      String[] weatherWayPValues = weatherWayPVal.split(";", 16);
                      
                      double weatherwaypointWindspeed = parseDoubleSafely(weatherWayPValues[0]);
                      double weatherwaypointWinddir = parseDoubleSafely(weatherWayPValues[1]);
                      double weatherwaypointSwellh = parseDoubleSafely(weatherWayPValues[2]);
                      double weatherwaypointSwelldir = parseDoubleSafely(weatherWayPValues[3]);
                      double weatherwaypointSwellperiod = parseDoubleSafely(weatherWayPValues[4]); 
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

                      WeatherWaypoint tempPoint = new WeatherWaypoint(weatherwaypointWindspeed,
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
                                                                      weatherwaypointGoodweather,
                                                                      weatherLon,
                                                                      legType,
                                                                      weatherLat,
                                                                      date);
                      weatherWayPointArray.add(tempPoint);

                    }
                  }
                  Voyage voyage = new Voyage(voyageID, worklistid,systemonboardstatus,state,
                                              pvapdf, lastupdate,
                                              voyageName,
                                              voyageVoyref,
                                              ope,
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
                                              weatherWayPointArray,
                                              voyageComment,
                                              shipReportsArray);
                 
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
public static int parseIntSafely(String str) {
    int result = 0;
    try {
        result = Integer.parseInt(str);
    } catch (NullPointerException npe) {
    } catch (NumberFormatException nfe) {
    }
    return result;
}
}