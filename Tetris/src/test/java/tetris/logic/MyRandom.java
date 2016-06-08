/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.logic;

import java.util.Random;

/**
 *
 * @author luhtalam
 */
public class MyRandom extends Random {
    private int[] values;
    private int i;
    
    public MyRandom(int[] values) {
        this.values = values;
        i = 0;
    }
    
    @Override
    public int nextInt(int number) {
        int value = values[i];
        i++;
        if (i >= values.length) {
            i = 0;
        }
        return value;
    }
    
    public void setIndex(int newIndex) {
        i = newIndex;
    }
    
}
