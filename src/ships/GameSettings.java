package ships;

import java.util.ArrayList;

public final class GameSettings {
    private GameSettings() {}

    public static ArrayList<ShipList> loadSettings() {
        ArrayList<ShipList> userShipList = new ArrayList<>();

        ArrayList<ShipList> shipListList = new ArrayList<>();
        shipListList.add(ShipList.HUGE);
        shipListList.add(ShipList.BIG);
        shipListList.add(ShipList.MIDDLE);
        shipListList.add(ShipList.SMALL);

        System.out.println("Давайте настроим количество кораблей");
        for (ShipList shipList : shipListList) {
            System.out.printf("Укажите количество %d-х палубных кораблей,которое нужно расположить на доске" +
                    " максимальное значение %d", shipList.getDeckCount(), shipList.getShipsQuantity());

            int shipsQuantity = CheckUserInput.checkShipsQuantity(shipList.getShipsQuantity());
            for(int i = 0; i < shipsQuantity; i++) {
                userShipList.add(shipList);
            }
        }
        
        return userShipList;
    }

}
