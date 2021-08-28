package com.alphagfx.testrail.impl;


import com.alphagfx.http.Request;
import com.alphagfx.http.Response;
import com.alphagfx.http.transform.RqTransform;
import com.alphagfx.http.transform.util.json.AsJsonObject;
import com.alphagfx.testrail.TestRail;
import com.alphagfx.testrail.User;
import org.json.JSONObject;

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
		Request<JSONObject> request = new RqTransform<>(
			base.url("index.php?/api/v2/get_user/" + id),
			new AsJsonObject()
		);
		Response<JSONObject> response = request.execute();
		return response.body();
	}
}
