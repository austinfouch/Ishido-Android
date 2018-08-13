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


        Game game = new Game();
        game.setup(boardLayout, scoreBoardLayout, currTileLayout, tileCountLayout);
    }
}
