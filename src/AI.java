import java.util.ArrayList;
import java.util.Random;

public class AI {

    final int MAX_AMOUNT_OF_ITERATIONS = 50;

    ArrayList<Ship> shipsAI = new ArrayList<>();

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

    public void shipSettingAI(ShipType shipType) {
        int counterOfFails = 0;
        ShipOrientation shipOrientation = null;
        int x = 0;
        int y = 0;

        do {
            x = getRandomStartCell(Grid.GRID_SIZE_X);
            y = getRandomStartCell(Grid.GRID_SIZE_Y);
            shipOrientation = getRandomOrientation();

            counterOfFails++;
            if (counterOfFails == MAX_AMOUNT_OF_ITERATIONS) {
                shipPlacementReset();
                return;
            }
        } while (!isPossibleToSet(shipType, shipOrientation, x, y));

        Ship ship = new Ship(shipType, shipOrientation, x, y);
        shipsAI.add(ship);
    }

    public boolean isPossibleToSet(ShipType shipType, ShipOrientation shipOrientation, int x, int y) {
        int amountOfDecks = shipType.ordinal() + 1;
        if ((shipOrientation.equals(ShipOrientation.VERTICAL) && (y > Grid.GRID_SIZE_Y - amountOfDecks))
                || (shipOrientation.equals(ShipOrientation.HORIZONTAL) && (x > Grid.GRID_SIZE_X - amountOfDecks))) {
            return false;
        }

        for (int i = 0; i < amountOfDecks; i++) {
            int offsetX = i * ((shipOrientation == ShipOrientation.HORIZONTAL) ? 1 : 0),
                    offsetY = i * ((shipOrientation == ShipOrientation.VERTICAL) ? 1 : 0);
            for (Ship ship : shipsAI) {
                if (ship.checkUncrossing(x + offsetX, y + offsetY) == false) {
                    return false;
                }

            }
        }
        return true;
    }

    public void shipPlacementGeneration() {
        shipSettingAI(ShipType.FOURDECKER);
        shipSettingAI(ShipType.THREEDECKER);
        shipSettingAI(ShipType.THREEDECKER);
        shipSettingAI(ShipType.TWODECKER);
        shipSettingAI(ShipType.TWODECKER);
        shipSettingAI(ShipType.TWODECKER);
        shipSettingAI(ShipType.SINGLEDECKER);
        shipSettingAI(ShipType.SINGLEDECKER);
        shipSettingAI(ShipType.SINGLEDECKER);
        shipSettingAI(ShipType.SINGLEDECKER);
    }

    public void shipPlacementReset() {
        shipsAI.clear();
        shipPlacementGeneration();
    }

}
