
public class Problem004LargestPalindromeProduct {
	
//Find the largest palindrome made from the product of two 3-digit numbers.

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int num1 = 999;
		int first = 0;
		String number;
		int highestPalindrome = 0;
		
		while (num1 > 0)
		{
			for (int i=999; i>1; i--)
			{
				first = i*num1;
				number = Integer.toString(first);
				
				try{
				if((number.charAt(0) == number.charAt(5)) && (number.charAt(1) == number.charAt(4)) && (number.charAt(2)) == number.charAt(3)) 
				{
					if (first > highestPalindrome)
					{
						highestPalindrome = first;
					}
				}}
			catch (Exception e){};
			}
			num1--;
		}
		System.out.println("Answer: " + highestPalindrome);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
