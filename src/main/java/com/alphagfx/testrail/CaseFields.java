package com.alphagfx.testrail;

import org.json.JSONObject;

public interface CaseFields {

	CaseField add(JSONObject json);

	Iterable<CaseField> list();
}
