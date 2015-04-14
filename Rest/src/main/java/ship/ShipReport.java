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
							private String cosp_eosp;
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

}