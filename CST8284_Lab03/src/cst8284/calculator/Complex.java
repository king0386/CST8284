package cst8284.calculator;


public class Complex {
	private double real = 0;
	private double imag = 0;

	// Complex constructor that takes in a single string, e.g. "2-4i"
	public Complex(String cStr) {
		this(cStr.split("(?=\\+)|(?=\\-)")); // splits cStr at + or - into an
		// array of strings having two elements. The first element of the
		// resultant array will be the real portion, while the second is the
		// imaginary portion. This array is passed to the next constructor.
	}

	// Complex constructor that takes in an array of two strings from the above
	// constructor e.g. cStr[0]="2", cStr[1]="-4i"
	public Complex(String[] cStr) {
		this(cStr[0], cStr[1]);
	}

	// Complex constructor that takes two separate strings as parameters, e.g. "2"
	// and "-4i"
	public Complex(String r, String i) {
		this(Integer.parseInt(r), Integer.parseInt(i.replace("i", "").trim()));

		// parseInt learned from
		// https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java

	}

	// Complex constructor that takes in two ints as parameters, e.g. 2 and -4
	public Complex(int r, int i) {
		this((double) r, (double) i);
	}

	// Complex constructor that takes in two ints and stores them as floats, e.g. as
	// 2.0 and -4.0
	public Complex(double r, double i) {
		setReal(r);
		setImag(i);
	}

	// default Complex constructor; it will chain automatically to the (int, int)
	// constructor
	public Complex() {
		this(0, 0);
	}

	public double getReal() {
		return real;
	}

	public double getImag() {
		return imag;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}

	public Complex getComplex() {
		return this;

	}

	public String toString() {
//		String operation;
//		if (imag >= 0) {
//			operation = " + ";
//
//		} else {
//			operation = " - ";
//			imag = -imag;
//		}
//		return real + operation + imag + "i";

		return (getReal() + (this.getImag() >= 0 ? " + " : " - ") + Math.abs(getImag()) + "i");
	}

	public boolean isZero() {
		return (this.getReal() == 0.0 && this.getImag() == 0.0);
	}
}




















