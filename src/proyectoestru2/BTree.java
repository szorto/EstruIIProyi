/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestru2;

import java.io.Serializable;
import static java.lang.Math.floor;

/**
 *
 * @author SURFACEB2I7
 */
public class BTree implements Serializable {

    private static final long serialVersionUID = 1L;
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
        while ((i <= x.getN()) && k > x.getKeys()[i]) {
            i++;
        }
        if (i <= x.getN() && k == x.getKeys()[i]) {
            return x;
        }
        if (x.isLeaf()) {
            return null;
        } else {
            return search(x.getC()[i], k);
        }

    }

    void createBTree() {
        BTREENODE x = new BTREENODE();
        x.setLeaf(true);
        x.setN(0);
        this.root = x;
    }

    void split(BTREENODE padre, int k, BTREENODE iz) {
        int min = (int) floor((t - 1) / 2);
        BTREENODE de = new BTREENODE();
        de.setLeaf(true);
        int indice = 0;
        for (int i = 0; i < padre.getC().length; i++) {
            if (!(padre.getC()[i] == null)) {
                if (padre.getC()[i].equals(iz)) {
                    indice = i;
                }
            }
        }

        if (t % 2 == 0) {
            de.setN(min + 1);
            int centro = iz.getKeys()[min];
            for (int j = 0; j <= min; j++) {
                de.getKeys()[j] = iz.getKeys()[j + min + 1];
                iz.getKeys()[j + min] = 0;
            }
            if (!iz.isLeaf()) {
                for (int i = 0; i < min + 1; i++) {
                    de.getC()[i] = iz.getC()[i + min + 1];
                    iz.getC()[i + min + 1] = null;
                }
            }
            //iz.getKeys()[5] = 0;
            iz.setN(min);
            for (int i = padre.getN() - 1; i > indice; i--) {
                padre.getC()[i + 1] = padre.getC()[i];
            }
            padre.getC()[indice + 1] = de;
            for (int i = padre.getN() - 1; i > indice - 1; i--) {
                padre.getKeys()[i + 1] = padre.getKeys()[i];
            }
            padre.getKeys()[indice] = centro;
            padre.setN(padre.getN() + 1);
        } else {

        }

    }

    void insertNF(BTREENODE x, int k) {
        int i = x.getN() - 1;
        if (x.isLeaf() && x.getN() <= t - 1) {
            while (i >= 0 && k < x.getKeys()[i]) {
                x.getKeys()[i + 1] = x.getKeys()[i];
                i--;
            }
            x.setN(x.getN() + 1);
            x.getKeys()[i + 1] = k;
        } else {
            while (i >= 0 && k < x.getKeys()[i]) {
                i--;
            }
            i++;
            if (x.getC()[i].getN() == this.t) {
                split(x, k, x.getC()[i]);
                if (k > x.getKeys()[i]) {
                    i++;
                }
            }
            insertNF(x.getC()[i], k);
        }
    }

    void insert(BTREENODE r, int k) {
        r = this.root;
        if (r.getN() == this.t - 1) {
            int i = r.getN() - 1;
            while (i >= 0 && k < r.getKeys()[i]) {
                r.getKeys()[i + 1] = r.getKeys()[i];
                i--;
            }
            r.setN(r.getN() + 1);
            r.getKeys()[i + 1] = k;
            BTREENODE s = new BTREENODE();
            this.root = s;
            s.setLeaf(false);
            s.setN(0);
            s.getC()[0] = r;
            split(s, k, r);
            //insertNF(s, k);     El split directamente añade el valor, espero que no nos joda despues lol
        } else {
            insertNF(r, k);
        }
    }

    void print(BTREENODE x) {
        if (this.root != null) {
            if (!x.isLeaf()) {
                for (int i = 0; i < x.getC().length; i++) {
                    if (!(x.getC()[i] == null)) {
                        print(x.getC()[i]);
                    }
                }
            }
            System.out.println("");
            for (int i = 0; i < x.getN(); i++) {
                System.out.println(x.getKeys()[i] + " ");
            }
        }

    }

    void print() {
        if (this.root != null) {
            if (!this.root.isLeaf()) {
                for (int i = 0; i < this.root.getC().length; i++) {
                    if (!(this.root.getC()[i] == null)) {
                        print(this.root.getC()[i]);
                    }
                }
            }
            System.out.println("");
            for (int i = 0; i < this.root.getN(); i++) {
                System.out.println(this.root.getKeys()[i] + " ");
            }
        }
    }

}
