package tetris.entity;

import java.awt.Color;

/**
 *O-muotoisen palikan konstruointi.
 */
public class OBlock extends Block {

    public OBlock(int x, int y, Color color) {
        super(x, y);
        parts[0] = new Part(x, y, color);
        parts[1] = new Part(x, y - 1, color);
        parts[2] = new Part(x + 1, y - 1, color);
        parts[3] = new Part(x + 1, y, color);
    }

    @Override
    public void rotateRight() {

    }

    @Override
    public void rotateLeft() {

    }
}
