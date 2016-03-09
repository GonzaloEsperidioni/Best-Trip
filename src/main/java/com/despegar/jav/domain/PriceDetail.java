package com.despegar.jav.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "currency", "adult_base", "total" })
public class PriceDetail {

	@JsonProperty("currency")
	private String currency;
	@JsonProperty("adult_base")
	private Double adultBase;
	@JsonProperty("total")
	private Double total;

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("adult_base")
	public Double getAdultBase() {
		return adultBase;
	}

	@JsonProperty("adult_base")
	public void setAdultBase(Double adultBase) {
		this.adultBase = adultBase;
	}

	@JsonProperty("total")
	public Double getTotal() {
		return total;
	}

	@JsonProperty("total")
	public void setTotal(Double total) {
		this.total = total;
	}

	public PriceDetail(String currency, Double adultBase, Double total) {
		super();
		this.currency = currency;
		this.adultBase = adultBase;
		this.total = total;
	}
	public PriceDetail(){}
	

}