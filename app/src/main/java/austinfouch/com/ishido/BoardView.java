package austinfouch.com.ishido;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

// TODO: DOC
public class BoardView
{
    private Board m_boardModel;
    private TableLayout m_boardLayout;
    private Context m_context;

    public BoardView(Board a_boardModel, TableLayout a_boardLayout, Context a_context)
    {
        this.m_boardModel = a_boardModel;
        this.m_boardLayout = a_boardLayout;
        this.m_context = a_context;
    }

    public void draw()
    {
        // TODO: draw
        for( Integer i = 0; i < getBoardView().getChildCount(); i++)
        {
            View rowView = getBoardView().getChildAt(i);
            if( rowView instanceof TableRow)
            {
                for( Integer j = 0; j < ((TableRow) rowView).getChildCount(); j++)
                {
                    View tileView = ((TableRow) rowView).getChildAt(j);
                    if ( tileView instanceof ImageView)
                    {
                        ImageView v = (ImageView) tileView;
                        TileView currTile = new TileView(getBoardModel().getTile(i, j), v);
                        //currTile.draw(getContext());
                    }
                }
            }
        }
    }

    public Context getContext()
    {
        return this.m_context;
    }

    public Board getBoardModel()
    {
        return m_boardModel;
    }

    public void setBoardModel(Board a_boardModel)
    {
        this.m_boardModel = a_boardModel;
    }

    public TableLayout getBoardView()
    {
        return m_boardLayout;
    }

    public void setBoardView(TableLayout a_boardLayout)
    {
        this.m_boardLayout = a_boardLayout;
    }

}
