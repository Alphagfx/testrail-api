package com.alphagfx.testrail;

import java.io.IOException;

import org.json.JSONObject;

public interface CaseFields {

    CaseField add(JSONObject json) throws IOException;

    Iterable<CaseField> list() throws IOException;
}
