package com.alphagfx.http;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

public interface Request<T> {

	Request<T> url(String url);

	Request<T> method(String method);

	Request<T> header(String header, String value);

	Request<T> body(Body body);

	Response<T> execute() throws RequestFailedException;


	interface Body {

		void writeTo(WritableByteChannel output);
	}
}
