/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha5;

/**
 *
 * @author bento
 */
public abstract class Heap {
    Comparable array[];
    int count = 0;
        
    public Heap(int MaxSize){ array = new Comparable[MaxSize];}
    
    public boolean isEmpty(){return count == 0;}
    public abstract void add(Comparable o); // método abstracto
    public abstract boolean contains(Comparable o); // método abstracto
    public abstract boolean remove(Comparable o); // método abstracto
    public Comparable peek(){return isEmpty()?null:array[0];}
    protected void troca(int i, int j){
        Comparable aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    
    public int left(int index){return 2*index+1;}
    public int right(int index){return 2*index+2;}
    public int parent(int index) {return (index-1)/2;}

}
