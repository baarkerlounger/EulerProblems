public class Problem007Prime10001 {
	
//What is the 10 001st prime number?

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		boolean prime = false;
		int k = 0;
		int count = 3; //Since the loop doesn't count 2 and 3 which are prime
		int primeNum = 0;
		
		
		while(count<=10001)
		{
			for (int i=2; i<=k/2; i++)
			{
				if (k%i == 0)
				{
					prime = false;
					break;
				}
				primeNum = k;
				prime = true;
			}
			if (prime)
			{
				count++;
			}
			k++;
		}
		System.out.println("Answer: " + primeNum);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
