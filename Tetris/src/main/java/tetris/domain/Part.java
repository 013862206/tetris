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
public class Part {
    private int xCoord;
    private int yCoord;
    private int width;
    
    public Part(int x, int y, int width) {
        xCoord = x;
        yCoord = y;
        this.width = width;
    }
    
    public void move(int dx, int dy) {
        xCoord += dx;
        yCoord += dy;
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
