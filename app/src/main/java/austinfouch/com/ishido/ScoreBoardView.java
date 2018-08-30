package austinfouch.com.ishido;

import android.widget.LinearLayout;
import android.widget.TextView;

// TODO: DOC
public class ScoreBoardView
{
    private ScoreBoard m_scoreBoardModel;
    private TextView m_player1_name;
    private TextView m_player1_score;
    private TextView m_player2_name;
    private TextView m_player2_score;

    public ScoreBoardView(ScoreBoard a_scoreBoardModel, TextView a_player1_name,
                          TextView a_player1_score, TextView a_player2_name,
                          TextView a_player2_score)
    {
        this.m_scoreBoardModel = a_scoreBoardModel;
        this.m_player1_name = a_player1_name;
        this.m_player1_score = a_player1_score;
        this.m_player2_name = a_player2_name;
        this.m_player2_score = a_player2_score;
    }

    public void draw()
    {
        getPlayer1Name().setText(getScoreBoardModel().getNames().get(0));
        getPlayer1Score().setText(getScoreBoardModel().getScores().get(0));
        getPlayer2Name().setText(getScoreBoardModel().getScores().get(1));
        getPlayer2Score().setText(getScoreBoardModel().getScores().get(1));
    }

    public ScoreBoard getScoreBoardModel()
    {
        return m_scoreBoardModel;
    }

    public void setScoreBoardModel(ScoreBoard a_scoreBoardModel)
    {
        this.m_scoreBoardModel = a_scoreBoardModel;
    }

    public void setPlayer1Name(TextView a_player1_name)
    {
        this.m_player1_name = a_player1_name;
    }

    public TextView getPlayer1Name()
    {
        return m_player1_name;
    }

    public void setPlayer1Score(TextView a_player1_score)
    {
        this.m_player1_score = a_player1_score;
    }

    public TextView getPlayer1Score()
    {
        return m_player1_score;
    }

    public void setPlayer2Name(TextView a_player2_name)
    {
        this.m_player2_name = a_player2_name;
    }

    public TextView getPlayer2Name()
    {
        return m_player2_name;
    }

    public void setPlayer2Score(TextView a_player2_score)
    {
        this.m_player2_score = a_player2_score;
    }

    public TextView getPlayer2Score()
    {
        return m_player2_score;
    }
}
