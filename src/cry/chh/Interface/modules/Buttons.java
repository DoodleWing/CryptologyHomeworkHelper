package cry.chh.Interface.modules;

import javax.swing.JButton;

public class Buttons {
	private JButton MulInverseButton, SMButton, CRTButton, DLPButton, ECCButton;
	private JButton calcButton, exitButton, returnButton;
	public Buttons(){
	}
	public JButton getMulInverseButton() {
		return MulInverseButton;
	}
	public void setMulInverseButton(String string) {
		MulInverseButton = new JButton(string);
	}
	public JButton getSMButton() {
		return SMButton;
	}
	public void setSMButton(String string) {
		SMButton = new JButton(string);
	}
	public JButton getCRTButton() {
		return CRTButton;
	}
	public void setCRTButton(String string) {
		CRTButton = new JButton(string);
	}
	public JButton getDLPButton() {
		return DLPButton;
	}
	public void setDLPButton(String string) {
		DLPButton = new JButton(string);
	}
	public JButton getCalcButton() {
		return calcButton;
	}
	public void setCalcButton(String string) {
		this.calcButton = new JButton(string);
	}
	public JButton getExitButton() {
		return exitButton;
	}
	public void setExitButton(String string) {
		this.exitButton = new JButton(string);
	}
	public JButton getECCButton() {
		return ECCButton;
	}
	public void setECCButton(String string) {
		ECCButton = new JButton(string);
	}
	public JButton getReturnButton() {
		return returnButton;
	}
	public void setReturnButton(String string){
		this.returnButton = new JButton(string);
	}
}
