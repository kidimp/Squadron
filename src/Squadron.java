import java.io.IOException;

public class Squadron {
    public static void main(String[] args) throws IOException {

        Menu.initialMessage();

        Game game = new Game();
        game.start();

        while (game.isEndOfGame() == false){
            System.out.println("Take your shot.");
            int x = Menu.getCoordX();
            int y = Menu.getCoordY();
            game.shot(x, y);
        }


    }
}
