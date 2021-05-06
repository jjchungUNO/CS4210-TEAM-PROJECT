package CSCI4210;


<<<<<<< HEAD
import java.awt.Component;
import java.lang.IllegalArgumentException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

=======
import java.lang.IllegalArgumentException;

>>>>>>> main
/**
 * @author JOSEPH ADOGERI
 *
 */

public class NonDoubleArgumentException extends IllegalArgumentException{
	
<<<<<<< HEAD
	
	public NonDoubleArgumentException(){
		JLabel lblNewLabel = new JLabel();
		JOptionPane.showMessageDialog(lblNewLabel,"The weight is not of type double");
=======
	public NonDoubleArgumentException(String message){
		//pass in message
		super(message);
	}
	
	public NonDoubleArgumentException(){
		super("The weight is not of type double");
>>>>>>> main
	}
}
