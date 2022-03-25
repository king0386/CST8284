package cst8284.asgmt4.roomScheduler;
/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modified by: Stewart King
    Class name: RoomScheduler.java
    Date: April 7, 2020
*/

import java.util.Scanner;

import cst8284.asgmt4.room.Room;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/**
 * RoomScheduler handles all input and output of the program, instantiates
 * RoomBooking objects and stores them
 * 
 * @author Stewart King, based on code supplied by Prof. Dave Houtman
 * @version 1.0
 */
public class RoomScheduler {
	/**
	 * Room holds information related to what room will be booked
	 * Scan is a field that gets assigned a new Scanner object for user input
	 * RoomBooking ArrayList to store the ROomBOoking objects
	 */
	private Room room;
	private static Scanner scan = new Scanner(System.in);
	private ArrayList<RoomBooking> roomBookings = new ArrayList<>();

	/**
	 * Constant int values used to make choices in the displayMenu() method
	 */
	private static final int DISPLAY_ROOM_INFORMATION = 1, ENTER_ROOM_BOOKING = 2, DELETE_BOOKING = 3,
			CHANGE_BOOKING = 4, DISPLAY_BOOKING = 5, DISPLAY_DAY_BOOKINGS = 6, SAVE_BOOKINGS_TO_FILE = 7,
			LOAD_BOOKINGS_FROM_FILE = 8, EXIT = 0;

	/**
	 * One-arg constructor used to instantiate a Room object and pass it to the setRoom method.
	 * @param room holds the reference value to the room object.
	 */
	public RoomScheduler(Room room) {
		setRoom(room);
	}

	/**
	 * Sets the Room field with the value of the parameter.
	 * @param room reference value to the new Room object.
	 */
	private void setRoom(Room room) {
		this.room = room;
	}

	/**
	 * Returns the value of the room field
	 * @return a reference value to Room object of the abstract Room class.
	 */
	private Room getRoom() {
		return room;
	}

	/**
	 * Uses a do-while loop to call the loadBookingsFromFile() method and then executes the menu for the program.
	 */
	public void launch() {
		int choice = 0;
		if (new File("CurrentRoomBookings.book").exists())
			loadBookingsFromFile();
		do {
			choice = displayMenu();
			executeMenuItem(choice);
		} while (choice != EXIT);
	}

	/**
	 * Displays the menu with a list of choices for the user to select, then returns an int.
	 * @return the int value of the users choice.
	 */
	private int displayMenu() {
		System.out.println("Enter a selection from the following menu:");
		System.out.println(DISPLAY_ROOM_INFORMATION + ". Display room information\n" + ENTER_ROOM_BOOKING
				+ ". Enter a room booking\n" + DELETE_BOOKING + ". Remove a room booking\n" + CHANGE_BOOKING
				+ ". Change a room booking\n" + DISPLAY_BOOKING + ". Display a booking\n" + DISPLAY_DAY_BOOKINGS
				+ ". Display room bookings for the whole day\n" + SAVE_BOOKINGS_TO_FILE
				+ ". Backup current bookings to file\n" + LOAD_BOOKINGS_FROM_FILE
				+ ". Load current bookings from file\n" + EXIT + ". Exit program");
		int ch = scan.nextInt();
		scan.nextLine(); // 'eat' the next line in the buffer
		System.out.println(); // add a space before next menu output
		return ch;
	}

