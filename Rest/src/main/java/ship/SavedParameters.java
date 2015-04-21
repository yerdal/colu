package ship;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SavedParameters {
  //FOr auto Generation
  //The Voyage ID
  @Id
  private int id;
  // @GeneratedValue(strategy=GenerationType.AUTO)
  
  private double requiredCurrentSpeed;
  private double requiredWindSpeed;
  private double requiredWindDir;
  private double requiredSignWaveHeight;
  private double requiredCurrentDir;
  private String requiredETA;
  private double requiredAvgSpeedMin;
  private double requiredAvgSpeedMax;

  protected SavedParameters(){} //So it works with JPA
  
  public SavedParameters(int theId,
                        double theRequiredCurrentSpeed,
                        double theRequiredWindSpeed,
                        double theRequiredWindDir,
                        double theRequiredSignWaveHeight,
                        double theRequiredCurrentDir,
                        double theRequiredAvgSpeedMin,
                        double theRequiredAvgSpeedMax,
                        String theRequiredETA) {
        id = theId;
        requiredCurrentSpeed = theRequiredCurrentSpeed;
        requiredWindSpeed = theRequiredWindSpeed;
        requiredWindDir = theRequiredWindDir;
        requiredSignWaveHeight = theRequiredSignWaveHeight;
        requiredCurrentDir = theRequiredCurrentDir;
        requiredAvgSpeedMin = theRequiredAvgSpeedMin;
        requiredAvgSpeedMax = theRequiredAvgSpeedMax;
        requiredETA = theRequiredETA;
    }
  public int getId(){
    return id;
  }
  public String getRequiredETA(){
    return requiredETA;
  }
  public double getRequiredCurrentSpeed(){
    return requiredCurrentSpeed;
  }
  public double getRequiredWindSpeed(){
    return requiredWindSpeed;
  }
  public double getRequiredWindDir(){
    return requiredWindDir;
  }
  public double getRequiredSignWaveHeight(){
    return requiredSignWaveHeight;
  }
  public double getRequiredCurrentDir(){
    return requiredCurrentDir;
  }
  public double getRequiredAvgSpeedMin(){
    return requiredAvgSpeedMin;
  }
  public double getRequiredAvgSpeedMax(){
    return requiredAvgSpeedMax;
  }
  //Setters
  public void setRequiredCurrentSpeed(double theRequiredCurrentSpeed){
    requiredCurrentSpeed = theRequiredCurrentSpeed;
  }
  public void setRequiredWindSpeed(double theRequiredWindSpeed ){
    requiredWindSpeed = theRequiredWindSpeed;
  }
  public void setRequiredWindDir(double theRequiredWindDir){
    requiredWindDir = theRequiredWindDir;
  }
  public void setRequiredSignWaveHeight(double theRequiredSignWaveHeight){
    requiredSignWaveHeight = theRequiredSignWaveHeight;
  }
  public void setRequiredCurrentDir(double theRequiredCurrentDir){
    requiredCurrentDir = theRequiredCurrentDir;
  }
  public void setRequiredETA(String theRequiredETA){
    requiredETA = theRequiredETA;
  }
  public void setRequiredAvgSpeedMin(double theRequiredAvgSpeedMin){
    requiredAvgSpeedMin = theRequiredAvgSpeedMin;
  }
  public void setRequiredAvgSpeedMax(double theRequiredAvgSpeedMax){
    requiredAvgSpeedMax = theRequiredAvgSpeedMax;
  }

}


    
