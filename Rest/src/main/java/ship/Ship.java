package ship;
import java.util.ArrayList;
/**
 * Class to represent the Ship
 */
public class Ship {

	private int id;
	//Static for now
	private double lati = 30.587745;
	private double longi = 16.192421;	
	private String name; //Gammalt???? Finns name där nere med.

	//According to the XML file 	
	private Operator operator;
	private String contract_contract_id; //borde egentligen skapa ett new Contract?
	private int hull_hull_id; // Hull == skrov. DB ID.
	private int engine_engine_id; // Engine ID from DB.
	private String ship_ship_name; // Ship name.
	private String shiptype_shiptypename; // Type of vessel
	private String ship_ship_signs; // Callsign
	private String ship_employment; // Values: T/C, Pool, Own, Unknown.
	private int hull_model_no; // IMO number. IMO == International Maritime Organization.
	private double hull_hull_len_oa; // Length over all. maxValue=500.0, minValue=10.0. Unit: meter
	private double hull_hull_len_pp; // LPP, dvs Perpendikel. maxValue=500.0, minValue=10.0 Unit: meter
	private double hull_hull_beam; // Beam, moulded. maxValue=100.0, minValue=2.0. Unit: meter.
	private double hull_hull_front; // Hull displacement.  Unit: Metric tonnes
	private double hull_hull_side; // Hull parameter. Unit: meter
	private double hull_hull_factor; // Hull factor. No unit specified in XML.
	private double ship_ship_nt; // Draft. maxValue=25.0, minValue=1.0. Unit: meter
	private double ship_draft_design; // Draft design. maxValue=25.0, minValue=1.0. Unit: meter.
	private double ship_draft_scantling; // Draft scantling. maxValue = 25.0, minValue=1.0 Unit: meter
	private double engine_eng_max_contin_rating; // Max load. Main Engine MCR. maxValue=100000.0, minValue=5000.0. Unit: Kilowatt
	private double engine_eng_norm_contin_rating; // Normal load. Main Engine NCR. maxValue=100000.0, minValue=5000.0. Unit: Kilowattt
	private double engine_eng_nom_rpm_at_mcr; // RPM at Max Continous Rating, Main Engine MCR. maxValue=5000.0, minValue=50.0. Unit: RPM
	private double engine_eng_nom_rpm_at_ncr; // RPM Normal Continous Rating. maxValue=5000.0, minValue=50.0. Unit: RPM
	private double ship_ship_speed; // WRS Speed. Max speed = WRS speed. Unit: knots
	private double ship_ship_dwt; // Bulb. Unit: meter.
	private double ship_criteria_wind; // GW limit below. Wind below. 
	private double ship_min_load_speed; // Min loaded speed. Unit: knots
	private double ship_max_load_speed; // Max loaded speed. Unit: knots
	private double ship_min_ballast_speed; // Ballast=barlast. Min Barlast speed. Unit: knots
	private double ship_max_ballast_speed; // Max barlast speed. Unit: knots
	private double ship_min_medium_speed; // min medium speed. Unit: knots.
	private double ship_max_medium_speed; // max medium speed. Unit: knots
	private String ship_routingtype; // Default routing type for ship. Classic, Seaware or Undefined.
	private String ship_supported_onboardsystem; // If ship has supported onboardsystem by SMHI. true or false.
	private String ship_state; // Active/Archived. Value=0 -> Active. Value=1 -> Archived
	private String ship_comment; // Ship comment
	private String ship_description; // Shiptype description.
	private ArrayList<SatCPollPosition> satCPollPositions;


