package austinfouch.com.ishido;

import java.util.Vector;

/**
 * Created by TheShadowMarble on 1/30/2018.
 */

public class Board
{
    private Vector<Vector<Tile>> tiles;

    public Board()
    {
        this.tiles = new Vector<Vector<Tile>>();
    }

    public Board(Vector<Vector<Tile>> tiles)
    {
        this.tiles = tiles;
    }

    public Vector<Vector<Tile>> getTiles()
    {
        return tiles;
    }

    public void setTiles(Vector<Vector<Tile>> tiles)
    {
        this.tiles = tiles;
    }
}
