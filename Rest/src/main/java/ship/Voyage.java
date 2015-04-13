package ship;
import java.util.ArrayList;
public class Voyage
{
	private int voyageID;
	private int worklistID;
	private String systemOnBoardStatus;
	private String state;
	private String pvapdfurl;
	private String lastUpdate;
	//values
	private String voyageName;
	private String voyRef;
	private Operator operator;
	private String personName;
	private Ship ship;
	private String departure;
	private String destination;
	private String etd;
	private String eta;
	private String requiredEta;
	private String loading;
	private String cargoWeight;
	private String cargoSensitiv;
	private String gmHeight;
	private String displacementAtDep;
	private String maxSpeed;
	private String draftAft;
	private String draftFwd;
	private String draftMean;
	private String draftTrim;
	private String tradelaneName;
	private String phase;
	private String hasRoute;
	private String nextMessageDate;
	private String priority;
	private String seaName;
	private String seaSortOrder;
	private String forecastModifiedDate;
	private String forecastState;
	private String foBrobDep;
	private String doBrobDep;
	private String foBrobLatest;
	private String doBrobLatest;
	private String hasPva;
	private ArrayList <WeatherWaypoint> weatherWaypoints;
	private String comment;
	// private bool onGoing; //kanske?
	public Voyage (int theVoyageID, int theWorklistID, String theSystemOnBoardStatus, 
									String theState,
									String thePvadpfurl,
									String theLastUpdate,
									String theVoyageName,
									String theVoyRef,
									Operator theOperator,
									String thePersonName,
									Ship theShip,
									String theDeparture,
									String  theDestination,
									String theEtd,
									String theEta,
									String theRequiredEta,
									String theLoading,
									String theCargoWeight,
									String theCargoSensitiv,
									String theGmHeight,
									String theDisplacementAtDep,
									String theMaxSpeed,
									String theDraftAft,
									String theDraftFwd,
									String theDraftMean,
									String theDraftTrim,
									String theTradelaneName,
									String thePhase,
									String theHasRoute,
									String theNextMessageDate,
									String thePriority,
									String theSeaName,
									String theSeaSortOrder,
									String theForecastModifiedDate,
									String theForecastState,
									String theFoBrobDep,
									String theDoBrobDep,
									String theFoBrobLatest,
									String theDoBrobLatest,
									String theHasPva,
									ArrayList <WeatherWaypoint> theWeatherWaypoints,
									String theComment)
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
	  	loading = theLoading;
	  	cargoWeight = theCargoWeight;
	  	cargoSensitiv = theCargoSensitiv;
	  	gmHeight = theGmHeight;
	  	displacementAtDep = theDisplacementAtDep;
	 	maxSpeed = theMaxSpeed;
	  	draftAft = theDraftAft;
	  	draftFwd = theDraftFwd;
	  	draftMean = theDraftMean;
	  	draftTrim = theDraftTrim;
	  	tradelaneName = theTradelaneName;
	  	phase = thePhase;
	  	hasRoute = theHasRoute;
	  	nextMessageDate = theNextMessageDate;
	  	priority = thePriority;
	  	seaName = theSeaName;
	  	seaSortOrder = theSeaSortOrder;
	  	forecastModifiedDate = theForecastModifiedDate;
	  	forecastState = theForecastState;
	  	foBrobDep = theFoBrobDep;
	  	doBrobDep = theDoBrobDep;
	  	foBrobLatest = theFoBrobDep;
	  	doBrobLatest = theDoBrobLatest;
	  	foBrobLatest = theFoBrobLatest;
	  	hasPva = theHasPva;
	  	weatherWaypoints = theWeatherWaypoints;
	 	comment = theComment;

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
}
