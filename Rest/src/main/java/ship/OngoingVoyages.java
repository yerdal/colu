
package ship;


/**
 * Class to represent the ongoing voyages
 */

public class OngoingVoyages{

	private int voyageID;
	private String shipTypeName;
	
  public OngoingVoyages(int theId, String theShipType){
    voyageID = theId;
    shipTypeName = theShipType;
  }
  /*public OngoingVoyages(int theId, String theName) {
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
