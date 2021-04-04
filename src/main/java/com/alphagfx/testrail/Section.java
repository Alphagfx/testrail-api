package com.alphagfx.testrail;

public interface Section extends JsonReadable, JsonPatchable {

	Suite suite();


	int id();

	void moveTo(Section parent);

	void delete();

	Section createSection(String name);

	Case createCase(String title, int templateId);

	Cases cases();
}
