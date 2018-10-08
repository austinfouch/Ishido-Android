package austinfouch.com.ishido;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.Vector;

/**/
/*
    Game.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Game class. This data structure acts the the Game model for the Game Activity class. All
        dynamic aspects of the screen are drawn using this class.

    DATE

        01/30/2018

*/
/**/
public class Game
{
    private Tile m_currTile;
    private Deck m_deck;
    private Board m_board;
    private ActivityLog m_log;
    private Player m_playerOne;
    private Player m_playerTwo;

    /**/
    /*
    Game::Game()

    NAME

            Game::Game - constructor for the Game class.

    SYNOPSIS

            public Game::Game();

    DESCRIPTION

            This function will construct a Game object. The member variables initialized in this
            function are m_currTile, m_deck, m_board, m_log, m_playerOne and m_playerTwo.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Game()
    {
        this.m_currTile = new Tile();
        this.m_deck = new Deck();
        this.m_board = new Board();
        this.m_log = new ActivityLog();
        this.m_playerOne = new Human();
        this.m_playerTwo = new Computer();
    }

    /**/
    /*
    Game::Game()

    NAME

            Game::Game - copy constructor for the Game class.

    SYNOPSIS

            public Game::Game(Tile a_currTile, Deck a_deck, Board a_board, ActivityLog a_log,
                        Player a_playerOne, Player a_playerTwo);
                a_currTile  --> Tile object to set m_currTile to.
                a_deck      --> Deck object to set m_deck to.
                a_board     --> Board object to set m_board to.
                a_log       --> ActivityLog object to set m_log to.
                a_playerOne --> Player object to set m_playerOne to.
                a_playerTwo --> Player object ot set m_playerTwo to.

    DESCRIPTION

            This function will construct a Game object. The member variables initialized in this
            function are m_currTile, m_deck, m_board, m_log, m_playerOne and m_playerTwo.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Game(Tile a_currTile, Deck a_deck, Board a_board, ActivityLog a_log, Player a_playerOne,
                Player a_playerTwo)
    {
        this.m_currTile = a_currTile;
        this.m_deck = a_deck;
        this.m_board = a_board;
        this.m_log = a_log;
        this.m_playerOne = a_playerOne;
        this.m_playerTwo = a_playerTwo;
    }

    /**/
    /*
    Game::calculateScore()

    NAME

            Game::calculateScore - calculate the score of the given Ishido play.

    SYNOPSIS

            public Game::calculateScore(Tile a_currTile, Board a_board, int a_row, int a_col);
                a_currTile  --> Tile object used to determine score.
                a_board     --> Board object used to place Tile object on and determine score.
                a_row       --> int representing the row where the Tile object is being played on
                                the Board object.
                a_col       --> int representing the column where the Tile object is being played on
                                the Board object.

    DESCRIPTION

            This function will calculate the score of an attempted play in an Ishido game. This is
            accomplished by using the given Tile and Board objects, placing the Tile on the Board
            at the given row and column position, and calculating the score produced. This score
            is then returned as an Integer value.

    RETURNS

            Integer.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Integer calculateScore(Tile a_currTile, Board a_board, int a_row, int a_col)
    {
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
    Game::getCurrTile()

    NAME

            Game::getCurrTile - getter for the Game object's m_currTile member variable.

    SYNOPSIS

            public Game::getCurrTile();

    DESCRIPTION

            This function returns the Game's member variable, m_currTile.

    RETURNS

            Tile.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Tile getCurrTile()
    {
        return m_currTile;
    }

    /**/
    /*
    Game::setCurrTile()

    NAME

            Game::setCurrTile - setter for the Game object's m_currTile member variable.

    SYNOPSIS

            public Game::setCurrTile(Tile a_currTile);
                a_currTile --> Tile object to set m_currTile to.

    DESCRIPTION

            This function sets the Game's member variable, m_currTile, to the given Tile.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setCurrTile(Tile a_currTile)
    {
        this.m_currTile = a_currTile;
    }

    /**/
    /*
    Game::getDeck()

    NAME

            Game::getDeck - getter for the Game object's m_deck member variable.

    SYNOPSIS

            public Game::getDeck();

    DESCRIPTION

            This function returns the Game's member variable, m_deck.

    RETURNS

            Deck.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Deck getDeck()
    {
        return m_deck;
    }

    /**/
    /*
    Game::setDeck()

    NAME

            Game::setDeck - setter for the Game object's m_deck member variable.

    SYNOPSIS

            public Game::setDeck(Deck a_deck);
                a_deck --> Deck object to set m_deck to.

    DESCRIPTION

            This function sets the Game's member variable, m_deck, to the given Deck variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setDeck(Deck a_deck)
    {
        this.m_deck = a_deck;
    }

    /**/
    /*
    Game::getBoard()

    NAME

            Game::getBoard - getter for the Game object's m_board member variable.

    SYNOPSIS

            public Game::getBoard();

    DESCRIPTION

            This function returns the Game's member variable, m_board.

    RETURNS

            Board.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Board getBoard()
    {
        return m_board;
    }

    /**/
    /*
    Game::setBoard()

    NAME

            Game::setBoard - setter for the Game object's m_board member variable.

    SYNOPSIS

            public Game::setBoard(Board a_board);
                a_board --> Board object to set m_board to.

    DESCRIPTION

            This function sets the Game's member variable, m_board, to the given Board variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setBoard(Board a_board)
    {
        this.m_board = a_board;
    }

    /**/
    /*
    Game::getLog()

    NAME

            Game::getLog - getter for the Game object's m_log member variable.

    SYNOPSIS

            public Game::getLog();

    DESCRIPTION

            This function returns the Game's member variable, m_log.

    RETURNS

            ActivityLog.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public ActivityLog getLog()
    {
        return m_log;
    }

    /**/
    /*
    Game::setLog()

    NAME

            Game::setLog - setter for the Game object's m_log member variable.

    SYNOPSIS

            public Game::setLog(ActivityLog a_log);
                a_log --> ActivityLog object to set m_log to.

    DESCRIPTION

            This function sets the Game's member variable, m_log, to the given ActivityLog
            variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setLog(ActivityLog a_log)
    {
        this.m_log = a_log;
    }

    /**/
    /*
    Game::getPlayerOne()

    NAME

            Game::getPlayerOne - getter for the Game object's m_playerOne member variable.

    SYNOPSIS

            public Game::getPlayerOne();

    DESCRIPTION

            This function returns the Game's member variable, m_playerOne.

    RETURNS

            Player.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Player getPlayerOne()
    {
        return this.m_playerOne;
    }

    /**/
    /*
    Game::setPlayerOne()

    NAME

            Game::setPlayerOne - setter for the Game object's m_playerOne member variable.

    SYNOPSIS

            public Game::setPlayerOne(Player a_player);
                a_player --> Player object to set m_playerOne to.

    DESCRIPTION

            This function sets the Game's member variable, m_playerOne, to the given Player
            variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setPlayerOne(Player a_player)
    {
        this.m_playerOne = a_player;
    }

    /**/
    /*
    Game::getPlayerTwo()

    NAME

            Game::getPlayerTwo - getter for the Game object's m_playerTwo member variable.

    SYNOPSIS

            public Game::getPlayerTwo();

    DESCRIPTION

            This function returns the Game's member variable, m_playerTwo.

    RETURNS

            Player.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Player getPlayerTwo()
    {
        return this.m_playerTwo;
    }

    /**/
    /*
    Game::setPlayerTwo()

    NAME

            Game::setPlayerTwo - setter for the Game object's m_playerTwo member variable.

    SYNOPSIS

            public Game::setPlayerTwo(Player a_player);
                a_player --> Player object to set m_playerTwo to.

    DESCRIPTION

            This function sets the Game's member variable, m_playerTwo, to the given Player
            variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setPlayerTwo(Player a_player)
    {
        this.m_playerTwo = a_player;
    }

    /**/
    /*
    Game::setup()

    NAME

            Game::setup - sets up the Game object of the start of an Ishido game.

    SYNOPSIS

            public Game::setup();

    DESCRIPTION

            This function will setup the m_deck, m_board, m_currTile, and Player member variables
            for the start of a game of Ishido.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void setup()
    {
        // Initialize deck
        // setupTiles are the 6 tiles that start on the Ishido board
        setDeck(new Deck());
        getDeck().setup();
        Vector<Tile> setupTiles = getDeck().getSetupTiles();
        Collections.shuffle(setupTiles);

        // initialize board
        // set the board so these setupTiles take up specific positions:
        // (0,0), (0,11), (3, 5), (4, 6), (7, 0), (7, 11)
        setBoard(new Board());
        getBoard().setTile(0, 0, setupTiles.firstElement());
        setupTiles.removeElementAt(0);
        getBoard().setTile(0, 11, setupTiles.firstElement());
        setupTiles.removeElementAt(0);
        getBoard().setTile(3, 5, setupTiles.firstElement());
        setupTiles.removeElementAt(0);
        getBoard().setTile(4, 6, setupTiles.firstElement());
        setupTiles.removeElementAt(0);
        getBoard().setTile(7, 0, setupTiles.firstElement());
        setupTiles.removeElementAt(0);
        getBoard().setTile(7, 11, setupTiles.firstElement());
        setupTiles.removeElementAt(0);

        // Initialize current tile with top tile of deck
        getCurrTile().setColor(getDeck().top().getColor());
        getCurrTile().setSymbol(getDeck().top().getSymbol());
        getDeck().pop();

        // Initialize Activity Log
        setLog(new ActivityLog());
        getLog().setPlayerOneTurn("The Game has begun!");
    }
}
