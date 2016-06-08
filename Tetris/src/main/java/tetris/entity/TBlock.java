package tetris.entity;

import java.awt.Color;

/**
 *T-muotoisen palikan konstruointi.
 */
public class TBlock extends Block {

    public TBlock(int x, int y, Color color) {
        super(x, y);
        parts[0] = new Part(x, y - 1, color);
        parts[1] = new Part(x, y, color);
        parts[2] = new Part(x - 1, y, color);
        parts[3] = new Part(x + 1, y, color);
    }
}
