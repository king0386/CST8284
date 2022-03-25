/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modified by: Stewart King
    Class name: TimeBlock.java
    Date: March 20, 2020
*/ 
package cst8284.asgmt4.room;

/**
 * Boardroom class that extends from the superclass Room.
 * @author Stewart King, based on code supplied by Prof. Dave Houtman
 * @version 1.0
 *
 */
public final class Boardroom extends Room{

	/**
	 * Int of seats that the Boardroom has.
	 */
	private int seats;
	
	/**
	 * No-arg constructor to instantiate a Boardroom with 16 seats.
	 */
	public Boardroom() {seats = 16;}
	
	/**
	 * Method to get the number of seats in a specific room.
	 * @return int of the amount of seats in the Boardroom.
	 */
	protected int getSeats() {return seats;}
	/**
	 * Method to get the type of the specific room.
	 * @return a String of the room type.
	 */
	protected String getRoomType(){return "board room";}
	/**
	 * Method to get the rooms specific details.
	 * @return String with more specific details of the room.
	 */
	protected String getDetails(){return "conference call enabled";}
}
