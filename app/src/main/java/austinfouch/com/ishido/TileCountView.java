package austinfouch.com.ishido;

import android.widget.LinearLayout;
import android.widget.TextView;

//TODO: DOC
public class TileCountView
{
    public Integer getTileCount() {
        return tileCount;
    }

    public void setTileCount(Integer a_tileCount)
    {
        this.tileCount = a_tileCount;
    }

    public TextView getTileCountLayout()
    {
        return tileCountLayout;
    }

    public void setTileCountLayout(TextView a_tileCountLayout)
    {
        this.tileCountLayout = a_tileCountLayout;
    }

    private Integer tileCount;
    private TextView tileCountLayout;

    public TileCountView(Integer a_tileCount, TextView a_tileCountLayout)
    {
        this.tileCount = a_tileCount;
        this.tileCountLayout = a_tileCountLayout;
    }

    public void draw()
    {
        getTileCountLayout().setText(getTileCount());
    }
}
