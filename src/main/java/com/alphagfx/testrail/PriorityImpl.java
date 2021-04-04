package com.alphagfx.testrail;

import org.json.JSONObject;

public class PriorityImpl implements Priority {

	private final JSONObject json;


	public PriorityImpl(JSONObject json) {
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
