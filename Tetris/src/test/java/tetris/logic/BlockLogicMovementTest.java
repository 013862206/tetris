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
public class BlockLogicMovementTest {

    Table table;
    int tableWidth;
    int tableHeight;
    Block block;
    BlockLogic logic; //Just for 100 % pit-report line-coverage! Works fine with static methods!

    @Before
    public void setUp() {
        tableWidth = 10;
        tableHeight = 20;
        table = new Table(tableWidth, tableHeight);
        block = new IBlock(5, 5, Color.BLUE);
        logic = new BlockLogic();
    }

    @Test
    public void testCanPlaceWhenFreePlace() {
        assertTrue(BlockLogic.canPlace(table, block));
    }

    @Test
    public void testCanNotPlaceWhenNotFreePlace() {
        table.addBlock(block);
        block.move(2, 0);
        assertFalse(BlockLogic.canPlace(table, block));
    }

    @Test
    public void testCanMoveDownWhenFreeSpace() {
        assertTrue(BlockLogic.canMoveDown(table, block));
    }

    @Test
    public void testCanNotMoveDownOverTheBorder() {
        block.move(0, 14);
        assertFalse(BlockLogic.canMoveDown(table, block));
    }

    @Test
    public void testCanNotMoveDownWhenNotFreeSpace() {
        table.addBlock(block);
        block.move(0, -1);
        assertFalse(BlockLogic.canMoveDown(table, block));
    }

    @Test
    public void testCanMoveRightWhenFreeSpace() {
        assertTrue(BlockLogic.canMoveRight(table, block));
    }

    @Test
    public void testCanNotMoveRightOverTheBorder() {
        block.move(4, 0);
        assertFalse(BlockLogic.canMoveRight(table, block));
    }

    @Test
    public void testCanNotMoveRightWhenNotFreeSpace() {
        table.addBlock(block);
        block.move(-4, 0);
        assertFalse(BlockLogic.canMoveRight(table, block));
    }

    @Test
    public void testCanMoveLeftWhenFreeSpace() {
        assertTrue(BlockLogic.canMoveLeft(table, block));
    }

    @Test
    public void testCanNotMoveLeftOverTheBorder() {
        block.move(-4, 0);
        assertFalse(BlockLogic.canMoveLeft(table, block));
    }

    @Test
    public void testCanNotMoveLeftWhenNotFreeSpace() {
        table.addBlock(block);
        block.move(1, 0);
        assertFalse(BlockLogic.canMoveLeft(table, block));
    }

}
