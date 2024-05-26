/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestru2;

/**
 *
 * @author samue
 */
public class Campos {
    private String nombre, tipo;
    private int longitud;
    private boolean llaveP;

    public Campos() {
    }

    public Campos(String nombre, String tipo, int longitud, boolean llaveP) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.longitud = longitud;
        this.llaveP = llaveP;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public boolean isLlaveP() {
        return llaveP;
    }

    public void setLlaveP(boolean llaveP) {
        this.llaveP = llaveP;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
