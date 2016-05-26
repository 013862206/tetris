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
public class OBlock extends Block {

    public OBlock(int x, int y) {
        super();
        parts[0] = (new Part(x, y));
        parts[1] = (new Part(x, y - 1));
        parts[2] = (new Part(x + 1, y - 1));
        parts[3] = (new Part(x + 1, y));
    }

    @Override
    public void rotate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
