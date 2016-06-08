/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logic;

import java.awt.Color;
import java.util.Random;
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
public class BlockRandomizerTest {

    BlockRandomizer randomizer;
    int x, y;
    Random random;

    @Before
    public void setUp() {
        this.x = 4;
        this.y = 1;
        random = new MyRandom(new int[]{0,1,2,3,4,5,6});
        this.randomizer = new BlockRandomizer(x, y, random);
    }
    
    @Test
    public void testConstructorSetsXCoordinateRight() {
        assertEquals(x, randomizer.getX());
    }
    
    @Test
    public void testConstrutorSetsYCoordinateRight() {
        assertEquals(y, randomizer.getY());
    }
    
    @Test
    public void testConstructorSetsRandomRight() {
        assertEquals(this.random, randomizer.getRandom());
    }
    
    @Test
    public void testDrawNextBlockWorks() {
        Block block = randomizer.drawNewBlock();
        assertEquals(IBlock.class, block.getClass());
        assertEquals(x, block.getX());
        assertEquals(y, block.getY());
        assertEquals(Color.cyan, block.getParts()[0].getColor());
        
        block = randomizer.drawNewBlock();
        assertEquals(JBlock.class, block.getClass());
        assertEquals(x, block.getX());
        assertEquals(y, block.getY());
        assertEquals(Color.blue, block.getParts()[0].getColor());
        
        block = randomizer.drawNewBlock();
        assertEquals(LBlock.class, block.getClass());
        assertEquals(x, block.getX());
        assertEquals(y, block.getY());
        assertEquals(Color.orange, block.getParts()[0].getColor());
        
        block = randomizer.drawNewBlock();
        assertEquals(OBlock.class, block.getClass());
        assertEquals(x, block.getX());
        assertEquals(y, block.getY());
        assertEquals(Color.yellow, block.getParts()[0].getColor());
        
        block = randomizer.drawNewBlock();
        assertEquals(SBlock.class, block.getClass());
        assertEquals(x, block.getX());
        assertEquals(y, block.getY());
        assertEquals(Color.green, block.getParts()[0].getColor());
        
        block = randomizer.drawNewBlock();
        assertEquals(TBlock.class, block.getClass());
        assertEquals(x, block.getX());
        assertEquals(y, block.getY());
        assertEquals(Color.magenta, block.getParts()[0].getColor());
        
        block = randomizer.drawNewBlock();
        assertEquals(ZBlock.class, block.getClass());
        assertEquals(x, block.getX());
        assertEquals(y, block.getY());
        assertEquals(Color.red, block.getParts()[0].getColor());
    }
}
