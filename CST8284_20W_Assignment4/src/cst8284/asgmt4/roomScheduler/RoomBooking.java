package cst8284.asgmt4.roomScheduler;

import java.io.Serializable;

/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modified by: Stewart King
    Class name: RoomBooking.java
    Date: March 20, 2020
*/ 

/**
 * RoomBooking class allows the RoomBooking object to get instantiated with all needed information for a Room Booking
 * @author Stewart King, based on code supplied by Prof. Dave Houtman
 * @version 1.0
 */
public class RoomBooking implements java.io.Serializable {
	/**
	 * serialVersionUID is a field that contains the version of the serializable class.
	 * contactInfo is a ContactInfo type class that holds the reference value of the ContactInfo of the person making the Room Booking.
	 * activity is an Activity type class that holds the reference value of the Activity of the person making the Room Booking.
	 * timeBlock is a TimeBlock type class that holds the reference value of the TimeBlock of the person making the Room Booking.
	 */
	public static final long serialVersionUID = 1L;
	private ContactInfo contactInfo;
	private Activity activity;
	private TimeBlock timeBlock;
	
	/**
	 * Three-arg constructor that uses the classes setters to get the contactInfo, activity and timeblock of the
	 * RoomBooking object.
	 * @param contactInfo holds the reference value of the ContactInfo object.
	 * @param activity holds the reference value of the Activity object.
	 * @param timeBlock holds the reference value of TimeBlock object.
	 */
	public RoomBooking(ContactInfo contactInfo, Activity activity, TimeBlock timeBlock) {
		setContactInfo(contactInfo); setActivity(activity); setTimeBlock(timeBlock);
	}
	/**
	 * Default RoomBooking constructor.
	 */
	public RoomBooking() {}

	/**
	 * Sets the contactinfo of the person making the RoomBooking, including first name, last name, phone number, and organization.
	 * @param contactInfo the ContactInfo object holding contact information of the person making the appointment.
	 */
	public void setContactInfo(ContactInfo contactInfo) {this.contactInfo = contactInfo;}
	/**
	 * Returns the contact information for the person making the Room Booking.
	 * @return the contactInfo object
	 */
	public ContactInfo getContactInfo() {return contactInfo;}

	/**
	 * Sets the Activity for the Room Booking, including the category and description.
	 * @param activity the Activity object holding the category and description of the Activity for the Room Booking.
	 */
	public void setActivity(Activity activity) {this.activity = activity;}
	/**
	 * Returns the category and description of the Activity for the Room Booking.
	 * @return the Activity object.
	 */
	public Activity getActivity() {return activity;}

	/**
	 * Sets the Timeblock for the Room Booking, including the start and end time.
	 * @param timeBlock the TimeBlock object.
	 */
	public void setTimeBlock(TimeBlock timeBlock) {this.timeBlock = timeBlock;}
	/**
	 * Returns the TimeBlock for the Room Booking.
	 * @return the TimeBlock object.
	 */
	public TimeBlock getTimeBlock() {return timeBlock;}

	/**
	 * Returns a string calling for the TimeBlock, Activity, and ContactInfo toString() methods.
	 * @return concatenation of the TimeBlock, Activity, and ContactInfo.
	 */
	@Override public String toString() {
		return (getTimeBlock().toString() + getActivity().toString() +  getContactInfo().toString());
	}

}
