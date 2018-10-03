package austinfouch.com.ishido;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // hides big action bar on app
        getSupportActionBar().hide();

        // initialize layouts
        m_boardLayout = (TableLayout) findViewById(R.id.boardLayout);
        m_scoreBoardLayout = (LinearLayout) findViewById(R.id.scoreLayout);
        m_currTileLayout = (ImageView) findViewById(R.id.currentTileView);
        m_tileCountLayout = (TextView) findViewById(R.id.tileCountView);
        m_player1NameLayout = (TextView) findViewById(R.id.playerLabel);
        m_player1ScoreLayout = (TextView) findViewById(R.id.scoreView);
        m_player2NameLayout = (TextView) findViewById(R.id.playerLabel2);
        m_player2ScoreLayout = (TextView) findViewById(R.id.scoreView2);

        // create new game
        this.m_game = new Game();
        this.m_game.setup(m_boardLayout, m_player1NameLayout, m_player1ScoreLayout, m_player2NameLayout,
                m_player2ScoreLayout, m_currTileLayout, m_tileCountLayout);

        // TODO: HELP, QUIT listeners

        // establish row tags, column tags, and onclick listeners for every tileView
        setupBoardListeners(m_boardLayout);

        // TODO: multiple white tiles are showing up when drawing board....
        // draw current tile, board, and tile count
        drawTile(this.m_game.getCurrTile(), m_currTileLayout);
        drawBoard(this.m_game.getBoard(), m_boardLayout);
        this.m_game.getDeck().pop();
        drawTileCount(this.m_game.getDeck(), m_tileCountLayout);

        // TODO: add to onclick --> try and place current tile. this will be working solitaire.
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

    @Override
    public void onClick(final View v) {
        //

        // grab currentTile and make sure the onclick doesnt trigger for it
        ImageView currTileView = (ImageView) findViewById(R.id.currentTileView);
        final int confirmTileId = this.getResources().getIdentifier("confirm_tile.png", "drawable", this.getPackageName());
        int currTileId = currTileView.getId();
        if(v instanceof ImageView && v.getId() != currTileId) // is ImageView, but not currentTileView
        {
            // build alert dialog, telling user of the tile position clicked
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Confirming Tile Placement")
                    .setMessage("row:" + v.getTag(R.string.row).toString() + " col:" + v.getTag(R.string.col).toString() )
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // draw current tile on board
                            drawTile(m_game.getCurrTile(), (ImageView) v);

                            int row = (int) v.getTag(R.string.row);
                            int col = (int) v.getTag(R.string.col);
                            // set tile in board model, current tile to deck.top(), pop deck
                            m_game.getBoard().setTile(row, col, m_game.getCurrTile());
                            m_game.setCurrTile(m_game.getDeck().top());
                            m_game.getDeck().pop();

                            // draw current tile, board, tile count, score
                            drawTile(m_game.getCurrTile(), m_currTileLayout);
                            drawBoard(m_game.getBoard(), m_boardLayout);
                            drawTileCount(m_game.getDeck(), m_tileCountLayout);
                            // TODO: drawScore()
                            dialog.dismiss();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }
}
