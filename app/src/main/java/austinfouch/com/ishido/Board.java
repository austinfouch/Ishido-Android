package austinfouch.com.ishido;

import java.util.Vector;

public class Board
{
    private Vector<Vector<Tile>> m_tiles;

    public Board()
    {
        this.m_tiles = new Vector<Vector<Tile>>();
    }

    public Board(Vector<Vector<Tile>> a_tiles)
    {
        this.m_tiles = a_tiles;
    }

    public Vector<Vector<Tile>> getTiles()
    {
        return m_tiles;
    }

    public void setTiles(Vector<Vector<Tile>> a_tiles)
    {
        this.m_tiles = a_tiles;
    }
}
