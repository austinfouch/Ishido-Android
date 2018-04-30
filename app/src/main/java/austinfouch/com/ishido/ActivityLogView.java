package austinfouch.com.ishido;

import android.view.View;
import android.widget.ScrollView;

public class ActivityLogView
{
    private ActivityLog m_logModel;
    private ScrollView m_logView;

    public ActivityLogView(ActivityLog a_logModel, ScrollView a_logView)
    {
        this.m_logModel = a_logModel;
        this.m_logView = a_logView;
    }

    public ActivityLog getLogModel()
    {
        return m_logModel;
    }

    public void setLogModel(ActivityLog a_logModel)
    {
        this.m_logModel = a_logModel;
    }

    public View getLogView()
    {
        return m_logView;
    }

    public void setLogView(ScrollView a_logView)
    {
        this.m_logView = a_logView;
    }
}
