package disease.ans1;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Exposure {
 
	private UUID patientid;
	private LocalDate datetime;
	private String exposureType;

	/** 
	 * Creating cons to pass UUID as parameter
	 * providing getters & setters method
	 * 
	 */
	
	public Exposure(UUID patientid) {
		// TODO Auto-generated constructor stub
		this.patientid=patientid;
	}
	
	public void setPatientid(UUID patientid) {
		this.patientid=patientid;
	}
	public UUID getPatientid() {
	return  patientid;
}
	public void setDatetime(LocalDate datetime) {
		this.datetime=datetime;
	}
	public LocalDate getDatetime() {
		return datetime;
	}
	public void setExposure(String exposureType) {
		this.exposureType=exposureType;
	}
	public String getexposureType() {
		return exposureType;
	}
	
	public void exposureType(String exposureType) {
		if("D".equals(exposureType)|| "I".equals(exposureType)) {
			this.exposureType=exposureType;
		}
		else
		throw new IllegalArgumentException("Exposure Type Should be Either Direct or Indirect Exposure");
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exposure other = (Exposure) obj;
		return Objects.equals(datetime, other.datetime) && Objects.equals(patientid, other.patientid);
	}
	@Override
	public int hashCode() {
		return Objects.hash(datetime, patientid);
	}
	
	@Override
	public String toString() {
		
		return  "Patient ID : "+patientid+
				" DateTime : "+datetime+
				" ExposureType "+exposureType;
				
	}
	
	
	
}
