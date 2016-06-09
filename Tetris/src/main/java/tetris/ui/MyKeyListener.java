package tetris.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import tetris.logic.Game;

/**
 *MyKeyListener luokka kuuntelee käyttäjän näppäimistön painalluksia. Painalluksen jälkeen luokka
 * suorittaa siihen liitetyn peli-luokan metodeja. Sekä lähetää JPanelille käskyn piirtää uusi
 * pelitilanne.
 */
public class MyKeyListener implements KeyListener {

    private Game game;
    private JPanel panel;

    /**
     *
     * @param game
     * @param panel
     */
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
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            game.rotateBlockToRight();
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
