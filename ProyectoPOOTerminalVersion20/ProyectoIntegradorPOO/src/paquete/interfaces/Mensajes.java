package paquete.interfaces;

public interface Mensajes {
    
    // Pertenecientes a todas las clases 
    public static final String TAB = "\t\t";
    public static final String ESP = "\n\n";
    public static final String PROGFAIL = "Algo salio mal, intente de nuevo./";
    public static final String ENTER = "Presione ENTER para continuar.";
    // Pertenecientes a MenuPrincipal
    public static final String MAIN = 
            "Bienvenido, elija una opcion:/"
            + "[A] Editor de texto/"
            + "[B] Calculadora/"
            + "[C] Hallar la X/"
            + "[D] Salir/";
    
    public static final String SALIDA = 
            "Hasta luego/"
            +"Tenga un buen día :-)/";
    
    // Pertenecientes a Editor de Texto
    public static final String EDITOROP =
            "Digite el número de la tarea a realizar./"
            + "[1] Ver descripcion del programa/"
            + "[2] Crear un archivo de texto/"
            + "[3] Salir/";
    
    public static final String EDITOR1 =
            "Usted puede escribir cada linea de texto desde/"
            +"la terminal para que luego se almacene como/"
            +"un archivo de texto. Para terminar solo/"
            +"digite <<salir>>./";
    
    public static final String EDITOR2 =
            "Digite el nombre de su archivo de texto/";
    
    public static final String EDITORFINAL =
            "¡Texto creado exitosamente!/";
    
    // Pertenecientes a Calculadora
    public static final String CALCOP =
            "Digite el número de la tarea a realizar./"
            + "[1] Ver <<Acerca de>>/"
            + "[2] Iniciar calculadora/"
            + "[3] Salir/";
    
    public static final String CALC1 =
            "Este programa fue realizado en conjunto por un/"
            + "grupo de estudiantes de la Universidad de Lima./"
            + "Puede digitar sus números y operandos en la/"
            + "terminal y en el display presente se mostrarán/"
            + "los resultados de las operaciones descritas.";
    
    public static final String CALC2 =
            "[1] Suma/"
            +"[2] Resta/"
            +"[3] Producto/"
            +"[4] División/";
    
    public static final String CALC3 =
            "[5] Verificar número primo/"
            +"[6] Sumatoria/"
            +"[7] Factorial/"
            +"[8] Salir/";
    
    // Pertenecientes a Hallar la X
    public static final String JUEGOOP =
            "Algo salio mal, intente de nuevo./";
}
