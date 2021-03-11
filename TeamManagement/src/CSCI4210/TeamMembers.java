package CSCI4210;

import java.io.*;

public class TeamMembers {

	public String firstName;
	public String lastName;
	public double weight;
	public static double totalTeamWeight;

	public TeamMembers(String firstName,String lastName,double weight) {
		if(isWeight(weight)){
			
			if(checkDouble(weight)) {
				
				this.weight = weight;
				//add team member weight to the total 
			}else {
				throw new OutOfRangeException();
			}
			
		}else {			
			throw new NonDoubleArgumentException();
		}		
		try {
			isName(firstName);
			this.firstName = firstName;
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		try {
			isName(lastName);
			this.lastName = lastName;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}	
	/**
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}	
	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/* this is suppose to be a check for when the user enters a number thats not a decmial.
	 * Needs to throw an Expection, Should revisit!
	 * public double checkDouble(double weight) { if(weight>1||weight<=0) {
	 * 
	 * } }
	 */

	public boolean checkDouble(double weight) {
		//assume the weight passed is in range [0, 1) 
		boolean inRange;
		// return false if weight is not between [0 , 1)
		if( weight < 1.0 && weight >= 0.0 ) {
			inRange = true;
		}else {
			inRange = false;
			//throw new OutOfRangeException();
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
	
public String getFullName() {
		
		return getFirstName() + " " + getLastName();
	}



	public boolean isName(String name) throws Exception {
		//returns true if both first and last name are letters only
		boolean isValidName = true;
		
		try {
		//looping each character in name
			for (int i = 0; i <name.length(); i++) {
				if(Character.isLetter(name.charAt(i))) {
					//continue looping each character in the string	is a letter	
					
					continue;
				}else {
					//
					isValidName = false;
					throw new Exception();
				}
				
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
			return isValidName;		
	}
}
