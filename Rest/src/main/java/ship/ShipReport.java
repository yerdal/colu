package ship;
import java.util.ArrayList;
public class ShipReport
{
	private int reportID;
	private String cosp_eosp;
	private String etaEarliest;
	private double obsWindspeed;
	private double obsWindspeedbf;
	private double obsWindDir;
	private double obsWaveh;
	private double obsSwellh;
	private double obsSwellDir;
	private String course;
	private double speedAvg;
	private double rpmAvg;
	private double loadAvg;
	private double distSinceLatestRep; //since latest report
	private double distRemToGo; //remaining?
	private String hfoBrob;
	private String lsfoBrob;
	private String mgoBrob;
	private String mdoBrob;
	private String meHfoSLR;
	private String meLsfoSLR;
	private String memDoSLR;
	private String memGoSLR;
	private String auxHfoSLR;
	private String auxLsfoSLR;
	private String auxMdoSLR;
	private String auxMgoSLR;
	private String boilerHfoSLR;
	private String boilerLsfoSLR;
	private String boilerMdoSLR;
	private String boilerMgoSLR;
	private String cleanHfoSLR;
	private String cleanLsfoSLR;
	private String cleanMdoSLR;
	private String cleanMgoSLR;
	private String heatHfoSLR;
	private String heatLfsoSLR;
	private String heatMdoSLR;
	private String heatMgoSLR;
	private String genAtSeaHfoSLR;
	private String genAtSeaLsfoSLR;
	private String genAtSeaMdoSlr;
	private String genAtSeaMgoSLR;
	private String othersAtSeaHfoSLR;
	private String othersAtSeaLsfoSLR;
	private String othersAtSeaMdoSLR;
	private String othersAtSeaMgoSLR;
	private String instructedLegCode;
	private double instructedSpeed;
	private String propulsionEngines;
	private String shaftGenerators;
	private String finStabilizers;
	private String steamTimeSLR;
	private String baselineInstructionID;
	private double proformaSpeed;
	private double intentedSpeed;
	private double lon;
	private String legType;
	private double lat;
	private String date;

