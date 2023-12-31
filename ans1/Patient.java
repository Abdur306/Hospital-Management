package disease.ans1;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Patient {
     private UUID patientid;
     private String firstName;
     private String lastName;
     private  Exposure[] exposures;
     private UUID[] diseaseIds;
     
     public Patient(int maxDiseases,int maxExposures) {
		if(maxDiseases<0 || maxExposures<0) {
			throw new IllegalArgumentException("maxDiseases or maxExposures  values cannot be used to initiate the array");
		}
		else {
			this.exposures=new Exposure[maxExposures];
			this.diseaseIds=new UUID[maxDiseases];
		}
	}
     public void addDiseaseId(UUID diseaseId) {
    	 boolean result=false;
    	 for(int i=0;i<diseaseIds.length;i++) {
    		 if(diseaseIds[i]==null) {
    			 diseaseIds[i]=diseaseId;
    			 result=true;
    			 break;
    		 }
    	 }
    	 if(!result) {
    		 throw new IndexOutOfBoundsException("DiseaseId array is full");
    	 }
     }
     
     public void addExposure(Exposure exp) {
    	 boolean result=false;
    	 for(int i=0;i<exposures.length;i++) {
    		 if(exposures[i]==null) {
    			 exposures[i]=exp;
    			 result=true;
    			 break;
    		 }	 
    	 }
    	 if(!result) {
    		 throw new IndexOutOfBoundsException("Exposure array is full");
    	 }
     }
     
     public void setpatientid(UUID patientid) {
    	 this.patientid=patientid;
     }
     public UUID getpatientid() {
    	 return patientid;
     }
     
     public void setfirstName(String firstName) {
    	 this.firstName=firstName;
     }
     public String getfirstName() {
    	 return firstName;
     }
     
     public void setLastName(String secondName) {
    	 this.lastName=secondName;
     }
     public String getLastName() {
    	 return lastName;
     }
     
     @Override
    public String toString() {
    
    	return  
    	         "Patient Id : "+patientid+
    	         " FirstName : "+firstName+
    	         " LastName : "+lastName+
    	         " Exposures : "+Arrays.toString(exposures)+
    	         " DiseaseId : "+Arrays.toString(diseaseIds);
    	         
    }
     
     @Override
     public int hashCode() {
         return Objects.hash(patientid);
     }
     
	public Exposure[] getExposures() {
		return exposures;
	}
	public void setExposures(Exposure[] exposures) {
		this.exposures = exposures;
	}
	public UUID[] getDiseaseIds() {
		return diseaseIds;
	}
	public void setDiseaseIds(UUID[] diseaseIds) {
		this.diseaseIds = diseaseIds;
	}
    
}
