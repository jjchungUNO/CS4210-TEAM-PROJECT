package CSCI4210;

import java.util.*;
public class Teams {
	
	public String name;
	ArrayList<TeamMembers> members;
	
	public Teams(String name) {
		this.name = name;
		this.members = new ArrayList<>();	
		}
	/**
	 * @param newMember adding new member to the arrayList
	 */
	public void addMember(TeamMembers newMember) {
		members.add(newMember);
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
	public void removeMember(int index) {
		this.members.remove(index);
	}
	/**
	 * @return the ArrayList of team members
	 */
	public ArrayList<TeamMembers> getTeamList() {
		return members;
	}
	/**
	 * @param members the members to set
	 */
	public void setMembers(ArrayList<TeamMembers> members) {
		this.members = members;
	}
	/**
	 * @return team member in the list at specified index
	 */
	public TeamMembers getMember(int index) {
		
		TeamMembers member = null;
		//getting the team member at index		
		member = members.get(index);
		//return team member
		return member;
	}	
	/**
	 * @return the size of the team
	 */
	public int getTeamSize() {
		
		return members.size();		
		
	}		
	
	@Override
	public String toString() {
		return this.getName();
	}
}
