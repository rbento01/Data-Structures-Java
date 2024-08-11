/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha1;

/**
 *
 * @author António
 */
public class Ficha1 {
    public static final int ITERATIVE = 1;
    public static final int RECURSIVE = 2;
    
    public static long runXTimes(int times, int value, int version){
        long sum = 0;
        for (int i = 0; i < times; i++) {
            long start = System.currentTimeMillis();
            switch(version){
                case ITERATIVE : Matemática.factorialI(value);
                                break;
                case RECURSIVE : Matemática.factorialR(value);
                                break;
            }
            long end = System.currentTimeMillis();
            sum += end - start;
        }
        return sum/times;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here4
        System.out.println("-------Versão Iterativa-------");
        for (int i = 1000; i <= 20000; i+=1000) {
            System.out.println(i + "-" +runXTimes(10, i, ITERATIVE));
        }
        System.out.println("-------Versão Recursiva-------");
        for (int i = 1000; i <= 20000; i+=1000) {
            System.out.println(i + "-" +runXTimes(10, i, RECURSIVE));
        }
    }
}
