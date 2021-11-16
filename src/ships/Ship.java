package ships;

import battleField.*;

public class Ship {
    private int length;
    private Cell cell;

    public Ship(int length) {
        this.length = length;
    }

    public void createShip(String[][] battleField) {
        BattleField bf = new BattleField();
        java.util.Random random = new java.util.Random();

        int letterRatio = random.nextInt(10);
        String letter = bf.ARRAY_OF_LETTERS.substring(letterRatio, letterRatio + 1);
        int digit = random.nextInt(10) + 1;
        String coordinate = letter + digit;

        selectLocationForShip(coordinate, length);
    }


    public void selectLocationForShip(String coordinate, int sizeOfShip) {

    }

}
