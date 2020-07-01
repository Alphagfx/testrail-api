package com.alphagfx.testrail;

import org.json.JSONObject;

interface JsonPatchable {
    void update(JSONObject json);
}