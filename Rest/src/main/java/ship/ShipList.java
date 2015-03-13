package ship;

import java.util.ArrayList;
import java.util.List;

public class ShipList {

	private ArrayList<Ship> ships;




	public ShipList(){

		ships = new ArrayList();
	}

	public ArrayList<Ship> getShips(){
		return ships;
	}

	public void setShips(ArrayList<Ship> s){
		ships = s;
	}

	public void addShip(Ship s){
		ships.add(s);
	}

	public Ship getShip(int i){
		return ships.get(i);
	 }

	public Ship findShip(String s){

		for(int i = 0; i < ships.size(); i++){

			if(ships.get(i).getName().equals(s))
				return ships.get(i);
		}	

		return new Ship(-1);
	}


}