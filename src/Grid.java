import java.util.ArrayList;

public class Grid {

    static final int GRID_SIZE_X = 10;
    static final int GRID_SIZE_Y = 10;

    static final String EMPTY_CELL = "\u25fb";
    static final String DECK_UNDAMAGED = "\u25fc";
    static final String DECK_DAMAGED = "\u2716";
    static final String MISS_SHOT = "\u2611";

    ArrayList<Ship> ships = new ArrayList<>();

    ShotStatus shotStatus;


    String[][] grid =
//                   1           2           3           4           5           6           7           8           9           10
            {{EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},  //A
                    {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},  //B
                    {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},  //C
                    {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},  //D
                    {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},  //E
                    {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},  //F
                    {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},  //G
                    {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},  //H
                    {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},  //I
                    {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}}; //J


    void render(boolean isShowShips) {
        System.out.println("1  2  3  4  5  6  7  8  9  10");
        for (Ship ship : ships) {
            ship.shipRender(grid, isShowShips);
        }

        for (int y = 0; y < GRID_SIZE_Y; y++) {
            for (int x = 0; x < GRID_SIZE_X; x++) {
                System.out.print(grid[y][x] + "  ");
            }
            Menu.printLetterCoordinate(y);
        }
        System.out.println();
    }


    public void createShip(ShipType shipType, ShipOrientation shipOrientation, int x_ShipCoordinate, int y_ShipCoordinate) {
        Ship ship = new Ship(shipType, shipOrientation, x_ShipCoordinate, y_ShipCoordinate);
        ships.add(ship);
    }


    public boolean isPossibleToPlace(ShipType shipType, ShipOrientation shipOrientation, int x, int y) {
        int amountOfDecks = shipType.ordinal() + 1;
        if ((shipOrientation.equals(ShipOrientation.VERTICAL) && (y > Grid.GRID_SIZE_Y - amountOfDecks))
                || (shipOrientation.equals(ShipOrientation.HORIZONTAL) && (x > Grid.GRID_SIZE_X - amountOfDecks))) {
            return false;
        }

        for (int i = 0; i < amountOfDecks; i++) {
            int offsetX = i * ((shipOrientation == ShipOrientation.HORIZONTAL) ? 1 : 0),
                    offsetY = i * ((shipOrientation == ShipOrientation.VERTICAL) ? 1 : 0);
            for (Ship ship : ships) {
                if (!ship.checkUncrossing(x + offsetX, y + offsetY)) {
                    return false;
                }

            }
        }
        return true;
    }


    public void addShip(Ship ship) {
        ships.add(ship);
    }


    public void clearShips() {
        ships.clear();
    }


    public boolean isPossibleToShoot(int x, int y) {
        return (x >= 0 && x <= 9) && (y >= 0 && y <= 9);
    }


    public boolean isShotDuplicated(int x, int y) {
        return grid[y][x].equals(MISS_SHOT) || grid[y][x].equals(DECK_DAMAGED);
    }


    public void makeShot(int x, int y) {
        shotStatus = ShotStatus.MISSED;

        for (Ship ship : ships) {
            if (ship.isHit(x, y)) {
                shotStatus = ShotStatus.DAMAGED;
                if (ship.isSunk()) {
                    shotStatus = ShotStatus.SUNK;
                    ship.borderRender(grid);
                }
                break;
            }
        }

        if (shotStatus == ShotStatus.MISSED) {
            grid[y][x] = MISS_SHOT;
        }
    }


    public ShotStatus getShotStatus() {
        return shotStatus;
    }

}







