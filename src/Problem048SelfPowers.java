import java.math.BigInteger;

//Find the last ten digits of the result of the series 1^1 + 2^2 + 3^3 + ... + 1000^1000.

public class Problem048SelfPowers {
	
	private String getAnswer(){
		int max = 1000;
		String answer;
		BigInteger result = getSeriesResult(max);
		answer = result.toString();
		answer = answer.substring(answer.length()-10);
		return answer;
	}


	private BigInteger getSeriesResult(int max) {
		
		BigInteger seriesResult = BigInteger.valueOf(1); //1^1 = 1 (0^0 = 1 but not included in series)
		BigInteger power = BigInteger.valueOf(0);
		
		for (int i=2; i<=max; i++){
			power = getPower(BigInteger.valueOf(i*i), i, i-1);
			seriesResult = seriesResult.add(power);
		}
		return seriesResult;
	}


	private BigInteger getPower(BigInteger power, int i, int n) {
		if(n > 1){
			power = getPower(power.multiply(BigInteger.valueOf(i)), i, n-1);
		}
		return power;
	}


	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		System.out.println("Answer: " + (new Problem048SelfPowers().getAnswer()));
        long stop = System.currentTimeMillis();
        System.out.println("Time used: " + (stop - start) + "ms");

	}

}
