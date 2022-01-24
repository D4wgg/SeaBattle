package seabattle.ship;

import seabattle.battlefield.Cell;

import java.util.ArrayList;

public class Ship {
    private ArrayList<Cell> shipLocation = new ArrayList<>();

    public Ship(ArrayList<Cell> shipLocation) {
        this.shipLocation = shipLocation;
    }

    public ArrayList<Cell> getShipLocation() {
        return shipLocation;
    }
}
