package com.alphagfx.testrail.impl;

import com.alphagfx.testrail.CaseField;
import org.json.JSONObject;

public class CaseFieldImpl implements CaseField {

	private final JSONObject json;


	public CaseFieldImpl(JSONObject json) {
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
