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
import cry.chh.algorithms.MultiplicativeInverse;
import cry.chh.algorithms.ecc.EllipticCurveCryptosystem;
import cry.chh.algorithms.ecc.PointersInECC;

public class MultiplicativeInverseInterface extends ParentInterface implements ActionListener{
	
	private JTextField jtfa, jtfx, jtfp;
	private JLabel coresidual, left, right, xequal;
	private Buttons buttons;
	private JPanel inPanel, outPanel, buttonPanel;
	private Container container;
	private ChooseAlgorithmInterfaces chooseAlgorithmInterfaces;
	
	public MultiplicativeInverseInterface(ChooseAlgorithmInterfaces chooseAlgorithmInterfaces) {
		super(3, 1, "求解乘法逆元");
		this.initButton();
		this.initLabel();
		this.initPanel();
		this.initTextField();
		this.drawPanel();
		this.ContainerAdd();
		this.chooseAlgorithmInterfaces = chooseAlgorithmInterfaces;
	}
	
	private void initLabel(){
		coresidual = new JLabel("≡");
		left = new JLabel("x ^ -1 ( mod ");
		right = new JLabel(" )");
		xequal = new JLabel("x = ");
		
		super.getModules().setFont(coresidual, left, right, xequal);
	}
	
	private void ContainerAdd() {
		container = new Container();
		container = getContentPane();
		container.add(inPanel);
		container.add(outPanel);
		container.add(buttonPanel);
	}
	
	private void initButton(){
		buttons = new Buttons();
		buttons.setCalcButton("计算");
		buttons.setReturnButton("返回");
		buttons.setExitButton("退出");
		
		super.getModules().setFont(buttons.getCalcButton(), buttons.getReturnButton(), buttons.getExitButton());
		
		buttons.getCalcButton().addActionListener(this);
		buttons.getReturnButton().addActionListener(this);
		buttons.getExitButton().addActionListener(this);
	}
	
	private void initTextField(){
		jtfa = new JTextField(4);
		jtfx = new JTextField(4);
		jtfp = new JTextField(4);
		
		super.getModules().setFont(jtfa, jtfx, jtfp);
	}
	
	private void initPanel(){
		buttonPanel = new JPanel();
		inPanel = new JPanel();
		outPanel = new JPanel();
		
		super.getModules().setPanelStyle(FlowLayout.CENTER, 0, 10, inPanel, outPanel);
		super.getModules().setPanelStyle(FlowLayout.CENTER, 60, 10, buttonPanel);
	}
	
	private void drawPanel(){
		buttonPanel.add(buttons.getCalcButton());
		buttonPanel.add(buttons.getReturnButton());
		buttonPanel.add(buttons.getExitButton());
		
		inPanel.add(jtfa);
		inPanel.add(coresidual);
		inPanel.add(left);
		inPanel.add(jtfp);
		inPanel.add(right);
		
		outPanel.add(xequal);
		outPanel.add(jtfx);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		try{
			if(e.getActionCommand().equals("计算")){
				Integer x = new MultiplicativeInverse(jtfa.getText(), jtfp.getText()).extendedEuclidAlgorithm();
				jtfx.setText(x.toString());
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
		}catch (Exception exc) {
			exc.printStackTrace();
			JOptionPane.showMessageDialog(getParent(), exc.getMessage(), "老铁，输错了……", JOptionPane.ERROR_MESSAGE);
		}
			
		
	}

}
