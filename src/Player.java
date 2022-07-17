import java.io.IOException;
import java.util.Random;

public abstract class Player {
    protected Grid grid;

    protected Player opponentPlayer;


    public Player(Grid grid){
        this.grid = grid;
    }


    public abstract void shipPlacement();


    public abstract int[] getShotCoordinates() throws IOException;


    public void allShipPlacementGeneration() {
        shipSetting(ShipType.FOURDECKER);
        shipSetting(ShipType.THREEDECKER);
        shipSetting(ShipType.THREEDECKER);
        shipSetting(ShipType.TWODECKER);
        shipSetting(ShipType.TWODECKER);
        shipSetting(ShipType.TWODECKER);
        shipSetting(ShipType.SINGLEDECKER);
        shipSetting(ShipType.SINGLEDECKER);
        shipSetting(ShipType.SINGLEDECKER);
        shipSetting(ShipType.SINGLEDECKER);
    }


    public void shipSetting(ShipType shipType) {
        int counterOfAttemptsToSetShip = 0;
        ShipOrientation shipOrientation;
        int x, y;

        do {
            x = getRandomStartCell(Grid.GRID_SIZE_X);
            y = getRandomStartCell(Grid.GRID_SIZE_Y);
            shipOrientation = getRandomOrientation();

            counterOfAttemptsToSetShip++;
            final int MAX_AMOUNT_OF_ITERATIONS = 50;
            if (counterOfAttemptsToSetShip == MAX_AMOUNT_OF_ITERATIONS) {
                shipPlacementReset();
                return;
            }
        } while (!grid.isPossibleToPlace(shipType, shipOrientation, x, y));

        Ship ship = new Ship(shipType, shipOrientation, x, y);
        grid.addShip(ship);
    }


    public ShipOrientation getRandomOrientation() {
        Random orientation = new Random();
        if (orientation.nextBoolean()) {
            return ShipOrientation.VERTICAL;
        } else {
            return ShipOrientation.HORIZONTAL;
        }
    }


    public int getRandomStartCell(int size) {
        return ((int) (Math.random() * size));
    }


    public void shipPlacementReset() {
        grid.clearShips();
        allShipPlacementGeneration();
    }

}
