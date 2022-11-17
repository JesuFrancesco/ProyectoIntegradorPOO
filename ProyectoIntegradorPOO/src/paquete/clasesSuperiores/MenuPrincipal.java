package paquete.clasesSuperiores;

import paquete.interfaces.Mensajes;

public class MenuPrincipal extends Display implements Mensajes{

    @Override
    public void ingresarOpciones() {
        limpiarDisplay(1);
        String aux = ""; int aux2 = 0;
        for (int i = 0; i < MAIN.length(); i++) {
            if (MAIN.charAt(i) == '/') {
                switch(aux2){
                    case 0: { // Titulo
                        ingresarTexto(aux,7,7);
                    }
                    case 1: { // A: Editor de texto
                        ingresarTexto(aux,3,3);
                    }
                    case 2: { // B: Calculadora
                        ingresarTexto(aux,9,3);
                    }
                    case 3: { // C: Juego
                        ingresarTexto(aux,3,12);
                    }
                    case 4: { // D: Salir
                        ingresarTexto(aux,10,12);
                    }
                } aux = ""; aux2++; 
            } else {
                aux += MAIN.charAt(i);
            }
        }
        ingresarTexto("Interfaz gráfica de SO",7,6);
    }
  
    public void mostrarDespedida(){
        limpiarDisplay(1);
        acomodarTexto(SALIDA, 5, 5);
    }
}
