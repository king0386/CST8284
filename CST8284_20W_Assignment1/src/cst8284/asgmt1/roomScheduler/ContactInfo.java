/*	Course Name: CST8284
 * 	Student Name: Stewart King
 * 	Class Name: ContactInfo
 * 	Date: January 23, 2020
 */
package cst8284.asgmt1.roomScheduler;

public class ContactInfo {
	
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String organization;
	
	
	public ContactInfo(String firstName, String lastName, String phoneNumber, String organization) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setOrganization(organization);
		
	}
	
	public ContactInfo(String firstName, String lastName, String phoneNumber) {
		this(firstName, lastName, phoneNumber, "Algonquin");
		
	}

	


	public String toString() {
//		if(this.organization == "") {
//			return this.firstName + this.lastName + this.phoneNumber;
//		}
		return this.firstName + this.lastName + this.phoneNumber + this.organization;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

}
