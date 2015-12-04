import java.util.ArrayList;

//Find the sum of all the multiples of 3 or 5 below 1000

public class Problem001MultiplesOf3And5 {

	public static void main(String[] args) {
		
        long start = System.currentTimeMillis();
        
		int maxNum = 1000;
		int sumMultiples = 0;
		ArrayList<Integer> multiples = new ArrayList<Integer>();

		for (int i=1; i < maxNum; i++)
		{
			if((i%3 == 0) || (i%5 == 0))
			{
				multiples.add(i);
			}
		}
		
		for (int i=0; i<multiples.size(); i++)
		{
			sumMultiples += multiples.get(i);
		}		
		
        System.out.println("Answer: " + sumMultiples);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
