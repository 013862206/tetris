package tetris.entity;

/**
 *Luokka kuvastaa pelilautaa, jossa palikoita voi liikutella ja johon pelipalikan
 * paloja voi tallentaa.
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
