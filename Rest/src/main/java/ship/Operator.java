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


  public Operator(int theId)
    operatorId = theId;
  }
  

}