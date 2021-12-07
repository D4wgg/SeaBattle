package ships;

import battlefield.Cell;

import java.util.ArrayList;

public class Ship {
    private int length;
    private ArrayList<Cell> shipLocation = new ArrayList<>();

    public Ship(ArrayList<Cell> shipLocation) {
        this.shipLocation = shipLocation;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<Cell> getShipLocation() {
        return shipLocation;
    }

    public void setShipLocation(ArrayList<Cell> shipLocation) {
        this.shipLocation = shipLocation;
    }
}
