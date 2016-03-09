package com.despegar.jav.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({

		"airline", "price_detail" })
public class Item {

	@JsonProperty("airline")
	private String airline;

	@JsonProperty("price_detail")
	private PriceDetail priceDetail;

	@JsonProperty("airline")
	public String getAirline() {
		return airline;
	}

	@JsonProperty("airline")
	public void setAirline(String airline) {
		this.airline = airline;
	}

	@JsonProperty("price_detail")
	public PriceDetail getPriceDetail() {
		return priceDetail;
	}

	@JsonProperty("price_detail")
	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}

	public Item(String airline, PriceDetail priceDetail) {
		super();
		this.airline = airline;
		this.priceDetail = priceDetail;
	}
	
	public Item(){}

}