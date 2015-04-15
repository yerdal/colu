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
   * @return      a Ship with given id
   * @see         ArrayList
   */ 
    //Request a ship with a certain name?
    @RequestMapping(value="/ships/id/{id}")
    public ArrayList getShip(@PathVariable String id) {
        ArrayList<Ship> myShips = getXMLShip();
        return myShips;
    }
   /**
   * @return      all ship polls 
   * @see         ArrayList
   */ 
    @RequestMapping(value="/ships/polls")
    public ArrayList getShipPolls() {
        ArrayList<Ship> myShips_pos = getXMLShipPolls();
        return myShips_pos;
    }
  /**
   * @return      all ongoing voyages
   * @see         ArrayList
   */ 
    @RequestMapping(value="/ongoingVoyages")
    public ArrayList getOngoingVoyages(){
      ArrayList<OnVoyages> voyages = getXMLOngoingVoyages();
      return voyages;
    }
    /**
     * @param  id the id of the voyage
     * @return      a voyage with given id
     * @see         ArrayList
     */ 
    @RequestMapping(value="/voyages/{id}")
    public ArrayList getVoyage(@PathVariable String id) {
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
                    String contract_contract_id = shipParts[1];
                    int hull_hull_id = parseIntSafely(shipParts[2]);
                    int engine_engine_id = parseIntSafely(shipParts[3]);
                    String ship_ship_name = shipParts[4];
                    String shiptype_shiptypename = shipParts[5];
                    String ship_ship_signs = shipParts[6];
                    String ship_employment = shipParts[7];
                    int hull_model_no = parseIntSafely(shipParts[8]);
                    double hull_hull_len_oa = parseDoubleSafely(shipParts[9]);
                    double hull_hull_len_pp = parseDoubleSafely(shipParts[10]);
                    double hull_hull_beam = parseDoubleSafely(shipParts[11]);
                    double hull_hull_front = parseDoubleSafely(shipParts[12]);
                    double hull_hull_side = parseDoubleSafely(shipParts[13]);
                    double hull_hull_factor = parseDoubleSafely(shipParts[14]);
                    double ship_ship_nt = parseDoubleSafely(shipParts[15]);
                    double ship_draft_design = parseDoubleSafely(shipParts[16]);
                    double ship_draft_scantling = parseDoubleSafely(shipParts[17]);
                    double engine_eng_max_contin_rating = parseDoubleSafely(shipParts[18]);
                    double engine_eng_norm_contin_rating = parseDoubleSafely(shipParts[19]);
                    double engine_eng_nom_rpm_mcr = parseDoubleSafely(shipParts[20]);
                    double engine_eng_nom_rpm_ncr = parseDoubleSafely(shipParts[21]);
                    double ship_ship_speed = parseDoubleSafely(shipParts[22]);
                    double ship_ship_dwt = parseDoubleSafely(shipParts[23]);
                    double ship_criteria_wind = parseDoubleSafely(shipParts[24]);
                    double ship_min_load_speed = parseDoubleSafely(shipParts[25]);
                    double ship_max_load_speed = parseDoubleSafely(shipParts[26]);
                    double ship_min_ballast_speed = parseDoubleSafely(shipParts[27]);
                    double ship_max_ballast_speed = parseDoubleSafely(shipParts[28]);
                    double ship_min_medium_speed = parseDoubleSafely(shipParts[29]);
                    double ship_max_medium_speed = parseDoubleSafely(shipParts[30]);
                    String ship_routingtype = shipParts[31];
                    String ship_supported_onboardsystem = shipParts[32];
                    String ship_state = shipParts[33];
                    
                    Ship theShip = new Ship(shipID, operator, contract_contract_id, hull_hull_id, engine_engine_id, ship_ship_name, shiptype_shiptypename, 
                                            ship_ship_signs, ship_employment, hull_model_no, hull_hull_len_oa , hull_hull_len_pp,
                        hull_hull_beam, hull_hull_front, hull_hull_side, hull_hull_factor, ship_ship_nt, ship_draft_design, ship_draft_scantling, 
                        engine_eng_max_contin_rating, engine_eng_norm_contin_rating, engine_eng_nom_rpm_mcr , engine_eng_nom_rpm_ncr, ship_ship_speed, 
                        ship_ship_dwt, ship_criteria_wind, ship_min_load_speed, ship_max_load_speed, ship_min_ballast_speed, ship_max_ballast_speed, ship_min_medium_speed, 
                        ship_max_medium_speed, ship_routingtype, ship_supported_onboardsystem, ship_state, shipComment, shipDesc);
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
    private ArrayList getXMLOngoingVoyages(){
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
                  int voyageVoyref = parseIntSafely(voyageValues[1]);
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
                  int voyageLoading = parseIntSafely(voyageValues[11]);
                  double voyageCargoweight = parseDoubleSafely(voyageValues[12]);
                  int voyageCargosensitiv = parseIntSafely(voyageValues[13]);
                  double voyageGmheight = parseDoubleSafely(voyageValues[14]);
                  double voyageDisplacement_at_dep = parseDoubleSafely(voyageValues[15]);
                  double voyageMaxspeed =  parseDoubleSafely(voyageValues[16]);
                  double voyageDraft_aft = parseDoubleSafely(voyageValues[17]);
                  double voyageDraft_fwd = parseDoubleSafely(voyageValues[18]);
                  double voyageDraft_mean = parseDoubleSafely(voyageValues[19]);
                  double voyageDraft_trim = parseDoubleSafely(voyageValues[20]);
                  String tradelaneName = voyageValues[21];
                  String voyagePhase = voyageValues[22];
                  String voyageHasroute = voyageValues[23];
                  String voyageNextMessageDate = voyageValues[24];
                  String voyagePriority =  voyageValues[25];
                  String seaName = voyageValues[26];
                  double seaSortOrder = parseDoubleSafely(voyageValues[27]);
                  String forecastModifieddate = voyageValues[28];
                  String forecastState =  voyageValues[29];
                  double voyageFo_brob_dep = parseDoubleSafely(voyageValues[30]);
                  double voyageDo_brob_dep = parseDoubleSafely(voyageValues[31]);
                  double voyageFo_brob_latest = parseDoubleSafely(voyageValues[32]);
                  double voyageDo_brob_latest =  parseDoubleSafely(voyageValues[33]);
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
                      String baselineSelected = (baselineValues[0]);
                      double baselineOva_cons_performance = parseDoubleSafely(baselineValues[1]);
                      double baselineOva_cons_performance_rep_diff = parseDoubleSafely(baselineValues[2]);
                      double baselineOva_cons_performance_rep_diff_prcnt = parseDoubleSafely(baselineValues[3]);
                      double baselinePva_cons_performance = parseDoubleSafely(baselineValues[4]);
                      double baselinePva_cons_performance_rep_diff = parseDoubleSafely(baselineValues[5]);
                      double baselinePva_cons_performance_rep_diff_prcnt = parseDoubleSafely(baselineValues[6]);
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
                      int legType = parseIntSafely(shipReportEl.getAttribute("legtype"));
                      double shipLat  = parseDoubleSafely(shipReportEl.getAttribute("lat"));
                      String date  = shipReportEl.getAttribute("date");
                      String shipReportVal = shipReportEl.getAttribute("values");
                      String[] shipReportValues = shipReportVal.split(";", 55);
                      
                      int repshipCosp_eosp = parseIntSafely(shipReportValues[0]);
                      String repshipEta_earliest = (shipReportValues[1]);
                      double observationWindspeed = parseDoubleSafely(shipReportValues[2]);
                      double observationWindspeedbf = parseDoubleSafely(shipReportValues[3]);
                      double observationWinddir = parseDoubleSafely(shipReportValues[4]);
                      double observationWaveh = parseDoubleSafely(shipReportValues[5]);
                      double observationSwellh = parseDoubleSafely(shipReportValues[6]);
                      double observationSwelldir = parseDoubleSafely(shipReportValues[7]);
                      double repshipCourse = parseDoubleSafely(shipReportValues[8]);
                      double repshipSpeed_avg = parseDoubleSafely(shipReportValues[9]);
                      double repshipRpm_avg = parseDoubleSafely(shipReportValues[10]);
                      double repshipLoad_Avg = parseDoubleSafely(shipReportValues[11]);
                      double repshipDist_since_latest_rep = parseDoubleSafely(shipReportValues[12]);
                      double repshipDist_rem_to_go = parseDoubleSafely(shipReportValues[13]);
                      double repshipHfo_brob = parseDoubleSafely(shipReportValues[14]);
                      double repshipLsfo_brob = parseDoubleSafely(shipReportValues[15]);
                      double repshipMgo_brob = parseDoubleSafely(shipReportValues[16]);
                      double repshipMdo_brob = parseDoubleSafely(shipReportValues[17]);
                      double repshipMeHfoSLR = parseDoubleSafely(shipReportValues[18]);
                      double repshipMeLsfoSLR = parseDoubleSafely(shipReportValues[19]);
                      double repshipMeMdoSLR = parseDoubleSafely(shipReportValues[20]);
                      double repshipMeMgoSLR = parseDoubleSafely(shipReportValues[21]);
                      double repshipAuxHfoSLR = parseDoubleSafely(shipReportValues[22]);
                      double repshipAuxLsfoSLR = parseDoubleSafely(shipReportValues[23]);
                      double repshipAuxMdoSLR = parseDoubleSafely(shipReportValues[24]);
                      double repshipAuxMgoSLR = parseDoubleSafely(shipReportValues[25]);
                      double repshipBoilerHfoSLR = parseDoubleSafely(shipReportValues[26]);
                      double repshipBoilerLsfoSLR = parseDoubleSafely(shipReportValues[27]);
                      double repshipBoilerMdoSLR = parseDoubleSafely(shipReportValues[28]);
                      double repshipBoilerMgoSLR = parseDoubleSafely(shipReportValues[29]);
                      double repshipCleanHfoSLR = parseDoubleSafely(shipReportValues[30]);
                      double repshipCleanLsfoSLR = parseDoubleSafely(shipReportValues[31]);
                      double repshipCleanMdoSLR = parseDoubleSafely(shipReportValues[32]);
                      double repshipCleanMgoSLR = parseDoubleSafely(shipReportValues[33]);
                      double repshipHeatHfoSLR = parseDoubleSafely(shipReportValues[34]);
                      double repshipHeatLsfoSLR = parseDoubleSafely(shipReportValues[35]);
                      double repshipHeatMdoSLR = parseDoubleSafely(shipReportValues[36]);
                      double repshipHeatMgoSLR = parseDoubleSafely(shipReportValues[37]);
                      double repshipGenAtSeaHfoSLR = parseDoubleSafely(shipReportValues[38]);
                      double repshipGenAtSeaLsfoSLR = parseDoubleSafely(shipReportValues[39]);
                      double repshipGenAtSeaMdoSLR = parseDoubleSafely(shipReportValues[40]);
                      double repshipGenAtSeaMgoSLR = parseDoubleSafely(shipReportValues[41]);
                      double repshipOthersAtSeaHfoSLR = parseDoubleSafely(shipReportValues[42]);
                      double repshipOthersAtSeaLsfoSLR = parseDoubleSafely(shipReportValues[43]);
                      double repshipOthersAtSeaMdoSLR = parseDoubleSafely(shipReportValues[44]);
                      double repshipOthersAtSeaMgoSLR = parseDoubleSafely(shipReportValues[45]);
                      String repshipInstructedlegcode = (shipReportValues[46]);
                      String repshipInstructedspeed = (shipReportValues[47]);
                      int repshipPropulsionengines = parseIntSafely(shipReportValues[48]);
                      int repshipShaftgenerators = parseIntSafely(shipReportValues[49]);
                      int repshipFinstabilizers = parseIntSafely(shipReportValues[50]);
                      double repshipSteamTimeSLR = parseDoubleSafely(shipReportValues[51]);
                      int baseline_instructionBaseline_instruction_id = parseIntSafely(shipReportValues[52]);
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
                      String weatherwaypointGoodweather = weatherWayPValues[15];

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