public class Game {
    Player aiPlayer, humanPlayer;
    Grid gridAIPlayer, gridHumanPlayer;
    PlayerType playerTypeTurn;


    public void start() {
        gridAIPlayer = new Grid();
        gridHumanPlayer = new Grid();

        aiPlayer = new AIPlayer(gridAIPlayer);
        humanPlayer = new HumanPlayer(gridHumanPlayer);

        aiPlayer.opponentPlayer = humanPlayer;
        humanPlayer.opponentPlayer = aiPlayer;

        aiPlayer.shipPlacement();
        humanPlayer.shipPlacement();

        playerTypeTurn = PlayerType.HUMAN;
    }


    public void shot(int x, int y) {
        Grid grid = (playerTypeTurn == PlayerType.HUMAN) ? gridAIPlayer : gridHumanPlayer;
        if (grid.isPossibleToShoot(x, y)) {
            if (!grid.isShotDuplicated(x, y)) {
                grid.makeShot(x, y);
                renderGrids(x, y);
                // Если игрок промахнулся, то передаём ход
                if (grid.getShotStatus() == ShotStatus.MISSED) {
                    changeTurn();
                }
            } else {
                if (playerTypeTurn == PlayerType.HUMAN) {
                    Menu.duplicateShotMessage();
                }
            }
        } else {
            if (playerTypeTurn == PlayerType.HUMAN) {
                Menu.outOfBattlefieldShotMessage();
            }
        }
    }


        public void changeTurn () {
            if (playerTypeTurn == PlayerType.HUMAN) {
                playerTypeTurn = PlayerType.AI;
            } else {
                playerTypeTurn = PlayerType.HUMAN;
            }
        }


        public boolean isEndOfGame () {
            Grid grid = (playerTypeTurn == PlayerType.HUMAN) ? gridAIPlayer : gridHumanPlayer;
            for (Ship ship : grid.ships) {
                if (!ship.isSunk()) {
                    return false;
                }
            }
            return true;
        }


        public void renderGrids ( int x, int y){
            if (playerTypeTurn == PlayerType.HUMAN) {
                System.out.println("AI player grid");
                gridAIPlayer.render(false);
            } else {
                Menu.aiShootingProcedure();
                System.out.print("AI player shot at X = " + (x + 1) + "  Y =");
                Menu.printLetterCoordinate(y);
                System.out.println("Human player grid");
                gridHumanPlayer.render(true);
            }
        }
    }
