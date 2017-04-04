package cry.chh.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.FlowLayout;

import cry.chh.Interface.modules.Buttons;
import cry.chh.algorithms.MultiplicativeInverse;
import cry.chh.algorithms.TurnToSystems;

public class TurnToSystemInterface extends ParentInterface implements ActionListener{

	private Buttons buttons;
	private JTextField jtfbin, jtfdex, jtfhex;
	private JLabel jlbin, jldex, jlhex;
	private ChooseAlgorithmInterfaces chooseAlgorithmInterfaces;
	private JPanel binPanel, dexPanel, hexPanel, buttonsPanel;
	Container container;
	private TurnToSystems toSystems = new TurnToSystems();
	
	public TurnToSystemInterface(ChooseAlgorithmInterfaces chooseAlgorithmInterfaces) {
		super(4, 1, "进制转换");
		this.chooseAlgorithmInterfaces = chooseAlgorithmInterfaces;
		initButtons();
		initPanel();
		initTextFields();
		initTextLabels();
		drawPanel();
		ContainerAdd();
	}
	
	private void ContainerAdd() {
		container = new Container();
		container = getContentPane();
		container.add(binPanel);
		container.add(dexPanel);
		container.add(hexPanel);
		container.add(buttonsPanel);
	}
	
	private void initTextFields(){
		jtfbin = new JTextField(27);
		jtfdex = new JTextField(27);
		jtfhex = new JTextField(27);
	
		super.getModules().setFont(jtfbin, jtfdex, jtfhex);
	}
	
	private void initTextLabels(){
		jlbin = new JLabel("Bin");
		jldex = new JLabel("Dex");
		jlhex = new JLabel("Hex");
		
		super.getModules().setFont(jlbin, jldex, jlhex);
	}
	
	private void initButtons(){
		buttons = new Buttons();
		buttons.setCalcButton("转换");
		buttons.setClearButton("清空");
		buttons.setReturnButton("返回");
		buttons.setExitButton("退出");
		
		buttons.getCalcButton().addActionListener(this);
		buttons.getReturnButton().addActionListener(this);
		buttons.getExitButton().addActionListener(this);
		buttons.getClearButton().addActionListener(this);
	
		super.getModules().setFont(buttons.getCalcButton(), buttons.getClearButton(), buttons.getExitButton(), buttons.getReturnButton());
		super.getModules().setButtonStyle(buttons.getCalcButton(), buttons.getClearButton(), buttons.getExitButton(), buttons.getReturnButton());
	}
	
	private void initPanel(){
		binPanel = new JPanel();
		hexPanel = new JPanel();
		dexPanel = new JPanel();
		buttonsPanel = new JPanel();
		
		super.getModules().setPanelStyle(FlowLayout.CENTER, 10, 20, buttonsPanel);
	}
	
	private void drawPanel(){
		binPanel.add(jlbin);
		binPanel.add(jtfbin);
		
		dexPanel.add(jldex);
		dexPanel.add(jtfdex);

		hexPanel.add(jlhex);
		hexPanel.add(jtfhex);
		
		buttonsPanel.add(buttons.getCalcButton());
		buttonsPanel.add(buttons.getClearButton());
		buttonsPanel.add(buttons.getReturnButton());
		buttonsPanel.add(buttons.getExitButton());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getActionCommand().equals("转换")){
				String b = jtfbin.getText(), d = jtfdex.getText(), h = jtfhex.getText();
				String string = b + d + h;
				
				if(! b.equals("")){
					string = "0b" + string;
					toSystems.setInputstr(string);
				}
				else if(! d.equals("")){
					string = "0d" + string;
					toSystems.setInputstr(string);
				}
				else if(! h.equals("")){
					string = "0x" + string;
					toSystems.setInputstr(string);
				}
				jtfbin.setText(toSystems.TurnToBin());
				jtfdex.setText(toSystems.TurnToDex());
				jtfhex.setText(toSystems.TurnToHex());
			}
			
			if(e.getActionCommand().equals("退出")){
				this.setVisible(false);
				this.dispose();
				System.exit(0);
			}
			if(e.getActionCommand().equals("返回")){
				this.setVisible(false);
				this.dispose();
				chooseAlgorithmInterfaces.setVisible(true);
			}
			
			if(e.getActionCommand().equals("清空")){
				super.clearJTextFields(jtfbin, jtfdex, jtfhex);
			}
		}catch (Exception exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(getParent(), exc.getMessage(), "老铁，输错了……", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
