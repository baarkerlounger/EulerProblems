import java.util.ArrayList;

//  If the Sum of the proper Divisors of A are equal to B and the sum of the
//  proper Divisors of B are equal to A, then A and B are amicable if they are not equal.

//Find the smallest member of the longest amicable chain with no element exceeding one million.

public class Problem095AmicablePairChains {
	
	private static final int maxValue = 1000000;
	private static ArrayList<Integer> chain = new ArrayList<Integer>();
	private static ArrayList<Integer> maxChain = new ArrayList<Integer>();
	
	private int getAnswer(){
		
		ArrayList<Integer> chain = new ArrayList<Integer>();
		
		for(int i = 220; i<maxValue; i++){
			chain.clear();
			chain = checkChain(i);
			if (chain.size() > maxChain.size()){
				maxChain.clear();
				maxChain.addAll(chain);
			}
		}
		return maxChain.get(0);
	}
	
	private ArrayList<Integer> checkChain(int i) {

		if(chain.isEmpty()){
			chain.add(i);
		}
		if(maxChain.contains(i)){
			chain.clear();
			return chain;
		}
		int sumDivisors = getSumDivisors(i);
		if((sumDivisors > maxValue) || (sumDivisors == 1) || (sumDivisors == 0)){ 
			chain.clear();
			return chain;
		}else if(chain.get(0) == sumDivisors){	//Chain has returned
			return chain;			
		}else if(chain.contains(sumDivisors)){  //Chain won't return
			chain.clear();
			return chain;
		}else{									//Chain not complete yet
			chain.add(sumDivisors);
		}
		checkChain(sumDivisors);
		return chain;
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
		System.out.println("Answer: " + (new Problem095AmicablePairChains().getAnswer()));
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");

	}

}
