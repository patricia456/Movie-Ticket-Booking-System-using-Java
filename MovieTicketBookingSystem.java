import java.util.Scanner;

public class MovieTicketBookingSystem{
	static Scanner input = new Scanner(System.in);



	//-------------------------------------------------------------------------------------------------------------
   							//First Display
	public static void showSystem(){
		System.out.println("\n 					Movie Ticket Booking System");
		System.out.println("\n\t\t\t\t\t\t Choose");
		System.out.println("\n\t\t\t\t\t\t [1]Admin");
		System.out.println("\n\t\t\t\t\t\t[2]Customer");
		System.out.println("\n\t\t\t\t\t\t[0]Exit\n\n");

		System.out.print("\n\t\t\t\t\t\t Enter Command: ");
		
	}
//---------------------------------------------------------------------------------------------------------------
					

														//For admin 
	public static void admin(){
	String username;
    String password;
    System.out.println("\n\t\t\t\t\t\tLog in:\n");
    System.out.print("\n\t\t\t\t\t\tusername:");
    username = input.next();
    System.out.print("\n\t\t\t\t\t\tpassword:");
    password = input.next();

    //users check = new users(username, password);

   		if(username.equals("user") && password.equals("pass")){
    	 chooseAdmin();
    	} 
    	else{
    	System.out.println("\n\t\t\t\t\t\tSorry,Please Try again!");
    	admin();
    	}

	}


	public static void chooseAdmin(){
		int choiceAdmin = -1;
    	System.out.println(".......Add.............");
    	System.out.println("[1] Add Cinema");
		System.out.println("[2] Add Movie");
		System.out.println("[3] Add ticket");
		System.out.println("[4] Add Customer");
		System.out.println("[5] Add Payment");
		System.out.println("[6] Add Book");
		System.out.println("......Search.......... ");
		System.out.println("[7] Search Cinema");
		System.out.println("[8] Search Movie");
		System.out.println("[9] Search Ticket");
		System.out.println("[10] Search Book");
		System.out.println("[11] Search Customer");
		System.out.println("[12] Search Payment");
		System.out.println("......View All.........");
		System.out.println("[13] Cinema");
		System.out.println("[14] Movie");
		System.out.println("[15] Ticket");
		System.out.println("[16] Book");
		System.out.println("[17] Customer");
    	System.out.println("[18] Payment");
    	System.out.println("[0] Exit");
    	System.out.print("Enter the number of your choice: ");
    	choiceAdmin = input.nextInt();
    	 switch(choiceAdmin){
    	 		case 1:
					addCinema();
					break;
				case 2:
					addMovie();
					break;
				case 3:
					addTicket();
					break;
				case 4:
					addCustomer();
					break;
				case 5:
					addPayment();
					break;
				case 6:
					addBook();
					break;
				case 7:
					viewCinema();
					break;
				case 8:
					viewMovie();
					break;
				case 9:
					viewTicket();
					break;
				case 10:
					viewBook();
					break;
				case 11:
					viewCustomer();
					break;
				case 12:
					viewPayment();
					break;
				case 13:
					Cinema.viewAll();
					break;
				case 14:
					Movie.viewAll();
					break;
				case 15:
					Ticket.viewAll();
					break;
				case 16:
					Book.viewAll();
					break;
				case 17:
					Customer.viewAll();
					break;
				case 18:
					Payment.viewAll();
					break;
    	 }


	} 
	public static void addCinema(){
		
		System.out.print("\nAdd Cinema ID: ");
		int id = input.nextInt();

		System.out.print("Add Cinema Name: ");
		String cin_Name = input.nextLine();
		cin_Name = input.nextLine();

		Cinema newCin = new Cinema(id, cin_Name);

		if(newCin.add()){
			System.out.println("\nSuccessfully added!");
		}else{
			System.out.println("\nError. Try again!");
		}
	}

	public static void viewCinema(){
		
		System.out.print("\nEnter Search Cinema ID: ");
		int id = input.nextInt();
		System.out.println();

		Cinema cin = Cinema.get(id);
		if(cin != null){
			cin.print();
		}else{
			System.out.println("ID does not exist");
		}
	}

	public static void addMovie(){
		
		System.out.print("\nEnter Movie ID: ");
		int id = input.nextInt();

		System.out.print("Enter Movie Title: ");
		String title = input.nextLine();
		title = input.nextLine();

		System.out.print("Enter Movie Release Date: ");
		String date = input.nextLine();

		System.out.print("Enter Movie Description: ");
		String desc = input.nextLine();

		System.out.print("Enter Cinema ID: ");
		int cinID = input.nextInt();

		Movie newMovie = new Movie(id, title, date,desc, Cinema.get(cinID));

		if(newMovie.add()){
			System.out.println("\nSuccessfully added!");
		}else{
			System.out.println("\nError. Try again!");
		}
	}

	public static void viewMovie(){
	
		System.out.print("\nEnter Search Movie ID: ");
		int id = input.nextInt();
		System.out.println();

		Movie movie = Movie.get(id);
		if(movie != null){
			movie.print();
		}else{
			System.out.println("ID does not exist");
		}
	}


