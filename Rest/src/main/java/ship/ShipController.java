package ship;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipController {


    @RequestMapping(value="/skepp/{name}")

    public Ship getShip(@PathVariable String name) {

    	ShipList ships = new ShipList();

    	ships.addShip(new Ship(1, "Jonken1"));
    	ships.addShip(new Ship(2, "Jonken2"));
    	ships.addShip(new Ship(3, "Henki"));

        return ships.findShip(name);
    }
}