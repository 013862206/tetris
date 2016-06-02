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
public class PointStatisticsTest {

    PointStatistics points;
    int gameLevel;

    @Before
    public void setUp() {
        gameLevel = 3;
        points = new PointStatistics(gameLevel);
    }

    @Test
    public void testConstructorSetsGameLevelRight() {
        assertEquals(gameLevel, points.getGameLevel());
    }

    @Test
    public void testConstructorSetsPointsRight() {
        assertEquals(0, points.getPoints());
    }

    @Test
    public void testConstructorSetsBlocksRight() {
        assertEquals(1, points.getBlocks());
    }

    @Test
    public void testConstructorSetsLinesRight() {
        assertEquals(0, points.getLines());
    }

    @Test
    public void testNewBlockIncreaseBlocksByOne() {
        points.newBlock();
        assertEquals(2, points.getBlocks());
    }
    
    @Test
    public void testaddPointsIncreasePointsRightZeroRows() {
        points.addPoints(0);
        assertEquals(0, points.getPoints());
    }
    
    @Test
    public void testaddPointsIncreaseLinesRightZeroRows() {
        points.addPoints(0);
        assertEquals(0, points.getLines());
    }

    @Test
    public void testaddPointsIncreasePointsRightOneRow() {
        points.addPoints(1);
        assertEquals(40 * gameLevel, points.getPoints());
    }
    
    @Test
    public void testaddPointsIncreaseLinesRightOneRow() {
        points.addPoints(1);
        assertEquals(1, points.getLines());
    }

    @Test
    public void testaddPointsIncreasePointsRightTwoRows() {
        points.addPoints(2);
        assertEquals(100 * gameLevel, points.getPoints());
    }
    
    @Test
    public void testaddPointsIncreaseLinesRightTwoRows() {
        points.addPoints(2);
        assertEquals(2, points.getLines());
    }

    @Test
    public void testaddPointsIncreasePointsRightThreeRows() {
        points.addPoints(3);
        assertEquals(300 * gameLevel, points.getPoints());
    }
    
    @Test
    public void testaddPointsIncreaseLinesRightThreeRows() {
        points.addPoints(3);
        assertEquals(3, points.getLines());
    }

    @Test
    public void testaddPointsIncreasePointsRightFourRows() {
        points.addPoints(4);
        assertEquals(1200 * gameLevel, points.getPoints());
    }
    
    @Test
    public void testaddPointsIncreaseLinesRightFourRows() {
        points.addPoints(4);
        assertEquals(4, points.getLines());
    }
}
