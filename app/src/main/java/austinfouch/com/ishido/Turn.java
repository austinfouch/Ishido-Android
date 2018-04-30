package austinfouch.com.ishido;

public class Turn
{
    private Integer m_turnNum;
    private IshidoColor m_colorPlayed;
    private IshidoSymbol m_symbolPlayed;
    private Integer m_rowPlayed;
    private Integer m_colPlayed;
    private String m_playerName;
    private Integer m_pointsScored;

    public Turn()
    {
    }

    public Turn(Integer a_turnNum, IshidoColor a_colorPlayed, IshidoSymbol a_symbolPlayed,
                Integer a_rowPlayed, Integer a_colPlayed, String a_playerName,
                Integer a_pointsScored)
    {
        this.m_turnNum = a_turnNum;
        this.m_colorPlayed = a_colorPlayed;
        this.m_symbolPlayed = a_symbolPlayed;
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

    public IshidoColor getColorPlayed()
    {
        return m_colorPlayed;
    }

    public void setColorPlayed(IshidoColor a_colorPlayed)
    {
        this.m_colorPlayed = a_colorPlayed;
    }

    public IshidoSymbol getSymbolPlayed()
    {
        return m_symbolPlayed;
    }

    public void setSymbolPlayed(IshidoSymbol a_symbolPlayed)
    {
        this.m_symbolPlayed = a_symbolPlayed;
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

    @Override
    public String toString() {
        String turnStr = "[Turn " + getTurnNum() + "]: ";
        turnStr += getPlayerName() + " played a ";
        turnStr += getColorPlayed() + " " + getSymbolPlayed() + " tile at ";
        turnStr += "row " + getRowPlayed() + ", column " + getColPlayed() + " for ";
        turnStr += getPointsScored() + " points.";
        return turnStr;
    }
}
