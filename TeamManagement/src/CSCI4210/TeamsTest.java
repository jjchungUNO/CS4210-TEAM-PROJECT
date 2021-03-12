/**
 * 
 */
package CSCI4210;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

/**
 * @author JOSEPH ADOGERI
 *
 */
public class TeamsTest {
	
	TeamMembers member1;
	TeamMembers member2;
	TeamMembers member3;
	TeamMembers member4;
	TeamMembers member5;
	TeamMembers member6;
	TeamMembers member7;
	TeamMembers member8;
	
	String fname1 = "jacob";
	String fname2 = "joe";
	String fname3 = "jonathan3";
	String fname4 = "jeremy";
	String fname5 = "joshua";
	String fname6 = "john";
		
	String lname1 = "jorda";
	String lname2 = "joe";
	String lname3 = "jonathan3";
	String lname4 = "jeremy";
	String lname5 = "joshua";
	String lname6 = "john";
	
	@Before
	public void Setup(){
		member1 = new TeamMembers(fname1,lname1,0.1);
		member2 = new TeamMembers(fname2,lname2,0.2);
		member3 = new TeamMembers(fname3,lname3,0.3);
		member4 = new TeamMembers(fname4,lname4,0.4);
		member5 = new TeamMembers(fname5,lname5,0.5);
		member6 = new TeamMembers(fname6,lname6,0.9);		
		
	}
 
	@Test 
	public void isWeightTest() {
		
		double val1 = 2.0;
		assertTrue(member1.isWeight(val1));
		
		double val2 = -2.0;
		assertFalse(member2.isWeight(val2));
		
		Object val3 = "1";
		assertTrue(member4.isWeight(val3));
		
		Object val4 = "-1";
		assertFalse(member5.isWeight(val4));
		
		String val5 = "";
		assertFalse(member6.isWeight(val5));				
	}

	@Test 
	public void checkDoubleTest() {
		
		double val1 = 0.5;		
		assertTrue(member1.checkDouble(val1));
		
		double val2 = 0.0;
		assertTrue(member4.checkDouble(val2));
		
		double val3 = 1.0;		
		assertFalse(member6.checkDouble(val3));
		
		double val4 = -1.0;
		assertFalse(member2.checkDouble(val4));		
						
	}
	
	@Test 
	public void isNameTest() throws Exception {
		
		assertFalse(member3.isName(member3.firstName));
		
		assertFalse(member3.isName(member3.lastName));		
		
		String name1 = "joe";
		double val1 = 2.0;
		assertTrue(member1.isName(name1));
		
		String name2 = "jonny2bravo1";
		assertFalse(member1.isWeight(name2));
		
		String name3 = "";
		assertFalse(member1.isWeight(name3));			
	}
	
	@Test 
	public void getFirstNameTest() {
				
		assertEquals("jacob",member1.getFirstName());
		
		assertNotEquals("John",member6.getFirstName());
		
		member7 = member6;
		assertNotNull(member7);
		
		assertEquals("john",member7.getFirstName());								
	}
	
	@Test 
	public void getLastNameTest() {
		assertEquals("jeremy",member4.getLastName());
		
		assertNotEquals("John",member6.getLastName());			
		
		member8 = member6;
		assertNotNull(member8);
		
		assertEquals("john",member8.getLastName());
	}	
}
