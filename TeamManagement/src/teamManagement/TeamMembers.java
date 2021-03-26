package teamManagement;

import java.io.*;

import exceptions.NonDoubleArgumentException;
import exceptions.OutOfRangeException;

public class TeamMembers extends VariableHandler{

	public String firstName;
	public String lastName;
	public double weight;
	public static double totalTeamWeight;

	public TeamMembers(String firstName,String lastName,double weight) {
		super();
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
