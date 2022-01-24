package seabattle.skeleton.mode;

import seabattle.battlefield.Cell;
import seabattle.instrument.InputChecker;
import seabattle.ship.Ship;
import seabattle.ship.ShipFactory;
import seabattle.ship.ShipList;
import seabattle.ship.ShipQuantitySettings;
import seabattle.skeleton.gameplay.*;

import java.util.*;

public abstract class GameMode {
    User user = new User(new Scanner(System.in).nextLine());
    Bot bot = new Bot("Ботяра попущеный");

    public abstract void startGame();

    public abstract void gameplay();

    public void finishGame(Player player) {
        System.out.println("Победу одержал " + player + " всего за " + player.getShotCount() + " выстрелов");
    }

    public boolean putShipOnField(String coordinate, ArrayList<Cell> battleField, ArrayList<Ship> placedShips) {
        Iterator<ShipList> iterator = ShipQuantitySettings.getUserShipList().iterator();
        while (iterator.hasNext()) {
            ShipList sl = iterator.next();
            Ship ship = ShipFactory.getPlacedShip(sl.getDeckCount(), coordinate, battleField);
            if (ship == null) return false;
            placedShips.add(ship);
            ShipQuantitySettings.getUserShipList().remove(sl);
        }
        return true;
    }

    public void makeShot(ArrayList<Ship> placedShips, Player player) {
        boolean end = false;
        while (player.checkHit(InputChecker.checkUserInput())) {
            end = placedShips.isEmpty();
            if (end) {
                finishGame(player);
            }
        }
    }

}
