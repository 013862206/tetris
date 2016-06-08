package tetris.entity;

import java.awt.Color;

/**
 *Z-muotoisen palikan konstruointi.
 */
public class ZBlock extends Block {

    public ZBlock(int x, int y, Color color) {
        super(x, y);
        parts[0] = new Part(x + 1, y, color);
        parts[1] = new Part(x, y, color);
        parts[2] = new Part(x, y - 1, color);
        parts[3] = new Part(x - 1, y - 1, color);
    }
}
