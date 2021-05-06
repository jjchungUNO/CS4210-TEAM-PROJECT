package CSCI4210;


import java.lang.IllegalArgumentException;
<<<<<<< HEAD

import javax.swing.JLabel;
import javax.swing.JOptionPane;
=======
>>>>>>> main
/**
 * @author JOSEPH ADOGERI
 *
 */
public class OutOfRangeException extends IllegalArgumentException {
	
<<<<<<< HEAD
	
	public OutOfRangeException() {
		//default message
		
		JLabel lblNewLabel = new JLabel();
		JOptionPane.showMessageDialog(lblNewLabel, "value of double must be between 1 and 0");
=======
	public OutOfRangeException(String message) {
		//pass in message
		super(message);
	}
	
	public OutOfRangeException() {
		//default message
		super("value of double must be between 1 and 0");
>>>>>>> main
	}

}
