/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvores;

/**
 *
 * @author paulo
 */
public class AVLTree extends BinarySearchTree {

    @Override
    public void add(Comparable o) {
        NodoAVL nodo = new NodoAVL();
        nodo.data = o;
        nodo.heigth = 1;
        nodo.left = null;
        nodo.rigth = null;
        if (root == null)
            root = nodo;
        else
            root = add((NodoAVL)root, nodo);
    }
    
    private NodoAVL add(NodoAVL actual, NodoAVL novo) {
        if (novo.data.compareTo(actual.data) < 0 )
            if (actual.left == null)
                actual.left = novo;
            else
                actual.left = add(actual.getLeft(), novo);
        else
            if (actual.rigth == null)
                actual.rigth = novo;
            else
                actual.rigth = add(actual.getRigth(), novo);
        return balance(actual);
    }

    @Override
    public boolean remove(Comparable o) {
        java.util.Stack<NodoAVL> pilha = new java.util.Stack();
        NodoAVL nodoARemover = (NodoAVL)root;
        NodoAVL parent = null;
        pilha.push((NodoAVL)root);
        while (nodoARemover != null && !nodoARemover.data.equals(o)) {
            parent = nodoARemover;
            if (o.compareTo(nodoARemover.data) < 0 )
                nodoARemover = nodoARemover.getLeft();
            else
                nodoARemover = nodoARemover.getRigth();
            pilha.push(nodoARemover);
        }
        if (nodoARemover == null)
            return false;
        else {
            if (root.left == null && root.rigth == null)
                root = null;
            else if (root.left == null && root.rigth != null && o.equals(root.data))
                root = root.rigth;
            else if (root.left != null && root.rigth == null && o.equals(root.data))
                root = root.left;
            else if (nodoARemover.left == null && nodoARemover.rigth == null)  {// caso 1
                if (nodoARemover.data.compareTo(parent.data) < 0 )
                    parent.left = null;
                else
                    parent.rigth = null;
                pilha.pop();
            }else if (nodoARemover.left == null && nodoARemover.rigth != null) { // caso 2.1
                if (nodoARemover.data.compareTo(parent.data) < 0 )
                    parent.left = nodoARemover.rigth;
                else
                    parent.rigth = nodoARemover.rigth;
                pilha.pop();
                pilha.push(nodoARemover.getRigth());
            } else if (nodoARemover.left != null && nodoARemover.rigth == null) {// caso 2.2
                if (nodoARemover.data.compareTo(parent.data) < 0 )
                    parent.left = nodoARemover.left;
                else
                    parent.rigth = nodoARemover.left;
                pilha.pop();
                pilha.push(nodoARemover.getLeft());
            } else { // caso 3
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
            while (!pilha.isEmpty()) {
                NodoAVL nodo = pilha.pop();
                NodoAVL pai = pilha.peek();
                if (pai == null)
                    root = balance(nodo);
                else if (nodo.data.compareTo(pai.data) < 0 )
                    pai.left = balance(nodo);
                else
                    pai.rigth = balance(nodo);
            }
            return true;
        }
    }
    
    
    
    private NodoAVL balance(NodoAVL nodo) {
        nodo.heigth = Math.max(heigth(nodo.getLeft()), heigth(nodo.getRigth()) ) + 1;
        if (factor(nodo) > 1)
            if (factor(nodo.getLeft()) >= 0)
                nodo = rigthRotation(nodo);
            else
                nodo = doubleRigthRotation(nodo);
        else if (factor(nodo) < -1)
            if (factor(nodo.getRigth()) <= 0)
                nodo = leftRotation(nodo);
            else
                nodo = doubleLeftRotation(nodo);
        return nodo;
    } 
    
    private int factor(NodoAVL nodo) {
        return heigth(nodo.getLeft()) - heigth(nodo.getRigth());
    }
    
    private int heigth(NodoAVL nodo) {
        return nodo==null?0:nodo.heigth;
    }
    
    private NodoAVL rigthRotation(NodoAVL k2) {
        NodoAVL k1 = k2.getLeft();
        k2.left = k1.rigth;
        k1.rigth = k2;
        k2.heigth = Math.max(heigth(k2.getLeft()), heigth(k2.getRigth()) ) + 1;
        k1.heigth = Math.max(heigth(k1.getLeft()), heigth(k2) ) + 1;
        return k1;
    }
    
    private NodoAVL leftRotation(NodoAVL k1) {
        NodoAVL k2 = k1.getRigth();
        k1.rigth = k2.left;
        k2.left = k1;
        k1.heigth = Math.max(heigth(k1.getLeft()), heigth(k1.getRigth()) ) + 1;
        k2.heigth = Math.max(heigth(k2.getRigth()), heigth(k1) ) + 1;
        return k2;
    }
    
    private NodoAVL doubleRigthRotation(NodoAVL k3) {
        k3.left = leftRotation(k3.getLeft());
        return rigthRotation(k3);
    }
    
    private NodoAVL doubleLeftRotation(NodoAVL k1) {
        k1.rigth = rigthRotation(k1.getRigth());
        return leftRotation(k1);
    }   
    
    private class NodoAVL extends Nodo {
        int heigth;
        
        NodoAVL getLeft() {
            return (NodoAVL)super.left;
        }
        
        NodoAVL getRigth() {
            return (NodoAVL)super.rigth;
        }
        
    }
    
}
