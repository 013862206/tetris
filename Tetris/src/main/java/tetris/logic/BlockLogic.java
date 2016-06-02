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

    public static boolean canPlace(Table table, Block block) {
        int x, y;
        for (Part part : block.getParts()) {
            x = part.getXCoordinate();
            y = part.getYCoordinate();
            if (!table.isFree(x, y)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canMoveDown(Table table, Block block) {
        int x, y;
        for (Part part : block.getParts()) {
            x = part.getXCoordinate();
            y = part.getYCoordinate();
            if (y == table.getHeight() - 1) {
                return false;
            }
            if (!table.isFree(x, y + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canMoveLeft(Table table, Block block) {
        int x, y;
        for (Part part : block.getParts()) {
            x = part.getXCoordinate();
            y = part.getYCoordinate();
            if (x == 0) {
                return false;
            }
            if (!table.isFree(x - 1, y)) {
                return false;
            }
        }
        return true;
    }

    public static boolean canMoveRight(Table table, Block block) {
        int x, y;
        for (Part part : block.getParts()) {
            x = part.getXCoordinate();
            y = part.getYCoordinate();
            if (x == table.getWidth() - 1) {
                return false;
            }
            if (!table.isFree(x + 1, y)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInTable(Table table, Block block) {
        int x, y;
        for (Part part : block.getParts()) {
            x = part.getXCoordinate();
            y = part.getYCoordinate();
            if (x < 0 || x > table.getWidth() - 1 || y < 0 || y > table.getHeight() - 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean canRotateRight(Table table, Block block) {
        boolean isPossible = false;
        block.rotateRight();
        if (BlockLogic.isInTable(table, block)) {
            if (BlockLogic.canPlace(table, block)) {
                isPossible = true;
            }
        }
        block.rotateLeft();
        return isPossible;
    }

    public static boolean canRotateLeft(Table table, Block block) {
        boolean isPossible = false;
        block.rotateLeft();
        if (BlockLogic.isInTable(table, block)) {
            if (BlockLogic.canPlace(table, block)) {
                isPossible = true;
            }
        }
        block.rotateRight();
        return isPossible;
    }
}
