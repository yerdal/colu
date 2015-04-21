package ship;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SavedParameters {
  //FOr auto Generation
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  private double requiredCurrentSpeed;
  private double requiredWindSpeed;
  private double requiredWindDir;
  private double requiredSignWaveHeight;
  private double requiredCurrentDir;
  private String requiredETA;
  private double requiredAvgSpeedMin;
  private double requiredAvgSpeedMax;

  protected SavedParameters(){} //So it works with JPA
  
  public SavedParameters(double theRequiredCurrentSpeed,
                        double theRequiredWindSpeed,
                        double theRequiredWindDir,
                        double theRequiredSignWaveHeight,
                        double theRequiredCurrentDir,
                        double theRequiredAvgSpeedMin,
                        double theRequiredAvgSpeedMax,
                        String theRequiredETA) {
        requiredCurrentSpeed = theRequiredCurrentSpeed;
        requiredWindSpeed = theRequiredWindSpeed;
        requiredWindDir = theRequiredWindDir;
        requiredSignWaveHeight = theRequiredSignWaveHeight;
        requiredCurrentDir = theRequiredCurrentDir;
        requiredAvgSpeedMin = theRequiredAvgSpeedMin;
        requiredAvgSpeedMax = theRequiredAvgSpeedMax;
        requiredETA = theRequiredETA;
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


}


    
