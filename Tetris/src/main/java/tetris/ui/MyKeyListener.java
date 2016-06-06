/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import tetris.logic.Game;

/**
 *
 * @author luhtalam
 */
public class MyKeyListener implements KeyListener {

    private Game game;
    private JPanel panel;

    public MyKeyListener(Game game, JPanel panel) {
        this.game = game;
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            game.moveBlockLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            game.moveBlockRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            game.moveBlockDown();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            game.moveBlockDownFast();
        } else if (e.getKeyCode() == KeyEvent.VK_Z) {
            game.rotateBlockToLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_X) {
            game.rotateBlockToRight();
        }
        panel.repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
