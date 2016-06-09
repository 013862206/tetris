package tetris.entity;

import java.awt.Color;

/**
 * Luokka kuvastaa J:n muotoista pelipalikkaa.
 */
public class JBlock extends Block {

    /**
     * Luo uuden J:n muotoisen palikan.
     *
     * @param x Uuden palikan x-koordinaatti
     * @param y Uuden palikan y-koordinaatti
     * @param color Uuden palikan väri
     *
     * @see tetris.entity.Block#Block(int, int)
     */
    public JBlock(int x, int y, Color color) {
        super(x, y);
        parts[0] = new Part(x + 1, y, color);
        parts[1] = new Part(x, y, color);
        parts[2] = new Part(x - 1, y, color);
        parts[3] = new Part(x - 1, y - 1, color);
    }
}
