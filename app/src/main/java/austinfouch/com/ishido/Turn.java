package austinfouch.com.ishido;

// TODO: DOC
public class Turn
{
    private Integer m_turnNum;
    private Tile m_tilePlayed;
    private Integer m_rowPlayed;
    private Integer m_colPlayed;
    private String m_playerName;
    private Integer m_pointsScored;

    public Turn()
    {
        this.m_tilePlayed = null;
        this.m_rowPlayed = null;
        this.m_colPlayed = null;
        this.m_playerName = null;
        this.m_pointsScored = null;
    }

    public Turn(Tile a_tilePlayed, Integer a_rowPlayed, Integer a_colPlayed, String a_playerName,
                Integer a_pointsScored)
    {
        this.m_tilePlayed = a_tilePlayed;
        this.m_rowPlayed = a_rowPlayed;
        this.m_colPlayed = a_colPlayed;
        this.m_playerName = a_playerName;
        this.m_pointsScored = a_pointsScored;
    }

    public Integer getPointsScored()
    {
        return m_pointsScored;
    }

    public void setPointsScored(Integer a_pointsScored)
    {
        this.m_pointsScored = m_pointsScored;
    }

    public Integer getTurnNum()
    {
        return m_turnNum;
    }

    public void setTurnNum(Integer a_turnNum)
    {
        this.m_turnNum = a_turnNum;
    }

    public Tile getTilePlayed()
    {
        return m_tilePlayed;
    }

    public void setTilePlayed(Tile a_tilePlayed)
    {
        this.m_tilePlayed = a_tilePlayed;
    }

    public Integer getRowPlayed()
    {
        return m_rowPlayed;
    }

    public void setRowPlayed(Integer a_rowPlayed)
    {
        this.m_rowPlayed = a_rowPlayed;
    }

    public Integer getColPlayed()
    {
        return m_colPlayed;
    }

    public void setColPlayed(Integer a_colPlayed)
    {
        this.m_colPlayed = a_colPlayed;
    }

    public String getPlayerName()
    {
        return m_playerName;
    }

    public void setPlayerName(String a_playerName)
    {
        this.m_playerName = a_playerName;
    }
}
