package seabattle.ship;

import seabattle.battlefield.BattleField;
import seabattle.battlefield.Cell;
import seabattle.instrument.CellChecker;
import seabattle.instrument.InputChecker;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ShipFactory {
    private static ArrayList<Ship> placedOnFieldEnemyShips = new ArrayList<>();
    private static ArrayList<Ship> placedOnFieldPlayerShips = new ArrayList<>();
    private static int digit;
    private static String letter;

    private ShipFactory() {}

    public static String getRandomCoordinate() {
        Random random = new Random();
        int letterRatio = random.nextInt(10);
        letter = BattleField.ARRAY_OF_LETTERS.substring(letterRatio, letterRatio + 1);
        digit = random.nextInt(10) + 1;

        if (!CellChecker.checkIfCellIsFree(letter, digit)) getRandomCoordinate();
        else return letter + digit;
        return "";
    }

    public static String getUserWishCoordinate() {
        System.out.println("Введи координату по типу A1");
        String userWish = new Scanner(System.in).nextLine();
        if (InputChecker.checkCorrectInput(userWish)) return userWish;
        else getUserWishCoordinate();
        return "";
    }

    public static Ship getPlacedShip(int length, String coordinate, ArrayList<Cell> battleField) {
        ArrayList<Cell> shipCells = new ArrayList<>();
        int num = getDigitFromStringCoordinate(coordinate);
        String let = getLetterFromStringCoordinate(coordinate);

        if (CellChecker.checkTop(let,num,length)) {
            for(int i = 0; i < length; i++) {
                shipCells.add(battleField.get(CellChecker.getCellIndex(let, num) - i * 10));
            }
            return new Ship(shipCells);
        }
        else if (CellChecker.checkLeft(let,num,length)) {
            for(int i = 0; i < length; i++) {
                shipCells.add(battleField.get(CellChecker.getCellIndex(let, num) - i));
            }
            return new Ship(shipCells);
        }
        else if (CellChecker.checkDown(let,num,length)) {
            for(int i = 0; i < length; i++) {
                shipCells.add(battleField.get(CellChecker.getCellIndex(let, num) + i * 10));
            }
            return new Ship(shipCells);
        }
        else if (CellChecker.checkRight(let,num,length)) {
            for(int i = 0; i < length; i++) {
                shipCells.add(battleField.get(CellChecker.getCellIndex(let, num) + i));
            }
            return new Ship(shipCells);
        }
        else return null;
    }

    // The method outputs ships location
    public static void outputShipsLocation(ArrayList<Ship> placedOnFieldShips) {
        for (Ship ship : placedOnFieldShips) {
            for (Cell cell : ship.getShipLocation()) {
                System.out.print(cell.getLetter() + cell.getDigit() + " ");
            }
        }
    }

    public static int getDigitFromStringCoordinate(String str) {
        return Integer.parseInt(str.substring(1));
    }
    public static String getLetterFromStringCoordinate(String str) {
        return str.substring(0, 1);
    }

    public static ArrayList<Ship> getPlacedOnFieldEnemyShips() {return placedOnFieldEnemyShips; }
    public static ArrayList<Ship> getPlacedOnFieldPlayerShips() { return placedOnFieldPlayerShips;}
}
