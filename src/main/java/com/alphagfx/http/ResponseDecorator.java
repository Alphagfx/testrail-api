package com.alphagfx.http;

import java.util.List;
import java.util.Map;

public abstract class ResponseDecorator<T, V> implements Response<T> {

	protected final Response<V> response;


	public ResponseDecorator(Response<V> strResponse) {
		this.response = strResponse;
	}


	@Override
	public int status() {
		return response.status();
	}

	@Override
	public String reason() {
		return response.reason();
	}

	@Override
	public Map<String, List<String>> headers() {
		return response.headers();
	}
}
