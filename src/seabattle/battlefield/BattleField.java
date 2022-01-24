package seabattle.battlefield;

import java.util.ArrayList;

public class BattleField {
    public static final int SIZE_OF_BATTLE_FIELD_SIDE = 10;
    public static final String ARRAY_OF_LETTERS = "ABCDEFGHIJ";
    private static ArrayList<Cell> enemyField = BattleFieldFactory.createEmptyBattleField();
    private static ArrayList<Cell> userField = BattleFieldFactory.createEmptyBattleField();

    private BattleField() {}

    public static ArrayList<Cell> getEnemyField() {
        return enemyField;
    }
    public static ArrayList<Cell> getUserField() {
        return userField;
    }
}