		public static void addTicket(){
		
		System.out.print("\nEnter Ticket ID: ");
		int id = input.nextInt();

		System.out.print("Enter Ticket price: ");
		int price = input.nextInt();

		System.out.print("Enter Movie ID: ");
		int movID = input.nextInt();

		Ticket newTicket = new Ticket(id, price, Movie.get(movID));

		if(newTicket.add()){
			System.out.println("\nSuccessfully added!");
		}else{
			System.out.println("\nError. Try again!");
		}
	}

	public static void viewTicket(){
		
		System.out.print("\nEnter Search Ticket ID: ");
		int id = input.nextInt();
		System.out.println();

		Ticket ticket = Ticket.get(id);
		if(ticket != null){
			ticket.print();
		}else{
			System.out.println("ID does not exist");
		}
	}


//________________________________________________________________CUSTOMER_______________________________________________________________


//---------------------------------------------------------------------------------------------------------------------
														//Customer
	public static void customer1(){
	
    	System.out.println("Welcome Customer!!!!");
    	cls();
    	chooseCustomer();

	}
		public static void chooseCustomer(){
    	int choiceCustomer = -1;
    	
    	System.out.println("[1]View All Movies ");
		System.out.println("[2] Register");
		System.out.println("[3] Pay now!");
		System.out.println("[4] Book Now!");
		System.out.println("[5] Search Book!");
		System.out.println("[0] Exit!");
		System.out.print("Enter Command: ");
    		

    	choiceCustomer = input.nextInt();
    	switch(choiceCustomer){
    			case 1:
					Movie.viewAll();
					break;
				case 2:
					addCustomer();
					break;
				case 3:
					addPayment();
					break;
				case 4:
					addBook();
					break;
				case 5:
					viewBook();
					break;				


    	}
    }
//------------------------------------------------------------------------------------------------------------------------------------------
		//to add customer
public static void addCustomer(){
	
		System.out.print("\nEnter Customer's ID: ");
		int id = input.nextInt();

		System.out.print("Enter Customer's Name: ");
		String name = input.nextLine();
		name = input.nextLine();

		System.out.print("Enter Email Address: ");
		String email = input.nextLine();

		System.out.print("Enter Gender: ");
		String gender = input.nextLine();

		Customer newCust = new Customer(id, name, email, gender);

		if(newCust.add()){
			System.out.println("\nSuccessfully added!");
		}else{
			System.out.println("\nError. Try again!");
		}
	}

	public static void viewCustomer(){
		
		System.out.print("\nEnter Search ID: ");
		int id = input.nextInt();
		System.out.println();

		Customer cust = Customer.get(id);
		if(cust != null){
			cust.print();
		}else{
			System.out.println("ID does not exist");
		}
	}


	public static void addPayment(){
		
		System.out.print("\nEnter Payment ID: ");
		int id = input.nextInt();

		System.out.print("\nEnter Your Payment : ");
		int payment = input.nextInt();

		System.out.print("\nEnter Number of Seats: ");
		int seat = input.nextInt();

		System.out.print("Enter Date: ");
		String date = input.nextLine();
		date = input.nextLine();

		System.out.print("Enter Customers ID: ");
		int custID = input.nextInt();

		Payment newPayment = new Payment(id, payment, seat,date, Customer.get(custID));

		if(newPayment.add()){
			System.out.println("\nSuccessfully added!");
		}else{
			System.out.println("\nError. Try again!");
		}
	}

	public static void viewPayment(){
		
		System.out.print("\nEnter Search Payment ID: ");
		int id = input.nextInt();
		System.out.println();

		Payment payment = Payment.get(id);
		if(payment != null){
			payment.print();
		}else{
			System.out.println("ID does not exist");
		}
	}


	public static void addBook(){
		
		System.out.print("\nEnter Book ID: ");
		int id = input.nextInt();

		System.out.print("Enter Book Date: ");
		String date = input.nextLine();
		date = input.nextLine();

		System.out.print("Enter Payment ID: ");
		int payID = input.nextInt();

		System.out.print("Enter Ticket ID: ");
		int ticID = input.nextInt();

		Book newBook = new Book(id, date, Payment.get(payID));

		if(newBook.add()){
			System.out.println("\nSuccessfully added!");
		}else{
			System.out.println("\nError. Try again!");
		}
	}

	public static void viewBook(){
		
		System.out.print("\nEnter Search Book ID: ");
		int id = input.nextInt();
		System.out.println();

		Book book = Book.get(id);
		if(book != null){
			book.print();
		}else{
			System.out.println("ID does not exist");
		}
	}

//-------------------------------------------------------------------------------------------------------------------------------------


 public static void main(String[] args) {
 		int command = -1;

		do{
			showSystem();
			command = input.nextInt();

			switch(command){
				case 1:
					admin();
					break;
				case 2:
				 	customer1();
				 	break;
					
			}
		}while(command != 0);
		
 	
 }

 public static void cls(){
		try{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch(Exception e){
			System.out.println(e);
		}
	}

}