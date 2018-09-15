package javaapplication1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaApplication1 {

    //Se generan los resultados y una variable extra en caso de que sea necesaria
    static List<String> result = new ArrayList<>();
    static String semillaArreglada;
    static int semillaLength;
    
    public static void main(String[] args) {
       //Creamos el scanner para ller datos del teclado y creamos una variable para almacenar la semilla
        Scanner sc = new Scanner(System.in);
        String semilla;

        //Obtenemos la semilla del teclado, en caso de que sea menor a 4 digitos o mayor a 8 volverá a preguntar
        do {
            System.out.println("Dame cadena");

            semilla = sc.nextLine();
            
        } while (semilla.length() < 4 || semilla.length() > 8);
        semillaLength = semilla.length();
        
        /*
            Tratamos de ejecutar el metodo "Aleatorio" que realiza el procedimiento
            El programa terminará cuando encuentre 0000 en los digitos por ejemplo:
                1000 --> 1000^2 --> 1000000
            Como el numero tiene 7 digitos se arregla
            En este caso se arregla de la siguiente manera
                01000000
            Y se elminan los numeros de los extremos para dejar lo 4 digitos de en medio
                01-0000-00
            Al tener 0000, si se eleva al cuadrado el resultado será 0 por lo tanto caería en un ciclo
        */
        try {
            Aleatorio(Integer.parseInt(semilla));

        } 
        //Si cae en un ciclo terminamos el programa y mostramos los resultados
        catch (Exception e) {
            
            System.out.println("Los 4 digitos del resultado son 0 por lo tanto el programa finalizará");

        }
        //Mostramos los resultados
        for (String s : result) {
            System.out.println(s);
        }
    }

    static void Aleatorio(int numero) {
        //Obtenemos el numero del teclado y lo elevamos al cuadrado
        long numeCuadrado =(long)Math.pow(numero,2);
        //Se realizaran 10 iteraciones, pueden ser cambiadas de acuerdo a la necesidad
        for (int i = 0; i < 10; i++) {
            //El numeroCuadrado lo pasamos a String con el fin de poder manejarlo de manera más sencilla
            String CadeN2 = "" + numeCuadrado;
            /*
                Se agregan los digitos convertidos a los resultados
                Usando el metodo getMiddleNumbers se arregla en caso de que los digitos sean impares
                y se obtienen los 4 digitos del centro
            
                Con el metodo checkChar convertimos los 4 numeros de en medio a 4 digitos por ejemplo:
                Si obtenemos los digitos 923 necesitamos convertirlo a 4
                Por lo cual obtenemos 0923 y asi sucesivamente
                    1 --> 0001
                   11 --> 0011
                  111 --> 0111
                 1111 --> 1111
                 Y solo realizamos la conversion a decimal agregando un 0. al inicio del numero
            */
            result.add(checkChar("" + getMiddleNumbers(CadeN2)));
            //Obtenemos nuestra nueva semilla
            numeCuadrado = getMiddleNumbers(CadeN2);
            numeCuadrado = (long)Math.pow(numeCuadrado,2);
        }

    }

    static String checkChar(String resultado) {
        //Se realiza la conversion a numero decimal
        
        int iterations = semillaLength-resultado.length();
        String back = "0.";
        for(int i = 0; i<iterations; i++){
            back +="0";
        }
       
        return back+resultado;

    }

    static int getMiddleNumbers(String semilla) {
        //Revisamos si la longitud de la semilla es par o impar
        if (semilla.length() % 2 != semillaLength % 2 )
            semillaArreglada = "0" + semilla;
         else 
            semillaArreglada = semilla;
       /*
        Con la semillaArreglada obtenemos los valores para no utilizar los caracteres izquierdos y derechos
        Sabremos cuales son los 4 digitos del centro sin importar la longitud del arreglo
        */
        int resultado = (semillaArreglada.length() - semillaLength) / 2;
        //Regresamos los 4 digitos del centro
        return Integer.parseInt(semillaArreglada.substring(resultado, semillaArreglada.length() - resultado));

    }
}
