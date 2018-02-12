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
    /**************************************************************************
     Function Name: getResourceID
     Purpose:
     Determine the resource image id that corresponds with the tile parameter
     Paramaters:
     t, the tile used to determine the correct resource image id
     Return Value:
     Integer value representing the resource image id that matched the tile
     parameter
     Assistance Received: None.
     **************************************************************************/
    public int getResourceID() {
        String resIDStr = "";
        switch(color) {
            case WHITE:
                resIDStr = "white_";
                break;
            case BLACK:
                resIDStr = "black_";
                break;
            case BLUE:
                resIDStr = "blue_";
                break;
            case GREEN:
                resIDStr = "green_";
                break;
            case RED:
                resIDStr = "red_";
                break;
            case YELLOW:
                resIDStr = "yellow_";
                break;
            default:
                break;
        }

        switch(symbol) {
            case SYM_1:
                resIDStr +=  "blank_tile";
                break;
            case SYM_2:
                resIDStr += "blank_tile";
                break;
            case SYM_3:
                resIDStr += "blank_tile";
                break;
            case SYM_4:
                resIDStr += "blank_tile";
                break;
            case SYM_5:
                resIDStr += "blank_tile";
                break;
            case SYM_6:
                resIDStr += "blank_tile";
                break;
            default:
                break;
        }

        int id = IshidoConstants.getResId(resIDStr, R.drawable.class);
        return id;
    }
}
