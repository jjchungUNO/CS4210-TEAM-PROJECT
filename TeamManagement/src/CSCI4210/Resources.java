package CSCI4210;


public class Resources {
	public String name;
	public double resourceUsed;
	public double remainingResource;
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
	public void decreaseRemainingResource(double decrementValue) {
		remainingResource = remainingResource - decrementValue;
	}
	/**
	 * @return teamSize divide remaining resource by team size
	 */
	public void updateRemainingResource(double resourceValue) {
		remainingResource = resourceValue;
		//setResourceUsed(remainingResource);
	}public void increaseRemainingResource(double resource) {
		remainingResource += resource;
	}

	public double getRemainingResource() {
		return remainingResource;
	}

	public void setResourceUsed(double resourceAlloc) {

		resourceUsed = resourceUsed + resourceAlloc;

	}
	public double getUsedResource() {

		return resourceUsed;
	}
	public void resetUsedResource() {

		resourceUsed = 0;

	}
}