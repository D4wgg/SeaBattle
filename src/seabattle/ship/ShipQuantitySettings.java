package seabattle.ship;

import seabattle.instrument.ShipQuantityChecker;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;

public final class ShipQuantitySettings {
    private ShipQuantitySettings() {}
    private static List<ShipList> userShipList;
    public static List<ShipList> loadSettings() {
        userShipList = new ArrayList<>();

        ArrayList<ShipList> shipModelList = new ArrayList<>();
        shipModelList.add(ShipList.HUGE);
        shipModelList.add(ShipList.BIG);
        shipModelList.add(ShipList.MIDDLE);
        shipModelList.add(ShipList.SMALL);

        System.out.println("Давайте настроим количество кораблей");
        for (ShipList shipList : shipModelList) {
            System.out.printf("Укажите количество %d-х палубных кораблей,которое нужно расположить на доске" +
                    " максимальное значение %d", shipList.getDeckCount(), shipList.getShipsQuantity());

            int shipsQuantity = ShipQuantityChecker.checkShipsQuantity(shipList.getShipsQuantity());
            for(int i = 0; i < shipsQuantity; i++) {
                userShipList.add(shipList);
            }
        }

        return userShipList;
    }

    public static List<ShipList> getUserShipList() {
        return userShipList;
    }
}
