/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.entity;

import tetris.entity.Part;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.awt.Color;

/**
 *
 * @author luhtalam
 */
public class PartTest {

    private Part part;
    int x, y;
    Color color;

    @Before
    public void setUp() {
        this.x = 3;
        this.y = 2;
        color = Color.WHITE;
        part = new Part(x, y, color);
    }

    @Test
    public void testConstructorXCoordIsRight() {
        assertEquals(x, part.getXCoordinate());
    }

    @Test
    public void testConstructorYCoordIsRight() {
        assertEquals(y, part.getYCoordinate());
    }

    @Test
    public void testConstructorSetsColorRight() {
        assertEquals(color, part.getColor());
    }

    @Test
    public void testMoveDxIsZero() {
        int dx = 0;
        part.move(dx, 0);
        assertEquals(x, part.getXCoordinate());
    }

    @Test
    public void testMoveDxIsPositive() {
        int dx = 5;
        part.move(dx, 0);
        assertEquals(x + dx, part.getXCoordinate());
    }

    @Test
    public void testMoveDxIsNegative() {
        int dx = -3;
        part.move(dx, 0);
        assertEquals(x + dx, part.getXCoordinate());
    }

    @Test
    public void testMoveDyIsZero() {
        int dy = 0;
        part.move(0, dy);
        assertEquals(y, part.getYCoordinate());
    }

    @Test
    public void testMoveDyIsPositive() {
        int dy = 3;
        part.move(0, dy);
        assertEquals(y + dy, part.getYCoordinate());
    }

    @Test
    public void testMoveDyIsNegative() {
        int dy = -3;
        part.move(0, dy);
        assertEquals(y + dy, part.getYCoordinate());
    }

    @Test
    public void testMoveDown() {
        part.moveDown();
        assertEquals(this.y + 1, part.getYCoordinate());
        assertEquals(this.x, part.getXCoordinate());
    }

    @Test
    public void testMoveRight() {
        part.moveRight();
        assertEquals(this.x + 1, part.getXCoordinate());
        assertEquals(this.y, part.getYCoordinate());
    }

    @Test
    public void testMoveLeft() {
        part.moveLeft();
        assertEquals(this.x - 1, part.getXCoordinate());
        assertEquals(this.y, part.getYCoordinate());
    }

    @Test
    public void testNewCoordinatesXIsRight() {
        int newX = 4;
        part.newCoordinates(newX, 0);
        assertEquals(newX, part.getXCoordinate());
    }

    @Test
    public void testNewCoordinatesYIsRight() {
        int newY = 3;
        part.newCoordinates(0, newY);
        assertEquals(newY, part.getYCoordinate());
    }
}
