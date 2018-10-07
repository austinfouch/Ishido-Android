package austinfouch.com.ishido;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**/
/*
    Launcher.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Launcher Activity class. This Activity is the first screen the user sees. It has two
        buttons: Solitaire and Standard.

        Solitaire.onClick():
            The user is prompted to enter their name. The Launcher then attaches the name
            to as well as a solitaire flag, marked as true, to an Intent object. Then the launcher
            launches the Game Activity with the Intent object attached.

        Standard.onClick():
            The user is prompted to enter their name. The Launcher then attaches the name
            to as well as a solitaire flag, marked as false, to an Intent object. Then the launcher
            launches the Game Activity with the Intent object attached.

    DATE

        01/30/2018

*/
/**/
public class Launcher extends AppCompatActivity
{
    private String m_playerName = "";

    /**/
    /*
    Launcher::onCreate()

    NAME

            Launcher::onCreate - called when the Launcher Activity is created.

    SYNOPSIS

            public void Launcher::onCreate();

    DESCRIPTION

            This function will set the layout of the Launcher Activity to the XML file located
            at R.layout.activity_launcher.

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
        setContentView(R.layout.activity_launcher);
    }

    /**/
    /*
    Launcher::Play()

    NAME

            Launcher::Play - launches the Game Activity as a Standard game.

    SYNOPSIS

            public void Launcher::Play();

    DESCRIPTION

            This function will prompt the user to enter their name. The Launcher then attaches the name
            to as well as a solitaire flag, marked as false, to an Intent object. Then the launcher
            launches the Game Activity with the Intent object attached.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void Play(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Standard: Enter Name");

        // Set up the input
        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input); // uncomment this line

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_playerName = input.getText().toString();
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("playerName", m_playerName);
                intent.putExtra("solitaireFlag", "false");
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    /**/
    /*
    Launcher::PlaySolitaire()

    NAME

            Launcher::Play - launches the Game Activity as a Solitaire game.

    SYNOPSIS

            public void Launcher::Play();

    DESCRIPTION

            This function will prompt the user to enter their name. The Launcher then attaches the name
            to as well as a solitaire flag, marked as true, to an Intent object. Then the launcher
            launches the Game Activity with the Intent object attached.

    RETURNS

            Void.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public void PlaySolitaire(View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Solitaire: Enter Name");

        // Set up the input
        final EditText input = new EditText(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input); // uncomment this line

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                m_playerName = input.getText().toString();
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("playerName", m_playerName);
                intent.putExtra("solitaireFlag", "true");
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