	public Ship(){
		id = 1;
		operator = new Operator(1);
		ship_ship_name = "undefined";
		contract_contract_id = "undefined";
		hull_hull_id = 0;
		engine_engine_id = 0;
		shiptype_shiptypename = "undefined";
		ship_ship_signs = "undefined";
		ship_employment = "undefined";
		hull_model_no = 0;
		hull_hull_len_oa = 0;
		hull_hull_len_pp = 0;
		hull_hull_beam = 0;
		hull_hull_front = 0;
		hull_hull_side = 0;
		hull_hull_factor = 0;
		ship_ship_nt = 0;
		ship_draft_design = 0;
		ship_draft_scantling = 0;
		engine_eng_max_contin_rating = 0;
		engine_eng_norm_contin_rating = 0;
		engine_eng_nom_rpm_at_mcr = 0;
		engine_eng_nom_rpm_at_ncr = 0;
		ship_ship_speed = 0;
		ship_ship_dwt = 0;
		ship_criteria_wind = 0;
		ship_min_load_speed = 0;
		ship_max_load_speed = 0;
		ship_min_ballast_speed = 0;
		ship_max_ballast_speed = 0;
		ship_min_medium_speed = 0;
		ship_max_medium_speed = 0;
		ship_routingtype = "undefined";
		ship_supported_onboardsystem = "undefined";
		ship_state = "undefined";
		ship_comment = "undefined";
		ship_description = "undefined";
		satCPollPositions = new ArrayList<SatCPollPosition>();
	}
	//This is temporary, only the interering values set.
	public Ship(int theId, Operator theOperator, String theShipname){
		id = theId;
		operator = theOperator;
		ship_ship_name = theShipname;
		contract_contract_id = "undefined";
		hull_hull_id = 0;
		engine_engine_id = 0;
		shiptype_shiptypename = "undefined";
		ship_ship_signs = "undefined";
		ship_employment = "undefined";
		hull_model_no = 0;
		hull_hull_len_oa = 0;
		hull_hull_len_pp = 0;
		hull_hull_beam = 0;
		hull_hull_front = 0;
		hull_hull_side = 0;
		hull_hull_factor = 0;
		ship_ship_nt = 0;
		ship_draft_design = 0;
		ship_draft_scantling = 0;
		engine_eng_max_contin_rating = 0;
		engine_eng_norm_contin_rating = 0;
		engine_eng_nom_rpm_at_mcr = 0;
		engine_eng_nom_rpm_at_ncr = 0;
		ship_ship_speed = 0;
		ship_ship_dwt = 0;
		ship_criteria_wind = 0;
		ship_min_load_speed = 0;
		ship_max_load_speed = 0;
		ship_min_ballast_speed = 0;
		ship_max_ballast_speed = 0;
		ship_min_medium_speed = 0;
		ship_max_medium_speed = 0;
		ship_routingtype = "undefined";
		ship_supported_onboardsystem = "undefined";
		ship_state = "undefined";
		ship_comment = "undefined";
		ship_description = "undefined";
		satCPollPositions = new ArrayList<SatCPollPosition>();
	}

	public Ship(int the_id,	Operator theOperator,
													String the_contract_contract_id,
													int the_hull_hull_id,
													int the_engine_engine_id,
													String the_ship_ship_name,
													String the_shiptype_shiptypename,
													String the_ship_ship_signs,
													String the_ship_employment,
													int the_hull_model_no,
													double the_hull_hull_len_oa,
													double the_hull_hull_len_pp,
													double the_hull_hull_beam,
													double the_hull_hull_front,
													double the_hull_hull_side,
													double the_hull_hull_factor,
													double the_ship_ship_nt,
													double the_ship_draft_design,
													double the_ship_draft_scantling,
													double the_engine_eng_max_contin_rating,
													double the_engine_eng_norm_contin_rating,
													double the_engine_eng_nom_rpm_at_mcr,
													double the_engine_eng_nom_rpm_at_ncr,
													double the_ship_ship_speed,
													double the_ship_ship_dwt,
													double the_ship_criteria_wind,
													double the_ship_min_load_speed,
													double the_ship_max_load_speed,
													double the_ship_min_ballast_speed,
													double the_ship_max_ballast_speed,
													double the_ship_min_medium_speed,
													double the_ship_max_medium_speed,
													String the_ship_routingtype,
													String the_ship_supported_onboardsystem,
													String the_ship_state,
													String the_ship_comment,
													String the_ship_desc){
		id = the_id;
		operator = theOperator;
		contract_contract_id = the_contract_contract_id;
		hull_hull_id = the_hull_hull_id;
		engine_engine_id = the_engine_engine_id;
		ship_ship_name = the_ship_ship_name;
		shiptype_shiptypename = the_shiptype_shiptypename;
		ship_ship_signs = the_ship_ship_signs;
		ship_employment = the_ship_employment;
		hull_model_no = the_hull_model_no;
		hull_hull_len_oa = the_hull_hull_len_oa;
		hull_hull_len_pp = the_hull_hull_len_pp;
		hull_hull_beam = the_hull_hull_beam;
		hull_hull_front = the_hull_hull_front;
		hull_hull_side = the_hull_hull_side;
		hull_hull_factor = the_hull_hull_factor;
		ship_ship_nt = the_ship_ship_nt;
		ship_draft_design = the_ship_draft_design;
		ship_draft_scantling = the_ship_draft_scantling;
		engine_eng_max_contin_rating = the_engine_eng_max_contin_rating;
		engine_eng_norm_contin_rating = the_engine_eng_norm_contin_rating;
		engine_eng_nom_rpm_at_mcr = the_engine_eng_nom_rpm_at_mcr;
		engine_eng_nom_rpm_at_ncr = the_engine_eng_nom_rpm_at_ncr;
		ship_ship_speed = the_ship_ship_speed;
		ship_ship_dwt = the_ship_ship_dwt;
		ship_criteria_wind = the_ship_criteria_wind;
		ship_min_load_speed = the_ship_min_load_speed;
		ship_max_load_speed = the_ship_max_load_speed;
		ship_min_ballast_speed = the_ship_min_ballast_speed;
		ship_max_ballast_speed = the_ship_max_ballast_speed;
		ship_min_medium_speed = the_ship_min_medium_speed;
		ship_max_medium_speed = the_ship_max_medium_speed;
		ship_routingtype = the_ship_routingtype;
		ship_supported_onboardsystem = the_ship_supported_onboardsystem;
		ship_state = the_ship_state;
		ship_comment = the_ship_comment;
		ship_description = the_ship_comment;
		satCPollPositions = new ArrayList<SatCPollPosition>();
	}
	public int getShipId(){
		return id;
	}
	public Operator getOperatorObject(){
		return 	operator;
	}
	public String getContractId(){
		return contract_contract_id;
	}
	public int getHullId(){
		return hull_hull_id;
	}
	public int getEngineId(){
		return engine_engine_id;
	}
	public String getShipName(){
		return ship_ship_name;
	}

