/**
 * 
 */
package exceptions;
import java.lang.IllegalArgumentException;
/**
 * @author JOSEPH ADOGERI
 *
 */
public class OutOfRangeException extends IllegalArgumentException {
	
	public OutOfRangeException(String message) {
		//pass in message
		super(message);
	}
	
	public OutOfRangeException() {
		//default message
		super("value of double must be between 1 and 0");
	}

}
