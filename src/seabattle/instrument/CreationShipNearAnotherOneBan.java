package seabattle.instrument;

import seabattle.ship.*;
import seabattle.battlefield.*;

import java.util.ArrayList;

public class CreationShipNearAnotherOneBan {
    private static final int[] cellIndexList = {-11, -10, -9, -1, 0, 1, 9, 10, 11};

    public static void guardCellsAroundShip(ArrayList<Ship> placedShips) {
        for (Ship ship : placedShips) {
            for (Cell cell : ship.getShipLocation()) {
                int coordinate = CellChecker.getCellIndex(cell.getLetter(), cell.getDigit());
                for (int i = 0; i < cellIndexList.length; i++) {
                    try {
                        BattleField.getEnemyField().get(coordinate + cellIndexList[i]).setFree(false);
                    } catch (IndexOutOfBoundsException e) {e.getStackTrace();}
                }
            }
        }
    }
}
