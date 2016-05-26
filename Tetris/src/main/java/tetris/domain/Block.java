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

    public Block() {
        this.parts = new Part[4];
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

    abstract public void rotateRight();
    
    abstract public void rotateLeft();
}
