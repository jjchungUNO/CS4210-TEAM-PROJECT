/**
 * 
 */
package tests;
import teamManagement.TeamMembers;
import teamManagement.VariableHandler;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author JOSEPH ADOGERI
 *
 */
public class VariableHandlerTests {	
	
	VariableHandler handler;	

	@Before
	public void Setup(){
		
		handler = new VariableHandler();		
	}

	@Test 
	public void isWeightTest() {
		
		double val1 = 2.0;
		assertTrue(handler.isWeight(val1));
		
		double val2 = -2.0;
		assertFalse(handler.isWeight(val2));
		
		Object val3 = "1";
		assertTrue(handler.isWeight(val3));
		
		Object val4 = "-1";
		assertFalse(handler.isWeight(val4));
		
		String val5 = "";
		assertFalse(handler.isWeight(val5));				
	}

	@Test 
	public void checkDoubleTest() {
		
		double val1 = 0.5;		
		assertTrue(handler.checkDouble(val1));
		
		double val2 = 0.0;
		assertTrue(handler.checkDouble(val2));
		
		double val3 = 1.0;		
		assertFalse(handler.checkDouble(val3));
		
		double val4 = -1.0;
		assertFalse(handler.checkDouble(val4));		
						
	}
	
	@Test 
	public void isLettersOnlyTest() {
		
		String val1 = "ComputerScience";		
		assertTrue(handler.isLettersOnly(val1));
		
		String val2 = "";
		assertFalse(handler.isLettersOnly(val2));
					
		String val4 = "C0mputer";
		assertFalse(handler.isLettersOnly(val4));		
						
	}
	@Test 
	public void isNumbersOnlyTest() {
		
		String val1 = "12";		
		assertEquals(true,handler.isNumbersOnly(val1));
		
		String val2 = "";
		assertEquals(false,handler.isNumbersOnly(val2));	
		
		String val3 = "0l234S6789";		
		assertFalse(handler.isNumbersOnly(val3));
		
		String val4 = "-1";		
		assertFalse(handler.isNumbersOnly(val4));
										
	}	
	@Test 
	public void isPercentageTest() {
		
		String val1 = "0.1";		
		assertEquals(false,handler.isPercentage(val1));
		assertNotEquals(true,handler.isPercentage(val1));		
		
		String val2 = "a";
		assertEquals(false,handler.isPercentage(val2));	
		
		String val3 = "999";		
		assertFalse(handler.isPercentage(val3));
		
		String val4 = "-1";		
		assertFalse(handler.isPercentage(val4));
		
		String val5 = "0";		
		assertTrue(handler.isPercentage(val5));
		
		String val6 = "100";		
		assertTrue(handler.isPercentage(val6));
										
	}	
	@Test 
	public void isValidOptionTest() {
		
		String val1 = "1";	
		int number1 = 5;
		assertTrue(handler.isValidOption(val1, number1));
		
		String val2 = "";
		int number2 = 2;
		assertEquals(false,handler.isValidOption(val2,number2));	
		
		String val3 = "1.5";	
		int number3 = 3;
		assertFalse(handler.isValidOption(val3,number3));
		
		String val4 = "-1";	
		int number4 = 4;
		assertFalse(handler.isValidOption(val4,number4));
		
		String val5 = null;	
		int number5 = 5;
		assertFalse(handler.isValidOption(val5,number5));										
	}	

}