package ships;

public enum ShipList {
    SMALL(1, 4), MIDDLE(2, 3), BIG(3, 2),
    HUGE(4, 1);

    ShipList(int deckCount, int shipsQuantity) {
        this.deckCount = deckCount;
        this.shipsQuantity = shipsQuantity;
    }

    private final int deckCount;
    private final int shipsQuantity;

    public int getDeckCount() {
        return deckCount;
    }

    public int getShipsQuantity() {
        return shipsQuantity;
    }
}
