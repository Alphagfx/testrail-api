package com.alphagfx.testrail.rest;

import java.util.List;
import java.util.Map;

public class SimpleResponse implements Response<byte[]> {

	private final int status;
	private final String reason;
	private final Map<String, List<String>> headers;
	private final byte[] body;


	public SimpleResponse(int status, String reason, Map<String, List<String>> headers, byte[] body) {
		this.status = status;
		this.reason = reason;
		this.headers = headers;
		this.body = body;
	}


	@Override
	public int status() {
		return status;
	}

	@Override
	public String reason() {
		return reason;
	}

	@Override
	public Map<String, List<String>> headers() {
		return Map.copyOf(headers);
	}

	@Override
	public byte[] body() {
		return body.clone();
	}
}
