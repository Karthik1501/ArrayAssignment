package view;
import controller.Validation;
import model.Passenger;
import controller.BookingController;
import controller.LoginAuthentication;
import controller.UserData;
public class User {
	BusManagement bank = new BusManagement();
	BookingController view= new BookingController();
	public void newUser() {
		System.out.println("************* Sign Up *************\n");
		System.out.print("Enter your name :");
		String name =Validation.isValidName();
		
		String gender = Validation.isValidGender();
		
		byte age = Validation.isValidAge();
		
		String email = Validation.isValidEmail();
		
		String userName = Validation.isValidUserName();
		
		String passWord = Validation.isValidPassword();
		
		String phone =Validation.isValidPhoneNumber();
		System.out.println("\n   User Registered Successfully    \n");
		System.out.println("           Back to Main Page          \n");
		new UserData(name, gender, age, email, userName, passWord, phone);
		bank.start();
	}
	
	public void existingUser() {
          Passenger loginAuth = new LoginAuthentication().isUser();
          while(loginAuth != null) {
        	  System.out.println("\nChoose Option -:)\n\t[1].View Profile\n\t[2].Book Ticket\n\t[3].Cancel Ticket\n\t[4].View Booked Ticket\n\t[5].Back");
        	  switch(Validation.userChoice()) {
        	  case 1:
        		  System.out.println(loginAuth);break;
        	  case 2:
        		  new BookingView().bookTicket(loginAuth);break;
        	  case 3:
        		   view.cancelTicket(loginAuth);break;
        	  case 4:
        		  view.showTicket(loginAuth);break;
        	  default:
        		  System.out.println("Invalid input try again !!!");
        	  }
          }
		
	}

	
}
