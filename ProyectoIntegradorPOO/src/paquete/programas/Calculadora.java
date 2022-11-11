package paquete.programas;

import java.util.Scanner;
import paquete.interfaces.Mensajes;

public class Calculadora extends Programa implements Mensajes{

    public Calculadora(String nombre) {
        super(nombre);
    }

    public void verAcercaDe(){
        Scanner sc = new Scanner(System.in);
        limpiarDisplay();
        acomodarTexto(CALC1,3,3);
        System.out.println(mostrarDisplay()); System.out.println(ENTER);
        sc.nextLine();
    }
    
    public void Calcular(){
        Scanner sc = new Scanner(System.in);
        limpiarDisplay();
        ingresarTexto("Debug",4,5);
        System.out.println(mostrarDisplay());
        System.out.println(ENTER);
        sc.nextLine();
    }

    @Override
    public void ingresarOpciones() {
        Scanner sc = new Scanner(System.in);
        int X=0;
        
        do {
            limpiarDisplay();
            acomodarTexto(CALCOP,3,3);
            System.out.println(mostrarDisplay());
            System.out.println("Ingrese el número de opción.");
            X = sc.nextInt();
            switch(X){
                case 1 -> {
                    verAcercaDe();
                }
                case 2 -> {
                    Calcular();
                }
                case 3 -> {
                    break;
                }
                default -> {
                    ingresarTexto(PROGFAIL,3,3);
                    esperar(2);
                }
            }
        } while(X != 3);
    }

    @Override
    public void limpiarDisplay() {
        super.limpiarDisplay();
        Fondo[1][5] = "Calculadora";
    }
    
    @Override
    public void iniciarPrograma() {
        ingresarOpciones();
    }
        
}
