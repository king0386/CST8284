
package cst8284.lab7;

public class BadAccountInputException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public BadAccountInputException() {
		this("Bad input: Value entered is incorrect");
	}
	
	public BadAccountInputException(String message) {
		super(message);
	}

}
