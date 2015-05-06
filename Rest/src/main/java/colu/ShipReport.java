package colu;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


/**
 * Class to represent the Ship Report
 */
public class ShipReport
{
	private int reportID; //Database ID for report, number.
	private int cosp_eosp; //Indicate if ship report is COSP[commense sea passage] or EOSP[end sea passage], 0,1,2.
	private Date etaEarliest; //Estimated earliest arrival, date string???.
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
	private double distSinceLatestRep; //Distance SLR[nm nautic mile] reported by vessel. //since latest report
	private double distRemToGo; //Distance left, [nm nautic mile]. //remaining?
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
	private double heatHfoSLR; // HFO == Heavy Fuel Oil  SLR == since last report unit: metric tonnes 
	private double heatLfsoSLR; // LFSO == Low Sulphur Fuel Oil. unit: metric tonnes
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


	//Our new vaiables!
	private String requiredETAStatus; //OK = ontime / BAD 
	private String requiredAvgSpeedStatus;



	public ShipReport(){
		reportID = 0;
		cosp_eosp = 0;
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		etaEarliest = new Date();
		obsWindspeed = 0.0;
		obsWindspeedbf = 0.0;
		obsWindDir = 0.0;
		obsWaveh = 0.0;
		obsSwellh = 0.0;
		obsSwellDir = 0.0;
		course = 0.0;
		speedAvg = 0.0;
		rpmAvg = 0.0;
		loadAvg = 0.0;
		distSinceLatestRep = 0.0;
		distRemToGo = 0.0;
		hfoBrob = 0.0;
		lsfoBrob = 0.0;
		mgoBrob = 0.0;
		mdoBrob = 0.0;
		meHfoSLR = 0.0;
		meLsfoSLR = 0.0;
		memDoSLR = 0.0;
		memGoSLR = 0.0;
		auxHfoSLR = 0.0;
		auxLsfoSLR = 0.0;
		auxMdoSLR = 0.0;
		auxMgoSLR = 0.0;
		boilerHfoSLR = 0.0;
		boilerLsfoSLR = 0.0;
		boilerMdoSLR = 0.0;
		boilerMgoSLR = 0.0;
		cleanHfoSLR = 0.0;
		cleanLsfoSLR = 0.0;
		cleanMdoSLR = 0.0;
		cleanMgoSLR = 0.0;
		heatHfoSLR = 0.0;
		heatLfsoSLR = 0.0;
		heatMdoSLR = 0.0;
		heatMgoSLR = 0.0;
		genAtSeaHfoSLR = 0.0;
		genAtSeaLsfoSLR = 0.0;
		genAtSeaMdoSlr = 0.0;
		genAtSeaMgoSLR = 0.0;
		othersAtSeaHfoSLR = 0.0;
		othersAtSeaLsfoSLR = 0.0;
		othersAtSeaMdoSLR = 0.0;
		othersAtSeaMgoSLR = 0.0;
		instructedLegCode = "undefined";
		instructedSpeed = "undefined";
		propulsionEngines = 0;
		shaftGenerators = 0;
		finStabilizers = 0;
		steamTimeSLR = 0.0;
		baselineInstructionID = 0;
		proformaSpeed = 0.0;
		intendedSpeed = 0.0;
		lon = 0.0;
		legType = 0;
		lat = 0.0;
		date = "2000-01-01 00:00";
	}

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
						 double theDistSinceLatestRep, 
						 double theDistRemToGo,
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
		try {
 			if(theEtaEarliest.equals(""))
 				theEtaEarliest = "00-00-00 00:00";
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			etaEarliest = formatter.parse(theEtaEarliest);
 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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
		intendedSpeed = theIntentedSpeed;
		lon = theLon;
		legType = theLegType;
		lat = theLat;
		date = theDate;
		requiredETAStatus = "undefined";
		requiredAvgSpeedStatus = "undefined";
	}
	public int getReportID(){
		return reportID;
	}
	public int getCosp_eosp(){
		return cosp_eosp;
	}
	public String getEtaEarliest(){
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return form.format(etaEarliest);
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
	public double getIntendedSpeed(){
		return intendedSpeed;
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


	//Newly added functions for levels on backend/
	//GET
	public String getRequiredETAStatus(){
		return requiredETAStatus;
	}
	public String getAvgSpeedStatus(){
		return requiredAvgSpeedStatus;
	}

	//Update
	public void updateRequiredETAStatus(Date reqMinEta, Date reqMaxEta){
		if((reqMinEta.compareTo(etaEarliest) < 0) && (reqMaxEta.compareTo(etaEarliest) > 0))
		{
        // GOOOD in between
        requiredETAStatus = "GOOD";
    	}
    	else
    	{
        // Bad
        requiredETAStatus = "BAD";
    	}
		
	}
	public void updateAvgSpeedStatus(double min, double max){
		if(speedAvg >= min && speedAvg <= max ){
			requiredAvgSpeedStatus = "GOOD";
		}else{
			requiredAvgSpeedStatus = "BAD";
		}
	}


}