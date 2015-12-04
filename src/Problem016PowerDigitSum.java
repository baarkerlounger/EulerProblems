import java.math.BigInteger;

//  What is the sum of the digits of the number 21000?

public class Problem016PowerDigitSum {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		int exponent = 1000;
		BigInteger base = BigInteger.valueOf(2);
		BigInteger result = BigInteger.valueOf(0);
		BigInteger sum = BigInteger.valueOf(0);
		String num = null;
		
		result = base.multiply(base);
		for (int i=0; i<exponent-2; i++)
		{
			result = result.multiply(base);
		}
		System.out.println(base+"^"+exponent+" = "+result);
		
		String digits = result.toString();
		
		for (int i=0; i<=digits.length(); i++)
		{
			if (i<digits.length())
			{
				num = digits.substring(i, (i+1));
				sum = sum.add(new BigInteger(num));
			}
		}
		
		System.out.println("Answer: " + sum);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
