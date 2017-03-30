package cry.chh.Interface.modules;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Modules {
	private static final Font font = new Font("等线", Font.BOLD, 16);
	private FlowLayout flowLayout;
	private static Dimension dimension = new Dimension(130, 30);
	
	public Modules(){
		flowLayout = new FlowLayout();
	}
	
	public void setFont(JLabel...jLabels ){
		for(int i = 0; i < jLabels.length; i++)jLabels[i].setFont(font);
	}
	
	public void setFont(JTextField...jTextFields){
		for(int i = 0; i < jTextFields.length; i++)jTextFields[i].setFont(font);
	}
	
	public void setFont(JButton...jButtons){
		for(int i = 0; i < jButtons.length; i++)jButtons[i].setFont(font);
	}
	
	public void setButtonStyle(JButton...jButtons){
		for(int i = 0; i < jButtons.length; i++)jButtons[i].setPreferredSize(dimension);
	}
	
	public void setPanelStyle(int flowlayoutint, int width, int height, JPanel... jPanels){
		for(int i = 0; i < jPanels.length; i++)jPanels[i].setLayout(new FlowLayout(flowlayoutint, width, height));
	}
	
	public Font getFont() {
		return font;
	}


	
}
