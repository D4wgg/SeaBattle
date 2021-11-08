import java.util.ArrayList;

public class BattleField {
    public static final int SIZE_OF_BATTLE_FIELD_SIDE = 10;
    public final String ARRAY_OF_LETTERS = "ABCDEFGHIJ";
    private ArrayList<Cells> battleField = new ArrayList<>();

    public void createEmptyBattleField() {
        int counter = 1;
        for(int i = 0; i < SIZE_OF_BATTLE_FIELD_SIDE; i++) {
            for(int j = 0; j < SIZE_OF_BATTLE_FIELD_SIDE; j++) {
                battleField.add(new Cells(ARRAY_OF_LETTERS.substring(j, j + 1) + counter));
            }
            counter++;
        }

    }


    public void checkBattleFieldCondition() {
        for(Cells cells : battleField) {
            System.out.println(cells.getCoordinate());
        }
    }

    public ArrayList<Cells> getBattleField() {
        return battleField;
    }



}
