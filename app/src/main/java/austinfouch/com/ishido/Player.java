package austinfouch.com.ishido;

/**
 * Created by TheShadowMarble on 1/30/2018.
 */

public class Player {
    private int score;
    private Tile currTile;

    public void help() {}

    public void play() {}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Tile getCurrTile() {
        return currTile;
    }

    public void setCurrTile(Tile currTile) {
        this.currTile = currTile;
    }

    public Player(int score, Tile currTile) {
        this.score = score;
        this.currTile = currTile;
    }
}
