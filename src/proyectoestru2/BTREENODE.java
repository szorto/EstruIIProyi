/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestru2;

import static java.lang.Math.floor;

/**
 *
 * @author SURFACEB2I7
 */
public class BTREENODE extends BTree{
    int[] keys;
    BTREENODE[] C;
    int n;
    boolean leaf;
    
    
    
    public BTREENODE(boolean leaf) {
        this.keys = new int[t];
        this.C = new BTREENODE[t];
        this.n = 0;
        this.leaf = leaf;
    }
    
    


    public BTREENODE() {
        this.t = 6;
        this.keys = new int[t];
        this.C = new BTREENODE[t];
        this.n = 0;
    }

    
    
    public int[] getKeys() {
        return keys;
    }

    public void setKeys(int[] keys) {
        this.keys = keys;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public BTREENODE[] getC() {
        return C;
    }

    public void setC(BTREENODE[] C) {
        this.C = C;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
    
    
    
    
    
}
