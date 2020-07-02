package com.alphagfx.testrail;

import java.io.IOException;

import org.json.JSONObject;

interface JsonPatchable {
    void patch(JSONObject json) throws IOException;
}