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
	private JButton SMButton, MIButton, DLPButton, ECCButton, TTSButton;
	private JPanel textPanel, button1Panel, button2Panel, exitPanel, button3Panel; 
	private JLabel textLabel;
	private Container container;


	public ChooseAlgorithmInterfaces() {
		super((Integer)5, (Integer)2,  new String("请选择一个算法："));
		this.initButtons();
		this.initLabel();
		this.initPanel();
		this.drawPanel();
		this.ContainerAdd();
	}
	private void initButtons(){

		buttons = new Buttons();
		SMButton = new JButton("平方乘算法");
		MIButton = new JButton("求解乘法逆元");
		DLPButton = new JButton("离散对数问题");
		ECCButton = new JButton("椭圆曲线方程");
		TTSButton = new JButton("进制转换");
		
		this.buttons.setExitButton("退出");
		
		super.getModules().setFont(DLPButton, buttons.getExitButton(), ECCButton, MIButton, SMButton, TTSButton);
		super.getModules().setButtonStyle(DLPButton, ECCButton, MIButton, SMButton, buttons.getExitButton(), TTSButton);
		
		
		MIButton.addActionListener(this);
		SMButton.addActionListener(this);
		DLPButton.addActionListener(this);
		ECCButton.addActionListener(this);
		TTSButton.addActionListener(this);
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
		button3Panel = new JPanel();
		exitPanel = new JPanel();
	}
	
	private void ContainerAdd() {
		container = new Container();
		container = getContentPane();
		container.add(textPanel);
		container.add(button1Panel);
		container.add(button2Panel);
		container.add(button3Panel);
		container.add(exitPanel);
	}
	
	private void drawPanel(){
		
		//add buttons
		textPanel.add(textLabel);
		
		button1Panel.add(MIButton);
		button1Panel.add(SMButton);
		button2Panel.add(DLPButton);
		button2Panel.add(ECCButton);
		button3Panel.add(TTSButton);
		exitPanel.add(buttons.getExitButton());
		
		super.getModules().setPanelStyle(FlowLayout.CENTER, 60, 10, textPanel, button1Panel, button2Panel, button3Panel, exitPanel);

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
		if(e.getActionCommand().equals("进制转换")){
			TurnToSystemInterface toSystemInterface = new TurnToSystemInterface(this);
			this.setVisible(false);
			this.dispose();
			toSystemInterface.setVisible(true);
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
