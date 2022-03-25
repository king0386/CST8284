/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modified by: Stewart King
    Class name: TimeBlock.java
    Date: March 20, 2020
*/ 
package cst8284.asgmt4.room;

/**
 * Classroom class extending from the superclass Room. 
 * @author Stewart King, based on code supplied by Prof. Dave Houtman
 * @version 1.0
 *
 */
public final class Classroom extends Room{

	/**
	 * Constant DEFAULT_SEATS to hold the default amount of seats in the room.
	 * Type int seats to set the amount of seats in the room.
	 */
	private static final int DEFAULT_SEATS=120;
	private int seats;
	
	/**
	 * No-arg constructor to instantiate a Classroom with the default amount of seats.
	 */
	public Classroom(){seats = DEFAULT_SEATS;}
	
	/**
	 * Method to get the number of seats in a specific room.
	 * @return int of the amount of seats in the Classroom.
	 */
	protected int getSeats(){return seats;}
	
	/**
	 * Method to get the type of the specific room.
	 * @return a String of the room type.
	 */
	protected String getRoomType(){return "classroom";}
	/**
	 * Method to get the rooms specific details.
	 * @return String with more specific details of the room.
	 */
	protected String getDetails(){return "contains overhead projector";}
}
