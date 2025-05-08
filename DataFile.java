import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DataFile {
	
	private String directory;
	private String input;
	
	public DataFile(String directory, String input) {
		this.directory = directory;
		this.input = input;
	}
	
	public ArrayList<String> loadDirectory() {
		
		ArrayList<String> data = new ArrayList<String>();
		Scanner infile = null;
		try {
			infile = new Scanner (new FileReader("./Directory/directory1.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			System.exit(0);
		}
		
		while(infile.hasNextLine()) {
			String line = infile.nextLine();
			data.add(line);
		}
		
		return data;
	}
	
	public ArrayList<Integer> loadSampleInput() {
		
		ArrayList<Integer> data = new ArrayList<Integer>();
		Scanner infile = null;
		try {
			infile = new Scanner (new FileReader("./Input/input.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
			System.exit(0);
		}
		
		while(infile.hasNextLine()) {
			String line = infile.nextLine();
			StringTokenizer token = new StringTokenizer(line);
			
			int s = Integer.parseInt(token.nextToken());
			data.add(s);
		}
		
		return data;
		
	}
	
}
