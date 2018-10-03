package austinfouch.com.ishido;

import java.util.Vector;

/**/
/*
    Board.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Board class. Hold information related to the board used in a standard game of Ishido.
            Vector<Vector<Tile>> m_tiles --> 2D Vector of Tiles, simulating a game board.

    DATE

        01/30/2018

*/
/**/
public class Board
{
    private Vector<Vector<Tile>> m_tiles;

    /**/
    /*
    Board::Board()

    NAME

            Board::Board - constructor for the Board class.

    SYNOPSIS

            public Board::Board();

    DESCRIPTION

            This function will construct a Board object. The only member variable of the constructed
            Board object, m_tiles, is set to be a 2D Vector of Tiles filled with blank tiles.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Board()
    {
        m_tiles = new Vector<>();
        for(int row = 0; row < IshidoConstants.NUM_BOARD_ROWS; row++)
        {
            Vector<Tile> tempTiles = new Vector<>();
            for(int col = 0; col < IshidoConstants.NUM_BOARD_COLS; col++)
            {
                Tile tempTile = new Tile(IshidoColor.BLANK, IshidoSymbol.BLANK);
                tempTiles.add(tempTile);
            }

            m_tiles.add(tempTiles);
        }
    }

    /**/
    /*
    Board::Board()

    NAME

            Board::Board - copy constructor for the Board class.

    SYNOPSIS

            public Board::Board(Vector<Vector<Tile>> a_tiles);
                a_tiles --> 2D Vector of tiles to set m_tiles to.

    DESCRIPTION

            This function will construct a Board object. The only member variable of the constructed
            Board object, m_tiles, is set to be a copy of a_tiles, a2D Vector of Tiles.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Board(Vector<Vector<Tile>> a_tiles)
    {
        this.m_tiles = a_tiles;
    }

    /**/
    /*
    Board::getTiles()

    NAME

            Board::getTiles - getter for the Board's tiles.

    SYNOPSIS

            public Board::getTiles();

    DESCRIPTION

            This function returns the Board's member variable, m_tiles.

    RETURNS

            Vector<Vector<Tile>>.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Vector<Vector<Tile>> getTiles()
    {
        return m_tiles;
    }

    /**/
    /*
    Board::getTile()

    NAME

            Board::getTile - returns a Tile object from the specified row and column.

    SYNOPSIS

            public Board::getTile(int a_row, int a_col);
                a_row --> row index of the tile
                a_col --> col index of the tile

    DESCRIPTION

            This function returns a Tile object from the specified col and row.

    RETURNS

            Tile.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Tile getTile(int a_row, int a_col)
    {
        return m_tiles.get(a_row).get(a_col);
    }

    /**/
    /*
    Board::setTile()

    NAME

            Board::setTile - sets the Tile object from the specified row and column to the passed
                            Tile.

    SYNOPSIS

            public Board::setTile(int a_row, int a_col, Tile tile);
                a_row   --> row index of the tile
                a_col   --> col index of the tile
                a_tile  --> Tile which the specified Tile will be set to.

    DESCRIPTION

            This function sets the Tile at a_row, a_col in m_tiles to a_tile.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setTile(int a_row, int a_col, Tile a_tile)
    {
        getTiles().get(a_row).set(a_col, a_tile);
    }

    /**/
    /*
    Board::setTiles()

    NAME

            Board::setTiles - setter for the m_tiles member variable.

    SYNOPSIS

            public Board::setTiles(Vector<Vector<Tile>> a_tiles);
                a_tiles  --> Tiles which m_tiles will be set to.

    DESCRIPTION

            This function sets the m_tiles to a_tiles.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setTiles(Vector<Vector<Tile>> a_tiles)
    {
        this.m_tiles = a_tiles;
    }
}