	public ShipReport(int theReportID,
							String theCosp_eosp,
						 String theEtaEarliest,
						 double theObsWindspeed,
						 double theObsWindspeedbf,
						 double theObsWindDir,
						 double theObsWaveh,
						 double theObsSwellh,
						 double theObsSwellDir,
						 String theCourse,
						 double theSpeedAvg,
						 double theRpmAvg,
						 double theLoadAvg,
						 double theDistSinceLatestRep, //since latest report
						 double theDistRemToGo, //remaining?
						 String theHfoBrob,
						 String theLsfoBrob,
						 String theMgoBrob,
						 String theMdoBrob,
						 String theMeHfoSLR,
						 String theMeLsfoSLR,
						 String theMemDoSLR,
						 String theMemGoSLR,
						 String theAuxHfoSLR,
						 String theAuxLsfoSLR,
						 String theAuxMdoSLR,
						 String theAuxMgoSLR,
						 String theBoilerHfoSLR,
						 String theBoilerLsfoSLR,
						 String theBoilerMdoSLR,
						 String theBoilerMgoSLR,
						 String theCleanHfoSLR,
						 String theCleanLsfoSLR,
						 String theCleanMdoSLR,
						 String theCleanMgoSLR,
						 String theHeatHfoSLR,
						 String theHeatLfsoSLR,
						 String theHeatMdoSLR,
						 String theHeatMgoSLR,
						 String theGenAtSeaHfoSLR,
						 String theGenAtSeaLsfoSLR,
						 String theGenAtSeaMdoSlr,
						 String theGenAtSeaMgoSLR,
						 String theOthersAtSeaHfoSLR,
						 String theOthersAtSeaLsfoSLR,
						 String theOthersAtSeaMdoSLR,
						 String theOthersAtSeaMgoSLR,
						 String theInstructedLegCode,
						 double theInstructedSpeed,
						 String thePropulsionEngines,
						 String theShaftGenerators,
						 String theFinStabilizers,
						 String theSteamTimeSLR,
						 String theBaselineInstructionID,
						 double theProformaSpeed,
						 double theIntentedSpeed,
						 double theLon,
						 String theLegType,
						 double theLat,
						 String theDate)
	{
		reportID = theReportID;
		cosp_eosp = theCosp_eosp;
		etaEarliest = theEtaEarliest;
		obsWindspeed = theObsWindspeed;
		obsWindspeedbf = theObsWindspeedbf;
		obsWindDir = theObsWindDir;
		obsWaveh = theObsWaveh;
		obsSwellh = theObsSwellh;
		obsSwellDir = theObsSwellDir;
		course = theCourse;
		speedAvg = theSpeedAvg;
		rpmAvg = theRpmAvg;
		loadAvg = theLoadAvg;
		distSinceLatestRep = theDistSinceLatestRep;
		distRemToGo = theDistRemToGo;
		hfoBrob = theHfoBrob;
		lsfoBrob = theLsfoBrob;
		mgoBrob = theMgoBrob;
		mdoBrob = theMdoBrob;
		meHfoSLR = theMeHfoSLR;
		meLsfoSLR = theMeLsfoSLR;
		memDoSLR = theMemDoSLR;
		memGoSLR = theMemGoSLR;
		auxHfoSLR = theAuxHfoSLR;
		auxLsfoSLR = theAuxLsfoSLR;
		auxMdoSLR = theAuxMdoSLR;
		auxMgoSLR = theAuxMgoSLR;
		boilerHfoSLR = theBoilerHfoSLR;
		boilerLsfoSLR = theBoilerLsfoSLR;
		boilerMdoSLR = theBoilerMdoSLR;
		boilerMgoSLR = theBoilerMgoSLR;
		cleanHfoSLR = theCleanHfoSLR;
		cleanLsfoSLR = theCleanLsfoSLR;
		cleanMdoSLR = theCleanMdoSLR;
		cleanMgoSLR = theCleanMgoSLR;
		heatHfoSLR = theHeatHfoSLR;
		heatLfsoSLR = theHeatLfsoSLR;
		heatMdoSLR = theHeatMdoSLR;
		heatMgoSLR = theHeatMgoSLR;
		genAtSeaHfoSLR = theGenAtSeaHfoSLR;
		genAtSeaLsfoSLR = theGenAtSeaLsfoSLR;
		genAtSeaMdoSlr = theGenAtSeaMdoSlr;
		genAtSeaMgoSLR = theGenAtSeaMgoSLR;
		othersAtSeaHfoSLR = theOthersAtSeaHfoSLR;
		othersAtSeaLsfoSLR = theOthersAtSeaLsfoSLR;
		othersAtSeaMdoSLR = theOthersAtSeaMdoSLR;
		othersAtSeaMgoSLR = theOthersAtSeaMgoSLR;
		instructedLegCode = theInstructedLegCode;
		instructedSpeed = theInstructedSpeed;
		propulsionEngines = thePropulsionEngines;
		shaftGenerators = theShaftGenerators;
		finStabilizers = theFinStabilizers;
		steamTimeSLR = theSteamTimeSLR;
		baselineInstructionID = theBaselineInstructionID;
		proformaSpeed = theProformaSpeed;
		intentedSpeed = theIntentedSpeed;
		lon = theLon;
		legType = theLegType;
		lat = theLat;
		date = theDate;
	
	}
	public int getReportID(){
		return reportID;
	}
	public String getCosp_eosp(){
		return cosp_eosp;
	}
	public String getEtaEarliest(){
		return etaEarliest;
	}
	public double getObsWindspeed(){
		return obsWindspeed;
	}
	public double getObsWindspeedbf(){
		return obsWindspeedbf;
	}
	public double getObsWindDir(){
		return obsWindDir;
	}
	public double getObsWaveh(){
		return obsWaveh;
	}
	public double getObsSwellh(){
		return obsSwellh;
	}
	public double getObsSwellDir(){
		return obsSwellDir;
	}
	public String getCourse(){
		return course;
	}
	public double getSpeedAvg(){
		return speedAvg;
	}
	public double getRpmAvg(){
		return rpmAvg;
	}
	public double getLoadAvg(){
		return loadAvg;
	}
	public double getDistSinceLatestRep(){
		return distSinceLatestRep;
	}
	public double getDistRemToGo(){
		return distRemToGo;
	}
	public String getHfoBrob(){
		return hfoBrob;
	}
	public String getLsfoBrob(){
		return lsfoBrob;
	}
	public String getMgoBrob(){
		return mgoBrob;
	}
	public String getMdoBrob(){
		return mdoBrob;
	}
	public String getMeHfoSLR(){
		return meHfoSLR;
	}
	public String getMeLsfoSLR(){
		return meLsfoSLR;
	}
	public String getMemDoSLR(){
		return memDoSLR;
	}
	public String getMemGoSLR(){
		return memGoSLR;
	}
	public String getAuxHfoSLR(){
		return auxHfoSLR;
	}
	public String getAuxLsfoSLR(){
		return auxLsfoSLR;
	}
	public String getAuxMdoSLR(){
		return auxMdoSLR;
	}
	public String getAuxMgoSLR(){
		return auxMgoSLR;
	}
	public String getBoilerHfoSLR(){
		return boilerHfoSLR;
	}
	public String getBoilerLsfoSLR(){
		return boilerLsfoSLR;
	}
	public String getBoilerMdoSLR(){
		return boilerMdoSLR;
	}
	public String getBoilerMgoSLR(){
		return boilerMgoSLR;
	}
	public String getCleanHfoSLR(){
		return cleanHfoSLR;
	}
	public String getCleanLsfoSLR(){
		return cleanLsfoSLR;
	}
	public String getCleanMdoSLR(){
		return cleanMdoSLR;
	}
	public String getCleanMgoSLR(){
		return cleanMgoSLR;
	}
	public String getHeatHfoSLR(){
		return heatHfoSLR;
	}
	public String getHeatLfsoSLR(){
		return heatLfsoSLR;
	}
	public String getHeatMdoSLR(){
		return heatMdoSLR;
	}
	public String getHeatMgoSLR(){
		return heatMgoSLR;
	}
	public String getGenAtSeaHfoSLR(){
		return genAtSeaHfoSLR;
	}
	public String getGenAtSeaLsfoSLR(){
		return genAtSeaLsfoSLR;
	}
	public String getGenAtSeaMdoSlr(){
		return genAtSeaMdoSlr;
	}
	public String getGenAtSeaMgoSLR(){
		return genAtSeaMgoSLR;
	}
	public String getOthersAtSeaHfoSLR(){
		return othersAtSeaHfoSLR;
	}
	public String getOthersAtSeaLsfoSLR(){
		return othersAtSeaLsfoSLR;
	}
	public String getOthersAtSeaMdoSLR(){
		return othersAtSeaMdoSLR;
	}
	public String getOthersAtSeaMgoSLR(){
		return othersAtSeaMgoSLR;
	}
	public String getInstructedLegCode(){
		return instructedLegCode;
	}
	public double getInstructedSpeed(){
		return instructedSpeed;
	}
	public String getPropulsionEngines(){
		return propulsionEngines;
	}
	public String getShaftGenerators(){
		return shaftGenerators;
	}
	public String getFinStabilizers(){
		return finStabilizers;
	}
	public String getSteamTimeSLR(){
		return steamTimeSLR;
	}
	public String getBaselineInstructionID(){
		return baselineInstructionID;
	}
	public double getProformaSpeed(){
		return proformaSpeed;
	}
	public double getIntentedSpeed(){
		return intentedSpeed;
	}
	public double getLon(){
		return lon;
	}
	public String getLegType(){
		return legType;
	}
	public double getLat(){
		return lat;
	}
	public String getDate(){
		return date;
	}


}