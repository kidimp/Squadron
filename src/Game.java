public class Game {
    Player aiPlayer, humanPlayer;
    Grid gridAIPlayer, gridHumanPlayer;

    public void start() {
        gridAIPlayer = new Grid();
        gridHumanPlayer = new Grid();

        aiPlayer = new AIPlayer(gridAIPlayer);
        humanPlayer = new HumanPlayer(gridHumanPlayer);

        aiPlayer.shipPlacement();
        humanPlayer.shipPlacement();
    }


    public void shot(int x, int y) {
        gridAIPlayer.makeShot(x, y);
        gridAIPlayer.render();
    }


    public boolean isEndOfGame() {
        for (Ship ship : gridAIPlayer.ships) {
            if (ship.isSunk() == false) {
                return false;
            }
        }
        return true;
    }

}
