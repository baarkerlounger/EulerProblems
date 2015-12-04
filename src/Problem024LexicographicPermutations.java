import java.util.ArrayList;
import java.util.Collections;

// A permutation is an ordered arrangement of objects. 
// For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. 
// If all of the permutations are listed numerically or alphabetically, 
// we call it lexicographic order

// What is the millionth lexicographic permutation of the digits 
// 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

public class Problem024LexicographicPermutations {
	
	ArrayList<String> permutations = new ArrayList<String> ();
	
	private String getAnswer(){
		
		int numberOfElements = 10;
		int endValue = 1000000;
		int [] values = new int[]{0,1,2,3,4,5,6,7,8,9};
		
		getPermutations(values, numberOfElements, endValue - 1);		
		Collections.sort(permutations);	
		return permutations.get(endValue - 1);
	}


	private void getPermutations(int[] values, int numberOfElements, int endValue) {
		
		//Heap's Algorithm (Recursive Implementation)
		if (numberOfElements == 1){
			addPermutation(values);
			if(permutations.size() > endValue){
				return;											//Exit method if we've found enough
			}
		}else{
			for(int i=0; i<numberOfElements; i++){
				getPermutations(values, numberOfElements-1, endValue);
				if(numberOfElements%2 == 0){					//Even
					swap(values, i, numberOfElements-1);
				}else{
					swap(values, 0, numberOfElements-1);        //Odd swap first digit
				}
			}
		}
	}
	
	private void addPermutation(int[] values) {
		String permutation = Integer.toString(values[0]);
		for(Integer val=1; val<values.length; val++){
			permutation = permutation.concat(Integer.toString(values[val]));
		}	
		permutations.add(permutation);
	}

	private static void swap(int[] values, int num1, int num2)
    {
        int swapVal = values[num1];
        values[num1] = values[num2];
        values[num2] = swapVal;
    }

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		System.out.println("Answer: " + (new Problem024LexicographicPermutations().getAnswer()));
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");

	}

}
