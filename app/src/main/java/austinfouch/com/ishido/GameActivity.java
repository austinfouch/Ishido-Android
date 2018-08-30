package austinfouch.com.ishido;

import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

// TODO: DOC
public class GameActivity extends AppCompatActivity
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
    }
}
