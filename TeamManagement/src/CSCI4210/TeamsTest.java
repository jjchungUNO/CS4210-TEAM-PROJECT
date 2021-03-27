package CSCI4210;


import org.junit.Test;


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;

/**
 * @author JOSEPH ADOGERI
 *
 */
public class TeamsTest {
	
	Teams team ;
			
	TeamMembers member1;
	TeamMembers member2;
	TeamMembers member3;
	TeamMembers member4;
	TeamMembers member5;
	TeamMembers member6;	
	TeamMembers member7;
	TeamMembers member8;
				
	@Before
	public void Setup(){
		team = new Teams("Shark Tank");
		
		member1 = new TeamMembers("joseph","adogeri",0.1);
		member2 = new TeamMembers("kiki","kiki",0.2);
		member3 = new TeamMembers("jeremy","jeremy",0.3);
		member4 = new TeamMembers("joshua","joshua",0.4);
		member5 = new TeamMembers("jack","ryan",0.5);
		member6 = new TeamMembers("nick","fury",0.9);
		member7 = new TeamMembers("Michael","Jackson",0.5);
		member8 = new TeamMembers("Odell","Beckham",0.9);
		
		team.addMember(member1);
		team.addMember(member2);
		team.addMember(member3);
		team.addMember(member4);
		team.addMember(member5);
		team.addMember(member6);
		
	}
 
	
	@Test 
	public void getTeamNameTest() {	
		
		assertNotNull(team);		
		assertEquals("Shark Tank",team.getName());		
		assertNotEquals("shark Tank",team.getName());
		
		Teams newTeam  = team;
		assertSame(newTeam,team);								
	}
	
	@Test 
	public void getTeamSizeTest() {
				
		assertNotNull(team.getTeamSize());	
		
		assertEquals(6,team.getTeamSize());	
		
		team.getTeamList().remove(5);
		assertNotEquals(6,team.getTeamSize());		
		assertEquals(5,team.getTeamSize());
				
	}	
	
	@Test 
	public void getMemberTest() {
		
		assertSame(member1,team.getMember(0));
		assertNotSame(member1,team.getMember(1));
		assertNotNull(team.getMember(3));
				
	}	
	@Test 	
	public void getTeamListTest() {
		
		assertNotNull(team.getTeamList());
		
		ArrayList<TeamMembers> newTeam = null;
		newTeam = team.getTeamList();
		
		assertNotNull(newTeam);
		assertSame(newTeam,team.getTeamList());
		
	}	
	
	@Test 
	public void addMemberTest() {
		Teams newTeam = new Teams("CSCI4210");
		
		assertEquals(0,newTeam.getTeamSize());
		assertNotEquals(2,newTeam.getTeamSize());
		
		newTeam.addMember(member1);
		newTeam.addMember(member2);		
		
		assertEquals(2,newTeam.getTeamSize());			
		
		}	
}
