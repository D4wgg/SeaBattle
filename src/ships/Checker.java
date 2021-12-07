package ships;

import battlefield.BattleField;

public class Checker {
    public static final String ALPHABET = "ABCDEFGHIJ";

    private Checker () {}

    public static boolean checkLeft(String letter, int digit, int length) {
        if (getLetterIndex(letter) % 10 - length >= 0) {
            for(int i = 0; i < length; i++) {
                if (checkIfCellIsFree(getCellIndex(letter, digit) - i) == false) return false;
            }
            return true;
        }
        return false;
    }

    public static boolean checkTop(String letter, int digit, int length) {
        if(digit - length > 0) {
            for(int i = 1; i <= length; i++) {
                if(checkIfCellIsFree(letter, digit - i));
                else return false;
            }
        } else return false;
        return true;
    }

    public static boolean checkRight(String letter, int digit, int length) {
        if (getLetterIndex(letter) % 10 - length <= 10) {
            for(int i = 0; i < length; i++) {
                if (checkIfCellIsFree(getCellIndex(letter, digit) + i) == false) return false;
            }
            return true;
        }
        return false;
    }

    public static boolean checkDown(String letter, int digit, int length) {
        if(digit + length <= 10) {
            for (int i = 1; i < length; i++) {
                if (!checkIfCellIsFree(letter, digit + i)) return false;
            }
        } else return false;
        return true;
    }

    private static boolean checkIfCellIsFree (String letter, int digit) {
        return(BattleField.battleField.get(getCellIndex(letter, digit)).isFree());
    }

    private static boolean checkIfCellIsFree (int cellIndex) {
        return(BattleField.battleField.get(cellIndex).isFree());
    }

    public static int getLetterIndex (String letter) {
        for(int i = 0; i < ALPHABET.length(); i++) {
            if(ALPHABET.substring(i, i + 1).equals(letter)) return i;
        }
        return 0;
    }

    public static int getCellIndex (String letter, int digit) {
        int index = (digit * 10 - 10) + getLetterIndex(letter);
        return index;
    }
}
