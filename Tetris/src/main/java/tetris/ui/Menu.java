/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javafx.application.Platform.exit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import tetris.logic.Game;

/**
 *
 * @author luhtalam
 */
public class Menu implements ActionListener {

    private int gameLevel;
    private JFrame frame;
    private JButton start;
    private JButton level;
    private JButton exit;

    public Menu() {
        this.gameLevel = 1;
        init();
    }

    public void init() {
        frame = new JFrame("MENU");
        frame.setPreferredSize(new Dimension(600, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "START GAME") {
            Game game = new Game(this.gameLevel, 10, 20);
            GameTable gameTable = new GameTable(game, 30, this);
            frame.setVisible(false);
        } else if (e.getActionCommand().contains("GAME LEVEL")) {
            gameLevel++;
            if (gameLevel > 10) {
                gameLevel = 1;
            }
            level.setText("GAME LEVEL: " + this.gameLevel);
        } else if (e.getActionCommand() == "EXIT") {
            System.exit(0);
        }
    }

    private void createComponents(Container container) {
        start = new JButton("START GAME");
        start.addActionListener(this);

        level = new JButton("GAME LEVEL: " + this.gameLevel);
        level.addActionListener(this);

        exit = new JButton("EXIT");
        exit.addActionListener(this);

        container.setLayout(new GridLayout(3, 1));

        container.add(start);
        container.add(level);
        container.add(exit);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
