
public class Problem010SummationOfPrimes {
	
//  Find the sum of all the primes below two million.	
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		boolean prime = false;
		int k = 2000000 ;
		long sum = 0;
		
		PrimeChecker pc = new PrimeChecker();
		
		for (long num =1; num<k; num++){
			
			prime = pc.primeChecker(num);
			
			if (prime){
				
				sum = sum + num;
			}
		}
		
		System.out.println("Answer: " + sum);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
