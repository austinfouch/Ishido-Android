package austinfouch.com.ishido;

import java.util.List;
import java.util.Vector;

/**/
/*
    Human.java

    AUTHOR

        Austin Fouch

    DESCRIPTION

        Human class. Extends the Player class.

    DATE

        01/30/2018

*/
/**/
public class Human extends Player
{
    public Human()
    {
        super();
    }

    /**/
    /*
    Human::Human()

    NAME

            Human::Human - constructor for the Board class.

    SYNOPSIS

            public Human::Human();

    DESCRIPTION

            This function will construct a Human object. This is done by calling the Player
            constructor through the super() function.

    RETURNS

            No return value.

    AUTHOR

            Austin Fouch

    DATE

            1/30/2018

    */
    /**/
    public Human(String a_name, Integer a_score)
    {
        super(a_name, a_score);
    }
}
