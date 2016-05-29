/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.entity;

/**
 *
 * @author luhtalam
 */
public class Table {

    private boolean[][] table;

    public Table(int width, int height) {
        this.table = new boolean[height][width];
    }

    public void addBlock(Block block) {
        for (Part part : block.getParts()) {
            table[part.getYCoordinate()][part.getXCoordinate()] = true;
        }
    }
    
    public boolean isFree(int x, int y) {
        return table[y][x];
    }

    public boolean[][] getTable() {
        return this.table;
    }
    
    public int getHeight() {
        return table.length;
    }
    
    public int getWidth() {
        return table[0].length;
    }

}
