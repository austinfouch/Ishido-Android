package austinfouch.com.ishido;

import java.lang.reflect.Field;

public class IshidoConstants {
    private final static int MAX_DECK_SIZE = 72;
    private final static int MAX_ROWS = 7;
    private final static int MAX_COLS = 11;
    private final static int MAX_COLORS = 5;
    private final static int MAX_SYMBOLS = 5;
    private final static int TILE_RECURRENCE = 2;

    public static int getMaxDeckSize() {
        return MAX_DECK_SIZE;
    }

    public static int getMaxRows() {
        return MAX_ROWS;
    }

    public static int getMaxCols() {
        return MAX_COLS;
    }

    public static int getMaxColors() {
        return MAX_COLORS;
    }

    public static int getTileRecurrence() {
        return TILE_RECURRENCE;
    }

    public static int getMaxSymbols() {

        return MAX_SYMBOLS;
    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
