package com.alphagfx.testrail;

public interface Case extends JsonReadable, JsonPatchable {

	Section section();


	int id();

	String title();

	Template template();

	void moveTo(Section parent);

	void delete();
}
