package cry.chh.algorithms;

import java.math.BigInteger;

public class RelativelyPrime {
	private BigInteger int1, int2;
	
	public RelativelyPrime(String int1, String int2){
		this.int1 = new BigInteger(int1);
		this.int2 = new BigInteger(int2);
	}
	
	public boolean isRelativelyPrime() {
		BigInteger int3= new BigInteger  ("0");
		while (!(this.int2.equals(BigInteger.ZERO))) {
			int3 = int1.mod(int2);
			int1 = int2;
			int2 = int3;
		}
		if (int1.equals(BigInteger.ONE)) return true;
		return false;
	}
	
}