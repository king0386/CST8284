/*	Course Name: CST8284
 * 	Student Name: Stewart King
 * 	Class Name: RoomBooking
 * 	Date: January 23, 2020
 */
package cst8284.asgmt1.roomScheduler;

import java.text.SimpleDateFormat;

public class RoomBooking {
	
	private ContactInfo contactInfo;
	private Activity activity;
	private TimeBlock timeBlock;
	
	
	public RoomBooking(TimeBlock timeBlock, ContactInfo contactInfo, Activity activity) {
		setTimeBlock(timeBlock);
		setContactInfo(contactInfo);
		setActivity(activity);
	}


	public ContactInfo getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}


	public Activity getActivity() {
		return activity;
	}


	public void setActivity(Activity activity) {
		this.activity = activity;
	}


	public TimeBlock getTimeBlock() {
		return timeBlock;
	}


	public void setTimeBlock(TimeBlock timeBlock) {
		this.timeBlock = timeBlock;
	}


	
	public String toString() {
		//https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm");	
		return 	dateFormat.format(getTimeBlock().getStartTime()) + "\n" + 
				getContactInfo()  + "\n" + getActivity().toString();
	}
	
	
}
