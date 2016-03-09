package com.despegar.jav.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.despegar.jav.domain.Trip;
import com.despegar.jav.service.TripGenerator;

@Controller
@RequestMapping("/despegar-it-jav")
public class TripController {
	
	private TripGenerator tripGenerator;
	
	public TripController(TripGenerator unTripGenerator){
		this.tripGenerator = unTripGenerator;
	}
	
	@RequestMapping(value = "/hellp", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "Hello World!";
	}
	@RequestMapping(value = "/best-trip", method = RequestMethod.POST)
	@ResponseBody
	public Trip getTrip(@RequestParam(value = "from", required = true) String from,
			@RequestParam(value = "money", required = true) Double wallet) {
			return this.tripGenerator.generateTrip(wallet, from);
	}
	
	@RequestMapping(value = "/best-trip", method = RequestMethod.GET)
	@ResponseBody
	public Trip getTripf(
			@RequestParam(value = "money", required = true) Double wallet,
			@RequestParam(value = "from", required = true) String from) {
		return this.tripGenerator.generateTrip(wallet, from);
	}

}