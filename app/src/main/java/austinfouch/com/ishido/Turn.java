package austinfouch.com.ishido;

/**/
/*
    Turn.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Turn class. Hold information related to each Turn taken in a standard game of Ishido.
            Tile m_tilePlayed       --> the tile played.
            Integer m_rowPlayed     --> the row the tile was played on.
            Integer m_colPlayed     --> the column the tile was played on.
            String m_playerName     --> the Player name who played the tile.
            Integer m_pointsScored  --> the points gained by the play.

    DATE

        01/29/2018

*/
/**/
public class Turn
{
    private Tile m_tilePlayed;
    private Integer m_rowPlayed;
    private Integer m_colPlayed;
    private String m_playerName;
    private Integer m_pointsScored;

    /**/
    /*
        Turn::Turn()

        NAME

                Turn::Turn - default constructor for the Turn class.

        SYNOPSIS

                public Turn::Turn();

        DESCRIPTION

                This function creates a Turn object.

        RETURNS

                No return value.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public Turn()
    {
    }

    /**/
    /*
        Turn::Turn()

        NAME

                Turn::Turn - copy constructor for the Turn class.

        SYNOPSIS

                public Turn::Turn(Tile a_tilePlayed, Integer a_rowPlayed, Integer a_colPlayed,
                                    String a_playerName, Integer a_pointsScored);
                    Tile m_tilePlayed       --> the tile played.
                    Integer m_rowPlayed     --> the row the tile was played on.
                    Integer m_colPlayed     --> the column the tile was played on.
                    String m_playerName     --> the Player name who played the tile.
                    Integer m_pointsScored  --> the points gained by the play.

        DESCRIPTION

                This function creates a Turn object given values for each of a Turn object's member
                variables.

        RETURNS

                No return value.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public Turn(Tile a_tilePlayed, Integer a_rowPlayed, Integer a_colPlayed, String a_playerName,
                Integer a_pointsScored)
    {
        this.m_tilePlayed = a_tilePlayed;
        this.m_rowPlayed = a_rowPlayed;
        this.m_colPlayed = a_colPlayed;
        this.m_playerName = a_playerName;
        this.m_pointsScored = a_pointsScored;
    }

    /**/
    /*
        Turn::getPointsScored()

        NAME

                Turn::getPointsScored - getter for the m_pointsScored member variable.

        SYNOPSIS

                public Integer Turn::getPointsScored();

        DESCRIPTION

                This function returns the m_pointsScored member variable.

        RETURNS

                Integer.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public Integer getPointsScored()
    {
        return m_pointsScored;
    }

    /**/
    /*
        Turn::getTilePlayed()

        NAME

                Turn::getTilePlayed - getter for the m_tilePlayed member variable.

        SYNOPSIS

                public Integer Turn::getTilePlayed();

        DESCRIPTION

                This function returns the m_tilePlayed member variable.

        RETURNS

                Tile.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public Tile getTilePlayed()
    {
        return m_tilePlayed;
    }

    /**/
    /*
        Turn::getRowPlayed()

        NAME

                Turn::getRowPlayed - getter for the m_rowPlayed member variable.

        SYNOPSIS

                public Integer Turn::getRowPlayed();

        DESCRIPTION

                This function returns the m_rowPlayed member variable.

        RETURNS

                Integer.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public Integer getRowPlayed()
    {
        return m_rowPlayed;
    }

    /**/
    /*
        Turn::getColPlayed()

        NAME

                Turn::getColPlayed - getter for the m_colPlayed member variable.

        SYNOPSIS

                public Integer Turn::getColPlayed();

        DESCRIPTION

                This function returns the m_colPlayed member variable.

        RETURNS

                Integer.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public Integer getColPlayed()
    {
        return m_colPlayed;
    }

    /**/
    /*
        Turn::getPlayerName()

        NAME

                Turn::getPlayerName - getter for the m_playerName member variable.

        SYNOPSIS

                public String Turn::getPlayerName();

        DESCRIPTION

                This function returns the m_playerName member variable.

        RETURNS

                String.

        AUTHOR

                Austin Fouch

        DATE

                10:26pm 1/29/2018

    */
    /**/
    public String getPlayerName()
    {
        return m_playerName;
    }
}
