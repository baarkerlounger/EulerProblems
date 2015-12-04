
public class Problem003PrimeFactors {
	
//What is the largest prime factor of the number 600851475143?

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		long number = 600851475143L;
		long highestPrime = 0L;
		boolean checkPrime = false;
		
		PrimeChecker primeChecker = new PrimeChecker();
		
		for (long i=1l; i<=Math.sqrt(number); i++) //Iterate through half of possible factors
		{		
			if((number%i) == 0) //Check if factor
			{
				checkPrime = primeChecker.primeChecker((number/i)); //Check if higher corresponding factor is prime
				if(checkPrime){
					if((number/i) > highestPrime){
						highestPrime = number/i;
					}
				}else{
					checkPrime = primeChecker.primeChecker(i); //Check if first factor is prime
					if(checkPrime){
						if(number > highestPrime){
							highestPrime = i;
						}
					}
				}
			}
		}
		System.out.println("Answer: " + highestPrime);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
