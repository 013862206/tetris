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
public class GameKeyListener implements KeyListener {

    private JPanel panel;
    private Game game;
    
    public GameKeyListener(Game game, JPanel panel) {
        this.game = game;
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (game.isOn()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    game.moveBlockLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    game.moveBlockRight();
                    break;
                case KeyEvent.VK_UP:
                    game.rotateBlockToRight();
                    break;
                case KeyEvent.VK_DOWN:
                    game.moveBlockDown();
                    break;
                case KeyEvent.VK_SPACE:
                    game.moveBlockDownFast();
                    break;
                case KeyEvent.VK_Z:
                    game.rotateBlockToLeft();
                    break;
                case KeyEvent.VK_X:
                    game.rotateBlockToRight();
                    break;
                default:
                    break;
            }
            panel.repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (game.isOn()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    game.moveBlockLeft();
                    break;
                case KeyEvent.VK_RIGHT:
                    game.moveBlockRight();
                    break;
                case KeyEvent.VK_UP:
                    game.rotateBlockToRight();
                    break;
                case KeyEvent.VK_DOWN:
                    game.moveBlockDown();
                    break;
                case KeyEvent.VK_SPACE:
                    game.moveBlockDownFast();
                    break;
                case KeyEvent.VK_Z:
                    game.rotateBlockToLeft();
                    break;
                case KeyEvent.VK_X:
                    game.rotateBlockToRight();
                    break;
                default:
                    break;
            }
            panel.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
