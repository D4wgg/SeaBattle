package seabattle.instrument;

import java.util.Scanner;

public class ShipQuantityChecker {
    public static int checkShipsQuantity (int shipLength) {
        Scanner scanner = new Scanner(System.in);
        try {
            int userInput = scanner.nextInt();
            if (userInput < 1 || userInput > shipLength) {
                System.out.printf("Даун там максимум %d", shipLength);
                checkShipsQuantity(shipLength);
            }
            return userInput;
        } catch (Exception e) {
            System.out.println("Ошибка ввода!");
            checkShipsQuantity(shipLength);
            return 0;
        }

    }

}
