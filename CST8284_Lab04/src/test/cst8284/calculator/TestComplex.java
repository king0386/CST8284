package test.cst8284.calculator;

//import cst8284.calculator.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestComplex {

	// 1. Use assertNotNull() to test the Complex(double, double) constructor (1 mark)
	
	@Test
	public void testComplexDoubleDouble() {
		assertNotNull(new Complex());
	}
	
	// 2. Use assertEquals(double, double, double) to test if getReal() returns the
	// correct value set using the Complex(String, String) constructor (1 mark)
	@Test
	public void testGetRealReturnUsingComplexStringString() {
		Complex c = new Complex("4", "-12i");
		assertEquals(4.0, c.getReal(), 1e-12);
	}
	
	// 3. Use assertEquals(double, double, double) to test if setImag() correctly resets
	// the value set using the Complex(int, int) constructor (1 mark)
	@Test
	public void testSetImagResetsUsingComplexIntInt() {
		Complex c = new Complex(4, -4);
		c.setImag(3.0);
		assertEquals(3.0, c.getImag(), 1e-12);
	}
	
	// 4. Use the no-arg Complex() constructor, and then use the real and
	// imaginary setters to set new integer values. Then use assertTrue(boolean)
	// to test the validity of your newly-added equals(complex) method (1 mark)
	@Test
	public void testNoArgComplexUsingRealImagSettersValidNewEqualsComplex() {
		Complex c = new Complex();
		Complex c1 = new Complex(2,3);
		c.setReal(2);
		c.setImag(3);
		assertTrue(c1.equals(c));
		
		//new complex 2,3 
	}
	
}
