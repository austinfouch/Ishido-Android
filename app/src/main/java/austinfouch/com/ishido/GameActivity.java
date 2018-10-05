package austinfouch.com.ishido;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

// TODO: DOC
public class GameActivity extends AppCompatActivity implements View.OnClickListener
{
    private Game m_game;
    private TableLayout m_boardLayout;
    private LinearLayout m_scoreBoardLayout;
    private ImageView m_currTileLayout;
    private TextView m_tileCountLayout;
    private TextView m_player1NameLayout;
    private TextView m_player1ScoreLayout;
    private TextView m_player2NameLayout;
    private TextView m_player2ScoreLayout;

    public Game getGame()
    {
        return m_game;
    }

    public void setGame(Game a_game) {
        this.m_game = a_game;
    }

    public TableLayout getBoardLayout()
    {
        return m_boardLayout;
    }

    public void setBoardLayout(TableLayout a_boardLayout)
    {
        this.m_boardLayout = a_boardLayout;
    }

    public LinearLayout getScoreBoardLayout()
    {
        return m_scoreBoardLayout;
    }

    public void setScoreBoardLayout(LinearLayout a_scoreBoardLayout)
    {
        this.m_scoreBoardLayout = a_scoreBoardLayout;
    }

    public ImageView getCurrTileLayout()
    {
        return m_currTileLayout;
    }

    public void setCurrTileLayout(ImageView a_currTileLayout)
    {
        this.m_currTileLayout = a_currTileLayout;
    }

    public TextView getTileCountLayout()
    {
        return m_tileCountLayout;
    }

    public void setTileCountLayout(TextView a_tileCountLayout)
    {
        this.m_tileCountLayout = a_tileCountLayout;
    }

    public TextView getPlayer1NameLayout()
    {
        return m_player1NameLayout;
    }

    public void setPlayer1NameLayout(TextView a_player1NameLayout)
    {
        this.m_player1NameLayout = a_player1NameLayout;
    }

    public TextView getPlayer1ScoreLayout()
    {
        return m_player1ScoreLayout;
    }

    public void setPlayer1ScoreLayout(TextView a_player1ScoreLayout)
    {
        this.m_player1ScoreLayout = a_player1ScoreLayout;
    }

    public TextView getPlayer2NameLayout()
    {
        return m_player2NameLayout;
    }

    public void setPlayer2NameLayout(TextView a_player2NameLayout)
    {
        this.m_player2NameLayout = a_player2NameLayout;
    }

    public TextView getPlayer2ScoreLayout()
    {
        return m_player2ScoreLayout;
    }

    public void setPlayer2ScoreLayout(TextView a_player2ScoreLayout)
    {
        this.m_player2ScoreLayout = a_player2ScoreLayout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // hides big action bar on app
        getSupportActionBar().hide();

        // initialize layouts
        setBoardLayout((TableLayout) findViewById(R.id.boardLayout));
        setScoreBoardLayout((LinearLayout) findViewById(R.id.scoreLayout));
        setCurrTileLayout((ImageView) findViewById(R.id.currentTileView));
        setTileCountLayout((TextView) findViewById(R.id.tileCountView));
        setPlayer1NameLayout((TextView) findViewById(R.id.playerLabel));
        setPlayer1ScoreLayout((TextView) findViewById(R.id.scoreView));
        setPlayer2NameLayout((TextView) findViewById(R.id.playerLabel2));
        setPlayer2ScoreLayout((TextView) findViewById(R.id.scoreView2));

        // create new game
        setGame(new Game());
        getGame().setup();

        // TODO: HELP, QUIT listeners

        // establish row tags, column tags, and onclick listeners for every tileView
        setupBoardListeners(getBoardLayout());

        // TODO: multiple white tiles are showing up when drawing board....
        // draw current tile, board, and tile count
        drawTile(getGame().getCurrTile(), getCurrTileLayout());
        drawBoard(getGame().getBoard(), getBoardLayout());
        getGame().getDeck().pop();
        drawTileCount(getGame().getDeck(), getTileCountLayout());

        // TODO: initialize players
        // TODO: set playerOneName to intent.getExtra("playerName")
        Intent intent = getIntent();
        //getGame().getPlayerOne().setName(intent.getStringExtra("playerName"));
        getGame().getPlayerOne().setName("GRTA");
        getGame().getPlayerOne().setScore(0);
        getGame().getPlayerTwo().setName("HAL9000");
        getGame().getPlayerTwo().setScore(0);
        drawPlayers(getGame(), getPlayer1NameLayout(), getPlayer1ScoreLayout(),
                getPlayer2NameLayout(), getPlayer2ScoreLayout());

        // TODO: check if currTile can be played anywhere for more than 0 points, if not, end game.
    }

