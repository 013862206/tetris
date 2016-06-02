/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.entity;

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
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void moveDown() {
        for (Part part : this.parts) {
            part.moveDown();
        }
        this.y++;
    }

    @Override
    public void moveLeft() {
        for (Part part : this.parts) {
            part.moveLeft();
        }
        this.x--;
    }

    @Override
    public void moveRight() {
        for (Part part : this.parts) {
            part.moveRight();
        }
        this.x++;
    }

    public void rotateLeft() {
        int dx = this.x;
        int dy = this.y;
        move(-dx, -dy);
        int newX, newY;
        for (Part part : parts) {
            newX = part.getYCoordinate();
            newY = -part.getXCoordinate();
            part.newCoordinates(newX, newY);
        }
        move(dx, dy);
    }

    public void rotateRight() {
        int dx = this.x;
        int dy = this.y;
        move(-dx, -dy);
        int newX, newY;
        for (Part part : parts) {
            newX = -part.getYCoordinate();
            newY = part.getXCoordinate();
            part.newCoordinates(newX, newY);
        }
        move(dx, dy);
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
