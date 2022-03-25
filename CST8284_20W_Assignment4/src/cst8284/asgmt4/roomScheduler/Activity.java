package cst8284.asgmt4.roomScheduler;
/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modified by: Stewart King
    Class name: Activity.java
    Date: March 20, 2020
*/ 

/**
 * Activity class holds all the details of the event and description of the Room Booking object.
 * @author Stewart King, based on code supplied by Prof. Dave Houtman
 * @version 1.0
 */
public class Activity implements java.io.Serializable {
	/**
	 * serialVersionUID is a field that contains the version of the serializable class.
	 * category is a String that is holding the category of the Activity.
	 * description is a String that holds the description of the Activity.
	 */
	private static final long serialVersionUID = 1L;
	private String category, description;
	
	/**
	 * Constructs a new Activity with the specific category and description strings.
	 * @param category The type of Activity being booked.
	 * @param description Detailed description of the Activity being booked.
	 */
	public Activity(String category, String description) {
		setCategory(category); setDescription(description);	
	}
	
	/**
	 * Returns the description of the Activity.
	 * @return the detailed description of the Activity.
	 */
	public String getDescription() {return description;}
	/**
	 * Sets the description of the Activity for the Room Booking.
	 * @param description contains the description of the Activity that is stored in the String "description".
	 */
	public void setDescription(String description) {this.description = description;}
	/**
	 * Returns the category of the Activity
	 * @return the category of the Activity
	 */
	public String getCategory() {return category;}
	/**
	 * Sets the category of the Activity for the room Booking.
	 * @param category contains the category type of the Activity that is stored in the String "category".
	 */
	public void setCategory(String category) {this.category = category;}
	/**
	 * Returns a string with the category and description of the Activity for the Room Booking.
	 * @return Returns the concatenation of the category and description of the Activity.
	 */
	@Override
	public String toString() {
		return  "Event: " + getCategory() + "\n" + 
			((getDescription()!="")?"Description: " + getDescription():"") + "\n";
	}
}