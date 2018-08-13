package austinfouch.com.ishido;

import java.util.List;
import java.util.Vector;

// TODO: DOC
public class Human extends Player
{

    public Turn play(Tile a_currTile, Board a_gameBoard, Integer a_rowIndex, Integer a_colIndex)
    {
        Turn turn  = new Turn();
        Integer value = isLegalPlay(a_currTile, a_gameBoard, a_rowIndex, a_colIndex);

        if (value > 0)
        {
            turn = new Turn(a_currTile, a_rowIndex, a_colIndex, getName(), value);
        }

        return turn;
    }
}
