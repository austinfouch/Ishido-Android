package austinfouch.com.ishido;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class Launcher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        //Main main = new Main();
        //main.main();

        Deck deck = new Deck();
        deck.setup();

        Tile tile = deck.lastTile();
        deck.removeLastTile();
        int resId = tile.getResourceID();

        ImageButton ivButton = (ImageButton) findViewById( R.id.view_testTile);
        ivButton.setImageResource(resId);
    }
}
