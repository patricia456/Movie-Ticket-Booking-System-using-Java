import java.io.*;

public class Book{
	private int id;
	private String date;
	private Payment payment;

	public Book(){
	}

	public Book(int id, String date, Payment payment){
		this.id = id;
		this.date = date;
		this.payment = payment;
	}

	public int getId(){
		return id;
	}
	public String getDate(){
		return date;
	}
	public Payment getPayment(){
		return payment;
	}
	public void setId(int id){
		this.id = id;
	}
	public void setDate(String date){
		this.date = date;
	}
	public void setPayment(Payment payment){
		this.payment = payment;
	}

	public void print(){
		System.out.println("Book ID:" + id);
		System.out.println("Book Date:" + date);
		payment.print();

	}


	public boolean add(){
		try{
			File file = new File("data/book.txt");
			if(!file.exists()){
				return false;
			}

			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(id + "\t");
			bufferedWriter.write(date + "\t");
			bufferedWriter.write(payment.getId() + "\n"); 
			bufferedWriter.close();

			return true;
		}catch(IOException x){
			System.out.println("Error");
		}

		return false;
	}

	public static Book get(int searchID){
		Book book = null;
		try{
			FileReader fileReader = new FileReader("data/book.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataID = Integer.parseInt(data[0]);
				String dataDate = data[1];
				int dataPayID = Integer.parseInt(data[2]);

				if(searchID == dataID){
					book = new Book(dataID, dataDate, Payment.get(dataPayID));
				}
			}
		}catch(IOException y){
			System.out.println("Error");
		}

		return book;
	}

	public static void viewAll(){
		System.out.printf("\n%-8s%-8s%-12s%-9s%-8s%-10s %-1s%-20s%-15s %-10s\n",
			"Book ID", "Book Date","Payment ID","Payment","Seat","Date","Customer ID", "Customer Name", "Customer Email"," Customer Gender");
		try{
			FileReader fileReader = new FileReader("data/book.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				
				int dataID = Integer.parseInt(data[0]);
				String dataDate = data[1];
				int dataPayID = Integer.parseInt(data[2]);


				Book book = new Book(dataID, dataDate, Payment.get(dataPayID));
				book.printRow();
				System.out.println();
			}
		}catch(IOException y){
			System.out.println("Error");
		}
	}

	public void printRow(){
		System.out.printf("%-10s %-10s", id, date);
		payment.printRow();
	}






















}