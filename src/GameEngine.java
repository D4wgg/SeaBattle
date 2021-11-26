import battleField.BattleField;
import ships.GameSettings;

public class GameEngine {
    private GameEngine() {}

    public static void startGame() {
        BattleField.createEmptyBattleField();

        System.out.println("Привет дружбанчик, играем в морской бой ....");
        System.out.println("Правила таковы : ......");

        GameSettings.loadSettings();
        //neposredstvennoGameplay();
    }

    private void neposredstvennoGameplay() {

    }
}
