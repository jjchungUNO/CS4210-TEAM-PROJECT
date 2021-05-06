package CSCI4210;

<<<<<<< HEAD
=======

>>>>>>> main
import java.util.*;

public class TeamManagementRunner {
	static double totalResource = 0.0;
	static double totalResourceConsumed = 0.0;
<<<<<<< HEAD
	ArrayList<Teams> team = new ArrayList<Teams>();
	ArrayList<Resources> teamResources = new ArrayList<Resources>();

	
	
	public static void printRedistributedResource(Resources r, Teams team) {
=======

	public static void main(String args[]) {
		/* 
		 * The gui stuff should prob come after making sure the bare bone program can work
		 *  GUI currentGUI = new GUI();
		 */

		Scanner input = new Scanner(System.in);
		VariableHandler handler = new VariableHandler();
		String rName;
		int totalTeams ;
		boolean isValidString = false;
		String rValue;

		do {
			System.out.println("Enter Resource name");
			isValidString = handler.isLettersOnly( rName = input.next());
		}while(isValidString == false);

		boolean validResource = false;
		do {

			System.out.println("Enter Total amount of Resource");
			validResource = handler.isNumbersOnly(rValue = input.next());
		}while(validResource == false);

		totalResource = Double.parseDouble(rValue);

		String stringNum;

		boolean isValidNumber = false;
		do {
			System.out.println("Enter number of Teams");
			isValidNumber = handler.isNumbersOnly(stringNum = input.next());
		}
		while(isValidNumber == false);

		ArrayList <Teams> team = new ArrayList<Teams>();
		ArrayList <Resources> teamResources = new ArrayList<Resources>();

		totalTeams = Integer.valueOf(stringNum);

		for (int index = 0; index < totalTeams ;index++) {
			int count = index;
			System.out.println("Please enter Team name of team " + (count + 1) + "");

			Teams firstTeam = new Teams(input.next());			
			boolean validNumberOfMembers = false;
			int numofMembers = 0 ;
			String strMembers = null;

			do {
				try {
					System.out.println("Enter number of Members in team " + firstTeam.getName());		 
					validNumberOfMembers = handler.isNumbersOnly(strMembers= input.next());

				}catch(Exception e) {
					e.printStackTrace();
				}
			}while(validNumberOfMembers == false);

			numofMembers = Integer.parseInt(strMembers);
			for(int i=0;i<numofMembers;i++) { 

				String firstName, lastName;
				double weight = 0.0;
				boolean isWeight = false;
				boolean isName = false;
				do {
					System.out.println("Enter first name of Member");
					isName = handler.isLettersOnly(firstName = input.next());
				}while(isName == false);

				isName = false;
				do {
					System.out.println("Enter last name Member");
					isName = handler.isLettersOnly(lastName = input.next());
				}while(isName == false);

				String memberWeight = null;			

				do {		
					try {
						System.out.println("Enter the weight of the member");
						isWeight = handler.isWeight(memberWeight = input.next());	
					}catch(OutOfRangeException e) {
						System.out.println(e.toString());
					}catch(Exception e) {
						System.out.println(e.toString());
					}

				}while(isWeight == false);				

				boolean isValidDouble = false;
				weight = Double.parseDouble(memberWeight);

				do {
					isValidDouble = handler.checkDouble(weight);
					while(isValidDouble == false) {
						System.out.println("Please provide adequate weight for team member");
						isValidDouble = handler.checkDouble(weight = Double.parseDouble(input.next()));							
					}

				}while(isValidDouble ==false);
				firstTeam.addMember(new TeamMembers(firstName,lastName,weight));
			}

			team.add(firstTeam);
			double amount = 0.0;
			String teamAmount = "";
			System.out.println("Enter Resource amount allocated to team");			

			boolean validTeamResource = false;
			do {

				validTeamResource = handler.isNumbersOnly( teamAmount = input.next());
				amount = Double.parseDouble(teamAmount);

				if(amount > totalResource && validTeamResource == true) {

					System.out.println("Error!! team resources cannot be greater than total resources");

					amount = updateTeamAmount(amount,totalResource,handler);
					updateTotalResourcesConsumed(amount);
				}
			}while(validTeamResource == false);

			totalResourceConsumed += amount;

			Resources newR = new Resources(rName,amount);
			teamResources.add(newR);

		}
		for(int j = 0; j < totalTeams; j++) {

			printAllocation(teamResources.get(j),team.get(j));
		}
		System.out.println("total resource consumed = " + totalResourceConsumed);
		System.out.println("total resource = " + totalResource);
		totalResource = totalResource - totalResourceConsumed;
		System.out.printf("Total resource unallocated is %.2f available\n",totalResource);

		int decision = 0;

		while(decision != 3) {
			System.out.println("What would you like to do with the remaining resource");
			System.out.println("(1) Distribute unallocated available resource by percentage to a team");
			System.out.println("(2) Distribute unallocated team resource to its members");
			System.out.println("(3) Exit Balanced Team Resource Allocation program");

			try {
				String text = input.next();
				decision = Integer.parseInt(text);

				if(decision == 1) {
					double percentVal = 0.0;
					String stringResourcePercentage;
					boolean isResourceValue = false;
					System.out.printf("What percentage of %.2f do you want to allocate ", totalResource);
					do {
						System.out.println("Enter Value");

						isResourceValue = handler.isPercentage(stringResourcePercentage = input.next());								
						System.out.println(stringResourcePercentage);
					}while(isResourceValue == false);
					percentVal = Double.parseDouble(stringResourcePercentage);
					percentVal = percentVal /100;

					double teamIncrease = totalResource * percentVal;				
					updateTotalResourcesConsumed(teamIncrease);
					totalResource = totalResource - teamIncrease;

					System.out.printf("which team do you want to allocate %.2f of resources ?\n",teamIncrease);
					System.out.println("Team Resource Allocation Status");

					boolean validTeamOption = false;
					int teamOption = 0;
					String stringTeamOption = "";
					ArrayList<String> optionList = new ArrayList<String>();
					for(int i = 0; i < totalTeams;i++) {
						String s = String.valueOf(i);
						optionList.add(s);

						System.out.printf("PRESS (%d) : Team %s has %.2f remaining \n",i,team.get(i).getName(),teamResources.get(i).getRemainingResource());				
					}

					do {
						System.out.println("Enter Option");
						validTeamOption = handler.isValidOption(stringTeamOption = input.next(),totalTeams);
					}
					while(validTeamOption == false);

					teamOption = Integer.parseInt(stringTeamOption);	
					System.out.printf("Team %s Resource Status\n", team.get(teamOption).getName());
					System.out.printf("Team %s Remaining Total Resource before update = %.2f\n",team.get(teamOption).getName(), teamResources.get(teamOption).getNumericalVal());
					teamResources.get(teamOption).increaseNumericalVal(teamIncrease);					
					System.out.printf("Team %s Remaining Total Resource after update = %.2f\n",team.get(teamOption).getName(), teamResources.get(teamOption).getNumericalVal());

				}else if(decision == 2){

					for(int index = 0; index < teamResources.size(); index++) {

						if(teamResources.get(index).getRemainingResource() > 0) {

							printRedistributedResource(teamResources.get(index),team.get(index));

						}else {

							System.out.printf("team %s remaining team resource is : 0\n",team.get(index).getName());
						}	
					}
				}else if(decision == 3) {

					System.out.println("Exit program");
					decision = 3;
					break;
				}
				else {
					System.out.println("Error!! Wrong input, please provide adequate input");
				}	

			}catch(NumberFormatException e) {
				System.out.println("please provide adequate input " + e.toString());
			}
		}
		//close resources
		input.close();
	}
	public static void printRedistributedResource(Resources r,Teams team) {		
>>>>>>> main

		double totalTeamResources = r.getNumericalVal() + r.getUsedResource();
		r.resetUsedResource();
		double totalAlloc = 0.0;
<<<<<<< HEAD
		System.out.printf("TEAM %s RESOURCE ALLOCATION STATUS", team.getName());
		System.out.println();
		for (int i = 0; i < team.getTeamSize(); i++) {

			double allocation = team.getMember(i).getWeight() * totalTeamResources;
			// update resources used
			r.setResourceUsed(allocation);
			totalAlloc += team.getMember(i).getWeight();
			System.out.println("Member: " + team.getMember(i).getFullName() + " has the weight of: "
					+ team.getMember(i).getWeight() + " The Allocation for Resource " + r.getName() + " is: "
					+ allocation);
		}
		if (totalAlloc != 1.0) {

			double remaining = r.getNumericalVal() - r.getUsedResource();
			r.updateRemainingResource(remaining);
			System.out.printf("Team %s still has %.2f remaining resource\n", team.getName(), r.getRemainingResource());
			System.out.printf("Team %s used %.2f resource\n", team.getName(), r.getUsedResource());
=======
		System.out.printf("TEAM %s RESOURCE ALLOCATION STATUS",team.getName());
		System.out.println();
		for(int i = 0; i < team.getTeamSize(); i++) {

			double allocation = team.getMember(i).getWeight() * totalTeamResources;
			//update resources used
			r.setResourceUsed(allocation);
			totalAlloc += team.getMember(i).getWeight();
			System.out.println("Member: "+ team.getMember(i).getFullName() + " has the weight of: " +team.getMember(i).getWeight() + " The Allocation for Resource " + r.getName() +" is: " +allocation );
		}
		if(totalAlloc != 1.0) {			

			double remaining = r.getNumericalVal() - r.getUsedResource();
			r.updateRemainingResource(remaining);
			System.out.printf("Team %s still has %.2f remaining resource\n",team.getName(),r.getRemainingResource());
			System.out.printf("Team %s used %.2f resource\n",team.getName(),r.getUsedResource());
>>>>>>> main
			System.out.println();
		}
	}

<<<<<<< HEAD
	public static void printAllocation(Resources r, Teams team) {

		double totalAlloc = 0.0;
		System.out.printf("TEAM %s RESOURCE ALLOCATION STATUS", team.getName());
		System.out.println();
		for (int i = 0; i < team.getTeamSize(); i++) {
			double allocation = team.getMember(i).getWeight() * r.getNumericalVal();
			// update resources used
			r.setResourceUsed(allocation);
			totalAlloc += team.getMember(i).getWeight();
			System.out.println("Member: " + team.getMember(i).getFullName() + " has the weight of: "
					+ team.getMember(i).getWeight() + " The Allocation for Resource " + r.getName() + " is: "
					+ allocation);
		}
		if (totalAlloc != 1.0) {
			double remaning = (1 - totalAlloc) * r.getNumericalVal();
			r.updateRemainingResource(remaning);
			System.out.printf("There is still %.2f remaning\n", remaning);
		}
	}

	public static double updateTeamAmount(double amount, double total, VariableHandler handler) {
		Scanner in = new Scanner(System.in);
		String stringAmount = "";
		while (amount > total) {
=======
	public static void printAllocation(Resources r,Teams team) {

		double totalAlloc = 0.0;
		System.out.printf("TEAM %s RESOURCE ALLOCATION STATUS",team.getName());
		System.out.println();
		for(int i = 0; i < team.getTeamSize(); i++) {
			double allocation = team.getMember(i).getWeight() * r.getNumericalVal();
			//update resources used
			r.setResourceUsed(allocation);
			totalAlloc += team.getMember(i).getWeight();
			System.out.println("Member: "+ team.getMember(i).getFullName() + " has the weight of: " +team.getMember(i).getWeight() + " The Allocation for Resource " + r.getName() +" is: " +allocation );
		}
		if(totalAlloc != 1.0) {
			double remaning = (1-totalAlloc)*r.getNumericalVal();
			r.updateRemainingResource(remaning);
			System.out.printf("There is still %.2f remaning\n",remaning );			
		}
	}
	public static double updateTeamAmount(double amount, double total,VariableHandler handler) {
		Scanner in = new Scanner(System.in);
		String stringAmount = "";
		while(amount > total) {
>>>>>>> main
			boolean isUpdatedAmount = false;
			System.out.println("please provide adequate value for team resource");
			do {
				isUpdatedAmount = handler.isNumbersOnly(stringAmount = in.next());

<<<<<<< HEAD
			} while (isUpdatedAmount == false);
=======
			}while(isUpdatedAmount == false);
>>>>>>> main

			amount = Double.parseDouble(stringAmount);
		}
		in.close();
		return amount;
	}
<<<<<<< HEAD

	public static void updateTotalResourcesConsumed(double resource) {
		totalResourceConsumed += resource;
	}
=======
	public static void updateTotalResourcesConsumed(double resource) {		
		totalResourceConsumed += resource;
	}	
>>>>>>> main
}