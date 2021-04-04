package com.alphagfx.testrail.impl;

import com.alphagfx.testrail.Status;
import org.json.JSONObject;

public class StatusImpl implements Status {

	private final JSONObject json;


	public StatusImpl(JSONObject json) {
		this.json = json;
	}


	@Override
	public int id() {
		return json.getInt("id");
	}

	@Override
	public JSONObject json() {
		return json;
	}
}
