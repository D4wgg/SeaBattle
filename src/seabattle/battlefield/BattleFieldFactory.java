package seabattle.battlefield;

import java.util.ArrayList;

public class BattleFieldFactory {
    static ArrayList<Cell> createEmptyBattleField() {
        ArrayList<Cell> array = new ArrayList<>();
        int counter = 1;
        for(int i = 0; i < BattleField.SIZE_OF_BATTLE_FIELD_SIDE; i++) {
            for(int j = 0; j < BattleField.SIZE_OF_BATTLE_FIELD_SIDE; j++) {
                array.add(new Cell(BattleField.ARRAY_OF_LETTERS.substring(j, j + 1), counter));
            }
            counter++;
        }
        return array;
    }
}
