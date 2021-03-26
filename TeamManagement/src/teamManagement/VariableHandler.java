package teamManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;

import exceptions.OutOfRangeException;

public class VariableHandler {


	public VariableHandler() {}
	
	public boolean isNumbersOnly(String text) {
		boolean isValidNumber = false;
			try {
				if(!(text.matches("[0-9]+"))){
					throw new NumberFormatException("Error!! only numbers, Try again");
				}					
				else {
					
				}
				int number = Integer.parseInt(text);
					
				if(number < 0) {
					isValidNumber = false;
					
					throw new IllegalArgumentException("Error!! number cannot be less than zero, Try again");
				}else
					isValidNumber = true;
			}catch(NumberFormatException e) {
				System.out.println(e.toString());		
			}catch(InputMismatchException e) {
				System.out.println(e.toString());
			}catch(IllegalArgumentException e) {
				System.out.println(e.toString());
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			
		return isValidNumber;		
	}
	public boolean isValidOption(String text,int totalTeams) {
		boolean isValidNumber = false;
			try {
				if(!(text.matches("[0-9]+"))){
					throw new NumberFormatException("Error!! only numebrs, Try again");
				}					
				else {
					
				}
				int number = Integer.parseInt(text);
					
				if(number < 0 || number >=totalTeams) {
					
					ArrayList<Integer> options = new ArrayList<Integer>();
					for(int i = 0; i < totalTeams;i++) {
						options.add(i);
					}
					isValidNumber = false;
					
					throw new IllegalArgumentException("Error!! input must be in range " + options );
				}else
					isValidNumber = true;
			}catch(NumberFormatException e) {
				System.out.println(e.toString());		
			}catch(InputMismatchException e) {
				System.out.println(e.toString());
			}catch(IllegalArgumentException e) {
				System.out.println(e.toString());
			}catch(Exception e) {
				System.out.println(e.toString());
			}
			
		return isValidNumber;		
	}

	public boolean isLettersOnly(String text) {
		boolean isValidString = false;
			try {
		        if(text.matches("^[a-zA-Z]+$")){
		        	isValidString = true;

		        }else{
		            throw new InputMismatchException("Error !! please provide text with letters only");
		        	
		        }
		    }catch(InputMismatchException e){
		        System.out.println(e.toString());
		    }
			return isValidString;
						
	}
		
public boolean isWeight(String weight) {
		
		boolean isValid = false;
		try {
			
			Double d = Double.parseDouble(weight);	
			isValid = true;
										
		}catch(NumberFormatException e) {
			isValid = false;
			
			System.out.println(e.toString());			
		}catch(IllegalArgumentException e) {
			System.out.println(e.toString());
		}
		
		// return the outcome
		return isValid;
	}
/* this is suppose to be a check for when the user enters a number thats not a decmial.
 * Needs to throw an Expection, Should revisit!
 * public double checkDouble(double weight) { if(weight>1||weight<=0) {
 * 
 * } }
 */
public boolean checkDouble(double weight) {
	//assume the weight passed is in range [0, 1) 
	boolean inRange = false;
	try {
	// return false if weight is not between [0 , 1)
	if( weight < 1.0 && weight >= 0.0 ) {
		inRange = true;
	}else {
		
		throw new OutOfRangeException();
	}
	
	}catch(OutOfRangeException e) {
		System.out.println(e.toString());
	}catch(Exception e) {
		System.out.println(e.toString());
	}
	return inRange;
}
public boolean isWeight(Object weight) {
	
	//cast the input of the user		
	String value = String.valueOf(weight);
	
	boolean isValid = true;
	try {
		
		Double d = Double.valueOf(value);
		if(d < 0) {				
			isValid = false;
		}
						
	}catch(NumberFormatException e) {
		isValid = false;
		
		e.printStackTrace();
		
	}
	
	// return the outcome
	return isValid;

   }
	public boolean isPercentage( String percentage) {
		boolean isValidNumber = false;
		try {
			if(!(percentage.matches("[0-9]+"))){
				throw new NumberFormatException("Error!! only numbers, Try again");
			}					
			else {
				
			}
			double percent = Double.parseDouble(percentage);
				
			if( percent/100 < 0 || percent/100 > 1) {
				isValidNumber = false;
				
				throw new IllegalArgumentException("Error!! choose a number between 0 and 100 only");
			}else
				isValidNumber = true;
		}catch(NumberFormatException e) {
			System.out.println(e.toString());		
		}catch(InputMismatchException e) {
			System.out.println(e.toString());
		}catch(IllegalArgumentException e) {
			System.out.println(e.toString());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
	return isValidNumber;			
		
	}
	
}
