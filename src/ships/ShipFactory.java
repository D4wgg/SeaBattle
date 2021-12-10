package ships;

import battlefield.*;
import ships.ProtectionShip;

import java.util.ArrayList;
import java.util.Random;
public class ShipFactory {

    private static ArrayList<Ship> placedOnDeckShips = new ArrayList<>();

    private ShipFactory() {}

    public static void createShip(ArrayList<ShipList> userShipList) {
        for(ShipList shipList : userShipList) {
            selectFirstShipCell(shipList.getDeckCount());
        }

    }

    public static void selectFirstShipCell (int length) {
        Random random = new Random();
        int letterRatio = random.nextInt(10);
        String letter = BattleField.ARRAY_OF_LETTERS.substring(letterRatio, letterRatio + 1);
        int digit = random.nextInt(10) + 1;

        for(Cell cell : BattleField.battleField) {
            if(cell.getLetter().equals(letter) && cell.getDigit() == digit) {
                if(cell.isFree()) {
                    placedOnDeckShips.add(selectLocationForShip(letter, digit, length));
                    break;
                } else selectFirstShipCell(length);

            }
        }

        ProtectionShip.guardCellsAroundShip();
    }

    public static Ship selectLocationForShip(String letter, int digit, int length) {
        ArrayList<Cell> shipCells = new ArrayList<>();

        if (Checker.checkTop(letter,digit,length)) {
            for(int i = 0; i < length; i++) {
                shipCells.add(BattleField.battleField.get(Checker.getCellIndex(letter, digit) - i * 10));
            }
            return new Ship(shipCells);
        }
        else if (Checker.checkLeft(letter,digit,length)) {
            for(int i = 0; i < length; i++) {
                shipCells.add(BattleField.battleField.get(Checker.getCellIndex(letter, digit) - i));
            }
            return new Ship(shipCells);
        }
        else if (Checker.checkDown(letter,digit,length)) {
            for(int i = 0; i < length; i++) {
                shipCells.add(BattleField.battleField.get(Checker.getCellIndex(letter, digit) + i * 10));
            }
            return new Ship(shipCells);
        }
        else if (Checker.checkRight(letter,digit,length)) {
            for(int i = 0; i < length; i++) {
                shipCells.add(BattleField.battleField.get(Checker.getCellIndex(letter, digit) + i));
            }
            return new Ship(shipCells);
        }
        else selectFirstShipCell(length);

        return new Ship(shipCells);
    }

    public static ArrayList<Ship> getPlacedOnDeckShips() {
        return placedOnDeckShips;
    }

}
