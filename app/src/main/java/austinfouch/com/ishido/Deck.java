package austinfouch.com.ishido;

import java.util.Collection;
import java.util.Collections;
import java.util.Vector;

/**
 * Created by TheShadowMarble on 1/30/2018.
 */

public class Deck
{

    private Vector<Tile> tiles;

    public Vector<Tile> getTiles()
    {
        return this.tiles;
    }

    public void setTiles(Vector<Tile> tiles)
    {
        this.tiles = tiles;
    }

    public Deck()
    {
        this.tiles = new Vector<Tile>();
    }

    public Deck(Vector<Tile> tiles)
    {
        this.tiles = tiles;
    }

    public void pop()
    {
        this.tiles.removeElementAt(this.tiles.size() - 1);
    }

    public Tile top()
    {
        return this.tiles.elementAt(this.tiles.size() - 1);
    }

    public void push(Tile t)
    {
        this.getTiles().add(t);
    }

    public void setup()
    {
        // create tiles
        for (int i = 0; i < IshidoConstants.UNQ_TILE_COUNT; i++)
        {
            for (IshidoColor color : IshidoColor.values())
            {
                for (IshidoSymbol symbol : IshidoSymbol.values())
                {
                    Tile t = new Tile(color, symbol);
                    this.push(t);
                }
            }
        }

        Collections.shuffle(this.getTiles());
    }
}
