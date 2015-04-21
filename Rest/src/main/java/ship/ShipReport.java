package ship;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm");
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
	public Date getEtaEarliest(){
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
	public void updateRequiredETAStatus(Date reqEta){
		if(reqEta.compareTo(etaEarliest)>0){
        // System.out.println("reqEta is after etaEarliest");
        requiredETAStatus = "BAD";
    }else if(reqEta.compareTo(etaEarliest)<0){
        // System.out.println("reqEta is before etaEarliest");
        requiredETAStatus = "BAD";
    }else{
        // System.out.println("reqEta is equal to etaEarliest");
        requiredETAStatus = "OK";
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