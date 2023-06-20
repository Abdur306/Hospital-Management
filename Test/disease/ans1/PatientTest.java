package disease.ans1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class PatientTest {
	
	private Patient patient;
	
	private String First_Name="FIRSTNAME";
	private String  Second_Name="SECONDNAME";
	
	private Exposure exposure;
	
	@Before
	public void SetUp() {
		 UUID uuid=UUID.randomUUID();
		 exposure=new Exposure(uuid);
		 exposure.setDatetime(LocalDate.now());
		 exposure.setExposure("D");
		 patient = new Patient(1, 1);
		 patient.setfirstName(First_Name);
		 patient.setLastName(Second_Name);
		 patient.setpatientid(uuid);
		 patient.setExposures(new Exposure[] {exposure});
		 patient.setDiseaseIds(new UUID [] {UUID.randomUUID(),UUID.randomUUID()});
		 
	}
	
	  @Test
	  public void Positive() {
		  assertNotNull(patient.getDiseaseIds());
		  assertNotNull(patient.getfirstName());
          assertNotNull(patient.getLastName());
          assertNotNull(patient.getExposures());
          assertNotNull(patient.getpatientid());
          assertNotNull(patient.hashCode());
          assertNotNull(patient.toString());
	  }
	  
	  @Test (expected=IllegalArgumentException.class)
	  public void IllegalExcept() {
		  patient=new Patient(-2, 0);
		  
	  }
	  
	  @Test
	  public void TestAdddisease() {
		  Patient p=new Patient(2, 2);
		  p.addDiseaseId(UUID.randomUUID());
		  p.addDiseaseId(UUID.randomUUID());
		  assertEquals(2,p.getDiseaseIds().length);
	  }
	  
	  @Test
	  public void TestExposure() {
		  Patient p1=new Patient(2, 2);
		  p1.addExposure(exposure);
		  p1.addExposure(exposure);
		  assertEquals(2, p1.getExposures().length);
	  }
	  
	  @Test (expected=IndexOutOfBoundsException.class)
	  public void ExceptionAddDisease() {
		  patient.addDiseaseId(UUID.randomUUID());
	  }
	  

	  @Test (expected=IndexOutOfBoundsException.class)
	  public void ExceptionAddExposure() {
		  patient.addExposure(exposure);
	  }
	  
	  

}
