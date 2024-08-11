/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha4;

/**
 *
 * @author bento
 */
public class Test {
    BinarySearchTree tree = new BinarySearchTree();
    LinkedSingleList l = new LinkedSingleList();
    
    public static long runXTimes(int times, LinkedList s){
        long sum = 0;
        for (int i = 0; i < times; i++) {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 1000000; j++) {
                double r = Math.random();
                if (!s.contains(r))
                    s.addLast(r);
                else
                    j--;
            }
            
            long end = System.currentTimeMillis();
            sum += end - start;
        }
            return sum/times;
    }
    
    public static long runXTimes(int times, BinarySearchTree s){
        long sum = 0;
        for (int i = 0; i < times; i++) {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 1000000; j++) {
                double r = Math.random();
                if (!s.contains(r))
                    s.add(r);
                else
                    j--;
               
            }

            long end = System.currentTimeMillis();
            sum += end - start;
        }
            return sum/times;
    }
    
//    public static void main(String[] args) {
//        System.out.println("Tree:" + runXTimes(1, new BinarySearchTree()));
//        System.out.println("LinkedList:" + runXTimes(1, new LinkedSingleList()));
//
//        
//    }
}
