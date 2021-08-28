package com.alphagfx.testrail.impl;

import com.alphagfx.http.Request;
import com.alphagfx.http.Response;
import com.alphagfx.http.transform.RqTransform;
import com.alphagfx.http.transform.util.json.AsJsonArray;
import com.alphagfx.http.transform.util.json.AsJsonObject;
import com.alphagfx.http.transform.util.json.AsJsonObjectStream;
import com.alphagfx.testrail.CaseField;
import com.alphagfx.testrail.CaseFields;
import org.json.JSONObject;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaseFieldsImpl implements CaseFields {

	private final Request<String> base;


	public CaseFieldsImpl(Request<String> base) {
		this.base = base;
	}


	@Override
	public CaseField add(JSONObject json) {
		Request<JSONObject> request = new RqTransform<>(
			base.url("index.php?/api/v2/add_case_field").method("POST"),
			new AsJsonObject()
		);
		Response<JSONObject> response = request.execute();
		return new CaseFieldImpl(response.body().getInt("id"), this);
	}

	@Override
	public Iterable<CaseField> list() {
		Request<Stream<JSONObject>> request = new RqTransform<>(
			base.url("index.php?/api/v2/get_case_fields"),
			new AsJsonArray().andThen(new AsJsonObjectStream())
		);
		Response<Stream<JSONObject>> response = request.execute();
		return response.body()
			.map(o -> new CaseFieldImpl(o.getInt("id"), this))
			.collect(Collectors.toList());
	}
}
