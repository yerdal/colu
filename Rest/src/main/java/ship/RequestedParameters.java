package ship;
import java.util.Date;


public class RequestedParameters{
  //FOr auto Generation
   // @Id
   //  @GeneratedValue(strategy=GenerationType.AUTO)
  private double requiredCurrentSpeed;
  private double requiredWindSpeed;
  private double requiredWindDir;
  private double requiredSignWaveHeight;
  private double requiredCurrentDir;
  private String requiredETA;
  private double requiredAvgSpeedMin;
  private double requiredAvgSpeedMax;




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