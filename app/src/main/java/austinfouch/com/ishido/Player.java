package austinfouch.com.ishido;

/**
 * Created by TheShadowMarble on 1/30/2018.
 */

public class Player
{
    private int m_score;
    private Tile m_currTile;

    public void help()
    {

    }

    public void play()
    {

    }

    public int getScore()
    {
        return m_score;
    }

    public void setScore(int a_score)
    {
        this.m_score = a_score;
    }

    public Tile getCurrTile()
    {
        return m_currTile;
    }

    public void setCurrTile(Tile a_tile)
    {
        this.m_currTile = a_tile;
    }

    public Player(int a_score, Tile a_tile)
    {
        this.m_score = a_score;
        this.m_currTile = a_tile;
    }
}
