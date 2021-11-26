package ships;

import java.util.ArrayList;

public final class GameSettings {
    private GameSettings() {}

    public static ArrayList<Ships> loadSettings() {
        ArrayList<Ships> userShipList = new ArrayList<>();

        ArrayList<Ships> shipsList = new ArrayList<>();
        shipsList.add(Ships.HUGE);
        shipsList.add(Ships.BIG);
        shipsList.add(Ships.MIDDLE);
        shipsList.add(Ships.SMALL);

        System.out.println("Давайте настроим количество кораблей");
        for (Ships ships : shipsList) {
            System.out.printf("Укажите количество %d-х палубных кораблей,которое нужно расположить на доске" +
                    " максимальное значение %d", ships.getDeckCount(), ships.getShipsQuantity());

            int shipsQuantity = CheckUserInput.checkShipsQuantity(ships.getShipsQuantity());
            for(int i = 0; i < shipsQuantity; i++) {
                userShipList.add(ships);
            }
        }
        for(Ships ships : userShipList) {
            System.out.print(ships + " ");
        }
        return userShipList;
    }






    /*private final Map<Ships, Integer> shipsConfigs = new LinkedHashMap<>();

    public Map<Ships, Integer> loadSettings() {
        shipsConfigs.put(Ships.SMALL, 4);
        shipsConfigs.put(Ships.MIDDLE, 3);
        shipsConfigs.put(Ships.BIG, 2);
        shipsConfigs.put(Ships.HUGE, 1);

        return shipsConfigs;
    }*/
}
