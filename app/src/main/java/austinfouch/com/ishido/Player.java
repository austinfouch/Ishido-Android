package austinfouch.com.ishido;

// TODO: DOC
public class Player
{
    private Integer m_score;
    private String m_name;

    public Integer isLegalPlay(Tile a_currTile, Board a_board, int a_row, int a_col)
    {
        int points = 0;
        // check tile match left
        if( a_col != 0)
        {
            if( a_currTile.isMatch(a_board.getTile(a_row, a_col)))
            {
                points++;
            }
        }
        // check tile match right
        if( a_col != IshidoConstants.NUM_BOARD_COLS - 1)
        {
            if( a_currTile.isMatch(a_board.getTile(a_row, a_col)))
            {
                points++;
            }
        }
        // check tile match above
        if( a_row != 0)
        {
            if( a_currTile.isMatch(a_board.getTile(a_row, a_col)))
            {
                points++;
            }
        }
        // check tile match below
        if( a_col != IshidoConstants.NUM_BOARD_ROWS - 1)
        {
            if( a_currTile.isMatch(a_board.getTile(a_row, a_col)))
            {
                points++;
            }
        }
        // double 4-way match points
        if( points > 3)
        {
            points = points * 2;
        }

        return points;
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

    public Player(String a_name, Integer a_score)
    {
        this.m_name = a_name;
        this.m_score = a_score;
    }

    public Player()
    {
        this.m_name = new String();
        this.m_score = 0;
    }
}
