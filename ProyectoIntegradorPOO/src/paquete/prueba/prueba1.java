package paquete.prueba;

import java.util.Scanner;

import paquete.clasesSuperiores.MenuPrincipal;
import paquete.gestion.*;
import paquete.programas.*;

class prueba1 {
    public static void main(String[] args)
    {
            /* Atributos del programa */
        String opcion = "opcion";

            /* Clases: utilidades de java */
        Scanner sc = new Scanner(System.in); // Scanner

            /* Clases creadas para el programa */
        GestionPrograma GestionP = new GestionPrograma();
        MenuPrincipal MenuP = new MenuPrincipal();
        
        EditorTexto EditorT = new EditorTexto("A");
        Calculadora Calc = new Calculadora("B");
        JuegoX Juego = new JuegoX("C");
        
        GestionP.ingresar(EditorT); GestionP.ingresar(Calc); GestionP.ingresar(Juego);

            /* Inicio del programa */
        while(!opcion.equalsIgnoreCase("D")){
            // Generacion de la GUI y mostrar programas disponibles
            MenuP.limpiarDisplay(); MenuP.ingresarOpciones();
            System.out.println(MenuP.mostrarDisplay());
            System.out.println("Ingrese la letra de la aplicacion:");

            // Input de caracter
            opcion = sc.nextLine();
            
            //Validación del programa
            while(MenuP.validarAplicacion(opcion)==false){
                opcion = sc.nextLine();
            } MenuP.limpiarDisplay();
            GestionP.ejecutarPrograma(opcion);
        }
        
        // Salida del sistema
        MenuP.limpiarDisplay();
        MenuP.mostrarDespedida();
        System.out.println(MenuP.mostrarDisplay());
        MenuP.esperar(3);
        MenuP.limpiarDisplay();
    }
}
