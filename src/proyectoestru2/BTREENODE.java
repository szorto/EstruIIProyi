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
public class BTREENODE {
    int[] keys;
    int t;
    BTREENODE[] C;
    int n;
    boolean leaf;

    public BTREENODE(int t, boolean leaf) {
        this.keys = new int[t - 1];
        this.t = t;
        this.C = new BTREENODE[t];
        this.n = 0;
        this.leaf = leaf;
    }
    
    
//    void insertNonFull(int k) {
//        int i = n - 1;
//        if (leaf) {
//            while (i >= 0 && keys[i] > k) {
//                keys[i + 1] = keys[i];
//                i--;
//            }
//            keys[i + 1] = k;
//            n++;
//        } else {
//            while (i >= 0 && keys[i] > k) {
//                i--;
//            }
//            if (C[i + 1].n == 2 * t - 1) {
//             //   splitChild(i + 1, C[i + 1]);
//                if (keys[i + 1] < k) {
//                    i++;
//                }
//            }
//            C[i + 1].insertNonFull(k);
//        }
//    }
//
//    void splitChild(int i, BTREENODE x, BTREENODE y) {
////        BTREENODE z = new BTREENODE(y.t, y.leaf);
////        z.n = (t - 1)/2;
////        for (int j = 0; j < (t - 1)/2; j++) {
////            z.keys[j] = y.keys[j + t];
////        }
////        if (!y.leaf) {
////            for (int j = 0; j < t; j++) {
////                z.C[j] = y.C[j + t];
////            }
////        }
////        y.n = t - 1;
////        for (int j = n; j > i; j--) {
////            C[j + 1] = C[j];
////        }
////        C[i + 1] = z;
////        for (int j = n - 1; j >= i; j--) {
////            keys[j + 1] = keys[j];
////        }
////        keys[i] = y.keys[t - 1];
////        n++;
//        int min = (int) floor((t - 1)/2);
//        BTREENODE z = new BTREENODE(y.t,y.leaf);
//        z.n = (int) floor(min);
//        for (int j = 0; j < min; j++) {
//            z.keys[j] = y.keys[j + min];
//        }
//        if(!y.leaf){
//            for (int j = 0; j < min; j++) {
//                z.C[j] = y.C[j + min];
//            }
//        }
//    }
//    BTREENODE search(int k) {
//        int i = 0;
//        while (i < n && k > keys[i]) {
//            i++;
//        }
//        if (i < n && k == keys[i]) {
//            return this;
//        }
//        if (leaf) {
//            return null;
//        }
//        return C[i].search(k);
//    }

    public BTREENODE() {
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
