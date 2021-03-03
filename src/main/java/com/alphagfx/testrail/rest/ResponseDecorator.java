package com.alphagfx.testrail.rest;

import java.util.List;
import java.util.Map;

abstract class ResponseDecorator<T> implements Response<T> {

	private final Response<?> response;


	ResponseDecorator(Response<?> strResponse) {
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
