/*
 * 
 * 
 */
package paquete.gestion;

import paquete.programas.Programa;

/**
 *
 * @author Jesu
 */
public class GestionPrograma {
    private Programa[] arrayProgramas;
    private int contador;

    public GestionPrograma() {
        arrayProgramas = new Programa[3];
        contador = 0;
    }

    public Programa[] getArrayProgramas() {
        return arrayProgramas;
    }

    public void setArrayProgramas(Programa[] arrayProgramas) {
        this.arrayProgramas = arrayProgramas;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    public void ingresar(Programa X){
        if(contador<arrayProgramas.length){
            arrayProgramas[contador] = X;
            contador++;
        } else {System.out.println("No hay memoria!");}
    }
    
    public void ejecutarPrograma(String X){
        boolean encontrado = false;
        for(int i=0; i<contador; i++){
            if(arrayProgramas[i].getNombre().equalsIgnoreCase(X)){
                arrayProgramas[i].iniciarPrograma(); encontrado = true;
            }
        } 
        if(encontrado == false && !X.equalsIgnoreCase("D")){
            System.out.println("Programa no encontrado en memoria.");
        }
    }
    
}
        
