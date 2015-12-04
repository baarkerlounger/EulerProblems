
public class Problem002EvenFibonacciNumbers	 {

//Find the sum of all even fibonacci numbers below 4 million

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		int num1 = 1;
		int num2 = 2;
		int end = 4000000;
		int sum = num2;
		
		while ((num1 + num2) < end)
		{			
		num1 += num2;
		num2 += num1; 
		
			if (num1%2 == 0)
			{
				sum += num1; 
			}
			if (num2%2 == 0)
			{
				sum += num2; 
			}
		}

		System.out.println("Answer: " + sum);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
