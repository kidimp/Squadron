public class Deck {

    int x_DeckCoordinate, y_DeckCoordinate;
    boolean isDamaged = false;

    public Deck(int x_DeckCoordinate, int y_DeckCoordinate) {
        this.x_DeckCoordinate = x_DeckCoordinate;
        this.y_DeckCoordinate = y_DeckCoordinate;
    }

    public int getX_DeckCoordinate() {
        return x_DeckCoordinate;
    }

    public void setX_DeckCoordinate(int x_DeckCoordinate) {
        this.x_DeckCoordinate = x_DeckCoordinate;
    }

    public int getY_DeckCoordinate() {
        return y_DeckCoordinate;
    }

    public void setY_DeckCoordinate(int y_DeckCoordinate) {
        this.y_DeckCoordinate = y_DeckCoordinate;
    }
}
