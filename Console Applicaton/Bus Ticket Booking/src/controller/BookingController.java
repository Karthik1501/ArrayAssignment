package controller;

import java.util.HashMap;

import model.Passenger;
import model.TicketModel;

public class BookingController {
	private static final HashMap<String, TicketModel> passenger = new HashMap<>();
	public BookingController(String from, String to,byte ticket, byte seat,Passenger user, int bookingId){

		passenger.put(user.getName(),new TicketModel("Yes","Njr",from,to, bookingId, seat, user.getAge()));
		System.out.println("             Ticket booked successfully                 ");
		System.out.println("                  Happy journy");
	}
	public BookingController(){
		
	}
	public void showTicket(Passenger user) {
		
		//System.out.println(passenger.keySet()+" "+user.getName());
		if(passenger.containsKey(user.getName())) {
			TicketModel showTicket =passenger.get(user.getName());
			System.out.println(showTicket);
		}
		else
			System.out.println("No One Ticket Booked !!!");
	}
	public void cancelTicket(Passenger user) {
		if(passenger.containsKey(user.getName())) {
			passenger.remove(user.getName());
		}
		else
			System.out.println("No One Ticket Booked !!!");
	}
}
