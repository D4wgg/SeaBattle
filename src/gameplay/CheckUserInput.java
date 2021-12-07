package gameplay;

import battlefield.BattleField;

import java.util.Scanner;
public class CheckUserInput {

    static String checkUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сделай ход! Введи координату : например (A1)");
        String input = scanner.nextLine();
        String error = "Ошибка ввода!";
        boolean correctLetter = false;

        if(input.length() < 2 || input.length() > 3) {
            System.out.println(error);
            checkUserInput();
        }
        String letter = input.charAt(0) + "";
        for (int i = 0; i < BattleField.ARRAY_OF_LETTERS.length(); i++) {
            if(letter.equals(BattleField.ARRAY_OF_LETTERS.substring(i, i + 1))) {
                correctLetter = true;
                break;
            }
        }
        if(!correctLetter) {
            System.out.println(error);
            checkUserInput();
        }

        try {
            int digit = Integer.parseInt(input.substring(1));
            if(digit < 1 || digit > 10) {
                System.out.println(error);
                checkUserInput();
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода");
            checkUserInput();
        }

        return input;
    }

}
