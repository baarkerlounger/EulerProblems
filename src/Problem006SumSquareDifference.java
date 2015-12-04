
public class Problem006SumSquareDifference {
	
//Find the difference between the sum of the squares of the first one 
//hundred natural numbers and the square of the sum.

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		int sum = 0;
		int square = 0;
		int sumOfSquares = 0;
		int squareOfSum = 0;
		
		for (int i=0; i<=100; i++)
		{
			square = i*i;
			sumOfSquares += square;
			sum += i;
		}
		squareOfSum = sum * sum;
		
		System.out.println("Answer: " + (squareOfSum-sumOfSquares));
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
