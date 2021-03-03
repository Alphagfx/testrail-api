package com.alphagfx.testrail.rest;

import java.nio.charset.StandardCharsets;

public class RsStringUTF8 extends ResponseDecorator<String> {

	private final Response<byte[]> response;


	public RsStringUTF8(Response<byte[]> response) {
		super(response);
		this.response = response;
	}


	@Override
	public String body() {
		return new String(response.body(), StandardCharsets.UTF_8);
	}
}
