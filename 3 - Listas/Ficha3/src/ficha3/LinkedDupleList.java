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
public class LinkedDupleList implements LinkedList{
    
    Item head;
    Item tail;
    
    @Override
    public boolean isEmpty() {
        if(head == null){
            return true;
        }
        return false;
    }

    @Override
    public void addFirst(Object data) {
        Item item = new Item();
        item.data = data;
        item.next = null;
        item.previous = null;
        if(head == null){
            head = item;
            tail = item;
        }else{
            item.next = head;
            head.previous = item;
            head = item;
        }
    }

    @Override
    public void addLast(Object data) {
        Item item = new Item();
        item.data = data;
        item.next= null;
        item.previous= null;
        if(head == null){
            head = item;
            tail = item;
        }else{
            item.previous = tail;
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
        if(head == null){
            return false;
        }else{
            if(data == head.data){
                if(head == tail){
                    head = null;
                    tail = null;
                }else{
                    head = head.next;
                    head.previous = null;
                }
                return true;
            }
        }
        Item i = head.next;
        while(i != null && data != i.data){
            i = i.next;
        }
        if(i == tail){
            tail = tail.previous;
            tail.next = null;
            return true;
        }else{
            if(i != null){
                i.previous.next = i.next;
                i.next.previous = i.previous;
                return true;
            }
        }
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
    
    public String reverseMostra(){
        Item i = tail;
        String s = "";
        while(i != null){
            if(i.previous == null){
                s = s + i.data + ".";
                return s;
            }
            s = s + i.data + ", ";
            i = i.previous;
        }
        return s;
    }
    
    class Item{   
        Object data;
        Item next;
        Item previous;
    }
    
}
