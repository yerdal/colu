package ship;

public class Contract {

  private int contract_id;
  private String cp_speed;
  private String cp_hfo;
  private String cp_mdo;
  private String cp_load_speed;
  private String cp_load_cons_hfo;
  private String cp_load_cons_mdo;
  private String cp_medium_speed;
  private String cp_medium_cons_hfo;
  private String cp_medium_cons_mdo;
  private String cp_ballast_speed;
  private String cp_ballast_cons_hfo;
  private String cp_ballast_cons_mdo;
  private String allowance_hfo_mt;
  private String allowance_hfo_percent;
  private String allowance_cp_speed;
  private String gw_dss;
  private String pvamethod;
  private String routemethod;
  // contract_filtercriteria.filter_type
  // contract_filtercriteria.filter_name
  // contract_filtercriteria.dss_swell
  // contract_filtercriteria.dss_windwave
  // contract_filtercriteria.signwaveh
  // contract_filtercriteria.wind_uptoincl_bf
  // contract_filtercriteria.rpm_allowance
 





  public Contract(int theId,  String the_cp_speed,
                              String the_cp_hfo,
                              String the_cp_mdo,
                              String the_cp_load_speed,
                              String the_cp_load_cons_hfo,
                              String the_cp_load_cons_mdo,
                              String the_cp_medium_speed,
                              String the_cp_medium_cons_hfo,
                              String the_cp_medium_cons_mdo,
                              String the_cp_ballast_speed,
                              String the_cp_ballast_cons_hfo,
                              String the_cp_ballast_cons_mdo,
                              String the_allowance_hfo_mt,
                              String the_allowance_hfo_percent,
                              String the_allowance_cp_speed,
                              String the_gw_dss,
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