    public void drawPlayers(Game a_game, TextView a_player1NameView, TextView a_player1ScoreView,
                            TextView a_player2NameView, TextView a_player2ScoreView)
    {
        a_player1NameView.setText(a_game.getPlayerOne().getName());
        a_player1ScoreView.setText(a_game.getPlayerOne().getScore().toString());
        a_player2NameView.setText(a_game.getPlayerTwo().getName());
        a_player2ScoreView.setText(a_game.getPlayerTwo().getScore().toString());
    }
    public void drawTile(Tile a_currTile, ImageView a_currTileView)
    {
        Resources resources = this.getResources();

        // draw foreground
        String fgResStr = a_currTile.getSymbolResourceStr();
        final int fgResId = resources.getIdentifier(fgResStr, "drawable", getPackageName());
        Drawable fg = getDrawable(fgResId);
        a_currTileView.setForeground(fg);

        // draw background
        String bgResStr = a_currTile.getColorResourceStr();
        final int bgResId = resources.getIdentifier(bgResStr, "drawable", getPackageName());
        Drawable bg = getDrawable(bgResId);
        a_currTileView.setBackground(bg);

        // disable onclick unless blank or help tile
        if(a_currTile.getSymbol() != IshidoSymbol.BLANK && a_currTile.getSymbol() != IshidoSymbol.HELP)
        {
            a_currTileView.setOnClickListener(null);
        }
    }

    public void drawTileCount(Deck a_deck, TextView a_tileCountView)
    {
        // set tile count to current deck size
        Integer deckSize = a_deck.getTiles().size();
        a_tileCountView.setText(deckSize.toString());
    }

    public void drawBoard(Board a_board, TableLayout a_boardView)
    {
        // loop over children (TableRow) of a_boardView (TableLayout)
        for( Integer i = 0; i < a_boardView.getChildCount(); i++)
        {
            View rowView = a_boardView.getChildAt(i);
            if( rowView instanceof TableRow)
            {
                // loop over children (ImageView) of rowView (TableRow)
                for( Integer j = 0; j < ((TableRow) rowView).getChildCount(); j++)
                {
                    View tileView = ((TableRow) rowView).getChildAt(j);
                    if ( tileView instanceof ImageView)
                    {
                        // get the tile from board model at i, j and draw the tile at that position
                        Tile currTile = a_board.getTile(i, j);
                        drawTile(currTile, (ImageView) tileView);
                    }
                }
            }
        }
    }

