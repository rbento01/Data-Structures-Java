/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha4;

import java.util.ArrayList;

/**
 *
 * @author bento
 */
public class BinarySearchTree implements Tree{

    Nodo root;
    
    @Override
    public boolean isEmpty() {
        return root==null;
        
    }

    @Override
    public void add(Comparable o) {
        Nodo nodo = new Nodo();
        nodo.data = o;
        nodo.left = null;
        nodo.right = null;
        if(root == null){//caso estejamos a começar a árvore
            root = nodo;//o valor da raiz passa o valor inserido em parâmetro
        }else{
            add(root, nodo);
        }
    }
    
    public void add(Nodo actual, Nodo novo){
        if(novo.data.compareTo(actual.data)<0){
            if(actual.left == null){//caso o ramo da esquerda seja menor
               actual.left = novo; //insere o nº nesse ramo
            }else{
                add(actual.left,novo);//se é menor tem que se ver sempre para a esquerda até ser disponivel ou ser maior e ser colocado na parte direita
            }
        }else if(actual.right == null){//se é maior e tem lugar disponivel na direita fica ai
                actual.right = novo; //insere no ramo da direita
        }else{
            add(actual.right,novo);// se é maior tem que se ver sempre para a direita até ser disponivel ou ser menor e ser colocado na parte esquerda
        }
    }

    @Override
    public boolean contains(Comparable o) {
        return contains(root, o);
    }
    
    boolean contains(Nodo actual, Comparable o){

        if(actual == null){//caso a árvore esteja vazia
            return false;
        }else if(actual.data.equals(o)){//serve primeiro para ver se o valor em parâmetro é a raiz e depois vai ser usado ao percorrer ao longo da árvore
            return true;
        }else if(o.compareTo(actual.data)<0){//vai percorrendo o lado direito
            return contains(actual.left, o);
        }else{
            return contains(actual.right, o);
        }
    }
    
    @Override
    public boolean remove(Comparable o) {
        return remove(root,o);
    }
    
    public Nodo findParent(Comparable o) {
        return findParent(root, o);
    }

    public Nodo findParent(Nodo a, Comparable o) {
        if (o.equals(a.data)) {
            return null;
        } else {
            if (o.compareTo(a.data) < 0) {
                if (a.left == null) {
                    return null;
                } else if (a.left.data.equals(o)) {
                    return a;
                } else {
                    return findParent(a.left, o);
                }

            } else if (a.right.data == null) {
                return null;
            } else if (a.right.data.equals(o)) {
                return a;
            } else {
                return findParent(a.right, o);
            }
        }
    }

    public Nodo find(Comparable o) {
        return find(root, o);
    }

    public Nodo find(Nodo a, Comparable o) {
        if (a == null) {
            return null;
        } else {
            if (a.data.equals(o)) {
                return a;
            } else {
                if (o.compareTo(a.data) < 0) {
                    return find(a.left, o);
                } else {
                    return find(a.right, o);
                }
            }
        }
    }
    
    public boolean remove(Nodo a, Comparable o) {
        Nodo nodoAremover = find(o);
        if (nodoAremover == null) {
            return false;
        } else {
            Nodo parent = findParent(o);
            if (root == nodoAremover) {
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.left == null && root.right != null) {
                    root = root.right;
                } else if (root.left != null && root.right == null) {
                    root = root.left;
                }
            } else if (nodoAremover.left == null && nodoAremover.right == null) {
                if (nodoAremover.data.compareTo(parent.data) < 0) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (nodoAremover.left == null && nodoAremover.right != null) {
                if (nodoAremover.data.compareTo(parent.data) < 0) {
                    parent.left = nodoAremover.right;
                } else {
                    parent.right = nodoAremover.right;
                }
            } else if (nodoAremover.left != null && nodoAremover.right == null) {
                if (nodoAremover.data.compareTo(parent.data) < 0) {
                    parent.left = nodoAremover.left;
                } else {
                    parent.right = nodoAremover.left;
                }
            } else {
                Nodo nodoMaior = nodoAremover.left;
                while (nodoMaior.right != null) {
                    nodoMaior = nodoMaior.right;
                }
                Nodo parentNodoMaior = findParent(nodoMaior.data);
                if (parentNodoMaior.equals(nodoAremover)) {
                    parentNodoMaior.left = nodoMaior.left;
                } else {
                    parentNodoMaior.right = nodoMaior.left;
                }
                nodoAremover.data = nodoMaior.data;
            }
            return true;
        }
    }
            
    @Override
    public Comparable findMin() {
        if(root == null){
            return null;
        }else{
            return findMin(root);
        }
    }
    public Comparable findMin(Nodo actual){
        if(actual.left == null){
            return actual.data;
        }else{
            return findMin(actual.left);
        }
    }

    @Override
    public Comparable findMax() {
        if(root == null){
            return null;
        }else{
            return findMax(root);
        }
    }
    
    public Comparable findMax(Nodo actual){
        if(actual.right == null){
            return actual.data;
        }else{
            return findMax(actual.right);
        }
    }
    
    public void mostrar() {
        mostrar(root, 0, 0);
    }
    
    public void mostrar(Nodo actual, int nivel, int aux) {
        if (actual!=null) {
            mostrar(actual.right, nivel+1, 1);
            for(int i=0; i < nivel; i++){
                System.out.print(" ");
            }
            if (aux > 0){
                System.out.print("/");
            }
            if (aux < 0){
                System.out.print("\\");
            }
        System.out.println(actual.data);
        mostrar(actual.left, nivel+1, -1);
        }
    }
    
    public void removeAll(ArrayList<Comparable> values){
        //O Comparable aux vai ter o valor de todos valores de values
        for(Comparable aux : values){
            //Se contem o valor na arvore, apaga
            if(contains(aux)){
                //apaga um elemento de cada vez
                remove(aux);
            }
        }
    }
    
    public boolean allSmallerThan(Comparable value){
        if(findMax()<value){
            return true;
        }else{
            return false
        }
    }

    class Nodo{
        Comparable data;
        Nodo left;
        Nodo right;
    }
}


