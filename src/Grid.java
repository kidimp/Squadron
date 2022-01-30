import java.util.ArrayList;

public class Grid {

    static final int GRID_SIZE_Y = 10;
    static final int GRID_SIZE_X = 10;

    static final String EMPTY_CELL = "\u25fb";
    static final String DECK_UNDAMAGED = "\u25fc";
    static final String DECK_DAMAGED = "\u2716";
    static final String MISS_SHOT = "\u2611";

    ArrayList<Ship> ships = new ArrayList<>();

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

    void render() {
        for (Ship ship : ships) {
            ship.shipRender(grid);
            //grid[ship.getY_ShipCoordinate()][ship.getX_ShipCoordinate()] = DECK_UNDAMAGED;
        }
        for (int y = 0; y < GRID_SIZE_Y; y++) {
            for (int x = 0; x < GRID_SIZE_X; x++) {
                System.out.print(grid[y][x] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

        public Ship createShip(ShipType shipType, ShipOrientation shipOrientation, int x_ShipCoordinate, int y_ShipCoordinate) {

            Ship ship = new Ship(shipType, shipOrientation, x_ShipCoordinate, y_ShipCoordinate);
            ships.add(ship);
            return ship;

        }

}






