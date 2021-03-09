package CSCI4210;

public class TeamMembers {

	public String firstName;
	public String lastName;
	public double weight;

	public TeamMembers(String firstName,String lastName,double weight) {
		//while(isWeight(weight) == true) {
		isWeight(weight);
		isName(firstName);
		isName(lastName);

		this.firstName = firstName;
		this.lastName = lastName;
		this.weight=weight;
	}

	/**
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the first name to set
	 */
	public void setFirstName(String name) {
		this.firstName = name;
	}
	/**
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the last name to set
	 */
	public void setName(String name) {
		this.lastName = name;
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

	public double checkDouble(double weight) {
		if( weight > 1 || weight <= 0 ) {
			throw new OutOfRangeException();
		}

		return weight;
	}


	public boolean isWeight(double weight) {
		//checking if the value is of type double
		boolean isValid;
		//using wrapper class to check if type is a double
		Double d = Double.valueOf(weight);

		if(d instanceof Double) {
			isValid = true;
		}else {
			isValid = false;
			throw new NonDoubleArgumentException();
		}

		// return the outcome
		return isValid;

	}

	public boolean isName(String name) throws Exception {
		//returns true if both first and last name are letters only
		boolean isValidName = true;

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
			return isValidName;		
	}
}
