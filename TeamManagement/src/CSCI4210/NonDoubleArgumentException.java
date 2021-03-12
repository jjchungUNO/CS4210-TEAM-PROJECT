/**
 * 
 */
package CSCI4210;
import java.lang.IllegalArgumentException;

/**
 * @author JOSEPH ADOGERI
 *
 */

public class NonDoubleArgumentException extends IllegalArgumentException{
	
	public NonDoubleArgumentException(String message){
		//pass in message
		super(message);
	}
	
	public NonDoubleArgumentException(){
		super("The weight is not of type double");
	}
}
