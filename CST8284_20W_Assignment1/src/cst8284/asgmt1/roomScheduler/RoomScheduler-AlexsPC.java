/*	Course Name: CST8284
 * 	Student Name: Stewart King
 * 	Class Name: RoomScheduler
 * 	Date: January 23, 2020
 */

package cst8284.asgmt1.roomScheduler;

import java.util.Calendar;

public class RoomScheduler {

	private static java.util.Scanner scan = new java.util.Scanner(System.in);
	private RoomBooking[] roomBookings;
	private int lastBookingIndex;

	private static final int ENTER_ROOM_BOOKING = 1;
	private static final int DISPLAY_BOOKING = 2;
	private static final int DISPLAY_DAY_BOOKINGS = 3;
	private static final int EXIT = 0;

	public RoomScheduler() {
		lastBookingIndex = 0;
		roomBookings = new RoomBooking[80];
	}

	public void launch() {
		int userChoice = displayMenu();

		do {
			// displayMenu();
			executeMenuItem(userChoice);

		} while (userChoice != EXIT);
	}

	private int displayMenu() {
		System.out.println("Enter a selection from the following menu: \n" + ENTER_ROOM_BOOKING
				+ ". Enter a room booking\n" + +DISPLAY_BOOKING + ". Display a booking\n" + DISPLAY_DAY_BOOKINGS
				+ ". Display room bookings for the whole day\n" + EXIT + ". Exit program");

		return scan.nextInt();
	}

	private void executeMenuItem(int choice) {

		switch (choice) {

		case ENTER_ROOM_BOOKING:
			makeBookingFromUserInput();
			break;
		case DISPLAY_BOOKING:
			displayBooking(null);
			break;
		case DISPLAY_DAY_BOOKINGS:
			displayDayBookings(null);
			break;
		case EXIT:

			break;
		}

	}

	private boolean saveRoomBooking(RoomBooking booking) {
		boolean booked = false;
//		if (findBooking(booking.getTimeBlock()) == null) {
//			
//		}
		
		return false;

	}

	private RoomBooking displayBooking(Calendar cal) {
		RoomBooking display = findBooking(cal);

		if (display != null) {
			return (display);

		} else {
			int time = cal.get(Calendar.HOUR_OF_DAY);
			System.out.println("No booking scheduled between " + time + ":00 " + "and " + (time + 1) + ":00");
		}
		return null;

	}

	private void displayDayBookings(Calendar cal) {
		for (int i = 8; i <= 23; i++) {

			cal.set(Calendar.HOUR_OF_DAY, i);
			displayBooking(cal);
		}

	}

	private static String getResponseTo(String s) {
		System.out.print(s); // Provided by David Houtman Assignment1 instructions
		return (scan.next());

	}

	private RoomBooking makeBookingFromUserInput() {
		
		String fullName = getResponseTo("Enter Client Name (as FirstName LastName): ");
		String phoneNumber = getResponseTo("Phone Number (e.g. 613-555-1212): ");
		scan.next(); //fix scanner 'bug'
		String organization = getResponseTo("Organization (optional): ");
		String eventCat = getResponseTo("Enter event category: ");
		String eventDis = getResponseTo("Enter a detailed description of event: ");

		Calendar startHour = makeCalendarFromUserInput(null, true);
		//Calendar endHour = makeCalendarFromUserInput(startHour, false);
		String[] name = fullName.split(" ");
		String firstName = name[0];
		String lastName = name[1];
		
		
		
		ContactInfo contact = new ContactInfo(firstName, lastName, phoneNumber, organization);
		Activity activity = new Activity(eventCat, eventDis);
		TimeBlock timeblock = new TimeBlock(startHour, makeCalendarFromUserInput(startHour, true));

		return new RoomBooking(timeblock, contact, activity);
	}

	private Calendar makeCalendarFromUserInput(Calendar cal, boolean requestHour) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		
		String date = getResponseTo("Event Date (entered as DDMMYYYY): ");
		
		int day = Integer.parseInt(date.substring(0, 2)); // https://www.tutorialspoint.com/Java-String-substring-Method-example
		int month = Integer.parseInt(date.substring(2, 4));// https://beginnersbook.com/2013/12/java-string-substring-method-example/
		int year = Integer.parseInt(date.substring(4, 8));

		if (requestHour == true) {
			String startTime = getResponseTo("Start Time: ");
			scan.next(); //Scanner bug
			String endTime = getResponseTo("End Time: ");
			//scan.next(); //Scanner bug
			
			int startHour = processTimeString(startTime);
			int endHour = processTimeString(endTime);
			
			calendar.set(year, month + 1, day, startHour, endHour);
		} else {
			calendar.set(year, month + 1, day);

		}
		return calendar;

	}

	private static int processTimeString(String t) {
		String[] strArrOne = t.split(" ");
		String[] strArrTwo = strArrOne[0].split(":");
		
		int hour = Integer.parseInt(strArrTwo[0]);
		
		if(strArrOne[1].contains("pm")) {
			return Integer.parseInt(strArrTwo[0]) + 12;
		} else {
			return hour;
		}

	}

	private RoomBooking findBooking(Calendar cal) {
		RoomBooking roomBookings = null;
		for (int i = 0; i < getBookingIndex(); i++) {
			if (getRoomBookings()[i].getTimeBlock().equals(cal)) {
				roomBookings = getRoomBookings()[i];
				return roomBookings;
			}
		}
		return null;

	}

	private RoomBooking[] getRoomBookings() {
		return roomBookings;

	}

	private int getBookingIndex() {
		return lastBookingIndex;

	}

	private void setBookingIndex(int bookingIndex) {
		this.lastBookingIndex = bookingIndex;
		
	}
}
