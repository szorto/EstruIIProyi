/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestru2;

import java.util.ArrayList;

/**
 *
 * @author samue
 */
public class MetaData {

    ArrayList<Campos> lista = new ArrayList();
    int longitud, cantidad, cabezaA;

    public MetaData() {
    }

    public ArrayList<Campos> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Campos> lista) {
        this.lista = lista;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCabezaA() {
        return cabezaA;
    }

    public void setCabezaA(int cabezaA) {
        this.cabezaA = cabezaA;
    }

    @Override
    public String toString() {
        String pipi = "";
        for (int i = 0; i < lista.size(); i++) {
                if (i == lista.size() - 1) {
                    pipi += lista.get(i).getNombre() + "|" + lista.get(i).getTipo() + "|" + lista.get(i).getLongitud() + "|" + lista.get(i).isLlaveP();
                } else {
                    pipi += lista.get(i).getNombre() + "|" + lista.get(i).getTipo() + "|" + lista.get(i).getLongitud() + "|" + lista.get(i).isLlaveP() + ",";
                }
            }
            int longi = 0;
            for (Campos cc : lista) {
                longi += cc.getLongitud();
                System.out.println(cc.getLongitud());
            }
            longi += lista.size() - 1;
            this.longitud = longi;
            this.cabezaA = -1;
            this.cantidad = 0;
            pipi += "\n" + this.longitud + "\n" + this.cantidad + "\n" + this.cabezaA;
        return pipi;
    }
    
    public String toString2(){
        return longitud + " qa " + cantidad + " sd " + cabezaA;
    }

}
