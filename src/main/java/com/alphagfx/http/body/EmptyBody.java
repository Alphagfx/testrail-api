package com.alphagfx.http.body;

import com.alphagfx.http.Request;

import java.nio.channels.WritableByteChannel;

public class EmptyBody implements Request.Body {

	@Override
	public void writeTo(WritableByteChannel output) {
		//empty body, nothing to write here
	}
}
