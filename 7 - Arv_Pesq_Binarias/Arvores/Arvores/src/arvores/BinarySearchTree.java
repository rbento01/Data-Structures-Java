/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvores;

import java.util.ArrayList;

/**
 *
 * @author paulo
 */
public class BinarySearchTree implements Tree {
    
    protected Nodo root;
    
    public BinarySearchTree() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public void add(Comparable o) {
        Nodo nodo = new Nodo();
        nodo.data = o;
        nodo.left = null;
        nodo.rigth = null;
        if (root == null)
            root = nodo;
        else
            add(root, nodo);
    }
    
    private void add(Nodo actual, Nodo novo) {
        if (novo.data.compareTo(actual.data) < 0 )
            if (actual.left == null)
                actual.left = novo;
            else
                add(actual.left, novo);
        else 
            if (actual.rigth == null)
                actual.rigth = novo;
            else
                add(actual.rigth, novo);
    }

    @Override
    public boolean contains(Comparable o) {
        return contains(root, o);
    }
    
    private boolean contains(Nodo actual, Comparable o) {
        if (actual == null)
            return false;
        else if (actual.data.equals(o))
            return true;
        else if (o.compareTo(actual.data) < 0 )
            return contains(actual.left, o);
        else
            return contains(actual.rigth, o);
    }

    @Override
    public boolean remove(Comparable o) {
        Nodo nodoARemover = find(o);
        if (nodoARemover == null)
            return false;
        else {
            Nodo parent = findParent(o);
            if (root.left == null && root.rigth == null)
                root = null;
            else if (nodoARemover.left == null && nodoARemover.rigth == null) // caso 1
                if (nodoARemover.data.compareTo(parent.data) < 0 )
                    parent.left = null;
                else
                    parent.rigth = null;
            else if (nodoARemover.left == null && nodoARemover.rigth != null) // caso 2.1
                if (nodoARemover.data.compareTo(parent.data) < 0 )
                    parent.left = nodoARemover.rigth;
                else
                    parent.rigth = nodoARemover.rigth;
            else if (nodoARemover.left != null && nodoARemover.rigth == null) // caso 2.2
                if (nodoARemover.data.compareTo(parent.data) < 0 )
                    parent.left = nodoARemover.left;
                else
                    parent.rigth = nodoARemover.left;
            else { // caso 3
                Nodo nodoMaior = nodoARemover.left;
                while (nodoMaior.rigth != null)
                    nodoMaior = nodoMaior.rigth;
                Nodo parentNodoMaior = findParent(nodoMaior.data);
                if (parentNodoMaior == nodoARemover)
                    parentNodoMaior.left = nodoMaior.left;
                else
                    parentNodoMaior.rigth = nodoMaior.left;
                nodoARemover.data = nodoMaior.data;
            }
            return true;
        }
    }
    
    private Nodo find(Comparable o) {
        return find(root, o);
    }

    private Nodo find(Nodo actual, Comparable o) {
        if (actual == null)
            return null;
        else
            if (actual.data.equals(o))
                return actual;
            else
                if (o.compareTo(actual.data) < 0 )
                    return find(actual.left, o);
                else
                    return find(actual.rigth, o);
    }
    
    protected Nodo findParent(Comparable o) {
        return findParent(root, o);
    }

    private Nodo findParent(Nodo actual, Comparable o) {
        if (o.equals(actual.data))
            return null;
        else
            if (o.compareTo(actual.data) < 0 )
                if (actual.left == null)
                    return null;
                else if (actual.left.data.equals(o))
                    return actual;
                else
                    return findParent(actual.left, o);
            else if (actual.rigth == null)
                return null;
            else if (actual.rigth.data.equals(o))
                return actual;
            else
                return findParent(actual.rigth, o);
    }

    @Override
    public Comparable findMin() {
        if (root == null)
            return null;
        else
            return findMin(root);
    }
    
    private Comparable findMin(Nodo actual) {
        if (actual.left == null)
            return actual.data;
        else
            return findMin(actual.left);
    }

    @Override
    public Comparable findMax() {
        if (root == null)
            return null;
        else
            return findMax(root);
    }
    
    private Comparable findMax(Nodo actual) {
        if (actual.rigth == null)
            return actual.data;
        else
            return findMax(actual.rigth);
    }
    
    public void mostrar() {
        mostrar(root, 0, 0);
    }

    private void mostrar(Nodo actual, int nivel, int aux) {
        if (actual!=null) {
            mostrar(actual.rigth, nivel+1, 1);
            for(int i=0; i < nivel; i++)
                System.out.print(" ");
            if (aux > 0) System.out.print("/");
            if (aux < 0) System.out.print("\\");
            System.out.println(actual.data);
            mostrar(actual.left, nivel+1, -1);
        }
    }
    
    protected class Nodo {
        Comparable data;
        Nodo left;
        Nodo rigth;
    }
    
    public boolean isLeaf(Comparable o) {
        return isLeaf(root, o);
    }
    
    private boolean isLeaf(Nodo actual, Comparable o) {
        if (actual == null)
            return false;
        else if (actual.data.equals(o))
            return actual.left == null && actual.rigth == null;
        else if (o.compareTo(actual.data) < 0 )
            return contains(actual.left, o);
        else
            return contains(actual.rigth, o);
    }
    
    public boolean isUnique(Comparable o) {
        return isUnique(root, o);
    }
    
    private boolean isUnique(Nodo actual, Comparable o) {
        if (actual == null)
            return false;
        else if (actual.data.equals(o))
            return !(true && isUnique(actual.rigth, o));
        else if (o.compareTo(actual.data) < 0 )
            return contains(actual.left, o);
        else
            return contains(actual.rigth, o);
    }

