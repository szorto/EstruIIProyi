/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestru2;

import java.io.Serializable;
import static java.lang.Math.floor;
import java.util.Collections;

/**
 *
 * @author SURFACEB2I7
 */
public class BTree implements Serializable {

    private static final long serialVersionUID = 42L;
    BTreeNode root;
    int t;  // Minimum degree

    public BTree(int t) {
        this.root = new BTreeNode(t, true);
        this.t = t;
    }

    public void insert(int k) {
        BTreeNode r = root;
        if (r.keys.size() == (2 * t) - 1) {
            BTreeNode s = new BTreeNode(t, false);
            s.children.add(r);
            splitChild(s, 0);
            root = s;
            insertNonFull(s, k);
        } else {
            insertNonFull(r, k);
        }
    }

    private void insertNonFull(BTreeNode x, int k) {
        int i = x.keys.size() - 1;
        if (x.leaf) {
            x.keys.add(k);
            Collections.sort(x.keys);
        } else {
            while (i >= 0 && k < x.keys.get(i)) {
                i--;
            }
            i++;
            if (x.children.get(i).keys.size() == 2 * t - 1) {
                splitChild(x, i);
                if (k > x.keys.get(i)) {
                    i++;
                }
            }
            insertNonFull(x.children.get(i), k);
        }
    }

    private void splitChild(BTreeNode x, int i) {
        int t = this.t;
        BTreeNode y = x.children.get(i);
        BTreeNode z = new BTreeNode(t, y.leaf);
        x.children.add(i + 1, z);
        x.keys.add(i, y.keys.get(t - 1));
        z.keys.addAll(y.keys.subList(t, 2 * t - 1));
        y.keys.subList(t - 1, y.keys.size()).clear();
        if (!y.leaf) {
            z.children.addAll(y.children.subList(t, y.children.size()));
            y.children.subList(t, y.children.size()).clear();
        }
    }

    public void delete(int k) {
        delete(root, k);
        if (root.keys.size() == 0) {
            if (root.leaf) {
                root = null;
            } else {
                root = root.children.get(0);
            }
        }
    }

    private void delete(BTreeNode node, int k) {
        int idx = findKey(node, k);

        if (idx < node.keys.size() && node.keys.get(idx) == k) {
            if (node.leaf) {
                node.keys.remove(idx);
            } else {
                deleteFromNonLeaf(node, idx);
            }
        } else {
            if (node.leaf) {
                return;  // Key not found
            }
            boolean flag = (idx == node.keys.size());
            if (node.children.get(idx).keys.size() < t) {
                fill(node, idx);
            }
            if (flag && idx > node.keys.size()) {
                delete(node.children.get(idx - 1), k);
            } else {
                delete(node.children.get(idx), k);
            }
        }
    }

    private int findKey(BTreeNode node, int k) {
        int idx = 0;
        while (idx < node.keys.size() && node.keys.get(idx) < k) {
            idx++;
        }
        return idx;
    }

    private void deleteFromNonLeaf(BTreeNode node, int idx) {
        int k = node.keys.get(idx);
        if (node.children.get(idx).keys.size() >= t) {
            int pred = getPredecessor(node, idx);
            node.keys.set(idx, pred);
            delete(node.children.get(idx), pred);
        } else if (node.children.get(idx + 1).keys.size() >= t) {
            int succ = getSuccessor(node, idx);
            node.keys.set(idx, succ);
            delete(node.children.get(idx + 1), succ);
        } else {
            merge(node, idx);
            delete(node.children.get(idx), k);
        }
    }

    private int getPredecessor(BTreeNode node, int idx) {
        BTreeNode cur = node.children.get(idx);
        while (!cur.leaf) {
            cur = cur.children.get(cur.keys.size());
        }
        return cur.keys.get(cur.keys.size() - 1);
    }

    private int getSuccessor(BTreeNode node, int idx) {
        BTreeNode cur = node.children.get(idx + 1);
        while (!cur.leaf) {
            cur = cur.children.get(0);
        }
        return cur.keys.get(0);
    }

    private void fill(BTreeNode node, int idx) {
        if (idx != 0 && node.children.get(idx - 1).keys.size() >= t) {
            borrowFromPrev(node, idx);
        } else if (idx != node.keys.size() && node.children.get(idx + 1).keys.size() >= t) {
            borrowFromNext(node, idx);
        } else {
            if (idx != node.keys.size()) {
                merge(node, idx);
            } else {
                merge(node, idx - 1);
            }
        }
    }

    private void borrowFromPrev(BTreeNode node, int idx) {
        BTreeNode child = node.children.get(idx);
        BTreeNode sibling = node.children.get(idx - 1);

        child.keys.add(0, node.keys.get(idx - 1));
        if (!child.leaf) {
            child.children.add(0, sibling.children.remove(sibling.children.size() - 1));
        }

        node.keys.set(idx - 1, sibling.keys.remove(sibling.keys.size() - 1));
    }

    private void borrowFromNext(BTreeNode node, int idx) {
        BTreeNode child = node.children.get(idx);
        BTreeNode sibling = node.children.get(idx + 1);

        child.keys.add(node.keys.get(idx));
        node.keys.set(idx, sibling.keys.remove(0));

        if (!child.leaf) {
            child.children.add(sibling.children.remove(0));
        }
    }

    private void merge(BTreeNode node, int idx) {
        BTreeNode child = node.children.get(idx);
        BTreeNode sibling = node.children.get(idx + 1);

        child.keys.add(node.keys.remove(idx));
        child.keys.addAll(sibling.keys);

        if (!child.leaf) {
            child.children.addAll(sibling.children);
        }

        node.children.remove(idx + 1);
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(BTreeNode node, int level) {
        if (node != null) {
            System.out.print("Level " + level + " ");
            System.out.print(node.keys.size() + ": ");
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
            System.out.println();
            level++;
            for (BTreeNode child : node.children) {
                printTree(child, level);
            }
        }
    }
    
    public BTreeNode search(int k) {
        if (root == null) {
            return null;
        } else {
            return search(root, k);
        }
    }

    private BTreeNode search(BTreeNode x, int k) {
        int i = 0;
        while (i < x.keys.size() && k > x.keys.get(i)) {
            i++;
        }
        if (i < x.keys.size() && k == x.keys.get(i)) {
            return x;
        }
        if (x.leaf) {
            return null;
        } else {
            return search(x.children.get(i), k);
        }
    }

    public BTreeNode getRoot() {
        return root;
    }

    public void setRoot(BTreeNode root) {
        this.root = root;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
    
        
}