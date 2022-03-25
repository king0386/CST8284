/* Course Name: CST8284
 * Author: Stewart King
 * Class name: BadRoomBookingException
 * Date: March 20, 2020
 */

package cst8284.asgmt4.roomScheduler;

/**
 * BadRoomBookingException extends from RuntimeException, and is thrown when bad input is entered.
 * @author Stewart King
 * @version 1.0
 */

public class BadRoomBookingException extends RuntimeException {
	
	/**
	 * serialVersionUID is a field that contains the version of the serializable class.
	 * header is a String that will store the default Header for the BadRoomBookingException.
	 */
	private static final long serialVersionUID = 1L;
	private String header;
	
	/**
	 * No-arg constructor to pass the default header and message to the two-arg constructor
	 */
	public BadRoomBookingException() {
		this("Bad room booking entered", "Please try again");
	}
	/**
	 * Two-arg constructor passes the String "header" to the setHeader method
	 * Passes the String "message" to the superclass, RuntimeException, constructor.
	 * @param header Basic error header
	 * @param message The output message that gets passed to the RuntimeException superclass
	 */
	public BadRoomBookingException(String header, String message) {
		super(message);
		setHeader(header);
	}

	/**
	 * Method to return the value of the private String "header"
	 * @return The header of this BadRoomBookingException
	 */
	public String getHeader() {
		return header;
	}
	
	/**
	 * Method to set the header for this BadRoomBookingException
	 * @param header String to contain the header stored in the header field
	 */
	public void setHeader(String header) {
	this.header = header;
	
	}
}
