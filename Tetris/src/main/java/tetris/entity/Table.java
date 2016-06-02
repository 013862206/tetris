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

    private Part[][] table;

    public Table(int width, int height) {
        this.table = new Part[height][width];
    }

    public void addBlock(Block block) {
        for (Part part : block.getParts()) {
            table[part.getYCoordinate()][part.getXCoordinate()] = part;
        }
    }

    public boolean isFree(int x, int y) {
        if (table[y][x] == null) {
            return true;
        } else {
            return false;
        }
    }

    public Part[][] getTable() {
        return this.table;
    }

    public int getHeight() {
        return table.length;
    }

    public int getWidth() {
        return table[0].length;
    }

}
