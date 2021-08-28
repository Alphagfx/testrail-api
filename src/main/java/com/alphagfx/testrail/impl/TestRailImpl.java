package com.alphagfx.testrail.impl;

import com.alphagfx.http.HttpUrlRequest;
import com.alphagfx.http.Request;
import com.alphagfx.http.RequestFailedException;
import com.alphagfx.http.Response;
import com.alphagfx.http.transform.RqTransform;
import com.alphagfx.http.transform.util.AsStringUTF8;
import com.alphagfx.http.transform.util.json.AsJsonArray;
import com.alphagfx.http.transform.util.json.AsJsonObjectStream;
import com.alphagfx.testrail.*;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRailImpl implements TestRail {

	private final Request<String> base;
	private final Request<Stream<JSONObject>> baseJsonObjStream;


	public TestRailImpl(String url) {
		this.base = new RqTransform<>(new HttpUrlRequest(url), new AsStringUTF8());
		this.baseJsonObjStream = new RqTransform<>(this.base, new AsJsonArray().andThen(new AsJsonObjectStream()));
	}


	@Override
	public CaseFields caseFields() {
		return new CaseFieldsImpl(base);
	}

	@Override
	public Iterable<CaseType> caseTypes() {
		try {
			Request<Stream<JSONObject>> request = baseJsonObjStream.url("index.php?/api/v2/get_case_types");
			Response<Stream<JSONObject>> response = request.execute();
			List<CaseType> result = response.body()
				.map(CaseTypeImpl::new)
				.collect(Collectors.toList());
			return result;
		} catch (RequestFailedException e) {
			throw new RuntimeException("Failed to get case types for " + this, e);
		}
	}

	@Override
	public Iterable<Priority> priorities() {
		try {
			Request<Stream<JSONObject>> request = baseJsonObjStream.url("index.php?/api/v2/get_priorities");
			Response<Stream<JSONObject>> response = request.execute();
			List<Priority> result = response.body()
				.map(PriorityImpl::new)
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
			Request<Stream<JSONObject>> request = baseJsonObjStream.url("index.php?/api/v2/get_statuses");
			Response<Stream<JSONObject>> response = request.execute();
			List<Status> result = response.body()
				.map(StatusImpl::new)
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
