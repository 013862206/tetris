package tetris.ui;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import tetris.entity.*;
import tetris.logic.*;

/**
 * GameTable piirtää pelilaudan tilannetta ja sisältää peliloopin.
 */
public class GameTable extends JPanel implements ActionListener {

    private Game game;
    private int scale;
    private JFrame frame;
    private Timer timer;
    private Menu menu;

    /**
     *
     * @param game
     * @param scale
     */
    public GameTable(Game game, int scale, Menu menu) {
        this.menu = menu;
        this.game = game;
        this.scale = scale;
        frame = new JFrame("Tetris");
        initialize();
        timer = new Timer(1000 / game.getGameLevel(), this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTable(g);
        drawCurrentBlock(g);
        drawPointStatistics(g);
        drawNextBlock(g);
        if (!game.isOn()) {
            drawGameOver(g);
        }
    }

    private void drawTable(Graphics g) {
        Part part;
        for (int y = 0; y < game.getTable().getHeight(); y++) {
            for (int x = 0; x < game.getTable().getWidth(); x++) {
                if (game.getTable().getTable()[y][x] == null) {
                    g.setColor(Color.white);
                    g.drawRect(scale * x, scale * y, scale, scale);
                } else {
                    part = game.getTable().getTable()[y][x];
                    g.setColor(part.getColor());
                    g.fill3DRect(scale * x, scale * y, scale, scale, true);
                }
            }
        }
    }

    private void drawCurrentBlock(Graphics g) {
        Block block = game.getCurrentBlock();
        for (Part p : block.getParts()) {
            g.setColor(p.getColor());
            g.fill3DRect(scale * p.getXCoordinate(), scale * p.getYCoordinate(), scale, scale, true);
        }
    }

    private void drawPointStatistics(Graphics g) {
        Font font = new Font("Helvetica", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Game Level: " + game.getPointStatistics().getGameLevel(),
                game.getTable().getWidth() * scale + 50, 50);
        g.drawString("Points: " + game.getPointStatistics().getPoints(),
                game.getTable().getWidth() * scale + 50, 100);
        g.drawString("Blocks: " + game.getPointStatistics().getBlocks(),
                game.getTable().getWidth() * scale + 50, 150);
        g.drawString("Lines: " + game.getPointStatistics().getLines(),
                game.getTable().getWidth() * scale + 50, 200);
    }

    private void drawNextBlock(Graphics g) {
        Block block = game.getNextBlock();
        int x = block.getX();
        int y = block.getY();
        block.move(-x, -y);
        for (Part p : block.getParts()) {
            g.setColor(p.getColor());
            g.fill3DRect(scale * (game.getTable().getWidth() + p.getXCoordinate() + 1) + 50,
                    250 + scale * p.getYCoordinate(), scale, scale, true);
        }
        block.move(x, y);
    }

    private void drawGameOver(Graphics g) {
        Font font = new Font("Helvetica", Font.BOLD, 50);
        g.setFont(font);
        g.setColor(Color.red);
        g.drawString("GAME OVER!", scale * 3, scale * 10);
    }

    private void initialize() {
        int width = (game.getTable().getWidth()) * scale + 350;
        int height = (game.getTable().getHeight() + 2) * scale;

        frame.setPreferredSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JPanel buttonsPanel = new JPanel();
        JButton menu = new JButton("MENU");
        JButton exit = new JButton("EXIT");
        JButton newGame = new JButton("NEW GAME");
        menu.setFocusable(false);
        exit.setFocusable(false);
        newGame.setFocusable(false);

        menu.addActionListener(this);
        exit.addActionListener(this);
        newGame.addActionListener(this);

        GridLayout gl = new GridLayout();
        gl.setColumns(3);
        buttonsPanel.setLayout(gl);
        buttonsPanel.add(newGame);
        buttonsPanel.add(menu);
        buttonsPanel.add(exit);
        container.add(buttonsPanel, BorderLayout.NORTH);
        container.add(this, BorderLayout.CENTER);
        
        GameKeyListener listener = new GameKeyListener(game, this);
        frame.addKeyListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!game.isOn()) {
            timer.stop();
        }
        game.moveBlockDown();
        if ("EXIT".equals(e.getActionCommand())) {
            System.exit(0);
        }
        if ("MENU".equals(e.getActionCommand())) {
            menu.getFrame().setVisible(true);
            frame.dispose();
        }
        if ("NEW GAME".equals(e.getActionCommand())) {
            game = new Game(game.getGameLevel(), game.getTable().getWidth(), game.getTable().getHeight());
            initialize();
            timer.restart();
        }
        repaint();
    }
}
