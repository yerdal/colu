package ship;
import java.util.ArrayList;

public class WeatherWaypoint
{
	private double windSpeed;
	private double windDir;
	private double swellh;
	private double swellDir; 
	private double swellPeriod;
	private double currentSpeed;
	private double currentDir;
	private double pressure;
	private double signwaveh;
	private double windwaveh;
	private double windWavePeriod;
	private double calcShipSpeed;
	private double weatherFactor;
	private double currentFactor;
	private double calcDistance;
	private double goodWeather;
	private double lon;
	private String legType;
	private double lat;
	private String date;

	public WeatherWaypoint (double theWindSpeed,
							double theWindDir,
							double theSwellh,
							double theSwellDir, 
							double theSwellPeriod,
							double theCurrentSpeed,
							double theCurrentDir,
							double thePressure,
							double theSignwaveh,
							double theWindwaveh,
							double theWindWavePeriod,
							double theCalcShipSpeed,
							double theWeatherFactor,
							double theCurrentFactor,
							double theCalcDistance,
							double theGoodWeather,
						 	double theLon,
							String theLegType,
							double theLat,
							String theDate)
	{
		windSpeed = theWindSpeed;
		windDir = theWindDir;
		swellh = theSwellh;
		swellDir = theSwellDir; 
		swellPeriod = theSwellPeriod;
		currentSpeed = theCurrentSpeed;
		currentDir = theCurrentDir;
		pressure = thePressure;
		signwaveh = theSignwaveh;
		windwaveh = theWindwaveh;
		windWavePeriod = theWindWavePeriod;
		calcShipSpeed = theCalcShipSpeed;
		weatherFactor = theWeatherFactor;
		currentFactor = theCurrentFactor;
		calcDistance = theCalcDistance;
		goodWeather = theGoodWeather;
		lon = theLon;
		legType = theLegType;
		lat = theLat;
		date = theDate;
	}

	public double getWindSpeed()
	{
		return windSpeed;
	}
	public double GetWindDir()
	{
		return windDir;
	}
	public double getTheSwellh()
	{
		return swellh;
	}
	public double getLat()
	{
		return lat;
	}
	public double getLon()
	{
		return lon;
	}

	
}