package com.alphagfx.testrail;

public interface Milestone extends JsonReadable, JsonPatchable {

	Project project();


	int id();
}
