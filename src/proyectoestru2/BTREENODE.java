/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestru2;

import java.io.Serializable;
import static java.lang.Math.floor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SURFACEB2I7
 */
//public class BTreeNode extends BTree{
//    int[] keys;
//    String[] keysS;
//    BTreeNode[] C;
//    int n;
//    boolean leaf;
//    
//    
//    
//    public BTreeNode(boolean leaf) {
//        this.keys = new int[t];
//        this.C = new BTreeNode[t];
//        this.n = 0;
//        this.leaf = leaf;
//    }
//    
//    
//
//
//    public BTreeNode() {
//        this.t = 6;
//        this.keys = new int[t];
//        this.C = new BTreeNode[t];
//        this.n = 0;
//    }
//
//    
//    
//    public int[] getKeys() {
//        return keys;
//    }
//
//    public void setKeys(int[] keys) {
//        this.keys = keys;
//    }
//
//    public int getT() {
//        return t;
//    }
//
//    public void setT(int t) {
//        this.t = t;
//    }
//
//    public BTreeNode[] getC() {
//        return C;
//    }
//
//    public void setC(BTreeNode[] C) {
//        this.C = C;
//    }
//
//    public int getN() {
//        return n;
//    }
//
//    public void setN(int n) {
//        this.n = n;
//    }
//
//    public boolean isLeaf() {
//        return leaf;
//    }
//
//    public void setLeaf(boolean leaf) {
//        this.leaf = leaf;
//    }
    
    public class BTreeNode implements Serializable{
        private static final long serialVersionUID = 412L;
    int t;
    boolean leaf;
    List<Integer> keys;
    List<BTreeNode> children;
    int offset;

    public BTreeNode(int t,boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new ArrayList<>();
        this.children = new ArrayList<>();
    }
    
    
    
}
