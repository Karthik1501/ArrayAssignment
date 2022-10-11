package view;
import  controller.Validation;
import model.BusModel;
import  controller.BookingController;
import controller.UserData;
public class BusManagement {
	BusManagement(){
		new UserData("uset", "Male", (byte)23, "user@gmail.com", "abcd", "Abcd@123", "976543212");
	}
	public void start() {
		new BusModel();
		System.out.println("***************** NJR TRAVELS *****************\n");
	    User user = new User();
		//System.out.println("\nChoose option -:)\n\t[1].Book Ticket\n\t[2].Cancel Ticket\n\t[3].View Available Tickets\n\t[4].View Booked Ticket\n\t[5].Quit");
	    System.out.println("Choose option -:)\n\t[1].Sign Up\n\t[2].Sign In\n\t[3].Exit");
		switch(Validation.userChoice()) {
		case 1:
			user.newUser();break;
		case 2:
			user.existingUser();break;
		case 3:break;
		default:
			System.out.println("Thanks for visiting !!!");
	    
		}
		
	}

}
