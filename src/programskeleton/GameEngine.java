package programskeleton;

import battlefield.BattleField;
import ships.GameSettings;
import ships.ShipFactory;
import gameplay.UserGuess;

public class GameEngine {
    private GameEngine() {}

    public static void startGame() {
        BattleField.createEmptyBattleField();

        System.out.println("Привет дружбанчик, играем в морской бой ....");
        System.out.println("Правила таковы : ......");

        ShipFactory.createShip(GameSettings.loadSettings());
        gameplay();
    }

    private static void gameplay() {
        while (!ShipFactory.getPlacedOnDeckShips().isEmpty()) {
            UserGuess.checkHit();
        }
        int shotCount = UserGuess.getShotCount();
        int hit = UserGuess.getHit();
        float accuracy = (float) shotCount / hit;

        finishGame(shotCount, accuracy + "%");
    }

    public static void finishGame(int shotCount, String accuracy) {
        System.out.println("Игра окончена!");
        System.out.println("Количество Ваших попыток " + shotCount + " а ваша точность " + accuracy);
    }
}
