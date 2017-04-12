package cry.chh.Interface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextField;

import cry.chh.Interface.modules.Modules;

public class ParentInterface extends JFrame{
	private static Integer screenWidth, screenHeight, rows, columns;
	private Modules modules;
	
	static{
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		screenHeight = screenSize.height;
		screenWidth = screenSize.width;
	}

	public void setRowsColumns(Integer a, Integer b){
		rows = a; 
		columns = b;
	}
	
	public ParentInterface(Integer r, Integer c, String titlestr) {
		modules = new Modules();
		this.setTitle("密码学作业助手");
		this.setSize((int)(screenWidth / 3.5), screenHeight / 3);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setRowsColumns(r, c);
		this.setLayout(new GridLayout(rows,	columns));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void clearJTextFields(JTextField...fields){
		for(int i = 0; i < fields.length; i++){
			fields[i].setText("");
		}
	}
	
	public Modules getModules() {
		return modules;
	}

}