package cst8284.asgmt2.room;

public final class ComputerLab extends Room{

	private static final int DEFAULT_SEATS=30;
	private int seats;
	
	public ComputerLab() {seats = DEFAULT_SEATS;}

	protected int getSeats(){return seats;}
	protected String getRoomType(){return "computer lab";}
	protected String getDetails(){return "contains outlets for 30 laptops";}

}
