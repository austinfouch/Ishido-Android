package austinfouch.com.ishido;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.Vector;

// TODO: DOC
// TODO: remove get/set for players, replace with get/set for playerOne and playerTwo
public class Game
{
    private Tile m_currTile;
    private Deck m_deck;
    private Board m_board;
    private ActivityLog m_log;
    private Player m_playerOne;
    private Player m_playerTwo;

    public Game()
    {
        this.m_currTile = new Tile();
        this.m_deck = new Deck();
        this.m_board = new Board();
        this.m_log = new ActivityLog();
        this.m_playerOne = new Human();
        this.m_playerTwo = new Computer();
    }

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

    public Tile getCurrTile()
    {
        return m_currTile;
    }

    public void setCurrTile(Tile a_currTile)
    {
        this.m_currTile = a_currTile;
    }

    public Deck getDeck()
    {
        return m_deck;
    }

    public void setDeck(Deck a_deck)
    {
        this.m_deck = a_deck;
    }

    public Board getBoard()
    {
        return m_board;
    }

    public void setBoard(Board a_board)
    {
        this.m_board = a_board;
    }

    public ActivityLog getLog()
    {
        return m_log;
    }

    public void setLog(ActivityLog a_log)
    {
        this.m_log = a_log;
    }

    public Player getPlayerOne()
    {
        return this.m_playerOne;
    }

    public void setPlayerOne(Player a_player)
    {
        this.m_playerOne = a_player;
    }

    public Player getPlayerTwo()
    {
        return this.m_playerTwo;
    }

    public void setPlayerTwo(Player a_player)
    {
        this.m_playerTwo = a_player;
    }

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
