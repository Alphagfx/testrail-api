package com.alphagfx.http;

import java.nio.charset.StandardCharsets;

public class RsStringUTF8 extends ResponseDecorator<String, byte[]> {

	public RsStringUTF8(Response<byte[]> response) {
		super(response);
	}


	@Override
	public String body() {
		return new String(response.body(), StandardCharsets.UTF_8);
	}
}
