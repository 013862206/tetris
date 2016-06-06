/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.game;

import java.awt.Graphics;
import tetris.logic.Game;
import tetris.ui.GameTable;
import tetris.ui.Gui;

/**
 *
 * @author luhtalam
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game(1,10,20);
        Gui gui = new Gui(game, 30);
        gui.run();
    }
}
