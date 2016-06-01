/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logic;

import java.util.ArrayList;
import tetris.entity.*;

/**
 *
 * @author luhtalam
 */
public class Game { //add getCurrentSituation! GhostBlock??

    private Table table;
    private BlockRandomizer rando;
    private PointStatistics points;
    private Block currentBlock;
    private Block nextBlock;
    private boolean onOff;

    public Game(int gameLevel, int tableWidth, int tableHeight) {
        this.table = new Table(tableWidth, tableHeight);
        int xCoord = tableWidth / 2;
        this.rando = new BlockRandomizer(xCoord, 1);
        this.currentBlock = rando.drawNewBlock();
        this.nextBlock = rando.drawNewBlock();
        this.points = new PointStatistics(gameLevel);
        this.onOff = true;
    }

    public void moveBlockLeft() {
        if (BlockLogic.canMoveLeft(this.table, currentBlock)) {
            currentBlock.moveLeft();
        }
    }

    public void moveBlockRight() {
        if (BlockLogic.canMoveRight(this.table, currentBlock)) {
            currentBlock.moveRight();
        }
    }

    public void moveBlockDown() {
        if (BlockLogic.canMoveDown(this.table, currentBlock)) {
            currentBlock.moveDown();
        } else {
            nextBlock();
        }
    }

    public void rotateBlockToRight() {
        if (BlockLogic.canRotateRight(this.table, currentBlock)) {
            currentBlock.rotateRight();
        }
    }

    public void rotateBlockToLeft() {
        if (BlockLogic.canRotateLeft(this.table, currentBlock)) {
            currentBlock.rotateLeft();
        }
    }

    public void moveBlockDownFast() {
        while (BlockLogic.canMoveDown(this.table, currentBlock)) {
            currentBlock.moveDown();
        }
    }

    public void nextBlock() {
        this.table.addBlock(currentBlock);
        checkTable();
        if (BlockLogic.canPlace(this.table, nextBlock)) {
            currentBlock = nextBlock;
            nextBlock = rando.drawNewBlock();
            this.points.newBlock();
        } else {
            onOff = false;
        }
    }

    public void checkTable() {
        ArrayList<Integer> fullRows = TableLogic.getFullRows(table);
        int rows = fullRows.size();
        points.addPoints(rows);
        TableLogic.removeRows(this.table, fullRows);
    }

    public Block getNextBlock() {
        return this.nextBlock;
    }
}
