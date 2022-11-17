package paquete.programas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import paquete.interfaces.Mensajes;

public class EditorTexto extends Programa implements Mensajes {

    public EditorTexto(String nombre) {
        super(nombre);
    }

    public void crearTexto() {
        limpiarDisplay(1);
        Scanner sc = new Scanner(System.in);
        // Preparar el display para la ejecución
        acomodarTexto(EDITOR2, 3, 3);
        System.out.println(mostrarDisplay());
        String nombre = sc.nextLine();

        // Creación de clase "Texto" para la creación de un txt.
        File Texto = new File(nombre + ".txt");
        String aux, TextoFinal = "";
        boolean salida = false;

        int aux2 = 1, b;
        while (salida == false) {
            b = 3;
            limpiarDisplay(1);
            Fondo[2][10] = nombre;
            while ((b + 12) % 13 != 0) {
                System.out.println(mostrarDisplay());
                System.out.println("Linea " + aux2 + ":");
                aux = sc.nextLine();
                ingresarTexto(aux, 3, b);
                b++;
                aux2++;
                // Solo si el usuario escribe "salir"
                if (!aux.equalsIgnoreCase("salir")) {
                    TextoFinal += aux + "\n";
                } else {
                    salida = true;
                    break;
                }
                limpiarDisplay(0);
            }
        }
        limpiarDisplay(1);

        // Escritura del archivo .txt
        try {
            FileWriter crearTexto = new FileWriter(Texto.getName());
            crearTexto.write(TextoFinal);
            crearTexto.close();
            ingresarTexto(EDITORFINAL, 4, 4);
        } catch (IOException ex) {
            System.out.println(PROGFAIL);
        }
        System.out.println(mostrarDisplay());
        esperar(3);
    }

    // Ver una breve descripcion del programa
    public void verDescripcion() {
        limpiarDisplay(1);
        acomodarTexto(EDITOR1, 3, 3);
        System.out.println(mostrarDisplay());
        esperar(3);
    }

    @Override
    public void ingresarOpciones() {
        Scanner sc = new Scanner(System.in);
        boolean salida = false;
        int X; String auxS;

        while (salida == false) {
            limpiarDisplay(1);
            acomodarTexto(EDITOROP, 3, 3);
            System.out.println(mostrarDisplay());
            System.out.println("Ingrese el número de opción.");
            
            auxS = sc.nextLine();
            while(true){
                if(verificarNumero(auxS)==true){
                    if(Integer.parseInt(auxS)<=3){
                        X = Integer.parseInt(auxS); break;
                    }
                }
                System.out.println(VERIFVALOR);
                auxS = sc.nextLine();
            }
            
            switch (X) {
                case 1: {
                    verDescripcion();
                    break;
                }
                case 2: {
                    crearTexto();
                    break;
                }
                case 3: {
                    salida = true;
                    break;
                }
                default: {
                    ingresarTexto(PROGFAIL, 3, 3);
                    esperar(2);
                }
            }
        } // Vuelve al while salida == false
    }

    @Override
    public void limpiarDisplay(int X) {
        super.limpiarDisplay(X);
        Fondo[2][5] = "Editor de texto";
    }

    @Override
    public void iniciarPrograma() {
        ingresarOpciones();
    }

}