	public String getShipTypeName(){
		return shiptype_shiptypename;
	}
	public String getShipSigns(){
		return ship_ship_signs;
	}
	public String getShipEmployment(){
		return ship_employment;
	}
	public int getHullModelNo(){
		return hull_model_no;
	}
	public double getHullLenOa(){
		return hull_hull_len_oa;
	}
	public double getHullLenPp(){
		return hull_hull_len_pp;
	}
	public double getHullBeam(){
		return hull_hull_beam;
	}
	public double getHullFront(){
		return hull_hull_front;
	}

	public double getHullSide(){
		return hull_hull_side;
	}
	public double getHullFactor(){
		return hull_hull_factor;
	}
	public double getShipNt(){
		return ship_ship_nt;
	}
	public double getDraftDesign(){
		return ship_draft_design;
	}
	public double getDraftScantling(){
		return ship_draft_scantling;
	}
	public double getEngineMaxContinRating(){
		return engine_eng_max_contin_rating;
	}
	public double getEngineNormContinRating(){
		return engine_eng_norm_contin_rating;
	}
	public double getEngineNomRpmAtMcr(){
		return engine_eng_nom_rpm_at_mcr;
	}
	public double getEngineNomRpmAtNcr(){
		return engine_eng_nom_rpm_at_ncr;	
	}
	public double getShipSpeed(){
		return ship_ship_speed;
	}
	public double getShipDwt(){
		return ship_ship_dwt;
	}
	public double getShipCriteriaWind(){
		return ship_criteria_wind;
	}

	public double getShipMinLoadSpeed(){
		return ship_min_load_speed;
	}
	public double getShipMaxLoadSpeed(){
		return ship_max_load_speed;
	}
	public double getShipMinBallastSpeed(){
		return ship_min_ballast_speed;
	}
	public double getShipMaxBallastSpeed(){
		return ship_max_ballast_speed;
	}
	public double getShipMinMediumSpeed(){
		return ship_min_medium_speed;
	}

	public double getShipMaxMediumSpeed(){
		return ship_max_medium_speed;
	}
	public String getShipRoutingType(){
		return ship_routingtype;
	}
	public String getShipSuppportedOnboardsystem(){
		return ship_supported_onboardsystem;
	}
	public String getShipState(){
		return ship_state;
	}
	public String getShipComment(){
		return ship_comment;
	}
	public String getShipDescription(){
		return ship_description;
	}
	public ArrayList<SatCPollPosition> getSatCPollPositions(){
		return satCPollPositions;
	}
	public void setPollPositions(ArrayList<SatCPollPosition> thePositions){
		satCPollPositions = thePositions;
	}
	
	public double getLat(){
		return lati;
	}

	public double getLon(){
		return longi;
	}

}