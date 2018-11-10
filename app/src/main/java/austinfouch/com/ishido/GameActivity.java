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
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

/**/
/*
    GameActivity.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Game Activity class. This Activity is the same layout for both Solitaire and Standard

        The m_game member variable is the model for each Ishido game. Every other member variable is
        a layout or view within the Game Activity that visualizes the m_game model to the user.

        The only interactive views are the individual ImageViews that make up the game board.

    DATE

        01/30/2018

*/
/**/
public class GameActivity extends AppCompatActivity implements View.OnClickListener
{
    private Game m_game;
    private TableLayout m_boardLayout;
    private ImageView m_currTileLayout;
    private TextView m_tileCountLayout;
    private TextView m_player1NameLayout;
    private TextView m_player1ScoreLayout;
    private TextView m_player2NameLayout;
    private TextView m_player2ScoreLayout;
    private TextView m_player1LogView;
    private TextView m_player2LogView;
    private Boolean m_solitaireFlag;

    public TextView getPlayer1LogView()
    {
        return this.m_player1LogView;
    }

    public void setPlayer1LogView(TextView a_player1LogView)
    {
        this.m_player1LogView = a_player1LogView;
    }

    public TextView getPlayer2LogView()
    {
        return this.m_player2LogView;
    }

    public void setPlayer2LogView(TextView a_player2LogView)
    {
        this.m_player2LogView = a_player2LogView;
    }

