package tetris.entity;

import java.awt.Color;

/**
 * Luokka kuvastaa neliön muotoista pelipalikkaa.
 */
public class OBlock extends Block {

    /**
     * Luo uuden neliön muotoisen palikan.
     *
     * @param x Uuden palikan x-koordinaatti
     * @param y Uuden palikan y-koordinaatti
     * @param color Uuden palikan väri
     *
     * @see tetris.entity.Block#Block(int, int)
     */
    public OBlock(int x, int y, Color color) {
        super(x, y);
        parts[0] = new Part(x, y, color);
        parts[1] = new Part(x, y - 1, color);
        parts[2] = new Part(x + 1, y - 1, color);
        parts[3] = new Part(x + 1, y, color);
    }

    /**
     * Neliön muotoista palaa ei pysty kääntämää.
     */
    @Override
    public void rotateRight() {

    }

    /**
     * Neliön muotoista palaa ei pysty kääntämään.
     */
    @Override
    public void rotateLeft() {

    }
}
