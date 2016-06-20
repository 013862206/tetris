package tetris.logic;

/**
 * Pelin pisteytyksestä huolehtiva luokka.
 */
public class PointStatistics {

    private int points; //pisteet
    private int lines; //tuhotut rivit
    private int gameLevel; //pelin vaikeustaso
    private int blocks; //konstruoidut pelipalikat
    private int linesForLevel;

    /**
     * Luo uuden pistestatistiikka olion, joka huolehtii pelin pisteiden
     * laskemisesta.
     *
     * @param gameLevel Pelin vaikeustaso
     */
    public PointStatistics(int gameLevel) {
        this.points = 0;
        this.lines = 0;
        this.linesForLevel = 0;
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
            linesForLevel++;
        } else if (rows == 2) {
            points += 100 * this.gameLevel;
            lines += 2;
            linesForLevel += 2;
        } else if (rows == 3) {
            points += 300 * this.gameLevel;
            lines += 3;
            linesForLevel += 3;
        } else {
            points += 1200 * this.gameLevel;
            lines += 4;
            linesForLevel += 4;
        }
        if (linesForLevel >= 25) {
            if (gameLevel < 20) {
                gameLevel++;
            }
            linesForLevel = linesForLevel - 25;
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
    
    public int getLinesForLevel() {
        return linesForLevel;
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
