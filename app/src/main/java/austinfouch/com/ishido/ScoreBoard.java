package austinfouch.com.ishido;

import java.util.HashMap;
import java.util.Map;

public class ScoreBoard
{
    private HashMap<String, Integer> m_scoreBoard;

    public ScoreBoard()
    {
        this.m_scoreBoard = new HashMap<String, Integer>();
    }

    public ScoreBoard(HashMap<String, Integer> a_scoreBoard)
    {
        this.m_scoreBoard = a_scoreBoard;
    }

    public Map<String, Integer> getScoreBoard()
    {
        return m_scoreBoard;
    }

    public void setScoreBoard(HashMap<String, Integer> a_scoreBoard)
    {
        this.m_scoreBoard = a_scoreBoard;
    }
}
