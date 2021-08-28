package com.alphagfx.testrail.impl;

import com.alphagfx.http.Request;
import com.alphagfx.http.Response;
import com.alphagfx.http.transform.RqTransform;
import com.alphagfx.http.transform.util.json.AsJsonArray;
import com.alphagfx.http.transform.util.json.AsJsonObjectStream;
import com.alphagfx.testrail.TestRail;
import com.alphagfx.testrail.User;
import com.alphagfx.testrail.Users;
import org.json.JSONObject;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UsersImpl implements Users {

	private final TestRail testrail;
	private final Request<String> base;


	public UsersImpl(TestRail testrail, Request<String> base) {
		this.testrail = testrail;
		this.base = base;
	}


	@Override
	public User get(int id) {
		return new UserImpl(testrail, base, id);
	}

	@Override
	public Iterable<User> list() {
		Request<Stream<JSONObject>> request = new RqTransform<>(
			base.url("index.php?/api/v2/get_users"),
			new AsJsonArray().andThen(new AsJsonObjectStream())
		);
		Response<Stream<JSONObject>> response = request.execute();
		return response.body()
			.map(o -> new UserImpl(testrail, base, o.getInt("id")))
			.collect(Collectors.toList());
	}
}
