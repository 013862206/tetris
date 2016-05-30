/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logic;

import java.awt.Color;
import java.util.Random;
import tetris.entity.*;

/**
 *
 * @author luhtalam
 */
public class BlockRandomizer {
    
    private Random random;
    private int x;
    private int y;
    
    public BlockRandomizer(int x, int y) {
        this.random = new Random();
        this.x = x;
        this.y = y;
    }
    
    public Block drawNewBlock() {
        int a = random.nextInt(7);
        if (a == 0) {
            return new IBlock(x, y, Color.BLUE);
        } else if (a == 1) {
            return new JBlock(x, y, Color.GREEN);
        } else if (a == 2) {
            return new LBlock(x, y, Color.ORANGE);
        } else if (a == 3) {
            return new OBlock(x, y, Color.PINK);
        } else if (a == 4) {
            return new SBlock(x, y, Color.RED);
        } else if (a == 5) {
            return new TBlock(x, y, Color.YELLOW);
        } else {
            return new ZBlock(x, y, Color.MAGENTA);
        }
    }
}
