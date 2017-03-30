package cry.chh.algorithms.ecc;

import cry.chh.algorithms.GreatestCommonDivisor;
import cry.chh.algorithms.MultiplicativeInverse;

public class EllipticCurveCryptosystem {
	private Integer a, b, p;
	public EllipticCurveCryptosystem(Integer a, Integer b, Integer p){
		this.a = a;
		this.b = b;
		this.p = p;
	}
	public PointersInECC AdditionRule(PointersInECC pointersInECC1, PointersInECC pointersInECC2){		//回头记得抛异常
		if(pointersInECC1.isZERO() && pointersInECC2.isZERO())return PointersInECC.ZERO;
		if(pointersInECC1.isZERO() && !pointersInECC2.isZERO())return pointersInECC2;
		if(!pointersInECC1.isZERO() && pointersInECC2.isZERO())return pointersInECC1;
		if(!pointersInECC1.TestTheSame(pointersInECC2)){
			Integer y = pointersInECC2.getY() - pointersInECC1.getY();
			Integer x = pointersInECC2.getX() - pointersInECC1.getX();
			Integer gcd = new GreatestCommonDivisor(y, x).calcGCD();
			y /= gcd; x /= gcd;
			x = (Integer)new MultiplicativeInverse(x.toString(), this.p.toString()).extendedEuclidAlgorithm();
			Integer lambda = y * x % this.p;
			x = (lambda * lambda - pointersInECC1.getX() - pointersInECC2.getX()) % p; if(x < 0) x+= this.p;
			y = (lambda * (pointersInECC1.getX() - x) - pointersInECC1.getY()) % p; if(y < 0) y+= this.p;
			PointersInECC pointersInECC3 = new PointersInECC(x, y);
			return pointersInECC3;
		}
		else{
			Integer y = 3 * pointersInECC1.getX() * pointersInECC1.getX() + this.a;
			Integer x = 2 * pointersInECC1.getY();
			Integer gcd = new GreatestCommonDivisor(y, x).calcGCD();
			y /= gcd; x /= gcd;
			x = (Integer)new MultiplicativeInverse(x.toString(), this.p.toString()).extendedEuclidAlgorithm();
			Integer lambda = y * x % this.p;
			x = (lambda * lambda - 2 * pointersInECC1.getX()) % this.p; if(x < 0) x+= this.p;
			y = (lambda * (pointersInECC1.getX() - x) - pointersInECC1.getY()) % this.p; if(y < 0) y+= this.p;
			PointersInECC pointersInECC3 = new PointersInECC(x, y);
			return pointersInECC3;
		}
	}
	
	public PointersInECC DoubleAndAddAlgorithm(Integer d, PointersInECC P){		//回头记得抛异常
		String binstr = Integer.toBinaryString(d);
		PointersInECC result = new PointersInECC(0, 0);
		for(int i = 0; i < binstr.length(); i++)
			if(binstr.charAt(i) == '0')result = AdditionRule(result, result);
			else result = AdditionRule(AdditionRule(result, result), P);
		return result;
	}
}
