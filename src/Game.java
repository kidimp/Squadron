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
}
