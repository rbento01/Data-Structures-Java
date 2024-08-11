/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigInteger;

/**
 *
 * @author António
 */
public class MatemáticaTest {
    
    public MatemáticaTest() {
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
    
    @Test
    public void testSoma() {
        assertEquals(4, Matemática.soma(2, 2));
        assertEquals(2, Matemática.soma(0, 2));
        assertEquals(-2, Matemática.soma(0, -2));
        assertEquals(-4, Matemática.soma(-2, -2));
    }
    @Test
    public void testSubtracao() {
       assertEquals(0, Matemática.subtracao(2, 2));
       assertEquals(-2, Matemática.subtracao(0, 2));
       assertEquals(4, Matemática.subtracao(2, -2));
       assertEquals(2, Matemática.subtracao(0, -2));
       assertEquals(18, Matemática.subtracao(20, 2));
    }
    
    @Test
    public void testMultiplicacao() {
       assertEquals(4, Matemática.multiplicacao(2, 2));
       assertEquals(0, Matemática.multiplicacao(0, 2));
       assertEquals(-4, Matemática.multiplicacao(2, -2));
       assertEquals(0, Matemática.multiplicacao(0, -2));
       assertEquals(40, Matemática.multiplicacao(20, 2));
    }
    
    @Test
    public void testDivisao() {
       assertEquals(1, Matemática.divisao(2, 2));
       assertEquals(-1, Matemática.divisao(2, -2));
       assertEquals(10, Matemática.divisao(20, 2));
    }
    
    @Test
    public void testFactorialI(){
        assertEquals(BigInteger.valueOf(1), Matemática.factorialI(0));
        assertEquals(BigInteger.valueOf(1), Matemática.factorialI(1));
        assertEquals(BigInteger.valueOf(2), Matemática.factorialI(2));
        assertEquals(BigInteger.valueOf(6), Matemática.factorialI(3));
        assertEquals(BigInteger.valueOf(24), Matemática.factorialI(4));
    }
    
    @Test
    public void testFactorialR(){
        assertEquals(BigInteger.valueOf(1), Matemática.factorialR(0));
        assertEquals(BigInteger.valueOf(1), Matemática.factorialR(1));
        assertEquals(BigInteger.valueOf(2), Matemática.factorialR(2));
        assertEquals(BigInteger.valueOf(6), Matemática.factorialR(3));
        assertEquals(BigInteger.valueOf(24), Matemática.factorialR(4));
    }
}
