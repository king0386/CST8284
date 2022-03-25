/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modified by: Stewart King
    Class name: TimeBlock.java
    Date: March 20, 2020
*/ 
package cst8284.asgmt3.room;

	/**
	 * Abstract Room class to set the defaults for more specific rooms.
	 * @author Stewart King, based on code supplied by Prof. Dave Houtman
	 * @version 1.0
	 *
	 */
public abstract class Room {
	/**
	 * serialVersionUID is a field that contains the version of the serializable class.
	 * DEFAULT_ROOM to hold the Default Room information.
	 * roomNumber is a String to hold the roomNumber of a specific room.
	 */
	public static final long serialVersionUID=1L;
	private static final String DEFAULT_ROOM = "unknown room number";
	private String roomNumber;
	
	/**
	 * No-arg constructor to instantiate a room object and pass the default to the one-arg constructor.
	 */
	protected Room() {this(DEFAULT_ROOM);}
	/**
	 * One-arg constructor that takes one String to set the Room Number. 
	 * @param roomNum room number of a specific room.
	 */
	protected Room(String roomNum) {setRoomNumber(roomNum);}
	
	/**
	 * Sets the room number of a room.
	 * @param roomNum Used to store the room number of a specific room.
	 */
	public void setRoomNumber(String roomNum) {roomNumber = roomNum;}
	/**
	 * Gets the room number of the specifed room.
	 * @return roomNumber of the room.
	 */
	public String getRoomNumber() {return roomNumber;}
	
	/**
	 * Abstract method for the subclass to use to return the amount of seats in a room.
	 * @return Type int of the number of seats in a room.
	 */
    protected abstract int getSeats();
    /**
     * Abstract method for the subclass to use to return the room type of a specified room.
     * @return Type String of the type of room.
     */
    protected abstract String getRoomType() ;
    /**
     * Abstract method for the subclass to use to return the details of a specified room.
     * @return Type String of the details of a room.
     */
	protected abstract String getDetails();
	
	/**
	 * Concatenates the room number, room type, seats, and details into one sentance.
	 */
	public String toString( ){return getRoomNumber() + " is a " +
		getRoomType() + " with " + getSeats() + " seats; " + getDetails();}
}
