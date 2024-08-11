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
public interface LinkedList {
    public boolean isEmpty();
    public void addFirst(Object o);
    public void addLast(Object o);
    public boolean contains(Object o);
    public boolean remove(Object o);
    public Object peekFirst();
    public Object peekLast();

    public int count(int x);
}