	/**
	 * Takes an int value of choice, which is used in the switch to execute the users choice.
	 * @param choice The int value taken from the user to execute their choice from the menu.
	 */
	private void executeMenuItem(int choice) {
		switch (choice) {
		case DISPLAY_ROOM_INFORMATION:
			displayRoomInfo();
			break;
		case ENTER_ROOM_BOOKING:
			saveRoomBooking(makeBookingFromUserInput());
			break;
		case DELETE_BOOKING:
			System.out.println("Enter booking to delete");
			System.out.println(
					deleteBooking(makeCalendarFromUserInput(null, true)) ? "Booking deleted" : "Booking not deleted");
			break;
		case CHANGE_BOOKING:
			System.out.println("Enter booking to change");
			if (!changeBooking(makeCalendarFromUserInput(null, true)))
				System.out.println("Cannot change room booking");
			break;
		case DISPLAY_BOOKING:
			displayBooking(makeCalendarFromUserInput(null, true));
			break;
		case DISPLAY_DAY_BOOKINGS:
			displayDayBookings(makeCalendarFromUserInput(null, false));
			break;
		case SAVE_BOOKINGS_TO_FILE:
			System.out.println(saveBookingsToFile() ? "Current room bookings backed up to file"
					: "Could not backup room bookings to file");
			break;
		case LOAD_BOOKINGS_FROM_FILE:
			System.out.println(loadBookingsFromFile() != null ? "Current room bookings loaded from file"
					: "Room bookings could not be loaded from file");
			break;
		case EXIT:
			System.out.println("Exiting Room Booking Application\n\n");
			break;
		default:
			System.out.println("Invalid choice: try again. (Select " + EXIT + " to exit.)\n");
		}
		System.out.println(); // add blank line after each output
	}

	/**
	 * 
	 * Takes a String parameter "s" and returns a String "userInput". You pass a message to this method,
	 * which then takes the users input to gather information.
	 * @param s the message to be displayed to the user.
	 * @return a String containing the users response to the message.
	 */
	private static String getResponseTo(String s) {
		System.out.print(s);
		String userInput = scan.nextLine();
		if (userInput.trim().isEmpty())
			throw new BadRoomBookingException("Missing value", "Missing an input value.");
		if (userInput == null)
			throw new BadRoomBookingException("Null value entered",
					"An attempt was made to pass a null value to a variable");
		return userInput;
	}

	/**
	 * This method collects all the useful information relating to creating a RoomBooking. 
	 * Using the getResponseTo() method you collect their name, phone number, activity, and date.
	 * As well, this method throws exceptions to most badly entered data.
	 * @return A reference value to the new RoomBooking object.
	 */
	private static RoomBooking makeBookingFromUserInput() {
		String[] fullName = getResponseTo("Enter Client Name (as FirstName LastName): ").split(" ");

		String fullNameCheck = fullName[0] + fullName[1];

		if (!fullNameCheck.matches("([A-Za-z]|-|\\.|')+"))
			throw new BadRoomBookingException("Name contains illegal characters",
					"A name cannot include characters other than alphabetic "
							+ "characters, the dash (-), the period(.) and the apostrophe(').");

		if (fullNameCheck.length() > 30)
			throw new BadRoomBookingException("Name length Exceeded",
					"The first or last name exceeds the 30 character maximum allowed");

		String phoneNumber = getResponseTo("Phone Number (e.g. 613-555-1212): ");
		if (!phoneNumber.matches("[1-9][1-9][1-9][-][1-9][1-9][1-9][-][1-9][1-9][1-9][1-9]"))
			throw new BadRoomBookingException("Bad Telephone number",
					"The telephone number must be a 10-digit number, seperated "
							+ "by a '-' in the form, e.g. 613-555-1212.");

		String organization = getResponseTo("Organization (optional): ");
		String category = getResponseTo("Enter event category: ");
		String description = getResponseTo("Enter detailed description of event: ");

		Calendar startCal = makeCalendarFromUserInput(null, true);
		Calendar endCal = makeCalendarFromUserInput(startCal, true);

		ContactInfo contactInfo = new ContactInfo(fullName[0], fullName[1], phoneNumber, organization);
		Activity activity = new Activity(category, description);
		TimeBlock timeBlock = new TimeBlock(startCal, endCal);
		return (new RoomBooking(contactInfo, activity, timeBlock));
	}

