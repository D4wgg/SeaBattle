package battlefield;

import java.util.ArrayList;

public class BattleField {
    public static final int SIZE_OF_BATTLE_FIELD_SIDE = 10;
    public static final String ARRAY_OF_LETTERS = "ABCDEFGHIJ";
    public static ArrayList<Cell> battleField = new ArrayList<>();

    private BattleField() {}

    public static void createEmptyBattleField() {
        int counter = 1;
        for(int i = 0; i < SIZE_OF_BATTLE_FIELD_SIDE; i++) {
            for(int j = 0; j < SIZE_OF_BATTLE_FIELD_SIDE; j++) {
                battleField.add(new Cell(ARRAY_OF_LETTERS.substring(j, j + 1), counter));
            }
            counter++;
        }
    }

}
