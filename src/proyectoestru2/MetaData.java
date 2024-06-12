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
        this.cabezaA = 0;
        this.cantidad = 0;
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
            if (cc.getLongitud() != -1) {
                longi += cc.getLongitud();
                System.out.println(cc.getLongitud());
            }else{
                longi += 1;
            }
        }
        longi += lista.size() - 1;
        this.longitud = longi;
        
        String cab = "" ;
        if(this.cabezaA == -1){
            cab += "-1";
        }else{
            cab = "" + this.cabezaA;
        }
        String can = "" + this.cantidad;
        String lon = "" + this.longitud;
        for (int i = lon.length(); i < 4; i++) {
            lon += "$";
        }
        for (int i = can.length(); i < 6; i++) {
            can += "$";
        }
        for (int i = cab.length(); i < 6; i++) {
            cab += "$";
        }
        
        pipi += "\n" + lon + "\n" + can + "\n" + cab + "\n";
        return pipi;
    }

    public String toString2() {
        return longitud + " qa " + cantidad + " sd " + cabezaA;
    }

    void sumarCntidad() {
        this.cantidad++;
    }

}
