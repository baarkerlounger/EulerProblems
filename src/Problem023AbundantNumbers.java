import java.util.ArrayList;
import java.util.HashSet;

//Find the sum of all integers that cannot be written as the sum of two abundant
//numbers

public class Problem023AbundantNumbers {
	
	static int lowerLimit = 12;
	static int upperLimit = 28123;
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int totalSum = 0;
		ArrayList<Integer> abundant = new ArrayList<Integer>();
		
		abundant = getAllAbundantNumbers(lowerLimit, upperLimit);
		totalSum = getTotalSumInLimit(upperLimit);
		totalSum = removeSumsOfAbundantNumberPairs(abundant, totalSum);
		
		System.out.println("Answer: " + totalSum);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
		
	}

	private static int getTotalSumInLimit (int upperLimit) {
		
		int totalSum = 0;
		for(int e=1; e<upperLimit; e++){
			totalSum = totalSum + e;
		}
		return totalSum;
	}

	private static int removeSumsOfAbundantNumberPairs(ArrayList<Integer> abundant, int totalSum) {
		
		int sum = 0;
		//HashSet for constant time performance - approx 2.5mins faster than ArrayList
		HashSet<Integer> numbersRemoved = new HashSet<Integer>();
		
		for(int k=0; k<abundant.size(); k++){
			for(int l=0; l<abundant.size(); l++){
				sum = abundant.get(k)+abundant.get(l);
				if((sum < upperLimit)&&(!numbersRemoved.contains(sum))){
					totalSum = totalSum - sum;
					numbersRemoved.add(sum);
				}else{
					continue;
				}
			}
		}
		return totalSum;
	}

	private static ArrayList<Integer> getAllAbundantNumbers(int lowerLimit, int upperLimit) {
		
		ArrayList<Integer> abundant = new ArrayList<Integer>();
		for(int i=lowerLimit; i<upperLimit; i++){
			if(checkIfAbundant(i)){
				abundant.add(i);
			}
		}
		return abundant;
	}

	private static boolean checkIfAbundant(int i) {

		int sumDivisors = getSumDivisors(i);
		if(sumDivisors > i){
			return true;
		}else{
			return false;
		}
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

}