    /**/
    /*
    GameActivity::getGame()

    NAME

            GameActivity::getGame - getter for the m_game member variable.

    SYNOPSIS

            public Game GameActivity::getGame();

    DESCRIPTION

            This function returns the m_game member variable.

    RETURNS

            Game.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public Game getGame()
    {
        return m_game;
    }

    /**/
    /*
    GameActivity::setGame()

    NAME

            GameActivity::setGame - setter for the m_game member variable.

    SYNOPSIS

            public void GameActivity::getGame(Game a_game);
                a_game --> value to set m_game to.

    DESCRIPTION

            This function sets the m_game member variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setGame(Game a_game) {
        this.m_game = a_game;
    }

    /**/
    /*
    GameActivity::getBoardLayout()

    NAME

            GameActivity::getBoardLayout - getter for the m_boardLayout member variable.

    SYNOPSIS

            public TableLayout GameActivity::getBoardLayout();

    DESCRIPTION

            This function returns the m_boardLayout member variable.

    RETURNS

            TableLayout.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public TableLayout getBoardLayout()
    {
        return m_boardLayout;
    }

    /**/
    /*
    GameActivity::setBoardLayout()

    NAME

            GameActivity::setBoardLayout - setter for the m_boardLayout member variable.

    SYNOPSIS

            public void GameActivity::setBoardLayout(TableLayout a_boardLayout);
                a_boardLayout --> value to set m_boardLayout to.

    DESCRIPTION

            This function sets the m_game member variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setBoardLayout(TableLayout a_boardLayout)
    {
        this.m_boardLayout = a_boardLayout;
    }

    /**/
    /*
    GameActivity::getCurrTileLayout()

    NAME

            GameActivity::getCurrTileLayout - getter for the m_currTileLayout member variable.

    SYNOPSIS

            public ImageView GameActivity::getCurrTileLayout();

    DESCRIPTION

            This function returns the m_currTileLayout member variable.

    RETURNS

            ImageView.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public ImageView getCurrTileLayout()
    {
        return m_currTileLayout;
    }

    /**/
    /*
    GameActivity::setCurrTileLayout()

    NAME

            GameActivity::setCurrTileLayout - setter for the m_currTileLayout member variable.

    SYNOPSIS

            public void GameActivity::setCurrTileLayout(ImageView a_currTileLayout);
                a_currTileLayout --> value to set m_currTileLayout to.

    DESCRIPTION

            This function sets the m_currTileLayout member variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setCurrTileLayout(ImageView a_currTileLayout)
    {
        this.m_currTileLayout = a_currTileLayout;
    }

    /**/
    /*
    GameActivity::getTileCountLayout()

    NAME

            GameActivity::getTileCountLayout - getter for the m_tileCountLayout member variable.

    SYNOPSIS

            public ImageView GameActivity::getTileCountLayout();

    DESCRIPTION

            This function returns the m_tileCountLayout member variable.

    RETURNS

            TextView.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public TextView getTileCountLayout()
    {
        return m_tileCountLayout;
    }

    /**/
    /*
    GameActivity::setTileCountLayout()

    NAME

            GameActivity::setTileCountLayout - setter for the m_tileCountLayout member variable.

    SYNOPSIS

            public void GameActivity::setTileCountLayout(TextView a_tileCountLayout);
                a_tileCountLayout --> value to set m_tileCountLayout to.

    DESCRIPTION

            This function sets the m_tileCountLayout member variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setTileCountLayout(TextView a_tileCountLayout)
    {
        this.m_tileCountLayout = a_tileCountLayout;
    }

    /**/
    /*
    GameActivity::getPlayer1NameLayout()

    NAME

            GameActivity::getPlayer1NameLayout - getter for the m_player1NameLayout member variable.

    SYNOPSIS

            public ImageView GameActivity::getPlayer1NameLayout();

    DESCRIPTION

            This function returns the m_player1NameLayout member variable.

    RETURNS

            TextView.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public TextView getPlayer1NameLayout()
    {
        return m_player1NameLayout;
    }

    /**/
    /*
    GameActivity::setPlayer1NameLayout()

    NAME

            GameActivity::setPlayer1NameLayout - setter for the m_player1NameLayout member variable.

    SYNOPSIS

            public void GameActivity::setPlayer1NameLayout(TextView a_player1NameLayout);
                a_player1NameLayout --> value to set m_player1NameLayout to.

    DESCRIPTION

            This function sets the m_player1NameLayout member variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setPlayer1NameLayout(TextView a_player1NameLayout)
    {
        this.m_player1NameLayout = a_player1NameLayout;
    }

    /**/
    /*
    GameActivity::getPlayer1ScoreLayout()

    NAME

            GameActivity::getPlayer1ScoreLayout - getter for the m_player1ScoreLayout member variable.

    SYNOPSIS

            public ImageView GameActivity::getPlayer1ScoreLayout();

    DESCRIPTION

            This function returns the m_player1ScoreLayout member variable.

    RETURNS

            TextView.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public TextView getPlayer1ScoreLayout()
    {
        return m_player1ScoreLayout;
    }

    /**/
    /*
    GameActivity::setPlayer1ScoreLayout()

    NAME

            GameActivity::setPlayer1ScoreLayout - setter for the m_player1ScoreLayout member variable.

    SYNOPSIS

            public void GameActivity::setPlayer1ScoreLayout(TextView a_player1ScoreLayout);
                a_player1ScoreLayout --> value to set m_player1ScoreLayout to.

    DESCRIPTION

            This function sets the m_player1ScoreLayout member variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setPlayer1ScoreLayout(TextView a_player1ScoreLayout)
    {
        this.m_player1ScoreLayout = a_player1ScoreLayout;
    }

    /**/
    /*
    GameActivity::getPlayer2NameLayout()

    NAME

            GameActivity::getPlayer2NameLayout - getter for the m_player2NameLayout member variable.

    SYNOPSIS

            public ImageView GameActivity::getPlayer2NameLayout();

    DESCRIPTION

            This function returns the m_player2NameLayout member variable.

    RETURNS

            TextView.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public TextView getPlayer2NameLayout()
    {
        return m_player2NameLayout;
    }

    /**/
    /*
    GameActivity::setPlayer2NameLayout()

    NAME

            GameActivity::setPlayer2NameLayout - setter for the m_player2NameLayout member variable.

    SYNOPSIS

            public void GameActivity::setPlayer2NameLayout(TextView a_player2NameLayout);
                a_player2NameLayout --> value to set m_player2NameLayout to.

    DESCRIPTION

            This function sets the m_player2NameLayout member variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setPlayer2NameLayout(TextView a_player2NameLayout)
    {
        this.m_player2NameLayout = a_player2NameLayout;
    }

    /**/
    /*
    GameActivity::getPlayer2ScoreLayout()

    NAME

            GameActivity::getPlayer2ScoreLayout - getter for the m_player2ScoreLayout member variable.

    SYNOPSIS

            public ImageView GameActivity::getPlayer2ScoreLayout();

    DESCRIPTION

            This function returns the m_player2ScoreLayout member variable.

    RETURNS

            TextView.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public TextView getPlayer2ScoreLayout()
    {
        return m_player2ScoreLayout;
    }

    /**/
    /*
    GameActivity::setPlayer2ScoreLayout()

    NAME

            GameActivity::setPlayer2ScoreLayout - setter for the m_player2ScoreLayout member variable.

    SYNOPSIS

            public void GameActivity::setPlayer2ScoreLayout(TextView a_player2ScoreLayout);
                a_player2ScoreLayout --> value to set m_player2ScoreLayout to.

    DESCRIPTION

            This function sets the m_player2ScoreLayout member variable.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018
    */
    /**/
    public void setPlayer2ScoreLayout(TextView a_player2ScoreLayout)
    {
        this.m_player2ScoreLayout = a_player2ScoreLayout;
    }

