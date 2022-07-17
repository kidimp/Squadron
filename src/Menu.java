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
            while ((!Objects.equals(humanChoice, "a")) && (!Objects.equals(humanChoice, "A"))
                    && (!Objects.equals(humanChoice, "m")) && (!Objects.equals(humanChoice, "M"))) {

                humanChoice = bufferedReader.readLine().trim();

                if ((!Objects.equals(humanChoice, "a")) && (!Objects.equals(humanChoice, "A"))
                        && (!Objects.equals(humanChoice, "m")) && (!Objects.equals(humanChoice, "M"))) {
                    System.out.println("Choose correct placing method.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Menu.getPlacingMethod()");
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


    static int getOrientation() {
        System.out.print("Orientation = ");

        String humanChoiceOrientation = null;
        try {
            while ((!Objects.equals(humanChoiceOrientation, "v")) && (!Objects.equals(humanChoiceOrientation, "V"))
                    && (!Objects.equals(humanChoiceOrientation, "h")) && (!Objects.equals(humanChoiceOrientation, "H"))) {

                humanChoiceOrientation = bufferedReader.readLine().trim();

                if ((!Objects.equals(humanChoiceOrientation, "v")) && (!Objects.equals(humanChoiceOrientation, "V"))
                        && (!Objects.equals(humanChoiceOrientation, "h")) && (!Objects.equals(humanChoiceOrientation, "H"))) {
                    System.out.println("Choose correct orientation.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Menu.getOrientation()");
        }

        switch (Objects.requireNonNull(humanChoiceOrientation)) {
            case ("V"), ("v") -> {
                return VERTICAL_SHIP_ORIENTATION;
            }
            case ("H"), ("h") -> {
                return HORIZONTAL_SHIP_ORIENTATION;
            }
            default -> throw new IllegalStateException("Unexpected value: " + humanChoiceOrientation);
        }
    }


    static int getCoordinate_X() {
        System.out.print("X = ");

        String x = null;
        try {
            while ((!Objects.equals(x, "1")) && (!Objects.equals(x, "2"))
                    && (!Objects.equals(x, "3")) && (!Objects.equals(x, "4"))
                    && (!Objects.equals(x, "5")) && (!Objects.equals(x, "6"))
                    && (!Objects.equals(x, "7")) && (!Objects.equals(x, "8"))
                    && (!Objects.equals(x, "9")) && (!Objects.equals(x, "10"))) {

                x = bufferedReader.readLine().trim();

                if ((!Objects.equals(x, "1")) && (!Objects.equals(x, "2"))
                        && (!Objects.equals(x, "3")) && (!Objects.equals(x, "4"))
                        && (!Objects.equals(x, "5")) && (!Objects.equals(x, "6"))
                        && (!Objects.equals(x, "7")) && (!Objects.equals(x, "8"))
                        && (!Objects.equals(x, "9")) && (!Objects.equals(x, "10"))) {
                    System.out.println("Choose correct coordinate X");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Menu.getCoordinate_X()");
        }

        return Integer.parseInt(Objects.requireNonNull(x)) - 1;
    }


    static int getCoordinate_Y() {
        System.out.print("Y = ");

        String y = null;
        try {
            while ((!Objects.equals(y, "A")) && (!Objects.equals(y, "a"))
                    && (!Objects.equals(y, "B")) && (!Objects.equals(y, "b"))
                    && (!Objects.equals(y, "C")) && (!Objects.equals(y, "c"))
                    && (!Objects.equals(y, "D")) && (!Objects.equals(y, "d"))
                    && (!Objects.equals(y, "E")) && (!Objects.equals(y, "e"))
                    && (!Objects.equals(y, "F")) && (!Objects.equals(y, "f"))
                    && (!Objects.equals(y, "G")) && (!Objects.equals(y, "g"))
                    && (!Objects.equals(y, "H")) && (!Objects.equals(y, "h"))
                    && (!Objects.equals(y, "I")) && (!Objects.equals(y, "i"))
                    && (!Objects.equals(y, "J")) && (!Objects.equals(y, "j"))) {

        y = bufferedReader.readLine().trim();

                if ((!Objects.equals(y, "A")) && (!Objects.equals(y, "a"))
                        && (!Objects.equals(y, "B")) && (!Objects.equals(y, "b"))
                        && (!Objects.equals(y, "C")) && (!Objects.equals(y, "c"))
                        && (!Objects.equals(y, "D")) && (!Objects.equals(y, "d"))
                        && (!Objects.equals(y, "E")) && (!Objects.equals(y, "e"))
                        && (!Objects.equals(y, "F")) && (!Objects.equals(y, "f"))
                        && (!Objects.equals(y, "G")) && (!Objects.equals(y, "g"))
                        && (!Objects.equals(y, "H")) && (!Objects.equals(y, "h"))
                        && (!Objects.equals(y, "I")) && (!Objects.equals(y, "i"))
                        && (!Objects.equals(y, "J")) && (!Objects.equals(y, "j"))) {
                    System.out.println("Choose correct coordinate Y");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: Menu.getCoordinate_Y()");
        }

        switch (Objects.requireNonNull(y)) {
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
                throw new IllegalStateException("Unexpected value: " + y);
            }
        }
    }


    public static void placingRulesMessage() {
        System.out.println("For placing a ship enter it orientation (V for vertical, H for horizontal) " +
                "\nand coordinates (X - from 1 to 10, Y - from A to J).");
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