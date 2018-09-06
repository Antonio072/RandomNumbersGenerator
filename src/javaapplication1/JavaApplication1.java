
package javaapplication1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaApplication1 {
    
//     /*Genera numeros aleatorios
//        */
//       for (int i = 0; i < 10; i++) {
//             String cAleatoria=""+System.nanoTime();
//       
//         System.out.println( cAleatoria.charAt(cAleatoria.length()-1));
//         }
     static List<String> result = new ArrayList<>();
    
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String cadena2;
        do {
         System.out.println("Dame cadena");
        
        cadena2=sc.nextLine();
       
        }while(cadena2.length()!=4);
            
        Aleatorio(Integer.parseInt(cadena2));
       for(String s:result){
           System.out.println(s);
       }
    }
    static void Aleatorio(int numero){
         int numeCuadrado=numero*numero;
                
            for (int i = 0; i < 10; i++) {
               
             String CadeN2=""+numeCuadrado;
                switch(CadeN2.length()){
                case 8:
                    numeCuadrado=Integer.parseInt(CadeN2.substring(2, CadeN2.length()-2));
                    result.add(checkChar(""+numeCuadrado));
                    break;
                case 7: 
                    numeCuadrado=Integer.parseInt(CadeN2.substring(1, CadeN2.length()-2));
                    result.add(checkChar(""+numeCuadrado));
                    break;
                case 6:numeCuadrado=Integer.parseInt(CadeN2.substring(1,CadeN2.length()-1));
                    result.add(checkChar(""+numeCuadrado));
                        break;
                    
                default:
                
            } numeCuadrado*=numeCuadrado;
           
            }
               
          
    
    
    }
   static String checkChar(String resultado)
    {switch(resultado.length())
    {
        case 1:return "0.000"+resultado;
        case 2:return "0.00"+resultado;
        case 3:return "0.0"+resultado;
        case 4:return "0."+resultado;
        
    }
         return null;
        
    }

}
