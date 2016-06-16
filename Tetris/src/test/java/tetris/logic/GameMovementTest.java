/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logic;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.entity.Block;
import tetris.entity.IBlock;
import tetris.entity.Part;

/**
 *
 * @author luhtalam
 */
public class GameMovementTest {

    Game game;
    int gameLevel;
    int tableWidth;
    int tableHeight;

    @Before
    public void setUp() {
        gameLevel = 5;
        tableWidth = 10;
        tableHeight = 20;
        game = new Game(gameLevel, tableWidth, tableHeight);
    }

    @Test
    public void testSetCurrentBlockSetsBlockRight() {
        int x = 5;
        int y = 5;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        assertEquals(block, game.getCurrentBlock());
    }

    @Test
    public void testMoveBlockLeftMovesBlockWhenFreeSpace() {
        int x = 5;
        int y = 5;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.moveBlockLeft();
        assertEquals(x - 1, block.getX());
    }

    @Test
    public void testMoveBlockLeftDoesNotMoveBlockWhenNoFreeSpace() {
        int x = 5;
        int y = 5;
        game.getTable().getTable()[5][4] = new Part(4, 5, Color.BLACK);
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.moveBlockLeft();
        assertEquals(x, block.getX());
    }

    @Test
    public void testMoveBlockRightMovesBlockWhenFreeSpace() {
        int x = 5;
        int y = 5;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.moveBlockRight();
        assertEquals(x + 1, block.getX());
    }

    @Test
    public void testMoveBlockRightDoesNotMoveBlockWhenNoFreeSpace() {
        int x = 5;
        int y = 5;
        game.getTable().getTable()[5][6] = new Part(6, 5, Color.BLACK);
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.moveBlockRight();
        assertEquals(x, block.getX());
    }

    @Test
    public void testMoveBlockDownMovesBlockWhenFreeSpace() {
        int x = 5;
        int y = 5;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.moveBlockDown();
        assertEquals(y + 1, block.getY());
    }

    @Test
    public void testRotateBlockRightRotatesBlockWhenFreeSpace() {
        int x = 5;
        int y = 5;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.rotateBlockToRight();
        assertEquals(y - 1, block.getParts()[0].getYCoordinate());
        assertEquals(x, block.getParts()[0].getXCoordinate());
    }

    @Test
    public void testRotateBlockLeftRotatesBlockWhenFreeSpace() {
        int x = 5;
        int y = 5;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.rotateBlockToLeft();
        assertEquals(y + 1, block.getParts()[0].getYCoordinate());
        assertEquals(x, block.getParts()[0].getXCoordinate());
    }

    @Test
    public void testCheckTableRemoveFullRows() {
        int y1 = 0;
        int y2 = 5;
        for (int x = 0; x < tableWidth; x++) {
            game.getTable().getTable()[y1][x] = new Part(x, y1, Color.BLACK);
            game.getTable().getTable()[y2][x] = new Part(x, y2, Color.BLACK);
        }
        game.checkTable();
        for (int x = 0; x < tableWidth; x++) {
            assertNull(game.getTable().getTable()[y1][x]);
            assertNull(game.getTable().getTable()[y2][x]);
        }
    }

    @Test
    public void testCheckTableAddPointsRight() {
        int y1 = 0;
        int y2 = 5;
        for (int x = 0; x < tableWidth; x++) {
            game.getTable().getTable()[y1][x] = new Part(x, y1, Color.BLACK);
            game.getTable().getTable()[y2][x] = new Part(x, y2, Color.BLACK);
        }
        game.checkTable();
        assertEquals(gameLevel * 100, game.getPointStatistics().getPoints());
    }

    @Test
    public void testNextBlockAddCurrentBlockPartsToTable() {
        int x = 5;
        int y = 19;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.nextBlock();
        for (Part part : block.getParts()) {
            assertEquals(part, game.getTable().getTable()[part.getYCoordinate()][part.getXCoordinate()]);
        }
    }

    @Test
    public void testNextBlockChecksTable() {
        for (int x = 0; x < 6; x++) {
            game.getTable().getTable()[19][x] = new Part(x, 19, Color.BLACK);
        }
        IBlock block = new IBlock(7, 19, Color.BLACK);
        game.setCurrentBlock(block);
        game.nextBlock();
        assertNull(game.getTable().getTable()[19][0]);
    }

    @Test
    public void testNextBlockMoveNextBlockToCurrentIfGameCanContinue() {
        int x = 5;
        int y = 19;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        Block nextBlock = game.getNextBlock();
        game.nextBlock();
        assertEquals(nextBlock, game.getCurrentBlock());
    }

    @Test
    public void testNextBlockDrawNewNextBlockIfGameCanContinue() {
        int x = 5;
        int y = 19;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        Block nextBlock = game.getNextBlock();
        game.nextBlock();
        assertNotNull(game.getNextBlock());
    }

    @Test
    public void testNextBlockIncreasePointStatisticsBlocksByOneIfGameCanContinue() {
        int x = 5;
        int y = 19;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.nextBlock();
        assertEquals(2, game.getPointStatistics().getBlocks());
    }

    @Test
    public void testNextBlockTurnGameOffIfGameCanNotContinue() {
        game.nextBlock();
        assertFalse(game.isOn());
    }

    @Test
    public void testMoveBlockDownCallsNextBlockWhenNoFreeSpace() {
        int x = 5;
        int y = 19;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.moveBlockDown();
        assertNotEquals(block, game.getCurrentBlock());
    }

    @Test
    public void testMoveBlockDownFastWorksNoObstacle() {
        int x = 5;
        int y = 1;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.moveBlockDownFast();
        assertEquals(19, block.getY());
        assertNotEquals(block, game.getCurrentBlock());
    }

    @Test
    public void testMoveBlockDownFastWorksObstacle() {
        int x = 5;
        int y = 1;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.getTable().getTable()[12][6] = new Part(7, 12, Color.BLACK);
        game.moveBlockDownFast();
        assertEquals(11, block.getY());
        assertNotEquals(block, game.getCurrentBlock());
    }

}
