package CSCI4210;


import java.lang.IllegalArgumentException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * @author JOSEPH ADOGERI
 *
 */
public class OutOfRangeException extends IllegalArgumentException {
	
	
	public OutOfRangeException() {
		//default message
		
		JLabel lblNewLabel = new JLabel();
		JOptionPane.showMessageDialog(lblNewLabel, "value of double must be between 1 and 0");
	}

}
