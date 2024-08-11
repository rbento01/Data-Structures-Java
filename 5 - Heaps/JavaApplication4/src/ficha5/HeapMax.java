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
public class HeapMax extends Heap{

    public HeapMax(int MaxSize) {
        super(MaxSize);
    }

    @Override
    public void add(Comparable o) {
        array[count] = o;
        count = count + 1;
        reorganiza();
    }
    
    public void reorganiza(){
        int i;
        i = count - 1;
        while(i>0 && array[i].compareTo(array[(i-1)/2]) > 0){
            troca(i, (i-1)/2);
            i = (i-1)/2;
        }
    }
    
    @Override
    public boolean contains(Comparable o) {
        int inicio = 0;
        int nodos = 1;
        while(inicio < count){
            inicio = nodos - 1;
            int fim = nodos + inicio;
            int numNodos=0;
            while(inicio < count && inicio < fim){
                if(o.equals(array[inicio])){
                    return true;
                }else if(o.compareTo(array[parent(inicio)]) < 0 && o.compareTo(array[inicio]) > 0){
                    numNodos = numNodos + 1;
                }
                inicio = inicio +1;
            }
            if(numNodos == nodos){
                return false;
            }
            nodos = nodos*2;
        }
        return false;
    }
    
    public int findIndex(Comparable o) {
        int inicio = 0;
        int nodos = 1;
        while(inicio < count){
            inicio = nodos - 1;
            int fim = nodos + inicio;
            int numNodos=0;
            while(inicio < count && inicio < fim){
                if(o.equals(array[inicio])){
                    return inicio;
                }else if(o.compareTo(array[parent(inicio)]) < 0 && o.compareTo(array[inicio]) > 0){
                    numNodos = numNodos + 1;
                }
                inicio = inicio + 1;
            }
            if(numNodos == nodos){
                return -1;
            }
            nodos = nodos*2;
        }
        return -1;
    }

    @Override
    public boolean remove(Comparable o) {
        int index;
        index = findIndex(o);
        if(index < 0){
            return false;
        }else{
            count = count - 1;
            array[index] = array[count];
            if(array[index].compareTo(array[parent(index)]) > 0){
                while(index > 0 && array[index].compareTo(array[(index)]) > 0){
                    troca(index, (index-1)/2);
                    index = (index-1)/2;
                }
            }else{
                while(left(index)< count && (array[index].compareTo(array[left(index)]) < 1) || (array[index].compareTo(array[right(index)])) < 0){
                    if(array[left(index)].compareTo(array[right(index)]) > 0){
                        troca(left(index), index);
                        index = left(index);
                    }else{
                        troca(right(index), index);
                        index = right(index);
                    }
                }
            }
        }
        return true;
    }   
}
