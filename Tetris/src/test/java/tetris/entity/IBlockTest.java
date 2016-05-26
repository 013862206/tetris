/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.entity;

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

    @Before
    public void setUp() {
        block = new IBlock(3,5);
    }


}
