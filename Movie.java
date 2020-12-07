import java.io.*;

public class Movie{
	private int id;
	private String title;
	private String date;
	private String desc;
	private Cinema cinema;


	public Movie(){
	}

	public Movie(int id, String title, String date, String desc, Cinema cinema){
		this.id = id;
		this.title = title;
		this.date = date;
		this.desc = desc;
		this.cinema = cinema;
	}


	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public String getDate(){
		return date;
	}
	public String getDesc(){
		return desc;
	}
	public Cinema getCinema(){
		return cinema;
	}

	public void setId(int id){
		this.id = id;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setDate(String date){
		this.date = date;
	}
	public void setDesc(String desc){
		this.desc = desc;
	}
	public void setCinema(Cinema cinema){
		this.cinema = cinema;
	}
	public void print(){
		System.out.println("Movie ID:" + id);
		System.out.println("Movie Title:" + title);
		System.out.println("Movie Release Date:" + date);
		System.out.println("Movie Description:" + desc);
		cinema.print();
	}

	public boolean add(){
		try{
			File file = new File("data/movie.txt");
			if(!file.exists()){
				return false;
			}

			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			bufferedWriter.write(id + "\t");
			bufferedWriter.write(title + "\t");
			bufferedWriter.write(date + "\t");
			bufferedWriter.write(desc + "\t");
			bufferedWriter.write(cinema.getId() + "\n"); // only the dept's id will be saved
			bufferedWriter.close();

			return true;
		}catch(IOException x){
			System.out.println("Error");
		}

		return false;
	}

	public static Movie get(int searchID){
		Movie movie = null;
		try{
			FileReader fileReader = new FileReader("data/movie.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataID = Integer.parseInt(data[0]);
				String dataTitle = data[1];
				String dataDate = data[2];
				String dataDesc = data[3];
				int dataCinID = Integer.parseInt(data[4]);

				if(searchID == dataID){
					movie = new Movie(dataID, dataTitle, dataDate,dataDesc, Cinema.get(dataCinID));
				}
			}
		}catch(IOException y){
			System.out.println("Error");
		}

		return movie;
	}

	public static void viewAll(){
		System.out.printf("\n%-15s %-25.23s %-25.23s %-25.23s %-15s %-25.23s\n",
			"Movie ID", "Movie Name", "Movie Release Date","Movie Description", "Cinema ID", "Cinema Name");
		try{
			FileReader fileReader = new FileReader("data/movie.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line = "";
			while((line = bufferedReader.readLine()) != null){
				String[] data = line.split("\t");

				int dataID = Integer.parseInt(data[0]);
				String dataTitle = data[1];
				String dataDate = data[2];
				String dataDesc = data[3];
				int dataCinID = Integer.parseInt(data[4]);

				Movie movie = new Movie(dataID, dataTitle, dataDate,dataDesc, Cinema.get(dataCinID));
				movie.printRow();
				System.out.println();
			}
		}catch(IOException y){
			System.out.println("Error");
		}
	}

	public void printRow(){
		System.out.printf("%-15d %-25.23s %-25.23s %-25.23s ", id, title, date,desc);
		cinema.printRow();
	}




}