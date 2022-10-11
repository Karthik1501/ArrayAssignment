package model;

public class BusModel {
	private String busName;
	private int totalSeat;
	private int[] seat = new int[20];
	public BusModel(){
		busName = "NJR" ;
		totalSeat = 20;
		
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getTotalSeat() {
		return totalSeat;
	}

	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}

	public int[] getSeat() {
		return seat;
	}

	public void setSeat(int[] seat) {
		this.seat = seat;
	}

	
}
