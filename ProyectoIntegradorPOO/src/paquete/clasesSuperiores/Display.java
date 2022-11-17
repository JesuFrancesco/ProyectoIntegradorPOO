package paquete.clasesSuperiores;

import java.time.LocalDate;

public abstract class Display {

    public String[][] Fondo;
    private String[] Aplicaciones;

    public Display() {
        Fondo = new String[15][15];
        Aplicaciones = new String[] { "A", "B", "C", "D" };
    }

    public String[][] getFondo() {
        return Fondo;
    }

    public void setFondo(String[][] fondo) {
        this.Fondo = fondo;
    }

    public String[] getAplicaciones() {
        return Aplicaciones;
    }

    public void setAplicaciones(String[] Aplicaciones) {
        this.Aplicaciones = Aplicaciones;
    }

    // Método para validar las aplicaciones en el array "Aplicaciones".
    public boolean validarAplicacion(String opcion) {
        for (int i = 0; i < Aplicaciones.length; i++) {
            if (Aplicaciones[i].equalsIgnoreCase(opcion)) {
                return true;
            }
        }
        System.out.println("\nIngrese una aplicación válida!");
        return false;

    }

    // Metodo para esperar unos segundos antes de la siguiente operación
    public void esperar(int Segundos) {
        try {
            Thread.sleep(Segundos * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Algo salio mal...");
        }
    }

    // Metodo para ingresar texto de manera directa.
    public void ingresarTexto(String Texto, int ejeX, int ejeY) {
        Fondo[ejeY][ejeX] = Texto;
    }

    // Metodo para ingresar texto con la condicion que cada char '/' sume una unidad
    // en el eje y.
    public void acomodarTexto(String TextoBarras, int ejeX, int ejeY) {
        String aux = "";
        for (int i = 0; i < TextoBarras.length(); i++) {
            if(ejeY==15){
                break;
            }
            if (TextoBarras.charAt(i) == '/') {
                Fondo[ejeY][ejeX] = aux;
                ejeY++;
                aux = "";
            } else {
                aux += TextoBarras.charAt(i);
            }
        }
    }

    // Metodo para "resetear" el display: convierte todo el interior a " ".
    public void limpiarDisplay(int borrar) {
        // Borra la terminal
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        // Si el argumento es 1 entonces borra los elementos de la matriz
        if(borrar==1){
            for (int i = 0; i < Fondo.length; i++) {
                for (int j = 0; j < Fondo[i].length; j++) {
                    if (i == 0 && j != 0) {
                        Fondo[i][j] = Integer.toString(j);
                    } else {
                        Fondo[i][j] = "";
                    }
                    if (j == 0 && i != 0) {
                        Fondo[i][j] = Integer.toString(i);
                    }
                }
            }
            Fondo[0][0] = "ULIMA";
            Fondo[14][14] = LocalDate.now().toString();
        }
    }

    // Metodo para mostrar la pantalla en la terminal.
    public String mostrarDisplay() {
        String cad = "", TAB = "\t";
        for (int i = 0; i < Fondo.length; i++) {
            for (int j = 0; j < Fondo[i].length; j++) {
                cad += Fondo[i][j] + TAB;
            }
            cad += "\n\n";
        }
        return cad;
    }

    // Método abstracto para el ingreso de las aplicaciones (diferentes por cada
    // programa)
    public abstract void ingresarOpciones();
}
