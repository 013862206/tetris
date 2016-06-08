/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.entity;

import java.awt.Color;
import tetris.entity.IBlock;
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
public class IBlockTest {

    IBlock block;
    int x, y;
    Color color;

    @Before
    public void setUp() {
        x = 3;
        y = 4;
        color = Color.BLACK;
        block = new IBlock(x, y, color);
    }

    @Test
    public void testConstructorSetsPositionsRight() {
        for (int i = 0; i < 4; i++) {
            assertEquals(y, block.getParts()[i].getYCoordinate());
            assertEquals(x - 1 + i, block.getParts()[i].getXCoordinate());
        }
    }
    
    @Test
    public void testConstructorSetsColorsRight() {
        for (Part part : block.getParts()) {
            assertEquals(color, part.getColor());
        }
    }
}
