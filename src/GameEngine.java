import battleField.BattleField;

public class GameEngine {
    public void startGame() {
        BattleField bf = new BattleField();
        bf.createEmptyBattleField();

        System.out.println("Привет дружбанчик, играем в морской бой ....");
        System.out.println("Правила таковы : ......");

        neposredstvennoGameplay();
    }

    private void neposredstvennoGameplay() {

    }
}
