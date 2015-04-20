package ship;
import java.util.Date;

public class RequestedParameters{
  private double requiredCurrentSpeed;
  private double requiredWindSpeed;
  private double requiredWindDir;
  private double requiredSignWaveHeight;
  private double requiredCurrentDir;
  private String requiredETA;

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


}