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
public class Ficha4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree l = new BinarySearchTree();
        l.add(17);
        l.add(14);
        l.add(5);
        l.add(12);
        l.add(6);
        l.add(2);
        
        l.remove(5);
        l.mostrar();
    }
    
}
