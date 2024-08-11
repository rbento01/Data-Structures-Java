/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvores;

import java.util.Random;

/**
 *
 * @author paulo
 */
public class Arvores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /*  Random r = new Random();
        BinarySearchTree bst = new BinarySearchTree();
        long ini = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            int num = r.nextInt();
            if (!bst.contains(i))
                bst.add(i);
        }
        System.out.println(System.currentTimeMillis()-ini);
        
        AVLTree avl = new AVLTree();
        ini = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            int num = r.nextInt();
            if (!avl.contains(i))
                avl.add(i);
        }
        System.out.println(System.currentTimeMillis()-ini);*/
      
      BinarySearchTree t = new BinarySearchTree();
      t.add(4);
      t.add(6);
      t.add(3);
      t.add(5);
      t.add(7);
      t.add(8);
      t.add(2);
  
      BinarySearchTree.union(t, t).mostrar();
        
    }
    
}