    protected Comparable brother(Comparable o) {
        return brother(root, o);
    }

    private Comparable brother(Nodo actual, Comparable o) {
        if (o.equals(actual.data))
            return null;
        else
            if (o.compareTo(actual.data) < 0 )
                if (actual.left == null)
                    return null;
                else if (actual.left.data.equals(o))
                    return actual.rigth==null?null:actual.rigth.data;
                else
                    return brother(actual.left, o);
            else if (actual.rigth == null)
                return null;
            else if (actual.rigth.data.equals(o))
                return  actual.left==null?null:actual.left.data;
            else
                return brother(actual.rigth, o);
    }
    
    public int level(Comparable o) {
        return level(root, o, 1);
    }
    
    private int level(Nodo actual, Comparable o, int nivel) {
        if (actual == null)
            return -1;
        else if (actual.data.equals(o))
            return nivel;
        else if (o.compareTo(actual.data) < 0 )
            return level(actual.left, o, nivel+1);
        else
            return level(actual.rigth, o, nivel+1);
    }
    
    public int heigth() {
        return heigth(root,1);
    }
    
    private int heigth(Nodo actual, int nivel) {
        if (actual != null) {
            int e = heigth(actual.left, nivel+1);
            int d = heigth(actual.rigth, nivel+1);
            return e>d?e:d;
        } 
        return nivel-1;
    }
    
    public int biggerLevel() {
        int a[] = new int[heigth()];
        biggerLevel(root,1, a);
        int max = a[0];
        int maxIndex = 0;
        for(int i = 1; i < a.length; i++ ) {
            if (a[i]> max) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex+1;
    }
    
    private void biggerLevel(Nodo actual, int nivel, int a[]) {
        if (actual != null) {
            a[nivel-1]++;
            biggerLevel(actual.left, nivel+1, a);
            biggerLevel(actual.rigth, nivel+1, a);
        } 
    }
    
    public int numberOfElements() {
        return numberOfElements(root);
    }
    
    private int numberOfElements(Nodo actual) {
        if (actual != null) {
            return 1+numberOfElements(actual.left)+numberOfElements(actual.rigth);
        } 
        return 0;
    }
    
    public void showDecreasingOrder() {
        showDecreasingOrder(root);
    }
    
    private void showDecreasingOrder(Nodo actual) {
        if (actual != null) {
            showDecreasingOrder(actual.rigth);
            System.out.println(actual.data);
            showDecreasingOrder(actual.left);
        } 
    }
    
    public int numberOfLeafs() {
        return numberOfLeafs(root);
    }
    
    private int numberOfLeafs(Nodo actual) {
        if (actual.left == null && actual.rigth == null)
            return 1;
        else if (actual.left != null && actual.rigth == null)
            return numberOfLeafs(actual.left);
        else if (actual.left == null && actual.rigth != null)
            return numberOfLeafs(actual.rigth);
        else
            return numberOfLeafs(actual.left)+numberOfLeafs(actual.rigth);
    }
    
    public Comparable max() {
        Nodo actual = root;
        if (actual==null) return null;
        while(actual.rigth != null)
            actual = actual.rigth;
        return actual.data;
    }
    
    /*public int numberOfOccurrences(Comparable value) {
        return numberOfOccurrences(root, value);
    }
    
    private int numberOfOccurrences(Nodo actual, Comparable value) {
        if (actual != null) {
            int i = actual.data.equals(value)?1:0;
            return i+numberOfOccurrences(actual.left, value)+numberOfOccurrences(actual.rigth, value);
        } 
        return 0;
    }*/
    
    public int numberOfOccurrences(Comparable o) {
        return numberOfOccurrences(root, o);
    }
    
    private int numberOfOccurrences(Nodo actual, Comparable o) {
        if (actual == null)
            return 0;
        else if (actual.data.equals(o))
            return 1 + numberOfOccurrences(actual.rigth, o); 
        else if (o.compareTo(actual.data) < 0 )
            return numberOfOccurrences(actual.left, o);
        else
            return numberOfOccurrences(actual.rigth, o);
    }
    
    public int numberElementsInLevel(int level) {
        return numberElementsInLevel(root,level, 1);
    }
    
    private int numberElementsInLevel(Nodo actual, int level, int currentLevel) {
        if (actual != null) {
            if (level == currentLevel)
                return 1;
            else
                return numberElementsInLevel(actual.left, level, currentLevel+1)+
                       numberElementsInLevel(actual.rigth, level, currentLevel+1);
        } 
        return 0;
    }
    
    public int numberElementsGratherThan(Comparable o) {
        return numberElementsGratherThan(root, o);
    }
    
    private int numberElementsGratherThan(Nodo actual, Comparable o) {
        if (actual != null) {
            int i=actual.data.compareTo(o) >0?1:0;
            return i + numberElementsGratherThan(actual.left, o)+
                       numberElementsGratherThan(actual.rigth, o);
        } 
        return 0;
    }
    
    public static BinarySearchTree union(BinarySearchTree t1, BinarySearchTree t2){
        BinarySearchTree t = new BinarySearchTree();
        adiciona(t1.root, t);
        adiciona(t2.root, t);
        return t;
    }
    
    private static void adiciona(Nodo actual, BinarySearchTree t) {
        if (actual != null) {
            t.add(actual.data);
            adiciona(actual.left, t);
            adiciona(actual.rigth, t);
        } 
       
    }
            
}
