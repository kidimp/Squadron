import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        System.out.println("To place ships manually press \"M\"");
        System.out.println("To place ships automatically press \"A\"");

        String humanChoice = null;
        try {
            humanChoice = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Error");
        }

        switch (humanChoice) {
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


    static int getCoordX() throws IOException {
        System.out.print("X = ");
        return Integer.parseInt(bufferedReader.readLine()) - 1;
    }


    static int getCoordY() throws IOException {
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
            default -> throw new IllegalStateException("Unexpected value: " + strHumanChoiceY);
        }
    }


    public static void placingRulesMessage() {
        System.out.println("For placing a ship enter it orientation (V for vertical, H for horizontal) " +
                "and coordinates (X - from 1 to 10, Y - from A to J).");
    }


    public static void currentOpponentGrid() {
        System.out.println("This is a current opponent's grid. \nTake your shot.");
    }
}
