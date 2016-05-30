/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.entity;

import java.awt.Color;
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
public class OBlockTest {

    OBlock block;
    int x, y;
    Color color;

    @Before
    public void setUp() {
        x = 3;
        y = 4;
        color = Color.BLACK;
        block = new OBlock(x, y, color);
    }

    @Test
    public void testConstructorSetsPositionsRight() {
        assertEquals(x, block.getParts()[0].getXCoordinate());
        assertEquals(y, block.getParts()[0].getYCoordinate());
        assertEquals(x, block.getParts()[1].getXCoordinate());
        assertEquals(y - 1, block.getParts()[1].getYCoordinate());
        assertEquals(x + 1, block.getParts()[2].getXCoordinate());
        assertEquals(y - 1, block.getParts()[2].getYCoordinate());
        assertEquals(x + 1, block.getParts()[3].getXCoordinate());
        assertEquals(y, block.getParts()[3].getYCoordinate());
    }
    
    @Test
    public void testConstructorSetsColorsRight() {
        for (Part part : block.getParts()) {
            assertEquals(color, part.getColor());
        }
    }

    @Test
    public void testMoveDownSetsCoordinatesRight() {
        block.moveDown();
        assertEquals(x, block.getX());
        assertEquals(y + 1, block.getY());
    }

    @Test
    public void testRotateRightDoesNotDoAnything() {
        block.rotateRight();
        assertEquals(x, block.getParts()[0].getXCoordinate());
        assertEquals(y, block.getParts()[0].getYCoordinate());
        assertEquals(x, block.getParts()[1].getXCoordinate());
        assertEquals(y - 1, block.getParts()[1].getYCoordinate());
        assertEquals(x + 1, block.getParts()[2].getXCoordinate());
        assertEquals(y - 1, block.getParts()[2].getYCoordinate());
        assertEquals(x + 1, block.getParts()[3].getXCoordinate());
        assertEquals(y, block.getParts()[3].getYCoordinate());
    }

    @Test
    public void testRotateLeftDoesNotDoAnything() {
        block.rotateLeft();
        assertEquals(x, block.getParts()[0].getXCoordinate());
        assertEquals(y, block.getParts()[0].getYCoordinate());
        assertEquals(x, block.getParts()[1].getXCoordinate());
        assertEquals(y - 1, block.getParts()[1].getYCoordinate());
        assertEquals(x + 1, block.getParts()[2].getXCoordinate());
        assertEquals(y - 1, block.getParts()[2].getYCoordinate());
        assertEquals(x + 1, block.getParts()[3].getXCoordinate());
        assertEquals(y, block.getParts()[3].getYCoordinate());
    }
}
