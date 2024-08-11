/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5;

import java.util.Random;

/**
 *
 * @author bento
 */
public class ficha5 {
    public static void main(String[] args) {
        Heap h = new HeapMin(10);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            h.add(r.nextInt(100));
        }
        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove(h.peek());
        }
    }
}
