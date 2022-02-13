import java.io.IOException;

public class Squadron {
    public static void main(String[] args) throws IOException {

        Menu.initialMessage();

        Game game = new Game();
        game.start();

    }
}
