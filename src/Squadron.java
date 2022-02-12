import java.io.IOException;
import java.util.ArrayList;

public class Squadron {
    public static void main(String[] args) throws IOException {

        Menu.message();

        Grid grid = new Grid();
        Grid gridAI = new Grid();

//        grid.createShip(ShipType.SINGLEDECKER, ShipOrientation.VERTICAL, 0, 0);

//        grid.createShip(ShipType.TWODECKER, ShipOrientation.VERTICAL, 3, 1);
//        grid.createShip(ShipType.TWODECKER, ShipOrientation.HORIZONTAL, 5, 1);
//
//        grid.createShip(ShipType.THREEDECKER, ShipOrientation.VERTICAL, 1, 3);
//        grid.createShip(ShipType.THREEDECKER, ShipOrientation.HORIZONTAL, 3, 4);
//
//        grid.createShip(ShipType.FOURDECKER, ShipOrientation.VERTICAL, 8, 3);
//        grid.createShip(ShipType.FOURDECKER, ShipOrientation.HORIZONTAL, 3, 8);

//        grid.render();

        AI ai = new AI();
        ai.shipPlacementGeneration();

        for (int i = 0; i < ai.shipsAI.size(); i++) {
            gridAI.addShip(ai.shipsAI.get(i));
        }

//        gridAI.render();


    }
}
