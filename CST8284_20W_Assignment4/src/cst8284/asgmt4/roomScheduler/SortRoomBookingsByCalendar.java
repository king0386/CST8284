package cst8284.asgmt4.roomScheduler;

/*  Course Name: CST8284
Author: Stewart King
Class name: SortRoomBookingsByCalendar.java
Date: March 22, 2020
*/ 

import java.util.Comparator;
/**
 * SortRoomBookingsByCalendar class is used to sort the ArrayList of RoomBooking
 * using it's compare method to compare the start times of two RoomBooking objects
 * @author Stewart King
 * @version 1.0
 */

public class SortRoomBookingsByCalendar implements Comparator<RoomBooking> {

	/**
	 * No-arg constructor is used to instantiate a new SortRoomBookingsByCalendar object.
	 */
	public SortRoomBookingsByCalendar() {
		
	}
	
	/**
	 * compare method used to compare to RoomBookings based on their TimeBlock start time
	 * then returns a value indicating which comes first.
	 * @return int indicating which RoomBooking is first. Positive if rb1 is first, negative is rb2 is first, Zero if they're the same.
	 */
	@Override
	public int compare(RoomBooking rb1, RoomBooking rb2) {
		return(rb1.getTimeBlock().getStartTime().compareTo(rb2.getTimeBlock().getStartTime()));
	}

}
