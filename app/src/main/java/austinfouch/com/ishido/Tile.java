package austinfouch.com.ishido;

/**/
/*
    Tile.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Tile class. Hold information related to each Tile used in a standard game of Ishido.
            IshidoColor m_color     --> enumerated 'color' of the tile
            IshidoSymbol m_symbol   --> enumerated 'symbol' of the tile

    DATE

        01/29/2018

*/
/**/
public class Tile
{
    private IshidoColor m_color;
    private IshidoSymbol m_symbol;

    public Tile()
    {
    }

    /**/
    /*
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
    /**/
    public Tile(IshidoColor a_color, IshidoSymbol a_symbol)
    {
        this.m_color = a_color;
        this.m_symbol = a_symbol;
    }

    /**/
    /*
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
    /**/
    public void setColor(IshidoColor a_color)
    {
        this.m_color = a_color;
    }

    /**/
    /*
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
    /**/
    public void setSymbol(IshidoSymbol a_symbol) 
    {
        this.m_symbol = a_symbol;
    }

    /**/
    /*
        Tile::getColor()

        NAME

                Tile::getColor() - getter for the m_color member variable of the Tile class.

        SYNOPSIS

                public void Tile::getColor();

        DESCRIPTION

                This function will return the value of the member variable m_color.

        RETURNS

                Void.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public IshidoColor getColor()
    {
        return this.m_color;
    }

    /**/
    /*
        Tile::getSymbol()

        NAME

                Tile::getSymbol() - getter for the m_symbol member variable of the Tile class.

        SYNOPSIS

                public void Tile::getSymbol();

        DESCRIPTION

                This function will return the value of the member variable m_symbol.

        RETURNS

                Void.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public IshidoSymbol getSymbol()
    {
        return this.m_symbol;
    }

    /**/
    /*
        Tile::isMatch()

        NAME

                Tile::isMatch() - boolean function for determining if a tile matches with this tile.

        SYNOPSIS

                public boolean Tile::isMatch(Tile a_tile);
                    a_tile --> the tile being compared to this tile.

        DESCRIPTION

                This function returns True if the passed tile matches this tile, False otherwise.

        RETURNS

                Boolean.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
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

    /**/
    /*
        Tile::getColorResourceStr()

        NAME

                Tile::getColorResourceStr() - used to determine the resource name associated with
                                              this tile's color

        SYNOPSIS

                public String Tile::getColorResourceStr();

        DESCRIPTION

                This function returns a String value that is the name of a resource associated
                with this tile's color.

        RETURNS

                String.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public String getColorResourceStr()
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

        resIDStr += "blank_tile";
        return resIDStr;
    }

    /**/
    /*
        Tile::getSymbolResourceStr()

        NAME

                Tile::getSymbolResourceStr() - used to determine the resource name associated with
                                              this tile's symbol

        SYNOPSIS

                public String Tile::getSymbolResourceStr();

        DESCRIPTION

                This function returns a String value that is the name of a resource associated
                with this tile's symbol.

        RETURNS

                String.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public String getSymbolResourceStr()
    {
        String resIDStr = "blank_";
        switch(this.m_symbol)
        {
            case BOLT:
                resIDStr += "bolt_";
                break;
            case CIRCLE:
                resIDStr += "circle_";
                break;
            case CROSS:
                resIDStr += "cross_";
                break;
            case HEART:
                resIDStr += "heart_";
                break;
            case MOON:
                resIDStr += "moon_";
                break;
            case STAR:
                resIDStr += "star_";
                break;
            case HELP:
                resIDStr = "help_";
                break;
            default:
                break;
        }

        resIDStr += "tile";
        return resIDStr;
    }
}
