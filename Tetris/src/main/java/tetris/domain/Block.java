/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;

import java.util.*;

/**
 *
 * @author luhtalam
 */
public abstract class Block implements Moveable {

    protected Part[] parts;
    protected int x;
    protected int y;

    public Block(int x, int y) {
        this.parts = new Part[4];
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        for (Part part : this.parts) {
            part.move(dx, dy);
        }
    }

    @Override
    public void moveDown() {
        for (Part part : this.parts) {
            part.moveDown();
        }
    }

    @Override
    public void moveLeft() {
        for (Part part : this.parts) {
            part.moveLeft();
        }
    }

    @Override
    public void moveRight() {
        for (Part part : this.parts) {
            part.moveRight();
        }
    }

    public void rotateRight() {
        move(-x, -y);
        int newX, newY;
        for (Part part : parts) {
            newX = part.getYCoordinate();
            newY = -part.getXCoordinate();
            part.newCoordinates(newX, newY);
        }
        move(x, y);
    }

    public void rotateLeft() {
        move(-x, -y);
        int newX, newY;
        for (Part part : parts) {
            newX = -part.getYCoordinate();
            newY = part.getXCoordinate();
            part.newCoordinates(newX, newY);
        }
        move(x, y);
    }

    public Part[] getParts() {
        return parts;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