	/**
	 * Method takes two parameters, first one is the initial calendar object to gather the day, month, and year
	 * of the Room Booking. Second determines if the user needs to enter just the time of a calendar object, such as the end time.
	 * @param initCal either null or startCal, depending on if the day, month, year and start time have already been requested.
	 * @param requestHour Tells the method if it should prompt the user for a start or end time.
	 * @return a reference value to the new Calendar object.
	 */
	private static Calendar makeCalendarFromUserInput(Calendar initCal, boolean requestHour) {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		String date = "";
		int hour = 0;
		boolean needNewCal = (initCal == null);

		if (needNewCal)
			date = getResponseTo("Event Date (entered as DDMMYYYY): ");

		try {
			int day = needNewCal ? Integer.parseInt(date.substring(0, 2)) : initCal.get(Calendar.DAY_OF_MONTH);
			int month = needNewCal ? Integer.parseInt(date.substring(2, 4)) - 1 : initCal.get(Calendar.MONTH);
			int year = needNewCal ? Integer.parseInt(date.substring(4, 8)) : initCal.get(Calendar.YEAR);

//   		if(!date.matches("[0-3][0-9][0-1][0-2][1-9][1-9][1-9][1-9]"))
//   			throw new BadRoomBookingException("Bad Calendar format", "Bad calendar date was entered. The correct format is DDMMYYYY");

			if (requestHour)
				hour = processTimeString(getResponseTo((needNewCal ? "Start" : "End") + " Time: "));
			cal.set(year, month, day, hour, 0);
			return (cal);
		} catch (Exception ex) {
			throw new BadRoomBookingException("Bad Calendar format",
					"Bad calendar date was entered. The correct format is DDMMYYYY");
		}
	}

	/**
	 * Takes a String for a time, determines if it's A.M. or P.M. and then parses it into an integer,
	 * converting it to 24 hour format and returns an int.
	 * @param t holds a String value for the hour of the Calendar object.
	 * @return an int value of the hour for the Room Booking.
	 */
	private static int processTimeString(String t) {
		int hour = 0;
		t = t.trim();
		if (t.contains("pm") || (t.contains("p.m.")))
			hour = Integer.parseInt(t.split(" ")[0]) + 12;
		if (t.contains("am") || t.contains("a.m."))
			hour = Integer.parseInt(t.split(" ")[0]);
		if (t.contains(":"))
			hour = Integer.parseInt(t.split(":")[0]);
		return hour;
	}

	/**
	 * Takes a type Calendar and then searches the RoomBooking ArrayList to find a RoomBooking that matches
	 * the Calendar parameter. Returns the RoomBooking if exists.
	 * @param cal Calendar used to search for the Room Booking.
	 * @return Either the RoomBooking if found, or null if not found.
	 */
	private RoomBooking findBooking(Calendar cal) {
//    	Calendar oneHourLater = Calendar.getInstance();
//    	oneHourLater.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY)+1);
//    	TimeBlock findTB = new TimeBlock(cal, oneHourLater);
//    	for (RoomBooking rb: getRoomBookings()) 
//    		if (rb.getTimeBlock().overlaps(findTB)) return rb;		
//    	return null;

		Collections.sort(getRoomBookings(), new SortRoomBookingsByCalendar());

		int i = Collections.binarySearch(getRoomBookings(), new RoomBooking(), new SortRoomBookingsByCalendar());
		if (i >= 0)
			return getRoomBookings().get(i);
		return null;
	}

	/**
	 * Displays information of the room, such as room type, and how many seats it has.
	 */
	private void displayRoomInfo() {
		System.out.println(getRoom().toString());
	}

	/**
	 * Takes a RoomBooking type parameter, and determines if a RoomBooking can be saved into the ArrayList
	 * and then sorts it if it can.
	 * @param roomBooking a reference value to a new roomBooking.
	 * @return true if the roomBooking can be saved into the ArrayList, false if it can not.
	 */
	private boolean saveRoomBooking(RoomBooking roomBooking) {
		
		if(this.findBooking(roomBooking.getTimeBlock().getStartTime()) != null) {
			System.out.println("Cannot save booking; that time is already booked");
			return false;
		}
		getRoomBookings().add(roomBooking);
		Collections.sort(getRoomBookings(), new SortRoomBookingsByCalendar());
		System.out.println("Booking time and date saved.");
		return true;
	}

	/**
	 * Takes a specific date and time of a Calendar and tries to find a RoomBooking in that time.
	 * @param cal gets passed to findBooking to determine if there is a RoomBooking in the time slot.
	 * @return whether there a RoomBooking in the specified time slot.
	 */
	private RoomBooking displayBooking(Calendar cal) {
		RoomBooking booking = findBooking(cal);
		int hr = cal.get(Calendar.HOUR_OF_DAY);
		System.out.print((booking != null) ? "---------------\n" + booking.toString() + "---------------\n"
				: "No booking scheduled between " + hr + ":00 and " + (hr + 1) + ":00\n");
		return booking;
	}

