/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.JPanel;
import tetris.logic.Game;

/**
 *
 * @author luhtalam
 */
public class GameLoop extends Timer implements ActionListener{
    private Game game;
    private JPanel panel;
    
    public GameLoop(Game game, JPanel panel) {
        this.game = game;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!game.isOn()) {
            return;
        }
        game.moveBlockDown();
        panel.repaint();  
    }
}
