package seabattle.instrument;

import seabattle.battlefield.BattleField;

public class CellChecker {
    public static final String ALPHABET = "ABCDEFGHIJ";

    private CellChecker () {}

    public static boolean checkLeft(String letter, int digit, int length) {
        if (getLetterIndex(letter) % 10 - length >= 0) {
            for(int i = 0; i < length; i++) {
                if (checkIfCellIsFree(getCellIndex(letter, digit) - i)) return false;
            }
            return true;
        }
        return false;
    }

    public static boolean checkTop(String letter, int digit, int length) {
        if(digit - length > 0) {
            for(int i = 1; i <= length; i++) {
                if(!checkIfCellIsFree(letter, digit - i)) return false;
            }
        } else return false;
        return true;
    }

    public static boolean checkRight(String letter, int digit, int length) {
        if (getLetterIndex(letter) % 10 - length <= 10) {
            for(int i = 0; i < length; i++) {
                if (checkIfCellIsFree(getCellIndex(letter, digit) + i)) return false;
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

    public static boolean checkIfCellIsFree (String letter, int digit) {
        return(BattleField.getEnemyField().get(getCellIndex(letter, digit)).isFree());
    }

    public static boolean checkIfCellIsFree (int cellIndex) {
        return(BattleField.getEnemyField().get(cellIndex).isFree());
    }

    public static int getLetterIndex (String letter) {
        for(int i = 0; i < ALPHABET.length(); i++) {
            if(ALPHABET.substring(i, i + 1).equals(letter)) return i;
        }
        return 0;
    }

    public static int getCellIndex (String letter, int digit) {
        return ((digit * 10 - 10) + getLetterIndex(letter));
    }
}