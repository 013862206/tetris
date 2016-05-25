/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.domain;
import java.util.*;
/**
 *
 * @author luhtalam
 */
public abstract class Piece {
    private ArrayList<Part> parts;
    
    public Piece() {
        this.parts = new ArrayList();
    }
    
    public void move(int dx, int dy) {
        for (Part part : this.parts) {
            part.move(dx, dy);
        }
    }
    
    public void rotate() {
        
    }
}

