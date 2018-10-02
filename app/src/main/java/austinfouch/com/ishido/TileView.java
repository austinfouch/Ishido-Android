package austinfouch.com.ishido;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

// TODO: DOC
public class TileView
{
    private Tile m_tileModel;
    private ImageView m_tileView;

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

    public void setTileView(ImageView a_tileView)
    {
        this.m_tileView = a_tileView;
    }

    public TileView(Tile a_tileModel, ImageView a_tileView)
    {
        this.m_tileModel = a_tileModel;
        this.m_tileView = a_tileView;
    }
}
