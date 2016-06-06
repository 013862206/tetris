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
import tetris.entity.*;

/**
 *
 * @author luhtalam
 */
public class GameTest {

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
    public void testConstructorSetsGameLevelRight() {
        assertEquals(gameLevel, game.getGameLevel());
        assertEquals(gameLevel, game.getPointStatistics().getGameLevel());
    }

    @Test
    public void testConstructorSetsTableWidthRight() {
        assertEquals(tableWidth, game.getTable().getWidth());
    }

    @Test
    public void testConstructorSetsTableHeightRight() {
        assertEquals(tableHeight, game.getTable().getHeight());
    }

    @Test
    public void testConstructorSetsNewBlocksCoordinatesRight() {
        assertEquals(tableWidth / 2, game.getBlockRandomizer().getX());
        assertEquals(1, game.getBlockRandomizer().getY());
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
        game.getTable().getTable()[5][4] = new Part(4,5, Color.BLACK);
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
        game.getTable().getTable()[5][6] = new Part(6,5, Color.BLACK);
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
        assertEquals(y, block.getParts()[0].getYCoordinate());
        assertEquals(x + 1, block.getParts()[0].getXCoordinate());
    }
    
    @Test
    public void testRotateBlockLeftRotatesBlockWhenFreeSpace() {
        int x = 5;
        int y = 5;
        IBlock block = new IBlock(x, y, Color.BLACK);
        game.setCurrentBlock(block);
        game.rotateBlockToLeft();
        assertEquals(y, block.getParts()[0].getYCoordinate());
        assertEquals(x - 1, block.getParts()[0].getXCoordinate());
    }
    
    @Test
    public void testCheckTableRemoveFullRow() {
        
    }
    
    @Test
    public void testCheckTableAddPointsRight() {
        
    }
    
    
}
