
public class Ships {
    public static final int countOfHugeShips = 1;
    public static final int countOfBigShips = 2;
    public static final int countOfMiddleShips = 3;
    public static final int countOfSmallShips = 4;

    public void placeShips() {
        java.util.Random random = new java.util.Random();
        if (checkIfPossible(random.nextInt())) new Ships();
    }

    public boolean checkIfPossible(int random) {
        return ();
    }
}
