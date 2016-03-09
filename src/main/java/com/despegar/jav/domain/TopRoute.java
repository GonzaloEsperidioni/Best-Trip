package com.despegar.jav.domain;

import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class TopRoute implements Serializable {
	private static HashMap<String, String> countryCityHash = new HashMap<String, String>();
	private String from;
	private String to;
	
	public TopRoute(){
		//OJO AL LEER ESTO, PELIGRO -> EPILEPTICOS ABSTENERSE.
		countryCityHash.put("BUE", "AR");
		countryCityHash.put("BRC", "AR"); 
		countryCityHash.put("IGR", "AR");
		countryCityHash.put("COR", "AR");
		countryCityHash.put("MDZ", "AR");
		countryCityHash.put("FTE", "AR");
		countryCityHash.put("USH", "AR");
		countryCityHash.put("EZE", "AR");
		countryCityHash.put("BSB", "BR");
		countryCityHash.put("CWB", "BR");
		countryCityHash.put("SAO", "BR");
		countryCityHash.put("SSA", "BR");
		countryCityHash.put("REC", "BR");
		countryCityHash.put("RIO", "BR");
		countryCityHash.put("FOR", "BR");
		countryCityHash.put("POA", "BR");
		countryCityHash.put("MCZ", "BR");
		countryCityHash.put("FLN", "BR");
		countryCityHash.put("NAT", "BR");
		countryCityHash.put("GRU", "BR");
		countryCityHash.put("BPS", "BR");
		countryCityHash.put("JPA", "BR");
		countryCityHash.put("AJU", "BR");
		countryCityHash.put("BHZ", "BR");
		countryCityHash.put("SCL", "CL");
		countryCityHash.put("IQQ", "CL");
		countryCityHash.put("MEX", "MX");
		countryCityHash.put("CUN", "MX");
		countryCityHash.put("LIM", "PE");
		countryCityHash.put("CUZ", "PE");
		countryCityHash.put("PIU", "PE");
		countryCityHash.put("MIA", "US");
		countryCityHash.put("ORL", "US");
		countryCityHash.put("NYC", "US");
		countryCityHash.put("MAD", "ES");
		countryCityHash.put("BCN", "ES");
		countryCityHash.put("ROM", "IT");
		countryCityHash.put("PUJ", "DO");
		countryCityHash.put("BOG", "CO");
		countryCityHash.put("CTG", "CO");
		countryCityHash.put("ADZ", "CO");
		countryCityHash.put("SMR", "CO");
		countryCityHash.put("MDE", "CO");
		countryCityHash.put("LIS", "PT");
		countryCityHash.put("PTY", "PA");
	}
	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}
	public String getCountry(){
		return countryCityHash.get(this.from);
	}
}
