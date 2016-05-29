/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logic;

import tetris.entity.*;

/**
 *
 * @author luhtalam
 */
public class BlockLogic {

    public boolean canCreate(Table table, Block block) {
        for (Part part : block.getParts()) {
            if (!table.isFree(part.getXCoordinate(), part.getYCoordinate())) {
                return false;
            }
        }
        return true;
    }

    public boolean canMoveDown(Table table, Block block) {
        for (Part part : block.getParts()) {
            if (part.getYCoordinate() == table.getHeight()) {
                return false;
            }
            if (!table.isFree(part.getXCoordinate(), part.getYCoordinate() + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean canMoveLeft(Table table, Block block) {
        for (Part part : block.getParts()) {
            if (part.getXCoordinate() == 0) {
                return false;
            }
            if (!table.isFree(part.getXCoordinate() - 1, part.getYCoordinate())) {
                return false;
            }
        }
        return true;
    }

    public boolean canMoveRight(Table table, Block block) {
        for (Part part : block.getParts()) {
            if (part.getXCoordinate() == table.getWidth()) {
                return false;
            }
            if (!table.isFree(part.getXCoordinate() + 1, part.getYCoordinate())) {
                return false;
            }
        }
        return true;
    }

    public boolean isInTable(Table table, Block block) {
        int x, y;
        for (Part part : block.getParts()) {
            x = part.getXCoordinate();
            y = part.getYCoordinate();
            if (x < 0 || x > table.getWidth() || y < 0 || y > table.getHeight()) {
                return false;
            }
        }
        return true;
    }

}
