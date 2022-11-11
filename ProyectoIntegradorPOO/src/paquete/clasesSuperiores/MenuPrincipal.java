package paquete.clasesSuperiores;

import paquete.interfaces.Mensajes;

public class MenuPrincipal extends Display implements Mensajes{

    @Override
    public void ingresarOpciones() {
        limpiarDisplay();
        String aux = ""; int aux2 = 0;
        for (int i = 0; i < MAIN.length(); i++) {
            if (MAIN.charAt(i) == '/') {
                switch(aux2){
                    case 0 -> { // Titulo
                        ingresarTexto(aux,2,5); //fondo[2][4] = aux;
                    }
                    case 1 -> { // A
                        ingresarTexto(aux,4,2); //fondo[4][3] = aux;
                    }
                    case 2 -> { // B
                        ingresarTexto(aux,5,8); //fondo[5][7] = aux;
                    }
                    case 3 -> { // C
                        ingresarTexto(aux,6,2); //fondo[6][3] = aux;
                    }
                    case 4 -> { // D
                        ingresarTexto(aux,7,8); //fondo[7][7] = aux;
                    }
                } aux = ""; aux2++; 
            } else {
                aux += MAIN.charAt(i);
            }
        } 
    }
  
    public void mostrarDespedida(){
        limpiarDisplay();
        acomodarTexto(SALIDA, 5, 5);
    }
}
