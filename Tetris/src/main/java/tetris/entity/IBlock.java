package tetris.entity;

import java.awt.Color;

/**
 *I-muotoisen palikan konstruointi. 
 */
public class IBlock extends Block {

    public IBlock(int x, int y, Color color) {
        super(x, y);
        parts[0] = new Part(x - 1, y, color);
        parts[1] = new Part(x, y, color);
        parts[2] = new Part(x + 1, y, color);
        parts[3] = new Part(x + 2, y, color);
    }
}
