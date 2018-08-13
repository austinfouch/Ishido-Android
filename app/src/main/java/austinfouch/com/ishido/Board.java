package austinfouch.com.ishido;

import java.util.Vector;

// TODO: DOC
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

    public void markAsHelp(Integer a_rowIndex, Integer a_colIndex)
    {
        getTile(a_rowIndex, a_colIndex).setSymbol(IshidoSymbol.HELP);
        getTile(a_rowIndex, a_colIndex).setColor(IshidoColor.HELP);
    }

    public Tile getTile(int rowIndex, int colIndex)
    {
        return m_tiles.get(rowIndex).get(colIndex);
    }

    public void setTiles(Vector<Vector<Tile>> a_tiles)
    {
        this.m_tiles = a_tiles;
    }
}
