package austinfouch.com.ishido;

import java.util.Collection;
import java.util.Collections;
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

    public Deck() {
        this.tiles = new Vector<Tile>();
    }

    public Deck(Vector<Tile> tiles) {
        this.tiles = tiles;
    }

    public void addTile(Tile t) {
        getTiles().add(t);
    }

    public void setup() {
        // create 2 of each tile combo
        for (int i = 0; i < IshidoConstants.getTileRecurrence(); i++) {
            for (IshidoColor color : IshidoColor.values()) {
                for (IshidoSymbol symbol : IshidoSymbol.values()) {
                    Tile t = new Tile(color, symbol);
                    addTile(t);
                }
            }
        }

        Collections.shuffle(getTiles());
    }
}
