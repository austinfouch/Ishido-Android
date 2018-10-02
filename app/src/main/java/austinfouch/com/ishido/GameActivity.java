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
        Game game = new Game(this);
        game.setup(boardLayout, player1NameLayout, player1ScoreLayout, player2NameLayout,
                player2ScoreLayout, currTileLayout, tileCountLayout);

        // TODO: HELP, QUIT listeners

        // establish row tags, column tags, and onclick listeners for every tileView
        for( Integer i = 0; i < boardLayout.getChildCount(); i++)
        {
            View rowView = boardLayout.getChildAt(i);
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

        // TODO: split these into functions: drawCurrTile(), drawBoard(), drawScoreBoard(), drawActivityLog(), drawTileCount()
        drawCurrTile(game.getCurrTile(), currTileLayout);
    }

    public void drawCurrTile(Tile a_currTile, ImageView a_currTileView)
    {
        Resources resources = this.getResources();
        // draw board, currentTile
        String fgResStr = a_currTile.getSymbolResourceStr();
        final int fgResId = resources.getIdentifier(fgResStr, "drawable", getPackageName());
        Drawable fg = getDrawable(fgResId);

        String bgResStr = a_currTile.getColorResourceStr();
        final int bgResId = resources.getIdentifier(bgResStr, "drawable", getPackageName());
        Drawable bg = getDrawable(bgResId);

        a_currTileView.setForeground(fg);
        a_currTileView.setBackground(bg);
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
