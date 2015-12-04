import java.math.BigInteger;

//  Starting in the top left corner of a 2×2 grid, and only being able to move 
//  to the right and down, there are exactly 6 routes to the bottom right corner.
//  How many such routes are there through a 20×20 grid?

public class Problem015LatticePaths {
	
// Essential finding 40!/(20!20!) because a 20x20 grid has 40 total steps to get to 
// the bottom corner of which there are 20 possible steps down and 20 possible steps
// right (order is unimportant)

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();

		int gridSizeX = 20;
		int gridSizeY = 20;
		
		int totalSteps = gridSizeX+gridSizeY;
		
		BigInteger numberOfRoutes = calculateFactorial(totalSteps).divide(calculateFactorial(gridSizeX).multiply(calculateFactorial(gridSizeY)));
		
		System.out.println("Answer: " + numberOfRoutes);
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");		
	}
	
	public static BigInteger calculateFactorial(int num){
		
		BigInteger result = BigInteger.ONE;
		for (int i=num; i>0; i--){
			
			result = result.multiply(BigInteger.valueOf(i));
		}
		return result;
	}

}
