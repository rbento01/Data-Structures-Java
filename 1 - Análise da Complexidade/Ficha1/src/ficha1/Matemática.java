/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha1;

import java.math.BigInteger;

/**
 *
 * @author António
 */
public class Matemática {
    
   public static int soma(int a, int b){
       return a+b;
   }
   
   public static int subtracao(int a, int b){
       return a-b;
   }
   
   public static int multiplicacao(int a, int b){
       return a*b;
   }
   
   public static int divisao(int a, int b){
       return a/b;
   }
   
   public static BigInteger factorialI(int num){
       BigInteger f = BigInteger.valueOf(1);
       for (int i = 1; i <= num; i++) {
           f = f.multiply(BigInteger.valueOf(i));
       }
       return f;
   }
   
   public static BigInteger factorialR(int num){
       if(num==0) 
           return BigInteger.valueOf(1);
       else 
           return BigInteger.valueOf(num).multiply(factorialR(num-1));
   }
}
