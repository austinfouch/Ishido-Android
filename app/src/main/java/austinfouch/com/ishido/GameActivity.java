package austinfouch.com.ishido;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

        getSupportActionBar().hide();

        TableLayout boardLayout = (TableLayout) findViewById(R.id.boardLayout);
        LinearLayout scoreBoardLayout = (LinearLayout) findViewById(R.id.scoreLayout);
        ImageView currTileLayout = (ImageView) findViewById(R.id.currentTileView);
        TextView tileCountLayout = (TextView) findViewById(R.id.tileCountView);
        TextView player1NameLayout = (TextView) findViewById(R.id.playerLabel);
        TextView player1ScoreLayout = (TextView) findViewById(R.id.scoreView);
        TextView player2NameLayout = (TextView) findViewById(R.id.playerLabel2);
        TextView player2ScoreLayout = (TextView) findViewById(R.id.scoreView2);

        Game game = new Game(this);
        game.setup(boardLayout, player1NameLayout, player1ScoreLayout, player2NameLayout,
                player2ScoreLayout, currTileLayout, tileCountLayout);

        // TODO: HELP, QUIT listeners

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
                        tileView.setTag(0, i);
                        tileView.setTag(1, j);
                        tileView.setOnClickListener(this);
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        ImageView currTileLayout = (ImageView) findViewById(R.id.currentTileView);
        int currTileId = currTileLayout.getId();
        if(v instanceof ImageView && v.getId() != currTileId) // is ImageView, but not currentTileView
        {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Confirming Tile Placement")
                    .setMessage("row:" + v.getTag(0).toString() + " col:" + v.getTag(1).toString() )
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
