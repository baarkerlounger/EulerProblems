// If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there 
// are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
// If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
// how many letters would be used?

// NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
//contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of 
//"and" when writing out numbers is in compliance with British usage.


public class Problem017NumberLetterCounts {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int one = 3, two = 3, three = 5, four = 4, five = 4, six = 3, seven = 5, eight = 5, nine = 4;
		int ten = 3, eleven = 6, twelve = 6, thirteen = 8, fourteen = 8, fifteen = 7, sixteen = 7, seventeen = 9, eighteen = 8, nineteen = 8;
		int twenty = 6, thirty = 6, forty = 5, fifty = 5, sixty = 5, seventy = 7, eighty = 6, ninety = 6;
		int hundred = 7, HundredAnd = 10, oneThousand = 11;
		
		int singles = one + two + three + four + five + six + seven + eight + nine;
		int tenTo19 = ten + eleven + twelve + thirteen + fourteen + fifteen + sixteen + seventeen + eighteen + nineteen;
		int oneTo99 = singles + tenTo19 + 8*singles + 10* (twenty + thirty + forty + fifty + sixty + seventy + eighty + ninety);
		int hundredTo1000 = (100 * singles) + (891 * HundredAnd) + (9 * oneTo99) + oneThousand  + (9 * hundred);
		int oneTo1000 = oneTo99 + hundredTo1000;

		System.out.println("Answer: " + oneTo1000);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
	}

}
