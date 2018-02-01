package austinfouch.com.ishido;

/**
 * Author:  Austin Fouch
 * Date:    01/29/2018 10:26 PM
 * Tile.java
 *      Tile class
 */

public class Tile {
    private int color;
    private int symbol;

    public Tile(int color, int symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public boolean isMatch(Tile t) {
        if(color == t.getColor()) {
            return true;
        }
        else if(symbol == t.getSymbol()) {
            return true;
        } else {
            return false;
        }
    }
}
