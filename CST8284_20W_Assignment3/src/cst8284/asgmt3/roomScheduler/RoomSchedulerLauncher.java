package cst8284.asgmt3.roomScheduler;
/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modiifed by: Stewart King
    Class name: RoomSchedulerLauncher.java
    Date: March 20, 2020
*/

import cst8284.asgmt3.room.*;
/**
 * RoomSchedulerLauncher is the class that starts the Room Booking program
 * @author Stewart King, based on code supplied by Prof. Dave Houtman
 * @version 1.0
 */

public class RoomSchedulerLauncher {

	public static void main(String[] args) {
		Room room = new ComputerLab();
		room.setRoomNumber("B119");
		new RoomScheduler(room).launch();
	}
	
}
