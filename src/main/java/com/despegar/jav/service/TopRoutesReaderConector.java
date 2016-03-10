package com.despegar.jav.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.despegar.jav.domain.TopRoute;
import com.despegar.jav.json.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;

public class TopRoutesReaderConector {

	public List<TopRoute> getTopRoutes() {
		JsonFactory jsonFactory = new JsonFactory();
		InputStream inputStream = TopRoutesReader.class.getResourceAsStream("top_routes.json");
		return jsonFactory.fromJson(new InputStreamReader(inputStream), new TypeReference<List<TopRoute>>() {
		});
	}
}
