package com.alphagfx.testrail.rest;

import org.json.JSONObject;

public class JsonObjectResponse extends ResponseDecorator<JSONObject> {

	private final Response<String> strResponse;


	JsonObjectResponse(Response<String> strResponse) {
		super(strResponse);
		this.strResponse = strResponse;
	}


	@Override
	public JSONObject body() {
		return new JSONObject(strResponse.body());
	}
}
