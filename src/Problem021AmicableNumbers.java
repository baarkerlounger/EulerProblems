import java.util.ArrayList;

//  If the Sum of the proper Divisors of A are equal to B and the sum of the
//  proper Divisors of B are equal to A, then A and B are amicable if they are not equal.
	
//  Evaluate the sum of all the amicable numbers under 10000.

public class Problem021AmicableNumbers {
	
	//Constructor
	public Problem021AmicableNumbers(){
	}
	
	private int getAnswer(){
		
		int upperLimit = 1000000;
		int sumDivisors = 0;
		int totalSum = 0;
		ArrayList<Integer> all = new ArrayList<Integer> ();
		ArrayList<Integer> amicable = new ArrayList<Integer> ();
		
		for (int i=0; i<upperLimit; i++){
			sumDivisors = getSumDivisors(i);
			all.add(i, sumDivisors);
		}
		for (int j=0; j<all.size(); j++){
			for (int l=0; l<all.size(); l++){
				if((all.get(l) == j) && (all.get(j) == l) && (l != j) && (!amicable.contains(l))){
					amicable.add(l);
					amicable.add(j);
				}
			}
		}
		for (int k=0; k<amicable.size(); k++){
			totalSum = totalSum + amicable.get(k);
		}
		return totalSum;	
	}
	
	private static int getSumDivisors(int i) {
		
		if(i==1 || i==0){
			return 0;
		}
		
		int sumDivisors = 1;
		double sqrt = Math.sqrt(i);
		
		for(int j=2; j<sqrt; j++){ //Iterate through lower half of factors (not including sqrt
								   //so that it isn't counted twice)
			if(i%j == 0){
				sumDivisors = sumDivisors + j;
				sumDivisors = sumDivisors + (i/j); //Add second half of factor pair
			}
		}
		if (i%sqrt == 0){ //Check if square root is a divisor and add if so
			sumDivisors = sumDivisors + (int)sqrt;
		}
		return sumDivisors;
		
	}
	
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		System.out.println("Answer: " + (new Problem021AmicableNumbers().getAnswer()));
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");

	}

}
