package com.alphagfx.testrail.impl;

import java.io.IOException;

import com.alphagfx.testrail.TestRail;
import com.alphagfx.testrail.User;
import com.alphagfx.testrail.Users;

public class UsersImpl implements Users {

	private final TestRail testrail;


	public UsersImpl(TestRail tr) {
		this.testrail = tr;
	}


	@Override
	public User get(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> list() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
}
