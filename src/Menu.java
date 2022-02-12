import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    static void message() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Menu message: this game has started.");
//        System.out.println("EMPTY_CELL - " + Grid.EMPTY_CELL);
//        System.out.println("DECK_UNDAMAGED - " + Grid.DECK_UNDAMAGED);
//        System.out.println("DECK_DAMAGED - " + Grid.DECK_DAMAGED);
//        System.out.println("MISS_SHOT - " + Grid.MISS_SHOT);

        System.out.println("To place ships manually press \"M\"");
        System.out.println("To place ships automatically press \"A\"");

        String humanChoice = bufferedReader.readLine();

        switch (humanChoice) {
            case ("M"), ("m") -> System.out.println("Ships are placed manually.");
            case ("A"), ("a") -> System.out.println("Ships are placed automatically.");
            default -> throw new IllegalStateException("Unexpected value: " + humanChoice);
        }
        System.out.println("For placing a ship enter it orientation (V for vertical, H for horizontal) and coordinates (X - from 1 to 10, Y - from A to J).");

        Grid grid = new Grid();

        System.out.println("Place one FOURDECKER.");

        System.out.print("Orientation = ");
        String humanChoiceOrientation = bufferedReader.readLine();
        System.out.print("X = ");
        int humanChoiceX = Integer.parseInt(bufferedReader.readLine()) - 1;
        System.out.print("Y = ");
        String strHumanChoiceY = bufferedReader.readLine();
        int humanChoiceY;
        switch (strHumanChoiceY) {
            case ("A"), ("a") -> humanChoiceY = 0;
            case ("B"), ("b") -> humanChoiceY = 1;
            case ("C"), ("c") -> humanChoiceY = 2;
            case ("D"), ("d") -> humanChoiceY = 3;
            case ("E"), ("e") -> humanChoiceY = 4;
            case ("F"), ("f") -> humanChoiceY = 5;
            case ("G"), ("g") -> humanChoiceY = 6;
            case ("H"), ("h") -> humanChoiceY = 7;
            case ("I"), ("i") -> humanChoiceY = 8;
            case ("J"), ("j") -> humanChoiceY = 9;
            default -> throw new IllegalStateException("Unexpected value: " + humanChoice);
        }
        System.out.println("check1");
        switch (humanChoiceOrientation) {
            case ("V"), ("v") -> grid.createShip(ShipType.FOURDECKER, ShipOrientation.VERTICAL, humanChoiceX, humanChoiceY);
            case ("H"), ("h") -> grid.createShip(ShipType.FOURDECKER, ShipOrientation.HORIZONTAL, humanChoiceX, humanChoiceY);
            default -> throw new IllegalStateException("Unexpected value: " + humanChoice);
        }
        grid.render();

    }
}
