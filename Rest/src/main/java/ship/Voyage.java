package ship;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class Voyage
{
	//variabler från XML
	private int voyageID;
	private int worklistID;
	private String systemOnBoardStatus;
	private String state;
	private String pvapdfurl;
	private String lastUpdate;
	//values
	private String voyageName; //Voyage Name
	private int voyRef;  //it says  Voyage Id?...
	private Operator operator;
	private String personName; //Name of master, Captain hook etc.
	private Ship ship;
	private String departure; 
	private String destination;
	private String etd; //Estimated Time of Departure format="yyyy-MM-dd HH:mm" "Voyage ETD in UTC" 
	private String eta; //Estimated Time of arrival format="yyyy-MM-dd HH:mm" description="ETA in UTC" 
	private String requiredEta; //format="yyyy-MM-dd HH:mm" description="Required ETA in UTC"
	private int loadingStatus; //Loaded/Ballast/Semiloaded  Loading 
	private double cargoWeight; // "Cargo weight as reported in Departure report
	private int cargoSensitivStatus; //"Unknown/Normal/Sensitive/Extra sensitive"
	private double gmHeight; //Metacentric height as reported in the Departure report
	private double displacementAtDep; //Displacement at departure
	private double maxSpeed; //WRS speed
	private double draftAft; //At departure
	private double draftFwd; //At departure
	private double draftMean; //(Draft aft + Draft fwd)/2 as reported in the Dep report
	private double draftTrim; //Draft aft - Draft fwd as reported in the Dep report
	private String tradelaneName; //Tradelane Name..
	private String voyagePhase; //Started/Ongoing/Ended
	private String hasRoute; // Voyage has a defined route, true / false
	private String nextMessageDate; //format="yyyy-MM-dd" Next message date
	private String priority; //Manual priority.
	private String seaName;  //name of the Sea
	private double seaSortOrder; //Sea sort order 
	private String forecastModifiedDate; // format="yyyy-MM-dd HH:mm:ss" Modified date
	private String forecastState; //State of forecast, new, changed, saved ,sent
	private double foBrobDep; //Fuel Oil remaining on board , incl. IFO, LS, HS if any at departure
	private double doBrobDep; // Diesel Oil remaining on board incl. MDO, MGO if any) at departure
	private double foBrobLatest; // Fuel Oil remaining on board incl. IFO, LS, HS if any) at arrival
	private double doBrobLatest; // Diesel Oil remaining on board incl. MDO, MGO if any) at arrival
	private String hasPva; //If voyage pva is created , true false, undefined
	private ArrayList <WeatherWaypoint> weatherWaypoints;
	private ArrayList <ShipReport> shipReports;
	private String comment; //Comment about the voyage


	//Our new vaiables!
	private Date requiredETA;


	// private bool onGoing; //kanske?
	public Voyage (int theVoyageID, int theWorklistID, String theSystemOnBoardStatus, 
									String theState,
									String thePvadpfurl,
									String theLastUpdate,
									String theVoyageName,
									int theVoyRef,
									Operator theOperator,
									String thePersonName,
									Ship theShip,
									String theDeparture,
									String  theDestination,
									String theEtd,
									String theEta,
									String theRequiredEta,
									int theLoading,
									double theCargoWeight,
									int theCargoSensitiv,
									double theGmHeight,
									double theDisplacementAtDep,
									double theMaxSpeed,
									double theDraftAft,
									double theDraftFwd,
									double theDraftMean,
									double theDraftTrim,
									String theTradelaneName,
									String thePhase,
									String theHasRoute,
									String theNextMessageDate,
									String thePriority,
									String theSeaName,
									double theSeaSortOrder,
									String theForecastModifiedDate,
									String theForecastState,
									double theFoBrobDep,
									double theDoBrobDep,
									double theFoBrobLatest,
									double theDoBrobLatest,
									String theHasPva,
									ArrayList <WeatherWaypoint> theWeatherWaypoints,
									String theComment,
									ArrayList <ShipReport> theShipReports)
	{
	voyageID = theVoyageID;
	worklistID = theWorklistID;
  	systemOnBoardStatus = theSystemOnBoardStatus;
  	state = theState;
  	pvapdfurl = thePvadpfurl;
  	lastUpdate = theLastUpdate;
	//values
  	voyageName = theVoyageName;
  	voyRef = theVoyRef;
	operator = theOperator;
  	personName = thePersonName;
  	ship = theShip;
  	departure = theDeparture;
  	destination = theDestination;
  	etd = theEtd;
  	eta = theEta;
  	requiredEta = theRequiredEta;
  	loadingStatus = theLoading;
  	cargoWeight = theCargoWeight;
  	cargoSensitivStatus = theCargoSensitiv;
  	gmHeight = theGmHeight;
  	displacementAtDep = theDisplacementAtDep;
	 	maxSpeed = theMaxSpeed;
  	draftAft = theDraftAft;
  	draftFwd = theDraftFwd;
  	draftMean = theDraftMean;
  	draftTrim = theDraftTrim;
  	tradelaneName = theTradelaneName;
  	voyagePhase = thePhase;
  	hasRoute = theHasRoute;
  	nextMessageDate = theNextMessageDate;
  	priority = thePriority;
  	seaName = theSeaName;
  	seaSortOrder = theSeaSortOrder;
  	forecastModifiedDate = theForecastModifiedDate;
  	forecastState = theForecastState;
  	foBrobDep = theFoBrobDep;
  	doBrobDep = theDoBrobDep;
  	doBrobLatest = theDoBrobLatest;
  	foBrobLatest = theFoBrobLatest;
  	hasPva = theHasPva;
  	weatherWaypoints = theWeatherWaypoints;

  	comment = theComment;
		shipReports = theShipReports;
		
  	requiredETA = new Date();
	 	compareETARequried();
	

	}
	public int getVoyageId(){
		return voyageID;
	}
	public int getWorkListId()
	{
		return worklistID;
	}
	public Ship getShip()
	{
		return ship;
	}
	public Operator getOperator()
	{
		return operator;
	}
	public ArrayList<WeatherWaypoint> getWeatherWaypoints()
	{
		return weatherWaypoints;
	}
	public WeatherWaypoint getLatestWeatherWaypoint()
	{
		return weatherWaypoints.get(weatherWaypoints.size()-1);
	}
	public ArrayList<ShipReport> getShipReports()
	{
		return shipReports;
	}


	public String getSystemOnBoardStatus(){
		return systemOnBoardStatus;
	}
	public String getState(){
		return state;
	}
	public String getPvapdfurl(){
		return pvapdfurl;
	}
	public String getLastUpdate(){
		return lastUpdate;
	}
	//values
	public String getVoyageName(){
		return voyageName;
	}
	public int getVoyRef(){
		return voyRef;
	}
	public String getPersonName(){
		return personName;
	}
	public String getDeparture(){
		return departure;
	}
	public String getDestination(){
		return destination;
	}
	public String getEtd(){
		return etd;
	}
	public String getEta(){
		return eta;
	}
	public String getRequiredEta(){
		return requiredEta;
	}
	public int getLoadingStatus(){
		return loadingStatus;
	}
	public double getCargoWeight(){
		return cargoWeight;
	}
	public int getCargoSensitivStatus(){
		return cargoSensitivStatus;
	}
	public double getGmHeight(){
		return gmHeight;
	}
	public double getDisplacementAtDep(){
		return displacementAtDep;
	}
	public double getMaxSpeed(){
		return maxSpeed;
	}
	public double getDraftAft(){
		return draftAft;
	}
	public double getDraftFwd(){
		return draftFwd;
	}
	public double getDraftMean(){
		return draftMean;
	}
	public double getDraftTrim(){
		return draftTrim;
	}
	public String getTradelaneName(){
		return tradelaneName;
	}
	public String getVoyagePhase(){
		return voyagePhase;
	}
	public String getHasRoute(){
		return hasRoute;
	}
	public String getNextMessageDate(){
		return nextMessageDate;
	}
	public String getPriority(){
		return priority;
	}
	public String getSeaName(){
		return seaName;
	}
	public double getSeaSortOrder(){
		return seaSortOrder;
	}
	public String getForecastModifiedDate(){
		return forecastModifiedDate;
	}
	public String getForecastState(){
		return forecastState;
	}
	public double getFoBrobDep(){
		return foBrobDep;
	}
	public double getDoBrobDep(){
		return doBrobDep;
	}
	public double getFoBrobLatest(){
		return foBrobLatest;
	}
	public double getDoBrobLatest(){
		return doBrobLatest;
	}
	public String getHasPva(){
		return hasPva;
	}
	public String getComment(){
		return comment;
	}


	// Bränsleåtgång → Bränsle kvar, OCH förbrukad bränsle sen senaste rapport?
			
	// Fart -> Definiera fartygets önskade hastighet. Spann? 

	public String getRequiredETA(){
		return requiredETA.toString();
	}
	public void setRequiredETA(String reqEta){
		try {
 			if(reqEta.equals(""))
 				reqEta = "00-00-00 00:00";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");
			requiredETA = formatter.parse(reqEta);
			System.out.println("requiredETA " +  requiredETA.toString());
 
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	// Ankomsttid -> Använda ETA variable från shipreport
	public void compareETARequried(){

		for(int i = 0; i < shipReports.size(); i++){
			// System.out.println("shipreports.length " + shipReports.size());
			shipReports.get(i).setStatusRequiredETA(requiredETA);
		}
	}




	public void checkWindSpeed(double chosenWindSpeed)
	{
		
		double reportedWindSpeed;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			reportedWindSpeed = weatherWaypoints.get(i).getWindSpeed();
			if (reportedWindSpeed < chosenWindSpeed)
			{
				weatherWaypoints.get(i).setWindSpeedStatus("GOOD");
			}
			else if (reportedWindSpeed == chosenWindSpeed)
			{
				weatherWaypoints.get(i).setWindSpeedStatus("OK");
			}
			else //reportedWindSpeed > chosenWindSpeed
			{
				weatherWaypoints.get(i).setWindSpeedStatus("BAD");
			}
		}
	}
	public void checkWindDir(double chosenWindDir)
	{
		
		double reportedWindDir;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			reportedWindDir = weatherWaypoints.get(i).getWindDir();
			if (reportedWindDir < chosenWindDir)
			{
				weatherWaypoints.get(i).setWindDirStatus("GOOD");
			}
			else if (reportedWindDir == chosenWindDir)
			{
				weatherWaypoints.get(i).setWindDirStatus("OK");
			}
			else //reportedWindDir > chosenWindDir
			{
				weatherWaypoints.get(i).setWindDirStatus("BAD");
			}
		}

	}
	public void checkSignWaveHeight(double chosenSignWaveHeight)
	{
		double reportedSignWaveHeight;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			reportedSignWaveHeight = weatherWaypoints.get(i).getSignWaveHeight();
			if (reportedSignWaveHeight < chosenSignWaveHeight)
			{
				weatherWaypoints.get(i).setSignWaveHeightStatus("GOOD");
			}
			else if (reportedSignWaveHeight == chosenSignWaveHeight)
			{
				weatherWaypoints.get(i).setSignWaveHeightStatus("OK");
			}
			else
			{
				weatherWaypoints.get(i).setSignWaveHeightStatus("BAD");
			}
		}
	}
	public void checkCurrentDir (double chosenCurrentDir)
	{
		double reportedCurrentDir;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			reportedCurrentDir = weatherWaypoints.get(i).getCurrentDir();
			if (reportedCurrentDir < chosenCurrentDir)
			{
				weatherWaypoints.get(i).setCurrentDirStatus("GOOD");
			}
			else if (reportedCurrentDir == chosenCurrentDir)
			{
				weatherWaypoints.get(i).setCurrentDirStatus("OK");
			}
			else
			{
				weatherWaypoints.get(i).setCurrentDirStatus("BAD");
			}
		}

	}
	public void checkCurrentSpeed (double chosenCurrentSpeed)
	{
		double reportedCurrentSpeed;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			reportedCurrentSpeed = weatherWaypoints.get(i).getCurrentSpeed();
			if (reportedCurrentSpeed < chosenCurrentSpeed)
			{
				weatherWaypoints.get(i).setCurrentSpeedStatus("GOOD");
			}
			else if (reportedCurrentSpeed == chosenCurrentSpeed)
			{
				weatherWaypoints.get(i).setCurrentSpeedStatus("OK");
			}
			else
			{
				weatherWaypoints.get(i).setCurrentSpeedStatus("BAD");
			}
		}
		
	}

}
