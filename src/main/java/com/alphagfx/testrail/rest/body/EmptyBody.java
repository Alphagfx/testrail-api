package com.alphagfx.testrail.rest.body;

import com.alphagfx.testrail.rest.Request;

import java.nio.channels.WritableByteChannel;

public class EmptyBody implements Request.Body {

	@Override
	public void writeTo(WritableByteChannel output) {
		//empty body, nothing to write here
	}
}
