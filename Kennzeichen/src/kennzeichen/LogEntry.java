package kennzeichen;

import java.sql.Timestamp;

public class LogEntry implements Comparable<Timestamp> {

	Timestamp timestamp = null;
	String licenseTag = "";

	public LogEntry(Timestamp timestamp, String licenseTag) {

	this.timestamp = timestamp;
	this.licenseTag = licenseTag;
	
	}
	
	public String getLicenseTag() {
		
		return this.licenseTag;
		
	}
	
	public String toString(){
		
		return timestamp.toString() + " : " + this.licenseTag; 
	}

	
	public int compareTo(Timestamp arg0) {
		
		return this.timestamp.compareTo(arg0);
	}

	

}
