package ship;
import java.util.ArrayList;

/**
 * Class to represent each Waypoint for the ship, i.e the expected positions of the ship
 */
public class Waypoint
{
	private int id;
	//values
	private String waypointName;
	private double waypointSpeed; //Ship speed at waypoint
	private String nWaypoint; // Order of waypoint
	private double lat;
	private double lon;
	private String legType;
	private String waypointETA;
	//default constructor
	public Waypoint()
	{
		id = 0;
		waypointName = "undefined";
		waypointSpeed = 0.0;
		nWaypoint = "undefined";
		lat = 0.0;
		lon = 0.0;
		legType = "undefined";
		waypointETA = "undefined";
	}
	public Waypoint(int theId, String theWaypointName,
					double theWaypointSpeed, 
					String theNWaypoint,
					double theLat, 
					double theLon,
					String theLegType,
					String theWaypointETA)
	{
		id = theId;
		waypointName = theWaypointName;
		waypointSpeed = theWaypointSpeed;
		nWaypoint = theNWaypoint;
		lat = theLat;
		lon = theLon;
		legType = theLegType;
		waypointETA = theWaypointETA;
	}
	public int getID()
	{
		return id;
	}
	public String getWaypointName()
	{
		return waypointName;
	}
	public double getWaypointSpeed()
	{
		return waypointSpeed;
	}
	public String getNWaypoint()
	{
		return nWaypoint;
	}
	public double getLat()
	{
		return lat;
	}
	public double getLon()
	{
		return lon;
	}
	public String getLegType()
	{
		return legType;
	}
	public String getWaypointETA()
	{
		return waypointETA;
	}

}
