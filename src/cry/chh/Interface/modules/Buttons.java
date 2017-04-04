package cry.chh.Interface.modules;

import javax.swing.JButton;

public class Buttons {
	private JButton calcButton, exitButton, returnButton, clearButton;
	public Buttons(){
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
	public JButton getReturnButton() {
		return returnButton;
	}
	public void setReturnButton(String string){
		this.returnButton = new JButton(string);
	}
	public JButton getClearButton() {
		return clearButton;
	}
	public void setClearButton(String string) {
		this.clearButton = new JButton(string);
	}
}
