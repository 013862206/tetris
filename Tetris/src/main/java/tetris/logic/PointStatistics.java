package tetris.logic;

/**
 *Pelin pisteytyksestä huolehtiva luokka.
 */
public class PointStatistics {

    private int points;
    private int lines;
    private int gameLevel;
    private int blocks;

    PointStatistics(int gameLevel) {
        this.points = 0;
        this.lines = 0;
        this.blocks = 1;
        this.gameLevel = gameLevel;
    }

    public void newBlock() {
        this.blocks++;
    }

    public void addPoints(int rows) {
        if (rows == 0) {
            return; //add few points?
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

    public int getPoints() {
        return points;
    }

    public int getLines() {
        return lines;
    }

    public int getGameLevel() {
        return gameLevel;
    }

    public int getBlocks() {
        return blocks;
    }

}
