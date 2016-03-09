package com.despegar.jav.domain;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonIgnoreProperties(ignoreUnknown = true)
public class FlightJson {
	

	private String to;
    @JsonProperty("items")
    private List<Item> items = new ArrayList<Item>();
   
    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }
    
    public String getAirline() {
    	if(items.isEmpty())
    	{return "";}
    	return items.get(0).getAirline(); 
    	}
    public Double getTotal() {
    	if(items.isEmpty())
    	{ return (double) 0;
    	
    	}
    	
    	return items.get(0).getPriceDetail().getTotal();
    }
    public String getTo() {
    	return to;
    }
    public void setTo(String to) {
    	this.to= to;
    }

    public FlightJson(){}
	public FlightJson(String to, List<Item> items) {
		super();
		this.to = to;
		this.items = items;
	}

	
    

}