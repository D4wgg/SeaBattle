package seabattle.skeleton.mode;

import seabattle.battlefield.BattleField;
import seabattle.instrument.CreationShipNearAnotherOneBan;
import seabattle.ship.ShipFactory;
import seabattle.ship.ShipQuantitySettings;

public class RealDuelVsBot extends seabattle.skeleton.mode.GameMode {
    @Override
    public void startGame() {
        ShipQuantitySettings.loadSettings();

        // если вдруг корабль не создастся, мы запустим метод еще раз с новой координатой.И так до тех пор,
        // пока все корабли не будут расположены на игровой доске
        while (!putShipOnField(ShipFactory.getRandomCoordinate(), BattleField.getEnemyField(),
                ShipFactory.getPlacedOnFieldEnemyShips())) {
            CreationShipNearAnotherOneBan.guardCellsAroundShip(ShipFactory.getPlacedOnFieldEnemyShips());
            // пометили клетки вокруг кораблей, что они заняты, туда нельзя ставить другие корабли
            putShipOnField(ShipFactory.getRandomCoordinate(), BattleField.getEnemyField(),
                    ShipFactory.getPlacedOnFieldEnemyShips());
        } //разместили корабли оппонента на его поле

        while (!putShipOnField(ShipFactory.getUserWishCoordinate(), BattleField.getUserField(),
                ShipFactory.getPlacedOnFieldPlayerShips())) {
            CreationShipNearAnotherOneBan.guardCellsAroundShip(ShipFactory.getPlacedOnFieldPlayerShips());
            // пометили клетки вокруг кораблей, что они заняты, туда нельзя ставить другие корабли
            putShipOnField(ShipFactory.getRandomCoordinate(), BattleField.getEnemyField(),
                    ShipFactory.getPlacedOnFieldEnemyShips());
        } // разместили корабли игрока на его поле
        gameplay();
    }

    @Override
    public void gameplay() {
        while (!ShipFactory.getPlacedOnFieldPlayerShips().isEmpty() && !ShipFactory.getPlacedOnFieldEnemyShips().isEmpty()) {
            System.out.println("Твой ход, браза!");
            makeShot(ShipFactory.getPlacedOnFieldEnemyShips(), user);
            System.out.println("Ход ботяры попущеного");
            makeShot(ShipFactory.getPlacedOnFieldPlayerShips(), bot);
        }
    }

}
