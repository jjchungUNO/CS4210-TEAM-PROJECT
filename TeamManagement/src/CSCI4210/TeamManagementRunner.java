package CSCI4210;

import java.util.*;

public class TeamManagementRunner {
	static double totalResource = 0.0;
	static double totalResourceConsumed = 0.0;
	ArrayList<Teams> team = new ArrayList<Teams>();
	ArrayList<Resources> teamResources = new ArrayList<Resources>();

	
	
	public static void printRedistributedResource(Resources r, Teams team) {

		double totalTeamResources = r.getNumericalVal() + r.getUsedResource();
		r.resetUsedResource();
		double totalAlloc = 0.0;
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
			System.out.println();
		}
	}

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
			boolean isUpdatedAmount = false;
			System.out.println("please provide adequate value for team resource");
			do {
				isUpdatedAmount = handler.isNumbersOnly(stringAmount = in.next());

			} while (isUpdatedAmount == false);

			amount = Double.parseDouble(stringAmount);
		}
		in.close();
		return amount;
	}

	public static void updateTotalResourcesConsumed(double resource) {
		totalResourceConsumed += resource;
	}
}