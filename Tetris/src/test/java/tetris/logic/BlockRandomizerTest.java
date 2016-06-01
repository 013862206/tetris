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
public class BlockRandomizerTest {

    BlockRandomizer random;
    int x, y;

    @Before
    public void setUp() {
        this.x = 4;
        this.y = 1;
        this.random = new BlockRandomizer(x, y);
    }
    
    @Test
    public void testConstructorSetsXCoordinateRight() {
        assertEquals(x, random.getX());
    }
    
    @Test
    public void testConstrutorSetsYCoordinateRight() {
        assertEquals(y, random.getY());
    }
}
