package com.alphagfx.http.transform.util;

import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class AsStringUTF8 implements Function<byte[], String> {

	@Override
	public String apply(byte[] input) {
		return new String(input, StandardCharsets.UTF_8);
	}
}
