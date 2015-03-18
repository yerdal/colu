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

  public Operator(){
    operatorId = 0;
    name = "undefined";
    copyfcst = "undefined";
    pva = "undefined";
    hasOnBoardSystem = "undefined";
    comment = "undefined";
    nationalityOfCrew = "undefined";
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


  
  

}