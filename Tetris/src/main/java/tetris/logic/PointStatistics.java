package tetris.logic;

/**
 * Pelin pisteytyksestä huolehtiva luokka.
 */
public class PointStatistics {

    private int points; //pisteet
    private int lines; //tuhotut rivit
    private int gameLevel; //pelin vaikeustaso
    private int blocks; //konstruoidut pelipalikat

    /**
     * Luo uuden pistestatistiikka olion, joka huolehtii pelin pisteiden
     * laskemisesta.
     *
     * @param gameLevel Pelin vaikeustaso
     */
    public PointStatistics(int gameLevel) {
        this.points = 0;
        this.lines = 0;
        this.blocks = 1;
        this.gameLevel = gameLevel;
    }

    /**
     * Kasvattaa konstruoitujen pelipalikoiden laskuria yhdellä.
     */
    public void newBlock() {
        this.blocks++;
    }

    /**
     * Kasvattaa pisteitä sen tuhottujen rivien ja vaikeusasteen perusteella.
     *
     * @param rows Tuhotut rivit
     */
    public void addPoints(int rows) {
        if (rows == 0) {
            return;
        } else if (rows == 1) {
            points += 40 * this.gameLevel;
            lines++;
            return;
        } else if (rows == 2) {
            points += 100 * this.gameLevel;
            lines += 2;
            return;
        } else if (rows == 3) {
            points += 300 * this.gameLevel;
            lines += 3;
            return;
        } else {
            points += 1200 * this.gameLevel;
            lines += 4;
        }
    }

    /**
     * @return Pelissä kerättyjen pisteiden määrä
     */
    public int getPoints() {
        return points;
    }

    /**
     * @return Tuhottujen rivien lukumäärä
     */
    public int getLines() {
        return lines;
    }

    /**
     * @return Pelin vaikeusaste
     */
    public int getGameLevel() {
        return gameLevel;
    }

    /**
     * @return Konstruoitujen pelipalikoiden lukumäärä
     */
    public int getBlocks() {
        return blocks;
    }

}
