package model;

public class TicketModel {
	private String confirmation, busName, from, to;
	private int bookingId;
	private byte seatNo,age,totalMemeber;
	

	public TicketModel(String confirm,String bus, String from, String to, int bookId,byte seat,byte age){
		confirmation = confirm;
		busName = bus;
		this.from = from;
		this.to = to;
		this.bookingId = bookId;
		seatNo = seat;
		this.age = age;
	}
	
	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}



	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public byte getTotalMemeber() {
		return totalMemeber;
	}

	public void setTotalMemeber(byte totalMemeber) {
		this.totalMemeber = totalMemeber;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public byte getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(byte seatNo) {
		this.seatNo = seatNo;
	}
	
	public String toString() {
		return ("\n-------------------------------------------------"+"\n          Profile       "+
		"\n-------------------------------------------------"+
		"\n    Bus Name                :"+getBusName()+
		"\n    TicketConfirmation      :"+getConfirmation()+
		"\n    Booking ID 			   :"+getBookingId()+
		"\n    From    			       :"+getFrom()+
		"\n    To                      :"+getTo()+
		"\n    Seat NO                 :"+getSeatNo()+	
		"\n-------------------------------------------------");
		
		
		
	}
	
}
