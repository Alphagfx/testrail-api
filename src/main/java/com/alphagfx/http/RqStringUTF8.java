package com.alphagfx.http;

import java.io.IOException;

public class RqStringUTF8 implements Request<String>{

	private final Request<byte[]> request;


	public RqStringUTF8(Request<byte[]> request) {
		this.request = request;
	}


	@Override
	public Request<String> url(String url) {
		return new RqStringUTF8(request.url(url));
	}

	@Override
	public Request<String> method(String method) {
		return new RqStringUTF8(request.method(method));
	}

	@Override
	public Request<String> header(String header, String value) {
		return new RqStringUTF8(request.header(header, value));
	}

	@Override
	public Request<String> body(Body body) {
		return new RqStringUTF8(request.body(body));
	}

	@Override
	public Response<String> execute() throws IOException {
		return new RsStringUTF8(request.execute());
	}
}
