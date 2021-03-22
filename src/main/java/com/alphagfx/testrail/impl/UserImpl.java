package com.alphagfx.testrail.impl;

import com.alphagfx.http.JsonObjectResponse;
import com.alphagfx.http.Request;
import com.alphagfx.testrail.TestRail;
import com.alphagfx.testrail.User;
import org.json.JSONObject;

import java.io.IOException;

public class UserImpl implements User {

	private final TestRail testrail;
	private final Request<String> base;

	private final int id;


	public UserImpl(TestRail testrail, Request<String> base, int id) {
		this.testrail = testrail;
		this.base = base;
		this.id = id;
	}


	@Override
	public TestRail testrail() {
		return testrail;
	}

	@Override
	public int id() {
		return id;
	}

	@Override
	public JSONObject json() {
		try {
			return new JsonObjectResponse(base.url("index.php?/api/v2/get_user/" + id).execute()).body();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
