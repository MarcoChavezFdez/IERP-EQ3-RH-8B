/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringgenerator;

/**
 *
 * @author Marco Chavez
 */
public class StringGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

// Condicion para el numero de bits por host
//        for (int i = 2; i <= 10; i++) {
//            if (i != 10) {
//                System.out.print("SI(C3<=" + (Math.pow(2, i)-2) + "," + (Math.pow(2, i)) + ",");
//            } else {
//                System.out.print("SI(C3<=" + (Math.pow(2, i)-2) + "," + (Math.pow(2, i)));
//            }
//
//        }
//        for (int i = 2; i < 10; i++) {
//            System.out.print(")");
//        }
//        System.out.println("");

        for (int i = 1; i <= 8; i++) {
            

            if (i != 8) {
                System.out.print("SI(POTENCIA(D3,(1/" + i + "))=2," + i + ",");
            } else {
                 System.out.print("SI(POTENCIA(D3,(1/" + i + "))=2," + i + ")");
            }

        }
        for (int i = 1; i <= 8; i++) {
            System.out.print(")");
        }

    }
}


