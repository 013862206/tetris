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
public class IBlock extends Block {

    public IBlock(int x, int y) {
        super();
        parts[0] = (new Part(x, y - 1));
        parts[1] = (new Part(x, y));
        parts[2] = (new Part(x, y + 1));
        parts[3] = (new Part(x, y + 2));
    }

    @Override
    void rotate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
