package ships;

import battlefield.Cell;
import battlefield.BattleField;

public class ProtectionShip {
    private static final int[] cellIndexList = {-11, -10, -9, -1, 0, 1, 9, 10, 11};

    public static void guardCellsAroundShip() {
        for (Ship ship : ShipFactory.getPlacedOnDeckShips()) {
            for (Cell cell : ship.getShipLocation()) {
                int coordinate = Checker.getCellIndex(cell.getLetter(), cell.getDigit());
                for (int i = 0; i < cellIndexList.length; i++) {
                    try {
                        BattleField.battleField.get(coordinate + cellIndexList[i]).setFree(false);
                    } catch (IndexOutOfBoundsException e) { }
                }
            }
        }
    }
}
