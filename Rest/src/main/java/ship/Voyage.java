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

	private String status;

	//Weather
	private double requiredMaxWindSpeed;
	private double requiredWindDir;
	private double requiredMaxSignWaveHeight;
	private double requiredCurrentDir;
	private double requiredMaxCurrentSpeed;
	//Ship
	private double requiredAvgSpeedMin;
	private double requiredAvgSpeedMax;



	//Default Constructor
	public Voyage(){
		voyageID = 0;
		worklistID = 0;
		systemOnBoardStatus = "undefined";
		state = "undefined";
		pvapdfurl = "undefined";
		lastUpdate = "undefined";
		voyageName = "undefined";
		voyRef = 0;
		operator = new Operator(0);
		personName = "undefined";
		ship = new Ship(0, operator, "undefined");
		departure = "undefined";
		destination = "undefined";
		etd = "undefined";
		eta = "undefined";
		requiredEta = "undefined";
		loadingStatus = 0;
		cargoWeight = 0.0;
		cargoSensitivStatus = 0;
		gmHeight = 0.0;
		displacementAtDep = 0.0;
		maxSpeed = 0.0;
		draftAft = 0.0;
		draftFwd = 0.0;
		draftMean = 0.0;
		draftTrim = 0.0;
		tradelaneName = "undefined";
		voyagePhase = "undefined";
		hasRoute = "undefined";
		nextMessageDate = "undefined";
		priority = "undefined";
		seaName = "undefined";
		seaSortOrder = 0.0;
		forecastModifiedDate = "undefined";
		forecastState = "undefined";
		foBrobDep = 0.0;
		doBrobDep = 0.0;
		foBrobLatest = 0.0;
		doBrobLatest = 0.0;
		hasPva = "undefined";
		comment = "undefined";
		requiredETA = new Date();
	}
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


	//Get own defined variables
	public double getRequiredMaxWindSpeed(){
		return requiredMaxWindSpeed;
	}
	public double getRequiredWindDir(){
		return requiredWindDir;
	}
	public double getRequiredMaxSignWaveHeight(){
		return requiredMaxSignWaveHeight;
	}
	public double getRequiredCurrentDir(){
		return requiredCurrentDir;
	}
	public double getRequiredMaxCurrentSpeed(){
		return requiredMaxCurrentSpeed;
	}
	public double getRequiredAvgSpeedMin(){
		return requiredAvgSpeedMin;
	}
	public double getRequiredAvgSpeedMax(){
		return requiredAvgSpeedMax;
	}


	public String getRequiredETA(){
		String temp; 
		try {
        temp = requiredETA.toString();
      }   
      catch (Exception e) {
      	// e.throw
         temp = "00-00-00 00:00";
      }
		return temp;
	}
	public void setRequiredParameters(RequestedParameters body){
		System.out.println("Requested PArams " +  body.getRequiredETA() +
								body.getRequiredCurrentSpeed() +
								body.getRequiredWindSpeed() +
								body.getRequiredWindDir() +
								body.getRequiredSignWaveHeight() +
								body.getRequiredCurrentDir());

		//Set each required limits for a voyage
		setRequiredETA(body.getRequiredETA());
    setRequiredCurrentSpeed(body.getRequiredCurrentSpeed());
    setRequiredWindSpeed(body.getRequiredWindSpeed());
    setRequiredWindDir(body.getRequiredWindDir());
    setRequiredSignWaveHeight(body.getRequiredSignWaveHeight());
    setRequiredCurrentDir(body.getRequiredCurrentDir());
    setRequiredAvgSpeed(body.getRequiredAvgSpeedMin() , body.getRequiredAvgSpeedMin());
	}


	public void setRequiredETA(String reqEta){
		try {
 			if(reqEta.equals(""))
 				reqEta = "00-00-00 00:00";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");
			requiredETA = formatter.parse(reqEta);
			for(int i = 0; i < shipReports.size(); i++){
				shipReports.get(i).updateRequiredETAStatus(requiredETA);
			}
 
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	// Ankomsttid -> Använda ETA variable från shipreport

	public void setRequiredAvgSpeed(double speedMin, double speedMax){
		requiredAvgSpeedMin = speedMin;
		requiredAvgSpeedMax = speedMax;
		for (int i = 0; i < shipReports.size(); i++)
		{
			shipReports.get(i).updateAvgSpeedStatus(speedMin, speedMax);
		}
	}
	public void setRequiredWindSpeed(double chosenWindSpeed)
	{
		requiredMaxWindSpeed = chosenWindSpeed;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			weatherWaypoints.get(i).updateWindSpeedStatus(chosenWindSpeed);
		}
	}
	public void setRequiredWindDir(double chosenWindDir)
	{
		requiredWindDir = chosenWindDir;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			weatherWaypoints.get(i).updateWindDirStatus(chosenWindDir);
		}

	}
	public void setRequiredSignWaveHeight(double chosenSignWaveHeight)
	{
		requiredMaxSignWaveHeight = chosenSignWaveHeight;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			weatherWaypoints.get(i).updateSignWaveHeightStatus(chosenSignWaveHeight);
		}
	}
	public void setRequiredCurrentDir (double chosenCurrentDir)
	{
		requiredCurrentDir = chosenCurrentDir;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			weatherWaypoints.get(i).updateCurrentDirStatus(chosenCurrentDir);
		}
	}


	public void setRequiredCurrentSpeed(double chosenCurrentSpeed)
	{
		requiredMaxCurrentSpeed = chosenCurrentSpeed;
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			weatherWaypoints.get(i).updateCurrentSpeedStatus(chosenCurrentSpeed);
		}
		
	}

	public String checkStatus()
	{
		WeatherWaypoint waypoint = getClosestWeatherWaypoint();
		//FIXA DENNA FUNKTION EFTER DATEGREJ

		if (waypoint.getWindSpeedStatus() == "BAD" || waypoint.getWindDirStatus() == "BAD"
			|| waypoint.getSignWaveHeightStatus() == "BAD" || waypoint.getCurrentSpeedStatus() == "BAD"
			|| waypoint.getCurrentDirStatus() == "BAD")
		{
			status = "BAD";
		}
		else if(waypoint.getWindSpeedStatus() == "GOOD" && waypoint.getWindDirStatus() == "GOOD"
			&& waypoint.getSignWaveHeightStatus() == "GOOD" && waypoint.getCurrentSpeedStatus() == "GOOD"
			&& waypoint.getCurrentDirStatus() == "GOOD")
		{
			status = "GOOD";
		}
		else
		{
			status = "OK";
		}
			
		
		return status;
	}
	public WeatherWaypoint getClosestWeatherWaypoint()
	{
		int theCounter = checkClosestWeather();
		System.out.println(theCounter);
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			if (i == theCounter)
			{
				return weatherWaypoints.get(i);
			}
		}
		return null;

	}

	public int checkClosestWeather()
	{
		String[] parts;
		String[] dayPart;
		//weatherDates format: yyyy-mm-dd hh:mm:ss
		ArrayList <String> weatherDatesString = new ArrayList <String>();
		//latestReportDate format: yyyy-mm-dd hh:mm
		String latestReportDate = shipReports.get(shipReports.size()-1).getDate();
		System.out.println(latestReportDate);
		for (int i = 0; i < weatherWaypoints.size(); i++)
		{
			weatherDatesString.add(weatherWaypoints.get(i).getETPDate());
		}
		//System.out.println(latestReportDateString + " " + weatherDates.get(2));

		parts = latestReportDate.split("-");
		// DEN FULASTE LÖSNINGEN IN THE HISTORY OF MANKIND
		dayPart = parts[2].split(" ");
		String[] timePart = dayPart[1].split(":");
		int currentYear = Integer.parseInt(parts[0]);
		int currentMonth = Integer.parseInt(parts[1]);
		int currentDay = Integer.parseInt(dayPart[0]);
		
		int currentHour = Integer.parseInt(timePart[0]);
		int currentMin = Integer.parseInt(timePart[1]);
		Date currentDate = new Date(currentYear, currentMonth, currentDay);
		long currentTotalTime = ((currentHour * 60) + currentMin) * 1000;
		ArrayList <Integer> weatherYears = new ArrayList<Integer>();
		ArrayList <Integer> weatherMonths = new ArrayList<Integer>();
		ArrayList <Integer> weatherDays = new ArrayList<Integer>();
		ArrayList <Date> weatherDates = new ArrayList<Date>();
		ArrayList <Integer> weatherHours = new ArrayList<Integer>();
		ArrayList <Integer> weatherMins = new ArrayList<Integer>();
		for (int i = 0; i < weatherDatesString.size(); i++)
		{
			parts = weatherDatesString.get(i).split("-");
			dayPart = parts[2].split(" ");
			timePart = dayPart[1].split(":");

			weatherYears.add(Integer.parseInt(parts[0]));
			weatherMonths.add(Integer.parseInt(parts[1]));
			weatherDays.add(Integer.parseInt(dayPart[0]));
			weatherDates.add(new Date(weatherYears.get(i), weatherMonths.get(i), weatherDays.get(i)));
			weatherHours.add(Integer.parseInt(timePart[0]));
			weatherMins.add(Integer.parseInt(timePart[1]));
		}
		 
		long diffDate;
		long closest = weatherDates.get(0).getTime(); // set to first
		Date closestDate = new Date();
		long totalHourMin;
		//comparison between the dates
		int counter = 0;
		for (int i = 1; i < weatherDates.size(); i++)
		{
			totalHourMin = ((weatherHours.get(i) * 60) + weatherMins.get(i)) * 1000; // * 1000 because convert to milliseconds

			diffDate = Math.abs((weatherDates.get(i).getTime() + totalHourMin) - (currentDate.getTime() + currentTotalTime)); // getTime returns the number of milliseconds since January 1, 1970, 00:00:00 GMT
			if(diffDate < closest)
			{
				closest = diffDate;
				closestDate = new Date(weatherDates.get(i).getTime() + totalHourMin); //using milliseconds constructor
				counter = i;
			}
			
			System.out.println(closest);
		}
		return counter;

	}
}
