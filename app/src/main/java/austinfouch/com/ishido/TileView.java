package austinfouch.com.ishido;

import android.view.View;

public class TileView
{
    private Tile m_tileModel;
    private View m_tileView;

    public Tile getTileModel()
    {
        return this.m_tileModel;
    }

    public void setTileModel(Tile a_tileModel)
    {
        this.m_tileModel = a_tileModel;
    }

    public View getTileView()
    {
        return this.m_tileView;
    }

    public void setTileView(View a_tileView)
    {
        this.m_tileView = a_tileView;
    }

    public TileView(Tile a_tileModel, View a_tileView)
    {
        this.m_tileModel = a_tileModel;
        this.m_tileView = a_tileView;
    }

    public void draw()
    {
        this.m_tileView.setBackgroundResource(this.m_tileModel.getResourceID());
    }
}
