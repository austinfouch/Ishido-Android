package austinfouch.com.ishido;

import android.widget.TableLayout;

// TODO: DOC
public class BoardView
{
    private Board m_boardModel;
    private TableLayout m_boardLayout;

    public BoardView(Board a_boardModel, TableLayout a_boardLayout)
    {
        this.m_boardModel = a_boardModel;
        this.m_boardLayout = a_boardLayout;
    }

    public void draw()
    {
        // TODO: draw
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
