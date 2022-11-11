package paquete.programas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import paquete.interfaces.Mensajes;

public class EditorTexto extends Programa implements Mensajes{
    
    public EditorTexto(String nombre) {
        super(nombre);
    }
    // Metodos:
    /*
    - limpiar()
    - esperar()
    - resetDisplay()
    - ingresar y acomodar Texto()
    */
    public void crearTexto(){
        limpiarDisplay();
        Scanner sc = new Scanner(System.in);
        // Preparar el display para la ejecución
        ingresarTexto("Editor de texto",2,2);
        acomodarTexto(EDITOR2,3,3);
        System.out.println(mostrarDisplay());
        String nombre = sc.nextLine();
        
        // Creación de clase "Texto" para la creación de un txt.
        File Texto = new File(nombre+".txt");
        String T = "", aux = "";
        boolean salida = false;
        
        int aux2 = 1, b;
        while(salida == false){
            b=3;
            limpiarDisplay();
            Fondo[2][10] = nombre;
            while((b+12) % 13 != 0){
                System.out.println(mostrarDisplay());
                System.out.println("Linea "+aux2+":");
                aux = sc.nextLine();
                ingresarTexto(aux,b,3); b++; aux2++;
                // Solo si el usuario escribe "salir"
                if(!aux.equalsIgnoreCase("salir")){
                    T += aux+"\n";
                } else {
                    salida=true; break;
                }
                desplazarDisplay();
            }
        } limpiarDisplay();
        
        // Escritura del archivo .txt
        try {
            FileWriter crearTexto = new FileWriter(Texto.getName());
            crearTexto.write(T);
            crearTexto.close();
            ingresarTexto(EDITORFINAL,5,4);
        } catch (IOException ex) {
            System.out.println(PROGFAIL);
        }
        System.out.println(mostrarDisplay()); esperar(3);
    }
    
    // Ver una breve descripcion del programa
    public void verDescripcion(){
        limpiarDisplay();
        acomodarTexto(EDITOR1,3,3);
        System.out.println(mostrarDisplay()); esperar(3);
    }

    @Override
    public void ingresarOpciones() {
        Scanner sc = new Scanner(System.in);
        boolean salida = false;
        int X;
        
        while(salida == false){
            limpiarDisplay();
            acomodarTexto(EDITOROP,3,3);
            System.out.println(mostrarDisplay());
            System.out.println("Ingrese el número de opción.");
            X = sc.nextInt();
            switch(X){
                case 1 -> {
                    verDescripcion();
                }
                case 2 -> {
                    crearTexto(); salida=true;
                }
                case 3 -> {
                    salida = true;
                }
                default -> {
                    ingresarTexto(PROGFAIL,3,3);
                    esperar(2);
                }
            }
        }
    }

    @Override
    public void limpiarDisplay() {
        super.limpiarDisplay();
        Fondo[2][5]="Editor de texto";
    }

    @Override
    public void iniciarPrograma() {
        ingresarOpciones();
    }

}
