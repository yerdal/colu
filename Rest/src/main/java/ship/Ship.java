package ship;

public class Ship {

	private int id;
	//Static for now
	private double lati = 30.587745;
	private double longi = 16.192421;	
	private String name;;

	public Ship(int i, String s){
		id = i;
		name = s;
	}

	// For now, this is a "didn't find" ship
	public Ship(int i){
		id = i;
		name = "Not found";	
	}

	public void setName(String s){
		name = s;
	}

	public String getName(){
		return name;
	}

	public int getId(){
		return id;
	}

	public void setLati(double d){
		lati = d;
	}
	
	public void setLongi(double d){
		longi = d;
	}

	public double getLati(){
		return lati;
	}

	public double getLongi(){
		return longi;
	}

}