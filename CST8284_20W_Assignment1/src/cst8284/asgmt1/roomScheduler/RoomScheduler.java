/*	Course Name: CST8284
 * 	Student Name: Stewart King
 * 	Class Name: RoomScheduler
 * 	Date: January 24, 2020
 */

package cst8284.asgmt1.roomScheduler;

import java.util.Calendar;
import java.util.Scanner;

public class RoomScheduler {

	private static Scanner scan = new Scanner(System.in);
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
//		int userChoice = displayMenu();
		int userChoice;

		do {
			userChoice = displayMenu(); //might fix infinite loop
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
			saveRoomBooking(makeBookingFromUserInput());
			break;
		case DISPLAY_BOOKING:
			scan.nextLine();
			Calendar cal = makeCalendarFromUserInput(null, true);
			displayBooking(cal);
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
		if(findBooking(booking.getTimeBlock().getStartTime()) == null) {
			roomBookings[getBookingIndex()] = booking;
			System.out.println("Booking time and date saved.\n");
			booked = true;
		} else if(findBooking(booking.getTimeBlock().getStartTime()) != null) {
			System.out.println("Could not save booking");
			booked = false;
		}
		return booked;

	}

	private RoomBooking displayBooking(Calendar cal) {
		RoomBooking booking = findBooking(cal);

		if (booking != null) {
			return booking;

		} else {
			int time = cal.get(Calendar.HOUR_OF_DAY);
			System.out.println("No booking scheduled between " + time + ":00 " + "and " + (time + 1) + ":00\n");
		}
		return null;

	}

	private void displayDayBookings(Calendar cal) {
		String display = new String();
		for (int i = 8; i <= 23; i++) {

			cal.set(Calendar.HOUR_OF_DAY, i);
			display += displayBooking(cal) + "\n";
		}

	}

	private static String getResponseTo(String s) {
		System.out.print(s); // Provided by David Houtman Assignment1 instructions
		return scan.nextLine();

	}

	private RoomBooking makeBookingFromUserInput() {		
		String[] fullName = new String[2];
		scan.nextLine(); //stupid scanner bug
		fullName = getResponseTo("Enter Client Name (as FirstName LastName): ").split(" ");
		String phoneNumber = getResponseTo("Phone Number (e.g. 613-555-1212): ");
		String organization = getResponseTo("Organization (optional): ");
		String eventCat = getResponseTo("Enter event category: ");
		String eventDis = getResponseTo("Enter a detailed description of event: ");

		Calendar startHour = makeCalendarFromUserInput(null, true);
		
		ContactInfo contact = new ContactInfo(fullName[0], fullName[1], phoneNumber, organization);
		Activity activity = new Activity(eventCat, eventDis);
		TimeBlock timeblock = new TimeBlock(startHour,makeCalendarFromUserInput(startHour, true));

		return new RoomBooking(timeblock, contact, activity);
	}

	private Calendar makeCalendarFromUserInput(Calendar cal, boolean requestHour) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		
		if (cal == null) {		
			String date;
			date = getResponseTo("Event Date (entered as DDMMYYYY): "); 
			calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date.substring(0, 2)));
			calendar.set(Calendar.MONTH, Integer.parseInt(date.substring(2, 4)) - 1); //Because in Java, even months start at 0
			calendar.set(Calendar.YEAR, Integer.parseInt(date.substring(4, 8)));
			
		} else {
			calendar.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH)); //Was not accepting my own day, month, year local variables. Might investigate.
			calendar.set(Calendar.MONTH, cal.get(Calendar.MONTH));
			calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));
		}			
		
		int hours;
		if (requestHour == true && cal == null) {
			hours = processTimeString(getResponseTo("Start Time: "));
			calendar.set(Calendar.HOUR, hours);
			
		} else if (requestHour == true && cal != null) {
			hours = processTimeString(getResponseTo("End Time: "));
			calendar.set(Calendar.HOUR, hours);
			
		} else if (requestHour != true && cal == null) {
			hours = 8;
			
		} else hours = 23;		
		calendar.set(Calendar.HOUR, hours);
		
		return calendar;
	
	}

	private static int processTimeString(String t) {

	
		String[] strArrOne = t.split(" ");
		String[] strArrTwo = strArrOne[0].split(":");
		
		int hour = Integer.parseInt(strArrTwo[0]);
		
		if(strArrOne.length > 1 && strArrOne[1].contains("p") || strArrOne[1].contains("P")) {
			return Integer.parseInt(strArrTwo[0]) + 12;
		
		} else if (strArrOne.length > 1 || strArrOne[1].contains("a") || strArrOne[1].contains("A") ){
			return hour;
		} else {
			return hour;
		}

	}

	private RoomBooking findBooking(Calendar cal) {
		RoomBooking roomBookings = new RoomBooking(null, null, null);
		TimeBlock tb = new TimeBlock();
		for (int i = 0; i < getBookingIndex(); i++) {
			if (getRoomBookings()[i].getTimeBlock().overlaps(tb)) { //change equals to overlaps
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
		this.lastBookingIndex = bookingIndex++;
		
	}
}
