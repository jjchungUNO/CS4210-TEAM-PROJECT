package CSCI4210;
import java.util.*;
public class TeamManagement {
	static int totalResource = 0;

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
			for(int i=0;i<numofMembers;i++) { // this entire for loop can be made into a method but for now im leaving it as is

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

				
				String d = null;
				/**
				 * 				weight = Double.parseDouble(d);
isWeight = handler.checkDouble(weight);
			}catch(Exception e) {
				e.printStackTrace();
			}*/
				
				do {		
					try {
				System.out.println("Enter the weight of the member");
				isWeight = handler.isWeight(d = input.next());	
					}catch(OutOfRangeException e) {
						System.out.println(e.toString());
					}catch(Exception e) {
						System.out.println(e.toString());
					}
					
				}while(isWeight == false);
				
				
				boolean isVal = false;
				weight = Double.parseDouble(d);

				do {
					isVal = handler.checkDouble(weight);
						while(isVal == false) {
							System.out.println("Please provide adequate weight for team member");
							isVal = handler.checkDouble(weight = input.nextDouble());							
						}
					
				}while(isVal ==false);
				firstTeam.addMember(new TeamMembers(firstName,lastName,weight));
			}

			team.add(firstTeam);
			System.out.println("Enter Resource amount allocated to team");
			double amount = input.nextDouble();
			Resources newR = new Resources(rName,amount);
			teamResources.add(newR);

		}
		for(int j = 0; j < totalTeams; j++) {

			printAllocation(teamResources.get(j),team.get(j));
		}

		//close resources
		input.close();

	}

	public static void printAllocation(Resources r,Teams team) {

		double totalAlloc = 0.0;
		System.out.printf("TEAM %s RESOURCE ALLOCATION STATUS",team.getName());
		System.out.println();
		for(int i = 0; i < team.getTeamSize(); i++) {
			double allocation = team.getMember(i).getWeight() * r.getNumericalVal();
			totalAlloc += team.getMember(i).getWeight();
			System.out.println("Member: "+ team.getMember(i).getFullName() + " has the weight of: " +team.getMember(i).getWeight() + " The Allocation for Resource " + r.getName() +" is: " +allocation );
		}
		if(totalAlloc != 1.0) {
			double remaning = (1-totalAlloc)*r.getNumericalVal();
			System.out.printf("There is still %.2f remaning",remaning );
			System.out.println();
		}
	}

}
