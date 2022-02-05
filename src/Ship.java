import java.util.ArrayList;
import java.util.Collections;

public class Ship {

    ArrayList<Deck> decks = new ArrayList<>();
    ArrayList<Border> borders = new ArrayList<>();

    private ShipType shipType;
    ShipOrientation shipOrientation;
    int x_ShipCoordinate, y_ShipCoordinate;
//    private boolean isSunk = false;

//    public Ship() {
//    }

    public Ship(ShipType shipType, ShipOrientation shipOrientation, int x_ShipCoordinate, int y_ShipCoordinate) {
        this.shipType = shipType;
        this.shipOrientation = shipOrientation;
        this.x_ShipCoordinate = x_ShipCoordinate;
        this.y_ShipCoordinate = y_ShipCoordinate;
        addDecks();
        addBorders();
    }

    public void shipRender(String[][] grid) {
        for (Deck deck : decks) {
            grid[deck.y_DeckCoordinate][deck.x_DeckCoordinate] = Grid.DECK_UNDAMAGED;
        }
    }

    public void borderRender(String[][] grid) {
        for (Border border : borders) {
            grid[border.y_BorderCoordinate][border.x_BorderCoordinate] = Grid.MISS_SHOT;
        }
    }

    public void addDecks() {
        for (int i = 0; i <= shipType.ordinal(); i++) {
            int offsetX = i * ((shipOrientation == ShipOrientation.HORIZONTAL) ? 1 : 0),
                    offsetY = i * ((shipOrientation == ShipOrientation.VERTICAL) ? 1 : 0);
            decks.add(new Deck(x_ShipCoordinate + offsetX, y_ShipCoordinate + offsetY));
        }
    }

    public void addBorders() {

        for (Deck deck : decks) {
            int x = deck.getX_DeckCoordinate();
            int y = deck.getY_DeckCoordinate();

            if ((x == 0) && (y == 0)) {
                borders.add(new Border(x + 1, y + 0));
                borders.add(new Border(x + 1, y + 1));
                borders.add(new Border(x + 0, y + 1));
            }
            if ((x == Grid.GRID_SIZE_X - 1) && (y == 0)) {
                borders.add(new Border(x - 1, y + 0));
                borders.add(new Border(x - 1, y + 1));
                borders.add(new Border(x + 0, y + 1));
            }
            if ((x == Grid.GRID_SIZE_X - 1) && (y == Grid.GRID_SIZE_Y - 1)) {
                borders.add(new Border(x - 1, y + 0));
                borders.add(new Border(x - 1, y - 1));
                borders.add(new Border(x + 0, y - 1));
            }
            if ((x == 0) && (y == Grid.GRID_SIZE_Y - 1)) {
                borders.add(new Border(x + 0, y - 1));
                borders.add(new Border(x + 1, y - 1));
                borders.add(new Border(x + 1, y + 0));
            }
            if ((x >= 1) && (x <= Grid.GRID_SIZE_X - 2) && (y == 0)) {
                borders.add(new Border(x - 1, y + 0));
                borders.add(new Border(x - 1, y + 1));
                borders.add(new Border(x + 0, y + 1));
                borders.add(new Border(x + 1, y + 1));
                borders.add(new Border(x + 1, y + 0));
            }
            if ((x == Grid.GRID_SIZE_X - 1) && (y <= Grid.GRID_SIZE_Y - 2) && (y >= 1)) {
                borders.add(new Border(x + 0, y - 1));
                borders.add(new Border(x - 1, y - 1));
                borders.add(new Border(x - 1, y + 0));
                borders.add(new Border(x - 1, y + 1));
                borders.add(new Border(x + 0, y + 1));
            }
            if ((x >= 1) && (x <= Grid.GRID_SIZE_X - 2) && (y == Grid.GRID_SIZE_Y - 1)) {
                borders.add(new Border(x - 1, y + 0));
                borders.add(new Border(x - 1, y + 1));
                borders.add(new Border(x + 0, y + 1));
                borders.add(new Border(x + 1, y + 1));
                borders.add(new Border(x + 1, y + 0));
            }
            if ((x == 0) && (y <= Grid.GRID_SIZE_Y - 2) && (y >= 1)) {
                borders.add(new Border(x + 0, y - 1));
                borders.add(new Border(x + 1, y - 1));
                borders.add(new Border(x + 1, y + 0));
                borders.add(new Border(x + 1, y + 1));
                borders.add(new Border(x + 0, y + 1));
            }
            if ((x >= 1) && (x <= Grid.GRID_SIZE_X - 2) && (y <= Grid.GRID_SIZE_Y - 2) && (y >= 1)) {
                borders.add(new Border(x - 1, y - 1));
                borders.add(new Border(x + 0, y - 1));
                borders.add(new Border(x + 1, y - 1));
                borders.add(new Border(x - 1, y + 0));
                borders.add(new Border(x + 1, y + 0));
                borders.add(new Border(x - 1, y + 1));
                borders.add(new Border(x + 0, y + 1));
                borders.add(new Border(x + 1, y + 1));
            }
        }

        for (int i = 0; i < borders.size(); i++) {
            for (Deck deck : decks){
                if ((borders.get(i).getX_BorderCoordinate() == deck.getX_DeckCoordinate()) &&
                        (borders.get(i).getY_BorderCoordinate() == deck.getY_DeckCoordinate())) {
                    borders.remove(i--);
                    break;
                }
            }
        }
    }

}