package austinfouch.com.ishido;

/**/
/*
    Comptuer.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Computer class. Hold information related to a Computer player in a standard game of Ishido.
        Extends the Player class.

    DATE

        01/30/2018

*/
/**/
public class Computer extends Player
{
    public Computer()
    {
        super();
    }

    /**/
    /*
    Computer::Computer()

    NAME

            Computer::Computer - constructor for the Computer class.

    SYNOPSIS

            public Computer::Computer();

    DESCRIPTION

            This function will construct a Computer object. This is done by calling the Player
            constructor through the super() function.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Computer(String a_name, Integer a_score)
    {
        super(a_name, a_score);
    }

    /**/
    /*
    Computer::Play()

    NAME

            Computer::Play() - returns the most optimal turn given tile and board objects.

    SYNOPSIS

            public Turn Computer::Play(Tile a_currTile, Board a_board);
                a_currTile  --> Tile object that is being compared to the board object.
                a_board     --> Board object that is being searched for optimal moves using a Tile.

    DESCRIPTION

            This function will place the given Tile object on each position on the given Board
            object, saving the score of each play. The play that nets the computer the most points
            is returned as a Turn object.

            This is done by first looping over each vector of vectors in the given Board
            object and then looping over each of these vectors and calculating the score if a user
            was to play the given Tile object at this position. If this play is the play that
            gains the computer the most points, then this play is saved.

            Once the entire Board object is iterated over, the optimal Turn object is created and
            returned.

    RETURNS

            Turn object.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Turn play(Tile a_currTile, Board a_board)
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
                currValue = isLegalPlay(a_currTile, a_board, row, col);
                if(currValue > bestValue)
                {
                    bestValue = currValue;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        Turn turn = new Turn(a_currTile, bestRow, bestCol, getName(), bestValue);

        return turn;
    }
}
