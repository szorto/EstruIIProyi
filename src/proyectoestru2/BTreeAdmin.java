/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestru2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author samue
 */
public class BTreeAdmin {

    private BTree tree;
    File archivo = null;

    public BTreeAdmin(File archiv) {
        archivo = archiv;
    }

    public BTree getTree() {
        return tree;
    }

    public void setTree(BTree tree) {
        this.tree = tree;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void cargarArbol() {
        try {
            if (archivo.exists()) {

                if (archivo.length() != 0) {
                    FileInputStream entrada = new FileInputStream(archivo);
                    ObjectInputStream objeto = new ObjectInputStream(entrada);
                    try {
                        tree = (BTree) objeto.readObject();
                    } catch (EOFException e) {
                        //encontro el final del archivo
                    }
                    objeto.close();
                    entrada.close();

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArbol() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            bw.writeObject(tree);
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
}
