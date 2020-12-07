import java.io.*;

public class Payment{
	private int id;
	private int payment;
	private int seat;
	private String date;
	private Customer customer;

	public Payment(){
	}
	public Payment(int id, int payment,int seat, String date, Customer customer){
		this.id = id;
		this.payment = payment;
		this.seat = seat;
		this.date = date;
		this.customer = customer;
	}

	public int getId(){
		return id;
	}
	public int getPayment(){
		return payment;
	}
	public int getSeat(){
		return seat;
	}
	public String getDate(){
		return date;
	}
	public Customer getCustomer(){
		return customer;
	}

	public void setId(int id){
		this.id= id;
	}
	public void setPayment(int payment){
		this.payment = payment;
	}
	public void setSeat(int seat){
		this.seat = seat;
	}
	public void setDate(String date){
		this.date = date;
	}
	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public void print(){
		System.out.println("Payment Id:" + id);
		System.out.println("Payment:" + payment);
		System.out.println("Seats:" + seat);
		System.out.println("Payment Date:" + date);
		customer.print();
	}


	public boolean add(){
		try{
			File file = new File("data/payment.txt");
			if(!file.exists()){
				return false;
			}

			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(id + "\t");
			bufferedWriter.write(payment + "\t");
			bufferedWriter.write(seat + "\t");
			bufferedWriter.write(date + "\t");
			bufferedWriter.write(customer.getId() + "\n"); // only the dept's id will be saved
			bufferedWriter.close();

			return true;
		}catch(IOException x){
			System.out.println("Error");
		}

		return false;
	}

	public static Payment get(int searchID){
		Payment payment = null;
		try{
			FileReader fileReader = new FileReader("data/payment.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataID = Integer.parseInt(data[0]);
				int dataPayment = Integer.parseInt(data[1]);		
				int dataSeat = Integer.parseInt(data[2]);		
				String dataDate = data[3];
				int dataCustID = Integer.parseInt(data[4]);

				if(searchID == dataID){
					payment = new Payment(dataID, dataPayment, dataSeat,dataDate, Customer.get(dataCustID));
				}
			}
		}catch(IOException y){
			System.out.println("Error");
		}

		return payment;
		
	}

	public static void viewAll(){
		System.out.printf("\n%-5s %-12s %-3s %-9s %-8s %-20s %-20s %-6s\n",
			"ID", "Payment", "Seat", "Date", "Customer ID", "Customer Name","Email", "Gender");
		try{
			FileReader fileReader = new FileReader("data/payment.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataID = Integer.parseInt(data[0]);
				int dataPayment = Integer.parseInt(data[1]);		
				int dataSeat = Integer.parseInt(data[2]);		
				String dataDate = data[3];
				int dataCustID = Integer.parseInt(data[4]);

				Payment payment = new Payment(dataID, dataPayment, dataSeat,dataDate, Customer.get(dataCustID));
				payment.printRow();
				System.out.println();
			}
		}catch(IOException y){
			System.out.println("Error");
		}
	}

	public void printRow(){
		System.out.printf("  %-5s %-12s %-3s %-10.23s ", id, payment, seat,date);
		customer.printRow();
	}



}