package austinfouch.com.ishido;

import android.widget.TableLayout;

public class BoardView
{
    private Board m_boardModel;
    private TableLayout m_boardView;

    public BoardView(Board a_boardModel, TableLayout a_boardView)
    {
        this.m_boardModel = a_boardModel;
        this.m_boardView = a_boardView;
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
        return m_boardView;
    }

    public void setBoardView(TableLayout a_boardView)
    {
        this.m_boardView = a_boardView;
    }
}
