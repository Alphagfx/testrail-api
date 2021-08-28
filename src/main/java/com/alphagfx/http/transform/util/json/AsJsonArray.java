package com.alphagfx.http.transform.util.json;

import org.json.JSONArray;

import java.util.function.Function;

public class AsJsonArray implements Function<String, JSONArray> {

	@Override
	public JSONArray apply(String s) {
		return new JSONArray(s);
	}
}
