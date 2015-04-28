package ship;


/**
 * Class to represent contract
 */
public class Contract {
 
  private int contract_id; // Database ID for Contract
  private double cp_speed; // C/P speed. C/P??? Unit: knots
  private double cp_hfo; //C/P FO, TOTAL CONSUMPTION. HFO == Heavy Fuel Oil. Unit: Metric tonnes per day
  private double cp_mdo; // C/P DO, Total consumption, MDO == Marine Diesel Oil. Unit: Metric tonnes per day
  private double cp_load_speed; // C/P speed loaded. Unit: knots
  private double cp_load_cons_hfo; // Loaded HFO consumption SEA. Unit: Metric tonnes per day
  private double cp_load_cons_mdo; // Loaded MDO consumption SEA. Unit: Metric tonnes per day
  private double cp_medium_speed; // C/P speed medium. Unit: knots
  private double cp_medium_cons_hfo; // Medium HFO consumption SEA. Unit: Metric tonnes per day
  private double cp_medium_cons_mdo; // Medium MDO consumption SEA. Unit: Metric tonnes per day
  private double cp_ballast_speed; // C/P speed Ballast. Ballast == Barlast, dvs last för att öka fartygets stabilitet. Unit: knots 
  private double cp_ballast_cons_hfo; // C/P HFO Ballast consumption SEA. Unit: Metric tonnes per day
  private double cp_ballast_cons_mdo; // C/P MDO Ballast consumption SEA. Unit: Metric tonnes per day
  private double allowance_hfo_mt; // Allowance C/P HFO in metric tonnes. Unit: Metric tonnes
  private double allowance_hfo_percent; // Allowance C/P HFO in percent. Unit: Percent
  private double allowance_cp_speed; // Allowance C/P Speed. Unit: knots
  private double gw_dss; 
  //DSS for Good Weather calculations (sea below) DSS 2 = swell 2,0m windwave 0,5m, 
  //DSS 3 = swell 2,0m windwave 1,25m, DSS 4 = swell 4,0m windwave 2,5m, DSS 5 = swell 4,0m windwave 4,0m.
  // maxValue = 12.0, minValue = 0.0
  private String pvamethod; // PVA method for analysis. value=none, value=WNI, value=Furness, value=Legal, value=PVR
  private String routemethod; // Route Method. MANUAL, AUTO or UNKNOWN.
  // contract_filtercriteria.filter_type
  // contract_filtercriteria.filter_name
  // contract_filtercriteria.dss_swell
  // contract_filtercriteria.dss_windwave
  // contract_filtercriteria.signwaveh
  // contract_filtercriteria.wind_uptoincl_bf
  // contract_filtercriteria.rpm_allowance
 





  public Contract(int theId,  double the_cp_speed,
                              double the_cp_hfo,
                              double the_cp_mdo,
                              double the_cp_load_speed,
                              double the_cp_load_cons_hfo,
                              double the_cp_load_cons_mdo,
                              double the_cp_medium_speed,
                              double the_cp_medium_cons_hfo,
                              double the_cp_medium_cons_mdo,
                              double the_cp_ballast_speed,
                              double the_cp_ballast_cons_hfo,
                              double the_cp_ballast_cons_mdo,
                              double the_allowance_hfo_mt,
                              double the_allowance_hfo_percent,
                              double the_allowance_cp_speed,
                              double the_gw_dss,
                              String the_pvamethod,
                              String the_routemethod) {
    contract_id  = theId;
    cp_speed = cp_speed; 
    cp_hfo = cp_hfo; 
    cp_mdo = cp_mdo; 
    cp_load_speed = cp_load_speed; 
    cp_load_cons_hfo = cp_load_cons_hfo; 
    cp_load_cons_mdo = cp_load_cons_mdo; 
    cp_medium_speed = cp_medium_speed; 
    cp_medium_cons_hfo = cp_medium_cons_hfo; 
    cp_medium_cons_mdo = cp_medium_cons_mdo; 
    cp_ballast_speed = cp_ballast_speed; 
    cp_ballast_cons_hfo = cp_ballast_cons_hfo; 
    cp_ballast_cons_mdo = cp_ballast_cons_mdo; 
    allowance_hfo_mt = allowance_hfo_mt; 
    allowance_hfo_percent = allowance_hfo_percent; 
    allowance_cp_speed = allowance_cp_speed; 
    gw_dss = gw_dss; 
    pvamethod = pvamethod; 
    routemethod = routemethod; 
  }
  
    

}