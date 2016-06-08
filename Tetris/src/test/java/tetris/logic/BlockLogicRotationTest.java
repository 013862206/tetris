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
public class BlockLogicRotationTest {

    Table table;
    int tableWidth;
    int tableHeight;
    Block block;

    @Before
    public void setUp() {
        tableWidth = 10;
        tableHeight = 20;
        table = new Table(tableWidth, tableHeight);
        block = new IBlock(5, 5, Color.BLUE);
    }

    @Test
    public void testIsInTableTrue() {
        assertTrue(BlockLogic.isInTable(table, block));
    }

    @Test
    public void testIsInTableTrueLeftUpperCorner() {
        block.move(-4, -5);
        assertTrue(BlockLogic.isInTable(table, block));
    }

    @Test
    public void testIsInTableTrueRightBottomCorner() {
        block.move(2, 14);
        assertTrue(BlockLogic.isInTable(table, block));
    }

    @Test
    public void testIsInTableFalseOverBottomEdge() {
        block.move(0, 15);
        assertFalse(BlockLogic.isInTable(table, block));
    }

    @Test
    public void testIsInTableFalseOverLeftEdge() {
        block.move(-5, 0);
        assertFalse(BlockLogic.isInTable(table, block));
    }

    @Test
    public void testIsInTableFalseOverUpperEdge() {
        block.move(0, -6);
        assertFalse(BlockLogic.isInTable(table, block));
    }

    @Test
    public void testIsInTableFalseOverRightEdge() {
        block.move(4, 0);
        assertFalse(BlockLogic.isInTable(table, block));
    }

    @Test
    public void testCanRotateRightWhenFreeSpace() {
        assertTrue(BlockLogic.canRotateRight(table, block));
    }

    @Test
    public void testCanNotRotateRightOverRightBorder() {
        block.rotateRight();
        block.move(4, 0);
        assertFalse(BlockLogic.canRotateRight(table, block));
    }

    @Test
    public void testCanNotRotateRightOverLeftBorder() {
        block.rotateRight();
        block.move(-4, 0);
        assertFalse(BlockLogic.canRotateRight(table, block));
    }

    @Test
    public void testCanNotRotateRightOverUpperBorder() {
        block.move(0, -5);
        assertFalse(BlockLogic.canRotateRight(table, block));
    }

    @Test
    public void testCanNotRotateRightOverBottomBorder() {
        block.move(0, 14);
        assertFalse(BlockLogic.canRotateRight(table, block));
    }
    
    @Test
    public void testCanNotRotateRightWhenNotSpace() {
        table.addBlock(block);
        block.move(0, -1);
        assertFalse(BlockLogic.canRotateRight(table, block));
    }

    @Test
    public void testCanRotateLeftWhenFreeSpace() {
        assertTrue(BlockLogic.canRotateLeft(table, block));
    }

    @Test
    public void testCanNotRotateLeftOverRightBorder() {
        block.rotateRight();
        block.move(4, 0);
        assertFalse(BlockLogic.canRotateLeft(table, block));
    }

    @Test
    public void testCanNotRotateLeftOverLeftBorder() {
        block.rotateRight();
        block.move(-5, 0);
        assertFalse(BlockLogic.canRotateLeft(table, block));
    }

    @Test
    public void testCanNotRotateLeftOverUpperBorder() {
        block.move(0, -5);
        assertFalse(BlockLogic.canRotateLeft(table, block));
    }

    @Test
    public void testCanNotRotateLeftOverBottomBorder() {
        block.move(0, 14);
        assertFalse(BlockLogic.canRotateLeft(table, block));
    }
    
    @Test
    public void testCannotRotateLeftWhenNotSpace() {
        table.addBlock(block);
        block.move(0, 1);
        assertFalse(BlockLogic.canRotateLeft(table, block));
    }
}
