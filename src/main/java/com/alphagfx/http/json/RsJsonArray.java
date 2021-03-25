package com.alphagfx.http.json;

import com.alphagfx.http.Response;
import org.json.JSONArray;

import java.util.List;
import java.util.Map;

public class RsJsonArray implements Response<JSONArray> {

	private final Response<String> strResponse;


	public RsJsonArray(Response<String> strResponse) {
		this.strResponse = strResponse;
	}


	@Override
	public int status() {
		return strResponse.status();
	}

	@Override
	public String reason() {
		return strResponse.reason();
	}

	@Override
	public Map<String, List<String>> headers() {
		return strResponse.headers();
	}

	@Override
	public JSONArray body() {
		return new JSONArray(strResponse.body());
	}
}
