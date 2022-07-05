import java.io.IOException;

public class Squadron {
    public static void main(String[] args) throws IOException {

        Menu.initialMessage();

        Game game = new Game();
        game.start();

        while (!game.isEndOfGame()) {
            int x, y;
            if (game.playerTypeTurn == PlayerType.HUMAN) {
                System.out.println("Take your shot.");
                x = Menu.getCoordX();
                y = Menu.getCoordY();
            } else {
                x = (int) (Math.random() * Grid.GRID_SIZE_X);
                y = (int) (Math.random() * Grid.GRID_SIZE_Y);
            }
            game.shot(x, y);
        }

        Menu.endOfTheGameMessage();

    }
}
