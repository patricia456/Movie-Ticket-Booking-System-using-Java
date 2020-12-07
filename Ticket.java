import java.io.*;

public class Ticket{
	private int id;
	private int price;
	private Movie movie;

	public Ticket(){

	}
	public Ticket(int id, int price, Movie movie){
		this.id = id;
		this.price = price;
		this.movie = movie;
	}


	public int getId(){
		return id;
	}
	public int getPrice(){
		return price;
	}
	public Movie getMovie(){
		return movie;
	}

	public void setId(int id){
		this.id = id;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public void setMovie(Movie movie){
		this.movie = movie;
	}

	public void print(){
		System.out.println("Ticket Id:" + id);
		System.out.println("Ticket Price:" + price);
		movie.print();
	}

	public boolean add(){
		try{
			File file = new File("data/ticket.txt");
			if(!file.exists()){
				return false;
			}

			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(id + "\t");
			bufferedWriter.write(price + "\t");
			bufferedWriter.write(movie.getId() + "\n"); 
			bufferedWriter.close();

			return true;
		}catch(IOException x){
			System.out.println("Error");
		}

		return false;
	}

	public static Ticket get(int searchID){
		Ticket ticket = null;
		try{
			FileReader fileReader = new FileReader("data/ticket.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataID = Integer.parseInt(data[0]);
				int dataPrice = Integer.parseInt(data[1]);
				int dataMovID = Integer.parseInt(data[2]);

				if(searchID == dataID){
					ticket = new Ticket(dataID, dataPrice, Movie.get(dataMovID));
				}
			}
		}catch(IOException y){
			System.out.println("Error");
		}

		return ticket;
	}

	public static void viewAll(){
		System.out.printf("\n%-15s%-15s%-15s %-25.23s%-25.23s%-25.23s%-25.23s%-25.23s\n",
			"Ticket ID", "Ticket Price","Movie ID", "Movie Name", "Movie Release Date","Movie Description","Cinema ID","Cinema Name" );
		try{
			FileReader fileReader = new FileReader("data/ticket.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataID = Integer.parseInt(data[0]);
				int dataPrice = Integer.parseInt(data[1]);
				int dataMovID = Integer.parseInt(data[2]);


				Ticket ticket = new Ticket(dataID, dataPrice, Movie.get(dataMovID));
				ticket.printRow();
				System.out.println();
			}
		}catch(IOException y){
			System.out.println("Error");
		}
	}

	public void printRow(){
		System.out.printf("%-15s %-15s", id, price);
		movie.printRow();
	}








}