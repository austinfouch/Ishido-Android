package austinfouch.com.ishido;

import java.util.Vector;

/**
 * Created by TheShadowMarble on 1/30/2018.
 */

public class Deck {
    private Vector<Tile> tiles;

    public Vector<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(Vector<Tile> tiles) {
        this.tiles = tiles;
    }

    public Deck(Vector<Tile> tiles) {
        this.tiles = tiles;
    }
}
