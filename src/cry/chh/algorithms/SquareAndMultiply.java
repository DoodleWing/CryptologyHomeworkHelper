package cry.chh.algorithms;

public class SquareAndMultiply {
	private int Base;
	private int Index;
	private int Dividend;
	public SquareAndMultiply(int base, int index, int dividend){
		this.Base = base;
		this.Index = index;
		this.Dividend = dividend;
	}
	public void baseSetter(int base){this.Base = base;}
	public void indexSetter(int index){this.Index = index;}
	public void dividendSetter(int dividend){this.Dividend = dividend;}
	public SquareAndMultiply(){
		this.Base = 0;
		this.Index = 0;
		this.Dividend = 1;
	}
	public String TurntoBin(){
		return Integer.toBinaryString(this.Index);
	}
	public int calc(){
		String binstr = TurntoBin();
		int result = 1;
		for(int i = 0; i < binstr.length(); i++)
			if(binstr.charAt(i) == '0')result *= result % Dividend;
			else result = result * result * Base % Dividend;
		return result ;
	}
}