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
public class BTree {

    BTREENODE root;
    int t;

    public BTree(int t) {
        
        this.root = null;
        this.t = t;
    }
    
    public BTree() {

    }

    public BTREENODE getRoot() {
        return root;
    }

    public void setRoot(BTREENODE root) {
        this.root = root;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
    
    
    
    
    
    BTREENODE search(BTREENODE x, int k) {
        int i = 0;
        while((i <= x.getN()) && k > x.getKeys()[i]){
            i++;
        }
        if (i <= x.getN() && k == x.getKeys()[i]) {
            return x;
        }
        if(x.isLeaf()){
            return null;
        }else{
            return search(x.getC()[i], k);
        }

    }
    
    void createBTree(int t){
        BTREENODE x = new BTREENODE();
        x.setLeaf(true);
        x.setN(0);
        this.root = x;
    }
    
    void split(BTREENODE x, int i, BTREENODE y){
        int min = (int) floor((t - 1)/2);
        BTREENODE z = new BTREENODE();
        z.setLeaf(y.isLeaf());
        z.setN(y.getN());
        for (int j = 0; j < min; j++) {
            z.getKeys()[j] = y.getKeys()[j + min];
        }
        if(!y.isLeaf()){
            for (int j = 0; j < t; j++) {
                z.getC()[j] = y.getC()[j + min];
            }
        }
        y.setN(min);
        for (int j = 0; j < i + 1; j++) {
            x.getC()[j + 1] = x.getC()[j];
        }
        x.getC()[i + 1] = z;
        for (int j = x.getN() -1; j >= i; j--) {
            x.getKeys()[j + 1] = x.getKeys()[j];
        }
        x.getKeys()[i] = y.getKeys()[min];
        x.setN(x.getN()+ 1);
    }
    
    void insertNF(BTREENODE x, int k){
        int i = x.getN() - 1;
        if(x.isLeaf()){
            while(i >= 0 && k < x.getKeys()[i]){
                x.getKeys()[i + 1] = x.getKeys()[i];
                i--;
            }
            x.getKeys()[i + 1] = k;
            x.setN(x.getN() + 1);
        }else{
            while(i >= 0 && k < x.getKeys()[i]){
                i++;
                if(x.getC()[i].getN() == t){
                    split(x,i,x.getC()[i]);
                    if(k > x.getKeys()[i]){
                        i++;
                    }
                }
                insertNF(x.getC()[i],k);
            }
        }
    }
    
    public void traverse() {
        if (root != null) {
            traverse(root);
        }
    }

    private void traverse(BTREENODE x) {
        int i;
        for (i = 0; i < x.n; i++) {
            if (!x.leaf) {
                traverse(x.getC()[i]);
            }
            System.out.print(" " + x.keys[i]);
        }
        if (!x.leaf) {
            traverse(x.getC()[i]);
        }
    }
    
    
}
