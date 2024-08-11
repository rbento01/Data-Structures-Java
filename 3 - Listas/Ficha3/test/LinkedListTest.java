/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ficha3.LinkedDupleList;
import ficha3.LinkedList;
import ficha3.LinkedSingleList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bento
 */
public class LinkedListTest {
    
    public LinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    public void testList(LinkedList s){
        assertEquals(true, s.isEmpty());
        s.addLast("ola");
        assertEquals(false, s.isEmpty());
        assertEquals("ola", s.peekFirst());
        assertEquals(true, s.remove("ola"));
        assertEquals(true, s.isEmpty());
        for (int i = 1; i <= 10; i++) {
            s.addLast(i);
            assertEquals(i, s.peekLast());
            assertEquals(false, s.isEmpty());
        }
        for (int i = 10; i >= 1; i--) {
            assertEquals(i, s.peekLast());
            assertEquals(true, s.remove(i));
            if(i == 1){
                assertEquals(true, s.isEmpty());
            }else{
                assertEquals(false, s.isEmpty());
            }
        }
    }
    
    @Test
    public void testLinkedList(){
        testList(new LinkedSingleList()); 
    }
    
    @Test
    public void testLinkedDupleList(){
        testList(new LinkedDupleList());
    }

    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
