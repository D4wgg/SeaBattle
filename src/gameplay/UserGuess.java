package gameplay;

import battlefield.*;
import programskeleton.GameEngine;
import ships.*;


public class UserGuess {
    private static int shotCount;
    private static int hit;

    private UserGuess() {}

    public static void checkHit () {

        while (!ShipFactory.getPlacedOnDeckShips().isEmpty()) {
            String userInput = CheckUserInput.checkUserInput();
            String letter = userInput.charAt(0) + "";
            int digit = Integer.parseInt(userInput.substring(1));

            if(BattleField.battleField.get(Checker.getCellIndex(letter, digit)).isGotShot()) {
                System.out.println("Вы уже стреляли в эту клетку!");
                CheckUserInput.checkUserInput();
            }

            for(Ship ship : ShipFactory.getPlacedOnDeckShips()) {
                for (Cell cell : ship.getShipLocation()) {
                    shotCount++;
                    cell.setGotShot(true);
                    if(cell == BattleField.battleField.get(Checker.getCellIndex(letter, digit))) {
                        hit++;
                        ship.getShipLocation().remove(cell);
                        if(ship.getShipLocation().isEmpty()) {
                            System.out.println("Потопил!");
                            ShipFactory.getPlacedOnDeckShips().remove(ship);
                            break;
                        } else {
                            System.out.println("Попал!");
                            break;
                        }

                    } else {
                        System.out.println("Чел, ты попуск, ты вообще играть не умеешь!!");
                        break;
                    }
                }
                break;
            }
        }
        float accuracy = hit / shotCount;
        GameEngine.finishGame(shotCount, accuracy);

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

}
