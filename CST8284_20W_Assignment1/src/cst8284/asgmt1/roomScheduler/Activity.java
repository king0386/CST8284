/*	Course Name: CST8284
 * 	Student Name: Stewart King
 * 	Class Name: Activity
 * 	Date: January 23, 2020
 */

package cst8284.asgmt1.roomScheduler;

public class Activity {

	private String description;
	private String category;
	
	public Activity(String category, String description) {
		setCategory(category);
		setDescription(description);
	}
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String toString() {
		return ("Event: " + getCategory() + "\n" + "Description: " + getDescription());
		
	}
}
