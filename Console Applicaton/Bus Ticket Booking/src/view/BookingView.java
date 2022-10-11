package view;

import controller.BookingController;
import controller.Validation;
import model.BusModel;
import model.Passenger;

public class BookingView {
	BusModel bus;
    static int bookingId = 10102;
    
	BookingView(){
		 bus = new BusModel();
	}
	
	public void bookTicket(Passenger user) {
		System.out.println("******************************************");
		System.out.println("From :");
		String from = Validation.isValidName();
		System.out.println("To   :");
		String to = Validation.isValidName();
		System.out.println("Enter the Number of Ticket :");
		byte ticket =Validation.userChoice();
		
		if(bus.getTotalSeat() >= ticket) {
		   bus.setTotalSeat(bus.getTotalSeat()-ticket);
		}
		else {
			System.out.println("No ticket available -:)");
			ticket = Validation.userChoice();
		}
		
		System.out.println("Choose seat :");
		byte seat = Validation.userChoice();
		int[] busSeat = bus.getSeat();
		if(busSeat[seat] == 0) {
			bus.setTotalSeat(busSeat[seat-1]=1);
		}
		else {
			System.out.println("We are say sorry "+seat+" already booked . choose another seat ");
		    seat=Validation.userChoice();	
		}
		
			new BookingController(from, to, ticket, seat,user,++bookingId);
	}
}
