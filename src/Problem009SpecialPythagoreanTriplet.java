public class Problem009SpecialPythagoreanTriplet {
	
//  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//	Find the product abc.

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		int tripletSum = 1000;
		int a = 1, b = 1, c = 1;
		
		while ((a<(tripletSum)))
		{
			for (b = 1; (b)<(tripletSum); b++)
			{
				for (c = 1; (c)<(tripletSum); c++)
				{
					if( (((a*a)+(b*b)) == (c*c)) && (a<b) )
					{
						if((a+b+c) == tripletSum)
						{
							System.out.println("Answer: " + a+"^2 + "+b+"^2 = "+c+"^2");
							System.out.println("The product abc is: "+(a*b*c));
					        long stop = System.currentTimeMillis();
					        System.out.println("Time used: " + (stop - start) + "ms");
							break;
						}
					}
				}
			}
			a++;
		}

	}

}
