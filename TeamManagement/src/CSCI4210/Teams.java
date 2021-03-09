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
	
	
	
	
}
