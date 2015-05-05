
package colu;

/**
 * Class to represent the Satelite positions from each ship
 */

public class SatCPollPosition {

  //According to XML File
  private double longitude;
  private double latitude;
  private int position_id;
  private String date;
  private double course;
  private double speed;
  private String region;
  private double speed_slp;


  
  public SatCPollPosition(){
    longitude = 0.0;
    latitude = 0.0;
    position_id = 0;
    date = "undefined";
    course = 0.0;
    speed = 0.0;
    region = "undefined";
    speed_slp = 0.0;
  }

  public SatCPollPosition(int theId, double theLongitude, double theLatitude, String theDate , double theCourse,
    double theSpeed, String theRegion, double theSpeedSlp ) {
    longitude = theLongitude;
    latitude = theLatitude;
    position_id = theId;
    date = theDate;
    course = theCourse;
    speed = theSpeed;
    region = theRegion;
    speed_slp = theSpeedSlp;
  }

  public int getPositionId(){
    return position_id;
  }
  public double getLon(){
    return longitude;
  }
  public double getLat(){
    return latitude;
  }
  public String getDate(){
    return date;
  }
  public double getCourse(){
    return course;
  }
  public double getSpeed(){
    return speed;
  }
  public String getRegion(){
    return region;
  }
  public double getSpeedSlp(){
    return speed_slp;
  }

  
}