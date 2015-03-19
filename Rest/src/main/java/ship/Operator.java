package ship;

public class Operator {

  private int operatorId;
  private String name;
  private String copyfcst;
  private String pva;
  private String hasOnBoardSystem;
  private String comment;
  //XML Elements - > crew, matters, routeinfo, whentocontact
  private String nationalityOfCrew;
  private String timeOrSafe;
  private String routeInformation;
  private String contactOperator;

  public Operator(int theId){
    operatorId = theId;
    name = "undefined";
    copyfcst = "undefined";
    pva = "undefined";
    hasOnBoardSystem = "undefined";
    comment = "This is the operator Comment by ze germans";
    nationalityOfCrew = "Germany";
    timeOrSafe = "undefined";
    routeInformation = "undefined";
    contactOperator = "undefined";
  }

  public Operator(int theId, String theName, String theCopyFcst, String thePva,
    String theHasOnBoardsystem, String theComment, String theNationalCrew, String theTimeOrSafe,
    String theRouteInformation, String theContactOperator) {
    operatorId = theId;
    name = theName;
    copyfcst = theCopyFcst;
    pva = thePva;
    hasOnBoardSystem = theHasOnBoardsystem;
    comment = theComment;
    nationalityOfCrew = theNationalCrew;
    timeOrSafe = theTimeOrSafe;
    routeInformation = theRouteInformation;
    contactOperator = theContactOperator;
  }

  public int getOperatorObject(){
    return operatorId;
  }
  public String getName(){
    return name;
  }
  public String getCopyFcst(){
    return copyfcst;
  }
  public String getPva(){
    return pva;
  }
  public String getHasOnBoardSystem(){
    return hasOnBoardSystem;
  }
  public String getComment(){
    return comment;
  }
  public String getNationalityCrew(){
    return nationalityOfCrew;
  }
  public String getTimeOrSafe(){
    return timeOrSafe;
  }
  public String getRouteInformation(){
    return routeInformation;
  }
  public String getContactOperator(){
    return contactOperator;
  }


}