package com.alphagfx.http.transform;

import com.alphagfx.http.Request;
import com.alphagfx.http.RequestFailedException;
import com.alphagfx.http.Response;

import java.util.function.Function;

public class RqTransform<V, T> implements Request<T> {

	private final Request<V> base;
	private final Function<V, T> transform;


	public RqTransform(Request<V> base, Function<V, T> transform) {
		this.base = base;
		this.transform = transform;
	}


	@Override
	public Request<T> url(String url) {
		return new RqTransform<>(base.url(url), transform);
	}

	@Override
	public Request<T> method(String method) {
		return new RqTransform<>(base.method(method), transform);
	}

	@Override
	public Request<T> header(String header, String value) {
		return new RqTransform<>(base.header(header, value), transform);
	}

	@Override
	public Request<T> body(Body body) {
		return new RqTransform<>(base.body(body), transform);
	}

	@Override
	public Response<T> execute() {
		return new RsTransform<>(base.execute(), transform);
	}
}

