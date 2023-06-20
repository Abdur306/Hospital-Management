package disease.ans1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class ExposureTest {

	 private Exposure exposure;
	 
	 @Before
	 public void SetUp() {
		 exposure=new Exposure(UUID.randomUUID());
		 exposure.setPatientid(exposure.getPatientid());
		 exposure.setDatetime(LocalDate.now());
		 exposure.setExposure("D");
	 }
	 
	 @Test
	 public void TestCase() {
		 assertNotNull(exposure.toString());
		 assertNotNull(exposure.getDatetime());
		 assertNotNull(exposure.getPatientid());
		 assertNotNull(exposure.hashCode());
		 assertNotNull(exposure.getexposureType());
		 assertTrue("D".equals(exposure.getexposureType()));
		
		 Exposure obj1= exposure;
		 assertTrue(obj1.equals(exposure));
		 assertTrue(exposure.equals(exposure));
		 assertFalse(exposure.equals(null));
		 
		 Exposure obj2=new Exposure(exposure.getPatientid());
		 obj2.setExposure("I");
		 assertTrue("I".equals(obj2.getexposureType()));
		 obj2.setDatetime(exposure.getDatetime());
		 assertTrue(exposure.equals(obj2));
		 
			 
	 }
	 
	 @Test
	 public void checkDExposure() {
		 
		 exposure.exposureType("D");
		 assertEquals("D",exposure.getexposureType());
		 
	 }
	 
	 @Test
	 public void checkIExposure() {
		 
		 exposure.exposureType("I");
		 assertEquals("I",exposure.getexposureType());
		 
	 }
	  
	 
	 @Test (expected=IllegalArgumentException.class)
	 public void ExceptionTest() {
		 exposure.exposureType("Invalid");
	 }
	 
	
}
