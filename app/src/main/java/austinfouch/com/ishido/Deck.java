package austinfouch.com.ishido;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

// TODO: DOC
public class Deck
{

    private Vector<Tile> m_tiles;

    public Deck()
    {
        this.m_tiles = new Vector<>();
    }

    public Vector<Tile> getTiles()
    {
        return this.m_tiles;
    }

    public Deck(Vector<Tile> a_tiles)
    {
        this.m_tiles = a_tiles;
    }

    public void setTiles(Vector<Tile> a_tiles)
    {
        this.m_tiles = a_tiles;
    }

    public void pop()
    {
        this.m_tiles.removeElementAt(this.m_tiles.size() - 1);
    }

    public Tile top()
    {
        return this.m_tiles.elementAt(this.m_tiles.size() - 1);
    }

    public void push(Tile t)
    {
        this.getTiles().add(t);
    }

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
