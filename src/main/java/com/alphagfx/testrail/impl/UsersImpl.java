package com.alphagfx.testrail.impl;

import com.alphagfx.http.json.RsJsonArray;
import com.alphagfx.http.Request;
import com.alphagfx.http.json.RsJsonObjectStream;
import com.alphagfx.testrail.TestRail;
import com.alphagfx.testrail.User;
import com.alphagfx.testrail.Users;

import java.io.IOException;
import java.util.stream.Collectors;

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
		try {
			return new RsJsonObjectStream(new RsJsonArray(base.url("index.php?/api/v2/get_users").execute())).body()
				.map(o -> new UserImpl(testrail, base, o.getInt("id")))
				.collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException(e); // TODO: 3/26/21 Fix exception type and message in 'list users'
		}
	}
}
