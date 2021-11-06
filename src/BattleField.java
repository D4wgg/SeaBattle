
public class BattleField {
    public static final int n = 10;
    private String[][] battleField = new String[n + 1][n + 1];

    public void createEmptyBattleField() {
        String alphabet = "ABCDEFGHIJK";
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 && j == 0) battleField[i][j] = " ";
                else if (i == 0) battleField[i][j] = alphabet.substring(j - 1 , j);
                else if (j == 0) battleField[i][j] = i + " ";
                else battleField[i][j] = "~";
            }
        }
        checkBattleFieldCondition();
    }

    public void checkBattleFieldCondition() {
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(battleField[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
