package austinfouch.com.ishido;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**/
/*
    Deck.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Deck class. Holds information related to the deck used in a standard game of Ishido.
            Vector<Tile> m_tiles --> Vector of Tiles, simulating a game deck.

    DATE

        01/30/2018

*/
/**/
public class Deck
{

    private Vector<Tile> m_tiles;

    /**/
    /*
    Deck::Deck()

    NAME

            Deck::Deck - constructor for the Deck class.

    SYNOPSIS

            public Deck::Deck();

    DESCRIPTION

            This function will construct a Deck object. The only member variable of the constructed
            Deck object, m_tiles, is set to be a Vector of Tiles.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Deck()
    {
        this.m_tiles = new Vector<>();
    }

    /**/
    /*
    Deck::getTiles()

    NAME

            Deck::getTiles - getter for the Deck class's m_tiles member variable.

    SYNOPSIS

            public Vector<Tile> Deck::getTiles();

    DESCRIPTION

            This function will return the m_tiles member variable.

    RETURNS

            Vector<Tile>.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Vector<Tile> getTiles()
    {
        return this.m_tiles;
    }

    /**/
    /*
    Deck::Deck()

    NAME

            Deck::Deck - copy constructor for the Deck class.

    SYNOPSIS

            public Deck::Deck(Vector<Tile> a_tiles);
                a_tiles --> Vector<Tile> to set m_tiles to.

    DESCRIPTION

            This function will set m_tiles to a_tiles.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Deck(Vector<Tile> a_tiles)
    {
        this.m_tiles = a_tiles;
    }

    /**/
    /*
    Deck::setTiles()

    NAME

            Deck::setTiles - sett for the Deck class;s m_tiles member variable.

    SYNOPSIS

            public void Deck::setTiles(Vector<Tile> a_tiles);
                a_tiles --> Vector<Tile> to set m_tiles to.

    DESCRIPTION

            This function will set m_tiles to a_tiles.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setTiles(Vector<Tile> a_tiles)
    {
        this.m_tiles = a_tiles;
    }

    /**/
    /*
    Deck::pop()

    NAME

            Deck::pop - removes the last element in m_tiles.

    SYNOPSIS

            public void Deck::pop();

    DESCRIPTION

            Removes the last Tile in the member variable m_tiles.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void pop()
    {
        this.m_tiles.removeElementAt(this.m_tiles.size() - 1);
    }

    /**/
    /*
    Deck::top()

    NAME

            Deck::top - returns the last element in m_tiles.

    SYNOPSIS

            public Tile Deck::top();

    DESCRIPTION

            Returns the last Tile in the member variable m_tiles.

    RETURNS

            Tile.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public Tile top()
    {
        return this.m_tiles.elementAt(this.m_tiles.size() - 1);
    }

    /**/
    /*
    Deck::push()

    NAME

            Deck::push - adds a new tile to m_tiles.

    SYNOPSIS

            public void Deck::top(Tile a_tile);
                a_tile --> Tile added to m_tiles

    DESCRIPTION

           Pushes a_tile to the end of m_tiles.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void push(Tile a_tile)
    {
        this.getTiles().add(a_tile);
    }

    /**/
    /*
    Deck::setup()

    NAME

            Deck::setup - removes the last element in m_tiles.

    SYNOPSIS

            public void Deck::setup();

    DESCRIPTION

            Initializes the Ishido Deck. Creates 72 Tiles, 2 of each unique color + symbol combo and
            shuffles.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setup()
    {
        // Create 2 combos of every IshidoColor and IshidoSymbol as a tile; push to
        for (int i = 0; i < IshidoConstants.UNQ_TILE_COUNT; i++)
        {
            for (IshidoColor color : IshidoColor.values())
            {
                if (color != IshidoColor.BLANK)
                {
                    for (IshidoSymbol symbol : IshidoSymbol.values())
                    {
                        if(symbol != IshidoSymbol.BLANK)
                        {
                            Tile t = new Tile(color, symbol);
                            this.push(t);
                        }
                    }
                }
            }
        }

        Collections.shuffle(this.getTiles());
    }

    /**/
    /*
    Deck::getSetupTiles()

    NAME

            Deck::getSetupTiles - creates a list of 6 Tiles that contains only one of each symbol
                                  and color.

    SYNOPSIS

            public Vector<Tile> Deck::getSetupTiles();

    DESCRIPTION

            Creates a new Vector of Tiles that holds 1 tile for each color and symbol for a total of
            6 tiles, removing these tiles from the deck as they are added to this new Vector.

    RETURNS

            Vector<Tile>.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public Vector<Tile> getSetupTiles()
    {
        Vector<Tile> setupTiles = new Vector<>();
        List<IshidoColor> colorList = new ArrayList<>();
        List<IshidoSymbol> symbolList = new ArrayList<>();

        //  1. check to see if tile color and symbol has been seen before
        //  2. if it has not, add tile to setupTiles, add color/symbol to lists, and remove tile
        //     from deck.
        //  3. go to next tile in deck, repeat
        for(int i = 0; i < m_tiles.size(); i++)
        {
            if(!colorList.contains(m_tiles.get(i).getColor()) &&
                    !symbolList.contains(m_tiles.get(i).getSymbol()))
            {
                setupTiles.add(m_tiles.get(i));
                colorList.add(m_tiles.get(i).getColor());
                symbolList.add(m_tiles.get(i).getSymbol());
                m_tiles.removeElementAt(i);
            }
        }

        return setupTiles;
    }
}
