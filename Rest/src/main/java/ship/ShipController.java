package ship;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class ShipController extends ParsingXML{


  private ArrayList<Ship> myShip;
  private ArrayList<Ship> myShipsPos;
  private ArrayList<OnVoyages> ongoingVoyages;
  private Voyage myVoyage;
  private ArrayList<Voyage> voyageList;

  private ArrayList<Voyage> badVoyages;
  private ArrayList<Voyage> goodVoyages;
  private ArrayList<Voyage> okVoyages;

   /**
   * @param  id the id of the ship
   * @return      a Ship with given id
   * @see         ArrayList
   */ 
    //Request a ship with a certain name?
    @RequestMapping(value="/ships/id/{id}")
    public ArrayList getShip(@PathVariable String id) {
        myShip = getXMLShip();
        return myShip;
    }
   /**
   * @return      all ship polls 
   * @see         ArrayList
   */ 
    @RequestMapping(value="/ships/polls")
    public ArrayList getShipPolls() {
        myShipsPos = getXMLShipPolls();
        return myShipsPos;
    }
  /**
   * @return      all ongoing voyages
   * @see         ArrayList
   */ 
    @RequestMapping(value="/voyages/ongoing")
    public ArrayList getOngoingVoyages(){
      // System.out.println("getONgoingVoyages");

      ongoingVoyages = getXMLOngoingVoyages();
      return ongoingVoyages;
    }
    /**
     * @param  id the id of the voyage
     * @return      a voyage with given id
     * @see         ArrayList
     */ 
    @RequestMapping(value="/voyages/id/{id}")
    public Voyage getVoyage(@PathVariable String id) {
        //This is so we dont update the voyage with new values and erase required parameters from user
        myVoyage = getXMLShipVoyage(id);
        return myVoyage;
    }
    @RequestMapping(value="/voyages")
    public ArrayList getAllVoyages() {

      //so we know we have the ongoing voyages
      ongoingVoyages = getOngoingVoyages();
      voyageList = new ArrayList<Voyage>();

      for(int i = 0; i < ongoingVoyages.size(); i++){
        String voyageId = Integer.toString(ongoingVoyages.get(i).getVoyageId());
        Voyage tempVoyage = getXMLShipVoyage(voyageId); 
        voyageList.add(tempVoyage);
      } 
      return voyageList;
    }

    
    @RequestMapping(value="/voyages/status/bad")
    public ArrayList getBadVoyages() {
      //so we know we have the ongoing voyages
      ongoingVoyages = getOngoingVoyages();
      badVoyages = new ArrayList<Voyage>();

      for(int i = 0; i < ongoingVoyages.size(); i++){
        String voyageId = Integer.toString(ongoingVoyages.get(i).getVoyageId());
        Voyage tempVoyage = getXMLShipVoyage(voyageId);
        if (tempVoyage.checkStatus() == "BAD")
        {
          badVoyages.add(tempVoyage);
        }
      } 
      return badVoyages;
    }
    @RequestMapping(value="/voyages/status/good")
    public ArrayList getGoodVoyages()
    {
      //so we know we have the ongoing voyages
      ongoingVoyages = getOngoingVoyages();
      goodVoyages = new ArrayList<Voyage>();

      for(int i = 0; i < ongoingVoyages.size(); i++){
        String voyageId = Integer.toString(ongoingVoyages.get(i).getVoyageId());
        Voyage tempVoyage = getXMLShipVoyage(voyageId);
        if (tempVoyage.checkStatus() == "GOOD")
        {
          goodVoyages.add(tempVoyage);
        }
      } 
      return goodVoyages;
    }


    @RequestMapping(value="/voyages/status/ok")
    public ArrayList getOkVoyages()
    {
      //so we know we have the ongoing voyages
      ongoingVoyages = getOngoingVoyages();
      okVoyages = new ArrayList<Voyage>();
        //This is so we dont update the voyage with new values and erase required parameters from user
      for(int i = 0; i < ongoingVoyages.size(); i++){
        String voyageId = Integer.toString(ongoingVoyages.get(i).getVoyageId());
        Voyage tempVoyage = getXMLShipVoyage(voyageId);
        if (tempVoyage.checkStatus() == "OK")
        {
          okVoyages.add(tempVoyage);
        }
      } 
      return okVoyages;
    }

    @RequestMapping(value="/voyages/{id}/updatelimits", method = RequestMethod.PUT)  
    public @ResponseBody RequestedParameters putData(@RequestBody RequestedParameters body, @PathVariable String id) {
      // System.out.println("IN post MEthod JAVA SPRING " + body + id );
      //Loop through the voyages (only one now) and set Required Parameters from frontend
      myVoyage.setRequiredParameters(body);

      return body;
    }
    //FOR FUTURE POST METHODS
    // @RequestMapping(value="/voyages/{id}/requiredETA", method = RequestMethod.POST)  
    // public @ResponseBody String postData(@RequestBody String eta, @PathVariable String id) {
    //   System.out.println("IN post MEthod JAVA SPRING " + eta + id );
    //   return eta;
    // }

    
}