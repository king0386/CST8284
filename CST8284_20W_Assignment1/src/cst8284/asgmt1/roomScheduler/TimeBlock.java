/*	Course Name: CST8284
 * 	Student Name: Stewart King
 * 	Class Name: TimeBlock
 * 	Date: January 23, 2020
 */

package cst8284.asgmt1.roomScheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeBlock {

	private Calendar startTime;
	private Calendar endTime;
	
	
	//https://docs.oracle.com/javase/7/docs/api/java/util/Calendar.html
	//https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.Builder.html
	//https://mkyong.com/java/java-date-and-calendar-examples/
	// as well as in Adenda version 1.10 of Assignment 1
	public TimeBlock() {		
		Calendar cal = Calendar.getInstance();
		
		startTime = new Calendar.Builder().set(Calendar.HOUR_OF_DAY, 8).build();
		endTime = new Calendar.Builder().set(Calendar.HOUR_OF_DAY, 23).build();
	}
	public TimeBlock(Calendar start, Calendar end) {
		setStartTime(start);
		setEndTime(end);
	}
	
	
	
	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	
	//https://www.geeksforgeeks.org/calendar-compareto-method-in-java-with-examples/
	public boolean overlaps(TimeBlock newBlock) {
		
		int day = Calendar.getInstance().getTime().getDay();
		int month = Calendar.getInstance().getTime().getMonth() + 1;
		int year = Calendar.getInstance().getTime().getYear();
		
		Calendar start = getStartTime();
		Calendar end = getEndTime();
		
		int value = end.compareTo(start);
		
		if(value == 0) {
			return true;
		} else {
			return false;
		}
		
	}
	//https://mkyong.com/java/java-date-and-calendar-examples/
	//https://javarevisited.blogspot.com/2012/12/how-to-add-subtract-days-months-years-to-date-time-java.html
	public int duration() {
		Calendar cal = Calendar.getInstance();
		
		Calendar endTime = getEndTime();
		int endHour = endTime.get(Calendar.HOUR_OF_DAY);
		Calendar startTime = getStartTime();
		int startHour = startTime.get(Calendar.HOUR_OF_DAY);
		
		return endHour - startHour;
		
		
	}
	
	public String toString() {
		
		SimpleDateFormat df = new SimpleDateFormat("EEE MMM dd yyyy HH:mm");
		return "\n" + df.format(this.getStartTime().getTime()).toString() + "\n";
		
	}
}
