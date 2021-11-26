package ships;

import battleField.*;

import java.util.ArrayList;
import java.util.Random;


public class CreationShip {
    private Cell cell;

    private CreationShip() {}

    public static void creationShip() {
        Random random = new Random();

        for(Ships ships : GameSettings.loadSettings()) {
            selectFirstShipCell(ships.getDeckCount());
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
                    cell.setFree(false);
                    selectLocationForShip(letter, digit, length);
                    break;
                } else selectFirstShipCell(length);

            }
        }
    }

    public static void selectLocationForShip(String letter, int digit, int length) {
        if (checkTop(letter,digit,length)) {

        }
        else if (checkDown(letter,digit,length)) {

        }
        else if (checkLeft(letter,digit,length)) {

        }
        else if (checkRight(letter,digit,length)) {

        }
        else selectFirstShipCell(length);
    }

    public static boolean checkLeft(String letter, int digit, int length) {
          
    }

    public static boolean checkTop(String letter, int digit, int length) {
        if(digit - length > 0) {
            for(int i = 1; i < length; i++) {
                if(checkIfCellIsFree(letter, digit - i));
                else return false;
            }
        } else return false;
        return true;
    }

    public static boolean checkRight(String letter, int digit, int length) {

    }

    public static boolean checkDown(String letter, int digit, int length) {
        if(digit + length <= 10) {
            for(int i = 1; i < length; i++) {
                if(checkIfCellIsFree(letter, digit + i));
                else return false;
            }
        } else return false;
        return true;
    }

    private static boolean checkIfCellIsFree (String letter, int digit) {
        String alphabet = "ABCDEFGHIJ";
        int index = 0;
        for(int i = 0; i < alphabet.length(); i++) {
            if(alphabet.substring(i, i + 1).equals(letter)) index = i * 10 + digit - 1;
        }
        return (BattleField.battleField.get(index).isFree() == true);
    }


}
