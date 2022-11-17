package paquete.programas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import paquete.interfaces.Mensajes;

@SuppressWarnings("unchecked") // Manda error por el arraylist
public class Calculadora extends Programa implements Mensajes {

    public Calculadora(String nombre) {
        super(nombre);
    }
    
    public String ordenarLista(ArrayList X) {
        String cad = "";
        Iterator<Integer> puntero = X.iterator();
        int contador = 0;
        while (puntero.hasNext()) {
            int aux = puntero.next();
            cad += aux;
            if(X.indexOf(aux) == X.size()-2){cad+=" y ";}
            else if(puntero.hasNext()){cad+=", ";}
            else {cad+=".";}
            contador++;
            if (contador > 12) {
                cad += "/";
                contador = 0;
            }
        }
        return cad;
    }

    public void verAcercaDe() {
        Scanner sc = new Scanner(System.in);
        limpiarDisplay(1);
        acomodarTexto(CALC1, 3, 3);
        System.out.println(mostrarDisplay());
        System.out.println(ENTER);
        sc.nextLine();
    }

    public void Calcular() {
        String[] operaciones = new String[] { "Suma", "Resta", "Multiplicación", "División", "Número primo",
                "Sumatoria", "Factorial", ""};
        Scanner sc = new Scanner(System.in);
        int Opcion;

        do {
            Opcion = 0; String auxS;
            limpiarDisplay(1);
            acomodarTexto(CALC2, 3, 3);
            acomodarTexto(CALC3, 6, 3);
            System.out.println(mostrarDisplay()); System.out.println("Digite su opción a realizar:");

            auxS = sc.nextLine();
            while(true){
                if(verificarNumero(auxS)==true){
                    if(Integer.parseInt(auxS)<=8){
                        Opcion = Integer.parseInt(auxS); break;
                    }
                }
                System.out.println(VERIFVALOR);
                auxS = sc.nextLine();
            }
            limpiarDisplay(1);

            // Mostrar el título de la operación
            ingresarTexto(operaciones[Opcion - 1], 5, 3);
            // Operaciones simples de dos números
            if (Opcion <= 4) {
                // Desde suma a división (dos números)
                float Num1, Num2, Resultado = 0;

                // Input del primer número
                ingresarTexto("* Ingrese el primer número: ", 4, 4);
                System.out.println(mostrarDisplay()); System.out.println("Digite su número");
                auxS = sc.nextLine();
                // Verificar que se ingrese un valor de tipo float
                while(true){
                    if(verificarFloat(auxS)==true){
                        Num1 = Float.parseFloat(auxS); break;
                    }
                    System.out.println(VERIFVALOR);
                    auxS = sc.nextLine();
                }
                ingresarTexto("* Ingrese el primer número: " + String.valueOf(Num1), 4, 4);
                limpiarDisplay(0);
                
                // Input del segundo número
                ingresarTexto("* Ingrese el segundo número", 4, 5);
                System.out.println(mostrarDisplay());
                System.out.println("Digite su número");
                auxS = sc.nextLine();
                // Verificar float
                while(true){
                    if(verificarFloat(auxS)==true){
                        Num2 = Float.parseFloat(auxS); break;
                    }
                    System.out.println(VERIFVALOR);
                    auxS = sc.nextLine();
                }
                ingresarTexto("* Ingrese el segundo número: " + String.valueOf(Num2), 4, 5);
                limpiarDisplay(0);
                
                // Multiplexación de las operaciones mediante Switch-case
                switch (Opcion) {
                    case 1: {
                        Resultado = Num1 + Num2;
                        break;
                    }
                    case 2: {
                        Resultado = Num1 - Num2;
                        break;
                    }
                    case 3: {
                        Resultado = Num1 * Num2;
                        break;
                    }
                    case 4: {
                        if (Num2 == 0) {
                            ingresarTexto("** El número ingresado no puede un divisor.", 3, 5);
                            break;
                        }
                        Resultado = Num1 / Num2;
                        break;
                    }
                    default: {
                        System.out.println(PROGFAIL);
                    }
                }
                ingresarTexto("** El resultado es: " + Resultado, 3, 6);

                // Para las opciones de array's...
            } else if (4 < Opcion && Opcion < 8) {
                int Num1;
                ArrayList<Integer> listaAux = new ArrayList<Integer>();

                ingresarTexto("* Ingrese su número a trabajar: ", 4, 4);
                System.out.println(mostrarDisplay());
                System.out.println("Digite su número");
                auxS = sc.nextLine();
                while(true){
                    if(verificarNumero(auxS)==true){
                        Num1 = Integer.parseInt(auxS); break;
                    }
                    System.out.println(VERIFVALOR);
                    auxS = sc.nextLine();
                }
                ingresarTexto("* Ingrese su número a trabajar: "+String.valueOf(Num1), 4, 4);
                limpiarDisplay(0);
                
                // Multiplexación de operaciones
                switch (Opcion) {
                    case 5: { // Número primo
                        // Operaciones inválidas
                        if (Num1 <= 1) {
                            ingresarTexto("** El número ingresado no puede ser analizado", 3, 5);
                            break;
                        }
                        // Definición
                        int cantDivisores = 0;
                        String esPrimo = "es primo";
                        boolean unaVez = true;
                        // Cálculo
                        for (int i = 1; i <= Num1; i++) {
                            if (Num1 % i == 0) {
                                listaAux.add(i);
                                cantDivisores++;
                            }
                            if (cantDivisores > 2 && unaVez == true) {
                                esPrimo = "no es primo";
                                unaVez = false;
                            }
                        }
                        ingresarTexto("** El número ingresado " + esPrimo, 3, 5);

                        String cad = ordenarLista(listaAux);
                        acomodarTexto("Los divisores son:/" + cad + "/", 3, 6);
                        boolean bordeDisplay = (Fondo[14][3].equalsIgnoreCase(""));
                        if(bordeDisplay == false){
                            ingresarTexto("y continúa.",3,14);
                        }
                        break;
                    } // Fin de número primo
                    
                    case 6: {
                        // Sumatoria
                        if (Num1 <= 1) {
                            ingresarTexto("** El número ingresado no puede ser analizado", 3, 5);
                            break;
                        }
                        int numIni, saltoNum, sumaTotal = 0;
                        
                        // Input del número de inicio
                        ingresarTexto("* Ingrese el número de inicio de la sumatoria", 4, 5);
                        System.out.println(mostrarDisplay()); System.out.println("Digite su número");
                        auxS = sc.nextLine();
                        while(true){
                            if(verificarNumero(auxS)==true){
                                numIni = Integer.parseInt(auxS); break;
                            }
                            System.out.println(VERIFVALOR);
                            auxS = sc.nextLine();
                        }
                        ingresarTexto("* Ingrese el número de inicio de la sumatoria "+String.valueOf(numIni), 4, 5);
                        limpiarDisplay(0);
                        
                        // Input del salto de números
                        ingresarTexto("* Ingrese el salto entre números: ", 4, 6);
                        System.out.println(mostrarDisplay()); System.out.println("Digite su número");
                        auxS = sc.nextLine();
                        while(true){
                            if(verificarNumero(auxS)==true){
                                if(Integer.parseInt(auxS)>0){
                                    saltoNum = Integer.parseInt(auxS); break;
                                }
                            }
                            System.out.println(VERIFVALOR);
                            auxS = sc.nextLine();
                        }
                        ingresarTexto("* Ingrese el salto entre números: "+String.valueOf(saltoNum), 4, 6);
                        
                        // Sumatoria
                        for (int i = numIni; i <= Num1; i += saltoNum) {
                            listaAux.add(i);
                            sumaTotal += i;
                        }
                        
                        String cad = ordenarLista(listaAux);
                        ingresarTexto("** La sumatoria resulta "+String.valueOf(sumaTotal), 3, 7);
                        acomodarTexto("** La suma fue de los números:/" + cad + "/", 3, 8);
                        boolean bordeDisplay = (Fondo[14][3].equalsIgnoreCase(""));
                        if(bordeDisplay == false){
                            ingresarTexto("y continúa.",3,14);
                        }
                        break;
                    }
                    
                    case 7: {
                        // Factorial
                        if(Num1<=0){
                            ingresarTexto("** El número ingresado no puede ser analizado", 3, 5);
                            break;
                        }
                        int Resultado = 1;
                        for(int i = 1; i<=Num1; i++){
                            listaAux.add(i);
                            Resultado *= i;
                        }
                        String cad = ordenarLista(listaAux);
                        
                        // Mostrar resultado
                        ingresarTexto("** El factorial resulta "+String.valueOf(Resultado), 3, 5);
                        acomodarTexto("** El producto fue de los términos:/" + cad+ "/", 3, 6);
                        boolean bordeDisplay = (Fondo[14][3].equalsIgnoreCase(""));
                        if(bordeDisplay == false){
                            ingresarTexto("y continúa.",3,14);
                        }
                        break;
                    }
                    default: {
                        System.out.println(PROGFAIL);
                    }
                }
            } else {
                System.out.println("Saliendo de las operaciones.");
                break;
            }
            System.out.println(mostrarDisplay());
            System.out.println(ENTER);
            sc.nextLine(); // Dos veces por el nextfloat
        } while (Opcion != 8);
    }

    @Override
    public void ingresarOpciones() {
        Scanner sc = new Scanner(System.in);
        String auxS; int X;

        do {
            X = 0;
            limpiarDisplay(1);
            acomodarTexto(CALCOP, 3, 3);
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
                    verAcercaDe();
                    break;
                }
                case 2: {
                    Calcular();
                    break;
                }
                case 3: {
                    System.out.println("Cerrando la calculadora."); break;
                }
                default: {
                    ingresarTexto(PROGFAIL, 3, 3);
                    esperar(2);
                    sc.close();
                }
            }
        } while (X != 3);
    }

    @Override
    public void limpiarDisplay(int X) {
        super.limpiarDisplay(X);
        ingresarTexto("Calculadora", 5, 1);
    }

    @Override
    public void iniciarPrograma() {
        ingresarOpciones();
    }

}
