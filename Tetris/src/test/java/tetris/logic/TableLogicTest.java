/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logic;

import java.awt.Color;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetris.entity.*;
import tetris.logic.*;

/**
 *
 * @author luhtalam
 */
public class TableLogicTest {

    Table table;
    int tableWidth;
    int tableHeight;
    TableLogic logic; //Just for 100 % pit-report line-coverage! Works fine with static methods!

    @Before
    public void setUp() {
        tableWidth = 10;
        tableHeight = 20;
        logic = new TableLogic();
        table = new Table(tableWidth, tableHeight);
    }

    public Table copyTable(Table table) { // for removeRowsTests: .clone don't work right for these ones...
        Table copy = new Table(table.getWidth(), table.getHeight());
        for (int y = 0; y < table.getHeight(); y++) {
            for (int x = 0; x < table.getWidth(); x++) {
                copy.getTable()[y][x] = table.getTable()[y][x];
            }
        }
        return copy;
    }

    @Test
    public void testGetFullRowsDoNotFindWrongRows() {
        int y = 0;
        for (int x = 0; x < tableWidth; x++) {
            if (x % 2 == 0) {
                table.getTable()[y][x] = new Part(x, y, Color.BLACK);
            }
        }
        ArrayList<Integer> fullRows = TableLogic.getFullRows(table);
        assertEquals(0, fullRows.size());
    }

    @Test
    public void testGetFullRowsFindsOneRow() {
        int y = 0;
        for (int x = 0; x < tableWidth; x++) {
            table.getTable()[y][x] = new Part(x, y, Color.BLACK);
        }
        ArrayList<Integer> fullRows = TableLogic.getFullRows(table);
        int row = fullRows.get(0);
        assertEquals(1, fullRows.size());
        assertEquals(y, row);
    }

    @Test
    public void testGetFullRowsFindsTwoRows() {
        int y1 = 0;
        int y2 = 5;
        for (int x = 0; x < tableWidth; x++) {
            table.getTable()[y1][x] = new Part(x, y1, Color.BLACK);
            table.getTable()[y2][x] = new Part(x, y2, Color.BLACK);
        }
        ArrayList<Integer> fullRows = TableLogic.getFullRows(table);
        int row1 = fullRows.get(0);
        int row2 = fullRows.get(1);
        assertEquals(2, fullRows.size());
        assertEquals(y1, row1);
        assertEquals(y2, row2);
    }

    @Test
    public void testRemoveRowsWorksRightOneFullRow() {
        int y = tableHeight - 1;
        for (int x = 0; x < tableWidth; x++) {
            table.getTable()[y][x] = new Part(x, y, Color.BLACK);
            if (x % 2 == 0) {
                table.getTable()[y - 1][x] = new Part(x, y - 1, Color.BLACK);
            }
        }
        Table tableClone = copyTable(table);
        TableLogic.removeRows(table, TableLogic.getFullRows(table));
        for (int x = 0; x < tableWidth; x++) {
            assertNull(table.getTable()[y - 1][x]);
            if (x % 2 == 0) {
                assertEquals(tableClone.getTable()[y - 1][x], table.getTable()[y][x]);
            }
        }
    }

    @Test
    public void testRemoveRowsWorksRightOneFullRowTop() {
        int y = 0;
        for (int x = 0; x < tableWidth; x++) {
            table.getTable()[y][x] = new Part(x, y, Color.BLACK);
            if (x % 2 == 0) {
                table.getTable()[y + 1][x] = new Part(x, y + 1, Color.BLACK);
            }
        }
        Table tableClone = copyTable(table);
        TableLogic.removeRows(table, TableLogic.getFullRows(table));
        for (int x = 0; x < tableWidth; x++) {
            assertNull(table.getTable()[y][x]);
            if (x % 2 == 0) {
                assertEquals(tableClone.getTable()[y + 1][x], table.getTable()[y + 1][x]);
            }
        }
    }

    @Test
    public void testRemoveRowsWorksRightTwoFullRows() {
        int y1 = 5;
        int y2 = tableHeight - 1;
        for (int x = 0; x < tableWidth; x++) {
            table.getTable()[y2][x] = new Part(x, y2, Color.BLACK);
            table.getTable()[y1][x] = new Part(x, y1, Color.BLACK);
            if (x % 2 == 0) {
                table.getTable()[y2 - 1][x] = new Part(x, y2 - 1, Color.BLACK);
            } else {
                table.getTable()[y1 - 1][x] = new Part(x, y1 - 1, Color.BLACK);
            }
        }
        Table tableClone = copyTable(table);
        TableLogic.removeRows(table, TableLogic.getFullRows(table));
        for (int x = 0; x < tableWidth; x++) {
            assertNull(table.getTable()[y1 - 1][x]);
            assertNull(table.getTable()[y2 - 1][x]);
            if (x % 2 == 0) {
                assertEquals(tableClone.getTable()[y2 - 1][x], table.getTable()[y2][x]);
            } else {
                assertEquals(tableClone.getTable()[y1 - 1][x], table.getTable()[y1 + 1][x]);
            }
        }
    }
}
