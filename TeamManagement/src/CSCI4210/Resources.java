package CSCI4210;

class Resources {
	public String name;
	public double numericalVal; //NumericalVal in this case could refer to the number of resources.
	public Resources(String name,double numericalVal) {
		this.name=name;
		this.numericalVal = numericalVal;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the numericalVal
	 */
	public double getNumericalVal() {
		return numericalVal;
	}
	/**
	 * @param increaseValue increment the numerical value of resource
	 */
	public void increaseNumericalVal(double increaseValue) {
		numericalVal = numericalVal + increaseValue;
	}

	/**
	 * @param numericalVal the numericalVal to set
	 */
	public void decreaseNumericalVal(double decrementValue) {
		numericalVal = numericalVal - decrementValue;
	}

}

