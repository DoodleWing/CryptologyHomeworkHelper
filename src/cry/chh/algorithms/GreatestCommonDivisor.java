package cry.chh.algorithms;

public class GreatestCommonDivisor {
	private Integer a, b;
	public GreatestCommonDivisor(Integer a, Integer b){
		this.a = a;
		this.b = b;
	}
	public Integer calcGCD(){
		Integer temp;
		if(a < b){
			temp = a;a = b;b = temp;
		}
		while(b != 0){
			temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
}
