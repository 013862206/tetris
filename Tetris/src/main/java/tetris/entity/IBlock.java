/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.entity;

import java.awt.Color;

/**
 *
 * @author luhtalam
 */
public class IBlock extends Block {

    public IBlock(int x, int y, Color color) {
        super(x, y);
        parts[0] = new Part(x, y - 1, color);
        parts[1] = new Part(x, y, color);
        parts[2] = new Part(x, y + 1, color);
        parts[3] = new Part(x, y + 2, color);
    }
}
