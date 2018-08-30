package austinfouch.com.ishido;

import android.widget.LinearLayout;
import android.widget.TextView;

//TODO: DOC
public class TileCountView
{
    private Integer m_tileCount;
    private TextView m_tileCountLayout;

    public TileCountView()
    {
        this.m_tileCount = 0;
    }

    public Integer getTileCount() {
        return m_tileCount;
    }

    public void setTileCount(Integer a_tileCount)
    {
        this.m_tileCount = a_tileCount;
    }

    public TextView getTileCountLayout()
    {
        return m_tileCountLayout;
    }

    public void setTileCountLayout(TextView a_tileCountLayout)
    {
        this.m_tileCountLayout = a_tileCountLayout;
    }


    public TileCountView(Integer a_tileCount, TextView a_tileCountLayout)
    {
        this.m_tileCount = a_tileCount;
        this.m_tileCountLayout = a_tileCountLayout;
    }

    public void draw()
    {
        getTileCountLayout().setText(getTileCount());
    }
}
