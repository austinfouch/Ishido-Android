package austinfouch.com.ishido;

import java.util.Vector;

// TODO: DOC
public class ActivityLog
{
    private Vector<String> m_log;

    public ActivityLog()
    {
        this.m_log = new Vector<String>();
    }

    public ActivityLog(Vector<String> a_log)
    {
        this.m_log = a_log;
    }

    public Vector<String> getLog()
    {
        return this.m_log;
    }

    public void setLog(Vector<String> a_log)
    {
        this.m_log = a_log;
    }

    public void addActivity(String a_activity)
    {
        getLog().add(a_activity);
    }
}
