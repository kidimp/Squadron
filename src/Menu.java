import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Menu {
    public static final int MANUAL_PLACING_METHOD = 1;
    public static final int AUTO_PLACING_METHOD = 0;
    public static final int VERTICAL_SHIP_ORIENTATION = 1;
    public static final int HORIZONTAL_SHIP_ORIENTATION = 0;

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    static void initialMessage() {
        System.out.println("Menu message: this game has started.");
    }


    static void endOfTheGameMessage() {
        System.out.println("End of the game.");
    }


    static int getPlacingMethod() {
        System.out.println("To place human ships manually press \"M\"");
        System.out.println("To place human ships automatically press \"A\"");

        String humanChoice = null;
        try {
            humanChoice = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Error");
        }

        switch (Objects.requireNonNull(humanChoice)) {
            case ("M"), ("m") -> {
                System.out.println("Ships are placing manually.");
                return MANUAL_PLACING_METHOD;
            }
            case ("A"), ("a") -> {
                System.out.println("Ships are placed automatically.");
                return AUTO_PLACING_METHOD;
            }
            default -> throw new IllegalStateException("Unexpected value: " + humanChoice);
        }
    }


    static int getOrientation() throws IOException {
        String humanChoiceOrientation;

        System.out.print("Orientation = ");
        humanChoiceOrientation = bufferedReader.readLine();
        switch (humanChoiceOrientation) {
            case ("V"), ("v") -> {
                return VERTICAL_SHIP_ORIENTATION;
            }
            case ("H"), ("h") -> {
                return HORIZONTAL_SHIP_ORIENTATION;
            }
            default -> throw new IllegalStateException("Unexpected value: " + humanChoiceOrientation);
        }
    }


    static int getCoordinate_X() throws IOException {
        System.out.print("X = ");
        return Integer.parseInt(bufferedReader.readLine()) - 1;
    }


    static int getCoordinate_Y() throws IOException {
        System.out.print("Y = ");
        String strHumanChoiceY = bufferedReader.readLine();
        switch (strHumanChoiceY) {
            case ("A"), ("a") -> {
                return 0;
            }
            case ("B"), ("b") -> {
                return 1;
            }
            case ("C"), ("c") -> {
                return 2;
            }
            case ("D"), ("d") -> {
                return 3;
            }
            case ("E"), ("e") -> {
                return 4;
            }
            case ("F"), ("f") -> {
                return 5;
            }
            case ("G"), ("g") -> {
                return 6;
            }
            case ("H"), ("h") -> {
                return 7;
            }
            case ("I"), ("i") -> {
                return 8;
            }
            case ("J"), ("j") -> {
                return 9;
            }
            default -> {
                System.out.println("Unexpected value. Please, enter valid Y coordinate from A to J.");
                throw new IllegalStateException("Unexpected value: " + strHumanChoiceY);
            }
        }
    }


    public static void placingRulesMessage() {
        System.out.println("For placing a ship enter it orientation (V for vertical, H for horizontal) " +
                "and coordinates (X - from 1 to 10, Y - from A to J).");
    }


    public static void currentOpponentGrid() {
        System.out.println("This is a current opponent's grid. \nTake your shot.");
    }


    public static void duplicateShotMessage() {
        System.out.println("You have already shoot at these coordinates. Try another one.");
    }


    public static void outOfBattlefieldShotMessage() {
        System.out.println("You shoot out of battlefield. Try another coordinates.");
    }


    public static void aiShootingProcedure() {
        try {
            Thread.sleep(350);
            System.out.print("AI player shooting");
            for (int i = 0; i < 8; i++) {
                Thread.sleep(250);
                System.out.print(".");
            }
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void printLetterCoordinate(int i) {
        switch (i) {
            case 0 -> System.out.println(" a");
            case 1 -> System.out.println(" b");
            case 2 -> System.out.println(" c");
            case 3 -> System.out.println(" d");
            case 4 -> System.out.println(" e");
            case 5 -> System.out.println(" f");
            case 6 -> System.out.println(" g");
            case 7 -> System.out.println(" h");
            case 8 -> System.out.println(" i");
            case 9 -> System.out.println(" j");
        }
    }
}