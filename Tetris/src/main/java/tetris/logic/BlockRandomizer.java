package tetris.logic;

import java.awt.Color;
import java.util.Random;
import tetris.entity.*;

/**
 *Uusien pelipalikoiden arvonnan suorittava luokka.
 */
public class BlockRandomizer {
    
    private Random random;
    private int x;
    private int y;
    
    public BlockRandomizer(int x, int y, Random random) {
        this.random = random;
        this.x = x;
        this.y = y;
    }
    
    public Block drawNewBlock() {
        int a = random.nextInt(7);
        if (a == 0) {
            return new IBlock(x, y, Color.cyan);
        } else if (a == 1) {
            return new JBlock(x, y, Color.blue);
        } else if (a == 2) {
            return new LBlock(x, y, Color.orange);
        } else if (a == 3) {
            return new OBlock(x, y, Color.yellow);
        } else if (a == 4) {
            return new SBlock(x, y, Color.green);
        } else if (a == 5) {
            return new TBlock(x, y, Color.magenta);
        } else {
            return new ZBlock(x, y, Color.red);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public Random getRandom() {
        return random;
    }
}
