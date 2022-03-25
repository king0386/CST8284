/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modified by: Stewart King
    Class name: TimeBlock.java
    Date: March 20, 2020
*/ 
package cst8284.asgmt3.room;


	/**
	 * ComputerLab class extending from superclass Room to hold more detailed information about a Room type.
	 * @author Stewart King, based on code supplied by Prof. Dave Houtman
	 * @version 1.0
	 *
	 */
public final class ComputerLab extends Room{

	/**
	 * Constant DEFAULT_SEATS to hold the default amount of seats the ComputerLab has.
	 * Type int seats to set the amount of seats in the room.
	 */
	private static final int DEFAULT_SEATS=30;
	private int seats;
	
	/**
	 * No-arg constructor to instantiate a ComputerLab with the default amount of seats.
	 */
	public ComputerLab() {seats = DEFAULT_SEATS;}

	/**
	 * Method used to return the amount of seats in a ComputerLab
	 * @return int of seats in the computer lab.
	 */
	protected int getSeats(){return seats;}
	/**
	 * Method to get the Room type of the specified room.
	 * @return the type of room that this is, a "computer lab".
	 */
	protected String getRoomType(){return "computer lab";}
	/**
	 * Method to get the Details of the specified room.
	 * @return returns more details of a room.
	 */
	protected String getDetails(){return "contains outlets for 30 laptops";}

}
