package tetris.logic;

import java.util.ArrayList;
import tetris.entity.Table;

/**
 *Luokka käsittelee kenttää: palauttaa täysiä rivejä ja poistaa niitä pelilaudalta.
 */
public class TableLogic {

    public static ArrayList<Integer> getFullRows(Table table) {
        ArrayList<Integer> fullRows = new ArrayList();
        boolean fullRow;
        for (int y = 0; y < table.getHeight(); y++) {
            fullRow = true;
            for (int x = 0; x < table.getWidth(); x++) {
                if (table.isFree(x, y)) {
                    fullRow = false;
                    break;
                }
            }
            if (fullRow) {
                fullRows.add(y);
            }
        }
        return fullRows;
    }

    public static void removeRows(Table table, ArrayList<Integer> rows) { //rivit jo oikeassa järjestyksessä edellisen metodin ansiosta
        for (int row : rows) {
            for (int y = row; y >= 0; y--) {
                for (int x = 0; x < table.getWidth(); x++) {
                    if (y == 0) {
                        table.getTable()[y][x] = null;
                    } else {
                        table.getTable()[y][x] = table.getTable()[y - 1][x];
                    }
                }
            }
        }
    }

}
