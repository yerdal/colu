package ship;

public class Ship {

	private int id;
	//Static for now
	private double lati = 30.587745;
	private double longi = 16.192421;	
	private String name;

	//According to the XML file 	
	private Operator operator;
	private String contract_contract_id;
	private String hull_hull_id;
	private String engine_engine_id;
	private String ship_ship_name;
	private String shiptype_shiptypename;
	private String ship_ship_signs;
	private String ship_employment;
	private String hull_model_no;
	private String hull_hull_len_oa;
	private String hull_hull_len_pp;
	private String hull_hull_beam;
	private String hull_hull_front;
	private String hull_hull_side;
	private String hull_hull_factor;
	private String ship_ship_nt;
	private String ship_draft_design;
	private String ship_draft_scantling;
	private String engine_eng_max_contin_rating;
	private String engine_eng_norm_contin_rating;
	private String engine_eng_nom_rpm_at_mcr;
	private String engine_eng_nom_rpm_at_ncr;
	private String ship_ship_speed;
	private String ship_ship_dwt;
	private String ship_criteria_wind;
	private String ship_min_load_speed;
	private String ship_max_load_speed;
	private String ship_min_ballast_speed;
	private String ship_max_ballast_speed;
	private String ship_min_medium_speed;
	private String ship_max_medium_speed;
	private String ship_routingtype;
	private String ship_supported_onboardsystem;
	private String ship_state;

	private String ship_comment;
	private String ship_description;

	public Ship(int the_id,	Operator theOperator,
													String the_contract_contract_id,
													String the_hull_hull_id,
													String the_engine_engine_id,
													String the_ship_ship_name,
													String the_shiptype_shiptypename,
													String the_ship_ship_signs,
													String the_ship_employment,
													String the_hull_model_no,
													String the_hull_hull_len_oa,
													String the_hull_hull_len_pp,
													String the_hull_hull_beam,
													String the_hull_hull_front,
													String the_hull_hull_side,
													String the_hull_hull_factor,
													String the_ship_ship_nt,
													String the_ship_draft_design,
													String the_ship_draft_scantling,
													String the_engine_eng_max_contin_rating,
													String the_engine_eng_norm_contin_rating,
													String the_engine_eng_nom_rpm_at_mcr,
													String the_engine_eng_nom_rpm_at_ncr,
													String the_ship_ship_speed,
													String the_ship_ship_dwt,
													String the_ship_criteria_wind,
													String the_ship_min_load_speed,
													String the_ship_max_load_speed,
													String the_ship_min_ballast_speed,
													String the_ship_max_ballast_speed,
													String the_ship_min_medium_speed,
													String the_ship_max_medium_speed,
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
	}

	public Operator getOperatorObject(){
		return 	operator;
	}
	public String getContractId(){
		return contract_contract_id;
	}
	public String getHullId(){
		return hull_hull_id;
	}
	public String getEngineId(){
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
	public String getHullModelNo(){
		return hull_model_no;
	}
	public String getHullLenOa(){
		return hull_hull_len_oa;
	}
	public String getHullLenPp(){
		return hull_hull_len_pp;
	}
	public String getHullBeam(){
		return hull_hull_beam;
	}
	public String getHullFront(){
		return hull_hull_front;
	}

	public String getHullSide(){
		return hull_hull_side;
	}
	public String getHullFactor(){
		return hull_hull_factor;
	}
	public String getShipNt(){
		return ship_ship_nt;
	}
	public String getDraftDesign(){
		return ship_draft_design;
	}
	public String getDraftScantling(){
		return ship_draft_scantling;
	}
	public String getEngineMaxContinRating(){
		return engine_eng_max_contin_rating;
	}
	public String getEngineNormContinRating(){
		return engine_eng_norm_contin_rating;
	}
	public String getEngineNomRpmAtMcr(){
		return engine_eng_nom_rpm_at_mcr;
	}
	public String getEngineNomRpmAtNcr(){
		return engine_eng_nom_rpm_at_ncr;	
	}
	public String getShipSpeed(){
		return ship_ship_speed;
	}
	public String getShipDwt(){
		return ship_ship_dwt;
	}
	public String getShipCriteriaWind(){
		return ship_criteria_wind;
	}

	public String getShipMinLoadSpeed(){
		return ship_min_load_speed;
	}
	public String getShipMaxLoadSpeed(){
		return ship_max_load_speed;
	}
	public String getShipMinBallastSpeed(){
		return ship_min_ballast_speed;
	}
	public String getShipMaxBallastSpeed(){
		return ship_max_ballast_speed;
	}
	public String getShipMinMediumSpeed(){
		return ship_min_medium_speed;
	}

	public String getShipMaxMediumSpeed(){
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
	// // For now, this is a "didn't find" ship
	// public String getName(){
	// 	return name;
	// }

	// public int getId(){
	// 	return id;
	// }

	// public void setLati(double d){
	// 	lati = d;
	// }
	
	// public void setLongi(double d){
	// 	longi = d;
	// }

	public double getLat(){
		return lati;
	}

	public double getLon(){
		return longi;
	}

}