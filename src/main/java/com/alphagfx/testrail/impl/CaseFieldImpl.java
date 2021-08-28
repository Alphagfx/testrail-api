package com.alphagfx.testrail.impl;

import com.alphagfx.testrail.CaseField;
import com.alphagfx.testrail.CaseFields;
import org.json.JSONObject;

import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

public class CaseFieldImpl implements CaseField {

	private final int id;
	private final CaseFields caseFields;


	public CaseFieldImpl(int id, CaseFields caseFields) {
		this.id = id;
		this.caseFields = caseFields;
	}


	@Override
	public int id() {
		return id;
	}

	@Override
	public JSONObject json() {
		return StreamSupport.stream(caseFields.list().spliterator(), true)
			.filter(cf -> cf.id() == id())
			.findFirst()
			.orElseThrow(() -> new NoSuchElementException("No such case field with id '" + id() + "'"))
			.json();
	}
}