	/**
	 * Takes a Calendar type, then searches the ArrayList for the specified calendar date and time.
	 * If the calendar exists it will confirm with the user to delete a RoomBooking from the ArrayList.
	 * @param cal Contains the date and time to search for a RoomBooking in the ArrayList.
	 * @return true if the RoomBooking is delete, false if the user no longer wishes to delete the appointment
	 * or if it can't find the specific date and time.
	 */
	private boolean deleteBooking(Calendar cal) {
		RoomBooking rb = displayBooking(cal);
		if (rb != null)
			if (getResponseTo("Press 'Y' to confirm deletion, " + "any other key to abort: ").toUpperCase()
					.equals("Y")) {
				getRoomBookings().remove(rb);
				return true;
			}
		return false;
	}

	/**
	 *  Used to change the date and time of an already established RoomBooking.
	 * @param cal Used to specify the date and time of the RoomBooking to be changed, and to change it.
	 * @return Returns false if it couldn't change the RoomBooking. Returns True with the new RoomBooking if it's successful.
	 */
	private boolean changeBooking(Calendar cal) {
		RoomBooking rb = displayBooking(cal); // existing RoomBooking
		if (rb == null)
			return false;
		Calendar startCal = makeCalendarFromUserInput(cal, false);
		startCal.set(Calendar.HOUR_OF_DAY, processTimeString(getResponseTo("Enter New Start Time: ")));
		Calendar endCal = makeCalendarFromUserInput(cal, false);
		endCal.set(Calendar.HOUR_OF_DAY, processTimeString(getResponseTo("Enter New End Time: ")));
		TimeBlock tb = new TimeBlock(startCal, endCal); // new TimeBlock
		for (RoomBooking rbook : getRoomBookings()) // check this won't collide with existing TimeBlock
			if (!rbook.equals(rb) && // ignore rb already in ArrayList
					(rbook.getTimeBlock().overlaps(tb)))
				return false;
		System.out.println("Booking has been changed to:");
		rb.setTimeBlock(tb);
		return (displayBooking(startCal) != null);
	}

	/**
	 * Displays all RoomBookings for a specified day.
	 * @param cal Uses specified date in a Calendar object that's passed to displayBooking() method to show
	 * any RoomBookings for the entire day.
	 */
	private void displayDayBookings(Calendar cal) {
		for (int hrCtr = 8; hrCtr < 24; hrCtr++) {
			cal.set(Calendar.HOUR_OF_DAY, hrCtr);
			RoomBooking rb = displayBooking(cal);
			if (rb != null)
				hrCtr = rb.getTimeBlock().getEndTime().get(Calendar.HOUR_OF_DAY) - 1;
		}
	}

	/**
	 *  Method to save RoomBookings to an external .book file. Uses a try-catch block to try saving 
	 * RoomBookings to a file, and a loob to write each object to the file.
	 * @return True if the RoomBookings were saved into the file. False if it caught an IOException
	 */
	private boolean saveBookingsToFile() {
		try (FileOutputStream fos = new FileOutputStream("CurrentRoomBookings.book");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			for (RoomBooking rb : getRoomBookings())
				oos.writeObject(rb);
			return true;
		} catch (IOException ex) {
			return false;
		}
	}

	/**
	 * Method to load RoomBookings from a .book file using a try-catch block to read the entire file.
	 * @return Either an ArrayList of Room Bookings, if found in the file, or null if there is no file.
	 */
	private ArrayList<RoomBooking> loadBookingsFromFile() {
		ArrayList<RoomBooking> ar = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream("CurrentRoomBookings.book");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			while (true)
				ar.add((RoomBooking) (ois.readObject()));
		} catch (EOFException ex) {
			return ar;
		} catch (IOException | ClassNotFoundException e) {
			return null;
		}
	}

	/**
	 * Returns a reference value from an ArrayList.
	 * @return the ArrayList of Room Bookings.
	 */
	private ArrayList<RoomBooking> getRoomBookings() {
		return roomBookings;
	}

}