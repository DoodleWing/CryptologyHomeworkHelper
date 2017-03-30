package cry.chh.algorithms;

import java.math.BigInteger;

public class MultiplicativeInverse {
	private BigInteger int1, int2;

	public MultiplicativeInverse(String int1, String int2){
		this.int1 = new BigInteger(int1);
		this.int2 = new BigInteger(int2);
	}
	
	public int extendedEuclidAlgorithm() {
		Boolean f = true;
		BigInteger initialint1 = int1;
		BigInteger initialint2 = int2;		
		if (int1.compareTo(int2)<0) {
			BigInteger t = int1;
			int1 = int2;
			int2 = t;
			f = false;
		}
		
		BigInteger s0 = new BigInteger("1");
		BigInteger s1 = new BigInteger("0");
		BigInteger s2  ,  t2;
		BigInteger t0 = new BigInteger("0");
		BigInteger t1 = new BigInteger("1");
		BigInteger r2;
		BigInteger q;
		int i = 0;

		while (!(int2.equals(BigInteger.ZERO))) {
			q = int1.divide(int2);
			r2 = int1.add(q.multiply(int2).negate()) ;
			s2 = s0.add(q.multiply(s1).negate());
			t2 = t0.add(q.multiply(t1).negate());
			int1 = int2; int2 = r2;
			s0 = s1; s1 = s2;
			t0 = t1; t1 = t2;			
		}
		int s = s0.intValue(), t = t0.intValue();
		if(s < 0) s = initialint2.intValue() + s;
		if(t < 0) t = initialint2.intValue() + t;
		return f ? s : t;
	}


}
