package ship;
import java.util.ArrayList;
public class ShipReport
{
	private int reportID; //Database ID for report, number.
	private int cosp_eosp; //Indicate if ship report is COSP[commense sea passage] or EOSP[end sea passage], 0,1,2.
	private String etaEarliest; //Estimated earliest arrival, date string???.
	private double obsWindspeed; //Reported wind speed
	private double obsWindspeedbf; //Wind reported by vessel.
	private double obsWindDir; //Reported wind direction.
	private double obsWaveh; //Reported wave height.
	private double obsSwellh; //Reported swell height.
	private double obsSwellDir; //Reported swell direction.
	private double course; // Reported ship direction, double, 0-360, degree.
	private double speedAvg; //Average ship speed, double, 0-23.
	private double rpmAvg; // Average RPM reported by vessel,
	private double loadAvg; //Average Main Engine Load [%] reported by vessel, 0-100.
	private double distSinceLatestRep; //Distance SLR[nm nautic mile] reported by vessel.
	private double distRemToGo; //Distance left, [nm nautic mile].
	private double hfoBrob; //Heavy fuel Oil Remaining on board, [mt metric tonnes]
	private double lsfoBrob; //Low sulfur fuel oil Remaining on board, [mt metric tonnes]
	private double mgoBrob; //Marine gas oil remaining on board, [mt metric tonnes].
	private double mdoBrob; //Marine diesel oil remaining on board, [mt metric tonnes].
	private double meHfoSLR; // ME Heavy fuel oil since last report, [mt metric tonnes].
	private double meLsfoSLR; // ME Low sulfur oil since last report, [mt metric tonnes].
	private double memDoSLR; //ME marine diesel oil since last report, [mt metric tonnes].
	private double memGoSLR; //ME marine gas oil since last report, [mt metric tonnes].
	private double auxHfoSLR; //Auxiliary heavy fuel oil since last report, [mt metric tonnes].
	private double auxLsfoSLR; //Auxiliary low sulfur oil since last report, [mt metric tonnes].
	private double auxMdoSLR; //Auxiliary marine diesel oil since last report, [mt metric tonnes].
	private double auxMgoSLR; //Auxiliary marine gas oil since last report, [mt metric tonnes].
	private double boilerHfoSLR; //Boiler heavy fuel oil since last report, [mt metric tonnes].
	private double boilerLsfoSLR; //Boiler Low sulfur oil since last report, [mt metric tonnes].
	private double boilerMdoSLR; //Boiler marine diesel oil since last report, [mt metric tonnes].
	private double boilerMgoSLR; //Boiler marine gas oil since last report, [mt metric tonnes].
	private double cleanHfoSLR; //Clean heavy fuel oil since last report, [mt metric tonnes].
	private double cleanLsfoSLR; //Clean low sulfur oil since last report, [mt metric tonnes].
	private double cleanMdoSLR; // Clean marine diesel oil since last report, [mt metric tonnes].
	private double cleanMgoSLR; //Clean marine gas oil since last report, [mt metric tonnes].
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
						 int theCosp_eosp,
						 String theEtaEarliest,
						 double theObsWindspeed,
						 double theObsWindspeedbf,
						 double theObsWindDir,
						 double theObsWaveh,
						 double theObsSwellh,
						 double theObsSwellDir,
						 double theCourse,
						 double theSpeedAvg,
						 double theRpmAvg,
						 double theLoadAvg,
						 double theDistSinceLatestRep, //since latest report
						 double theDistRemToGo, remaining?
						 double theHfoBrob,
						 double theLsfoBrob,
						 double theMgoBrob,
						 double theMdoBrob,
						 double theMeHfoSLR,
						 double theMeLsfoSLR,
						 double theMemDoSLR,
						 double theMemGoSLR,
						 double theAuxHfoSLR,
						 double theAuxLsfoSLR,
						 double theAuxMdoSLR,
						 double theAuxMgoSLR,
						 double theBoilerHfoSLR,
						 double theBoilerLsfoSLR,
						 double theBoilerMdoSLR,
						 double theBoilerMgoSLR,
						 double theCleanHfoSLR,
						 double theCleanLsfoSLR,
						 double theCleanMdoSLR,
						 double theCleanMgoSLR,
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
	public int getCosp_eosp(){
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
	public double getCourse(){
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
	public double getHfoBrob(){
		return hfoBrob;
	}
	public double getLsfoBrob(){
		return lsfoBrob;
	}
	public double getMgoBrob(){
		return mgoBrob;
	}
	public double getMdoBrob(){
		return mdoBrob;
	}
	public double getMeHfoSLR(){
		return meHfoSLR;
	}
	public double getMeLsfoSLR(){
		return meLsfoSLR;
	}
	public double getMemDoSLR(){
		return memDoSLR;
	}
	public double getMemGoSLR(){
		return memGoSLR;
	}
	public double getAuxHfoSLR(){
		return auxHfoSLR;
	}
	public double getAuxLsfoSLR(){
		return auxLsfoSLR;
	}
	public double getAuxMdoSLR(){
		return auxMdoSLR;
	}
	public double getAuxMgoSLR(){
		return auxMgoSLR;
	}
	public double getBoilerHfoSLR(){
		return boilerHfoSLR;
	}
	public double getBoilerLsfoSLR(){
		return boilerLsfoSLR;
	}
	public double getBoilerMdoSLR(){
		return boilerMdoSLR;
	}
	public double getBoilerMgoSLR(){
		return boilerMgoSLR;
	}
	public double getCleanHfoSLR(){
		return cleanHfoSLR;
	}
	public double getCleanLsfoSLR(){
		return cleanLsfoSLR;
	}
	public double getCleanMdoSLR(){
		return cleanMdoSLR;
	}
	public double getCleanMgoSLR(){
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