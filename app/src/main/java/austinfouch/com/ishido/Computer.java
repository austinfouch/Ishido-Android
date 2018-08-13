package austinfouch.com.ishido;

// TODO: DOC
public class Computer extends Player
{

    public Turn play(Tile currTile, Board gameBoard)
    {
        Integer currValue = 0;
        Integer bestValue = 0;
        Integer bestRow = -1;
        Integer bestCol = -1;
        // Loop over game board
        for (int row = 0; row < IshidoConstants.NUM_BOARD_ROWS; row++)
        {
            for (int col = 0; col < IshidoConstants.NUM_BOARD_COLS; col++)
            {
                currValue = isLegalPlay(currTile, gameBoard, row, col);
                if( currValue > 0 && currValue > bestValue)
                {
                    bestValue = currValue;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        Turn turn = new Turn(currTile, bestRow, bestCol, getName(), bestValue);

        return turn;
    }
}