    /**/
    /*
    GameActivity::onCreate()

    NAME

            GameActivity::onCreate - called when the Game Activity is created.

    SYNOPSIS

            public void GameActivity::onCreate();

    DESCRIPTION

            This function will set the layout of the Game Activity to the XML file located
            at R.layout.activity_launcher. Then each of the layout/view member variables are set to
            the specified layout/view IDs in the XML file. The game model is setup using
            game.setup(). Every ImageView within the TableLayout has an OnClick listener enabled,
            which is handled the Game.onClick() function. The initial m_game model is draw to the
            screen through the Game.draw() functions. The m_solitaireFlag is set to true if the
            Intent object's Extra variable solitaireFlag has a value of "true" or false if the
            solitaireFlag Extra variable has a value of "false".

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // hides big action bar on app
        getSupportActionBar().hide();

        // initialize layouts
        setBoardLayout((TableLayout) findViewById(R.id.boardLayout));
        setCurrTileLayout((ImageView) findViewById(R.id.currentTileView));
        setTileCountLayout((TextView) findViewById(R.id.tileCountView));
        setPlayer1NameLayout((TextView) findViewById(R.id.playerLabel));
        setPlayer1ScoreLayout((TextView) findViewById(R.id.scoreView));
        setPlayer2NameLayout((TextView) findViewById(R.id.playerLabel2));
        setPlayer2ScoreLayout((TextView) findViewById(R.id.scoreView2));
        setPlayer1LogView((TextView) findViewById(R.id.player1Turn));
        setPlayer2LogView((TextView) findViewById(R.id.player2Turn));

        // create new game
        setGame(new Game());
        getGame().setup();

        // establish row tags, column tags, and onclick listeners for every tileView
        setupBoardListeners(getBoardLayout());

        // draw current tile, board, and tile count
        drawTile(getGame().getCurrTile(), getCurrTileLayout());
        drawBoard(getGame().getBoard(), getBoardLayout());
        getGame().getDeck().pop();
        drawTileCount(getGame().getDeck(), getTileCountLayout());

        // get intent, set user name
        Intent intent = getIntent();
        getGame().getPlayerOne().setName(intent.getStringExtra("playerName"));
        getGame().getPlayerOne().setScore(0);
        String temp = intent.getStringExtra("solitaireFlag");
        if(temp.equals("false"))
        {
            m_solitaireFlag = false;
        } else {
            m_solitaireFlag = true;
        }

        if(m_solitaireFlag == false)
        {
            getGame().getPlayerTwo().setName("HAL9000");
            getGame().getPlayerTwo().setScore(0);
        }

        drawPlayers(getGame(), getPlayer1NameLayout(), getPlayer1ScoreLayout(),
                getPlayer2NameLayout(), getPlayer2ScoreLayout());
    }

    /**/
    /*
    GameActivity::drawPlayers()

    NAME

            GameActivity::drawPlayers - draw Player data to screen.

    SYNOPSIS

            public void GameActivity::drawPlayers(Game a_game, TextView a_player1NameView,
                            TextView a_player1ScoreView, TextView a_player2NameView,
                            TextView a_player2ScoreView);
                a_game              --> Game variable used to determine Players' name and score.
                a_player1NameView   --> TextView which has its text value set Game.m_playerOne.name.
                a_player1ScoreView  --> TextView which has its text value set Game.m_playerOne.score.
                a_player2NameView   --> TextView which has its text value set Game.m_playerTwo.name.
                a_player2ScoreView  --> TextView which has its text value set Game.m_playerTwo.score.

    DESCRIPTION

            This function will use the given Game object to set the text values for the given
            TextView objects.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void drawPlayers(Game a_game, TextView a_player1NameView, TextView a_player1ScoreView,
                            TextView a_player2NameView, TextView a_player2ScoreView)
    {
        a_player1NameView.setText(a_game.getPlayerOne().getName());
        a_player1ScoreView.setText(a_game.getPlayerOne().getScore().toString());
        if(m_solitaireFlag == false)
        {
            a_player2NameView.setText(a_game.getPlayerTwo().getName());
            a_player2ScoreView.setText(a_game.getPlayerTwo().getScore().toString());
        }
    }

    /**/
    /*
    GameActivity::drawTile()

    NAME

            GameActivity::drawTile - draw tile to the screen.

    SYNOPSIS

            public void GameActivity::drawTile(Tile a_currTile, ImageView a_currTileView);
                a_currTile      --> Tile object to draw.
                a_currTileView  --> ImageView where a_currTile is drawn to.

    DESCRIPTION

            This function will use the given Tile object to set the foreground and background
            resources of the given ImageView.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
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

    /**/
    /*
    GameActivity::drawTileCount()

    NAME

            GameActivity::drawTileCount - draw tile to the screen.

    SYNOPSIS

            public void GameActivity::drawTileCount(Deck a_deck, TextView a_tileCountView);
                a_deck          --> Deck object used to draw deck size to screen.
                a_tileCountView --> TextView where a_deck.size() is drawn to.

    DESCRIPTION

            This function will use the given Deck object to draw the object's size to the
            the deck size to screen.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void drawTileCount(Deck a_deck, TextView a_tileCountView)
    {
        // set tile count to current deck size
        Integer deckSize = a_deck.getTiles().size();
        a_tileCountView.setText(deckSize.toString());
    }

    /**/
    /*
    GameActivity::drawBoard()

    NAME

            GameActivity::drawBoard - draw game board to the screen.

    SYNOPSIS

            public void GameActivity::drawBoard(Board a_board, TableLayout a_boardView);
                a_board     --> Board object used to draw the game board to screen.
                a_boardView --> TextView where a_deck.size() is drawn to.

    DESCRIPTION

            This function will use the given Board object to draw game board to the screen.

            This is accomplished by iterating over the children of the given TableLayout, which
            return TableRow layouts. Then iterating over the children of a TableRow layout,
            ImageViews are returned.

            Each ImageView in these TableRows represents an individual square on the game board, and
            is given two tags, row and col, to save positional data relevant to the game board on
            each ImageView. This aspect of the game board layout is done in the
            GameActivity.enableListeners() function.

            Every ImageView is then drawn using the GameActivity.drawTile() function, passing
            the current ImageView and the associated Tile object in the GameActivity.game.board
            object.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
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

    /**/
    /*
    GameActivity::setupBoardListeners()

    NAME

            GameActivity::setupBoardListeners - setup onClick() listeners on the game board.

    SYNOPSIS

            public void GameActivity::setupBoardListeners(TableLayout a_boardLayout);
                a_boardLayout --> TableLayout to set onClick() listeners on.

    DESCRIPTION

            This function will enable OnClick() listeners on every ImageView in every TableRow in
            the given TableLayout.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
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

    /**/
    /*
    GameActivity::onClick()

    NAME

            GameActivity::onClick - onClick handler for ImageView and Button objects.

    SYNOPSIS

            public void GameActivity::onClick(View v);
                v --> View/Button being clicked.

    DESCRIPTION

            This function will handle the onClick functionality of every ImageView and Button in the
            Game Activity.

            ImageViews:
                Every clickable ImageView is found on the TableLayout which represents the game
                board. These game board squares are ImageViews, and are only clickable when they
                have no Tile object placed on them. If they are indeed Blank squares, then when
                clicked, this function interprets that click as the user attempting to play the
                current tile to clicked ImageView, or game board square. The user is prompted to
                confirm their attempted play, given the row and column they are playing at. If the
                play is confirmed, the score of the play is then calculated. If the result is
                greater than 0, then the play is legal and made. The score is added to the human
                player's score and their log is updated. The current tile is changed to the tile at
                the top of the deck and the deck is popped.

                If the game is in Solitaire, the above process repeats until the deck is empty,
                redrawing the current tile, tile count, board, score, and log after each play by
                the user.

                If the game is in Standard, HAL9000 makes his move after each of the human player's
                move. HAL9000's move is determined by placing the current tile on each blank game
                board square, calculating the score gained from the play. The highest scoring play
                is made. After HAL9000's move is made, the current tile, tile count, game board,
                scores, and logs are redrawn.

            Buttons:
                There is only one button in this Activity, the quit button. Once clicked, the user
                will be prompted to confirm they want to exit the game.

                If Yes is clicked, then the application is returned to the Launcher Activity.

                If No is clicked, the the application is returned to the current state of the Game
                Activity.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    @Override
    public void onClick(final View v) {
        if(v instanceof Button)
        {
            quitGame();
        }

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
                            Intent intent = getIntent();
                            int row = (int) v.getTag(R.string.row);
                            int col = (int) v.getTag(R.string.col);
                            Integer score = getGame().calculateScore(getGame().getCurrTile(), getGame().getBoard(), row, col);
                            if (score > 0) // legal move
                            {
                                // draw tile being played on ImageView that was clicked
                                drawTile(getGame().getCurrTile(), (ImageView) v);

                                // set tile in board model, set current tile to deck.top(), then pop deck
                                getGame().getBoard().setTile(row, col, getGame().getCurrTile());
                                getGame().getPlayerOne().setScore(getGame().getPlayerOne().getScore() + score);
                                try {
                                    getGame().setCurrTile(getGame().getDeck().top());
                                    getGame().getDeck().pop();
                                } catch (ArrayIndexOutOfBoundsException e)
                                {
                                    String exitStr = "Game over! ";
                                    getGame().getPlayerOne().setScore(getGame().getPlayerOne().getScore() + (int) score);
                                    if (getGame().getPlayerOne().getScore() > getGame().getPlayerTwo().getScore()) {
                                        exitStr += getGame().getPlayerOne().getName() + " won with a score of " + (getGame().getPlayerOne().getScore());
                                    } else {
                                        exitStr += getGame().getPlayerTwo().getName() + " won with a score of " + (getGame().getPlayerTwo().getScore());
                                    }

                                    dialog.dismiss();
                                    gameOver(exitStr);
                                }

                                String playerTurnStr = getGame().getPlayerOne().getName() + " placed a tile at ";
                                playerTurnStr += (row + 1) + ", " + (col + 1);
                                playerTurnStr += " for " + score + " points.";
                                getGame().getLog().setPlayerOneTurn(playerTurnStr);
                                getPlayer1LogView().setText(getGame().getLog().getPlayerOneTurn());

                                // draw current tile, draw board, draw tile count, draw score(s)
                                drawTile(getGame().getCurrTile(), getCurrTileLayout());
                                //drawBoard(getGame().getBoard(), getBoardLayout());
                                drawTileCount(getGame().getDeck(), getTileCountLayout());
                                drawPlayers(getGame(), getPlayer1NameLayout(), getPlayer1ScoreLayout(), getPlayer2NameLayout(), getPlayer2ScoreLayout());

                                // if a standard game, computer's turn
                                if(m_solitaireFlag == false)
                                {
                                    int test  = getGame().getDeck().getTiles().size();
                                    if(test == 0)
                                    {
                                        String exitStr = "Game over! ";

                                        if (getGame().getPlayerOne().getScore() > getGame().getPlayerTwo().getScore()) {
                                            exitStr += getGame().getPlayerOne().getName() + " won with a score of " + (getGame().getPlayerOne().getScore());
                                        } else {
                                            exitStr += getGame().getPlayerTwo().getName() + " won with a score of " + (getGame().getPlayerTwo().getScore());
                                        }

                                        dialog.dismiss();
                                        gameOver(exitStr);
                                    }

                                    Turn computerTurn = new Turn();
                                    Computer computer = new Computer();

                                    computerTurn = computer.play(getGame().getCurrTile(), getGame().getBoard());
                                    // set tile in board model, set current tile to deck.top(), then pop deck
                                    getGame().getBoard().setTile(computerTurn.getRowPlayed(),
                                                                computerTurn.getColPlayed(),
                                                                getGame().getCurrTile());
                                    View rowPlayedView = getBoardLayout().getChildAt(computerTurn.getRowPlayed());
                                    View tilePlayedView = ((TableRow) rowPlayedView).getChildAt(computerTurn.getColPlayed());
                                    drawTile(getGame().getCurrTile(), (ImageView) tilePlayedView);
                                    getGame().getPlayerTwo().setScore(getGame().getPlayerTwo().getScore() + computerTurn.getPointsScored());

                                    try {
                                        getGame().setCurrTile(getGame().getDeck().top());
                                        getGame().getDeck().pop();
                                    } catch (ArrayIndexOutOfBoundsException e)
                                    {
                                        String exitStr = "Game over! ";

                                        if (getGame().getPlayerOne().getScore() > getGame().getPlayerTwo().getScore()) {
                                            exitStr += getGame().getPlayerOne().getName() + " won with a score of " + (getGame().getPlayerOne().getScore());
                                        } else {
                                            exitStr += getGame().getPlayerTwo().getName() + " won with a score of " + (getGame().getPlayerTwo().getScore());
                                        }

                                        dialog.dismiss();
                                        gameOver(exitStr);
                                    }

                                    // draw current tile, draw board, draw tile count, draw score(s)
                                    drawTile(getGame().getCurrTile(), getCurrTileLayout());
                                    //drawBoard(getGame().getBoard(), getBoardLayout());
                                    drawTileCount(getGame().getDeck(), getTileCountLayout());
                                    drawPlayers(getGame(), getPlayer1NameLayout(), getPlayer1ScoreLayout(), getPlayer2NameLayout(), getPlayer2ScoreLayout());

                                    String computerTurnStr = getGame().getPlayerTwo().getName() + " placed a tile at ";
                                    computerTurnStr += (computerTurn.getRowPlayed() + 1) + ", " + (computerTurn.getColPlayed() + 1);
                                    computerTurnStr += " for " + computerTurn.getPointsScored() + " points.";
                                    getGame().getLog().setPlayerTwoTurn(computerTurnStr);
                                    getPlayer2LogView().setText(getGame().getLog().getPlayerTwoTurn());
                                }
                            } else {
                                // illegal move, do nothing but tell user
                                Toast.makeText(getApplicationContext(), "Illegal move! Tiles must be placed adjacent to at least one matching tile!", Toast.LENGTH_LONG).show();
                            }
                            dialog.dismiss();
                        }

                    })
                    .setNegativeButton("No", null);
            // resize AlertDialog, place it below current tile
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

    /**/
    /*
    GameActivity::quitGame()

    NAME

            GameActivity::quitGame - quits the Game Activity.

    SYNOPSIS

            public void GameActivity::quitGame();

    DESCRIPTION

            This function will exit the Game Activity and return to the Launcher Activity.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void quitGame()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Quit");
        alertDialog.setMessage("Quit game?");

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialog.show();
    }

    /**/
    /*
    GameActivity::gameOver()

    NAME

            GameActivity::gameOver - displays the winner and their score, exits the Game Activity.

    SYNOPSIS

            public void GameActivity::gameOver();

    DESCRIPTION

            This function will display an AlertDialog object to the screen, detailing the winner
            of the game and their score. The function then exits the Game Activity, returning to
            the Launcher Activity.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void gameOver(String a_exitStr)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Game Over");
        alertDialog.setMessage(a_exitStr);

        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                    }
                });

        alertDialog.show();
    }
}
