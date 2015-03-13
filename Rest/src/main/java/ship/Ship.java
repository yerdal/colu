package ship;

public class Ship {

	private int id = 3;
	private double lati = 30.587745;
	private double longi = 16.192421;	
	private String name = "Baten";

	public Ship(int i, String s){
		name = s;
		id = i;
	}

	public Ship(int i){
		name = "Not found";
		id = i;
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