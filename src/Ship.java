
public class Ship extends Cells {
    public final int LENGTH_OF_HUGE_SHIP = 4;
    public final int LENGTH_OF_BIG_SHIP = 3;
    public final int LENGTH_OF_MIDDLE_SHIP = 2;
    public final int LENGTH_OF_SMALL_SHIP = 1;

    public Ship(String coordinate) {
        super(coordinate);
    }

    public void createShip(String[][] battleField) {
        BattleField bf = new BattleField();
        java.util.Random random = new java.util.Random();
        int letterRatio = random.nextInt(10);
        String letter = bf.ARRAY_OF_LETTERS.substring(letterRatio, letterRatio + 1);
        int digit = random.nextInt(10) + 1;
        String coordinate = letter + digit;
    }

}
