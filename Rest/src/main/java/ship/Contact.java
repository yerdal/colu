package ship;

public class Contact {

  //According to XML File
  private int contactId;
  private String shipAddressActive;
  private String communicationType;
  private String address;
  private String fullAddress;

  
  public Contact(){
    contactId = 0;
    shipAddressActive = "undefined";
    communicationType = "undefined";
    address = "undefined";
    fullAddress = "undefined";

  }

  public Contact(int theId, String theShipAddressActive, String theCommunicationType, String theAddress , String theFullAddress ) {
    contactId = theId;
    shipAddressActive = theShipAddressActive;
    communicationType = theCommunicationType;
    address = theAddress;
    fullAddress = theFullAddress;
  }

  public int getContactId(){
    return contactId;
  }
  public String getShipAddressActive(){
    return shipAddressActive;
  }
  public String getCommunicationType(){
    return communicationType;
  }
  public String getAddress(){
    return address;
  }
  public String getFullAddress(){
    return fullAddress;
  }



  
  

}