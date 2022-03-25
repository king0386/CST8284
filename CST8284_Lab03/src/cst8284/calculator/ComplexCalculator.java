package cst8284.calculator;


public class ComplexCalculator {
	
	private java.util.Scanner op = new java.util.Scanner(System.in);
	private Complex c;  // stores result of current calculation 
	
	public ComplexCalculator(Complex c1, Complex c2){
		
		System.out.println("Which math operation do you wish to perform?  Enter +, -, *, /");
		
		switch (op.nextLine().charAt(0)){
		   case '+':
		      setComplexResult(add(c1, c2));  
		      break;
		   case '-':
			   setComplexResult(subtract(c1, c2));
			   break;
		   case '*':
			   setComplexResult(multiply(c1, c2));
			   break;
		   case '/':
			   setComplexResult(divide(c1, c2));
			   break;
		      
		   default:
			  System.out.println("Unknown operation requested");
		}		
	}
	
	public ComplexCalculator() {}  // Needed for Lab 4; do not change
	
	public Complex add(Complex c1, Complex c2){
		double real = c1.getReal() + c2.getReal();  // Addition statement
		double imag = c1.getImag() + c2.getImag();
		return(new Complex(real, imag));
	}


	
	public Complex subtract(Complex c1, Complex c2){
		double real = c1.getReal() - c2.getReal();	// Subtraction
		double imag = c1.getImag() - c2.getImag();
		return new Complex(real, imag);
	}
	
	public Complex multiply(Complex c1, Complex c2){
		double a = c1.getReal();
		double b = c1.getImag();
		double x = c2.getReal();
		double y = c2.getImag();
		
		double real = (a * x - b * y);
		double imag = (a * y + x * b);
		
		return new Complex(real, imag);
		
	}
	
	public Complex divide(Complex c1, Complex c2){		
	   //TODO: check for possible division by 0 and output an error message to the screen
	   //return a constructor with value 0 + 0i);
		double a = c1.getReal();
		double b = c1.getImag();
		double x = c2.getReal();
		double y = c2.getImag();
		
		if(c2.isZero()){
			System.out.println("Error: Can not divide by 0");
			return new Complex(0,0);
		}
		
//		if(c1.getImag() == 0 || c2.getImag() == 0) {
//			System.err.println("Error: Can not divide by 0");
//			return new Complex(0,0);
//		}
		else {
			
		double real = (a * x + b * y) / (x * x + y * y);
		double imag = (x * b - a * y) / (x * x + y * y);
		return new Complex(real, imag);
		}
		
	}   
	
    // If attempting Bonus C, comment out the above divide() method, which must use
	// the calculation given in the Lab 03 document--this must be included for marks--and
	// add a new divide() method here that employs the complex conjugate in the Complex
	// class, as described in the BONUS MARKS section of the Lab 3 document.
	
	public void setComplexResult(Complex c) {
		// TODO: save the value of c passed as a parameter to this.c, declared at the start
		// of this class
		this.c = c;
	}

	public Complex getComplexResult(){
	    //TODO: return the result of the calculation stored in the Complex c variable declared
		// at the start of this class. 
		return c;
	}

	public String toString(){
		// TODO: return the String value of the Complex Result of the calculation, 
		// using c's toString() method, i.e. chain using the existing toString() method
		return c.toString();
	}
	
}
