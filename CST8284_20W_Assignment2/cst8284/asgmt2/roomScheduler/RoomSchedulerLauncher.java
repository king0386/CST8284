package cst8284.asgmt2.roomScheduler;
/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modiifed by: Stewart King
    Class name: RoomSchedulerLauncher.java
    Date: February 11, 2020
*/

import cst8284.asgmt2.room.*;

public class RoomSchedulerLauncher {

	public static void main(String[] args) {
		Room room = new ComputerLab();
		room.setRoomNumber("B119");
		new RoomScheduler(room).launch();
	}
	
}