    public void drawHelp(Game a_game, TableLayout a_boardLayout)
    {
        Vector<Integer> rows = new Vector<>();
        Vector<Integer> cols = new Vector<>();
        int currValue = 0;

        // loop over rows then cols, assessing value of placing the current tile at every position
        for (int row = 0; row < IshidoConstants.NUM_BOARD_ROWS; row++)
        {
            for (int col = 0; col < IshidoConstants.NUM_BOARD_COLS; col++)
            {
                // calculate the score of current tile at the current positions, if it > 0, add to help
                currValue = a_game.calculateScore(a_game.getCurrTile(), a_game.getBoard(), row, col);
                if( currValue > 0)
                {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }

        // loop over rows & cols which hold positions of tiles to be marked as help
        for (int i = 0; i < rows.size(); i++)
        {
            View boardRow = a_boardLayout.getChildAt(rows.get(i));
            View tileView = ((TableRow) boardRow).getChildAt(cols.get(i));
            drawTile(new Tile(IshidoColor.HELP, IshidoSymbol.HELP), (ImageView) tileView);
        }
    }

    public void setupBoardListeners(TableLayout a_boardLayout)
    {
        // loop over children (TableRow) of a_boardView (TableLayout)
        for( Integer i = 0; i < a_boardLayout.getChildCount(); i++)
        {
            View rowView = a_boardLayout.getChildAt(i);
            if( rowView instanceof TableRow)
            {
                // loop over children (ImageView) of rowView (TableRow)
                for( Integer j = 0; j < ((TableRow) rowView).getChildCount(); j++)
                {
                    View tileView = ((TableRow) rowView).getChildAt(j);
                    if ( tileView instanceof ImageView)
                    {
                        // set tags --> 0:row 1:col, enable OnClickListener
                        tileView.setTag(R.string.row, i);
                        tileView.setTag(R.string.col, j);
                        tileView.setOnClickListener(this);
                    }
                }
            }
        }
    }

    public boolean checkExitConditions()
    {
        if(getGame().getDeck().getTiles().size() < 1)
        {
            return true;
        }

        int bestScore = 0;
        for(int row = 0; row < IshidoConstants.NUM_BOARD_ROWS; row++)
        {
            for(int col = 0; col < IshidoConstants.NUM_BOARD_COLS; col++)
            {
                int tempScore = getGame().calculateScore(getGame().getCurrTile(), getGame().getBoard(), row, col);
                if (tempScore > bestScore)
                {
                    bestScore = tempScore;
                }
            }
        }

        if (bestScore == 0)
        {
            return true;
        }

        return false;
    }

    @Override
    public void onClick(final View v) {
        // get currentTile and make sure the onClick doesn't trigger for it
        final ImageView currTileView = (ImageView) findViewById(R.id.currentTileView);
        //final int confirmTileId = this.getResources().getIdentifier("confirm_tile.png", "drawable", this.getPackageName());
        int currTileId = currTileView.getId();
        if(v instanceof ImageView && v.getId() != currTileId) // is ImageView, but not currentTileView
        {
            // build alert dialog, telling user of the tile position clicked
            AlertDialog.Builder builder = new  AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("")
                    .setMessage("Place tile here?\n\nrow : " + ((int) v.getTag(R.string.row) + 1) + "\ncol  : " + ((int) v.getTag(R.string.col) + 1) )
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            int row = (int) v.getTag(R.string.row);
                            int col = (int) v.getTag(R.string.col);
                            Integer score = getGame().calculateScore(getGame().getCurrTile(), getGame().getBoard(), row, col);
                            if (score > 0)
                            {
                                // TODO: check deck size before setting current tile and popping...this tile may be the last one! This shit below didnt work
                                if(checkExitConditions())
                                {
                                    String exitStr = "Game over! ";
                                    if(getGame().getPlayerOne().getScore() > getGame().getPlayerTwo().getScore())
                                    {
                                        exitStr += getGame().getPlayerOne().getName() + " won with a score of " + getGame().getPlayerOne().getScore();
                                    } else {
                                        exitStr += getGame().getPlayerTwo().getName() + " won with a score of " + getGame().getPlayerTwo().getScore();
                                    }
                                    Toast.makeText(getApplicationContext(), exitStr, Toast.LENGTH_LONG).show();

                                    finish();
                                }
                                // draw tile being played on ImageView that was clicked
                                drawTile(getGame().getCurrTile(), (ImageView) v);

                                // set tile in board model, set current tile to deck.top(), then pop deck
                                getGame().getBoard().setTile(row, col, getGame().getCurrTile());
                                getGame().setCurrTile(getGame().getDeck().top());
                                getGame().getDeck().pop();
                                getGame().getPlayerOne().setScore(getGame().getPlayerOne().getScore() + score);

                                // draw current tile, draw board, draw tile count, draw score(s)
                                drawTile(getGame().getCurrTile(), getCurrTileLayout());
                                drawBoard(getGame().getBoard(), getBoardLayout());
                                drawTileCount(getGame().getDeck(), getTileCountLayout());
                                drawPlayers(getGame(), getPlayer1NameLayout(), getPlayer1ScoreLayout(), getPlayer2NameLayout(), getPlayer2ScoreLayout());

                                // quick msg to tell user of points gained
                                Toast.makeText(getApplicationContext(), "Match! Your score increased by " + score.toString() + ".", Toast.LENGTH_SHORT).show();
                            } else {
                                // illegal move, do nothing but tell user
                                Toast.makeText(getApplicationContext(), "Illegal move! Tiles must be placed adjacent to at least one matching tile!", Toast.LENGTH_LONG).show();
                            }
                            dialog.dismiss();
                        }

                    })
                    .setNegativeButton("No", null);
                    //.show();
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

            lp.copyFrom(alertDialog.getWindow().getAttributes());
            lp.width = 450;
            lp.height = 750;
            lp.x=720;
            lp.y=600;
            alertDialog.getWindow().setAttributes(lp);
        }
    }
}
