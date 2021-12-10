package gameplay;

import battlefield.BattleField;
import ships.Checker;

import java.util.Scanner;
public class CheckUserInput {
    private static String input;

    static String checkUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сделай ход! Введи координату : например (A1)");
        String error = "Ошибка ввода!";

        while (!correctInput(scanner.nextLine())) {
            System.out.println(error);
        }

        return input;

    }

    private static boolean correctInput(String userInput) {
        String alphabet = BattleField.ARRAY_OF_LETTERS;
        int digit;
        boolean correctLetter = false;
        if (userInput.length() < 2 || userInput.length() > 3) return false;
        String letter = userInput.charAt(0) + "";
        for (int i = 0; i < alphabet.length(); i++) {
            if (letter.equals(alphabet.substring(i, i + 1))) correctLetter = true;
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
        if(BattleField.battleField.get(Checker.getCellIndex(letter, digit)).isGotShot()) {
            System.out.println("Вы уже стреляли в эту клетку!");
            return true;
        } else return false;
    }

}
