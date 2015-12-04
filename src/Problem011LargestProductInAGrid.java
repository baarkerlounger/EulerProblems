import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Problem011LargestProductInAGrid {
	
//  What is the greatest product of four adjacent numbers in the same 
//  direction (up, down, left, right, or diagonally) in the 20×20 grid?

	public static void main(String[] args) throws FileNotFoundException {
				
		long start = System.currentTimeMillis();
		
		int arraySize = 20;
		int[][] array = new int[arraySize][arraySize];
		int product = 0;
		int maxProduct = 0;
		
		FileReader inputStream = new FileReader("problem11.txt");
		Scanner fileScanner = new Scanner(inputStream);
		
		//Put grid into an array
		int k=0;
		while (fileScanner.hasNextLine())
		{
			String line = fileScanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			lineScanner.useDelimiter(" ");
			
				while (lineScanner.hasNext())
				{
					for(int j=0; j<20; j++)
					{
						array[k][j] = Integer.parseInt(lineScanner.next());
					}
				}
				lineScanner.close();
				k++;
		}
		fileScanner.close();
		
		//check horizontal products
		for (int i=0; i<20; i++)
		{
			for (int j=0; j<17; j++)
			{
				product = array[i][j]*array[i][j+1]*array[i][j+2]*array[i][j+3];
			
				if(product > maxProduct)
				{
					maxProduct = product;
				}
			}
		}
		
		//check vertical products
		for (int i=0; i<17; i++)
		{
			for (int j=0; j<20; j++)
			{
				product = array[i][j]*array[i+1][j]*array[i+2][j]*array[i+3][j];
				
				if(product > maxProduct)
				{
					maxProduct = product;
				}
			}
		}
	
		//check right diagonal products
		for (int i=0; i<17; i++)
		{
			for (int j=0; j<17; j++)
			{
				product = array[i][j]*array[i+1][j+1]*array[i+2][j+2]*array[i+3][j+3];
				
				if(product > maxProduct)
				{
					maxProduct = product;
				}
			}
		}
		
		//check left diagonal products
		for (int i=0; i<17; i++)
		{
			for (int j=19; j>2; j--)
			{
				product = array[i][j]*array[i+1][j-1]*array[i+2][j-2]*array[i+3][j-3];
				if(product > maxProduct)
				{
					maxProduct = product;
				}
			}
		}
		
		System.out.println("Answer: " + maxProduct);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
