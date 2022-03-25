package cst8284.asgmt3.roomScheduler;
/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modified by: Stewart King
    Class name: TimeBlock.java
    Date: March 20, 2020
*/ 

import java.util.Calendar;

/**
 * TimeBlock holds an object with the start and end time of a calendar object for a RoomBooking.
 * @author Stewart King, based on code supplied by Prof. Dave Houtman
 * @version 1.0
 */
public class TimeBlock implements java.io.Serializable {
	/**
	 * serialVersionUID is a field that contains the version of the serializable class.
	 * startTime holds the starting point of the Room Booking.
	 * endTime holds the ending point of the Room Booking.
	 */
	private static final long serialVersionUID = 1L;
	private Calendar startTime, endTime;
	
	public TimeBlock() {
		this(new Calendar.Builder().set(Calendar.HOUR_OF_DAY, 8).build(),
				new Calendar.Builder().set(Calendar.HOUR_OF_DAY, 24).build());
	}
	
	public TimeBlock(Calendar start, Calendar end) {
		setStartTime(start); setEndTime(end);
	}
	
	@Override
	public String toString() {
		return getStartTime().get(Calendar.HOUR_OF_DAY) + ":00 - " + getEndTime().get(Calendar.HOUR_OF_DAY) + ":00\n";
	}

	public void setStartTime(Calendar startTime) {this.startTime = startTime;}
	public Calendar getStartTime() {return startTime;}

	public void setEndTime(Calendar endTime) {this.endTime = endTime;}
	public Calendar getEndTime() {return endTime;}
	
	public int duration() {
		return (getEndTime().get(Calendar.HOUR_OF_DAY) - getStartTime().get(Calendar.HOUR_OF_DAY));
	}
	
	public boolean overlaps(TimeBlock tb) {
		if ((tb.getStartTime().get(Calendar.DAY_OF_YEAR) != this.getStartTime().get(Calendar.DAY_OF_YEAR))
				|| (tb.getStartTime().get(Calendar.YEAR) != this.getStartTime().get(Calendar.YEAR))) 
			return false;  // can't overlap; not on same date
	    return ((tb.getStartTime().get(Calendar.HOUR_OF_DAY) < getEndTime().get(Calendar.HOUR_OF_DAY))
				&& (tb.getEndTime().get(Calendar.HOUR_OF_DAY) > getStartTime().get(Calendar.HOUR_OF_DAY))) ;
	    // same date, but do the two timeblocks overlap?
	}
	
}
