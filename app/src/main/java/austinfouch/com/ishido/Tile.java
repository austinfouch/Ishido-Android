package austinfouch.com.ishido;

/**
 * Author:  Austin Fouch
 * Date:    01/29/2018 10:26 PM
 * Tile.java
 *      Tile class
 */

public class Tile {
    private IshidoColor color;
    private IshidoSymbol symbol;

    public Tile(IshidoColor color, IshidoSymbol symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public void setColor(IshidoColor color) {
        this.color = color;
    }

    public void setSymbol(IshidoSymbol symbol) {
        this.symbol = symbol;
    }

    public IshidoColor getColor() {
        return color;
    }

    public IshidoSymbol getSymbol() {
        return symbol;
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
