package ficha2_;

import ficha2.IllimitedStack;
import ficha2.LimitedStack;
import ficha2.Stack;

public class Ficha2 {
    
    public static long runXTimes(int times, Stack s){
        long sum = 0;
        for (int i = 0; i < times; i++) {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 1000000; j++) {
                s.push(Math.random());   
            }
            while(!s.isEmpty()){
                s.pop();
            }
            long end = System.currentTimeMillis();
            sum += end - start;
        }
        return sum/times;
    }
    
     public static long runXTimes(int times, java.util.Stack s){
        long sum = 0;
        for (int i = 0; i < times; i++) {
            long start = System.currentTimeMillis();
            for (int j = 0; j < 1000000; j++) {
                s.push(Math.random());   
            }
            while(!s.isEmpty()){
                s.pop();
            }
            long end = System.currentTimeMillis();
            sum += end - start;
        }
        return sum/times;
    }
     
    public static void main(String[] args) {
//        System.out.println("Limited:" + runXTimes(10, new LimitedStack(1000000)));
//        System.out.println("Illimited:" + runXTimes(10, new IllimitedStack()));
//        System.out.println("Java:" + runXTimes(10, new java.util.Stack()));

    LimitedStack l = new LimitedStack(5);
    
    l.push(4);
    l.push(3);
    l.push(2);
    l.push(1);
        System.out.println(l.pop());
    }
}
