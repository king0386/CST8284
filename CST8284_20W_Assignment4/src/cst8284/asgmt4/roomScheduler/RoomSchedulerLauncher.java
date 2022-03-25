package cst8284.asgmt4.roomScheduler;
/*  Course Name: CST8284
    Author: Prof. Dave Houtman
    Modiifed by: Stewart King
    Class name: RoomSchedulerLauncher.java
    Date: April 7, 2020
*/

import cst8284.asgmt4.room.*;
//import cst8284.asgmt4.room.ComputerLab;

/**
 * RoomSchedulerLauncher is the class that starts the Room Booking program
 * @author Stewart King, based on code supplied by Prof. Dave Houtman
 * @version 1.0
 */

public class RoomSchedulerLauncher {


	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				
				(new RoomScheduler(new ComputerLab("B119"))).launch();
			}
		});
	}
	


}


