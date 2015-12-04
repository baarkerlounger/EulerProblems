import java.math.BigInteger;

//What is the index of the first term in the Fibonacci sequence to contain 1000 digits?

public class Problem0251000DigitFibonacciNumber {
	
	private int getAnswer(){
		
		int digitLimit = 1000;
		BigInteger num1 = BigInteger.valueOf(1);
		BigInteger num2 = BigInteger.valueOf(1);
		int index = 2;
		
		
		while ((num1.toString().length() < digitLimit) && (num2.toString().length() < digitLimit)){
			num1 = num1.add(num2);
			num2 = num2.add(num1);
			index += 2;			
		}	
		return index;
	}

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		System.out.println("Answer: " + (new Problem0251000DigitFibonacciNumber().getAnswer()));
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");

	}

}
