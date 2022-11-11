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
    protected int codigo;

    public Programa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void generarCodigo(){
        Random rnd = new Random();
        this.codigo = rnd.nextInt(100-0+1)+0;
    }
    
    public abstract void iniciarPrograma();
}
