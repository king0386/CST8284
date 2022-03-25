package test.cst8284.calculator;

//import cst8284.calculator.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestComplexCalculator {
	
//	@Test
//	public void testToString() {
//		Complex c = new Complex(3,2);
//		assertTrue(c.toString().equals("3.0 + 2.0i"));
//	}

	// 5. Using assertTrue(boolean), test that two Complex numbers created using the
	// Complex(int, int) constructor and the Complex(String, String) constructor
	// give the correct result using the subtract() method. Use equals(Complex) to
	// compare the actual and expected result (1 mark)
	
	@Test
	public void testComplexIntIntComplexStringStringUsingSubtract() {
		Complex c1 = new Complex(3, 16);
		Complex c2 = new Complex(7, 12);
		Complex c3 = new Complex("4", "-4");
		ComplexCalculator cc = new ComplexCalculator();
		
		assertTrue(c1.equals(cc.subtract(c2, c3)));
		
	}
	
	// 6.Test that the result of '0 - 0i' divided by '0 + 0i' is '0.0 + 0.0i',
	// as required in the Lab 3 specifications (3 marks)

	@Test
	public void testDivideByZeroResult() {
		//Complex c1 = new Complex("0.0 + 0.0i");
		Complex c2 = new Complex(0, 0);
		Complex c3 = new Complex(0, 0);
		ComplexCalculator cc = new ComplexCalculator();
		
		//assertTrue(cc.toString().equals("0.0 + 0.0i"));
		//assertTrue(cc.divide(c2, c3).equals("0.0 + 0.0i"));
		//assertTrue(ComplexCalculator.divide(new Complex(0, 0), new Complex(0, 0)).toString().equals("0.0 + 0.0i"));
		assertTrue(ComplexCalculator.divide(c2, c3).equals("0.0 + 0.0i"));
		//assertTrue(cc.divide(c2, c3).toString().equals("0.0 + 0.0i")); gave me a stupid yellow line
		//complex needs to =  complex not tostring
	}
	
}
