/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha3;

/**
 *
 * @author bento
 */
public class LinkedSingleList implements LinkedList{
    
        Item head;
        Item tail;
    
    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void addFirst(Object data) {
        Item item = new Item();
        item.data = data;
        item.next = null;
        if(head == null){
            head = item;
            tail = item;
        }else{
            item.next = head;
            head = item;
        }
    }

    @Override
    public void addLast(Object data) {
        Item item = new Item();
        item.data = data;
        item.next = null;
        if(head == null){
            head = item;
            tail = item;
        }else{
            tail.next = item;
            tail = item;
        }
        
    }

    @Override
    public boolean contains(Object data) {
        Item i = head;
        while(i != null && i.data != data){
            i = i.next;
        }
            return i != null;
    }

    @Override
    public boolean remove(Object data) {
        Item i = head;
        if(head == null){
            return false; // A lista está vazia
        }else{
            if(i.data == data){
                //O item a remover é o único da lista
                if(head == tail){
                    head = null;
                    tail = null;
                //O item a remover é a cabeça
                }else{
                    head = head.next;
                }
            return true;
            }
        }
        while (i.next != null && i.next.data != data){
            i = i.next;
        }
        if(i.next != null){
            //O item a remover é a cauda
            if(i.next.equals(tail)){
                tail = i;
            }
            //O item a remover está no meio da lista
            i.next = i.next.next;
            return true;
        }
        //O item não se encontra na lista
        return false;
    }

    @Override
    public Object peekFirst() {
        if(isEmpty()){
            return null;
        }
        return head.data;
    }

    @Override
    public Object peekLast() {
        if(isEmpty()){
            return null;
        }
        return tail.data;
    }

    @Override
    public int count(int data){
        Item i = head;
        int contador=0;
        while (i != null){
            if(i.data.equals(data)){
                contador++;
            }
            i = i.next;
        }
        return contador;
    }

    @Override
    public String mostra() {
        Item i = head;
        String s = "";
        while(i != null){
            if( i .next == null){
                s = s + i.data + ".";
                return s;
            }
            s =  s + i.data + ", ";
            i = i.next;
        }
        return s;
    }
    
    class Item{   
        Object data;
        Item next;
    }

    void inserirDepois(Object o1, Object o2){
        Item aux = head;
        Item item = new Item();
        item.data = o2;
        item.next = null;
        while(aux != null){
            if(aux.data.equals(o1)){
                item.next = aux.next;
                aux.next = item;
            }else if(aux.data.equals(tail)){
                tail.next = item;
            }
            aux = aux.next;
        }
    }
    
    boolean contains1(Object o1){
        Item item = head;
        while(item != null){
            if(item.data.equals(o1)){
                return true;
            }
            item = item.next;
        }
        return false;
    }
    
    void substitui(Object o1, Object o2) {
        Item aux = head;
        while(aux != null){
            if(aux.data.equals(o1)){
                aux.data = o2;
            }
            aux = aux.next;
        }      
    }
    
    LinkedSingleList inverter(){
        LinkedSingleList l = new LinkedSingleList();
        Item item = head;
        while(item != null){
            l.addFirst(item.data);
            item = item.next;
        }
        return l;
    }
    
    void removeTodos(LinkedSingleList l1) {
        Item item = l1.head;
        while(item != null){
            remove(item.data);
            item = item.next;
        }
    }
}
