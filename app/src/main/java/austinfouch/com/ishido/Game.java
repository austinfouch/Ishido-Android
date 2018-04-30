package austinfouch.com.ishido;

import android.app.Activity;

import java.util.Vector;

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

    public Game()
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
    }

    public Game(Tile a_currTile, TileView a_currTileView, Deck a_deck, Board a_board,
                BoardView a_boardView, ActivityLog a_log, ActivityLogView a_logView,
                Vector<Player> a_players, ScoreBoard a_scoreBoard, ScoreBoardView a_scoreBoardView,
                Turn a_lastTurn)
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

    public void setM_scoreBoard(ScoreBoard a_scoreBoard)
    {
        this.m_scoreBoard = a_scoreBoard;
    }

    public ScoreBoardView getScoreBoardView()
    {
        return m_scoreBoardView;
    }

    public void setScoreBoardView(ScoreBoardView a_scoreBoardView)
    {
        this.m_scoreBoardView = a_scoreBoardView;
    }

    public Turn getLastTurn()
    {
        return m_lastTurn;
    }

    public void setLastTurn(Turn a_lastTurn)
    {
        this.m_lastTurn = a_lastTurn;
    }

    public void setup()
    {
        // model initializations
        this.m_deck = new Deck();
        this.m_deck.setup();

        Vector<Tile> setupTiles = this.m_deck.getSetupTiles();
        // set row 0, col 0
        // set row 0, col 11
        // set row 3, col 5
        // set row 4, col 6
        // set row 7, col 0
        // set row 7, col 11

        this.m_currTile.setColor(this.m_deck.top().getColor());
        this.m_currTile.setSymbol(this.m_deck.top().getSymbol());
        this.m_deck.pop();
    }
}
