package austinfouch.com.ishido;

/**
 * Author:  Austin Fouch
 * Date:    01/29/2018 10:26 PM
 * Tile.java
 *      Tile class
 */

public class Tile
{
    private IshidoColor m_color;
    private IshidoSymbol m_symbol;

    /*!
    Tile::Tile()

    NAME

            Tile::Tile - constructor for the Tile class.

    SYNOPSIS

            public Tile::Tile( IshidoColor a_color, IshidoSymbol a_symbol );
                a_color  --> the color of the Tile to be constructed.
                a_symbol --> the symbol of the Tile to be constructed.

    DESCRIPTION

            This function will construct a Tile object. The member variables of the constructed Tile
            object, m_color and m_symbol, are set to the values of the respective parameters,
            a_color and a_symbol.

            The values are enumerated and defined in the IshidoColor and IshidoSymbol classes. The
            values, combined as "color_symbol", correspond to PNG files in the res/drawable
            directory.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            10:26pm 1/29/2018

    */
    public Tile(IshidoColor a_color, IshidoSymbol a_symbol)
    {
        this.m_color = a_color;
        this.m_symbol = a_symbol;
    }

    /*!
    Tile::setColor()

    NAME

            Tile::setColor() - setter for the m_color member variable of the Tile class.

    SYNOPSIS

            public void Tile::setColor( IshidoColor a_color);
                a_symbol --> the symbol to set m_color to.

    DESCRIPTION

            This function will assign the value of the member variable m_color to the value of the
            parameter a_color.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            10:26pm 1/29/2018

    */
    public void setColor(IshidoColor a_color)
    {
        this.m_color = a_color;
    }

    /*!
        Tile::setSymbol()

        NAME

                Tile::setSymbol() - setter for the m_symbol member variable of the Tile class.

        SYNOPSIS

                public void Tile::setSymbol( IshidoSymbol a_symbol);
                    a_symbol --> the symbol to set m_symbol to.

        DESCRIPTION

                This function will assign the value of the member variable m_symbol to the value of
                the parameter a_symbol.

        RETURNS

                Void.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    public void setSymbol(IshidoSymbol a_symbol) 
    {
        this.m_symbol = a_symbol;
    }

    /*!
        Tile::setSymbol()

        NAME

                Tile::setSymbol() - setter for the m_symbol member variable of the Tile class.

        SYNOPSIS

                public void Tile::setSymbol( IshidoSymbol a_symbol);
                    a_symbol --> the symbol to set m_symbol to.

        DESCRIPTION

                This function will assign the value of the member variable m_symbol to the value of
                the parameter a_symbol.

        RETURNS

                Void.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    public IshidoColor getColor()
    {
        return this.m_color;
    }

    public IshidoSymbol getSymbol()
    {
        return this.m_symbol;
    }

    public boolean isMatch(Tile a_tile)
    {
        if(this.m_color == a_tile.getColor())
        {
            return true;
        }
        else if(this.m_symbol == a_tile.getSymbol())
        {
            return true;
        }
        else
        {
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
    public int getResourceID()
    {
        String resIDStr = "";
        switch(this.m_color)
        {
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

        switch(this.m_symbol)
        {
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
