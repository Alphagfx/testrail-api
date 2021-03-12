package com.alphagfx.testrail.impl;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.alphagfx.http.HttpUrlRequest;
import com.alphagfx.http.JsonArrayResponse;
import com.alphagfx.http.Request;
import com.alphagfx.http.RqStringUTF8;
import com.alphagfx.testrail.CaseFields;
import com.alphagfx.testrail.CaseType;
import com.alphagfx.testrail.Priority;
import com.alphagfx.testrail.Projects;
import com.alphagfx.testrail.Status;
import com.alphagfx.testrail.TestRail;
import com.alphagfx.testrail.Users;
import com.alphagfx.http.body.EmptyBody;
import org.json.JSONObject;

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
	public Iterable<CaseType> caseTypes() throws IOException {
		var response = new JsonArrayResponse(base.url("index.php?/api/v2/get_case_types").execute());
		return StreamSupport.stream(response.body().spliterator(), false)
			.map(o -> new CaseTypeImpl(((JSONObject) o)))
			.collect(Collectors.toList());
	}

	@Override
	public Iterable<Priority> priorities() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Projects projects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Status> statuses() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users users() {
		return new UsersImpl(this);
	}
}
