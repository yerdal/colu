package ship;
import java.util.Date;


/**
 * Class for handling the requested parameters from frontend
 */
public class RequestedParameters{
  //FOr auto Generation
   // @Id
   //  @GeneratedValue(strategy=GenerationType.AUTO)
  private double requiredCurrentSpeed;
  private double requiredWindSpeed;
  private double requiredWindDir;
  private double requiredSignWaveHeight;
  private double requiredCurrentDir;
  private String requiredMinETA;
  private String requiredMaxETA;
  private double requiredAvgSpeedMin;
  private double requiredAvgSpeedMax;




  public String getRequiredMinETA(){
    return requiredMinETA;
  }
  public String getRequiredMaxETA(){
    return requiredMaxETA;
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