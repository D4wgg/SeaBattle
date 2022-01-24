package seabattle.skeleton.gameplay;

import seabattle.battlefield.BattleField;
import seabattle.battlefield.Cell;
import seabattle.instrument.CellChecker;
import seabattle.ship.Ship;

import java.util.ArrayList;

public abstract class Player {
    int shotCount;
    final String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract boolean checkHit(String userInput);

    abstract boolean makeHit(String userInput);

    public int getShotCount() {
        return shotCount;
    }
}
