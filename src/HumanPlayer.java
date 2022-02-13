import java.io.IOException;

public class HumanPlayer extends Player {

    public HumanPlayer(Grid grid) {
        super(grid);
    }


    public void shipPlacement() {
        switch (Menu.getPlacingMethod()) {
            case (Menu.MANUAL_PLACING_METHOD) -> {
                allShipPlacementManually();
                grid.render();
            }
            case (Menu.AUTO_PLACING_METHOD) -> {
                allShipPlacementGeneration();
                grid.render();
            }
        }
    }


    public void shipPlacement(ShipType shipType) throws IOException {
        int humanChoiceOrientation = 0;

        if (shipType != ShipType.SINGLEDECKER) {
            humanChoiceOrientation = Menu.getOrientation();
        }

        int humanChoiceX = Menu.getCoordX();
        int humanChoiceY = Menu.getCoordY();

        switch (humanChoiceOrientation) {
            case (Menu.VERTICAL_SHIP_ORIENTATION) -> grid.createShip(shipType, ShipOrientation.VERTICAL, humanChoiceX, humanChoiceY);
            case (Menu.HORIZONTAL_SHIP_ORIENTATION) -> grid.createShip(shipType, ShipOrientation.HORIZONTAL, humanChoiceX, humanChoiceY);
        }
    }


    public void allShipPlacementManually() {
        Menu.placingRulesMessage();
        try {
            System.out.println("Place one FOURDECKER.");
            shipPlacement(ShipType.FOURDECKER);
            System.out.println("Place two THREEDECKERs.");
            shipPlacement(ShipType.THREEDECKER);
            shipPlacement(ShipType.THREEDECKER);
            System.out.println("Place three TWODECKERs.");
            shipPlacement(ShipType.TWODECKER);
            shipPlacement(ShipType.TWODECKER);
            shipPlacement(ShipType.TWODECKER);
            System.out.println("Place four SINGLEDECKERs.");
            shipPlacement(ShipType.SINGLEDECKER);
            shipPlacement(ShipType.SINGLEDECKER);
            shipPlacement(ShipType.SINGLEDECKER);
            shipPlacement(ShipType.SINGLEDECKER);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
