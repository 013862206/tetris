/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;

/**
 *
 * @author luhtalam
 */
public class TBlock extends Block {

    public TBlock(int x, int y) {
        super(x,y);
        parts[0] = (new Part(x, y - 1));
        parts[1] = (new Part(x, y));
        parts[2] = (new Part(x - 1, y));
        parts[3] = (new Part(x + 1, y));
    }
}
