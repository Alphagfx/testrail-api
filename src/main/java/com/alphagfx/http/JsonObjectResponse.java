package com.alphagfx.http;

import org.json.JSONObject;

public class JsonObjectResponse extends ResponseDecorator<JSONObject> {

	private final Response<String> strResponse;


	public JsonObjectResponse(Response<String> strResponse) {
		super(strResponse);
		this.strResponse = strResponse;
	}


	@Override
	public JSONObject body() {
		return new JSONObject(strResponse.body());
	}
}
