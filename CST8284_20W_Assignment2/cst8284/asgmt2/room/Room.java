package cst8284.asgmt2.room;

public abstract class Room {
	
	public static final long serialVersionUID=1L;
	private static final String DEFAULT_ROOM = "unknown room number";
	private String roomNumber;
	
	protected Room() {this(DEFAULT_ROOM);}
	protected Room(String roomNum) {setRoomNumber(roomNum);}
	
	public void setRoomNumber(String roomNum) {roomNumber = roomNum;}
	public String getRoomNumber() {return roomNumber;}
	
    protected abstract int getSeats();
    protected abstract String getRoomType() ;
	protected abstract String getDetails();
	
	public String toString( ){return getRoomNumber() + " is a " +
		getRoomType() + " with " + getSeats() + " seats; " + getDetails();}
}
