package tetris.logic;

import java.util.ArrayList;
import java.util.Random;
import tetris.entity.*;

/**
 * Tetris-peliä kuvastava luokka.
 */
public class Game { //add GhostBlock??

    private Table table; //Pelilautaolio
    private BlockRandomizer randomizer; //Pelipalikoiden arpojaolio
    private PointStatistics points; //Pistestatistiikkaolio
    private Block currentBlock; //Liikuteltava pelipalikka
    private Block nextBlock; //Seuraava pelipalikka
    private int gameLevel; //Pelin vaikeustaso
    private boolean on; //Totuusarvo siitä, onko peli käynnissä

    /**
     * Luo uuden Tetris-peliolion.
     *
     * @param gameLevel Pelin vaikeustaso
     * @param tableWidth Pelilaudan leveys
     * @param tableHeight Pelilaudan korkeus
     *
     * @see tetris.entity.Table
     * @see tetris.logic.BlockRandomizer#drawNewBlock()
     * @see tetris.logic.PointStatistics
     */
    public Game(int gameLevel, int tableWidth, int tableHeight) {
        this.table = new Table(tableWidth, tableHeight);
        int xCoord = tableWidth / 2 - 1;
        this.randomizer = new BlockRandomizer(xCoord, 1, new Random());
        this.currentBlock = randomizer.drawNewBlock();
        this.nextBlock = randomizer.drawNewBlock();
        this.points = new PointStatistics(gameLevel);
        this.gameLevel = gameLevel;
        this.on = true;
    }

    /**
     * Liikuttaa liikuteltavaa pelipalikkaa vasemmalle mikäli mahdollista.
     *
     * @see tetris.logic.BlockLogic#canMoveLeft(tetris.entity.Table,
     * tetris.entity.Block)
     * @see tetris.entity.Block#moveLeft()
     */
    public void moveBlockLeft() {
        if (BlockLogic.canMoveLeft(this.table, currentBlock)) {
            currentBlock.moveLeft();
        }
    }

    /**
     * Liikuttaa liikuteltavaa pelipalikkaa oikealle mikäli mahdollista.
     *
     * @see tetris.logic.BlockLogic#canMoveRight(tetris.entity.Table,
     * tetris.entity.Block)
     * @see tetris.entity.Block#moveRight()
     */
    public void moveBlockRight() {
        if (BlockLogic.canMoveRight(this.table, currentBlock)) {
            currentBlock.moveRight();
        }
    }

    /**
     * Liikuttaa liikuteltavaa pelipalikkaa alaspäin mikäli mahdollista.
     *
     * @see tetris.logic.BlockLogic#canMoveDown(tetris.entity.Table,
     * tetris.entity.Block)
     * @see tetris.entity.Block#moveDown()
     */
    public void moveBlockDown() {
        if (BlockLogic.canMoveDown(this.table, currentBlock)) {
            currentBlock.moveDown();
        } else {
            nextBlock();
        }
    }

    /**
     * Kääntää liikuteltavaa pelipalikkaa myötäpäivään mikäli mahdollista.
     *
     * @see tetris.logic.BlockLogic#canRotateRight(tetris.entity.Table,
     * tetris.entity.Block)
     * @see tetris.entity.Block#rotateRight()
     */
    public void rotateBlockToRight() {
        if (BlockLogic.canRotateRight(this.table, currentBlock)) {
            currentBlock.rotateRight();
        }
    }

    /**
     * Kääntää liikuteltavaa pelipalikkaa vastapäivään mikäli mahdollista.
     *
     * @see tetris.logic.BlockLogic#canRotateLeft(tetris.entity.Table,
     * tetris.entity.Block)
     * @see tetris.entity.Block#rotateLeft()
     */
    public void rotateBlockToLeft() {
        if (BlockLogic.canRotateLeft(this.table, currentBlock)) {
            currentBlock.rotateLeft();
        }
    }

    /**
     * Liikuttaa tällä hetkellä liikuteltan pelipalikan niin alas kuin
     * mahdollista.
     *
     * @see tetris.logic.BlockLogic#canMoveDown(tetris.entity.Table,
     * tetris.entity.Block)
     * @see tetris.entity.Block#moveDown()
     */
    public void moveBlockDownFast() {
        while (BlockLogic.canMoveDown(this.table, currentBlock)) {
            moveBlockDown();
        }
        moveBlockDown();
    }

    /**
     * Kiinnittää nykyisen liikuteltavan pelipalikan pöytään ja jatkaa peliä
     * mikäli mahdollista.
     *
     * @see tetris.entity.Table#addBlock(tetris.entity.Block)
     * @see tetris.logic.BlockLogic#canPlace(tetris.entity.Table,
     * tetris.entity.Block)
     * @see tetris.logic.BlockRandomizer#drawNewBlock()
     * @see tetris.logic.PointStatistics#newBlock()
     */
    public void nextBlock() {
        this.table.addBlock(currentBlock);
        checkTable();
        if (BlockLogic.canPlace(this.table, nextBlock)) {
            currentBlock = nextBlock;
            nextBlock = randomizer.drawNewBlock();
            this.points.newBlock();
        } else {
            on = false;
        }
    }

    /**
     * Tarkistaa pöydän tilanteen: poistaa rivejä ja lisää pisteitä.
     *
     * @see tetris.logic.TableLogic
     * @see tetris.logic.PointStatistics#addPoints(int)
     */
    public void checkTable() {
        ArrayList<Integer> fullRows = TableLogic.getFullRows(table);
        int rows = fullRows.size();
        points.addPoints(rows);
        TableLogic.removeRows(this.table, fullRows);
    }

    /**
     * Asettaa nykyisen pelipalikan halutuksi. Testejä varten luotu metodi.
     *
     * @param block Haluttu pelipalikka
     */
    public void setCurrentBlock(Block block) { //for tests
        this.currentBlock = block;
    }

    /**
     * @return Seuraava pelipalikka
     */
    public Block getNextBlock() {
        return this.nextBlock;
    }

    public int getGameLevel() {
        return this.gameLevel;
    }

    public Table getTable() {
        return table;
    }

    public PointStatistics getPointStatistics() {
        return points;
    }

    public Block getCurrentBlock() {
        return currentBlock;
    }

    public boolean isOn() {
        return on;
    }

    public BlockRandomizer getBlockRandomizer() {
        return randomizer;
    }

}
