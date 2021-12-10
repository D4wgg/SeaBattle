package gameplay;

import battlefield.*;
import ships.*;

public class UserGuess {
    private static int shotCount;
    private static int hit;

    private UserGuess() {}

    public static void checkHit () {
        boolean sunkenShip = false;
        if (makeHit()) {
            hit++;
            for (Ship ship : ShipFactory.getPlacedOnDeckShips()) {
                if (ship.getShipLocation().isEmpty()) {
                    System.out.println("Потопил");
                    ShipFactory.getPlacedOnDeckShips().remove(ship);
                    sunkenShip = true;
                    break;
                }
            }
            if (!sunkenShip) System.out.println("Попал");
        } else System.out.println("Промазал, попуск");
        shotCount++;
    }

    private static boolean makeHit() {
        String userInput = CheckUserInput.checkUserInput();
        String letter = userInput.charAt(0) + "";
        int digit = Integer.parseInt(userInput.substring(1));

        BattleField.battleField.get(Checker.getCellIndex(letter, digit)).setGotShot(true);
        for (Ship ship : ShipFactory.getPlacedOnDeckShips()) {
            for (Cell cell : ship.getShipLocation()) {
                if (cell.equals(BattleField.battleField.get(Checker.getCellIndex(letter, digit)))) {
                    ship.getShipLocation().remove(cell);
                    return true;
                }
            }
        }
        return false;
    }

    public static void lol() {
        for (Ship ship : ShipFactory.getPlacedOnDeckShips()) {
            for (Cell cell : ship.getShipLocation()) {
                System.out.print(cell.getLetter() + cell.getDigit() + " ");
            }
        }
    }

    public static int getShotCount () {
        return shotCount;
    }

    public static int getHit() {
        return hit;
    }
}
