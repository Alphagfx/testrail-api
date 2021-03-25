package com.alphagfx.http.json;

import com.alphagfx.http.Response;
import com.alphagfx.http.ResponseDecorator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class RsJsonObjectStream extends ResponseDecorator<Stream<JSONObject>, JSONArray> {

	public RsJsonObjectStream(Response<JSONArray> response) {
		super(response);
	}


	@Override
	public Stream<JSONObject> body() {
		return StreamSupport.stream(response.body().spliterator(), false)
			.map(o -> ((JSONObject) o));
	}
}
