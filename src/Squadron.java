import java.io.IOException;

public class Squadron {
    public static void main(String[] args) throws IOException {

        Menu.initialMessage();

        Game game = new Game();
        game.start();

        while (!game.isEndOfGame()) {
            Player currentPlayer = (game.playerTypeTurn == PlayerType.HUMAN) ? game.humanPlayer : game.aiPlayer;

            int[] currentPlayerShotCoordinates = currentPlayer.getShotCoordinates();
            int x = currentPlayerShotCoordinates[0];
            int y = currentPlayerShotCoordinates[1];

            game.shot(x, y);
        }

        Menu.endOfTheGameMessage();
    }
}
