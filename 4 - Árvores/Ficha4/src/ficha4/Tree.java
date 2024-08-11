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
public interface Tree {
    public boolean isEmpty();
    public void add(Comparable o);
    public boolean contains(Comparable o);
    public boolean remove(Comparable o);
    public Object findMin();
    public Object findMax();
}
