package tetris.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import tetris.logic.Game;

/**
 * Luokka toimii pelin näppäimistön kuuntelijana.
 */
public class GameKeyListener implements KeyListener {

    private JPanel panel;
    private Game game;

    /**
     * Luo uuden näppäimistön kuuntelijan.
     *
     * @param game Peli, jota näppäinten painalluksilla hallinnoidaan
     * @param panel JPanel, joka piirtää peliä
     */
    public GameKeyListener(Game game, JPanel panel) {
        this.game = game;
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (game.getIsOn()) {
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
