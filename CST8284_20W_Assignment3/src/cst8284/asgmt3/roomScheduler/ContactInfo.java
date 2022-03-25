package cst8284.asgmt3.roomScheduler;
/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modified by: Stewart King
    Class name: ContactInfo.java
    Date: March 20, 2020
*/ 
/**
 * ContactInfo class stores all information related to the individual/organization creating the Room Booking
 * @author Stewart King, based on code supplied by Prof. Dave Houtman
 * @version 1.0
 */
public class ContactInfo implements java.io.Serializable {
	/**
	 * serialVersionUID is a field that contains the version of the serializable class.
	 * firstName is a String that holds the first name of the person making a Room Booking.
	 * lastName is a String that holds the last name of the person making a Room Booking.
	 * phoneNumber is a String that holds the telephone number of the person making the Room Booking.
	 * organization is a String that holds the name of the organization making a Room Booking.
	 */
	private static final long serialVersionUID = 1L;
	private String firstName, lastName, phoneNumber, organization;
	/**
	 * Three-arg constructor to chain and pass a person first name, last name, phone number, and default organization
	 * of "Algonquin College" to the next four-arg constructor.
	 * @param firstName String to hold the first name of the person making the Room Booking.
	 * @param lastName String to hold the last name of the person making the Room Booking.
	 * @param phoneNumber String to hold the phone number of the person making the Room Booking.
	 */
	public ContactInfo(String firstName, String lastName, String phoneNumber) {this(firstName, lastName, phoneNumber, "Algonquin College");}
	/**
	 * Four-arg constructor to instantiate a ContactInfo object. Uses the classes setters to collect the information from the user
	 * @param firstName String with the persons first name.
	 * @param lastName String to hold the persons last name.
	 * @param phoneNumber String to hold the persons phone number.
	 * @param organization String to hold the persons organization.
	 */
	public ContactInfo(String firstName, String lastName, String phoneNumber, String organization) {
		setFirstName(firstName); setLastName(lastName); 
		setPhoneNumber(phoneNumber); setOrganization(organization);
	}	
	
	/**
	 * Sets the person making the Room Booking first name.
	 * @param firstName String of the users first name.
	 */
	public void setFirstName(String firstName) {this.firstName = firstName;}
	/**
	 * Gets the first name of the person making the Room Booking.
	 * @return the String of the first name of the person making the Room Booking.
	 */
	public String getFirstName() {return firstName;}

	/**
	 * Sets the last name of the person making the Room Booking.
	 * @param lastName String storing the last name of the user.
	 */
	public void setLastName(String lastName) {this.lastName = lastName;}
	/**
	 * Gets the last name of the person making the Room Booking.
	 * @return the String of the last name of the person making the Room Booking.
	 */
	public String getLastName() {return lastName;}

	/**
	 * Sets the phone number of the person making the Room Booking.
	 * @param phoneNumber String to store the phone number of the user.
	 */
	public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
	/**
	 * Gets the phone number of the person making the Room Booking.
	 * @return The phone number of the user making the Room Booking.
	 */
	public String getPhoneNumber() {return phoneNumber;}

	/**
	 * Sets the organization of the person creating the Room Booking.
	 * @param organization String to store the name of the organization creating the Room Booking.
	 */
	public void setOrganization(String organization) {this.organization = organization;}
	/**
	 * Gets the organization of the person who created the Room Booking.
	 * @return The organization of the person who is making the Room Booking.
	 */
	public String getOrganization() {return organization;}
	/**
	 * Returns a string with the first name, last name, phone number and organization.
	 * @return Returns the concatenation of first name, last name, phone number and organization of the ContactInfo.
	 */
	@Override
	public String toString() {
		return "Contact Information: " +
			((getFirstName()!="")?(getFirstName() + " " + getLastName()):"") + "\n" +
			"Phone: " + getPhoneNumber() +  
			((getOrganization().equals(""))?"":("\n" +getOrganization() + "\n"));
	}
}