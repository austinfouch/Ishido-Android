package austinfouch.com.ishido;

import android.widget.LinearLayout;

public class ScoreBoardView
{
    private ScoreBoard m_scoreBoardModel;
    private LinearLayout m_scoreBoardView;

    public ScoreBoardView(ScoreBoard a_scoreBoardModel, LinearLayout a_scoreBoardView)
    {
        this.m_scoreBoardModel = a_scoreBoardModel;
        this.m_scoreBoardView = a_scoreBoardView;
    }

    public ScoreBoard getScoreBoardModel()
    {
        return m_scoreBoardModel;
    }

    public void setScoreBoardModel(ScoreBoard a_scoreBoardModel)
    {
        this.m_scoreBoardModel = a_scoreBoardModel;
    }

    public LinearLayout getScoreBoardView()
    {
        return m_scoreBoardView;
    }

    public void setM_scoreBoardView(LinearLayout a_scoreBoardView)
    {
        this.m_scoreBoardView = a_scoreBoardView;
    }
}
