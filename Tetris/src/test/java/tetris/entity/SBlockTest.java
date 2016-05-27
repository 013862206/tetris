/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.entity;

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
public class SBlockTest {
     
    SBlock block;
    int x, y;

    @Before
    public void setUp() {
        x = 3;
        y = 4;
        block = new SBlock(x, y);
    }

    @Test
    public void testConstructorSetsPositionsRight() {
        assertEquals(x -1, block.getParts()[0].getXCoordinate());
        assertEquals(y, block.getParts()[0].getYCoordinate());
        assertEquals(x, block.getParts()[1].getXCoordinate());
        assertEquals(y, block.getParts()[1].getYCoordinate());
        assertEquals(x, block.getParts()[2].getXCoordinate());
        assertEquals(y - 1, block.getParts()[2].getYCoordinate());
        assertEquals(x + 1, block.getParts()[3].getXCoordinate());
        assertEquals(y - 1, block.getParts()[3].getYCoordinate());
    }

    @Test
    public void testMoveDownSetsCoordinatesRight() {
        block.moveDown();
        assertEquals(x, block.getX());
        assertEquals(y + 1, block.getY());
    }
}
