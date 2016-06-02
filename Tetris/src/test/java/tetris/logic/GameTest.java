/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
}
