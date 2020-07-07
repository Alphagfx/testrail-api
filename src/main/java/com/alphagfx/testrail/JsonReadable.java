package com.alphagfx.testrail;

import java.io.IOException;

import org.json.JSONObject;

public interface JsonReadable {

    JSONObject json() throws IOException;
}