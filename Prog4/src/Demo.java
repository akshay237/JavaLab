import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Demo implements ActionListener{
	JFrame f;
	JRadioButton j1;
	JRadioButton j2;
	JRadioButton j3;
	Demo(){
		f=new JFrame();
		 j1=new JRadioButton("Red");
		j1.setBounds(75, 100, 100, 30);
		j1.setBackground(Color.red);
		j2=new JRadioButton("Yellow");
		j2.setBounds(75, 75, 100, 30);
		j2.setBackground(Color.yellow);
		j3=new JRadioButton("Green");
		j3.setBounds(75, 50, 100, 30);
		j3.setBackground(Color.green);
		JButton submit =new JButton("Submit");
		submit.setBounds(85,150,100,30);
		submit.addActionListener(this);
		ButtonGroup bg=new ButtonGroup();
		bg.add(j1);
		bg.add(j2);
		bg.add(j3);
		bg.add(submit);
		f.add(j1);
		f.add(j2);
		f.add(j3);
		f.add(submit);
		f.setSize(300,300);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public static void main(String args[]) {
		new Demo();
	}

	
	public void actionPerformed(ActionEvent e) {
		if (j1.isSelected()) {
			f.setBackground(Color.red);
			JOptionPane.showMessageDialog(f, "Stop", null, 0,null);
		}
		if(j2.isSelected()) {
			JOptionPane.showMessageDialog(f, "Be ready", null, 0);
		}
		if(j3.isSelected()) {
			JOptionPane.showMessageDialog(f, "Go", null, 0);
		}
	}
}