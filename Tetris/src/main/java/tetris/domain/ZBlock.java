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
public class ZBlock extends Block {
    
    public ZBlock(int x, int y) {
        super.addPart(new Part(x, y));
        super.addPart(new Part(x + 1, y));
        super.addPart(new Part(x + 1, y + 1));
        super.addPart(new Part(x + 2, y + 1));
    }
}
