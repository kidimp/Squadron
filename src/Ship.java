import java.util.ArrayList;

public class Ship {

    ArrayList<Deck> decks = new ArrayList<>();

    private ShipType shipType;
    ShipOrientation shipOrientation;
    int x_ShipCoordinate, y_ShipCoordinate;
    private boolean isSunk = false;

    public Ship() {
    }

    public Ship(ShipType shipType, ShipOrientation shipOrientation, int x_ShipCoordinate, int y_ShipCoordinate) {
        this.shipType = shipType;
        this.shipOrientation = shipOrientation;
        this.x_ShipCoordinate = x_ShipCoordinate;
        this.y_ShipCoordinate = y_ShipCoordinate;
        addDecks();
    }

    public void shipRender(String[][] grid) {
        for (Deck deck : decks) {
            grid[deck.y_DeckCoordinate][deck.x_DeckCoordinate] = Grid.DECK_UNDAMAGED;
        }
    }

    public void addDecks() {
        for (int i = 0; i <= shipType.ordinal(); i++) {
            int offsetX = i * ((shipOrientation == ShipOrientation.HORIZONTAL) ? 0 : 1),
                offsetY = i * ((shipOrientation == ShipOrientation.VERTICAL) ? 0 : 1);
            decks.add(new Deck(x_ShipCoordinate +offsetX, y_ShipCoordinate +offsetY));
        }
        //Deck deck = new Deck(x_ShipCoordinate, y_ShipCoordinate);
    }



//    public static Ship createShip(ShipType shipType, ShipOrientation shipOrientation, int x_ShipCoordinate, int y_ShipCoordinate) {
//
//        if (shipType == ShipType.SINGLEDECKER) {
//            decks.add(new Deck(x_ShipCoordinate, y_ShipCoordinate));
//            return new Ship(ShipType.SINGLEDECKER, ShipOrientation.VERTICAL, x_ShipCoordinate, y_ShipCoordinate);
//        }
//
//        if (shipType == ShipType.TWODECKER) {
//            if (shipOrientation == ShipOrientation.HORIZONTAL) {
//                for (int i = 0; i < 2; i++) {
//                    decks.add(new Deck(x_ShipCoordinate, y_ShipCoordinate);
//                }
//                return new Ship(ShipType.TWODECKER, ShipOrientation.HORIZONTAL, x_ShipCoordinate, y_ShipCoordinate);
//            } else {
//                Deck deck0 = new Deck(x_ShipCoordinate, y_ShipCoordinate);
//                Deck deck1 = new Deck(x_ShipCoordinate, y_ShipCoordinate + 1);
//                decks.add(deck0);
//                decks.add(deck1);
//                return new Ship(ShipType.TWODECKER, ShipOrientation.VERTICAL, x_ShipCoordinate, y_ShipCoordinate);
//            }
//        }

//        if (shipType == ShipType.THREEDECKER) {
//            if (shipOrientation == ShipOrientation.HORIZONTAL) {
//                return new Ship(ShipType.THREEDECKER, ShipOrientation.HORIZONTAL, x_ShipCoordinate, y_ShipCoordinate);
//            } else {
//                return new Ship(ShipType.THREEDECKER, ShipOrientation.VERTICAL, x_ShipCoordinate, y_ShipCoordinate);
//            }
//        }
//
//        if (shipType == ShipType.FOURDECKER) {
//            if (shipOrientation == ShipOrientation.HORIZONTAL) {
//                return new Ship(ShipType.FOURDECKER, ShipOrientation.HORIZONTAL, x_ShipCoordinate, y_ShipCoordinate);
//            } else {
//                return new Ship(ShipType.FOURDECKER, ShipOrientation.VERTICAL, x_ShipCoordinate, y_ShipCoordinate);
//            }
//        }
//
//        return null;
//    }


//    public ShipType getShipType() {
//        return shipType;
//    }
//
//    public void setShipType(ShipType shipType) {
//        this.shipType = shipType;
//    }
//
//    public ShipOrientation getShipOrientation() {
//        return shipOrientation;
//    }
//
//    public void setShipOrientation(ShipOrientation shipOrientation) {
//        this.shipOrientation = shipOrientation;
//    }
//
    public int getX_ShipCoordinate() {
        return x_ShipCoordinate;
    }

//    public void setX_ShipCoordinate(int x_ShipCoordinate) {
//        this.x_ShipCoordinate = x_ShipCoordinate;
//    }

    public int getY_ShipCoordinate() {
        return y_ShipCoordinate;
    }

//    public void setY_ShipCoordinate(int y_ShipCoordinate) {
//        this.y_ShipCoordinate = y_ShipCoordinate;
//    }
//
//    public boolean isSunk() {
//        return isSunk;
//    }
//
//    public void setSunk(boolean sunk) {
//        isSunk = sunk;
//    }
}