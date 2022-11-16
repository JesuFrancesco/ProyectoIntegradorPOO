package paquete.programas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import paquete.interfaces.Mensajes;

public class Calculadora extends Programa implements Mensajes{

    public Calculadora(String nombre) {
        super(nombre);
    }
    
    public String ordenarLista(ArrayList X){
        String cad = "";
        Iterator<Integer> puntero = X.iterator();
        int contador = 0;
//      System.out.println(puntero);
//      System.out.println(puntero.next());
//      System.out.println(puntero.hasNext());
        while(puntero.hasNext()){
            cad += puntero.next()+", ";
            contador++;
            if(contador>12){
                cad+="/"; contador=0;
            }
        }
        return cad;
    }
    public void verAcercaDe(){
        Scanner sc = new Scanner(System.in);
        limpiarDisplay();
        acomodarTexto(CALC1,3,3);
        System.out.println(mostrarDisplay());
        System.out.println(ENTER); sc.nextLine();
    }
    
    public void Calcular(){
        String[] operaciones = new String[]{"Suma","Resta","Multiplicación","División","Número primo","Sumatoria","Factorial",""};
        Scanner sc = new Scanner(System.in);
        int Opcion = 0;
        
        do {
            limpiarDisplay();
            acomodarTexto(CALC2,3,3);
            acomodarTexto(CALC3,6,3);
            System.out.println(mostrarDisplay());
            System.out.println("Digite su opción a realizar:");
            Opcion = sc.nextInt(); limpiarDisplay();
            
            ingresarTexto(operaciones[Opcion-1],5,3);
            if(Opcion<=4){
                // Desde suma a división (dos números)
                float Num1, Num2, Resultado = 0;
                
                ingresarTexto("* Ingrese el primer número", 5, 4);
                System.out.println(mostrarDisplay());
                System.out.println("Digite su número");
                Num1 = sc.nextFloat(); 
                ingresarTexto(String.valueOf(Num1), 6, 4);desplazarDisplay();

                ingresarTexto("* Ingrese el segundo número", 5, 5);
                System.out.println(mostrarDisplay());
                System.out.println("Digite su número");
                Num2 = sc.nextFloat();
                ingresarTexto(String.valueOf(Num2), 6, 5); desplazarDisplay();
                switch(Opcion){
                    case 1 -> {
                        Resultado = Num1 + Num2;
                    }
                    case 2 -> {
                        Resultado = Num1 - Num2;
                    }
                    case 3 -> {
                        Resultado = Num1 * Num2;
                    }
                    case 4 -> {
                        Resultado = Num1 / Num2;
                    }
                    default -> {
                        System.out.println(PROGFAIL);
                    }
                }
                

            } else if (4 < Opcion && Opcion < 8){
                // Desde número primo a factorial (trabajo de naturales en array's)
                int Num1;
                // Clase genérica
                ArrayList<Integer> listaAux = new ArrayList<Integer>();
                
                ingresarTexto("* Ingrese su número a trabajar", 5, 4);
                System.out.println(mostrarDisplay());
                System.out.println("Digite su número");
                Num1 = sc.nextInt(); 
                ingresarTexto(String.valueOf(Num1), 6, 4); desplazarDisplay();
                switch(Opcion){
                    case 5 -> {
                        // Número primo
                        int cantDivisores = 1;
                        String esPrimo = "es primo";
                        boolean unaVez=true;
                        
                        for(int i = 1; i<Num1; i++){
                            if(Num1 % i == 0){
                                listaAux.add(i);
                                cantDivisores++;
                            }
                            if(cantDivisores>2 && unaVez==true){
                                esPrimo = "no es primo"; unaVez=false;
                            }
                        }
                        ingresarTexto("El número ingresado "+esPrimo,5,5);
                        
                        String cad = ordenarLista(listaAux);
                        acomodarTexto("Los divisores son: "+cad+"y "+Num1+"/",5,6);
                    }
                    case 6 -> {
                        int Resultado = Num1;
                    }
                    case 7 -> {
                        int Resultado = Num1;
                    }
                    default -> {
                        System.out.println(PROGFAIL);
                    }
                }
            } else {
                System.out.println("Cerrando la calculadora."); break;
            }
            System.out.println(mostrarDisplay());
            System.out.println(ENTER);
            sc.nextLine(); sc.nextLine(); // Dos veces por el nextfloat
        } while(Opcion != 8);
        
    }

    @Override
    public void ingresarOpciones() {
        Scanner sc = new Scanner(System.in);
        int X;
        
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
        ingresarTexto("Calculadora",5,1);
    }
    
    @Override
    public void iniciarPrograma() {
        ingresarOpciones();
    }
        
}
