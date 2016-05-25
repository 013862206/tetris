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
public abstract class Block implements Moveable {
    private ArrayList<Part> parts;
    
    public Block() {
        this.parts = new ArrayList();
    }
    
    public void addPart(Part part) {
        this.parts.add(part);
    }
    
    public void move(int dx, int dy) {
        for (Part part : this.parts) {
            part.move(dx, dy);
        }
    }
    
    public void moveDown() {
        for (Part part : this.parts) {
            part.moveDown();
        }
    }
    
    public void moveLeft() {
        for (Part part : this.parts) {
            part.moveLeft();
        }
    }
    
    public void moveRight() {
        for (Part part : this.parts) {
            part.moveRight();
        }
    }
    
    public void rotate() {
        
    }
}

