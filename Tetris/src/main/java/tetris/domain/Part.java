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
    private int width;
    
    public Part(int x, int y) {
        xCoord = x;
        yCoord = y;
        width = 10;
    }

    public void move(int dx, int dy) {
        xCoord += dx;
        yCoord += dy;
    }

    public void moveDown() {
        yCoord += 1;
    }

    public void moveRight() {
        xCoord += 1;
    }

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

    public int getWidth() {
        return width;
    }

}
