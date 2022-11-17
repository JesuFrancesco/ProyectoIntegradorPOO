/*
 * 
 * 
 */
package paquete.programas;

import java.util.Random;

/**
 *
 * @author Jesu
 */
public abstract class Programa extends paquete.clasesSuperiores.Display {
    protected String nombre;

    public Programa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean verificarNumero(String X){
        try {
            int prueba = Integer.parseInt(X);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean verificarFloat(String X){
        try {
            float prueba = Float.parseFloat(X);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public abstract void iniciarPrograma();
}
