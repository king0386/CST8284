package cst8284.asgmt2.room;

public final class Boardroom extends Room{

	private int seats;
	
	public Boardroom() {seats = 16;}
	
	protected int getSeats() {return seats;}
	protected String getRoomType(){return "board room";}
	protected String getDetails(){return "conference call enabled";}
}
