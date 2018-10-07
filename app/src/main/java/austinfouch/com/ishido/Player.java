package austinfouch.com.ishido;

/**/
/*
    Player.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Player class. Holds name and score data and a function for determining a legal play.

    DATE

        01/30/2018

*/
/**/
public class Player
{
    private Integer m_score;
    private String m_name;

    /**/
    /*
    Player::isLegalPlay()

    NAME

            Player::isLegalPlay - given a Tile, Board.

    SYNOPSIS

            public Player::setScore(Integer a_score);
                a_score --> Integer value to set m_score to.

    DESCRIPTION

            This function will return an Integer value which represents the value of playing
            the given Tile object on the given Board object at the given position.

            If the value is greater than 0, the play can be interpreted as legal.

            If the value is 0, the play is illegal.

    RETURNS

            Integer.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Integer isLegalPlay(Tile a_currTile, Board a_board, int a_row, int a_col)
    {
        // if tile is not blank
        if(a_board.getTile(a_row,  a_col).getSymbol() != IshidoSymbol.BLANK)
        {
            return 0;
        }

        Integer value = 0;
        // check tile match left
        if( a_col != 0)
        {
            if( a_currTile.isMatch(a_board.getTile(a_row, a_col - 1)))
            {
                value++;
            }
        }
        // check tile match right
        if( a_col != IshidoConstants.NUM_BOARD_COLS - 1)
        {
            if( a_currTile.isMatch(a_board.getTile(a_row, a_col + 1)))
            {
                value++;
            }
        }
        // check tile match above
        if( a_row != 0)
        {
            if( a_currTile.isMatch(a_board.getTile(a_row - 1, a_col)))
            {
                value++;
            }
        }
        // check tile match below
        if( a_row != IshidoConstants.NUM_BOARD_ROWS - 1)
        {
            if( a_currTile.isMatch(a_board.getTile(a_row + 1, a_col)))
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

    /**/
    /*
    Player::getName()

    NAME

            Player::getName - getter for the m_name member variable.

    SYNOPSIS

            public Player::getName();

    DESCRIPTION

            This function will return the m_name member variable.

    RETURNS

            String.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public String getName()
    {
        return this.m_name;
    }

    /**/
    /*
    Player::setName()

    NAME

            Player::setName - setter for the m_name member variable.

    SYNOPSIS

            public Player::setName(String a_name);
                a_name --> String value to set m_name to.

    DESCRIPTION

            This function will set the n_name member variable to the value of a_name.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setName(String a_name)
    {
        this.m_name = a_name;
    }

    /**/
    /*
    Player::getScore()

    NAME

            Player::getScore - getter for the m_score member variable.

    SYNOPSIS

            public Player::getScore();

    DESCRIPTION

            This function will return the m_score member variable.

    RETURNS

            Integer.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Integer getScore()
    {
        return this.m_score;
    }

    /**/
    /*
    Player::setScore()

    NAME

            Player::setScore - setter for the m_score member variable.

    SYNOPSIS

            public Player::setScore(Integer a_score);
                a_score --> Integer value to set m_score to.

    DESCRIPTION

            This function will set the m_score member variable to the value of a_score.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setScore(Integer a_score)
    {
        this.m_score = a_score;
    }

    /**/
    /*
    Player::Player()

    NAME

            Player::Player - copy constructor for the Player class.

    SYNOPSIS

            public Player::Player(String a_name, Integer a_score);
                a_name  --> String value to set m_name to.
                a_score --> Integer value to set m_score to.

    DESCRIPTION

            This function will construct a Player object given String and Integer values.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Player(String a_name, Integer a_score)
    {
        this.m_name = a_name;
        this.m_score = a_score;
    }


    /**/
    /*
    Player::Player()

    NAME

            Player::Player - constructor for the Player class.

    SYNOPSIS

            public Player::Player();

    DESCRIPTION

            This function will construct a Player object.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Player()
    {
        this.m_name = new String();
        this.m_score = 0;
    }
}
