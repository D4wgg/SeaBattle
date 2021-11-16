package ships;

import java.util.ArrayList;
import java.util.Scanner;

public class GameSettings {
    public ArrayList<Ships> loadSettings() {
        ArrayList<Ships> userShipList = new ArrayList<>();

        ArrayList<Ships> shipsList = new ArrayList<>();
        shipsList.add(Ships.HUGE);
        shipsList.add(Ships.BIG);
        shipsList.add(Ships.MIDDLE);
        shipsList.add(Ships.SMALL);

        Scanner scanner = new Scanner(System.in);
        for (Ships ships : shipsList) {
            System.out.printf("Укажите количество %d-х палубных кораблей,которое нужно расположить на доске" +
                    " максимальное значение %d", ships.getDeckCount(), ships.getShipsQuantity());

            for(int i = 0; i < CheckUserInput.checkShipsQuantity(ships.getShipsQuantity()); i++) {
                userShipList.add(ships);
            }
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
