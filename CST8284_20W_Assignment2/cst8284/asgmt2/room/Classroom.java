package cst8284.asgmt2.room;

public final class Classroom extends Room{

	private static final int DEFAULT_SEATS=120;
	private int seats;
	
	public Classroom(){seats = DEFAULT_SEATS;}
	
	protected int getSeats(){return seats;}
	protected String getRoomType(){return "classroom";}
	protected String getDetails(){return "contains overhead projector";}
}
