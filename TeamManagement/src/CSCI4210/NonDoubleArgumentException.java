package CSCI4210;


import java.awt.Component;
import java.lang.IllegalArgumentException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author JOSEPH ADOGERI
 *
 */

public class NonDoubleArgumentException extends IllegalArgumentException{
	
	
	public NonDoubleArgumentException(){
		JLabel lblNewLabel = new JLabel();
		JOptionPane.showMessageDialog(lblNewLabel,"The weight is not of type double");
	}
}
