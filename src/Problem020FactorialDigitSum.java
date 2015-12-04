import java.math.BigInteger;

//  Find the sum of the digits in the number 100!

public class Problem020FactorialDigitSum {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		int val = 100;	
		BigInteger factorial = doFactorial(val);
		BigInteger sumDigits = sumDigits(factorial);;
		
		System.out.println("Answer: " + sumDigits);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

	private static BigInteger sumDigits(BigInteger factorial) {
		
		BigInteger sum = BigInteger.valueOf(0);
		while(factorial.compareTo(BigInteger.valueOf(0))> 0){
			BigInteger digit = factorial.mod(BigInteger.valueOf(10));
			factorial = factorial.divide(BigInteger.valueOf(10));
			sum = sum.add(digit);
		}
		return sum;
	}

	private static BigInteger doFactorial(int val) {
		
		BigInteger factorial = BigInteger.valueOf(val);
		for(int i=val-1; i>0; i--){
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

}
