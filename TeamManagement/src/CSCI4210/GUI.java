package CSCI4210;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	JFrame frame;
	JPanel panel;
	JLabel label;
	
	public GUI()  {
		 frame = new JFrame();
		JButton button = new JButton("TESTing");
		button.setBounds(0,0, 1, 1);
		panel = new JPanel();
		label = new JLabel("YERP");
		panel.add(button);
		panel.setBorder(BorderFactory.createEmptyBorder(100,150,100,150));
		panel.setLayout(new GridLayout(0,1));
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TEST");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}


}
