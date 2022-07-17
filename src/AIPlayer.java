public class AIPlayer extends Player {
    int[] previousShotCoordinates;
    int[] firstSuccessShot;
    int direction;
    int counterOfDirectionChanges;
    boolean isShipFound;

    public AIPlayer(Grid grid) {
        super(grid);
        this.previousShotCoordinates = new int[2];
        previousShotCoordinates[0] = -1;
        previousShotCoordinates[1] = -1;
        this.firstSuccessShot = new int[2];
        firstSuccessShot[0] = -1;
        firstSuccessShot[1] = -1;
        direction = -1;
        isShipFound = false;
        counterOfDirectionChanges = 0;
    }


    public void shipPlacement() {
        allShipPlacementGeneration();
    }


    public int[] getShotCoordinates() {
        int[] aiShotCoordinates = new int[2];

        int[] offset_X = {0, 1, 0, -1};
        int[] offset_Y = {-1, 0, 1, 0};

        if (opponentPlayer.grid.getShotStatus() == ShotStatus.MISSED) {
            if (isShipFound) {
                if (!(counterOfDirectionChanges == 1)) {
                    direction = (direction < 2) ? direction + 2 : direction - 2;
                    previousShotCoordinates = firstSuccessShot.clone();
                    counterOfDirectionChanges++;
                } else {
                    direction = (int) (Math.random() * 4);
                    previousShotCoordinates = firstSuccessShot.clone();
                }
            } else {
                direction = -1;
            }
        }

        if (opponentPlayer.grid.getShotStatus() == ShotStatus.SUNK) {
            direction = -1;
            isShipFound = false;
            counterOfDirectionChanges = 0;
        }

        if (opponentPlayer.grid.getShotStatus() == ShotStatus.DAMAGED) {
            isShipFound = true;
            if (direction == -1) {
                firstSuccessShot = previousShotCoordinates.clone();
                direction = (int) (Math.random() * 4);
            }
        }

        if (!isShipFound) {
            aiShotCoordinates[0] = (int) (Math.random() * Grid.GRID_SIZE_X);
            aiShotCoordinates[1] = (int) (Math.random() * Grid.GRID_SIZE_Y);
        } else {
            aiShotCoordinates[0] = previousShotCoordinates[0] + offset_X[direction];
            aiShotCoordinates[1] = previousShotCoordinates[1] + offset_Y[direction];
        }

        if (!grid.isPossibleToShoot(aiShotCoordinates[0], aiShotCoordinates[1])) {
            previousShotCoordinates = firstSuccessShot.clone();
            direction = -1;
            aiShotCoordinates[0] = -1;
            aiShotCoordinates[1] = -1;
            return aiShotCoordinates;
        }

        previousShotCoordinates = aiShotCoordinates.clone();

        return aiShotCoordinates;
    }
}
