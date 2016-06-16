package tetris.logic;

import tetris.entity.*;

/**
 * Palikoiden liikuttelua hallinnoiva luokka.
 */
public class BlockLogic {

    /**
     * Tarkistaa voiko pelipalikkan sijoittaa pelilaudalle.
     *
     * @param table Pelilautataulukko
     * @param block Pelipalikka
     * @return Totuusarvo siitä, voiko kyseisen palikan sijoittaa taulukkoon
     * pelipalikan koordinaatteihin
     *
     * @see tetris.entity.Table#isFree(int, int)
     */
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

    /**
     * Tarkistaa voiko pelipalikkaa siirtää pelilaudalla alaspäin.
     *
     * @param table Pelilautataulukko
     * @param block Pelipalikka
     * @return Totuusarvo siitä, voiko voiko palikkaa siirtää alaspäin
     *
     * @see tetris.entity.Table#isFree(int, int)
     */
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

    /**
     * Tarkistaa voiko pelipalikkaa siirtää pelilaudalla vasemmalle.
     *
     * @param table Pelilautataulukko
     * @param block Pelipalikka
     * @return Totuusarvo siitä, voiko palikkaa siirtää vasemmalle.
     *
     * @see tetris.entity.Table#isFree(int, int)
     */
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

    /**
     * Tarkistaa voiko pelipalikkaa siirtää pelilaudalla oikealle.
     *
     * @param table Pelilautataulukko
     * @param block Pelipalikka
     * @return Totuusarvo siitä, voiko pelipalikkaa siirtää laudalla oikealle
     *
     * @see tetris.entity.Table#isFree(int, int)
     */
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

    /**
     * Tarkistaa onko pelipalikka pelilaudalla.
     *
     * @param table Pelilautataulukko
     * @param block Pelipalikka
     * @return Totuusarvo siitä, onko pelipalikka pelilaudan rajojen
     * sisäpuolella
     */
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

    /**
     * Tarkistaa voiko pelipalikkaa kääntää pelilaudalla myötäpäivään.
     *
     * @param table Pelilautataulukko
     * @param block Pelipalikka
     * @return Totuusarvo, siitä voiko pelipalikkaa kääntää myötäpäivään
     * pelilaudalla
     *
     * @see tetris.entity.Block#rotateRight()
     * @see tetris.entity.Block#rotateLeft()
     */
    public static boolean canRotateRight(Table table, Block block) {
        block.rotateRight();
        boolean isPossible = (isInTable(table, block) && canPlace(table, block));
        block.rotateLeft();
        return isPossible;
    }

    /**
     * Tarkistaa voiko pelipalikkaa kääntää pelilaudalla vastapäivään.
     *
     * @param table Pelilautataulukko
     * @param block Pelipalikka
     * @return Totuusarvo siitä, voiko pelipalikkaa kääntää vastapäivään
     * pelilaudalla
     */
    public static boolean canRotateLeft(Table table, Block block) {
        block.rotateLeft();
        boolean isPossible = (isInTable(table, block) && canPlace(table, block));
        block.rotateRight();
        return isPossible;
    }
}
