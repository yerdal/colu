package colu;

/**
 * Class to represent the operator
 */
public class Operator {

  private int operatorId; //Operator ID.
  private String name; //Name of operator.
  private int copyfcst; //Copy forecast, [undef,no,yes,sometimes].
  private int pva; // [undef,no,yes,sometimes]
  private int hasOnBoardSystem; //Has onboard system, [undef,no,yes,sometimes] 
  private String comment; //Main comment
  //XML Elements - > crew, matters, routeinfo, whentocontact
  private String nationalityOfCrew;// Nation.
  private String timeOrSafe; //Matters most, fast or safe trip.
  private String routeInformation; //Specific routes
  private String contactOperator; //When to contact

  public Operator(int theId){
    operatorId = theId;
    name = "undefined";
    copyfcst = 0;//"undefined";
    pva = 0;//"undefined";
    hasOnBoardSystem = 0;//"undefined";
    comment = "This is the operator Comment by ze germans";
    nationalityOfCrew = "Germany";
    timeOrSafe = "undefined";
    routeInformation = "undefined";
    contactOperator = "undefined";
  }

  public Operator(int theId, String theName, int theCopyFcst, int thePva,
    int theHasOnBoardsystem, String theComment, String theNationalCrew, String theTimeOrSafe,
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

  public int getOperatorId(){
    return operatorId;
  }
  public String getName(){
    return name;
  }
  public int getCopyFcst(){
    return copyfcst;
  }
  public int getPva(){
    return pva;
  }
  public int getHasOnBoardSystem(){
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