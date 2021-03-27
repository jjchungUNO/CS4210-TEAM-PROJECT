package CSCI4210;



import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author JOSEPH ADOGERI
 *
 */
public class ResourcesTest {

	Resources resource1;
	Resources resource2;
	Resources resource3;
	Resources resource4;
	Resources resource5;
	Resources resource6;
		
	String resourceName1 = "Hours";
	String resourceName2 = "Hours";
	String resourceName3 = "Hours";
	String resourceName4 = "Money";
	String resourceName5 = "Money";
	String resourceName6 = "";
		
	double resourceAmount1 = 1000.0;
	double resourceAmount2 = 1000.9;
	double resourceAmount3 = 2000.0;
	double resourceAmount4 = 2000.0;
	double resourceAmount5 = 1000.9;
	
		
	@Before
	public void Setup(){
		 resource1 = new Resources(resourceName1,resourceAmount1);
		 resource2 = new Resources(resourceName2,resourceAmount2);
		 resource3 = new Resources(resourceName3,resourceAmount3);
		 resource4 = new Resources(resourceName4,resourceAmount4);
		 resource5 = new Resources(resourceName5,resourceAmount5);
		
	}
 
	@Test 
	public void getNameTest() {
		
		assertEquals("Hours",resource1.getName());
		
		assertNotEquals(resource2.getName(),resource4.getName());
		
		assertNotNull(resource3);
		
		assertEquals("Money",resource4.getName());
		
		resource6 = resource4;
		
		assertSame(resource6,resource4);
		
		assertNotNull(resource6);
		assertTrue(resource6.getName() == resource5.getName());
		
	}

	@Test 
	public void getNumbericalValTest() {
		
		double zero = 0.0;		
		assertFalse(resource1.getNumericalVal() == zero);
		
		assertTrue(resource4.getNumericalVal() == resource3.getNumericalVal());
		
		double val1 = 1000.9;		
		assertTrue(val1 == resource5.getNumericalVal());
		
		Resources resource7 = resource5;
		assertEquals(1000.9,resource7.getNumericalVal(),0.001);
						
	}
	
	@Test 
	public void increaseNumericalValTest(){
		
		double val1 = 3000;
		double val2 = 1000.0;
		
		resource1.increaseNumericalVal(val1);
		
		assertFalse(resource1.getNumericalVal() == 1000.0);
		
		assertTrue(resource1.getNumericalVal() == 4000.0);
		
		resource3.increaseNumericalVal(val2);
		
		assertNotEquals(2000.0,resource3.getNumericalVal(),0.001);
		
		assertEquals(3000.0,resource3.getNumericalVal(),0.001);
		
					
	}	
	
	@Test 
	public void decreaseRemainingResourceTest() {
		
		double val1 = 500.0;
		double val2 = 1000.0;
		
		resource1.decreaseRemainingResource(val1);	
				
		assertFalse(resource1.getNumericalVal() == 500.0);
		
		assertTrue(resource1.getNumericalVal() == 1000.0);
		
		resource3.decreaseRemainingResource(val2);
		
		assertNotEquals(3000.0,resource3.getNumericalVal(),0.001);
		
		assertEquals(2000.0,resource3.getNumericalVal(),0.001);				
									
	}
	
	@Test 
	public void updateRemainingResourceTest() {
		
		double val1 = 500.0;
		double val2 = 1000.0;
		
		resource1.updateRemainingResource(val1);	
				
		assertFalse(resource1.getRemainingResource() == 1000.0);
		
		assertTrue(resource1.getRemainingResource() == 500.0);
		
		resource3.updateRemainingResource(val2);
		
		assertNotEquals(3000.0,resource3.getRemainingResource(),0.001);
		
		assertEquals(1000.0,resource3.getRemainingResource(),0.001);				
									
	}
	@Test 
	public void increaseRemainingResourceTest() {
		
		double val1 = 500.0;
		double val2 = 1000.0;
		
		resource1.increaseRemainingResource(val1);	
				
		assertFalse(resource1.getRemainingResource() == 1000.0);
		
		assertTrue(resource1.getRemainingResource() == 500.0);
		
		resource3.increaseRemainingResource(val2);
		
		assertNotEquals(3000.0,resource3.getRemainingResource(),0.001);
		
		assertEquals(1000.0,resource3.getRemainingResource(),0.001);				
									
	}
	@Test 
	public void getRemainingResourceTest() {
		
		double val1 = 500.0;
		double val2 = 1000.0;		
				
		assertFalse(resource1.getRemainingResource() == 1000.0);		
		
		resource3.increaseRemainingResource(val2);
		
		assertNotEquals(3000.0,resource3.getRemainingResource(),0.001);
		
		assertEquals(1000.0,resource3.getRemainingResource(),0.001);				
									
	}
	@Test 
	public void getUsedResourceTest() {
		
		double val1 = 500.0;
		double val2 = 1000.0;		
				
		assertFalse(resource1.getUsedResource() == 1000.0);		
		
		resource3.increaseRemainingResource(val2);
		
		assertNotEquals(3000.0,resource3.getUsedResource(),0.001);
		
		assertEquals(0.0,resource3.getUsedResource(),0.001);	
		
		resource2.setResourceUsed(val1);
		
		assertNotEquals(3000.0,resource3.getUsedResource(),0.001);
		
		assertEquals(0.0,resource3.getUsedResource(),0.001);			
									
	}
	
	@Test 
	public void resetUsedResourceTest() {
		
		double val1 = 50000.0;
		double val2 = 10000.0;		
				
		resource4.setResourceUsed(val2);
		resource5.setResourceUsed(val1);
		
		resource4.resetUsedResource();
		resource5.resetUsedResource();
				
		assertFalse(resource4.getUsedResource() == 10000.0);	
		assertTrue(resource4.getUsedResource() == 0.0);
		
		assertFalse(resource5.getUsedResource() == 50000.0);	
		assertTrue(resource5.getUsedResource() == 0.0);
		
											
	}
	
}
