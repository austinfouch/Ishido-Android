package austinfouch.com.ishido;

import java.lang.reflect.Field;

public class IshidoConstants
{
    public final static int DECK_SIZE = 72;
    public final static int NUM_BOARD_ROWS = 8;
    public final static int NUM_BOARD_COLS = 12;
    public final static int NUM_COLORS = 6;
    public final static int NUM_SYMBOLS = 6;
    public final static int UNQ_TILE_COUNT = 2;

    public static int getResId(String resName, Class<?> c)
    {
        try
        {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1;
        }
    }
}
