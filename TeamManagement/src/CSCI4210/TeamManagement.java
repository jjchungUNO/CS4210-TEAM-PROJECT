package CSCI4210;
import java.util.*;
 public class TeamManagement {
	 static int iD = 0;
	 public static void main(String args[]) {
		/* 
		 * The gui stuff should prob come after making sure the bare bone program can work
		 *  GUI currentGUI = new GUI();
		 */
		 		 
		 
		 Scanner input = new Scanner(System.in);
		 System.out.println("Enter Resource name");
		 String rName = input.next();
		 
		 System.out.println("Enter number of Teams");
		 int totalTeams = input.nextInt();
		 ArrayList <Teams> team = new ArrayList<Teams>();
		 ArrayList <Resources> teamResources = new ArrayList<Resources>();
		 
		 
		 for (int index = 0; index < totalTeams ;index++) {
			 int count = index;
		 System.out.println("Please enter Team name of team " + (count + 1) + "");
		 
		 Teams firstTeam = new Teams(input.next());
		 System.out.println("Enter number of Members");
		 int numofMembers = input.nextInt();
		 
		 for(int i=0;i<numofMembers;i++) { // this entire for loop can be made into a method but for now im leaving it as is
			 System.out.println("Enter name of Member");
			 String firstName = input.next();
			 
			 System.out.println("Enter last name Member");
			 String lastName = input.next();
			 
			 System.out.println("Enter the weight of the member");
			 double weight = input.nextDouble();
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
		 }
	 }
	 
}
