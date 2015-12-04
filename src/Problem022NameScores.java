import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//For the names in the text file, order them alphabetically, 
//Sum each name (A=1, B=2 C...)
//Multiply it's sum by it's alphabetical position
//Sum these values

public class Problem022NameScores {
	
	private int getAnswer(){
		
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<Integer> scores = new ArrayList<Integer>();
		int sum = 0;
		
		names = importNames();
		Collections.sort(names);
		scores = calculateNameScores(names);
		sum    = sumScores(scores);
		
		return sum;	
	}

	private int sumScores(ArrayList<Integer> scores) {
		
		int sum = 0;
		
		for (int i=0; i<scores.size(); i++){
			sum = sum + scores.get(i); 
		}									   
		return sum;
	}

	private ArrayList<Integer> calculateNameScores(ArrayList<String> names) {
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		ArrayList<Integer> scores = new ArrayList<Integer>();
		
		for(String x: names){
			int namescore = 0;
			for(int i=0; i<x.length(); i++){
				namescore = namescore + (alphabet.indexOf(x.charAt(i)) + 1);
			}
			namescore = namescore * (names.indexOf(x) + 1);
			scores.add(namescore);
		}
		return scores;
	}

	private ArrayList<String> importNames() {
		
		ArrayList<String> names = new ArrayList<String>();
		
		FileReader inputStream;
		try {
			inputStream = new FileReader("problem22.txt");
			Scanner fileScanner = new Scanner(inputStream);
			while (fileScanner.hasNextLine())
			{
				String line = fileScanner.nextLine();
				Scanner lineScanner = new Scanner(line);
				lineScanner.useDelimiter(",");
				
					while (lineScanner.hasNext())
					{
						String name = lineScanner.next().replaceAll("\"", "");
						names.add(name);
					}
					lineScanner.close();
			}
			fileScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return names;
	}

	public static void main(String[] args) {
			
			long start = System.currentTimeMillis();
			System.out.println("Answer: " + (new Problem022NameScores().getAnswer()));
	        long stop = System.currentTimeMillis();
	        System.out.println("Time used: " + (stop - start) + "ms");


	}

}
