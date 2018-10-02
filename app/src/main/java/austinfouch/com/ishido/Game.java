package austinfouch.com.ishido;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Vector;

// TODO: DOC
public class Game
{
    private Tile m_currTile;
    private TileView m_currTileView;
    private Deck m_deck;
    private Board m_board;
    private BoardView m_boardView;
    private ActivityLog m_log;
    private ActivityLogView m_logView;
    private Vector<Player> m_players;
    private ScoreBoard m_scoreBoard;
    private ScoreBoardView m_scoreBoardView;
    private Turn m_lastTurn;
    private Integer m_turnNum;
    private TileCountView m_tileCountView;
    private Integer m_tileCount;
    private Context m_context;

    public Game(Context a_context)
    {
        this.m_currTile = new Tile();
        this.m_currTileView = null;
        this.m_deck = new Deck();
        this.m_board = new Board();
        this.m_boardView = null;
        this.m_log = new ActivityLog();
        this.m_logView = null;
        this.m_players = new Vector<Player>();
        this.m_scoreBoard = new ScoreBoard();
        this.m_scoreBoardView = null;
        this.m_lastTurn = new Turn();
        this.m_turnNum = 0;
        this.m_tileCountView = null;
        this.m_tileCount = IshidoConstants.DECK_SIZE;
    }

    public Game(Tile a_currTile, TileView a_currTileView, Deck a_deck, Board a_board,
                BoardView a_boardView, ActivityLog a_log, ActivityLogView a_logView,
                Vector<Player> a_players, ScoreBoard a_scoreBoard, ScoreBoardView a_scoreBoardView,
                Turn a_lastTurn, Integer a_turnNum, TileCountView a_tileCountView,
                Integer a_tileCount, Context a_context)
    {
        this.m_currTile = a_currTile;
        this.m_currTileView = a_currTileView;
        this.m_deck = a_deck;
        this.m_board = a_board;
        this.m_boardView = a_boardView;
        this.m_log = a_log;
        this.m_logView = a_logView;
        this.m_players = a_players;
        this.m_scoreBoard = a_scoreBoard;
        this.m_scoreBoardView = a_scoreBoardView;
        this.m_lastTurn = a_lastTurn;
        this.m_turnNum = a_turnNum;
        this.m_tileCountView = a_tileCountView;
        this.m_tileCount = a_tileCount;
        this.m_context = a_context;
    }

    public void help(Tile currTile, Board gameBoard)
    {
        Vector<Integer> rows = new Vector<>();
        Vector<Integer> cols = new Vector<>();
        int currValue;

        for (int row = 0; row < IshidoConstants.NUM_BOARD_ROWS; row++)
        {
            for (int col = 0; col < IshidoConstants.NUM_BOARD_COLS; col++)
            {
                currValue = calculateScore(currTile, gameBoard, row, col);
                if( currValue > 0)
                {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }

        for (int i = 0; i < rows.size(); i++)
        {
            gameBoard.markAsHelp(rows.elementAt(i), cols.elementAt(i));
        }
    }

    public Integer calculateScore(Tile a_currTile, Board gameBoard, int rowIndex, int colIndex)
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

    public Integer getTurnNum()
    {
        return this.m_turnNum;
    }

    public void setTurnNum(Integer a_turnNum)
    {
        this.m_turnNum = a_turnNum;
    }

    public Tile getCurrTile()
    {
        return m_currTile;
    }

    public void setCurrTile(Tile a_currTile)
    {
        this.m_currTile = a_currTile;
    }

    public TileView getCurrTileView()
    {
        return m_currTileView;
    }

    public void setCurrTileView(TileView a_currTileView)
    {
        this.m_currTileView = a_currTileView;
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

    public BoardView getBoardView()
    {
        return m_boardView;
    }

    public void setBoardView(BoardView a_boardView)
    {
        this.m_boardView = a_boardView;
    }

    public ActivityLog getLog()
    {
        return m_log;
    }

    public void setLog(ActivityLog a_log)
    {
        this.m_log = a_log;
    }

    public ActivityLogView getLogView()
    {
        return m_logView;
    }

    public void setLogView(ActivityLogView a_logView)
    {
        this.m_logView = a_logView;
    }

    public Vector<Player> getPlayers()
    {
        return m_players;
    }

    public void setPlayers(Vector<Player> a_players)
    {
        this.m_players = a_players;
    }

    public ScoreBoard getScoreBoard()
    {
        return m_scoreBoard;
    }

    public ScoreBoardView getScoreBoardView()
    {
        return m_scoreBoardView;
    }

    public void setScoreBoardView(ScoreBoardView a_scoreBoardView)
    {
        this.m_scoreBoardView = a_scoreBoardView;
    }

    public TileCountView getTileCountView()
    {
        return m_tileCountView;
    }

    public void setTileCountView(TileCountView a_tileCountView)
    {
        this.m_tileCountView = a_tileCountView;
    }

    public Turn getLastTurn()
    {
        return m_lastTurn;
    }

    public void setLastTurn(Turn a_lastTurn)
    {
        this.m_lastTurn = a_lastTurn;
    }

    public void setContext(Context a_context)
    {
        this.m_context = a_context;
    }

    public Context getContext()
    {
        return this.m_context;
    }

    public void setup(TableLayout a_boardLayout, TextView a_player1_name, TextView a_player1_score,
                      TextView a_player2_name, TextView a_player2_score, ImageView a_currTileLayout,
                      TextView a_tileCountLayout)
    {
        // view initializations
        setBoardView(new BoardView(getBoard(), a_boardLayout, getContext()));
        setCurrTileView(new TileView(getCurrTile(), a_currTileLayout));
        setTileCountView(new TileCountView(getDeck().getTiles().size(), a_tileCountLayout));
        setScoreBoardView(new ScoreBoardView(getScoreBoard(), a_player1_name, a_player1_score,
                a_player2_name, a_player2_score));
        // TODO: setActivityLogView(new ActivityLog());

        // model initializations
        setDeck(new Deck());
        getDeck().setup();

        Vector<Tile> setupTiles = getDeck().getSetupTiles();

        // TODO: draw() functions throw errors, maybe move drawing to only be in GameActivity
        getCurrTile().setColor(getDeck().top().getColor());
        getCurrTile().setSymbol(getDeck().top().getSymbol());
        //getCurrTileView().draw(getContext());
        getDeck().pop();
       // getTileCountView().draw();
    }
}
