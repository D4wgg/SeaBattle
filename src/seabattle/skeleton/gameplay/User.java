package seabattle.skeleton.gameplay;

import seabattle.battlefield.BattleField;
import seabattle.battlefield.Cell;
import seabattle.instrument.CellChecker;
import seabattle.ship.Ship;
import seabattle.ship.ShipFactory;

import java.util.ArrayList;

public class User extends Player{
    public User(String name) {
        super(name);
    }

    public String toString() {
        return name;
    }

    public boolean checkHit(String userInput) {
        boolean sunkenShip = false;
        if (makeHit(userInput)) {
            for (Ship ship : ShipFactory.getPlacedOnFieldEnemyShips()) {
                if (ship.getShipLocation().isEmpty()) {
                    System.out.println("Потопил");
                    ShipFactory.getPlacedOnFieldEnemyShips().remove(ship);
                    sunkenShip = true;
                    break;
                }
            }
            if (!sunkenShip) System.out.println("Попал");
            return true;
        } else System.out.println("Промазал, попуск");
        shotCount++;
        return false;
    }

    boolean makeHit(String userInput) {
        String letter = userInput.charAt(0) + "";
        int digit = Integer.parseInt(userInput.substring(1));

        BattleField.getEnemyField().get(CellChecker.getCellIndex(letter, digit)).setGotShot(true);
        for (Ship ship : ShipFactory.getPlacedOnFieldEnemyShips()) {
            for (Cell cell : ship.getShipLocation()) {
                if (cell.equals(BattleField.getEnemyField().get(CellChecker.getCellIndex(letter, digit)))) {
                    ship.getShipLocation().remove(cell);
                    return true;
                }
            }
        }
        return false;
    }

    public int getShotCount() {
        return shotCount;
    }

}
