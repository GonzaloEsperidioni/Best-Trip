package com.despegar.jav.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.despegar.jav.domain.Trip;
import com.despegar.jav.service.TripGenerator;

@Controller
@RequestMapping("/despegar-it-jav")
public class TripController {
	
	private TripGenerator tripGenerator;
	
	public TripController(TripGenerator unTripGenerator){
		this.tripGenerator = unTripGenerator;
	}
	
	
	@RequestMapping(value = "/best-trip", method = RequestMethod.GET)
	@ResponseBody
	public Object getTrip(
			@RequestParam(value = "money", required = true) Double wallet,
			@RequestParam(value = "from", required = true) String from) {
		return this.tripGenerator.generateTrip(wallet, from);
	}

}