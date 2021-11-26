package battleField;

public class Cell {
    private String letter;
    private int digit;
    private boolean isFree = true;

    public Cell(String letter, int digit) {
        this.letter = letter;
        this.digit = digit;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getDigit() {
        return digit;
    }

    public void setDigit(int digit) {
        this.digit = digit;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
