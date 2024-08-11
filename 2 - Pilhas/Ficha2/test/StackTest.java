/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ficha2.IllimitedStack;
import ficha2.LimitedStack;
import ficha2.Stack;
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
public class StackTest {
    
    public StackTest() {
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
    
    public void testStack(Stack s){
        assertEquals(true, s.isEmpty());
        s.push("ola");
        assertEquals(false, s.isEmpty());
        assertEquals("ola", s.peek());
        assertEquals("ola", s.pop());
        assertEquals(true, s.isEmpty());
        for (int i = 1; i <= 10; i++) {
            s.push(i);
            assertEquals(i, s.peek());
            assertEquals(false, s.isEmpty());
        }
        for (int i = 10; i >= 1; i--) {
            assertEquals(i, s.peek());
            assertEquals(i, s.pop());
            if(i == 1){
                assertEquals(true, s.isEmpty());
            }else{
                assertEquals(false, s.isEmpty());
            }
        }
    }
    
    @Test
    public void testLimitedStack(){
        testStack(new LimitedStack(100));
    }
    
    @Test
    public void testIllimitedStack(){
        testStack(new IllimitedStack());
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
