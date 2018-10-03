package austinfouch.com.ishido;

import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

// TODO: DOC
public class ScoreBoard {
    private Vector<Integer> m_scores;
    private Vector<String> m_names;

    private TextView m_player1NameLayout;
    private TextView m_player1ScoreLayout;
    private TextView m_player2NameLayout;
    private TextView m_player2ScoreLayout;

    public ScoreBoard()
    {
    }


    public void draw()
    {
        getPlayer1NameLayout().setText(getNames().get(0));
        getPlayer2NameLayout().setText(getNames().get(1));
        redraw();
    }

    public void redraw()
    {
        getPlayer1ScoreLayout().setText(getScores().get(0));
        getPlayer2ScoreLayout().setText(getScores().get(1));
    }

    public ScoreBoard(Vector<Integer> a_scores, Vector<String> a_names, TextView a_player1NameLayout,
                      TextView a_player1ScoreLayout, TextView a_player2NameLayout,
                      TextView a_player2ScoreLayout)
    {
        this.m_scores = a_scores;
        this.m_names = a_names;
        this.m_player1NameLayout = a_player1NameLayout;
        this.m_player1ScoreLayout = a_player1ScoreLayout;
        this.m_player2NameLayout = a_player2NameLayout;
        this.m_player2ScoreLayout = a_player2ScoreLayout;
    }

    public Vector<Integer> getScores()
    {
        return m_scores;
    }

    public void setScores(Vector<Integer> a_scores)
    {
        this.m_scores = a_scores;
    }

    public Vector<String> getNames()
    {
        return m_names;
    }

    public void setNames(Vector<String> a_names)
    {
        this.m_names = a_names;
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

    public void setM_player2NameLayout(TextView a_player2NameLayout)
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
}
