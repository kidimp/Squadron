public class Game {
    Player aiPlayer, humanPlayer;
    Grid gridAIPlayer, gridHumanPlayer;
    PlayerType playerTypeTurn;


    public void start() {
        gridAIPlayer = new Grid();
        gridHumanPlayer = new Grid();

        aiPlayer = new AIPlayer(gridAIPlayer);
        humanPlayer = new HumanPlayer(gridHumanPlayer);

        aiPlayer.shipPlacement();
        humanPlayer.shipPlacement();

        playerTypeTurn = PlayerType.HUMAN;
    }


    public void shot(int x, int y) {
        Grid grid = (playerTypeTurn == PlayerType.HUMAN) ? gridAIPlayer : gridHumanPlayer;
        if (!grid.isShotDuplicated(x, y)) {
            grid.makeShot(x, y);
            renderGrids();
            changeTurn();
        }
    }


    public void changeTurn() {
        if (playerTypeTurn == PlayerType.HUMAN) {
            playerTypeTurn = PlayerType.AI;
        } else {
            playerTypeTurn = PlayerType.HUMAN;
        }
    }


    public boolean isEndOfGame() {
        for (Ship ship : gridAIPlayer.ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }


    public void renderGrids() {
        if (playerTypeTurn == PlayerType.HUMAN) {
            System.out.println("AIPlayer grid");
            gridAIPlayer.render(false);
        } else {
            Menu.aiShootingProcedure();
            System.out.println("HumanPlayer grid");
            gridHumanPlayer.render(true);
        }
    }
}
