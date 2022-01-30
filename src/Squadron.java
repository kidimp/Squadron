import java.util.ArrayList;

public class Squadron {
    public static void main(String[] args) {


        Menu.message();

        Grid grid = new Grid();
        grid.render();

        grid.createShip(ShipType.SINGLEDECKER, ShipOrientation.VERTICAL, 1, 1);
        grid.render();

        grid.createShip(ShipType.TWODECKER, ShipOrientation.HORIZONTAL, 3, 1);
        grid.render();

//        Ship twodecker0 = Ship.createShip(ShipType.TWODECKER, ShipOrientation.HORIZONTAL, 3, 1);
//        Ship.createShip(ShipType.TWODECKER, ShipOrientation.VERTICAL, 6, 1);
//
//        Ship.createShip(ShipType.THREEDECKER, ShipOrientation.HORIZONTAL, 1, 3);
//        Ship.createShip(ShipType.THREEDECKER, ShipOrientation.VERTICAL, 8, 1);
//
//        Ship.createShip(ShipType.FOURDECKER, ShipOrientation.HORIZONTAL, 0, 5);
//        Ship.createShip(ShipType.FOURDECKER, ShipOrientation.VERTICAL, 7, 6);

        //Grid.render(ships);

    }
}
