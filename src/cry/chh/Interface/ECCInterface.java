package cry.chh.Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cry.chh.Interface.modules.Buttons;
import cry.chh.algorithms.ecc.EllipticCurveCryptosystem;
import cry.chh.algorithms.ecc.PointersInECC;


public class ECCInterface extends ParentInterface implements ActionListener{

	private Buttons buttons;
	private JPanel equationPanel, calcPanel, buttonPanel;
	private JLabel leftbracketLabel, rightbracketLabel1, rightbracketLabel2, aLabel, bLabel, pLabel, com1Label, com2Label, mulLabel, equalLabel;
	private JTextField jtfa, jtfb, jtfp, jtfx, jtfy, jtfn, jtfcx, jtfcy;
	private Container container;
	private ChooseAlgorithmInterfaces chooseAlgorithmInterfaces;
	
	public ECCInterface(ChooseAlgorithmInterfaces chooseAlgorithmInterfaces) {
		super((Integer)4, (Integer)1, new String("椭圆曲线算法"));
		this.initButton();
		this.initPanel();
		this.initTextField();
		this.initTextLabel();
		this.drawPanel();
		this.ContainerAdd();
		this.chooseAlgorithmInterfaces = chooseAlgorithmInterfaces;
	}
	
	private void ContainerAdd() {
		container = new Container();
		container = getContentPane();
		container.add(equationPanel);
		container.add(calcPanel);
		container.add(buttonPanel);
	}
	
	private void initTextLabel(){
		aLabel = new JLabel("a = ");
		bLabel = new JLabel("    b = ");
		pLabel = new JLabel("    p = ");
		leftbracketLabel = new JLabel(" ( ");
		rightbracketLabel1 = new JLabel(" ) ");
		rightbracketLabel2 = new JLabel(" ) ");
		com1Label = new JLabel(" , ");
		com2Label = new JLabel(" , ");
		mulLabel = new JLabel(" * ( ");
		equalLabel = new JLabel(" = ");
		
		super.getModules().setFont(aLabel, bLabel, pLabel, leftbracketLabel, rightbracketLabel1, rightbracketLabel2, com1Label, com2Label, mulLabel, equalLabel);
	}
	
	private void initButton(){
		buttons = new Buttons();
		buttons.setCalcButton("计算");
		buttons.setReturnButton("返回");
		buttons.setExitButton("退出");
		buttons.setClearButton("清空");
		buttons.getCalcButton().addActionListener(this);
		buttons.getReturnButton().addActionListener(this);
		buttons.getExitButton().addActionListener(this);
		buttons.getClearButton().addActionListener(this);
		
		super.getModules().setFont(buttons.getCalcButton(), buttons.getReturnButton(), buttons.getExitButton(), buttons.getClearButton());
		super.getModules().setButtonStyle(buttons.getCalcButton(), buttons.getReturnButton(), buttons.getExitButton(), buttons.getClearButton());
	}
	
	private void initTextField(){
		jtfa = new JTextField(3);
		jtfb = new JTextField(3);
		jtfp = new JTextField(3);
		jtfn = new JTextField(3);
		jtfx = new JTextField(3);
		jtfy = new JTextField(3);
		jtfcx = new JTextField(3);
		jtfcy = new JTextField(3);
		
		super.getModules().setFont(jtfa, jtfb, jtfp, jtfn, jtfx, jtfy, jtfcx, jtfcy);
	}
	
	private void initPanel(){
		equationPanel = new JPanel();
		calcPanel = new JPanel();
		buttonPanel = new JPanel();
		
		super.getModules().setPanelStyle(FlowLayout.CENTER, 10, 30, buttonPanel);
		super.getModules().setPanelStyle(FlowLayout.CENTER, 0, 30, equationPanel, calcPanel);
	}
	
	private void drawPanel(){
	
		equationPanel.add(aLabel);
		equationPanel.add( jtfa);
		equationPanel.add(bLabel);
		equationPanel.add(jtfb);
		equationPanel.add(pLabel);
		equationPanel.add(jtfp);
	
		calcPanel.add(jtfn);
		calcPanel.add(mulLabel);
		calcPanel.add(jtfx);
		calcPanel.add(com1Label);
		calcPanel.add(jtfy);
		calcPanel.add(rightbracketLabel1);
		calcPanel.add(equalLabel);
		calcPanel.add(leftbracketLabel);
		calcPanel.add(jtfcx);
		calcPanel.add(com2Label);
		calcPanel.add(jtfcy);
		calcPanel.add(rightbracketLabel2);
		
		buttonPanel.add(buttons.getCalcButton());
		buttonPanel.add(buttons.getClearButton());
		buttonPanel.add(buttons.getReturnButton());
		buttonPanel.add(buttons.getExitButton());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getActionCommand().equals("计算")){
				ECCInterface eccInterface = new ECCInterface(null);
				PointersInECC result = new EllipticCurveCryptosystem(new Integer(jtfa.getText()), new Integer(jtfb.getText()), new Integer(jtfp.getText())).DoubleAndAddAlgorithm(new Integer(jtfn.getText()), new PointersInECC(new Integer(jtfx.getText()), new Integer(jtfy.getText())));
				jtfcx.setText(result.getX().toString());
				jtfcy.setText(result.getY().toString());
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
				super.clearJTextFields(jtfa, jtfb, jtfcx, jtfcy, jtfn, jtfp, jtfx, jtfy);
			}
		}catch (Exception exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(getParent(), exc.getMessage(), "老铁，输错了……", JOptionPane.ERROR_MESSAGE);
		}
			
	}
}
