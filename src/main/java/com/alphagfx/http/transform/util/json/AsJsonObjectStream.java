package com.alphagfx.http.transform.util.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AsJsonObjectStream implements Function<JSONArray, Stream<JSONObject>> {

	@Override
	public Stream<JSONObject> apply(JSONArray objects) {
		return StreamSupport.stream(objects.spliterator(), false)
			.map(o -> ((JSONObject) o));
	}
}
