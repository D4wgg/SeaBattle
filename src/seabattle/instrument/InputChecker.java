package seabattle.instrument;

import java.util.Scanner;
import seabattle.battlefield.BattleField;

public class InputChecker {
    private static String input;

    public static String checkUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сделай ход! Введи координату : например (A1)");
        String error = "Ошибка ввода!";

        while (!checkCorrectInput(scanner.nextLine())) {
            System.out.println(error);
        }

        return input;

    }

    public static boolean checkCorrectInput(String userInput) {
        int digit;
        boolean correctLetter = false;
        if (userInput.length() < 2 || userInput.length() > 3) return false;
        String letter = userInput.charAt(0) + "";
        for (int i = 0; i < BattleField.ARRAY_OF_LETTERS.length(); i++) {
            if (letter.equals(BattleField.ARRAY_OF_LETTERS.substring(i, i + 1))) correctLetter = true;
        }
        if (!correctLetter) return false;

        try {
            digit = Integer.parseInt(userInput.substring(1));
            if(digit < 1 || digit > 10) return false;
        } catch (Exception e) {
            return false;
        }

        if (checkRepeatedShot(letter, digit)) return false;

        input = userInput;
        return true;
    }

    private static boolean checkRepeatedShot(String letter, int digit) {
        if(BattleField.getEnemyField().get(CellChecker.getCellIndex(letter, digit)).isGotShot()) {
            System.out.println("Вы уже стреляли в эту клетку!");
            return true;
        } else return false;
    }
}
