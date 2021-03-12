package com.alphagfx.http;

import com.alphagfx.http.body.EmptyBody;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpUrlRequest implements Request<byte[]> {

	private final URI uri;
	private final String method;
	private final Map<String, String> headers;
	private final Body body;


	public HttpUrlRequest(String url) {
		this(url, "GET", Collections.emptyMap(), new EmptyBody());
	}

	public HttpUrlRequest(String url, String method, Map<String, String> headers, Body body) {
		this(URI.create(url), method, headers, body);
	}

	public HttpUrlRequest(URI uri, String method, Map<String, String> headers, Body body) {
		this.uri = uri;
		this.method = method;
		this.headers = headers;
		this.body = body;
	}


	@Override
	public Request<byte[]> url(String url) {
		return new HttpUrlRequest(uri.resolve(url), this.method, this.headers, this.body);
	}

	@Override
	public Request<byte[]> method(String method) {
		return new HttpUrlRequest(this.uri, method, this.headers, this.body);
	}

	@Override
	public Request<byte[]> header(String header, String value) {
		Map<String, String> newHeaders = new LinkedHashMap<>(this.headers);
		newHeaders.merge(header, value, (s1, s2) -> s2);
		return new HttpUrlRequest(this.uri, this.method, newHeaders, this.body);
	}

	@Override
	public Request<byte[]> body(Body body) {
		return new HttpUrlRequest(this.uri, this.method, this.headers, body);
	}

	@Override
	public Response<byte[]> execute() throws IOException {
		URL url = this.uri.toURL();
		URLConnection connection = url.openConnection();
		HttpURLConnection conn = (HttpURLConnection) connection;
		try {
			conn.setConnectTimeout(60_1000);
			conn.setRequestMethod(method);
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(false);
			for (final Map.Entry<String, String> header : headers.entrySet()) {
				conn.addRequestProperty(header.getKey(), header.getValue());
			}
			conn.connect();
			if (method.equals("POST") || method.equals("PUT") || method.equals("PATCH")) {
				conn.setDoOutput(true);
				try (OutputStream os = conn.getOutputStream();
					 WritableByteChannel output = Channels.newChannel(os)) {

					body.writeTo(output);
				}
			}
			return new SimpleResponse(
				conn.getResponseCode(),
				conn.getResponseMessage(),
				conn.getHeaderFields(),
				body(conn)
			);
		} catch (final IOException exp) {
			throw new IOException(String.format("Failed %s request to %s", method, url), exp);
		} finally {
			conn.disconnect();
		}
	}

	private byte[] body(final HttpURLConnection conn) throws IOException {
		final InputStream input;
		if (conn.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
			input = conn.getErrorStream();
		} else {
			input = conn.getInputStream();
		}
		final byte[] body;
		if (input == null) {
			body = new byte[0];
		} else {
			try (input) {
				byte[] buffer = new byte[8192];
				var output = new ByteArrayOutputStream();
				for (int bytes = input.read(buffer); bytes != -1; bytes = input.read(buffer)) {
					output.write(buffer, 0, bytes);
				}
				body = output.toByteArray();
			}
		}
		return body;
	}
}
