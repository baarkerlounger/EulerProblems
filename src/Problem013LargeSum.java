import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Problem013LargeSum {
	
//  Work out the first ten digits of the sum of the following one-hundred 50-digit numbers

	public static void main(String[] args) throws FileNotFoundException {
		
		long start = System.currentTimeMillis();

		BigInteger number = null;
		BigInteger sum = BigInteger.valueOf(0);
	
		FileReader inputStream = new FileReader("problem12.txt");
		Scanner sc = new Scanner(inputStream);
	
		while(sc.hasNextLine())	{
			number = new BigInteger(sc.nextLine());
			sum = sum.add(number);
		}
		sc.close();
	
		String finalSum = sum.toString();
		finalSum = finalSum.substring(0, 10);
		
		System.out.println("Answer: " + finalSum);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
