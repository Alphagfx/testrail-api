package com.alphagfx.testrail.impl;

import com.alphagfx.http.HttpUrlRequest;
import com.alphagfx.http.Request;
import com.alphagfx.http.RequestFailedException;
import com.alphagfx.http.Response;
import com.alphagfx.http.transform.RqTransform;
import com.alphagfx.http.transform.util.AsStringUTF8;
import com.alphagfx.http.transform.util.json.AsJsonArray;
import com.alphagfx.testrail.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestRailImpl implements TestRail {

	private final Request<String> base;
	private final Request<JSONArray> baseJsonArray;


	public TestRailImpl(String url) {
		this.base = new RqTransform<>(new HttpUrlRequest(url), new AsStringUTF8());
		this.baseJsonArray = new RqTransform<>(this.base, new AsJsonArray());
	}


	@Override
	public CaseFields caseFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<CaseType> caseTypes() {
		try {
			Request<JSONArray> request = baseJsonArray.url("index.php?/api/v2/get_case_types");
			Response<JSONArray> response = request.execute();
			List<CaseType> result = StreamSupport.stream(response.body().spliterator(), false)
				.map(o -> new CaseTypeImpl((JSONObject) o))
				.collect(Collectors.toList());
			return result;
		} catch (RequestFailedException e) {
			throw new RuntimeException("Failed to get case types for " + this, e);
		}
	}

	@Override
	public Iterable<Priority> priorities() {
		try {
			Request<JSONArray> req = baseJsonArray.url("index.php?/api/v2/get_priorities");
			Response<JSONArray> res = req.execute();
			List<Priority> result = StreamSupport.stream(res.body().spliterator(), false)
				.map(o -> new PriorityImpl((JSONObject) o))
				.collect(Collectors.toList());
			return result;
		} catch (RequestFailedException e) {
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
			Request<JSONArray> request = baseJsonArray.url("index.php?/api/v2/get_statuses");
			Response<JSONArray> response = request.execute();
			List<Status> result = StreamSupport.stream(response.body().spliterator(), false)
				.map(o -> new StatusImpl((JSONObject) o))
				.collect(Collectors.toList());
			return result;
		} catch (RequestFailedException e) {
			throw new RuntimeException("Failed to get statuses for " + this, e);
		}
	}

	@Override
	public Users users() {
		return new UsersImpl(this, base);
	}
}
