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
	private JButton clearequationButton;
	private JPanel equationPanel, calc1Panel, buttonPanel, calc2Panel;
	private JLabel spaceLabel, leftbracketLabel1, leftbracketLabel2, rpl, rightbracketLabel1, rightbracketLabel2, rel, rightbracketLabel3, aLabel, bLabel, pLabel, com1Label, com2Label, com3Label, com4Label, com5Label, mulLabel, equalLabel;
	private JTextField jtfa, jtfb, jtfp, jtfx1, jtfy1, jtfn, jtfcx1, jtfcy1, jtfx2, jtfy2, jtfx3, jtfy3, jtfcx2, jtfcy2;
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
		container.add(calc1Panel);
		container.add(calc2Panel);
		container.add(buttonPanel);
	}
	
	private void initTextLabel(){
		aLabel = new JLabel("a = ");
		bLabel = new JLabel("    b = ");
		pLabel = new JLabel("    p = ");
		spaceLabel = new JLabel("     ");
		leftbracketLabel1 = new JLabel(" ( ");
		rightbracketLabel1 = new JLabel(" ) ");
		rightbracketLabel2 = new JLabel(" ) ");
		com1Label = new JLabel(" , ");
		com2Label = new JLabel(" , ");
		com3Label = new JLabel(" , ");
		com4Label = new JLabel(" , ");
		com5Label = new JLabel(" , ");
		mulLabel = new JLabel(" * ( ");
		equalLabel = new JLabel(" = ");
		leftbracketLabel2 = new JLabel(" ( ");
		rpl = new JLabel(" ) + ( ");
		rel = new JLabel(" ) = ( ");
		rightbracketLabel3 = new JLabel(" ) ");
		super.getModules().setFont(spaceLabel, leftbracketLabel1, leftbracketLabel2, rpl, rightbracketLabel1, rightbracketLabel2, rel, rightbracketLabel3, aLabel, bLabel, pLabel, com1Label, com2Label, com3Label, com4Label, com5Label, mulLabel, equalLabel);
	}
	
	private void initButton(){
		buttons = new Buttons();
		clearequationButton = new JButton("重置方程");
		buttons.setCalcButton("计算");
		buttons.setReturnButton("返回");
		buttons.setExitButton("退出");
		buttons.setClearButton("清空");
		clearequationButton.addActionListener(this);
		buttons.getCalcButton().addActionListener(this);
		buttons.getReturnButton().addActionListener(this);
		buttons.getExitButton().addActionListener(this);
		buttons.getClearButton().addActionListener(this);
		
		super.getModules().setFont(buttons.getCalcButton(), buttons.getReturnButton(), buttons.getExitButton(), buttons.getClearButton(), clearequationButton);
		super.getModules().setButtonStyle(buttons.getCalcButton(), buttons.getReturnButton(), buttons.getExitButton(), buttons.getClearButton(), clearequationButton);
	}
	
	private void initTextField(){
		jtfa = new JTextField(3);
		jtfb = new JTextField(3);
		jtfp = new JTextField(3);
		jtfn = new JTextField(3);
		jtfx1 = new JTextField(3);
		jtfx2 = new JTextField(3);
		jtfx3 = new JTextField(3);
		jtfy1 = new JTextField(3);
		jtfy2 = new JTextField(3);
		jtfy3 = new JTextField(3);
		jtfcx1 = new JTextField(3);
		jtfcy1 = new JTextField(3);
		jtfcx2 = new JTextField(3);
		jtfcy2 = new JTextField(3);
		
		super.getModules().setFont(jtfa, jtfb, jtfp, jtfn, jtfx1, jtfy1, jtfcx1, jtfcy1, jtfx2, jtfx3, jtfy2, jtfy3, jtfcx2, jtfcy2);
	}
	
	private void initPanel(){
		equationPanel = new JPanel();
		calc1Panel = new JPanel();
		calc2Panel = new JPanel();
		buttonPanel = new JPanel();
		
		super.getModules().setPanelStyle(FlowLayout.CENTER, 10, 30, buttonPanel);
		super.getModules().setPanelStyle(FlowLayout.CENTER, 0, 30, equationPanel, calc1Panel, calc2Panel);
	}
	
	private void drawPanel(){
	
		equationPanel.add(aLabel);
		equationPanel.add( jtfa);
		equationPanel.add(bLabel);
		equationPanel.add(jtfb);
		equationPanel.add(pLabel);
		equationPanel.add(jtfp);
		equationPanel.add(spaceLabel);
		equationPanel.add(clearequationButton);
	
		calc1Panel.add(jtfn);
		calc1Panel.add(mulLabel);
		calc1Panel.add(jtfx1);
		calc1Panel.add(com1Label);
		calc1Panel.add(jtfy1);
		calc1Panel.add(rightbracketLabel1);
		calc1Panel.add(equalLabel);
		calc1Panel.add(leftbracketLabel1);
		calc1Panel.add(jtfcx1);
		calc1Panel.add(com2Label);
		calc1Panel.add(jtfcy1);
		calc1Panel.add(rightbracketLabel2);
		
		calc2Panel.add(leftbracketLabel2);
		calc2Panel.add(jtfx2);
		calc2Panel.add(com3Label);
		calc2Panel.add(jtfy2);
		calc2Panel.add(rpl);
		calc2Panel.add(jtfx3);
		calc2Panel.add(com4Label);
		calc2Panel.add(jtfy3);
		calc2Panel.add(rel);
		calc2Panel.add(jtfcx2);
		calc2Panel.add(com5Label);
		calc2Panel.add(jtfcy2);
		calc2Panel.add(rightbracketLabel3);
		
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
				EllipticCurveCryptosystem ellipticCurveCryptosystem = new EllipticCurveCryptosystem(new Integer(jtfa.getText()), new Integer(jtfb.getText()), new Integer(jtfp.getText()));
				if(!jtfx1.getText().equals("") && !jtfy1.getText().equals("") && !jtfn.getText().equals("")){
					PointersInECC result = ellipticCurveCryptosystem.DoubleAndAddAlgorithm(new Integer(jtfn.getText()), new PointersInECC(new Integer(jtfx1.getText()), new Integer(jtfy1.getText())));
					jtfcx1.setText(result.getX().toString());
					jtfcy1.setText(result.getY().toString());
				}
				else if(!jtfx2.getText().equals("") && !jtfy2.getText().equals("") && !jtfx3.getText().equals("") && !jtfy3.getText().equals("")){
					PointersInECC result = ellipticCurveCryptosystem.AdditionRule(new PointersInECC(new Integer(jtfx2.getText()), new Integer(jtfy2.getText())), new PointersInECC(new Integer(jtfx3.getText()), new Integer(jtfy3.getText())));
					jtfcx2.setText(result.getX().toString());
					jtfcy2.setText(result.getY().toString());
				}
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
				super.clearJTextFields( jtfx1, jtfy1, jtfn, jtfcx1, jtfcy1, jtfx2, jtfy2, jtfx3, jtfy3, jtfcx2, jtfcy2);
			}
			if(e.getActionCommand().equals("重置方程")){
				super.clearJTextFields(jtfa, jtfb, jtfp);
			}
		}catch (Exception exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(getParent(), exc.getMessage(), "老铁，输错了……", JOptionPane.ERROR_MESSAGE);
		}
			
	}
}
