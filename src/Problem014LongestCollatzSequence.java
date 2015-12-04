
public class Problem014LongestCollatzSequence{
	
//  The following iterative sequence is defined for the set of positive integers:
//  n → n/2 (n is even)
//  n → 3n + 1 (n is odd)
//  Which starting number, under one million, produces the longest chain?

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		int seqLength = 0;
		int maxSeqLength = 0;
		long maxNum = 0;
		long num = 0;
		
		for (long i=2; i<1000000; i++){
		
			num = i;
			
			while(!(num == 1)){
		
				if (num%2 == 0){
					
					num = (num/2);
					seqLength++;
				}
		
				else {
			
					num = ((3*num)+1);
					seqLength++;
				}
				
				if (num == maxNum){
					seqLength = (seqLength + maxSeqLength);
					num = 1;
				}
			}
			
			if (seqLength > maxSeqLength){
				
				maxSeqLength = seqLength;
				maxNum = i;
			}
			
			seqLength = 0;
		}
		System.out.println("Answer: ");
		System.out.println("The number producing the longest chain is " + maxNum);
		System.out.println("Chain length: " + maxSeqLength);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");
		
	}
}
