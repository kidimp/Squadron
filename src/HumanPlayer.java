import java.io.IOException;
import java.util.ArrayList;

public class HumanPlayer extends Player {

    public HumanPlayer(Grid grid) {
        super(grid);
    }


    public void shipPlacement() {
        switch (Menu.getPlacingMethod()) {
            case (Menu.MANUAL_PLACING_METHOD) -> {
                allShipPlacementManually();
            }
            case (Menu.AUTO_PLACING_METHOD) -> {
                allShipPlacementGeneration();
                grid.render(true);
            }
        }
    }


    public void shipPlacement(ShipType shipType) throws IOException {
        int humanChoiceX, humanChoiceY;
        ShipOrientation shipOrientation;

        do {
            int humanChoiceOrientation = 0;

            if (shipType != ShipType.SINGLEDECKER) {
                humanChoiceOrientation = Menu.getOrientation();
            }

            humanChoiceX = Menu.getCoordX();
            humanChoiceY = Menu.getCoordY();

            shipOrientation = (humanChoiceOrientation == Menu.VERTICAL_SHIP_ORIENTATION) ? ShipOrientation.VERTICAL : ShipOrientation.HORIZONTAL;

        } while (!grid.isPossibleToPlace(shipType, shipOrientation, humanChoiceX, humanChoiceY));

        grid.createShip(shipType, shipOrientation, humanChoiceX, humanChoiceY);
    }


    public void allShipPlacementManually() {
        Menu.placingRulesMessage();
        ArrayList<ShipType> allShipsWithTypes = new ArrayList<>();
        allShipsWithTypes.add(ShipType.FOURDECKER);
        allShipsWithTypes.add(ShipType.THREEDECKER);
        allShipsWithTypes.add(ShipType.THREEDECKER);
        allShipsWithTypes.add(ShipType.TWODECKER);
        allShipsWithTypes.add(ShipType.TWODECKER);
        allShipsWithTypes.add(ShipType.TWODECKER);
        allShipsWithTypes.add(ShipType.SINGLEDECKER);
        allShipsWithTypes.add(ShipType.SINGLEDECKER);
        allShipsWithTypes.add(ShipType.SINGLEDECKER);
        allShipsWithTypes.add(ShipType.SINGLEDECKER);

        try {
            for (ShipType shipWithType : allShipsWithTypes) {
                shipPlacement(shipWithType);
                grid.render(true);
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

}
