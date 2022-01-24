package seabattle.skeleton.gameplay;

import seabattle.skeleton.mode.GameMode;

public class GameEngine {
    GameMode gameMode;

    public GameEngine(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void startGame() {
        gameMode.startGame();
    }
}
