package com.alphagfx.http.transform;

import com.alphagfx.http.Response;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class RsTransform<T, V> implements Response<T> {

	private final Response<V> response;
	private final Function<V, T> transform;


	public RsTransform(Response<V> response, Function<V, T> transform) {
		this.response = response;
		this.transform = transform;
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

	@Override
	public T body() {
		try {
			V body = response.body();
			T result = transform.apply(body);
			return result;
		} catch (Exception e) {
			throw new TransformFailedException(e);
		}
	}
}
