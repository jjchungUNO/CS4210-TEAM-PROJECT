package teamManagement;

public class Printer {
	
	public Printer() {}
	
	public static void printRedistributedResource(Resources r,Teams team) {		

		double totalTeamResources = r.getNumericalVal() + r.getUsedResource();
		r.resetUsedResource();
		System.out.println("line 201 totalteam resources = "+ totalTeamResources);
		double totalAlloc = 0.0;
		System.out.printf("TEAM %s RESOURCE ALLOCATION STATUS",team.getName());
		System.out.println();
		for(int i = 0; i < team.getTeamSize(); i++) {

			double allocation = team.getMember(i).getWeight() * totalTeamResources;
			//update resources used
			System.out.println("line 209 allocation = "+ allocation);
			r.setResourceUsed(allocation);
			totalAlloc += team.getMember(i).getWeight();
			System.out.println("Member: "+ team.getMember(i).getFullName() + " has the weight of: " +team.getMember(i).getWeight() + " The Allocation for Resource " + r.getName() +" is: " +allocation );
		}
		if(totalAlloc != 1.0) {			
			double remaining = r.getNumericalVal() - r.getUsedResource();

			r.updateRemainingResource(remaining);
			System.out.printf("2) there is still %.2f remaining resource\n",r.getRemainingResource());
			System.out.printf(" Team %s used %.2f resource\n",team.getName(),r.getUsedResource());
		}
	}

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

}
