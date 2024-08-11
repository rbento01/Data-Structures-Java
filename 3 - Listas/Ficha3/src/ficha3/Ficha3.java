/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha3;

/**
 *
 * @author bento
 */
public class Ficha3 {

//    public static long runXTimes(int times, LinkedList s){
//        long sum = 0;
//        for (int i = 0; i < times; i++) {
//            long start = System.currentTimeMillis();
//            for (int j = 0; j < 1000000; j++) {
//                s.addLast(Math.random()*100);
//            }
//            for (int x = 1; x < 101; x++) {
//                s.count(x);
//            }
//
//            while(!s.isEmpty())
//                    s.remove(s.peekFirst());
//
//            long end = System.currentTimeMillis();
//            sum += end - start;
//        }
//            return sum/times;
//    }
//    
//    public static long runXTimes(int times, java.util.LinkedList s){
//        long sum = 0;
//        int contador =0;
//        for (int i = 0; i < times; i++) {
//            long start = System.currentTimeMillis();
//            for (int j = 0; j < 1000000; j++) {
//                s.addLast(Math.random()*100);   
//            }
//            for (int x = 1; x < 101; x++) {
//                if(s.contains(x)){
//                    contador++;
//                }
//            }
//            while(!s.isEmpty())
//                s.remove(s.peekFirst());
//            
//            long end = System.currentTimeMillis();
//            sum += end - start;
//        }
//        return sum/times;
//    }
     
    public static void main(String[] args) {
//        System.out.println("Single:" + runXTimes(1, new LinkedSingleList()));
//        System.out.println("Duple:" + runXTimes(1, new LinkedDupleList()));
//        System.out.println("Java:" + runXTimes(1, new java.util.LinkedList()));
        LinkedSingleList l = new LinkedSingleList();
        
        l.addLast(1);
        l.addLast(2);
        l.addLast(3);
        l.addLast(4);
        l.addLast(5);
        System.out.println(l.mostra());
        l.substitui(1, 67);
        System.out.println(l.mostra());
        
        l.inverter();
        System.out.println(l.mostra());
        l.removeTodos(l);
        System.out.println(l.mostra());
        
        
    }
    
}   

