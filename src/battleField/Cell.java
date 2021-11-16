package battleField;

public class Cell {
    private String coordinate;
    private boolean isFree = true;

    public Cell(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }
}
