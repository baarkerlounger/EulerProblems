public class Problem012HighlyDivisibleTriangleNumber {
	
//  What is the value of the first triangle number to have over five hundred divisors?

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		double triangleNum = 0;
		double n = 1;
		int divisorCount = 0;
		int divisorLimit = 500/2;
		
		while (divisorCount<=divisorLimit)
		{
			triangleNum = n*((n+1)/2);
			
			for (int i=1; i<= Math.sqrt(triangleNum); i++)
			{
				if (triangleNum%i == 0)
				{
					divisorCount++;
				}
			}
				
			if(divisorCount<divisorLimit)
			{
				divisorCount = 0;
			}
			n++;
		}
		System.out.println("Answer: " + (int)triangleNum);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}
}
