package com.alphagfx.http.transform.util.json;

import org.json.JSONObject;

import java.util.function.Function;

public class AsJsonObject implements Function<String, JSONObject> {

	@Override
	public JSONObject apply(String s) {
		return new JSONObject(s);
	}
}
