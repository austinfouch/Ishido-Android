package austinfouch.com.ishido;

// TODO: DOC
public class Player
{
    private Integer m_score;
    private Tile m_currTile;
    private String m_name;

    public Integer isLegalPlay(Tile a_currTile, Board gameBoard, int rowIndex, int colIndex)
    {
        Integer value = 0;
        // check tile match left
        if( colIndex != 0)
        {
            if( a_currTile.isMatch(gameBoard.getTile(rowIndex, colIndex)))
            {
                value++;
            }
        }
        // check tile match right
        if( colIndex != IshidoConstants.NUM_BOARD_COLS - 1)
        {
            if( a_currTile.isMatch(gameBoard.getTile(rowIndex, colIndex)))
            {
                value++;
            }
        }
        // check tile match above
        if( rowIndex != 0)
        {
            if( a_currTile.isMatch(gameBoard.getTile(rowIndex, colIndex)))
            {
                value++;
            }
        }
        // check tile match below
        if( colIndex != IshidoConstants.NUM_BOARD_ROWS - 1)
        {
            if( a_currTile.isMatch(gameBoard.getTile(rowIndex, colIndex)))
            {
                value++;
            }
        }
        // double 4-way match value
        if( value > 3)
        {
            value = value * 2;
        }

        return value;
    }

    public String getName()
    {
        return this.m_name;
    }

    public void setName(String a_name)
    {
        this.m_name = a_name;
    }

    public Integer getScore()
    {
        return this.m_score;
    }

    public void setScore(Integer a_score)
    {
        this.m_score = a_score;
    }

    public Tile getCurrTile()
    {
        return m_currTile;
    }

    public void setCurrTile(Tile a_tile)
    {
        this.m_currTile = a_tile;
    }

    public Player(Integer a_score, Tile a_tile, String a_name)
    {
        this.m_score = a_score;
        this.m_currTile = a_tile;
        this.m_name = a_name;
    }

    public Player()
    {
        this.m_name = new String();
        this.m_currTile = new Tile();
        this.m_score = 0;
    }
}
