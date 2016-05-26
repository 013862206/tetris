/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;

/**
 *
 * @author luhtalam
 */
public class Part implements Moveable {

    private int xCoord;
    private int yCoord;

    public Part(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    public void move(int dx, int dy) {
        xCoord += dx;
        yCoord += dy;
    }

    @Override
    public void moveDown() {
        yCoord += 1;
    }

    @Override
    public void moveRight() {
        xCoord += 1;
    }

    @Override
    public void moveLeft() {
        xCoord -= 1;
    }

    public void newCoordinates(int x, int y) {
        xCoord = x;
        yCoord = y;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }
}
