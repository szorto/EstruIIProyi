/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestru2;

/**
 *
 * @author samue
 */
public class NodoAvaill {
    int pos, offset, espacio;
    

    public NodoAvaill() {
    }

    public NodoAvaill(int pos, int offset, int espacio) {
        this.pos = pos;
        this.offset = offset;
        this.espacio = espacio;
    }
    
    

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }
    
    
}
