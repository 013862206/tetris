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

import java.awt.Color;

import tetris.entity.Table;

/**
 *
 * @author luhtalam
 */
public class TableTest {

    Table table;
    int x, y;

    @Before
    public void setUp() {
        this.x = 10;
        this.y = 20;
        table = new Table(x, y);
    }

    @Test
    public void testConstructorSetsHeightRight() {
        assertEquals(this.y, table.getTable().length);
    }

    @Test
    public void testConstructorSetsWidthRight() {
        assertEquals(this.x, table.getTable()[0].length);
    }

    @Test
    public void testAddBlockWorks() {
        JBlock block = new JBlock(5, 5, Color.BLACK);
        table.addBlock(block);
        int x, y;
        for (Part part : block.getParts()) {
            x = part.getXCoordinate();
            y = part.getYCoordinate();
            assertEquals(part, table.getTable()[y][x]);
        }
    }

    @Test
    public void testIsFreeReturnTrueWhenFree() {
        table.getTable()[5][5] = null;
        assertTrue(table.isFree(5, 5));
    }

    @Test
    public void testIsFreeReturnFalseWhenNotFree() {
        table.getTable()[5][5] = new Part(5, 5, Color.BLACK);
        assertFalse(table.isFree(5, 5));
    }

    @Test
    public void testGetHeight() {
        assertEquals(this.y, table.getHeight());
    }

    @Test
    public void testGetwidth() {
        assertEquals(this.x, table.getWidth());
    }
}
