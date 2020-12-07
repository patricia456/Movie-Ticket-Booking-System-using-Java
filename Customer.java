import java.io.*;

public class Customer{
	private int id;
	private String name;
	private String email;
	private String gender;



	public Customer(){
	}
	

	public Customer(int id, String name, String email, String gender){
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public int getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public String getEmail(){
		return email;
	}
	public String getGender(){
		return gender;
	}

	public void setId(int id){
		this.id=id;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setGender(String gender){
		this.gender = gender;
	}

	public void print(){
		System.out.println("Customer's Id:" + id);
		System.out.println("Customer's Name:" + name);
		System.out.println("Customer's email:" + email);
		System.out.println("Customer's Gender:" + gender);
	}

	public boolean add(){
		try{
			File file = new File("data/customer.txt");
			if(!file.exists()){	// check if the file exist
				return false;
			}

			FileWriter fileWriter = new FileWriter(file, true);	// true means append
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// write the data in the file
			bufferedWriter.write(id + "\t");
			bufferedWriter.write(name + "\t");
			bufferedWriter.write(email + "\t");
			bufferedWriter.write(gender + "\n");
			bufferedWriter.close();

			return true;
		}catch(IOException x){
			System.out.println("Error");
		}

		return false;
	}

	public static Customer get(int searchID){
		Customer foundCust = null;
		try{
			FileReader fileReader = new FileReader("data/customer.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";

			// while the text file has line of text
			while((line = bufferedReader.readLine()) != null){
				// split the line into an array of strings
				String[] data = line.split("\t");

				// Get the values from the array data
				int dataID = Integer.parseInt(data[0]);
				String dataName = data[1];
				String dataEmail = data[2];
				String dataGender = data[3];

				// if the searchID is found instantiate a department object
				if(searchID == dataID){
					foundCust = new Customer(dataID, dataName, dataEmail, dataGender);
				}
			}
		}catch(IOException y){
			System.out.println("Error");
		}

		return foundCust;
	}

	public static void viewAll(){
		// this is the header
		System.out.printf("\n%-10s %-18s %-20s %-15s\n", "ID", "Name","Email","Gender");
		try{
			FileReader fileReader = new FileReader("data/customer.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");
				

				int dataID = Integer.parseInt(data[0]);
				String dataName = data[1];
				String dataEmail = data[2];
				String dataGender = data[3];

				Customer cust = new Customer(dataID, dataName, dataEmail, dataGender);
				cust.printRow();
				System.out.println();
			}
		}catch(IOException y){
			System.out.println("Error");
		}
	}

	public void printRow(){
		System.out.printf("%-12s %-18s %-15s %-4s", id, name, email, gender);
	}





}