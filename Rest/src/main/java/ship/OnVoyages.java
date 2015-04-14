//ongoingVoyage
package ship;
//import.java.util.ArrayList;

public class OnVoyages{

	private int voyageID;
	private String shipTypeName;
	
  public OnVoyages(int theId, String theShipType){
    voyageID = theId;
    shipTypeName = theShipType;
  }
  /*public OnVoyages(int theId, String theName) {
    voyageID = theId;
    theValues = theName;
  }*/

  public int getVoyageId(){
    return voyageID;
}
  
  public String getVoyageName(){
    return shipTypeName;
  }

}
