public class PrimeChecker {
	
	public boolean primeChecker(Long number)
	{
		boolean prime = true;
		
		if ((number == 0L) || (number == 1L))
			{
				prime = false;
			}
		else if (number%2L == 0L){
			prime = false;
		}
		else
		{
			for (Long i=3L; i<=Math.sqrt(number); i+= 2)
			{
				if(number%i == 0L)
				{
					prime = false;
					break;
				}
				prime = true;
			}
		}
		return prime;
	}
}
