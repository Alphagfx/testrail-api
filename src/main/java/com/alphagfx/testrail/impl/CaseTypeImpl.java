package com.alphagfx.testrail.impl;

import com.alphagfx.testrail.CaseType;
import org.json.JSONObject;

public class CaseTypeImpl implements CaseType {

	private final JSONObject json;


	public CaseTypeImpl(JSONObject json) {
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
