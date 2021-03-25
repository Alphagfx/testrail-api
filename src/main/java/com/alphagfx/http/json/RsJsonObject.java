package com.alphagfx.http.json;

import com.alphagfx.http.Response;
import com.alphagfx.http.ResponseDecorator;
import org.json.JSONObject;

public class RsJsonObject extends ResponseDecorator<JSONObject, String> {

	public RsJsonObject(Response<String> strResponse) {
		super(strResponse);
	}


	@Override
	public JSONObject body() {
		return new JSONObject(response.body());
	}
}
