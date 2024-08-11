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
public interface Tree {
    public boolean isEmpty();
    public void add(Comparable o);
    public boolean contains(Comparable o);
    public boolean remove(Comparable o);
    public Comparable findMin();
    public Comparable findMax();
}
