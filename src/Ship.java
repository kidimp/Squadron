import java.util.ArrayList;

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

        int[] coordX = {-1, 0, 1, -1, 1, -1, 0, 1};
        int[] coordY = {-1, -1, -1, 0, 0, 1, 1, 1};

        for (Deck deck : decks) {
            for (int i = 0; i < 8; i++) {
                int x_BorderCoordinate = deck.getX_DeckCoordinate() + coordX[i];
                int y_BorderCoordinate = deck.getY_DeckCoordinate() + coordY[i];
                boolean crossingBorderDeck = false;
                boolean crossingBorderBorder = false;

                for (Deck deckCheck : decks) {
                    if (((deckCheck.getX_DeckCoordinate() == x_BorderCoordinate) && (deckCheck.getY_DeckCoordinate() == y_BorderCoordinate))) {
                        crossingBorderBorder = true;
                        break;
                    }
                }

                for (Border borderCheck : borders) {
                    if (((borderCheck.getX_BorderCoordinate() == x_BorderCoordinate) && (borderCheck.getY_BorderCoordinate() == y_BorderCoordinate))) {
                        crossingBorderDeck = true;
                        break;
                    }
                }

                if ((crossingBorderDeck == false) && (crossingBorderBorder == false)) {
                    if ((x_BorderCoordinate >= 0) && (y_BorderCoordinate >= 0) && (x_BorderCoordinate < Grid.GRID_SIZE_X) && (y_BorderCoordinate < Grid.GRID_SIZE_Y)) {
                        borders.add(new Border(x_BorderCoordinate, y_BorderCoordinate));
                    }
                }
            }
        }
    }



}