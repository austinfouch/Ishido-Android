package austinfouch.com.ishido;

import java.util.Vector;

/**/
/*
    Activity.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        ActivityLog class. Holds data representing the last Turn's taken by both the Human and
        Computer players. If Solitaire, the Computer's data will always be "".

    DATE

        01/30/2018

*/
/**/
public class ActivityLog
{
    private String m_playerOneTurn;
    private String m_playerTwoTurn;

    /**/
    /*
    ActivityLog::ActivityLog()

    NAME

            ActivityLog::ActivityLog - constructor for the ActivityLog class.

    SYNOPSIS

            public ActivityLog::ActivityLog();

    DESCRIPTION

            This function will construct an ActivityLog object. The member variables of the object
            will represent the last turn's taken by each player.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public ActivityLog()
    {
        m_playerOneTurn = new String();
        m_playerTwoTurn = new String();
    }

    /**/
    /*
    ActivityLog::ActivityLog()

    NAME

            ActivityLog::ActivityLog - copy constructor for the ActivityLog class.

    SYNOPSIS

            public ActivityLog::ActivityLog(String a_playerOneTurn, String a_playerTwoTurn);
                a_playerOneTurn --> value to set m_playerOneTurn to.
                a_playerTwoTurn --> value to set m_playerTwoTurn to.

    DESCRIPTION

            This function will construct an ActivityLog object given data representing the last
            turns taken by the two players.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public ActivityLog(String a_playerOneTurn, String a_playerTwoTurn)
    {
        m_playerOneTurn = a_playerOneTurn;
        m_playerTwoTurn = a_playerTwoTurn;
    }

    /**/
    /*
    ActivityLog::getPlayerOneTurn()

    NAME

            ActivityLog::getPlayerOneTurn - getter for the m_playerOneTurn member variable.

    SYNOPSIS

            public String ActivityLog::getPlayerOneTurn();

    DESCRIPTION

            This function will return the m_playerOneTurn member variable.

    RETURNS

            String.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public String getPlayerOneTurn()
    {
        return m_playerOneTurn;
    }

    /**/
    /*
    ActivityLog::setPlayerOneTurn()

    NAME

            ActivityLog::setPlayerOneTurn - setter for the m_playerOneTurn member variable.

    SYNOPSIS

            public void ActivityLog::setPlayerOneTurn(String a_playerOneTurn);
                a_playerOneTurn --> value to set m_playerOneTurn to.

    DESCRIPTION

            This function will set the m_playerOneTurn member variable to the given String value.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setPlayerOneTurn(String a_playerOneTurn)
    {
        this.m_playerOneTurn = a_playerOneTurn;
    }

    /**/
    /*
    ActivityLog::getPlayerTwoTurn()

    NAME

            ActivityLog::getPlayerTwoTurn - getter for the m_playerTwoTurn member variable.

    SYNOPSIS

            public String ActivityLog::getPlayerTwoTurn();

    DESCRIPTION

            This function will return the m_playerTwoTurn member variable.

    RETURNS

            String.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public String getPlayerTwoTurn()
    {
        return m_playerTwoTurn;
    }


    /**/
    /*
    ActivityLog::setPlayerTwoTurn()

    NAME

            ActivityLog::setPlayerTwoTurn - setter for the m_playerTwoTurn member variable.

    SYNOPSIS

            public void ActivityLog::setPlayerTwoTurn(String a_playerTwoTurn);
                a_playerTwoTurn --> value to set m_playerTwoTurn to.

    DESCRIPTION

            This function will set the m_playerTwoTurn member variable to the given String value.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setPlayerTwoTurn(String a_playerTwoTurn)
    {
        this.m_playerTwoTurn = a_playerTwoTurn;
    }
}
