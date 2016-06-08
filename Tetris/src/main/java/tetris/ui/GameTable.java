package tetris.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.entity.*;
import tetris.logic.*;

/**
 *GameTable piirtää pelilaudan tilanteen.
 */
public class GameTable extends JPanel {

    private Game game;
    private int scale;

    public GameTable(Game game, int scale) {
        this.game = game;
        this.scale = scale;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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
        Block block = game.getCurrentBlock();
        for (Part p : block.getParts()) {
            g.setColor(p.getColor());
            g.fill3DRect(scale * p.getXCoordinate(), scale * p.getYCoordinate(), scale, scale, true);
        }
    }
}
