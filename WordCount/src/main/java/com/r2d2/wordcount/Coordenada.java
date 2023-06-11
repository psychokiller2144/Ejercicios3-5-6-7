/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r2d2.wordcount;

/**
 *
 * @author PCERF2
 */
public class Coordenada {
    
    private int ren;
    private int col;
    
    
    public Coordenada(){
        this.ren = -1;
        this.col = -1;
    }
    
    public Coordenada(int ren, int col){
        this.ren = ren;
        this.col = col;
    }

    public int getRen() {
        return ren;
    }

    public void setRen(int ren) {
        this.ren = ren;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    @Override
    public String toString(){
        return String.format("[%d,%d]", ren,col);
    }
}
