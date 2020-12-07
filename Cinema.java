import java.io.*;

public class Cinema{
	private int id;
	private String cin_Name;

	public Cinema(){

	}

	public Cinema(int id, String cin_Name){
		this.id = id;
		this.cin_Name =cin_Name;
	}

	public int getId(){
		return id;
	}
	public String getCin_Name(){
		return cin_Name;
	}

	public void setId(int id){
		this.id = id;
	}
	public void setCin_Name(String cin_Name){
		this.cin_Name = cin_Name;
	}

	public void print(){
		System.out.println("Cinema ID:" + id);
		System.out.println("Cinema Name:" + cin_Name);

	}
	public boolean add(){
		try{
			File file = new File("data/cinema.txt");
			if(!file.exists()){	
				return false;
			}

			FileWriter fileWriter = new FileWriter(file, true);	
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		
			bufferedWriter.write(id + "\t");
			bufferedWriter.write(cin_Name + "\n");
			bufferedWriter.close();

			return true;
		}catch(IOException x){
			System.out.println("Error");
		}

		return false;
	}

	public static Cinema get(int searchID){
		Cinema foundcin = null;
		try{
			FileReader fileReader = new FileReader("data/cinema.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";

			while((line = bufferedReader.readLine()) != null){
	
				String[] data = line.split("\t");

			
				int dataID = Integer.parseInt(data[0]);
				String datacin_Name = data[1];

				if(searchID == dataID){
					foundcin = new Cinema(dataID, datacin_Name);
				}
			}
		}catch(IOException y){
			System.out.println("Error");
		}

		return foundcin;
	}

	public static void viewAll(){
	
		System.out.printf("\n%-15s %-25.23s\n", "Cinema ID", "Cinema Name");
		try{
			FileReader fileReader = new FileReader("data/cinema.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");
				int dataID = Integer.parseInt(data[0]);
				String datacin_Name = data[1];

				Cinema cin = new Cinema(dataID, datacin_Name);
				cin.printRow();
				System.out.println();
			}
		}catch(IOException y){
			System.out.println("Error");
		}
	}

	public void printRow(){
		System.out.printf("%-15d %-25.23s", id, cin_Name);
	}

}