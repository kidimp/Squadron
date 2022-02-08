import java.util.ArrayList;
import java.util.Random;

public class AI {

    ArrayList<Ship> shipsAI = new ArrayList<>();

    public boolean getRandomOrientation() {
        Random orientation = new Random();
        return orientation.nextBoolean();
    }

    public int[] getRandomStartCell() {
        int rangeX = Grid.GRID_SIZE_X;
        int rangeY = Grid.GRID_SIZE_Y;
        int x = (int) (Math.random() * rangeX);
        int y = (int) (Math.random() * rangeY);
        return new int[]{x, y};
    }

    public Ship shipSettingAI(ShipType shipType, ShipOrientation shipOrientation, int x_ShipCoordinate, int y_ShipCoordinate) {
        boolean isVertical = getRandomOrientation();
        int x;
        int y;
        Ship ship = new Ship(shipType, shipOrientation, x_ShipCoordinate, y_ShipCoordinate);
        shipsAI.add(ship);
        return ship;
    }

    // public void isPossibleToSet() {}

}
