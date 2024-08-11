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
        if(i == null){
            return false;
        }else{
            return true;
        }
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
    
    class Item{   
        Object data;
        Item next;
    }
    
    
}
