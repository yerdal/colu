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
	private double heatHfoSLR; // HFO == Heavy Fuel Oil  SLR == since last report unit: metric tonnes 
	private double heatLsfoSLR; // LFSO == Low Sulphur Fuel Oil. unit: metric tonnes
	private double heatMdoSLR; // MDO == Marine Diesel Oil. unit: metric tonnes
	private double heatMgoSLR; // MGO == Marine Gas Oil. unit: metric tonnes
	private double genAtSeaHfoSLR; // unit: metric tonnes
	private double genAtSeaLsfoSLR; // unit: metric tonnes
	private double genAtSeaMdoSlr; // unit: metric tonnes
	private double genAtSeaMgoSLR; // unit: metric tonnes
	private double othersAtSeaHfoSLR; // unit: metric tonnes
	private double othersAtSeaLsfoSLR; // unit: metric tonnes
	private double othersAtSeaMdoSLR; // unit: metric tonnes
	private double othersAtSeaMgoSLR; // unit: metric tonnes
	private String instructedLegCode; // legal code? OPTIONAL
	private String instructedSpeed; // OPTIONAL
	private int propulsionEngines; // Propulsion engines in use. Dvs antal propulsion engines?
	private int shaftGenerators; // Shaft generators in use. Dvs antal?
	private int finStabilizers; // Fin stabilizers in use, yes/no. 0 == No, 1 == Yes.
	private double steamTimeSLR; // Reported steaming time SLR. Unit: hours
	private int baselineInstructionID; // Instruction ID.
	private double proformaSpeed; // proforma == för formens skull på latin. WTF. unit: knots
	private double intendedSpeed; // intended speed. unit: knots
	private double lon; // longitude
	private int legType; // repposition.legtype. Different types of legs. 1 eller 2. 1 == RL. 2 == GC.
	private double lat; // latitude
	private String date; // date of report

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
						 double theHeatHfoSLR,
						 double theHeatLfsoSLR,
						 double theHeatMdoSLR,
						 double theHeatMgoSLR,
						 double theGenAtSeaHfoSLR,
						 double theGenAtSeaLsfoSLR,
						 double theGenAtSeaMdoSlr,
						 double theGenAtSeaMgoSLR,
						 double theOthersAtSeaHfoSLR,
						 double theOthersAtSeaLsfoSLR,
						 double theOthersAtSeaMdoSLR,
						 double theOthersAtSeaMgoSLR,
						 String theInstructedLegCode,
						 String theInstructedSpeed,
						 int thePropulsionEngines,
						 int theShaftGenerators,
						 int theFinStabilizers,
						 double theSteamTimeSLR,
						 int theBaselineInstructionID,
						 double theProformaSpeed,
						 double theIntentedSpeed,
						 double theLon,
						 int theLegType,
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
	public double getHeatHfoSLR(){
		return heatHfoSLR;
	}
	public double getHeatLfsoSLR(){
		return heatLfsoSLR;
	}
	public double getHeatMdoSLR(){
		return heatMdoSLR;
	}
	public double getHeatMgoSLR(){
		return heatMgoSLR;
	}
	public double getGenAtSeaHfoSLR(){
		return genAtSeaHfoSLR;
	}
	public double getGenAtSeaLsfoSLR(){
		return genAtSeaLsfoSLR;
	}
	public double getGenAtSeaMdoSlr(){
		return genAtSeaMdoSlr;
	}
	public double getGenAtSeaMgoSLR(){
		return genAtSeaMgoSLR;
	}
	public double getOthersAtSeaHfoSLR(){
		return othersAtSeaHfoSLR;
	}
	public double getOthersAtSeaLsfoSLR(){
		return othersAtSeaLsfoSLR;
	}
	public double getOthersAtSeaMdoSLR(){
		return othersAtSeaMdoSLR;
	}
	public double getOthersAtSeaMgoSLR(){
		return othersAtSeaMgoSLR;
	}
	public String getInstructedLegCode(){
		return instructedLegCode;
	}
	public String getInstructedSpeed(){
		return instructedSpeed;
	}
	public int getPropulsionEngines(){
		return propulsionEngines;
	}
	public int getShaftGenerators(){
		return shaftGenerators;
	}
	public int getFinStabilizers(){
		return finStabilizers;
	}
	public double getSteamTimeSLR(){
		return steamTimeSLR;
	}
	public int getBaselineInstructionID(){
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
	public int getLegType(){
		return legType;
	}
	public double getLat(){
		return lat;
	}
	public String getDate(){
		return date;
	}


}