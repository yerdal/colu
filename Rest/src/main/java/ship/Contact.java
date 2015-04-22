package ship;

public class Contact {

  //According to XML File
  private int contactId;  //ID
  private int shipAddressActive; //If shipaddress is active, 0 inactive, 1 active
  private String communicationType; //Type of communication, FAX, IMC, MTX, PHONE, TLX 
  private String address;
  private String fullAddress;

  
  public Contact(){
    contactId = 0;
    shipAddressActive = 0;
    communicationType = "undefined";
    address = "undefined";
    fullAddress = "undefined";

  }

  public Contact(int theId, int theShipAddressActive, String theCommunicationType, String theAddress , String theFullAddress ) {
    contactId = theId;
    shipAddressActive = theShipAddressActive;
    communicationType = theCommunicationType;
    address = theAddress;
    fullAddress = theFullAddress;
  }

  public int getContactId(){
    return contactId;
  }
  public int getShipAddressActive(){
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