package com.alphagfx.http;

import java.util.List;
import java.util.Map;

public interface Response<T> {

	int status();

	String reason();

	Map<String, List<String>> headers();

	T body();
}
