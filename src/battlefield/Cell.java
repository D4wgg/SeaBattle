package battlefield;

public class Cell {
    private String letter;
    private int digit;
    private boolean isFree = true;
    private boolean gotShot = false;

    public Cell(String letter, int digit) {
        this.letter = letter;
        this.digit = digit;
    }

    public String getLetter() {
        return letter;
    }

    public int getDigit() {
        return digit;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public boolean isGotShot() {
        return gotShot;
    }

    public void setGotShot(boolean gotShot) {
        this.gotShot = gotShot;
    }
}
