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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // hides big action bar on app
        getSupportActionBar().hide();

        // initialize layouts
        TableLayout boardLayout = (TableLayout) findViewById(R.id.boardLayout);
        LinearLayout scoreBoardLayout = (LinearLayout) findViewById(R.id.scoreLayout);
        ImageView currTileLayout = (ImageView) findViewById(R.id.currentTileView);
        TextView tileCountLayout = (TextView) findViewById(R.id.tileCountView);
        TextView player1NameLayout = (TextView) findViewById(R.id.playerLabel);
        TextView player1ScoreLayout = (TextView) findViewById(R.id.scoreView);
        TextView player2NameLayout = (TextView) findViewById(R.id.playerLabel2);
        TextView player2ScoreLayout = (TextView) findViewById(R.id.scoreView2);

        // create new game
        Game game = new Game();
        game.setup(boardLayout, player1NameLayout, player1ScoreLayout, player2NameLayout,
                player2ScoreLayout, currTileLayout, tileCountLayout);

        // TODO: HELP, QUIT listeners

        // establish row tags, column tags, and onclick listeners for every tileView
        setupBoardListeners(boardLayout);

        // TODO: multiple white tiles are showing up when drawing board....
        drawTile(game.getCurrTile(), currTileLayout);
        drawBoard(game.getBoard(), boardLayout);
        game.getDeck().pop();
        drawTileCount(game.getDeck(), tileCountLayout);

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
        Integer deckSize = a_deck.getTiles().size();
        a_tileCountView.setText(deckSize.toString());
    }

    public void drawBoard(Board a_board, TableLayout a_boardView)
    {
        for( Integer i = 0; i < a_boardView.getChildCount(); i++)
        {
            View rowView = a_boardView.getChildAt(i);
            if( rowView instanceof TableRow)
            {
                for( Integer j = 0; j < ((TableRow) rowView).getChildCount(); j++)
                {
                    View tileView = ((TableRow) rowView).getChildAt(j);
                    if ( tileView instanceof ImageView)
                    {
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
        int currValue;

        for (int row = 0; row < IshidoConstants.NUM_BOARD_ROWS; row++)
        {
            for (int col = 0; col < IshidoConstants.NUM_BOARD_COLS; col++)
            {
                currValue = a_game.calculateScore(a_game.getCurrTile(), a_game.getBoard(), row, col);
                if( currValue > 0)
                {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }

        for (int i = 0; i < rows.size(); i++)
        {
            View boardRow = a_boardLayout.getChildAt(rows.get(i));
            View tileView = ((TableRow) boardRow).getChildAt(cols.get(i));
            drawTile(new Tile(IshidoColor.HELP, IshidoSymbol.HELP), (ImageView) tileView);
        }
    }

    public void setupBoardListeners(TableLayout a_boardLayout)
    {
        for( Integer i = 0; i < a_boardLayout.getChildCount(); i++)
        {
            View rowView = a_boardLayout.getChildAt(i);
            if( rowView instanceof TableRow)
            {
                for( Integer j = 0; j < ((TableRow) rowView).getChildCount(); j++)
                {
                    View tileView = ((TableRow) rowView).getChildAt(j);
                    if ( tileView instanceof ImageView)
                    {
                        tileView.setTag(R.string.row, i);
                        tileView.setTag(R.string.col, j);
                        tileView.setOnClickListener(this);
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        // grab currentTile and make sure the onclick doesnt trigger for it
        ImageView currTileLayout = (ImageView) findViewById(R.id.currentTileView);
        final int confirmTileId = this.getResources().getIdentifier("confirm_tile.png", "drawable", this.getPackageName());
        int currTileId = currTileLayout.getId();
        if(v instanceof ImageView && v.getId() != currTileId) // is ImageView, but not currentTileView
        {
            // TODO: v.setForeground(this.getDrawable(confirmTileId)); throws an err
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Confirming Tile Placement")
                    .setMessage("row:" + v.getTag(R.string.row).toString() + " col:" + v.getTag(R.string.col).toString() )
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }
}
