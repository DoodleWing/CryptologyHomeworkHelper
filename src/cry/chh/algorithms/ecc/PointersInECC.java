package cry.chh.algorithms.ecc;

public class PointersInECC {
	private Integer x, y;
	public static PointersInECC ZERO = new PointersInECC(0, 0);
	
	public boolean isZERO(){
		if(this.x == 0 && this.y == 0)return true;
		else return false;
	}
	
	public PointersInECC(Integer x, Integer y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	
	public PointersInECC(){}
	
	public boolean TestTheSame(PointersInECC pointersInECC){
		boolean boolx = pointersInECC.getX() == this.x;
		boolean booly = pointersInECC.getY() == this.y;
		return boolx && booly;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	
}
