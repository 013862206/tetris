/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import tetris.logic.Game;

/**
 *
 * @author luhtalam
 */
public class Gui implements Runnable {

    private JFrame frame;
    private Game game;
    private int scale;
    private GameTable table;

    /**
     *
     * @param game
     * @param scale
     */
    public Gui(Game game, int scale) {
        this.game = game;
        this.scale = scale;
    }

    @Override
    public void run() {
        frame = new JFrame("Tetris");
        int width = (game.getTable().getWidth()) * scale + 300;
        int height = (game.getTable().getHeight() + 1) * scale;

        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        table = new GameTable(game, scale);
        container.add(table);
        MyKeyListener listener = new MyKeyListener(game, table);
        frame.addKeyListener(listener);
    }
}
