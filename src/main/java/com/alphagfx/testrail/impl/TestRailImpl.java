package com.alphagfx.testrail.impl;

import com.alphagfx.http.HttpUrlRequest;
import com.alphagfx.http.json.RsJsonArray;
import com.alphagfx.http.Request;
import com.alphagfx.http.RqStringUTF8;
import com.alphagfx.http.body.EmptyBody;
import com.alphagfx.testrail.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestRailImpl implements TestRail {

	private final Request<String> base;


	public TestRailImpl(String url) {
		this.base = new RqStringUTF8(new HttpUrlRequest(url, "GET", Map.of(), new EmptyBody()));
	}


	@Override
	public CaseFields caseFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CaseType> caseTypes() {
		try {
			var response = new RsJsonArray(base.url("index.php?/api/v2/get_case_types").execute());
			List<CaseType> result = StreamSupport.stream(response.body().spliterator(), false)
				.map(o -> new CaseTypeImpl((JSONObject) o))
				.collect(Collectors.toList());
			return result;
		} catch (IOException e) {
			throw new RuntimeException("Failed to get case types for " + this, e);
		}
	}

	@Override
	public Iterable<Priority> priorities() {
		try {
			var response = new RsJsonArray(base.url("index.php?/api/v2/get_priorities").execute());
			List<Priority> result = StreamSupport.stream(response.body().spliterator(), false)
				.map(o -> new PriorityImpl((JSONObject) o))
				.collect(Collectors.toList());
			return result;
		} catch (IOException e) {
			throw new RuntimeException("Failed to get priorities for " + this, e);
		}
	}

	@Override
	public Projects projects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Status> statuses() {
		try {
			var response = new RsJsonArray(base.url("index.php?/api/v2/get_statuses").execute());
			List<Status> result = StreamSupport.stream(response.body().spliterator(), false)
				.map(o -> new StatusImpl((JSONObject) o))
				.collect(Collectors.toList());
			return result;
		} catch (IOException e) {
			throw new RuntimeException("Failed to get statuses for " + this, e);
		}
	}

	@Override
	public Users users() {
		return new UsersImpl(this, base);
	}
}
