package com.alphagfx.testrail;

public interface Run extends JsonReadable, JsonPatchable {

	Project project();

	int id();

	void close();

	void delete();

	Iterable<Test> tests();
}
