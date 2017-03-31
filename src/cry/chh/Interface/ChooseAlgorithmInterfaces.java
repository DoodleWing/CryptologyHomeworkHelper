package cry.chh.Interface;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cry.chh.Interface.modules.Buttons;

public class ChooseAlgorithmInterfaces extends ParentInterface implements ActionListener{
	
	private Buttons buttons;
	private JPanel textPanel, button1Panel, button2Panel, exitPanel; 
	private JLabel textLabel;
	private Container container;


	public ChooseAlgorithmInterfaces() {		//构造器
		super((Integer)4, (Integer)2,  new String("请选择一个算法："));
		this.initButtons();
		this.initLabel();
		this.initPanel();
		this.drawPanel();
		this.ContainerAdd();
	}
	private void initButtons(){		//初始化Buttons

		this.buttons = new Buttons();
		this.buttons.setSMButton("平方乘算法");
		this.buttons.setMulInverseButton("求解乘法逆元");
		this.buttons.setDLPButton("离散对数问题");
		this.buttons.setECCButton("椭圆曲线方程");
		this.buttons.setExitButton("退出");
		
		super.getModules().setFont(buttons.getDLPButton(), buttons.getExitButton(), buttons.getECCButton(), buttons.getMulInverseButton(), buttons.getSMButton());
		super.getModules().setButtonStyle(buttons.getDLPButton(), buttons.getECCButton(), buttons.getMulInverseButton(), buttons.getSMButton(), buttons.getExitButton());
		
		
		buttons.getMulInverseButton().addActionListener(this);
		buttons.getSMButton().addActionListener(this);
		buttons.getDLPButton().addActionListener(this);
		buttons.getECCButton().addActionListener(this);
		buttons.getExitButton().addActionListener(this);
	}
	
	private void initLabel(){		//初始化Label
		textLabel = new JLabel("请选择一个算法");
		super.getModules().setFont(textLabel);
	}
	
	private void initPanel(){		//初始化Panel
		textPanel = new JPanel();
		button1Panel = new JPanel();
		button2Panel = new JPanel();
		exitPanel = new JPanel();
	}
	
	private void ContainerAdd() {
		container = new Container();
		container = getContentPane();
		container.add(textPanel);
		container.add(button1Panel);
		container.add(button2Panel);
		container.add(exitPanel);
	}
	
	private void drawPanel(){
		
		//add buttons
		textPanel.add(textLabel);
		
		button1Panel.add(buttons.getMulInverseButton());
		button1Panel.add(buttons.getSMButton());
		button2Panel.add(buttons.getDLPButton());
		button2Panel.add(buttons.getECCButton());
		exitPanel.add(buttons.getExitButton());
		
		super.getModules().setPanelStyle(FlowLayout.CENTER, 60, 10, textPanel, button1Panel, button2Panel, exitPanel);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("平方乘算法")){
			JOptionPane.showMessageDialog(getParent(), "平方乘算法");
		}
		if(e.getActionCommand().equals("求解乘法逆元")){
			MultiplicativeInverseInterface multiplicativeInverseInterface = new MultiplicativeInverseInterface(this);
			this.setVisible(false);
			this.dispose();
			multiplicativeInverseInterface.setVisible(true);
		}
		if(e.getActionCommand().equals("离散对数问题")){
			JOptionPane.showMessageDialog(getParent(), "离散对数问题");
		}
		if(e.getActionCommand().equals("椭圆曲线方程")){
			ECCInterface eccInterface = new ECCInterface(this);
			this.setVisible(false);
			this.dispose();
			eccInterface.setVisible(true);
		}
		if(e.getActionCommand().equals("退出")){
			this.setVisible(false);
			this.dispose();
			System.exit(0);
		}
		
	}
	
	public static void main(String[] args) {
		ChooseAlgorithmInterfaces chooseFunctionInterface = new ChooseAlgorithmInterfaces();
		chooseFunctionInterface.setVisible(true);
	}
	
}
