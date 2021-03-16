package com.alphagfx.testrail.impl;

import java.io.IOException;

import com.alphagfx.http.Request;
import com.alphagfx.testrail.TestRail;
import com.alphagfx.testrail.User;
import com.alphagfx.testrail.Users;

public class UsersImpl implements Users {

	private final TestRail testrail;
	private final Request<String> base;


	public UsersImpl(TestRail testrail, Request<String> base) {
		this.testrail = testrail;
		this.base = base;
	}


	@Override
	public User get(int id) throws IOException {
		return new UserImpl(testrail, base, id);
	}

	@Override
	public Iterable<User> list() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
